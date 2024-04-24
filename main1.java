import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class main1 {

public static void main(String[] args){
    //Variables & Objects
        Ship[] ships = new Ship[10];
        Astronaut[] astros = new Astronaut[30];
        int choice = 0;
        int choice2 = 0;

    //Scanner
        Scanner kbd = new Scanner(System.in);
    
    Connection connect = null; //Will be fixed
    /*Statement statement = connect.createStatement();
    ResultSet results = null;
    try {
        //Class.forName(); <-- getting the driver
        //connect = DriverManager.getConnection(url, username, pass);
    } catch (SQLException e) {
        System.out.println("An error occurred: " + e.getMessage());
    }*/

    // Main menu
    // - Astronauts
    // - Rocket/Ship Inventory
    // - Launch
    // - Quit
    //databaseArrayRetrieval(statement, results);
    if (LoggingInPassword(kbd)) {
        do {
            System.out.println("Main Menu\n" +
                               "1. Astronauts\n" +
                               "2. Ships\n" + 
                               "3. Launch\n" +
                               "4. Quit");
            try {
                choice = kbd.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("An error has occurred: " + e.getMessage());
            }
            switch(choice) {
                case 1:
                    do {
                        System.out.println("Astronaut Menu\n" + 
                                           "1. Add Astronaut\n" +
                                           "2. Edit Astronaut\n" +
                                           "3. Delete Astronaut\n" +
                                           "4. Go Back");
                        try {
                            choice2 = kbd.nextInt();
                        } catch (NumberFormatException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        }
                        int field = 0;
                        switch (choice2) {
                        case 1:
                            System.out.print("Please enter the astronaut's full name (First Last): ");
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
                                kbd.nextLine();
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
                                    try {
                                        field = kbd.nextInt();
                                    } catch (NumberFormatException e) {
                                        System.out.println("An error has occurred: " + e.getMessage());
                                    }
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
                                            try {
                                                astroPayRate = kbd.nextDouble();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error has occurred: " + e.getMessage());
                                            }
                                            break;

                                        case 9: 
                                            System.out.print("Please enter the astronaut's weight in pounds: ");
                                            kbd.nextLine();
                                            try {
                                                astroWeight = kbd.nextDouble();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error has occurred: " + e.getMessage());
                                            }
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
                                    break;
                                }
                            }
                            /*
                            try {
                                //statement.executeUpdate(add name);
                                //statement.executeUpdate(add serial number);
                                //statement.executeUpdate(add DOB);
                                //statement.executeUpdate(add address);
                                //statement.executeUpdate(add email);
                                //statement.executeUpdate(add phone number);
                                //statement.executeUpdate(add next of kin);
                                //statement.executeUpdate(add status);
                                //statement.executeUpdate(add pay rate);
                                //statement.executeUpdate(add weight);
                            } catch (SQLException e) {
                                System.out.println("An error has occured while saving astronaut to database: " + e.getMessage());
                            }
                            */
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
                                        System.out.println(count + " " + a.getName());
                                    }
                                }
                                kbd.nextLine();
                                int astroChoice = astroSelection(kbd, astros);
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
                                field = 0;
                                kbd.nextLine();
                                try {
                                    field = kbd.nextInt();
                                } catch (NumberFormatException e) {
                                    System.out.println("An error has occurred: " + e.getMessage());
                                }
                                switch (field) {
                                    case 1:
                                        System.out.print("Please edit the astronaut's full name (First Last): ");
                                        kbd.nextLine();
                                        astroName = (kbd.nextLine()).trim();
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
                                                //statement.executeUpdate(add name);
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
                                            //statement.executeUpdate(add DOB);
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
                                    correct = "";
                                    do {
                                        System.out.println("The astronaut's current address in the database is " + astroToEdit.address() + "\n" +
                                                    "You entered: " + astroAddress + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setAddress(astroAddress);
                                            //statement.executeUpdate(add address);
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
                                    correct = "";
                                    do {
                                        System.out.println("The astronaut's current email in the database is " + astroToEdit.email() + "\n" +
                                                    "You entered: " + astroEmail + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setEmail(astroEmail);
                                            //statement.executeUpdate(add email);
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
                                    correct = "";
                                    do {
                                        System.out.println("The astronaut's current phone number in the database is " + astroToEdit.phoneNumber() + "\n" +
                                                    "You entered: " + astroPhone + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setPhoneNumber(astroPhone);
                                            //statement.executeUpdate(add phone number);
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
                                    correct = "";
                                    do {
                                        System.out.println("The astronaut's current next of kin in the database is " + astroToEdit.nextOfKin() + "\n" +
                                                        "You entered: " + astroNextOfKin + "\n" +
                                                        "If this correct, please enter \"Correct\".\n" +
                                                        "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setNextOfKin(astroNextOfKin);
                                            //statement.executeUpdate(add next of kin);
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
                                    correct = "";
                                    do {
                                        System.out.println("The astronaut's current planetary status in the database is " + astroToEdit.status() + "\n" +
                                                        "You entered: " + astroStatus + "\n" +
                                                        "If this correct, please enter \"Correct\".\n" +
                                                        "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setStatus(astroStatus);
                                            //statement.executeUpdate(add status);
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
                                    astroPayRate = 0;
                                    kbd.nextLine();
                                    try {
                                        astroPayRate = kbd.nextDouble();
                                    } catch (NumberFormatException e) {
                                        System.out.println("An error has occurred: " + e.getMessage());
                                    }
                                    correct = "";
                                    do {
                                        System.out.println("The astronaut's current pay rate in the database is " + astroToEdit.payRate() + "\n" +
                                                        "You entered: " + astroPayRate + "\n" +
                                                        "If this correct, please enter \"Correct\".\n" +
                                                        "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setPayRate(astroPayRate);
                                            //statement.executeUpdate(add pay rate);
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the astronaut's pay rate (X,XXX.XX): ");
                                            kbd.nextLine();
                                            try {
                                                astroPayRate = kbd.nextDouble();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error has occurred: " + e.getMessage());
                                            }
                                        }
                                    } while (!correct.equalsIgnoreCase("correct"));
                                    break;

                                case 9: 
                                    System.out.print("Please edit the astronaut's weight in pounds: ");
                                    astroWeight = 0;
                                    kbd.nextLine();
                                    try {
                                        astroWeight = kbd.nextDouble();
                                    } catch (NumberFormatException e) {
                                        System.out.println("An error has occurred: " + e.getMessage());
                                    }
                                    correct = "";
                                    do {
                                        System.out.println("The astronaut's current weight in the database is " + astroToEdit.weight() + "\n" +
                                                    "You entered: " + astroWeight + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                        kbd.nextLine();
                                        correct = kbd.nextLine();
                                        if (correct.equalsIgnoreCase("Correct")) {
                                            astroToEdit.setWeight(astroWeight);
                                            //statement.executeUpdate(add weight);
                                        } else if (correct.equalsIgnoreCase("Go back")) {
                                            break;
                                        } else {
                                            System.out.print("Please edit the weight in pounds: ");
                                            kbd.nextLine();
                                            try {
                                                astroWeight = kbd.nextDouble();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error has occurred: " + e.getMessage());
                                            }
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
                                int astroChoice = astroSelection(kbd, astros);
                            //     yes: ask for key to delete
                                System.out.println("Type \"yes\" for deletion.\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                theKey = kbd.nextLine();
                                if (theKey.equalsIgnoreCase("yes")) {
                                    //correct key: delete astronaut, notify user
                                    AstroRemoval removeAstro = new AstroRemoval(1);
                                    removeAstro.addAstro(astros[astroChoice - 1]);
                                    removeAstro.removeAstronauts(connect);
                                    break;
                                } else if (theKey.equalsIgnoreCase("Go back")) {
                                    break;
                                }
                            } while (!theKey.equalsIgnoreCase("Go back")||!theKey.equalsIgnoreCase("yes"));
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
                //     * - Add astro
                    do{
                        //**LINE AFTER THIS NEEDS TO BE EDITED**  
                        System.out.println("Ship Menu\n" +
                                           "1. Add Ship\n" +
                                           "2. Edit Ship\n" +
                                           "3. Delete Ship\n" +
                                           "4. Add Astronaut To Ship" +
                                           "5. Go Back");
                        choice2 = 0;
                        try {
                            choice2 = kbd.nextInt();
                        } catch (NumberFormatException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        }
                        int field = 0;
                        switch (choice2) {
                            case 1:
                                System.out.print("Please enter the ship's name: ");
                                kbd.nextLine();
                                String shipName = (kbd.nextLine()).trim();
                                System.out.print("Please enter the ship's fuel capacity: ");
                                kbd.nextLine();
                                double shipFuelCapacity = kbd.nextDouble();
                                try {
                                    shipFuelCapacity = kbd.nextDouble();
                                } catch (NumberFormatException e) {
                                    System.out.println("An error has occurred: " + e.getMessage());
                                }
                                System.out.print("Please enter the ship's current fuel level: ");
                                kbd.nextLine();
                                double shipCurrentFuel = 0;
                                try {
                                    shipCurrentFuel = kbd.nextDouble();
                                } catch (NumberFormatException e) {
                                    System.out.println("An error has occurred: " + e.getMessage());
                                }
                                System.out.print("Please enter the ship's crew capacity: ");
                                kbd.nextLine();
                                int shipCrewCapacity = 0;
                                try {
                                    shipCrewCapacity = kbd.nextInt();
                                } catch (NumberFormatException e) {
                                    System.out.println("An error has occurred: " + e.getMessage());
                                }
                                
                                String change = "";
                                do {
                                    System.out.println("Please verify information before saving.\n" +
                                                    "Name: " + shipName + "\n" +
                                                    "Fuel Capacity: " + shipFuelCapacity + "\n" +
                                                    "Current Fuel: " + shipCurrentFuel + "\n" +
                                                    "Crew Capacity: " + shipCrewCapacity);
                                    System.out.println("Is there anything you wish to change? (yes/no)");
                                    change = (kbd.nextLine()).trim();
                                    if (change.equalsIgnoreCase("yes")) {
                                        System.out.println("Which field do you wish to change?");
                                        System.out.println("1. Ship Name" +
                                                           "2. Fuel Capacity" +
                                                           "3. Current Fuel" +
                                                           "4. Crew Capacity");
                                        System.out.print("Please enter the corresponding number: ");
                                        try {
                                            field = kbd.nextInt();
                                        } catch (NumberFormatException e) {
                                            System.out.println("An error has occurred: " + e.getMessage());
                                        }
                                        switch (field) {
                                            case 1:
                                            System.out.print("Please enter the ship's name: ");
                                            kbd.nextLine();
                                            shipName = (kbd.nextLine()).trim();
                                            break;

                                            case 2:
                                            System.out.print("Please enter the ship's fuel capacity in pounds: ");
                                            kbd.nextLine();
                                            try {
                                                shipFuelCapacity = kbd.nextDouble();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error has occurred: " + e.getMessage());
                                            }
                                            break;

                                            case 3:
                                            System.out.print("Please enter the ship's current fuel level in pounds: ");
                                            kbd.nextLine();
                                            try {
                                                shipCurrentFuel = kbd.nextDouble();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error has occurred: " + e.getMessage());
                                            }
                                            break;

                                            case 4:
                                            System.out.print("Please enter the ship's crew capacity: ");
                                            kbd.nextLine();
                                            try {
                                                shipCrewCapacity = kbd.nextInt();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error has occurred: " + e.getMessage());
                                            }
                                            break;

                                            default:
                                            System.out.println("Please enter a number 1-4");
                                            break;
                                        }
                                    }
                                } while (!change.equalsIgnoreCase("no"));
                                for (int count = 0; count < ships.length; count++) {
                                    if (ships[count] == null) {
                                        ships[count] = new Ship();
                                        ships[count].setSName(shipName);
                                        ships[count].setFCap(shipFuelCapacity);
                                        ships[count].setFuel(shipCurrentFuel);
                                        ships[count].setSCap(shipCrewCapacity);
                                        break;
                                    }
                                }
                                /*
                                try {
                                    //statement.executeUpdate(add ship name);
                                    //statement.executeUpdate(add fCap);
                                    //statement.executeUpdate(add fuel);
                                    //statement.executeUpdate(add sCap);
                                } catch (SQLException e) {
                                    System.out.println("An error occurred while saving ship to database: " + e.getMessage());
                                }
                                */
                                break;

                            case 2:
                                int shipChoice = shipSelection(kbd, ships);
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
                                                shipToEdit.setSName(shipName); 
                                                //statement.executeUpdate(add name);
                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) || !(changeSuccessful));
                                        break;

                                    case 2:
                                        theKey = "";
                                        changeSuccessful = false;
                                        do {
                                            System.out.println("Please edit the ship's fuel capacity in pounds: ");
                                            kbd.nextLine();
                                            shipFuelCapacity = 0;
                                            try {
                                                shipFuelCapacity = kbd.nextDouble();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                            }
                                            System.out.println("The ship's current fuel capacity in the database is \'" + shipToEdit.getFCap() + "\'.\n" +
                                                            "You entered the name \'" + shipFuelCapacity + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            String correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                shipToEdit.setFCap(shipFuelCapacity); 
                                                //statement.executeUpdate(add fCap);
                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) || !(changeSuccessful));
                                        break;

                                    case 3:
                                        theKey = "";
                                        changeSuccessful = false;
                                        do {
                                            System.out.println("Please edit the ship's current fuel in pounds: ");
                                            kbd.nextLine();
                                            shipCurrentFuel = 0;
                                            try {
                                                shipCurrentFuel = kbd.nextDouble();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                            }
                                            System.out.println("The ship's current fuel capacity in the database is \'" + shipToEdit.getFuel() + "\'.\n" +
                                                            "You entered the name \'" + shipCurrentFuel + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            String correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                shipToEdit.setFuel(shipCurrentFuel); 
                                                //statement.executeUpdate(add fuel);
                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) || !(changeSuccessful));
                                        break;

                                    case 4:
                                        theKey = "";
                                        changeSuccessful = false;
                                        do {
                                            System.out.println("Please edit the ship's crew capacity: ");
                                            kbd.nextLine();
                                            shipCrewCapacity = 0;
                                            try {
                                                shipCrewCapacity = kbd.nextInt();
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                            }
                                            System.out.println("The ship's current crew capacity in the database is \'" + shipToEdit.getSCap() + "\'.\n" +
                                                            "You entered the name \'" + shipCrewCapacity + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            String correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                shipToEdit.setSCap(shipCrewCapacity); 
                                                //statement.executeUpdate(add sCap);
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
                                shipChoice = shipSelection(kbd, ships);
                                // no: ask for correct ship, verify
                                // yes: ask for key to delete
                                System.out.println("Type \"yes\" for deletion.\n" +
                                                   "If you wish to go back enter \"Go back\".");
                                String theKey = kbd.nextLine();
                                do {
                                    if (theKey.equalsIgnoreCase("yes")) {
                                        // correct key: delete ship, notify user
                                        ShipRemoval removeShip = new ShipRemoval(ships[shipChoice - 1]);
                                        removeShip.removeShip(connect);
                                    } else if (theKey.equalsIgnoreCase("go back")) {
                                        break;
                                    }
                                } while (!theKey.equalsIgnoreCase("yes")||!theKey.equalsIgnoreCase("go back"));
                                break;

                            case 4:
                                //int astroChoice = astroSelection(kbd, astros);
                                shipChoice = shipSelection(kbd, ships);
                                //ships[shipChoice -1].addAstro(astros[astroChoice - 1]);
                                break;

                            case 5:
                                System.out.println("Going back to main menu.");
                                break;

                            default:
                                System.out.println("Please enter a number 1-5.");
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
                                shipChoice = shipSelection(kbd, ships);
                                String launchConfirmation = "";
                                do {
                                    System.out.println("WARNING: Launching is irreversible and can result in death when gone wrong.\n" +
                                                       "Are you sure you wish to proceed? (Yes/No)");
                                    kbd.nextLine();
                                    launchConfirmation = (kbd.nextLine()).trim();
                                    if (launchConfirmation.equalsIgnoreCase("yes")) {
                                        ships[shipChoice - 1].launch();
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
    
    //results.close();
    //statement.close();
    //connect.close();
    kbd.close();
    System.exit(0);
}

    public static boolean LoggingInPassword(Scanner scan) {
        boolean createPassword = true;
        boolean allowedEntry = false;
        File file = new File("ApplicationPassword.dat");
        int applicationPassword = -800;
        if (file.exists()) {
            try {
                FileInputStream passInput = new FileInputStream(file);
                applicationPassword = (int) passInput.read();
                passInput.close();
                createPassword = false;
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("An error occured: " + e.getMessage());
            }
        }

        if (createPassword) {

            int passNum = -496108;
            // * - Create password and display for user to write down
            System.out.println("Creating Password...");

            Random r = new Random();
             passNum = 0;
            for (int i = 0; i < 1; i++) {
                passNum = r.nextInt(20000);
                System.out.println("Please write down the following password: " + passNum);
            }
            try {
                //file.createNewFile();
                FileOutputStream passOutput = new FileOutputStream(file);
                PrintWriter pw = new PrintWriter(file);
                pw.write(passNum);
                pw.close();
                passOutput.close();
                createPassword = false;
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("An error occured: " + e.getMessage());
            }
            
            // * - Notify user of account creation and move on
            System.out.println("*Account Created*");

            // * Any time after 1st
            allowedEntry = true;
        } else {
            // ask for password or to reset password with the administrator password
            System.out.println("1. Enter Password to Application\n" +
                               "2. Enter Admin Password to Reset Application Password\n" +
                               "3. Quit");
            int loginChoice = scan.nextInt();
            do {
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
                                scan.nextLine();
                                choice3 = scan.nextLine();
                                if (choice3.equalsIgnoreCase("Go back")) {
                                    break;
                                } else {
                                    try {
                                        enteredPassword = Integer.parseInt(choice3);
                                    } catch (NumberFormatException e) {
                                        System.out.println("An error occurred: " + e.getMessage());
                                    }
                                    
                                }
                            }
                        }
                        break;
        
                    case 2:
                        // ask for adminPass
                        int trueAdminPass = -298756;
                        File adminFile = new File("adminPassword.dat");
                        try {
                            FileInputStream adminPassFile = new FileInputStream(adminFile);
                            trueAdminPass = adminPassFile.read();
                            System.out.println(trueAdminPass);
                            adminPassFile.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        } catch (IOException e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }
                        System.out.println("Please enter the admin password: ");
                        int adminPass = scan.nextInt();
                        if (adminPass == trueAdminPass) {
                            // create a new password for application and show it to user to write down
                            System.out.println("Creating Password...");

                            Random r = new Random();
                            int passNum = 0;
                            for (int i = 0; i < 1; i++) {
                                passNum = r.nextInt(20000);
                                System.out.println("Please write down the following password: " + passNum);
                            }
                            try {
                                //file.createNewFile();
                                FileOutputStream passOutput = new FileOutputStream(file);
                                PrintWriter pw = new PrintWriter(file);
                                pw.write(passNum);
                                pw.close();
                                passOutput.close();
                                createPassword = false;
                            } catch (FileNotFoundException e) {
                                System.out.println("An error occurred: " + e.getMessage());
                            } catch (IOException e) {
                                System.out.println("An error occured: " + e.getMessage());
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
                                    if (adminPass == trueAdminPass) {
                                        // create a new password for application and show it to user to write down
                                        System.out.println("Creating Password...");
            
                                        Random r = new Random();
                                        int passNum = 0;
                                        for (int i = 0; i < 1; i++) {
                                            passNum = r.nextInt(20000);
                                            System.out.println("Please write down the following password: " + passNum);
                                        }
                                        try {
                                            //file.createNewFile();
                                            FileOutputStream passOutput = new FileOutputStream(file);
                                            PrintWriter pw = new PrintWriter(file);
                                            pw.write(passNum);
                                            pw.close();
                                            passOutput.close();
                                            createPassword = false;
                                        } catch (FileNotFoundException e) {
                                            System.out.println("An error occurred: " + e.getMessage());
                                        } catch (IOException e) {
                                            System.out.println("An error occured: " + e.getMessage());
                                        }
                                        allowedEntry = true;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
        
                    case 3:
                        System.out.println("Quitting the application");
                        break;

                    default:
                        System.out.println("Please enter the number 1 or 2.");
                        break;
                }
            } while ((loginChoice != 3) && (allowedEntry == false));
            
        }
            return allowedEntry;
    }

    public static void databaseArrayRetrieval(Statement s, ResultSet r) {
        /*try {
            Check if the file/database exits
            Yes:
                int count = 0;
                r = s.executeQuery(getting names);
                while (r.next()) {
                    String dbName = r.getString("Names");
                    astros[count].setName(dbName);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting serials);
                while (r.next()) {
                    String dbSerialNumber = r.getInt("SerialNumbers");
                    astros[count].setSerialNumber(dbSerialNumber);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting DOB's);
                while (r.next()) {
                    String dbBirthdate = r.getString("Birthdates");
                    astros[count].setdateOfBirth(dbBirthdate);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting addresses);
                while (r.next()) {
                    String dbAddress = s.getString("Addresses");
                    astros[count].setAddress(dbAddress);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting emails);
                while (r.next()) {
                    String dbEmail = r.getString("Emails");
                    astros[count].setEmail(dbEmail);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting phone numbers);
                while (r.next()) {
                    String dbPhoneNumber = r.getString("PhoneNumbers");
                    astros[count].setPhoneNumber(dbPhoneNumber);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting next of kin);
                while (r.next()) {
                    String dbNextOfKin = r.getString("NextOfKin");
                    astros[count].setNextOfKin(nextOfKin);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting statuses);
                while (r.next()) {
                    String dbStatus = r.getString("Statuses");
                    astros[count].setStatus(dbStatus);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting pay rates);
                while (r.next()) {
                    String dbPayRate = r.getDouble("PayRates");
                    astros[count].setPayRate(dbPayRate);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting weights);
                while (r.next()) {
                    String dbWeight = r.getDouble("");
                    astros[count].setWeight(dbWeight);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting ship names);
                while (r.next()) {
                    String name = r.getString("ShipNames");
                    astros[count].setSName(name);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting fuel capacities);
                while (r.next()) {
                    String fCap = r.getString("FuelCapacities");
                    astros[count].setFCap(fCap);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting fuels);
                while (r.next()) {
                    String fuel = r.getString("Fuel");
                    astros[count].setFuel(fuel);
                    count++;
                }
                count = 0;
                r = s.executeQuery(getting crew capacities);
                while (r.next()) {
                    String sCap = r.getString("ShipCapacities");
                    astros[count].setSCap(sCap);
                    count++;
                }
            no:
                create file?
                create database?
                s.executeUpdate(create table for astronauts);
                s.executeUpdate(create columns for astronaut fields);
                s.executeUpdate(create table for ships);
                s.executeUpdate(create columns for ship fields);
                backup database on file
        } catch (SQLException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }*/
    }

    public static int astroSelection(Scanner kbd, Astronaut[] astros) {
        //Ask user to select am astronaut
        System.out.println("Please select an astronaut:");
        int count = 0;
        for (Astronaut a : astros) {
            if (a != null) {
                count++;
                System.out.println(count + ". " + a.getName());
            }
        }
        int astroChoice = 0;
        do {
            try {
                astroChoice = kbd.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("An error has occurred: " + e.getMessage());
            }
        } while (!(astroChoice >= 1 && astroChoice <= count));
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
                        System.out.println(count + " " + a.getName());
                    }
                }
                kbd.nextLine();
                do {
                    try {
                        astroChoice = kbd.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("An error has occurred: " + e.getMessage());
                    }
                } while (!(astroChoice >= 1 && astroChoice <= count));
            }
        } while (!astroConfirmation.equalsIgnoreCase("yes"));
        return astroChoice;
    }

    public static int shipSelection(Scanner kbd, Ship[] ships) {
        // Ask the user to select a ship
        System.out.println("Please select a ship: ");
        int count = 0;
        for (Ship s : ships) {
            if (s != null) {
                count++;
                System.out.println(count + ". " + s.getSName());
            }
        }
        int shipChoice = 0;
        do {
            try {
                shipChoice = kbd.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!(shipChoice >= 1 && shipChoice <= count));
        String shipConfirmation = "";
        do {
            System.out.println("Chosen ship: " + ships[shipChoice - 1].getSName());
            System.out.println("Is this the correct ship? (Yes/No)");
            kbd.nextLine();
            shipConfirmation = (kbd.nextLine()).trim();
            if (shipConfirmation.equalsIgnoreCase("no")) {
                count = 0;
                for (Ship s : ships) {
                    if (s != null) {
                        count++;
                        System.out.println(count + ". " + s.getSName());
                    }
                }
                kbd.nextLine();
                do {
                    try {
                        shipChoice = kbd.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                } while (!(shipChoice >= 1 && shipChoice <= count));
            }
        } while (!shipConfirmation.equalsIgnoreCase("yes"));
        return shipChoice;
    }
}
