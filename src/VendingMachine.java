/*
Commit-1
1. Display menu with following columns -- item-id, name, price.
     should have at-least 3 products
2. Accept item-id and amount from user
3. Based on item-id,
           return balance amount to user, if amount provided is more than item price
           print a simple msg saying ""dispensing <item name>""
4. keep track of amount in vending machine

*/

import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {
        System.out.println("HELLO!!! Look into the below options for the items and opt");
        Scanner sc = new Scanner(System.in);
        //variables for selecting option, amount loaded by user, balance amount for user and amount in machine
        int option;
        float userAmount;
        float userBalanceAmount;
        float amountInMachine = 0;
        float productPrice;
        do{
            System.out.println(" Item Name           Price \n 1. Cool Drink      Rs. 50.00 \n 2. Energy Bar      Rs. 35.50 \n 3. Masks           Rs. 80.25 \n 4. Coffee          Rs. 20.00 \n 5. Chips           Rs. 40.00");
            System.out.println("Enter your option");
            option = sc.nextInt();
            if(option>5){
                System.out.println("Choose the right option");
            }
            else{
                if(option == 1){
                    productPrice = 50.00F;
                    System.out.println("Load amount for cool drink");
                    userAmount = sc.nextFloat();
                    //Checking if the amount loaded by user is more than 2000
                    if(userAmount>2000){
                        System.out.println("Highest denomination is 2000, please load less than Rs.2000");
                    }
                    //Checking if user is loading exact amount as product's price
                    else if(userAmount<productPrice){
                        System.out.println("Please load the exact amount of product");
                    }
                    //Checking the balance based on amount loaded and saving each product price
                    else {
                        System.out.println("Amount loaded by you: " + userAmount);
                        userBalanceAmount = userAmount - productPrice;

                        if (userBalanceAmount == 0) {
                            System.out.println("Dispensing Cool Drink");
                        } else if (userBalanceAmount > 0) {
                            System.out.println("Please collect cool drink and your balance of Rs." + userBalanceAmount);
                        }
                        amountInMachine += productPrice;
                    }

                }
                else if(option == 2){
                    productPrice = 35.50F;
                    System.out.println("Load amount for energy bar");
                    userAmount = sc.nextFloat();
                    if(userAmount>2000){
                        System.out.println("Highest denomination is 2000, please load less than Rs.2000");
                    }
                    else if(userAmount<productPrice){
                        System.out.println("Please load the exact amount of product");
                    }
                    else {
                        System.out.println("Amount loaded by you: " + userAmount);
                        userBalanceAmount = userAmount - productPrice;

                        if (userBalanceAmount == 0) {
                            System.out.println("Dispensing Energy Bar");
                        } else if (userBalanceAmount > 0) {
                            System.out.println("Please collect energy bar and your balance of Rs." + userBalanceAmount);
                        }
                        amountInMachine += productPrice;
                    }

                }
                else if(option == 3){
                    productPrice = 80.25F;
                    System.out.println("Load amount for masks");
                    userAmount = sc.nextFloat();
                    if(userAmount>2000){
                        System.out.println("Highest denomination is 2000, please load less than Rs.2000");
                    }
                    else if(userAmount<productPrice){
                        System.out.println("Please load the exact amount of product");
                    }
                    else {
                        System.out.println("Amount loaded by you: " + userAmount);
                        userBalanceAmount = userAmount - productPrice;

                        if (userBalanceAmount == 0) {
                            System.out.println("Dispensing Mssks");
                        } else if (userBalanceAmount > 0) {
                            System.out.println("Please collect masks and your balance of Rs." + userBalanceAmount);
                        }
                        amountInMachine += productPrice;
                    }

                }
                else if(option == 4){
                    productPrice = 20.00F;
                    System.out.println("Load amount for Coffee");
                    userAmount = sc.nextFloat();
                    if(userAmount>2000){
                        System.out.println("Highest denomination is 2000, please load less than Rs.2000");
                    }
                    else if(userAmount<productPrice){
                        System.out.println("Please load the exact amount of product");
                    }
                    else {
                        System.out.println("Amount loaded by you: " + userAmount);
                        userBalanceAmount = userAmount - productPrice;

                        if (userBalanceAmount == 0) {
                            System.out.println("Dispensing Coffee");
                        } else if (userBalanceAmount > 0) {
                            System.out.println("Please collect coffee and your balance of Rs." + userBalanceAmount);
                        }
                        amountInMachine += productPrice;
                    }

                }
                else if(option ==5){
                    productPrice = 40.00F;
                    System.out.println("Load amount for Chips");
                    userAmount = sc.nextFloat();
                    if(userAmount>2000){
                        System.out.println("Highest denomination is 2000, please load less than Rs.2000");
                    }
                    else if(userAmount<productPrice){
                        System.out.println("Please load the exact amount of product");
                    }
                    else {
                        System.out.println("Amount loaded by you: " + userAmount);
                        userBalanceAmount = userAmount - productPrice;

                        if (userBalanceAmount == 0) {
                            System.out.println("Dispensing Chips");
                        } else if (userBalanceAmount > 0) {
                            System.out.println("Please collect chips and your balance of Rs." + userBalanceAmount);
                        }
                        amountInMachine += productPrice;
                    }

                }
            }
            System.out.println("Amount in Machine " + amountInMachine);
        }while(true);


    }

}
