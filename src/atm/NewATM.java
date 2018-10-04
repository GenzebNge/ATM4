package atm;
import java.util.*;
public class NewATM {

    public static Scanner userInput = new Scanner(System.in);
    //public static  ArrayList<Account>myAccountList;
    public static String checkID(String acctNum, String pwd) {
        String result = "Accout or pin number is wrong";

        String a = "1234 pwd1 8000.36";
        String b = "2345 pwd2 4800.20";
        String c = "3456 pwd3 9600.74";





        if (acctNum.equals(a.substring(0, a.indexOf(" "))) &&
                pwd.equals(a.substring(a.indexOf(" ") + 1, a.lastIndexOf(" "))))
            return result = a.substring(a.lastIndexOf(" ") + 1);

        if (acctNum.equals(b.substring(0, b.indexOf(" "))) &&
                pwd.equals(b.substring(b.indexOf(" ") + 1, b.lastIndexOf(" "))))
            return result = b.substring(b.lastIndexOf(" ") + 1);

        if (acctNum.equals(c.substring(0, c.indexOf(" "))) &&
                pwd.equals(c.substring(c.indexOf(" ") + 1, c.lastIndexOf(" "))))
            return result = c.substring(c.lastIndexOf(" ") + 1);

        return result;
    }


    public static int services() {
        int options;
        do {
            System.out.print("\nchoose your services ! "  + "\n 1. Check Balance \n 2. Deposit"   + "\n 3. Withdraw\n 4. Log Out\n\n");
            options = userInput.nextInt();
            if (options < 1 || options > 4) {
                System.out.println("The selected services does not exist try from the following");
            }

        } while (options < 1 || options > 4);

        return options;
    }

    public static void displayBalance(double x) {
        System.out.printf("\nYour Current Balance is $%.2f\n", x);
    }

    public static double deposit(double x, double y) {
        double depositAmt = y, currentBal = x;
        double newBalance = depositAmt + currentBal;
        System.out.printf("Your New Balance is $%.2f\n", newBalance);
        return newBalance;
    }

    public static double withdraw(double x, double y) {
        double withdrawAmt = y, currentBal = x, newBalance;

        newBalance = currentBal - withdrawAmt;
        System.out.printf("Your New Balance is %.2f\n", newBalance);

        return newBalance;
    }


    public static void main(String[] args) {
        ArrayList<Account>myAccountList = new ArrayList<>();
        String accNum, pass, initialBalance = "wrong";
        int count = 0, servicesOption = 0;
        double depositAmt = 0, withdrawAmt = 0, currentBal = 0;
        boolean entery;
        int cout =1;

        do{
            Account myAccount = new Account();
            System.out.println( "Enter your account number?");
            String acc1 = userInput.next();
            myAccount.setAccountNum(acc1);
            userInput.nextLine();

            System.out.println("Set te pin");
            String pin = userInput.next();
            myAccount.setPIN(pin);
            userInput.nextLine();

            System.out.println("Enter initial balance");
            String acc1Value = userInput.next();
            myAccount.setAccountNum(acc1Value);
            userInput.nextLine();

            myAccountList.add(myAccount);
            System.out.println("Do you want o enter an other account? ");
            userInput.nextLine();


          //  System.out.println("your first account" + myAccountList.get(0) + myAccountList.get(1) + myAccountList.get(2));



        } while (count <=3);

        do {


            entery = false;
            System.out.println("Please Enter Your Account Number: ");
            accNum = userInput.next();

            System.out.println("Enter Your Pin: ");
            pass = userInput.next();

            initialBalance = checkID(accNum, pass);

            count++;

            if (count >= 3 && initialBalance.equals("wrong")) {
                System.out.print("Maximum Login Attempts Reached.");
                System.exit(0);
            }
            if (!(initialBalance.equals("wrong"))) {
                System.out.println("\nYour New Balance is: $ " + initialBalance);
            } else
                System.out.println(initialBalance);


        } while (initialBalance.equals("wrong"));

        currentBal = Double.parseDouble(initialBalance);

        while (servicesOption !=4){
            servicesOption =services();
            if (servicesOption == 1) {
                displayBalance(currentBal);
            } else if (servicesOption == 2){
                System.out.print("\nEnter Amount You Wish to Deposit: $ ");
                     depositAmt = userInput.nextDouble();
                     currentBal = deposit(depositAmt, currentBal);

            } else if (servicesOption == 3){
                System.out.print("\nEnter Amount You Wish to Withdrawl: $ ");
                   withdrawAmt = userInput.nextDouble();

                    while (withdrawAmt > currentBal) {
                        System.out.print("ERROR: INSUFFICIENT FUNDS!! "
                                + "PLEASE ENTER A DIFFERENT AMOUNT: $");
                        withdrawAmt = userInput.nextDouble();
                    }

            } else if (servicesOption == 4){
                System.out.print("\nThank For Using My ATM.  Have a Nice Day.  Good-Bye!");
                   System.exit(0);
            }
        }

    }
}
