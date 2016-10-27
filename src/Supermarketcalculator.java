
/*Program to take in goods demanded in a shop and compute and display the price, amount
   demanded, also the
   balance remaining after payment
   */
import java.util.*;
public class Supermarketcalculator {

        public static void main(String[]args){
            Scanner shop = new Scanner(System.in);
            System.out.print("Enter the goods you are purchasing: ");
            String item = shop.nextLine();
            double price = 0 ;
            if(item.equals("shoe")){
                System.out.print("Which model: \n1. Nike\n2. All stars\n3. Supra\n4. Snikers\n Model name: ");
                String model = shop.nextLine();//To take in the particular model demanded in shoe
                if(model.equals("Nike")){
                    price = 2000;
                }else if(model.equals("All stars")){
                    price = 1800;
                }else if(model.equals("Supra")){
                    price = 3000;
                }else if(model.equals("Snikers")){
                    price = 2300;
                }
            }else if(item.equals("bag")){
                price = 3000;//You can copy and paste the above model declaration to be more specific
                //about bag
            }else if(item.equals("watch")){
                price = 1200;//You can copy and paste the above model declaration to be more specific
               // about watch
            }else if(item.equals("t-shirt")){
                price = 1000;//You can copy and paste the above model declaration to be more specific
               // about shirt
            }else if(item.equals("trouser")){
                price = 1800;//You can copy and paste the above model declaration to be more specific
               // about trouser
            }else if(item.equals("blowse")){
                price = 2500;//You can copy and paste the above model declaration to be more specific
               // about blowse
            }
            System.out.println("Price = #"+price);System.out.print("How many are you purchasing: ");
            int amount = shop.nextInt();
            double tot = price*amount;
            System.out.println("Total price= #"+tot+"\n");
            System.out.print("Enter the Amount paid= #");
            double amntpaid = shop.nextDouble();
            double balance = amntpaid - tot;
            System.out.println("Balance = #"+balance);
        }
    }

