/*
Commit-1
1. Display menu with following columns -- item-id, name, price.
     should have at-least 3 products
2. Accept item-id and amount from user
3. Based on item-id,
           return balance amount to user, if amount provided is more than item price
           print a simple msg saying ""dispensing <item name>""
4. keep track of amount in vending machine

Commit -2
1.  Vending machine should display menu after dispensing item and should accept next item-id and amount

Commit -3
1. Add option to view amount in vending machine based on user input
2. Refactor code  using methods and avoid code duplication


*/

import java.util.Scanner;

public class VendingMachine {

    int option;
    float userAmount;
    float userBalanceAmount;
    float amountInMachine = 0;
    float productPrice;
    String productName;
    Scanner sc;

        public static void main(String[] args) {
            VendingMachine machine = new VendingMachine();
            while(true){
                machine.initialItemsDisplay();
                machine.checkOnUserInput();
                machine.choiceOfItem();
            }
        }

        public void initialItemsDisplay(){
            System.out.println("HELLO!!! Look into the below options for the items and opt");
            System.out.println(" Item Name           Price \n 1. Cool Drink      Rs. 50.00 \n 2. Energy Bar      Rs. 35.50 \n 3. Masks           Rs. 80.25 \n 4. Coffee          Rs. 20.00 \n 5. Chips           Rs. 40.00 \n 6. Check Amount in Machine");
            System.out.println("Choose the item");
            sc = new Scanner(System.in);
            option = sc.nextInt();
        }

        public void checkOnUserInput(){

            if(option <1 || option >6){
                System.out.println("Choose the right option");
            }
            else if(option == 6){
                System.out.println("The amount in the machine " + amountInMachine);
            }

        }

        public void choiceOfItem(){
            if(option ==1){
                productPrice = 50.00F;
                productName = "Cold Drink";
                System.out.println("Load amount " + productPrice + " for " + productName);
                userAmount = sc.nextFloat();
                itemPurchase(productPrice,userAmount,productName);
            }
            else if(option == 2){
                productPrice = 35.50F;
                productName = "Energy Bar";
                System.out.println("Load amount " + productPrice + " for " + productName);
                userAmount = sc.nextFloat();
                itemPurchase(productPrice,userAmount,productName);
            }
            else if(option == 3){
                productPrice = 80.25F;
                productName = "Masks";
                System.out.println("Load amount " + productPrice + " for " + productName);
                userAmount = sc.nextFloat();
                itemPurchase(productPrice,userAmount,productName);
            }
            else if(option == 4){
                productPrice = 20.00F;
                productName = "Coffee";
                System.out.println("Load amount " + productPrice + " for " + productName);
                userAmount = sc.nextFloat();
                itemPurchase(productPrice,userAmount,productName);
            }
            else if(option == 5){
                productPrice = 40.00F;
                productName = "Chips";
                System.out.println("Load amount " + productPrice + " for " + productName);
                userAmount = sc.nextFloat();
                itemPurchase(productPrice,userAmount,productName);
            }
        }

        public void itemPurchase(float productPrice,float userAmount, String productName){

            if(userAmount>2000){
                System.out.println("Highest denomination is 2000, please load less than Rs.2000");
            }
            else if(userAmount<productPrice){
                System.out.println("Please load the exact amount of product");
            }
            else{
                System.out.println("Amount loaded by you: " + userAmount);
                userBalanceAmount = userAmount - productPrice;

                if (userBalanceAmount == 0) {
                    System.out.println("Dispensing" + productName);
                } else if (userBalanceAmount > 0) {
                    System.out.println("Please collect " + productName +" and your balance of Rs." + userBalanceAmount);
                }
                amountInMachine += productPrice;
            }
        }
}
