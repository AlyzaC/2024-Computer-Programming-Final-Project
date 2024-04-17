import java.util.Scanner;
import java.sql.*;

public class shipRemoval {
    //Fields
        private Ship shipToRemove;

    //Constructor
        public shipRemoval(Ship s) {
            shipToRemove = s;
        }

    //Methods
        /**
     * Verifies whether to remove the ship information.
     * @return A boolean for whether the removal has been approved by the user
     */
        private boolean verifyRemoval() {
            Scanner keyboard = new Scanner(System.in);
            boolean verified;
            System.out.println("The following ship has been chosen for removal: " + shipToRemove.getName() + "\n" +
                               "Do you wish to procede with removal?\n" +
                               "1. Yes\n" +
                               "2. No");
            int choice = keyboard.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Please enter a number 1-2.\n" +
                                   "Do you wish to proceed with removal?\n" +
                                   "1. Yes\n" +
                                   "2. No");
                choice = keyboard.nextInt();
            }
            if (choice == 1) {
                verified = true;
            } else {
                verified = false;
            }
            keyboard.close();
            return verified;
        }

    /**
     * Removes astronauts added to list, after verification from the user.
     * @param c A SQL connection provided by the user
     */
        public void removeShip(Connection c) {
            if (verifyRemoval()) {
                /*try {
                    open sql connection?
                    open database?
                    find ship in database
                    delete all info
                    close connection?
                } catch (SQLException e) {
                        System.out.println("Error occured: " + e.getMessage());
                    }
                */

                String emptyString = null;
                shipToRemove.setSName(emptyString);
                shipToRemove.setSCap(0);
                shipToRemove.setFCap(0);
                shipToRemove.setFuel(0.0);
                shipToRemove = null;
                System.out.println("Ship has been successfully removed.");
            }
        }
}
