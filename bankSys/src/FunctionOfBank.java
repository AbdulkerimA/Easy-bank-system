import java.util.ArrayList;

public class FunctionOfBank {
    private ArrayList<String> userName = new ArrayList<>();
    private ArrayList<Double> deposit = new ArrayList<Double>();
    //private ArrayList<Double> withdraw = new ArrayList<>();
    //private ArrayList<Double> transfer = new ArrayList<>();

    public void register(String userName, double deposit) {
        this.userName.add(userName);
        this.deposit.add(deposit);
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
            It takes two usernames sender and resiver and it will take the amount to transer
            then it will decreas the deposit amount from sender and add it to resiver deposit
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
}// the end of the class


