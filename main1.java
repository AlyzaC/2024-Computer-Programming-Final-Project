public class main1 {
public static void main(String[] args){
    Astronaut guy = new Astronaut();
    guy.spaceWalk();
    System.out.println(guy.getSerialNumber());
    //General outline idea? (Make changes if you want to)
    //Variables & Objects

    //Scanner(s)?
        //Scanner kbd = new Scanner(System.in)

    //Login

    
    /* Main menu
     * - Astronauts
     * - Rocket/Ship Inventory
     * - Launch
     * - Quit
    do {
        System.out.println(String for main menu);
        int choice = kbd.nextInt();
        switch (choice) {
            case 1:
                do {
                    System.out.println(astro menu);
                    int choice2 = kbd.nextInt();
                    int field;
                    switch (choice2) {
                    case 1:
                        System.out.print("Please enter the astronaut's full name (First Last): ")
                        String astroname = (kbd.nextLine()).trim(); I don't know if that works?
                        System.out.print("Please enter the astronaut's date of birth (DD/MM/YYYY): ");
                        String astroDateOfBirth = (kbd.nextLine()).trim();
                        System.out.print("Please enter the astronaut's address ():");
                        String astroAddress = (kbd.nextLine()).trim();
                        System.out.print("Please enter the astronaut's email: ");
                        String astroEmail = (kbd.nextLine()).trim();
                        System.out.print("Please enter the astronaut's phone number: ");
                        String astroPhone = (kbd.nextLine()).trim();
                        System.out.print("Please enter the full name of the astronaut's next of kin: ");
                        String astroNextOfKin = (kbd.nextLine()).trim();
                        System.out.print("Please enter the astronaut's planetary status (On Earth/In Space): ");
                        String astroStatus = (kbd.nextLine()).trim();
                        System.out.print("Please enter the astronaut's pay rate: ");
                        double astroPayRate = kbd.nextDouble();
                        System.out.print("Please enter the astronaut's weight: ");
                        double astroWeight = kbd.nextDouble();
                        System.out.println("Please verify information before saving:\n" +
                                           "Name: " + astroName + "\n" +
                                           "Date of Birth: " + astroDateOfBirth + "\n" +
                                           "Address: " + astroAddress + "\n" +
                                           "Email: " + astroEmail + "\n" +
                                           "Phone Number: " + astroPhone + "\n" +
                                           "Next of Kin: " + astroNextOfKin + "\n" +
                                           "Status: " + astroStatus + "\n" +
                                           "Pay Rate: " + astroPayRate + "\n" +
                                           "Weight: " + astroWeight);
                        do {
                            System.out.println("Please verify information before saving.\n" +
                                           "Name: " + astroName + "\n" +
                                           "Date of Birth: " + astroDateOfBirth + "\n" +
                                           "Address: " + astroAddress + "\n" +
                                           "Email: " + astroEmail + "\n" +
                                           "Phone Number: " + astroPhone + "\n" +
                                           "Next of Kin: " + astroNextOfKin + "\n" +
                                           "Status: " + astroStatus + "\n" +
                                           "Pay Rate: " + astroPayRate + "\n" +
                                           "Weight: " + astroWeight);
                            System.out.println("Is there anything you wish to change? (yes/no)");
                            String change = (kbd.nextLine()).trim();
                            if (change.equalsIgnoreCase("yes")) {
                                System.out.println("Which field do you wish to change?");
                                System.out.println("1. Name\n" +
                                                   "2. Date of Birth\n" +
                                                   "3. Address\n" +
                                                   "4. Email\n" + 
                                                   "5. Phone Number\n" +
                                                   "6. Next of Kin\n" +
                                                   "7. Status\n" +
                                                   "8. Pay Rate\n" +
                                                   "9. Weight\n" +);
                                System.out.print("Please enter the corresponding integer: ");
                                field = kbd.nextInt();
                                switch (field) {
                                    case 1:
                                        System.out.print("Please enter the astronaut's full name (First Last): ")
                                        String astroname = (kbd.nextLine()).trim();
                                        break;
                                    
                                    case 2:
                                        System.out.print("Please enter the astronaut's date of birth (DD/MM/YYYY): ");
                                        String astroDateOfBirth = (kbd.nextLine()).trim();
                                        break;

                                    case 3:
                                        System.out.print("Please enter the astronaut's address ():");
                                        String astroAddress = (kbd.nextLine()).trim();
                                        break;

                                    case 4: 
                                        System.out.print("Please enter the astronaut's email: ");
                                        String astroEmail = (kbd.nextLine()).trim();
                                        break;

                                    case 5: 
                                        System.out.print("Please enter the astronaut's phone number: ");
                                        String astroPhone = (kbd.nextLine()).trim();
                                        break;

                                    case 6: 
                                        System.out.print("Please enter the full name of the astronaut's next of kin: ");
                                        String astroNextOfKin = (kbd.nextLine()).trim();
                                        break;

                                    case 7: 
                                        System.out.print("Please enter the astronaut's planetary status (On Earth/In Space): ");
                                        String astroStatus = (kbd.nextLine()).trim();
                                        break;

                                    case 8: 
                                        System.out.print("Please enter the astronaut's pay rate: ");
                                        double astroPayRate = kbd.nextDouble();
                                        break;

                                    case 9: 
                                        System.out.print("Please enter the astronaut's weight: ");
                                        double astroWeight = kbd.nextDouble();
                                        break;

                                    default: 
                                        System.out.println("Please enter a number 1-9.")
                                        break;
                                }
                                
                            }
                        } while (!change.equalsIgnoreCase("no"));
                        Astronaut astro = new Astronaut();
                        code saving astro to separate file/database
                        break;

                    case 2:
                        code for editing astro
                        break;

                    case 3:
                        code for deleting astro
                        break;

                    case 4:
                        System.out.println("Going back to main menu.")
                        break;

                    default:
                        while (choice2 > 4 || choice2 < 1) {
                            System.out.println("Please enter a number from 1-4");
                        }
                        break;
                    }
                } while ( != 4);
                break;

            case 2:
                * Rocket/Ship menu
                * - Add
                * - Edit info
                * - Delete 
                do{
                    System.out.println(string for rocket/ship menu);
                    int choice2 = kbd.nextInt();
                    int field;
                    switch (choice2) {
                        case 1:
                            System.out.println("Please enter the ship's name: ");
                            String shipName = (kbd.nextLine()).trim();
                            System.out.println("Please enter the ship's fuel capacity: ");
                            double shipFuelCapacity = kbd.nextDouble();
                            System.out.println("Please enter the ship's current fuel level: ");
                            double shipCurrentFuel = kbd.nextDouble();
                            System.out.println("Please enter the ship's crew capacity: ");
                            int shipCrewCapacity = kbd.nextInt();
                            do {
                                System.out.println("Please verify information before saving.\n" +
                                                   "Name: " + shipName + "\n" +
                                                   "Fuel Capacity: " + shipFuelCapacity + "\n" +
                                                   "Current Fuel: " + shipCurrentFuel + "\n" +
                                                   "Crew Capacity: " + shipCrewCapacity);
                                System.out.println("Is there anything you wish to change? (yes/no)");
                                String change = (kbd.nextLine).trim();
                                if (change.equalsIgnoreCase("yes")) {
                                    System.out.println("Which field do you wish to change?");
                                    System.out.println("1. Name" +
                                                       "2. Fuel Capacity" +
                                                       "3. Current Fuel" +
                                                       "4. Crew Capacity");
                                    System.out.print("Please enter the corresponding number: ");
                                    field = nextInt();
                                    switch (field) {
                                        case 1:
                                        System.out.println("Please enter the ship's name: ");
                                        String shipName = (kbd.nextLine()).trim();
                                        break;

                                        case 2:
                                        System.out.println("Please enter the ship's fuel capacity: ");
                                        double shipFuelCapacity = kbd.nextDouble();
                                        break;

                                        case 3:
                                        System.out.println("Please enter the ship's current fuel level: ");
                                        double shipCurrentFuel = kbd.nextDouble();
                                        break;

                                        case 4:
                                        System.out.println("Please enter the ship's crew capacity: ");
                                        int shipCrewCapacity = kbd.nextInt();
                                        break;

                                        default:
                                        System.out.println("Please enter a number 1-4");
                                        break;
                                    }
                                }
                            } while (!change.equalsCaseIgnore("no"));
                            break;

                        case 2:
                            code for editing existing ship
                            break;

                        case 3:
                            code for deleting a ship
                            break;

                        case 4:
                            System.out.println("Going back to main menu.")
                            break;

                        default:
                            ask for valid number
                            break;
                    }
                } while ( != 4)
                break;

            case 3:
                * - Fuel? (Does it make more sense for fuel to be here or in the ship inventory?)
                * - Launch
                do {
                    System.out.println(string for launch menu);
                    int choice2 = kbd.nextInt();
                    switch (choice2) {
                        case 1:
                            code for checking & adding fuel
                            break;

                        case 2:
                            code for launch
                            break;

                        case 3:
                            System.out.println("Going back to main menu.")
                            break;

                        default:
                            ask for valid number
                            break;
                    }
                } while ( != 4)
                break;

            case 4:
                System.out.println();
                break;

            default:
                break;
        }
    }*/

    //Close scanners and program
}
}
