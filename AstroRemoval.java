import java.util.Scanner;
import java.sql.*;

public class AstroRemoval {
    //Fields
        private Astronaut[] astrosToBeRemoved;
        private boolean verified = false;
        int astroCount = 0;

    //Constructor
    /**
     * The constructor for the AstroRemoval class. Asks for the number of astronauts to be removed.
     * @param numToRemove The number of astronauts to be removed
     */
        public AstroRemoval(int numToRemove){
            astrosToBeRemoved = new Astronaut[numToRemove];
        }

    //Methods
    /**
     * Adds an astronaut to the list of Astronauts to be removed.
     * @param a A user supplied astronaut that is to be removed
     */
        public void addAstro(Astronaut a) {
            for (int count = 0; count < astrosToBeRemoved.length; count++) {
                if (astrosToBeRemoved[count] ==  null) {
                    astrosToBeRemoved[count] = a;
                    break;
                }
            }
        }

    /**
     * Verifies whether to remove the astronaut information.
     * @return A boolean for whether the removal has been approved by the user
     */
        private void verifyRemoval(Scanner keyboard) {
            String astronautList = "\n";
            for (Astronaut astro : astrosToBeRemoved) {
                if (astro != null) {
                    astronautList += "- " + astro.getName() + "\n";
                }
            }
            System.out.println("The following astronauts have been chosen for removal: " +
                               astronautList +
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
        }

    /**
     * Removes astronauts added to list, after verification from the user.
     * @param c A SQL connection provided by the user
     */
        public Astronaut removeAstronauts(Connection c, Scanner keyboard) {
            if (!verified) {
                verifyRemoval(keyboard);
            }
            if (verified && astroCount < astrosToBeRemoved.length) {
                if (astrosToBeRemoved[astroCount] != null) {
                    try {
                        String updateForRemoval = "delete from Astronauts where SerialNumbers = ?";
                        PreparedStatement ps = c.prepareStatement(updateForRemoval);
                        ps.setInt(1, astrosToBeRemoved[astroCount].getSerialNumber());
                        ps.executeUpdate();
                        ps.close();
                    } catch (SQLException e) {
                        System.out.println("Error occured: " + e.getMessage());
                    }
                    String emptyString = null;
                    String astroRemoved = astrosToBeRemoved[astroCount].getName();
                    astrosToBeRemoved[astroCount].setName(emptyString);
                    astrosToBeRemoved[astroCount].setdateOfBirth(emptyString);
                    astrosToBeRemoved[astroCount].setSerialNumber(0);
                    astrosToBeRemoved[astroCount].setAddress(emptyString);
                    astrosToBeRemoved[astroCount].setEmail(emptyString);
                    astrosToBeRemoved[astroCount].setPhoneNumber(emptyString);
                    astrosToBeRemoved[astroCount].setNextOfKin(emptyString);
                    astrosToBeRemoved[astroCount].setStatus(emptyString);
                    astrosToBeRemoved[astroCount].setPayRate(0);
                    astrosToBeRemoved[astroCount].setWeight(0);
                    astrosToBeRemoved[astroCount] = null;
                    System.out.println("\n" + astroRemoved + " has been successfully removed.");
                }
            }
            return astrosToBeRemoved[astroCount++];
        }

        /**
     * Removes astronauts added to list, without verification from the user.
     * @param c A SQL connection provided by the user
     */
        public Astronaut removeAstronauts(Connection c) {
            if (astroCount < astrosToBeRemoved.length) {
                if (astrosToBeRemoved[astroCount] != null) {
                    try {
                        String updateForRemoval = "delete from Astronauts where SerialNumbers = ?";
                        PreparedStatement ps = c.prepareStatement(updateForRemoval);
                        ps.setInt(1, astrosToBeRemoved[astroCount].getSerialNumber());
                        ps.executeUpdate();
                        ps.close();
                    } catch (SQLException e) {
                        System.out.println("Error occured: " + e.getMessage());
                    }
                    String emptyString = null;
                    String astroRemoved = astrosToBeRemoved[astroCount].getName();
                    astrosToBeRemoved[astroCount].setName(emptyString);
                    astrosToBeRemoved[astroCount].setdateOfBirth(emptyString);
                    astrosToBeRemoved[astroCount].setSerialNumber(0);
                    astrosToBeRemoved[astroCount].setAddress(emptyString);
                    astrosToBeRemoved[astroCount].setEmail(emptyString);
                    astrosToBeRemoved[astroCount].setPhoneNumber(emptyString);
                    astrosToBeRemoved[astroCount].setNextOfKin(emptyString);
                    astrosToBeRemoved[astroCount].setStatus(emptyString);
                    astrosToBeRemoved[astroCount].setPayRate(0);
                    astrosToBeRemoved[astroCount].setWeight(0);
                    astrosToBeRemoved[astroCount] = null;
                    System.out.println("\n" + astroRemoved + " has been successfully removed.");
                }
            }
            return astrosToBeRemoved[astroCount++];
        }

        
}
