import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option = 0;// interface option
        String name; // name for account creator
        double dipAmount = 0 ; // deposit amount
        double withAmount = 0 ; // Withdrawal amount
        Scanner input = new Scanner(System.in);

        while (option != 5 ){
            display();
            option = input.nextInt();
        }

    }

    // almost all of the things that are displayed on the system will came from this function
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