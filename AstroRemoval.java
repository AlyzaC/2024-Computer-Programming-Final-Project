import java.util.Scanner;
import java.sql.*;

public class AstroRemoval {
    //Fields
        private Astronaut[] astrosToBeRemoved;

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
            for (Astronaut astro : astrosToBeRemoved) {
                if (astro == null) {
                    astro = a;
                    break;
                }
            }
        }

    /**
     * Verifies whether to remove the astronaut information.
     * @return A boolean for whether the removal has been approved by the user
     */
        private boolean verifyRemoval() {
            Scanner keyboard = new Scanner(System.in);
            String astronautList = "";
            boolean verified;
            for (Astronaut astro : astrosToBeRemoved) {
                if (astro != null) {
                    astronautList += "- " + astro.getName() + "\n";
                }
            }
            System.out.println("The following astronauts have been chosen for removal:" +
                               astronautList +
                               "Do you wish to proceed with removal?\n" +
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
        public void removeAstronauts(Connection c) {
            if (verifyRemoval()) {
                for (Astronaut astro : astrosToBeRemoved) {
                    if (astro != null) {
                        /*try {
                            Statement stmnt = c.getStatement();
                            ResultSet rsltst = stmnt.executeQuery(); //Or do we use something else?
                            find astronaut in database
                            delete all info
                            rsltst.close();
                            stmnt.close();
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
                System.out.println("Astronaut(s) have been successfully removed.");
            }
        }
}
