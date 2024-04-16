import java.util.Random;
import java.util.Scanner;

public class main1 {

public static void main(String[] args){
    Astronaut guy = new Astronaut();
    guy.spaceWalk();
    System.out.println(guy.getSerialNumber());
    //Variables & Objects
        String[] shipNames;
        String mainMenu = "";
        int choice;

    //Scanner
        Scanner kbd = new Scanner(System.in);
     
    // Main menu
    // - Astronauts
    // - Rocket/Ship Inventory
    // - Launch
    // - Quit
    do {
        System.out.println(mainMenu);
        choice = kbd.nextInt();
         switch(choice) {
            case 1:
                int choice2;
                do {
                   System.out.println("Menu:");
                    choice2 = kbd.nextInt();
                    int field;
                    switch (choice2) {
                    case 1:
                        System.out.print("Please enter the astronaut's full name (First Last): ");
                        String astroName = (kbd.nextLine()).trim(); // I don't know if that works?
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
                        String change;
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
                            change = (kbd.nextLine()).trim();
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
                                                   "9. Weight\n" );
                                System.out.print("Please enter the corresponding integer: ");
                                field = kbd.nextInt();
                                switch (field) {
                                    case 1:
                                        System.out.print("Please enter the astronaut's full name (First Last): ");
                                         astroName = (kbd.nextLine()).trim();
                                        break;
                                    
                                    case 2:
                                        System.out.print("Please enter the astronaut's date of birth (DD/MM/YYYY): ");
                                         astroDateOfBirth = (kbd.nextLine()).trim();
                                        break;

                                    case 3:
                                        System.out.print("Please enter the astronaut's address ():");
                                         astroAddress = (kbd.nextLine()).trim();
                                        break;

                                    case 4: 
                                        System.out.print("Please enter the astronaut's email: ");
                                         astroEmail = (kbd.nextLine()).trim();
                                        break;

                                    case 5: 
                                        System.out.print("Please enter the astronaut's phone number: ");
                                         astroPhone = (kbd.nextLine()).trim();
                                        break;

                                    case 6: 
                                        System.out.print("Please enter the full name of the astronaut's next of kin: ");
                                         astroNextOfKin = (kbd.nextLine()).trim();
                                        break;

                                    case 7: 
                                        System.out.print("Please enter the astronaut's planetary status (On Earth/In Space): ");
                                         astroStatus = (kbd.nextLine()).trim();
                                        break;

                                    case 8: 
                                        System.out.print("Please enter the astronaut's pay rate: ");
                                         astroPayRate = kbd.nextDouble();
                                        break;

                                    case 9: 
                                        System.out.print("Please enter the astronaut's weight: ");
                                         astroWeight = kbd.nextDouble();
                                        break;

                                    default: 
                                        System.out.println("Please enter a number 1-9.");
                                        break;
                                }
                                
                            }
                        }  while (!change.equalsIgnoreCase("no"));
                        
                       Astronaut astro = new Astronaut();

                        //code saving astro to separate file/database

                        break;

                    case 2:
                    do{
                       // ask which astronaut the user wants to edit
                        System.out.println("Which astronaut would you like to edit?");

                        //retrieve astronaut from external container
                        
                        //verify that its the correct astronaut
                        System.out.println("This is the correct astronaut?");
                       
                        //no: ask for the correct astronaut, retrieve, verify again
                        System.out.println("");

                        //yes: ask what field to edit, verify, ask for new value, verify, edit info, notify
                        System.out.println("Field" +
                                            "1. Name\n" +
                                            "2. Date of Birth\n" + 
                                            "3. Address\n" +
                                            "4. Email\n" +
                                            "5. Phone Number\n" + 
                                            "6. Next of Kin\n" +
                                            "7. Status\n" +
                                            "8. Pay Rate\n" +
                                            "9. Weight\n");

                        System.out.println("Please select a field");
                        field = kbd.nextInt();
                        switch (field) {
                            case 1:
                                System.out.print("Please edit the astronaut's full name (First Last): ");
                                astroName = (kbd.nextLine()).trim();
                                break;
                                    
                                    case 2:
                                        System.out.print("Please edit the astronaut's date of birth (DD/MM/YYYY): ");
                                         astroDateOfBirth = (kbd.nextLine()).trim();
                                        break;

                                    case 3:
                                        System.out.print("Please edit the astronaut's address ():");
                                         astroAddress = (kbd.nextLine()).trim();
                                        break;

                                    case 4: 
                                        System.out.print("Please edit the astronaut's email: ");
                                         astroEmail = (kbd.nextLine()).trim();
                                        break;

                                    case 5: 
                                        System.out.print("Please edit the astronaut's phone number: ");
                                         astroPhone = (kbd.nextLine()).trim();
                                        break;

                                    case 6: 
                                        System.out.print("Please edit the full name of the astronaut's next of kin: ");
                                         astroNextOfKin = (kbd.nextLine()).trim();
                                        break;

                                    case 7: 
                                        System.out.print("Please edit the astronaut's planetary status (On Earth/In Space): ");
                                         astroStatus = (kbd.nextLine()).trim();
                                        break;

                                    case 8: 
                                        System.out.print("Please edit the astronaut's pay rate: ");
                                         astroPayRate = kbd.nextDouble();
                                        break;

                                    case 9: 
                                        System.out.print("Please edit the astronaut's weight: ");
                                         astroWeight = kbd.nextDouble();
                                        break;

                                    default: 
                                        System.out.println("Please enter a number 1-9.");
                                        break;
                                }

                        //send astronaut back to external container  <-- idk what this means or if i have to do anything with it
                    }
                        break;
                    
                      case 3:
                      do{
                    //   ask for astronaut to delete
                         System.out.println("Which astronaut would you like to delete?");

                    //     pull astronaut and verify that it is the correct one
                    
                    //     no: ask for correct astronaut, verify
                           System.out.println("Who is the correct astronaut?");

                    //     yes: ask for key to delete
                           System.out.println("Please provide the key for deletion.");

                    //     incorrect key: notiy that it is the incorrect key, ask again
                    //     correct key: delete astronaut, notify user

                         break;
                      }
                    case 4:
                        System.out.println("Going back to main menu.");
                        break;

                    default:
                        System.out.println("Please enter a number from 1-4");
                    }
                } while (choice2 != 4);
                break;

                case 2:
            //     * Rocket/Ship menu
            //     * - Add
            //     * - Edit info
            //     * - Delete 
                    do{
                    //**LINE AFTER THIS NEEDS TO BE EDITED**  
                    //System.out.println(string for rocket/ship menu);
                    //choice2 = kbd.nextInt(write in choices. 1. title 2. title, 3. title, etc.);
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
                            String change = "";
                            do {
                                System.out.println("Please verify information before saving.\n" +
                                                   "Name: " + shipName + "\n" +
                                                   "Fuel Capacity: " + shipFuelCapacity + "\n" +
                                                   "Current Fuel: " + shipCurrentFuel + "\n" +
                                                   "Crew Capacity: " + shipCrewCapacity);
                                System.out.println("Is there anything you wish to change? (yes/no)");
                                String c = kbd.nextLine();
                                change = c.trim();
                                if (change.equalsIgnoreCase("yes")) {
                                    System.out.println("Which field do you wish to change?");
                                    System.out.println("1. Name" +
                                                       "2. Fuel Capacity" +
                                                       "3. Current Fuel" +
                                                       "4. Crew Capacity");
                                    System.out.print("Please enter the corresponding number: ");
                                    field = kbd.nextInt();
                                    switch (field) {
                                        case 1:
                                        System.out.println("Please enter the ship's name: ");
                                        shipName = (kbd.nextLine()).trim();
                                        break;

                                        case 2:
                                        System.out.println("Please enter the ship's fuel capacity: ");
                                        shipFuelCapacity = kbd.nextDouble();
                                        break;

                                        case 3:
                                        System.out.println("Please enter the ship's current fuel level: ");
                                        shipCurrentFuel = kbd.nextDouble();
                                        break;

                                        case 4:
                                        System.out.println("Please enter the ship's crew capacity: ");
                                        shipCrewCapacity = kbd.nextInt();
                                        break;

                                        default:
                                        System.out.println("Please enter a number 1-4");
                                        break;
                                    }
                                }
                            } while (!change.equalsIgnoreCase("no"));
                            break;

                          case 2:
                            // ask which ship the user wants to edit
                            System.out.println("What ship would you like to edit?");
                            // retrieve ship from external container

                            // verify that its the correct ship

                            // no: ask for the correct ship, retrieve, verify again
                            // yes: ask what field to edit, verify, ask for new value, verify, edit info, notify

                            // send ship back to external container

                            break;

                        case 3:
                            // ask for ship to delete
                            System.out.println("What ship would you like to delete?");
                            // pull ship and verify that it is the correct one

                            // no: ask for correct ship, verify
                            // yes: ask for key to delete
                            // incorrect key: notiy that it is the incorrect key, ask again
                            // correct key: delete ship, notify user

                            break;

                        case 4:
                            System.out.println("Going back to main menu.");
                            break;

                        default:
                            System.out.println("Please enter a number 1-4.");
                            break;
                    }
                } while (choice != 4);

                break;

            case 3:
                // * - Select a ship
                // * - Back
                do {
                    System.out.println("1. Select a Ship\n" +
                                       "2. Back to main menu");
                     choice2 = kbd.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.println("Please select a ship to launch.");
                            int count = 0;
                            for (String s : shipNames) {
                                if (s != null) {
                                    count++;
                                    System.out.println(count + ". " + s.getName());
                                }
                            }
                            System.out.print("Please enter the corresponding number: ");
                            int shipChoice = kbd.nextInt();
                            String verify;
                            do {
                                System.out.println("Ship selected: " + shipNames[shipChoice]);
                                System.out.println("Is this the correct ship? (yes/no)");
                                if (verify.equalsIgnoreCase("no")) {
                                    System.out.println("Please select a ship to launch:");
                                    count = 0;
                                    for (String s : shipNames) {
                                        if (s != null) {
                                            count++;
                                            System.out.println(count + ". " + s.getName());
                                        }
                                    shipChoice = kbd.nextInt();
                                    }
                                }
                            } while (!verify.equalsIgnoreCase("yes"));
                            //retrieve ship
                            System.out.println("Please select a field.");
                            System.out.println("1. Name\n" +
                                               "2. Fuel Capacity\n" +
                                               "3. Current Fuel\n" +
                                               "4. Crew Capacity");
                            System.out.print("Please enter the corresponding number:");
                            int field = kbd.nextInt();
                            do {
                                System.out.println("Field selected: " + field);
                                System.out.println("Is this the correct field? (yes/no)");
                                String v = kbd.nextLine();
                                verify = v.trim();
                                if (verify.equalsIgnoreCase("no")) {
                                    System.out.println("Please select a field.");
                                    System.out.println("1. Name\n" +
                                                       "2. Fuel Capacity\n" +
                                                       "3. Current Fuel\n" +
                                                       "4. Crew Capacity");
                                    field = kbd.nextInt();
                                }
                            } while (!verify.equalsIgnoreCase("yes"));
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
                            // edit ship info
                            // notify user
                            // move ship to external container
                            break;

                        case 2:
                            System.out.println("Going back to main menu.");
                            break;

                        default:
                            System.out.println("Please enter a number 1-2.");
                            break;
                    }
                    break;
                } while (choice2 != 2);

            case 4:
                System.out.println("Closing program now.");
                break;

            default:
                System.out.println("Please select a number 1-4");
                break;
        }
    } while (choice != 4);

    kbd.close();
    System.exit(0);
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