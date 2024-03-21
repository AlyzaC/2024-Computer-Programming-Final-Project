import java.util.Scanner;
public class AstroRemoval {
    //Fields
        private Astronaut[] astrosToBeRemoved;

    //Constructor
    /**
     * The constructor for the class. Asks for the number of astronauts to be removed.
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
            Scanner kbd = new Scanner(System.in);
            String astronautList = "";
            boolean verified;
            for (Astronaut astro : astrosToBeRemoved) {
                astronautList += astro.Name + "\n";
            }
            System.out.println("The following astronauts have been chosen for removal:" +
                               astronautList +
                               "Do you wish to proceed with removal?\n" +
                               "1. Yes\n" +
                               "2. No");
            int choice = kbd.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Please enter a number 1-2.\n" +
                                   "Do you wish to proceed with removal?\n" +
                                   "1. Yes\n" +
                                   "2. No");
                choice = kbd.nextInt();
            }
            if (choice == 1) {
                verified = true;
            } else {
                verified = false;
            }
            kbd.close();
            return verified;
        }

    /**
     * Removes astronauts added to list, after verification from the user.
     */
        public void removeAstronauts() {
            if (verifyRemoval()) {
                /*for (Astronaut astro : astrosToBeRemoved) {
                    Code to remove astronauts
                }*/
                System.out.println("Astronauts have been successfully removed.");
            }
        }
}
