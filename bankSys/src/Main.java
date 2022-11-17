import java.util.*;

public class Main {
    public static void main(String[] args) {

        Byte option = 0;// interface option
        String name; // name for account creator
        double dipAmount = 0  ; // deposit amount
        double withAmount = 0 ; // Withdrawal amount
        Scanner input = new Scanner(System.in);

        while (option != 5 ){
            display();
            option = input.nextByte();

            // checking if the user pressed the wrong button

            if (option > 5 || option < 1){
                System.out.println("you pressed the wrong option pleas try again");
                display();
                option = input.nextByte();
            }
            // if the user press one of the given option correctly the following code will be run
            else {
                // so we will check the user option hear and per form the required action
                switch (option){
                    case 1:
                        // taking username and amount of deposit

                        System.out.println("Enter the user full name : ");
                        name = input.nextLine();
                        System.out.println("Enter Deposit amount : ");
                        dipAmount = input.nextDouble();


                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

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
        System.out.println("* To Deposit to an existing account press 2 ");
        System.out.println("* To withdraw from an existing account press 3 ");
        System.out.println("* To transfer form one account to another account press 4");
        System.out.println("* To shutdown the System press 5 ");
    }
}