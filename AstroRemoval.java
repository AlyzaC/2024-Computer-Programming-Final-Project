import java.util.Scanner;

public class AstroRemoval {
    //Fields
        Astronaut[] astrosToBeRemoved;

    //Constructor?
    /**
     * @param numToRemove The number of astronauts to be removed
     */
        public AstroRemoval(int numToRemove) {
            astrosToBeRemoved = new Astronaut[numToRemove];
        }

    //Methods
    /**
     * @param a A user supplied astronaut that is to be removed
     */
        public void addAstro(Astronaut a) {
            for (int count : astrosToBeRemoved) {
                if (astrosToBeRemoved[count] == null) {
                    astrosToBeRemoved[count] = a;
                    break;
                }
            }
        }

        /**
         * @return A boolean for whether the removal has been approved by the user
         */
        private boolean verifyRemoval() {
            Scanner kbd = new Scanner(System.in);
            String astronauts = "";
            boolean verified;
            for (int count : astrosToBeRemoved) {
                astronauts += astrosToBeRemoved[count].getName() + "\n";
            }
            System.out.println("The following astronauts have been chosen for removal:" +
                                 astronauts + "\n" +
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

        public void removeAstronauts() {
            if (verifyRemoval()) {
                //
                System.out.println("Astronauts have been successfully removed.");
            }
        }
}
