import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class main1 {

public static void main(String[] args){
    //Variables & Objects
        Ship[] ships = new Ship[10]; //Temporary value?
        Astronaut[] astros = new Astronaut[20]; //temporary value?
        int choice;
        int choice2;

    //Scanner
        Scanner kbd = new Scanner(System.in);
     

    //Code for getting astros and ships from database

    // Main menu
    // - Astronauts
    // - Rocket/Ship Inventory
    // - Launch
    // - Quit
    if (LoggingInPassword(kbd)) {
        do {
            System.out.println("Main Menu\n" +
                               "1. Astronauts\n" +
                               "2. Ships\n" + 
                               "3. Launch");
            choice = kbd.nextInt();
            switch(choice) {
                case 1:
                    do {
                    System.out.println("Astronaut Menu\n" + 
                                       "1. Add Astronaut\n" +
                                       "2. Edit Astronaut\n" +
                                       "3. Delete Astronaut\n" +
                                       "4. Go Back");
                        choice2 = kbd.nextInt();
                        int field;
                        switch (choice2) {
                        case 1:
                            System.out.print("Please enter the astronaut's full name (First Last): ");
                            kbd.nextLine();
                            String astroName = kbd.nextLine().trim();
                            System.out.print("Please enter the astronaut's date of birth (DD/MM/YYYY): ");
                            String astroDateOfBirth = (kbd.nextLine()).trim();
                            System.out.print("Please enter the astronaut's address: ");
                            String astroAddress = (kbd.nextLine()).trim();
                            System.out.print("Please enter the astronaut's email (name@example.com): ");
                            String astroEmail = (kbd.nextLine()).trim();
                            System.out.print("Please enter the astronaut's phone number [(XXX)XXX-XXXX]: ");
                            String astroPhone = (kbd.nextLine()).trim();
                            System.out.print("Please enter the full name of the astronaut's next of kin: ");
                            String astroNextOfKin = (kbd.nextLine()).trim();
                            System.out.print("Please enter the astronaut's planetary status (On Earth/In Space): ");
                            String astroStatus = (kbd.nextLine()).trim();
                            System.out.print("Please enter the astronaut's pay rate (X,XXX.XX): ");
                            double astroPayRate = kbd.nextDouble();
                            System.out.print("Please enter the astronaut's weight in pounds: ");
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
                                            kbd.nextLine();
                                            astroName = (kbd.nextLine()).trim();
                                            break;
                                        
                                        case 2:
                                            System.out.print("Please enter the astronaut's date of birth (DD/MM/YYYY): ");
                                            kbd.nextLine();
                                            astroDateOfBirth = (kbd.nextLine()).trim();
                                            break;

                                        case 3:
                                            System.out.print("Please enter the astronaut's address: ");
                                            kbd.nextLine();
                                            astroAddress = (kbd.nextLine()).trim();
                                            break;

                                        case 4: 
                                            System.out.print("Please enter the astronaut's email (name@example.com): ");
                                            kbd.nextLine();
                                            astroEmail = (kbd.nextLine()).trim();
                                            break;

                                        case 5: 
                                            System.out.print("Please enter the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                            kbd.nextLine();
                                            astroPhone = (kbd.nextLine()).trim();
                                            break;

                                        case 6: 
                                            System.out.print("Please enter the full name of the astronaut's next of kin: ");
                                            kbd.nextLine();
                                            astroNextOfKin = (kbd.nextLine()).trim();
                                            break;

                                        case 7: 
                                            System.out.print("Please enter the astronaut's planetary status (On Earth/In Space): ");
                                            kbd.nextLine();
                                            astroStatus = (kbd.nextLine()).trim();
                                            break;

                                        case 8: 
                                            System.out.print("Please enter the astronaut's pay rate (X,XXX.XX): ");
                                            kbd.nextLine();
                                            astroPayRate = kbd.nextDouble();
                                            break;

                                        case 9: 
                                            System.out.print("Please enter the astronaut's weight in pounds: ");
                                            kbd.nextLine();
                                            astroWeight = kbd.nextDouble();
                                            break;

                                        default: 
                                            System.out.println("Please enter a number 1-9.");
                                            break;
                                    }
                                    
                                }
                            }  while (!change.equalsIgnoreCase("no"));
                            
                            for (int count = 0; count < astros.length; count++) {
                                if (astros[count] == null) {
                                    astros[count] = new Astronaut(astroName, astroDateOfBirth, astroAddress, astroEmail, astroPhone, astroNextOfKin, astroStatus, astroPayRate, astroWeight);
                                }
                            }

                            //code saving astro to separate file/database 

                            break;

                        case 2:
                            do {
                                Astronaut astroToEdit;
                                // ask which astronaut the user wants to edit
                                System.out.println("Which astronaut would you like to edit?");
                                int count = 0;
                                for (Astronaut a : astros) {
                                    if (a != null) {
                                        count++;
                                        System.out.println(count + " " + a.getName() + "\n");
                                    }
                                }
                                kbd.nextLine();
                                int astroChoice = kbd.nextInt();
                                String astroConfirmation = "";
                                //verify that its the correct astronaut
                                do {
                                    System.out.println("Chosen astronaut: " + astros[astroChoice - 1].getName());
                                    System.out.println("Is this the correct astronaut? (Yes/No)");
                                    kbd.nextLine();
                                    astroConfirmation = (kbd.nextLine()).trim();
                                    if (astroConfirmation.equalsIgnoreCase("no")) {
                                        count = 0;
                                        for (Astronaut a : astros) {
                                            if (a != null) {
                                                count++;
                                                System.out.println(count + " " + a.getName() + "\n");
                                            }
                                        }
                                        kbd.nextLine();
                                        astroChoice = kbd.nextInt();
                                    }
                                } while (!astroConfirmation.equalsIgnoreCase("yes"));
    
                                astroToEdit = astros[astroChoice - 1];
                                System.out.println("This is the current information for " + astroToEdit.getName());
                                System.out.println("Name: " + astroToEdit.getName() + "\n" +
                                                   "Serial Number: " + astroToEdit.getSerialNumber() + "\n" +
                                                   "Date of Birth: " + astroToEdit.dateOfBirth() + "\n" + 
                                                   "Address: " + astroToEdit.address() + "\n" +
                                                   "Email: " + astroToEdit.email() + "\n" +
                                                   "Phone Number: " + astroToEdit.phoneNumber() + "\n" + 
                                                   "Next of Kin: " + astroToEdit.nextOfKin() + "\n" +
                                                   "Status: " + astroToEdit.status() + "\n" +
                                                   "Pay Rate: " + astroToEdit.payRate() + "\n" +
                                                   "Weight: " + astroToEdit.weight());
                                
                                //yes: ask what field to edit, verify, ask for new value, verify, edit info, notify
                                System.out.println("Field\n" +
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
                                kbd.nextLine();
                                field = kbd.nextInt();
                                switch (field) {
                                    case 1:
                                        System.out.print("Please edit the astronaut's full name (First Last): ");
                                        kbd.nextLine();
                                        astroName = (kbd.nextLine()).trim();
    
                                        //pull current value if astronaut does not already exist in code
                                        
                                        String correctAstroName = "";
                                        do {
                                            System.out.println("The astronaut's current name in the database is " + astroToEdit.getName() + "\n" +
                                                        "You entered: " + astroName + "\n" +
                                                        "If this correct, please enter \"Correct\".\n" +
                                                        "If you wish to go back enter \"Go back\".");
                                            kbd.nextLine();
                                            correctAstroName = kbd.nextLine();
                                            if (correctAstroName.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setName(astroName);
    
                                                //Change the name inside the database
    
                                                //Move on
                                            } else if (correctAstroName.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                System.out.print("Please edit the astronaut's full name (First Last): ");
                                                kbd.nextLine();
                                                astroName = (kbd.nextLine()).trim();
                                            }
                                        } while (!correctAstroName.equalsIgnoreCase("correct"));
                                        break;
                                        
                                case 2:
                                    System.out.print("Please edit the astronaut's date of birth (DD/MM/YYYY): ");
                                    kbd.nextLine();
                                    astroDateOfBirth = (kbd.nextLine()).trim();
                                    String correct = "";
                                    do {
                                        System.out.println("The astronaut's current date of birth in the database is " + astroToEdit.dateOfBirth() + "\n" +
                                                    "You entered: " + astroDateOfBirth + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setdateOfBirth(astroDateOfBirth);

                                            //Change the DOB inside the database

                                            //Move on
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the astronaut's date of birth (DD/MM/YYYY): ");
                                            kbd.nextLine();
                                            astroDateOfBirth = (kbd.nextLine()).trim();
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 3:
                                    System.out.print("Please edit the astronaut's address:");
                                    kbd.nextLine();
                                    astroAddress = (kbd.nextLine()).trim();
                                    String correct = "";
                                    do {
                                        System.out.println("The astronaut's current address in the database is " + astroToEdit.address() + "\n" +
                                                    "You entered: " + astroAddress + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setAddress(astroAddress);

                                            //Change the address inside the database

                                            //Move on
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the astronaut's address: ");
                                            kbd.nextLine();
                                            astroAddress = (kbd.nextLine()).trim();
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 4: 
                                    System.out.print("Please edit the astronaut's email (name@example.com): ");
                                    kbd.nextLine();
                                    astroEmail = (kbd.nextLine()).trim();
                                    String correct = "";
                                    do {
                                        System.out.println("The astronaut's current email in the database is " + astroToEdit.email() + "\n" +
                                                    "You entered: " + astroEmail + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setEmail(astroEmail);

                                            //Change the email inside the database

                                            //Move on
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the astronaut's email (name@example.com): ");
                                            kbd.nextLine();
                                            astroEmail = (kbd.nextLine()).trim();
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 5: 
                                    System.out.print("Please edit the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                    kbd.nextLine();
                                    astroPhone = (kbd.nextLine()).trim();
                                    String correct = "";
                                    do {
                                        System.out.println("The astronaut's current phone number in the database is " + astroToEdit.phoneNumber() + "\n" +
                                                    "You entered: " + astroPhone + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setPhoneNumber(astroPhone);

                                            //Change the phone number inside the database

                                            //Move on
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                            kbd.nextLine();
                                            astroPhone = (kbd.nextLine()).trim();
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 6: 
                                    System.out.print("Please edit the full name of the astronaut's next of kin: ");
                                    kbd.nextLine();
                                    astroNextOfKin = (kbd.nextLine()).trim();
                                    String correct = "";
                                    do {
                                        System.out.println("The astronaut's current next of kin in the database is " + astroToEdit.nextOfKin() + "\n" +
                                                        "You entered: " + astroNextOfKin + "\n" +
                                                        "If this correct, please enter \"Correct\".\n" +
                                                        "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.nextOfKin(astroNextOfKin);
    
                                            //Change the next of kin inside the database
    
                                            //Move on
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the full name of the astronaut's next of kin: ");
                                            kbd.nextLine();
                                            astroDateOfBirth = (kbd.nextLine()).trim();
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 7: 
                                    System.out.print("Please edit the astronaut's planetary status (On Earth/In Space): ");
                                    kbd.nextLine();
                                    astroStatus = (kbd.nextLine()).trim();
                                    String correct = "";
                                    do {
                                        System.out.println("The astronaut's current planetary status in the database is " + astroToEdit.status() + "\n" +
                                                        "You entered: " + astroStatus + "\n" +
                                                        "If this correct, please enter \"Correct\".\n" +
                                                        "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setStatus(astroStatus);
    
                                            //Change the status inside the database
    
                                            //Move on
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the astronaut's planetary status (On Earth/In Space): ");
                                            kbd.nextLine();
                                            astroStatus = (kbd.nextLine()).trim();
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 8: 
                                    System.out.print("Please edit the astronaut's pay rate (X,XXX.XX): ");
                                    kbd.nextLine();
                                    astroPayRate = kbd.nextDouble();
                                    String correct = "";
                                    do {
                                        System.out.println("The astronaut's current pay rate in the database is " + astroToEdit.payRate() + "\n" +
                                                        "You entered: " + astroPayRate + "\n" +
                                                        "If this correct, please enter \"Correct\".\n" +
                                                        "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setPayRate(astroPayRate);
    
                                            //Change the pay rate inside the database
    
                                            //Move on
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the astronaut's pay rate (X,XXX.XX): ");
                                            kbd.nextLine();
                                            astroPayRate = (kbd.nextLine()).trim();
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 9: 
                                    System.out.print("Please edit the astronaut's weight in pounds: ");
                                    kbd.nextLine();
                                    astroWeight = kbd.nextDouble();
                                    String correct = "";
                                    do {
                                        System.out.println("The astronaut's current weight in the database is " + astroToEdit.weight() + "\n" +
                                                    "You entered: " + astroWeight + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setWeight(astroWeight);

                                            //Change the weight inside the database

                                            //Move on
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the weight in pounds: ");
                                            kbd.nextLine();
                                            astroWeight = (kbd.nextLine()).trim();
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 10:
                                    System.out.println("Going back");
                                    break;

                                default: 
                                    System.out.println("Please enter a number 1-10.");
                                    break;
                            }
                            astros[astroChoice - 1] = astroToEdit;
                            } while (field != 10);
                            break;
                        
                        case 3:
                            String theKey;
                            do{
                                ask for astronaut to delete
                                System.out.println("Which astronaut would you like to delete?");
                                int count = 0;
                                for (Astronaut a : astros) {
                                    if (a != null) {
                                        count++;
                                        System.out.println(count + ". " + a.getName() + "\n");
                                    }
                                }
                                int astroChoice = kbd.nextInt();
                                String astroConfirmation = "";
                                do {
                                    System.out.println("Chosen astronaut: " + astros[astroChoice - 1].getName());
                                    System.out.println("Is this the correct astronaut? (Yes/No)");
                                    kbd.nextLine();
                                    astroConfirmation = (kbd.nextLine()).trim();
                                    if (astroConfirmation.equalsIgnoreCase("no")) {
                                        count = 0;
                                        for (Astronaut a : astros) {
                                            if (a != null) {
                                                count++;
                                                System.out.println(count + " " + a.getName() + "\n");
                                            }
                                        }
                                        kbd.nextLine();
                                        astroChoice = kbd.nextInt();
                                    }
                                } while (!astroConfirmation.equalsIgnoreCase("yes"));
                            //     yes: ask for key to delete
                                System.out.println("Type \"yes\" for deletion.\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                theKey = kbd.nextLine();
                                if (theKey.equalsIgnoreCase("yes")) {
                                    //correct key: delete astronaut, notify user
                                    AstroRemoval removeAstro = new AstroRemoval(1);
                                    removeAstro.addAstro(astros[astroChoice - 1]);
                                    //removeAstro.removeAstronauts(SQL connection);
                                    break;
                                } else if (theKey.equalsIgnoreCase("Go back")) {
                                    break;
                                } else {
                                    while (!(theKey.equalsIgnoreCase("yes"))&&!(theKey.equalsIgnoreCase("go back")) {
                                        //incorrect key: notify that it is the incorrect key, ask again
                                        System.out.println("Wrong key, try again.");
                                        System.out.println("Type \"yes\" for deletion.\n" +
                                                           "If you wish to go back enter \"Go back\".");
                                        theKey = kbd.nextLine();
                                    }
                                    
                                }
                            } while (!theKey.equalsIgnoreCase("Go back")||!theKey.equalsIgnoreCase("yes");
                            break;

                        case 4:
                            System.out.println("Going back to main menu.");
                            break;

                        default:
                            System.out.println("Please enter a number from 1-4");
                            break;
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
                        System.out.println("Ship Menu\n" +
                                           "1. Add Ship\n" +
                                           "2. Edit Ship\n" +
                                           "3. Delete Ship\n" +
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
                                            System.out.println("Please enter the ship's fuel capacity in pounds: ");
                                            shipFuelCapacity = kbd.nextDouble();
                                            break;

                                            case 3:
                                            System.out.println("Please enter the ship's current fuel level in pounds: ");
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
                                for (int count = 0; count < ships[].length; count++) {
                                    if (ships[count] == null) {
                                        ships[count] = new Ship();
                                        ships[count].setSName(shipName);
                                        ships[count].setFCap(shipFuelCapacity);
                                        ships[count].setFuel(shipCurrentFuel);
                                        ships[count].setSCap(shipCrewCapacity);
                                        break;
                                    }
                                }
                                break;

                            case 2:
                                // ask which ship the user wants to edit
                                System.out.println("What ship would you like to edit?");
                                int count = 0;
                                for (Ship s : ships) {
                                    if (s != null) {
                                        count++;
                                        System.out.println(count + ". " + s.getSName() + "\n");
                                    }
                                }
                                int shipChoice = kbd.nextInt();
                                String shipConfirmation = "";
                                do {
                                    System.out.println("Chosen ship: " + ships[shipChoice - 1].getName());
                                    System.out.println("Is this the correct ship? (Yes/No)");
                                    kbd.nextLine();
                                    shipConfirmation = (kbd.nextLine()).trim();
                                    if (shipConfirmation.equalsIgnoreCase("no")) {
                                        count = 0;
                                        for (Ship s : ships) {
                                            if (s != null) {
                                                count++;
                                                System.out.println(count + ". " + s.getSName() + "\n");
                                            }
                                        }
                                        kbd.nextLine();
                                        shipChoice = kbd.nextInt();
                                    }
                                } while (!shipConfirmation.equalsIgnoreCase("yes"));
                                Ship shipToEdit = ships[shipChoice - 1];

                                // yes: ask what field to edit, verify, ask for new value, verify, edit info, notify
                                System.out.println("This is the current information for " + shipToEdit.getSName() + ".\n" +
                                                   "Ship Name: " + shipToEdit.getSName() + "\n" +
                                                   "Fuel Capacity: " + shipToEdit.getFCap() + "\n" +
                                                   "Fuel: " + shipToEdit.getFuel() + "\n" +
                                                   "Ship Capacity: " + shipToEdit.getSCap());
                                System.out.println("Fields\n" +
                                                    "1. Ship name\n" +
                                                    "2. Fuel Capacity\n" +
                                                    "3. Fuel\n" +
                                                    "4. Ship Capacity\n" +
                                                    "5. Go Back");
                                field = kbd.nextInt();
                                switch (field) {
                                    case 1:
                                        String theKey = "";
                                        boolean changeSuccessful = false;
                                        do {
                                            System.out.println("Please edit the ship's name: ");
                                            kbd.nextLine();
                                            shipName = (kbd.nextLine()).trim();
                                            System.out.println("The ship's current name in the database is \'" + shipToEdit.getSName() + "\'.\n" +
                                                            "You entered the name \'" + shipName + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            String correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                ship.setSName(shipName); 

                                                //Change the name inside the database

                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) || !(changeSuccessful));
                                        break;

                                    case 2:
                                        String theKey = "";
                                        boolean changeSuccessful = false;
                                        do {
                                            System.out.println("Please edit the ship's fuel capacity in pounds: ");
                                            kbd.nextLine();
                                            shipFuelCapacity = kbd.nextDouble();
                                            System.out.println("The ship's current fuel capacity in the database is \'" + shipToEdit.getFCap() + "\'.\n" +
                                                            "You entered the name \'" + shipFuelCapacity + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            String correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                ship.setFCap(shipFuelCapacity); 

                                                //Change the fuel capacity inside the database

                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) || !(changeSuccessful));
                                        break;

                                    case 3:
                                        String theKey = "";
                                        boolean changeSuccessful = false;
                                        do {
                                            System.out.println("Please edit the ship's current fuel in pounds: ");
                                            kbd.nextLine();
                                            shipCurrentFuel = kbd.nextDouble();
                                            System.out.println("The ship's current fuel capacity in the database is \'" + shipToEdit.getFuel() + "\'.\n" +
                                                            "You entered the name \'" + shipCurrentFuel + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            String correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                ship.setFuel(shipCurrentFuel); 

                                                //Change the fuel capacity inside the database

                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) || !(changeSuccessful));
                                        break;

                                    case 4:
                                        String theKey = "";
                                        boolean changeSuccessful = false;
                                        do {
                                            System.out.println("Please edit the ship's crew capacity: ");
                                            kbd.nextLine();
                                            shipCrewCapacity = kbd.nextInt();
                                            System.out.println("The ship's current crew capacity in the database is \'" + shipToEdit.getSCap() + "\'.\n" +
                                                            "You entered the name \'" + shipCrewCapacity + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            String correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                ship.setSCap(shipCrewCapacity); 

                                                //Change the crew capacity inside the database

                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) || !(changeSuccessful));
                                        break;

                                    case 5: 
                                        System.out.println("Going back to the previous menu.");
                                        break;

                                    default:
                                        System.out.println("Please enter a number 1-5");
                                        break;
                                    }
                                ships[shipChoice - 1] = shipToEdit;
                                break;

                            case 3:
                                // ask for ship to delete
                                System.out.println("What ship would you like to delete?");

                                // pull ship and verify that it is the correct one

                                // no: ask for correct ship, verify

                                // yes: ask for key to delete
                                //TO HELP ME, TYPE "yes: ask for" IN THE SERACH BAR AND BASE IT OFF OF WHAT COMES UP :)
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
                        int shipChoice;
                        switch (choice2) {
                            case 1:
                                System.out.println("Please select a ship to launch.");
                                int count = 0;
                                for (Ship s : ships) {
                                    if (s != null) {
                                        count++;
                                        System.out.println(count + ". " + s.getSName());
                                    }
                                }
                                System.out.print("Please enter the corresponding number: ");
                                shipChoice = kbd.nextInt();
                                String verify = "";
                                do {
                                    System.out.println("Ship selected: " + ships[shipChoice].getSName());
                                    System.out.println("Is this the correct ship? (yes/no)");
                                    if (verify.equalsIgnoreCase("no")) {
                                        System.out.println("Please select a ship to launch:");
                                        count = 0;
                                        for (Ship s : ships) {
                                            if (s != null) {
                                                count++;
                                                System.out.println(count + ". " + s.getSName());
                                            }
                                        shipChoice = kbd.nextInt();
                                        }
                                    }
                                } while (!verify.equalsIgnoreCase("yes"));
                                String launchConfirmation = "";
                                do {
                                    System.out.println("WARNING: Launching is irreversible and can result in death when gone wrong.\n" +
                                                       "Are you sure you wish to proceed? (Yes/No)");
                                    kbd.nextLine();
                                    launchConfirmation = (kbd.nextLine()).trim();
                                    if (launchConfirmation.equalsIgnoreCase("yes")) {
                                        ships[shipChoice - 1].launch();  //<-- Temporary value pass?
                                    } else if (launchConfirmation.equalsIgnoreCase("no")) {
                                        System.out.println("The ship will not be launched.");
                                    }
                                } while ((launchConfirmation.equalsIgnoreCase("yes")||launchConfirmation.equalsIgnoreCase("no")));
                                break;

                            case 2:
                                System.out.println("Going back to main menu.");
                                break;

                            default:
                                System.out.println("Please enter a number 1-2.");
                                break;
                        }
                    } while (choice2 != 2);
                    break;
                    

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

    public static boolean LoggingInPassword(Scanner scan) {

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
            // * First time application is run

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
            allowedEntry = true;
        } else {
            // ask for password or to reset password with the administrator password
            int loginChoice = scan.nextInt();
            switch (loginChoice) {
                case 1:
                    System.out.println("Please enter the password for the application: ");
                    int enteredPassword = scan.nextInt();
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
                            choice3 = scan.nextLine();
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
                    int adminPass = scan.nextInt();
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
                            String inputA = scan.nextLine();

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
                        loginChoice = scan.nextInt();
                    }
                    break;
            }
        }

            // ***NEED TO FINISH THIS PART***
            // * - - ask for administrator password and verify
            // * - - reset password
            // * - verify password

            // I'm not sure how to have the computer remember the password
            // * - - move on if valid
            return allowedEntry;
        }
    }
