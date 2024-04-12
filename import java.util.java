import java.util.Random;
import java.util.Scanner;

public class main1 {

public static void main(String[] args){
    
}

    public void LoggingInPassword() {

        Scanner kbd2 = new Scanner(System.in);

        boolean createPassword = true;
        if (createPassword) {

            // Need To make it so we know when it was runned for the first time and when it
            // was not
            // Login
            // * First time application is run

            // * - Create password and display for user to write down
            System.out.println("Creating Password...");

            Random r = new Random();
            Integer num = 0;
            for (int i = 0; i < 1; i++) {
                num = r.nextInt(20000);
                System.out.println("Please Write Down The Following Password: " + num);
            }
            // * - Notify user of account creation and move on
            System.out.println("*Account Created*");

            // * Any time after 1st
            createPassword = false;
        } else {

            // * - give option to reset password using administrator password
            System.out.println("Do you wish to reset the password with using the adminstartor password?");

            // ***NEED TO FINISH THIS PART***
            // * - - ask for administrator password and verify
            // * - - reset password
            // * - verify password

        }

        // I'm not sure how to have the computer remember the password
        // * - - move on if valid
        kbd2.close();
    }

}
