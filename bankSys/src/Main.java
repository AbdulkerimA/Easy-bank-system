import java.util.*;

public class Main {
    public static void main(String[] args) {

        Byte option = 0;// interface option
        String name; // name for account creator
        double dipAmount = 0  ; // deposit amount
        double withAmount = 0 ; // Withdrawal amount
        double transAmount = 0; // transfer amount
        Scanner input = new Scanner(System.in);
        FunctionOfBank javaBank = new FunctionOfBank();

        // fetching the data from Database

        javaBank.dataReader();
        input.next();

        while (option != 7 ){
            display();
            option = input.nextByte();

            // checking if the user pressed the wrong button

            if (option > 7 || option < 1){
                System.out.println("you pressed the wrong option pleas try again");
                display();
                option = input.nextByte();
            }
            // if the user press one of the given option correctly then the following code will be run
            else {
                // so we will check the user option hear and per form the required action
                switch (option){
                    case 1:
                        // taking username and amount of deposit

                        System.out.println("Enter the user full name : ");
                        name = input.next();
                        System.out.println("Enter Deposit amount : ");
                        dipAmount = input.nextDouble();
                        javaBank.register(name,dipAmount);
                        System.out.println("registered successfully Press any later to continue... ");
                        input.next();
                        break;
                    case 2:
                        javaBank.dataDisplay();
                        System.out.println(" Press any later to continue... ");
                        input.next();

                        break;
                    case 3:
                        System.out.printf("Enter the username to deposit on : ");
                        name = input.next();

                        System.out.println("Enter the amount of money to deposit : ");
                        dipAmount = input.nextDouble();

                        javaBank.setDeposit(name , dipAmount);

                        System.out.println(" Press any later to continue... ");
                        input.next();
                        break;
                    case 4:
                        System.out.printf("pleas Enter the account owner name : ");
                        name = input.next();
                        System.out.printf("How much money do you want to withdraw : ");
                        withAmount = input.nextDouble();

                        javaBank.setWithdraw(name,withAmount);
                        System.out.println(" Press any later to continue... ");
                        input.next();
                        break;
                    case 5:
                        String senderName ,receiverName ; // sender name and resiver name

                        System.out.printf("pleas Enter the Sender name : ");
                        senderName = input.next();

                        System.out.printf("pleas Enter the receiver name : ");
                        receiverName = input.next();

                        System.out.printf("pleas Enter the Amount of money to transfer : ");
                        transAmount = input.nextDouble();

                        javaBank.setTransfer(senderName , receiverName , transAmount);
                        System.out.println(" Press any later to continue... ");
                        input.next();
                        break;
                    case 6:
                        // the user wants to exit the program
                        javaBank.fileSaver();
                        javaBank.fileSaverForReader();
                        System.out.println("the Database is updated successfully");

                        System.out.println(" Press any later to continue... ");
                        input.next();
                        break;
                }
            }
        }

    }

    // almost all things that are displayed on the system will came from this function
    public static void display (){
        System.out.println("\t\t\t +======================+");
        System.out.println(" \t\t\t| Welcome to JAVA Bank |");
        System.out.println("\t\t\t +======================+");

        System.out.println("* To create an account press 1 ");
        System.out.println("* To display all users 2");
        System.out.println("* To Deposit on an existing account press 3 ");
        System.out.println("* To withdraw from an existing account press 4 ");
        System.out.println("* To transfer form one account to another account press 5");
        System.out.println("* To save the data press 6 ");
        System.out.println("* To exit the program press 7");
    }
}