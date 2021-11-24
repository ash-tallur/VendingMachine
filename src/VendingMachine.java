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

    float amountInMachine = 0;
    Scanner sc;

    public VendingMachine() {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        while (true) {
            int option = machine.initialItemsDisplay();
            machine.checkOnUserInput(option);
            machine.choiceOfItem(option);
        }
    }

    public int initialItemsDisplay() {
        System.out.println("HELLO!!! Look into the below options for the items and opt");
        System.out.println(" Item Name           Price \n 1. Cool Drink      Rs. 50.00 \n" +
                " 2. Energy Bar      Rs. 35.50 \n 3. Masks           Rs. 80.25 \n 4. Coffee          Rs. 20.00 \n" +
                " 5. Chips           Rs. 40.00 \n 6. Check Amount in Machine");
        System.out.println("Choose the item");
        return sc.nextInt();
    }

    public void checkOnUserInput(int option) {
        if (option < 1 || option > 6) {
            System.out.println("Choose the right option");
        } else if (option == 6) {
            System.out.println("The amount in the machine " + amountInMachine);
        }
    }

    public void choiceOfItem(int option) {
        float productPrice = 0;
        String productName = "";
        switch (option) {
            case 1:
                productPrice = 50.00F;
                productName = "Cold Drink";
                break;
            case 2:
                productPrice = 35.50F;
                productName = "Energy Bar";
                break;
            case 3:
                productPrice = 80.25F;
                productName = "Masks";
                break;
            case 4:
                productPrice = 20.00F;
                productName = "Coffee";
                break;
            case 5:
                productPrice = 40.00F;
                productName = "Chips";
                break;
        }
        System.out.println("Load amount " + productPrice + " for " + productName);
        float userAmount = sc.nextFloat();
        itemPurchase(productPrice, userAmount, productName);
    }

    public void itemPurchase(float productPrice, float userAmount, String productName) {
        if (userAmount > 2000) {
            System.out.println("Highest denomination is 2000, please load less than Rs.2000");
        } else if (userAmount < productPrice) {
            System.out.println("Please load the exact amount of product");
        } else {
            System.out.println("Amount loaded by you: " + userAmount);
            float userBalanceAmount = userAmount - productPrice;

            if (userBalanceAmount == 0) {
                System.out.println("Dispensing" + productName);
            } else if (userBalanceAmount > 0) {
                System.out.println("Please collect " + productName + " and your balance of Rs." + userBalanceAmount);
            }
            amountInMachine += productPrice;
        }
    }
}
