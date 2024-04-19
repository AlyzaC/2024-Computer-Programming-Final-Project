import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class main1 {

public static void main(String[] args){
    Astronaut guy = new Astronaut();
    guy.spaceWalk();
    System.out.println(guy.getSerialNumber());
    //Variables & Objects
        String[] shipNames = new String[10]; //Temporary value?
        String mainMenu = "";
        int choice;

    //Temporary Variables/Object
        Astronaut temporaryAstro = new Astronaut();
        Astronaut astro = new Astronaut();
        Ship temporaryShip = new Ship();

    //Scanner
        Scanner kbd = new Scanner(System.in);
     
    // Main menu
    // - Astronauts
    // - Rocket/Ship Inventory
    // - Launch
    // - Quit
    if (LoggingInPassword()) {
        do {
            System.out.println(mainMenu);
            choice = kbd.nextInt();
            int choice2 = 0;
            switch(choice) {
                case 1:
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
                                    System.out.print("Please enter the corresponding option/integer: ");
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
                            
                            astro = new Astronaut();

                            //code saving astro to separate file/database 

                            break;

                        case 2:
                        do {
                        // ask which astronaut the user wants to edit
                            System.out.println("Which astronaut would you like to edit?");

                            //retrieve astronaut from external container
                            
                            //verify that its the correct astronaut
                            System.out.println("Is this the correct astronaut?");
                        
                            //no: ask for the correct astronaut, retrieve, verify again

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
                                                "9. Weight\n" +
                                                "10. Go back");

                            System.out.println("Please select a field");
                            field = kbd.nextInt();
                            switch (field) {
                                case 1:
                                    System.out.print("Please edit the astronaut's full name (First Last): ");
                                    astroName = (kbd.nextLine()).trim();

                                    //pull current value if astronaut does not already exist in code
                                    System.out.println("The astronaut's current name in the database is " + astro.getName() + "\n" +
                                                    "You entered: " + astroName + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                                    String correctAstroName = kbd.nextLine();
                                                    
                                    if (correctAstroName.equalsIgnoreCase("Correct")) {

                                        //Replace the astronaut's name with the new value (astroName)
                                        //change the astro part
                                        //astro.setName(astroName); //this was commented out but i didnt see why so i uncommented it out lol

                                        //Change the name inside the database

                                        //Move on
                                    } else if (correctAstroName.equalsIgnoreCase("Go back")) {
                                        break;
                                    } else {
                                        while (!(correctAstroName.equalsIgnoreCase("Correct")) && !(correctAstroName.equalsIgnoreCase("()"))) {
                                            System.out.println("The astronaut's current name in the database is " + astro.getName() + "\n" +
                                                    "You entered: " + astroName + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter ().");
                                                    correctAstroName = kbd.nextLine();
                                        }
                                    }

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

                                        case 10:
                                            System.out.println("Going back");
                                            break;

                                        default: 
                                            System.out.println("Please enter a number 1-10.");
                                            break;
                                    }

                            //send astronaut back to external container  <-- FILE STUFF !!
                            } while (field != 10);
                            break;
                        
                        case 3:
                        String theKey;
                        do{
                        //   ask for astronaut to delete
                            System.out.println("Which astronaut would you like to delete?");

                        //     pull astronaut and verify that it is the correct one
                        
                        //     no: ask for correct astronaut, verify
                            System.out.println("Who is the correct astronaut?"); //STILL NEED TO VERIFY

                        //     yes: ask for key to delete
                            System.out.println("Type \"yes\" for deletion.\n" +
                                                "If you wish to go back enter \"Go back\".");
                            theKey = kbd.nextLine();
                            if (theKey.equalsIgnoreCase("yes")) {

                                //correct key: delete astronaut, notify user
                                AstroRemoval removeAstro = new AstroRemoval(1);
                                removeAstro.addAstro(temporaryAstro);
                                //removeAstro.removeAstronauts(SQL connection);
                            
                            } else if (theKey.equalsIgnoreCase("Go back")) {
                                break;
                            } else {
                                while (!(theKey.equalsIgnoreCase("yes"))) {
                                    //incorrect key: notify that it is the incorrect key, ask again
                                    System.out.println("Wrong key, try again.");
                                    System.out.println("Type \"yes\" for deletion.");
                                    theKey = kbd.nextLine();
                                }
                                
                            }
                            } while (theKey.equalsIgnoreCase("Go back"));
                            break;

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
                //i dont think i did this menu correctly
                        do{
                        System.out.println("Ship Menu \n" +
                                        "1. Add Ship \n" +
                                        "2. Edit Ship Information \n" +
                                        "3. Delete Ship \n" +
                                        "4. Go Back");
                        choice2 = kbd.nextInt();
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
                                        System.out.println("1. Ship Name" +
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
                                    System.out.println("Fields\n" +
                                                    "1. Ship name\n" +
                                                    "2. Fuel Capacity\n" +
                                                    "3. Fuel\n" +
                                                    "4. Ship Capacity");
                                    field = kbd.nextInt();
                                    switch (field) {
                                        case 1:
                                        String theKey = "";
                                        boolean changeSuccessful = false;
                                        do {
                                            System.out.println("Please edit the ship's name: ");
                                            shipName = (kbd.nextLine()).trim();
                                            String currentShipName = ""; //pull actual value from database
                                            System.out.println("The ship's current name in the database is \'" + currentShipName + "\'.\n" +
                                                            "You entered the name \'" + shipName + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            String correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                
                                                //Replace the ship's name with the new value (shipName)
                                                //change the ship part
                                            // ship.setName(shipName); <-- maybe its suppose to be Ship.setSName(shipName); idk

                                                //Change the name inside the database

                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            } else {
                                                while (!(correct.equalsIgnoreCase("correct")) && !(correct.equalsIgnoreCase("go back"))) {
                                                    System.out.println("Try Again");
                                                    System.out.println("Type \"correct\" to edit.\n" +
                                                                    "Type \"go back\" if you wish to go back");
                                                    theKey = kbd.nextLine();
                                                }
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) || !(changeSuccessful));
                                        
                                        break;

                                        case 2:
                                        System.out.println("Please edit the ship's fuel capacity: ");
                                        shipFuelCapacity = kbd.nextDouble();
                                        break;

                                        case 3:
                                        System.out.println("Please edit the ship's current fuel level: ");
                                        shipCurrentFuel = kbd.nextDouble();
                                        break;

                                        case 4:
                                        System.out.println("Please edit the ship's crew capacity: ");
                                        shipCrewCapacity = kbd.nextInt();
                                        break;

                                        default:
                                        System.out.println("Please enter a number 1-4");
                                        break;
                                    }

                                // send ship back to external container

                                break;

                            case 3:
                                // ask for ship to delete
                                System.out.println("What ship would you like to delete?");

                                // pull ship and verify that it is the correct one

                                // no: ask for correct ship, verify

                                // yes: ask for key to delete
                                System.out.println("Type \"yes\" for deletion.\n" +
                                                "If you wish to go back enter \"Go back\".");
                            String theKey = kbd.nextLine();
                            if (theKey.equalsIgnoreCase("yes")) {

                                // *** NEED A WAY TO DELETE THE SHIP ***
                                //ShipRemoval removeShip = new ShipRemoval(ship);
                                //removeShip.removeShip(SQL connection);
                                
                            }

                                // incorrect key: notify that it is the incorrect key, ask again
                                System.out.println("Wrong key");
                                System.out.println("Type \"THIS NEEDS TO HAVE A KEY\" for deletion.");   //this needs to be edited

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
                                        System.out.println(count + ". " + s);
                                    }
                                }
                                System.out.print("Please enter the corresponding number: ");
                                int shipChoice = kbd.nextInt();
                                String verify = "";
                                do {
                                    System.out.println("Ship selected: " + shipNames[shipChoice]);
                                    System.out.println("Is this the correct ship? (yes/no)");
                                    if (verify.equalsIgnoreCase("no")) {
                                        System.out.println("Please select a ship to launch:");
                                        count = 0;
                                        for (String s : shipNames) {
                                            if (s != null) {
                                                count++;
                                                System.out.println(count + ". " + s);
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
                                        temporaryShip.setSName(shipName);
                                        break;

                                    case 2:
                                        System.out.println("Please enter the ship's fuel capacity: ");
                                        double shipFuelCapacity = kbd.nextDouble();
                                        temporaryShip.setFCap(shipFuelCapacity);
                                        break;

                                    case 3:
                                        System.out.println("Please enter the ship's current fuel level: ");
                                        double shipCurrentFuel = kbd.nextDouble();
                                        temporaryShip.setFuel(shipCurrentFuel);
                                        break;

                                    case 4:
                                        System.out.println("Please enter the ship's crew capacity: ");
                                        int shipCrewCapacity = kbd.nextInt();
                                        temporaryShip.setSCap(shipCrewCapacity);
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
    }
    

    kbd.close();
    System.exit(0);
}

    public static boolean LoggingInPassword() {

        boolean createPassword = true;
        boolean allowedEntry = false;

        File file = new File("ApplicationPassword.csv");
        int applicationPassword = -800;
        if (file.exists()) {
            try {
                FileInputStream passFile = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(passFile);
                applicationPassword = (int) ois.readObject();
                ois.close();
                passFile.close();
                createPassword = false;
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("An error occured: " + e.getMessage());
            }
            
        }

        Scanner kbd2 = new Scanner(System.in);

         createPassword = true;
        if (createPassword) {

            int passNum = -496108;

            createPassword = false;
            try {
                file.createNewFile();
                FileOutputStream passFile = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(passFile);
                oos.writeObject(passNum);
                oos.close();
                passFile.close();
                createPassword = false;
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("An error occured: " + e.getMessage());
            }
            
    
            // Login
            // * First time application is run (THIS PART IS (I HOPE) DONE)

            // * - Create password and display for user to write down
            System.out.println("Creating Password...");

            Random r = new Random();
             passNum = 0;
            for (int i = 0; i < 1; i++) {
                passNum = r.nextInt(20000);
                System.out.println("Please write down the following password: " + passNum);
            }
            // * - Notify user of account creation and move on
            System.out.println("*Account Created*");

            // * Any time after 1st
            createPassword = false;
        } else {
            // ask for password or to reset password with the administrator password
            int loginChoice = kbd2.nextInt();
            switch (loginChoice) {
                case 1:
                    System.out.println("Please enter the password for the application: ");
                    int enteredPassword = kbd2.nextInt();
                    if (enteredPassword == applicationPassword) {
                        allowedEntry = true;
                    } else {
                        String choice3;
                        while (!(enteredPassword == applicationPassword)) {

                            //* notify that the incorrect password has been entered
                            // ask for password again and give option to go back
                            System.out.println("You input the wrong password.");
                            System.out.println("Reenter the password or type \"Go back\"");
                            //use a scanner to edit
                            choice3 = kbd2.nextLine();
                            if (choice3.equalsIgnoreCase("Go back")) {
                                break;
                            } else {
                                enteredPassword = Integer.parseInt(choice3);
                            }
                        }
                    }
                    break;
    
                case 2:
                    // ask for adminPass
                    int trueAdminPass = -298756;
                    int adminPass = kbd2.nextInt();
                    File adminFile = new File("adminPassword.dat");
                    try {
                        FileInputStream adminPassFile = new FileInputStream(adminFile);
                        trueAdminPass = adminPassFile.read();
                        adminPassFile.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    } catch (IOException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    
                    if (adminPass == trueAdminPass) {
                        // create a new password for application and show it to user to write down
                        System.out.println("Creating Password...");

                        Random r = new Random();
                         int passNum = 0;
                        for (int i = 0; i < 1; i++) {
                            passNum = r.nextInt(20000);
                            System.out.println("Please write down the following password: " + passNum);
                        }

                        allowedEntry = true;
                    } else {
                        while (!(adminPass == trueAdminPass)) {

                            // notify that incorrect pass has been entered
                            // ask for pass again and give option to go back
                            System.out.println("You input the wrong password.");
                            System.out.println("Reenter the password or type \"Go back\"");
                            //use the scanner to get input -- 
                            String inputA = kbd2.nextLine();

                           if (inputA.equalsIgnoreCase("Go back")) {
                                break;
                            } else {
                                adminPass = Integer.parseInt(inputA);
                            }
                        }
                    }
                    break;
    
                default:
                    while ((loginChoice != 1) && (loginChoice != 2)) {
                        System.out.println("Please enter the number 1 or 2.");
                       // ask for password or to reset password with the administrator password
                        loginChoice = kbd2.nextInt();
                    }
                    break;
            }
        }

            // * - give option to reset password using administrator password
            System.out.println("Do you wish to reset the password with using the adminstartor password?");

            // * - - ask for administrator password and verify
            // * - - reset password 
            // * - verify password (THIS PART IS DONE)

            // I'm not sure how to have the computer remember the password
            // * - - move on if valid
            kbd2.close();
            return allowedEntry;
        }
    }