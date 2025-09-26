import java.util.*;
import java.math.*;
import java.io.*;
public class PROGRAM
{
    public static void main(String args[])
    throws IOException {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the style name/ number");
        String style = sc.nextLine();
        System.out.println("Enter 1 for merchat's consumption");
        System.out.println("Enter 2 for actual consumption");
        choice = sc.nextInt();
        int i;
        double sum_quan = 0, avg = 0, sum_val_quan = 0, avg_three = 0, elastic_box = 800, garmants_box_avg = 0, elastic_box_req = 0;
        double elastic_average;
        double elastic_values[] ={0.575, 0.651, 0.727, 0.803};
        double elastic_orderquan[] = new double[4];
        double elastic_values_orderquan[] = new double[4];
        Date current_Date = new Date();
        switch(choice)
        {
            case 1:

                System.out.println("Enter 1 for Main Label");
                System.out.println("Enter 2 for Thread");
                System.out.println("Enter 3 for Button");
                System.out.println("Enter 4 for Elastic");
                System.out.println("Enter 5 for HTI Label");
                choice = sc.nextInt();
                System.out.println("Enter the order quantity for Small size");
                elastic_orderquan[0] = sc.nextDouble();
                System.out.println("Enter the order quantity for Medium size");
                elastic_orderquan[1] = sc.nextDouble();
                System.out.println("Enter the order quantity for Large size");
                elastic_orderquan[2] = sc.nextDouble();
                System.out.println("Enter the order quantity for Extra large size");
                elastic_orderquan[3] = sc.nextDouble();
                switch(choice)
                {
                    case 1:
                        System.out.println("Per garment 1 label is required");
                        for(i = 0; i<=3; i++)
                        {
                            sum_quan = sum_quan + elastic_orderquan[i];
                        }
                        System.out.println("The total number of labels required for all the sizes in one colour are "+sum_quan);
                        System.out.println("The total number of labels required for all the sizes in 20 colours are "+sum_quan *20);

                        FileWriter fileWriterlabelmerchant = new FileWriter("data merchant label.txt", true);
                        PrintWriter printWriterlabelmerchant = new PrintWriter(fileWriterlabelmerchant);
                        printWriterlabelmerchant.println("For Style "+style);
                        printWriterlabelmerchant.println("Per garment 1 label is required");
                        printWriterlabelmerchant.println("The total number of labels required for all the sizes in one colour are "+sum_quan);
                        printWriterlabelmerchant.println("The total number of labels required for all the sizes in 20 colours are "+sum_quan *20);
                        printWriterlabelmerchant.println();
                        printWriterlabelmerchant.println();
                        printWriterlabelmerchant.close();
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Per garment 1 button is required");
                        for(i = 0; i<=3; i++)
                        {
                            sum_quan = sum_quan + elastic_orderquan[i];
                        }
                        System.out.println("The total number of buttons required for all the sizes in one colour are "+sum_quan);
                        System.out.println("The total number of buttons required for all the sizes in 20 colours are "+sum_quan *20);

                        FileWriter fileWriterButtonMerchant = new FileWriter("data merchant button.txt", true);
                        PrintWriter printWriterButtonMerchant = new PrintWriter(fileWriterButtonMerchant);
                        printWriterButtonMerchant.println("For Style "+style);
                        printWriterButtonMerchant.println("The total number of buttons required for all the sizes in one colour are "+sum_quan);
                        printWriterButtonMerchant.println("The total number of buttons required for all the sizes in 20 colours are "+sum_quan *20);
                        printWriterButtonMerchant.println();
                        printWriterButtonMerchant.println();
                        printWriterButtonMerchant.close();                        
                        break;
                    case 4:
                        //Calculating Average
                        for(i=0; i<=3; i++)
                        {
                            elastic_values_orderquan[i] = elastic_values[i] * elastic_orderquan[i];
                            sum_quan = sum_quan + elastic_orderquan[i];
                            sum_val_quan = sum_val_quan + elastic_values_orderquan[i];
                        }
                        avg = sum_val_quan/sum_quan;
                        avg = Math.round(avg*1000.0)/1000.0;
                        avg_three = avg+(avg * 3/100);
                        avg_three = Math.round(avg_three*1000.0)/1000.0;
                        System.out.println("For style "+style);
                        System.out.println("The average is "+avg+" meters");
                        System.out.println("The average with 3% wastage is "+avg_three+" meters");
                        garmants_box_avg = (int) elastic_box / avg_three;
                        garmants_box_avg = Math.round(garmants_box_avg*100.0)/100.0;
                        //System.out.println("We can approximately make "+garmants_box_avg+" gamerments per box of elastic");
                        sum_val_quan = Math.round(sum_val_quan*100.0)/100.0;
                        System.out.println();
                        System.out.println("For small size we can make "+Math.round((elastic_box/elastic_values[0])*100.0)/100.0+" garments per box of elastic");
                        System.out.println("For medium size we can make "+Math.round((elastic_box/elastic_values[1])*100.0)/100.0+" garments per box of elastic");
                        System.out.println("For large size we can make "+Math.round((elastic_box/elastic_values[2])*100.0)/100.0+" garments per box of elastic");
                        System.out.println("For extra large size we can make "+Math.round((elastic_box/elastic_values[3])*100.0)/100.0+" garments per box of elastic");
                        System.out.println();
                        System.out.println("The total amount of elastic required for the whole order for one colour is "+sum_val_quan+" meters");
                        elastic_box_req = sum_val_quan / elastic_box;
                        elastic_box_req = Math.round(elastic_box_req*100.0)/100.0;
                        System.out.println("The amount of elastic boxes required for the whole order for one colour is "+elastic_box_req+" meters");
                        System.out.println("The total amount of elastic required for the whole order in 20 colours is "+Math.round((sum_val_quan *20)*100.0)/100.0+" meters");
                        System.out.println("The amount of elastic boxes required for the whole order in 20 colours is "+Math.round((elastic_box_req *20)*100.0)/100.0+" meters");
                        FileWriter fileWriterelasticmerchant = new FileWriter("data merchant elastic.txt", true);
                        PrintWriter printWriterelasticmerchant = new PrintWriter(fileWriterelasticmerchant);
                        printWriterelasticmerchant.println("For Style "+style);
                        printWriterelasticmerchant.println("The average is "+avg+" meters");
                        printWriterelasticmerchant.println("The average with 3% wastage is "+avg_three+" meters");
                        printWriterelasticmerchant.println("For small size we can make "+Math.round((elastic_box/elastic_values[0])*100.0)/100.0+" garments per box of elastic");
                        printWriterelasticmerchant.println("For medium size we can make "+Math.round((elastic_box/elastic_values[1])*100.0)/100.0+" garments per box of elastic");
                        printWriterelasticmerchant.println("For large size we can make "+Math.round((elastic_box/elastic_values[2])*100.0)/100.0+" garments per box of elastic");
                        printWriterelasticmerchant.println("For extra large size we can make "+Math.round((elastic_box/elastic_values[3])*100.0)/100.0+" garments per box of elastic");
                        printWriterelasticmerchant.println("The total amount of elastic required for the whole order for one colour is "+sum_val_quan+" meters");
                        printWriterelasticmerchant.println("The amount of elastic boxes required for the whole order for one colour is "+elastic_box_req+" meters");
                        printWriterelasticmerchant.println("The total amount of elastic required for the whole order in 20 colours is "+Math.round((sum_val_quan *20)*100.0)/100.0+" meters");
                        printWriterelasticmerchant.println("The amount of elastic boxes required for the whole order in 20 colours is "+Math.round((elastic_box_req *20)*100.0)/100.0+" meters");
                        printWriterelasticmerchant.println();
                        printWriterelasticmerchant.println();
                        printWriterelasticmerchant.close();
                        printWriterelasticmerchant.flush();
                        break;
                    case 5:
                        System.out.println("Per garment 1 HTI label is required");
                        for(i = 0; i<=3; i++)
                        {
                            sum_quan = sum_quan + elastic_orderquan[i];
                        }
                        System.out.println("The total number of HTI labels required for all the sizes in one colour are "+sum_quan);
                        System.out.println("The total number of HTI labels required for all the sizes in 20 colours are "+sum_quan *20);

                        FileWriter fileWriterHtiMerchant = new FileWriter("data merchant HTI Label.txt", false);
                        PrintWriter printWriterHtiMerchant = new PrintWriter(fileWriterHtiMerchant);
                        printWriterHtiMerchant.println("For Style "+style);
                        printWriterHtiMerchant.println("The total number of buttons required for all the sizes in one colour are "+sum_quan);
                        printWriterHtiMerchant.println("The total number of buttons required for all the sizes in 20 colours are "+sum_quan *20);
                        printWriterHtiMerchant.println();
                        printWriterHtiMerchant.println();
                        printWriterHtiMerchant.close();
                        break;
                    default:
                        System.out.println("You have entered the wrong option");
                }
                break;
                //ACTUALL CONSUMPTION STARTS FROM HERE
            case 2:

                System.out.println("Enter 1 for Main Label");
                System.out.println("Enter 2 for Thread");
                System.out.println("Enter 3 for Button");
                System.out.println("Enter 4 for Elastic");
                System.out.println("Enter 5 for HTI Label");
                choice = sc.nextInt();
                System.out.println("Enter the order quantity for Small size");
                elastic_orderquan[0] = sc.nextDouble();
                System.out.println("Enter the order quantity for Medium size");
                elastic_orderquan[1] = sc.nextDouble();
                System.out.println("Enter the order quantity for Large size");
                elastic_orderquan[2] = sc.nextDouble();
                System.out.println("Enter the order quantity for Extra large size");
                elastic_orderquan[3] = sc.nextDouble();
                switch(choice)
                {
                    case 1:
                        System.out.println("Per garment 1 label is required");
                        for(i = 0; i<=3; i++)
                        {
                            sum_quan = sum_quan + elastic_orderquan[i];
                        }
                        System.out.println("The total number of labels required for all the sizes in one colour are "+sum_quan);
                        System.out.println("The total number of labels required for all the sizes in 20 colours are "+sum_quan *20);

                        FileWriter fileWriterlabelactual = new FileWriter("data actual label.txt", true);
                        PrintWriter printWriterlabelActual = new PrintWriter(fileWriterlabelactual);
                        printWriterlabelActual.println("For Style "+style);
                        printWriterlabelActual.println("Per garment 1 label is required");
                        printWriterlabelActual.println("The total number of labels required for all the sizes in one colour are "+sum_quan);
                        printWriterlabelActual.println("The total number of labels required for all the sizes in 20 colours are "+sum_quan *20);
                        printWriterlabelActual.println();
                        printWriterlabelActual.println();
                        printWriterlabelActual.close();
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Per garment 1 button is required");
                        for(i = 0; i<=3; i++)
                        {
                            sum_quan = sum_quan + elastic_orderquan[i];
                        }
                        System.out.println("The total number of buttons required for all the sizes in one colour are "+sum_quan);
                        System.out.println("The total number of buttons required for all the sizes in 20 colours are "+sum_quan *20);

                        FileWriter fileWriterButtonActual = new FileWriter("data actual button.txt", true);
                        PrintWriter printWriterButtonActual = new PrintWriter(fileWriterButtonActual);
                        printWriterButtonActual.println("For Style "+style);
                        printWriterButtonActual.println("The total number of buttons required for all the sizes in one colour are "+sum_quan);
                        printWriterButtonActual.println("The total number of buttons required for all the sizes in 20 colours are "+sum_quan *20);
                        printWriterButtonActual.println();
                        printWriterButtonActual.println();
                        printWriterButtonActual.close(); 
                        break;
                    case 4:
                        for(i=0; i<=3; i++)
                        {
                            elastic_values_orderquan[i] = elastic_values[i] * elastic_orderquan[i];
                            sum_quan = sum_quan + elastic_orderquan[i];
                            sum_val_quan = sum_val_quan + elastic_values_orderquan[i];
                        }
                        avg = sum_val_quan/sum_quan;
                        avg = Math.round(avg*1000.0)/1000.0;
                        avg_three = avg+(avg * 3/100);
                        avg_three = Math.round(avg_three*1000.0)/1000.0;
                        System.out.println("For style "+style);
                        System.out.println("The average is "+avg+" meters");
                        System.out.println("The average with 3% wastage is "+avg_three+" meters");
                        garmants_box_avg = (int) elastic_box / avg_three;
                        garmants_box_avg = Math.round(garmants_box_avg*100.0)/100.0;
                        //System.out.println("We can approximately make "+garmants_box_avg+" gamerments per box of elastic");
                        sum_val_quan = Math.round(sum_val_quan*100.0)/100.0;
                        System.out.println();
                        System.out.println("For small size we can make "+Math.round((elastic_box/elastic_values[0])*100.0)/100.0+" garments per box of elastic");
                        System.out.println("For medium size we can make "+Math.round((elastic_box/elastic_values[1])*100.0)/100.0+" garments per box of elastic");
                        System.out.println("For large size we can make "+Math.round((elastic_box/elastic_values[2])*100.0)/100.0+" garments per box of elastic");
                        System.out.println("For extra large size we can make "+Math.round((elastic_box/elastic_values[3])*100.0)/100.0+" garments per box of elastic");
                        System.out.println();
                        System.out.println("The total amount of elastic required for the whole order for one colour is "+sum_val_quan+" meters");
                        elastic_box_req = sum_val_quan / elastic_box;
                        elastic_box_req = Math.round(elastic_box_req*100.0)/100.0;
                        System.out.println("The amount of elastic boxes required for the whole order for one colour is "+elastic_box_req+" meters");
                        System.out.println("The total amount of elastic required for the whole order in 20 colours is "+Math.round((sum_val_quan *20)*100.0)/100.0+" meters");
                        System.out.println("The amount of elastic boxes required for the whole order in 20 colours is "+Math.round((elastic_box_req *20)*100.0)/100.0+" meters");
                        String data = "data.txt";
                        FileWriter fileWriter = new FileWriter("data actual elastic.txt", true);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.println("For Style "+style);
                        printWriter.println("The average is "+avg+" meters");
                        printWriter.println("The average with 3% wastage is "+avg_three+" meters");
                        printWriter.println("For small size we can make "+Math.round((elastic_box/elastic_values[0])*100.0)/100.0+" garments per box of elastic");
                        printWriter.println("For medium size we can make "+Math.round((elastic_box/elastic_values[1])*100.0)/100.0+" garments per box of elastic");
                        printWriter.println("For large size we can make "+Math.round((elastic_box/elastic_values[2])*100.0)/100.0+" garments per box of elastic");
                        printWriter.println("For extra large size we can make "+Math.round((elastic_box/elastic_values[3])*100.0)/100.0+" garments per box of elastic");
                        printWriter.println("The total amount of elastic required for the whole order for one colour is "+sum_val_quan+" meters");
                        printWriter.println("The amount of elastic boxes required for the whole order for one colour is "+elastic_box_req+" meters");
                        printWriter.println("The total amount of elastic required for the whole order in 20 colours is "+Math.round((sum_val_quan *20)*100.0)/100.0+" meters");
                        printWriter.println("The amount of elastic boxes required for the whole order in 20 colours is "+Math.round((elastic_box_req *20)*100.0)/100.0+" meters");
                        printWriter.println();
                        printWriter.println();
                        printWriter.close();
                        break;
                    case 5:
                        System.out.println("Per garment 1 HTI label is required");
                        for(i = 0; i<=3; i++)
                        {
                            sum_quan = sum_quan + elastic_orderquan[i];
                        }
                        System.out.println("The total number of HTI labels required for all the sizes in one colour are "+sum_quan);
                        System.out.println("The total number of HTI labels required for all the sizes in 20 colours are "+sum_quan *20);

                        FileWriter fileWriterHtiActual = new FileWriter("data actual HTI Label.txt", true);
                        PrintWriter printWriterHtiActual = new PrintWriter(fileWriterHtiActual);
                        printWriterHtiActual.println("For Style "+style);
                        printWriterHtiActual.println("The total number of buttons required for all the sizes in one colour are "+sum_quan);
                        printWriterHtiActual.println("The total number of buttons required for all the sizes in 20 colours are "+sum_quan *20);
                        printWriterHtiActual.println();
                        printWriterHtiActual.println();
                        printWriterHtiActual.close();
                        break;
                    default:
                        System.out.println("You have entered the wrong option");
                }

                break;
            default:
                System.out.println("Youve entered the wrong choice");
        }
    }
}