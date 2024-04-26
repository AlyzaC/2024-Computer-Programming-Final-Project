import java.util.Scanner;
import java.sql.*;

public class AstroRemoval {
    //Fields
        private Astronaut[] astrosToBeRemoved;
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
        private boolean verifyRemoval(Scanner keyboard) {
            String astronautList = "\n";
            boolean verified;
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
            return verified;
        }

    /**
     * Removes astronauts added to list, after verification from the user.
     * @param c A SQL connection provided by the user
     */
        public void removeAstronauts(Connection c, Scanner keyboard) {
            if (verifyRemoval(keyboard)) {
                for (Astronaut astro : astrosToBeRemoved) {
                    if (astro != null) {
                        /*try {
                            Statement stmnt = c.getStatement();
                            String updateForRemoval = "delete from Astronauts " + 
                                                      "where SerialNumbers = " + astro.getSerialNumber();
                            adjust database?
                        } catch (SQLException e) {
                            System.out.println("Error occured: " + e.getMessage());
                        }
                        */

                        String emptyString = null;
                        astro.setName(emptyString);
                        astro.setdateOfBirth(emptyString);
                        astro.setSerialNumber(0);
                        astro.setAddress(emptyString);
                        astro.setEmail(emptyString);
                        astro.setPhoneNumber(emptyString);
                        astro.setNextOfKin(emptyString);
                        astro.setStatus(emptyString);
                        astro.setPayRate(0);
                        astro.setWeight(0);
                        astro = null;
                        //yield astro; ??
                    }
                    
                }
                System.out.println("\nAstronaut(s) have been successfully removed.");
            }
        }
}
