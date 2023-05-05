import java.io.*;
import java.util.ArrayList;

public class FunctionOfBank {
    private ArrayList<String> userName = new ArrayList<>();
    private ArrayList<Double> deposit = new ArrayList<Double>();


    public void register(String userName, double deposit) {
        this.userName.add(userName);
        this.deposit.add(deposit);
    }


    public void dataDisplay () {

        System.out.println("\t\t\t +============================+");
        System.out.println(" \t\t\t|  JAVA Bank Users Database  |");
        System.out.println("\t\t\t +============================+");

        for ( int i = 0 ; i < this.userName.size(); i++  ) {
            System.out.println(( i+1 ) +" " + this.userName.get(i) + " : " + this.deposit.get(i) + " ETB");
        }
    }

    /*
     * what this function will do is that if the existing user wants to deposit some amount of money
     * it will acept that money and add to the account deposit
     * */
    public void setDeposit (String name , double depAmount) {
        // we need to search for the username
        String ownerName ;
        for (int i=0 ; i < this.userName.size();i++){

            ownerName = this.userName.get(i);

            if (ownerName.equals(name)){
                // clear the screen
                System.out.println("The deposit amount is : " + depAmount + " ETB ");

                this.deposit.set( i , ( this.deposit.get(i) + depAmount) );

                System.out.println("Your current balance is  : " + this.deposit.get(i) + " ETB");

                // press something to continue
            }
            else {

            }
        }// end of loop
    }// end of func



    // what this fuc will do is when someone withdraw some amount of money from their account
    // it will check the right owner of the account and decreas their deposit amount

    public void setWithdraw (String name , double withAmount){

        // we need to search for the username first

        String ownerName ;
        for (int i=0 ; i < this.userName.size();i++){

            ownerName = this.userName.get(i);

            if (ownerName.equals(name)){
                // clear the screen
                System.out.println("dear customer the withdrawn amount is : " + withAmount + " ETB");

                this.deposit.set( i , ( this.deposit.get(i) - withAmount) );

                System.out.println("Your current balance is : " + this.deposit.get(i) + " ETB");

                // press something to continue
            }
            else {

            }
        }// the end of for loop
    }// the end of the function

        /*
            what this function will do is it allow users to transfer from one account to another
            using the  name  of the user they want to transfer money to
            It takes two usernames sender and receiver, and it will take the amount to transfer
            then it will decreas the deposit amount from sender and add it to receiver deposit
        */
    public void setTransfer (String sender , String resiver , double transferAmount) {

        // checking the user have sufficent amount of money
        // identifaing who is the sender

        for (int i=0; i<this.userName.size() ; i++ ) {

            if (sender.equals( this.userName.get(i) ) ) {

                    this.deposit.set( i , ( this.deposit.get(i) - transferAmount) );

                System.out.println("\t\t\t Transfer successful TO " + resiver );
                System.out.println("dear customer your current balance is " + this.deposit.get(i) + " ETB");

            } // the end of the if statment

            // identifing the resiver and adding the transfer amount

            if (resiver.equals( this.userName.get(i) ) ) {

                this.deposit.set( i , ( this.deposit.get(i) + transferAmount) );

            }// the end of if stetment

        }// end of for loop
    }

    //  what this function will do is just saving users data on the database

    public void fileSaver ( ) {
        // first i will create a File that the data will be saved on
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter ( " Java_Bank_DB.txt"));
             // the file is created, so now we can write the data on that file

            writer.write("\t\t\t +======================+ \n");
            writer.write(" \t\t\t| Welcome to JAVA Bank | \n" );
            writer.write("\t\t\t +======================+ \n");

            for (int i=0; i<this.userName.size(); i++ ){
                writer.write( (i+1) + " " + this.userName.get(i) + " : " + this.deposit.get(i) + " ETB \n");
            }
            writer.close();

            // so we this code will save each and evey data on the userName and deposit array
            // this function have to implemented whn the user exit the program

        }catch (Exception e){
            System.out.println(" !!! File is not saved ");
        }
    }// end of the func

    public void fileSaverForReader ( ) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter ( "Bank_Data_To_read_from.txt"));

            for (int i=0; i<this.userName.size(); i++ ){
                writer.write( this.userName.get(i) + "\n" ) ;
                writer.write(  String.valueOf(this.deposit.get(i)) + "\n");
            }
            writer.close();

        }catch (Exception e){
            System.out.println(" !!! File is not saved ");
        }
    }// end of the function

    // only saving the date is useless we have to read from that data

    public void dataReader () {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Bank_Data_To_read_from.txt"));

            String line = "one";

            while (line != null) {
                line  = reader.readLine();
                int i = 0 ; // index
                if (line == null ) {
                 continue;
                }
                else {
                    userName.add(line);
                   deposit.add(Double.parseDouble(String.valueOf(reader.readLine())));
                }
                i++;
            }
            reader.close();
            System.out.println("Data successfully fetched press any letter To Start the program : ");

        } catch (FileNotFoundException e) {
            System.out.println("The Database is Down ");
        } catch (IOException e) {
            System.out.println("ioException");
        }
    }


}// the end of the class


