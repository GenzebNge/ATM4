package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMClass {

    static int i =0;
    static Scanner userInput =  new Scanner(System.in);
    static String[] user ={"1234", "2345","3456"};
    static String[] pin = {"0000","1111","2222"};
    static double[] balance ={500.0,600.0,700.0};
    static  double balance1;
    Account account = new Account();
  //  ArrayList<Account> myAccount = new ArrayList<>(100);

    private static boolean validateAccount(String accountNumber , String pin2) {

        boolean check = false;
        int count =0;
        do {
            if (accountNumber.equals(user[count]) && pin2.equals(pin[count])) {
                balance1 = balance[i];
                check = true;
            }
            count++;

        }while (count<3);

      return check;
    }


    public static void deposit (double  userdeposit){
        balance1 = balance1  + userdeposit;
        System.out.println("your current balance is:"+ balance1);
    }

    public static void withdraw(double withdrawAmount) {
        if (withdrawAmount >= balance1) {
            System.out.println("incefficinet fund");
        } else {
            balance1 = balance1 - withdrawAmount;
            System.out.println("your current balance is " + balance1);
        }
    }


    public static void  checkBalance(double balane){
        System.out.println("current balcance is " + balane);
    }

    public static void main(String[] args) {

        Account account1 = new Account();
        System.out.println("Enter your Accout number");
        String userAccount = userInput.next();
        account1.setAccountNum(userAccount);
        System.out.println("Enter your pin Number");
        String userPIN = userInput.next();
        account1.setPIN(userPIN);
        boolean accoutnChek;
        int count =0;

        do {
            accoutnChek = validateAccount(account1.getAccountNum(), account1.getPIN());
            if (accoutnChek == false)
               validateAccount(account1.getAccountNum(), account1.getPIN());
              System.out.println(accoutnChek);
        }while (count<3);

         int i =0;

            if (accoutnChek == true) {
                System.out.printf("Choose the type of service you want! 1. deposit, 2. withdraw, 3. checkBalance");
                int userSelection = userInput.nextInt();
                if (userSelection == 1) {
                    System.out.println("Enter deposit amount");
                    double depositAmount = userInput.nextDouble();
                    deposit(depositAmount);
                } else if (userSelection == 2) {
                    System.out.println("Enter withraw amount?");
                    double withrawAmount = userInput.nextDouble();
                    withdraw(withrawAmount);
                    System.out.println("Do you want other transaction?");
                } else if (userSelection == 3) {
                    checkBalance(balance1);
                }

            }


    }
}
