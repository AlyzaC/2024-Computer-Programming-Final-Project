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
