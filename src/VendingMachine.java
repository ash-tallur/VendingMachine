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

Commit-4
1. Add option to view all previous transactions performed
2. When user selects previous transactions, display below details for all previous transactions
   timestamp of transaction, item-id, amount entered by user, balance returned to user, amount in vending machine

*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VendingMachine {

    static float amountInMachine;
    private static final int MAX_TRANSACTIONS = 50;
    int transactionCounter;
    Scanner sc;

    //Arrays to track the transactions
    int[] purchasedItemId = new int[MAX_TRANSACTIONS];
    float[] amountEnteredByUser = new float[MAX_TRANSACTIONS];
    float[] balanceReturnedToUser = new float[MAX_TRANSACTIONS];
    float[] amountInMachineDuringTransaction = new float[MAX_TRANSACTIONS];
    String[] listOfTransactionTime = new String[MAX_TRANSACTIONS];

    public VendingMachine() {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        //Putting all the item details into a list, so it can be accessed
        String[] itemNames = {"Cool Drink","Energy Bar","FaceMasks","Hot Coffee","PotatoChips"};
        int[] itemIDs = {1,2,3,4,5};
        float[] itemPrices = {50.00F, 35.50F, 80.25F, 20.00F, 40.00F};

        VendingMachine machine = new VendingMachine();

        while (true) {

            int option = machine.displayMenuAndGetUserInput(itemIDs,itemNames,itemPrices);
            if(machine.verifyInput(option)){
                if(option>=1 && option <=5){
                    machine.dispenseItem(option, itemNames, itemPrices );
                } else if (option == 6) {
                    System.out.println("The amount in the machine " + amountInMachine);
                } else if(option == 7){
                    machine.displayPreviousTransactions();
                }
            }
        }
    }

    //Displaying the menu and taking the user's option
    public int displayMenuAndGetUserInput(int[] itemIDs, String[] itemNames, float[] itemPrices) {
        System.out.println("HELLO!!! Look into the below options and opt");
        System.out.println(" Item ID \t\t Item Name \t\tItem Price");
        for(int i=0;i<itemIDs.length;i++) {
            System.out.println("\t" + itemIDs[i] + "\t\t\t" + itemNames[i] + "\t\t\t" + itemPrices[i]);
        }
        System.out.println("\t6\t\t" +" Amount In Machine");
        System.out.println("\t7\t\t" + "Items Transaction History");
        System.out.println("Choose your option");
        return sc.nextInt();
    }

    //Verifying the user input
    public boolean verifyInput(int option){
        if (option < 1 || option > 7) {
            System.out.println("Please choose a proper input");
             return false;
        }
        return true;
    }

    //Dispensing the respective item
    public void dispenseItem(int itemIdForPurchase, String[] itemNames, float[] itemPrices) {
        float productPrice = itemPrices[itemIdForPurchase-1];
        String productName = itemNames[itemIdForPurchase-1];
        System.out.println("Load amount of Rs." + productPrice + " for " + productName);
        float userAmount = sc.nextFloat();

        if (userAmount > 2000) {
            System.out.println("Highest denomination is 2000, please load less than Rs.2000");
        } else if (userAmount < productPrice) {
            System.out.println("Please load the exact amount of product");
        } else {
            System.out.println("Amount loaded by you: " + userAmount);
            float userBalanceAmount = userAmount - productPrice;

            System.out.println("Dispensing " + productName);
            if (userBalanceAmount > 0) {
                System.out.println("Please collect your balance of Rs." + userBalanceAmount);
            }

            amountInMachine += productPrice;
            recordTransactions(itemIdForPurchase,userAmount,userBalanceAmount);
            transactionCounter = transactionCounter + 1;
        }
    }

    //Returning the transaction time based on a certain format
    public String getCurrentTimeStamp(){
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm");
        LocalDateTime transactionTime = LocalDateTime.now();
        String formattedDateTime = transactionTime.format(formatDateTime);
        return formattedDateTime;
    }

    //Tracking the transactions of the items purchased
    public void recordTransactions(int option, float userAmount, float userBalanceAmount){
        purchasedItemId[transactionCounter] = option;
        amountEnteredByUser[transactionCounter] = userAmount;
        balanceReturnedToUser[transactionCounter] = userBalanceAmount;
        amountInMachineDuringTransaction[transactionCounter] = amountInMachine;
        listOfTransactionTime[transactionCounter] = getCurrentTimeStamp();
    }


    public void displayPreviousTransactions(){
        if(transactionCounter == 0){
            System.out.println("Items were not bought");
        }else if(transactionCounter>0){
            System.out.println("The Item transaction details are:");
            System.out.println("Transaction Time \t\t Item ID \t\t Amount Entered by User \t\t " +
                               "Balance Given to User \t\t Amount in the Machine");
            for(int i=0;i<transactionCounter;i++){
                System.out.println(listOfTransactionTime[i] + "\t\t\t" +purchasedItemId[i] + "\t\t\t\t\t\t" + amountEnteredByUser[i] +
                        "\t\t\t\t\t\t" + balanceReturnedToUser[i] + "\t\t\t\t\t\t" + amountInMachineDuringTransaction[i]);
            }
        }
    }
}
