import java.util.Scanner;
import java.sql.*;

public class ShipRemoval {
    //Fields
        private Ship shipToRemove;

    //Constructor
        public ShipRemoval(Ship s) {
            shipToRemove = s;
            System.out.println(shipToRemove.getSName());
        }

    //Methods
        /**
     * Verifies whether to remove the ship information.
     * @return A boolean for whether the removal has been approved by the user
     */
        private boolean verifyRemoval(Scanner keyboard) {
            boolean verified;
            System.out.println("The following ship has been chosen for removal: " + shipToRemove.getSName() + "\n" +
                               "Do you wish to proceed with removal? (Yes/No)");
            String choice = keyboard.nextLine();
            while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                System.out.println("Please enter \"yes\" or \"no\".\n" +
                        "Do you wish to proceed with removal? (Yes/No)");
                choice = keyboard.nextLine();
            }
            if (choice.equalsIgnoreCase("yes")) {
                verified = true;
            } else {
                verified = false;
            }
            return verified;
        }

    /**
     * Removes astronauts added to list, after verification from the user.
     * @param c A SQL connection provided by the user
     */
        public Ship removeShip(Connection c, Scanner keyboard) {
            if (verifyRemoval(keyboard)) {
                /*try {
                    Statement stmnt = c.getStatement();
                    String updateForRemoval = "delete from Ships " + 
                                              "where ShipNames = " + shipToRemove.getSName();
                    adjust database?
                } catch (SQLException e) {
                    System.out.println("Error occured: " + e.getMessage());
                }*/
                shipToRemove.setSName(null);
                shipToRemove.setSCap(0);
                shipToRemove.setFCap(0);
                shipToRemove.setFuel(0.0);
                shipToRemove = null;
                System.out.println("\nShip has been successfully removed.");
            }
            return shipToRemove;
        }
}
