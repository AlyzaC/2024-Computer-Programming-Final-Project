import java.util.*;
import java.io.*;

public class main1 {

public static void main(String[] args){
    //Variables & Objects
    int choice = 0;
    int choice2 = 0;
    Ship[] ships = new Ship[10];
    Astronaut[] astros = new Astronaut[30];
    String correct = "";
    InputAndArrayChecker checker = new InputAndArrayChecker();
    DatabaseManager dbManager = null;

    //Scanner
    Scanner kbd = new Scanner(System.in);
    
    if (LoggingInPassword(kbd)) {
        //Sets up database, connection,and statement
        dbManager = new DatabaseManager();
        astros = dbManager.databaseAstronautArrayRetrieval();
        ships = dbManager.databaseShipArrayRetrieval();
        do {
            //Main menu for the program
            System.out.println("\nMission Control\n" +
                               "1. Astronauts\n" +
                               "2. Ships\n" + 
                               "3. Launch\n" +
                               "4. Quit");
            //Variable for main menu switch loop
            choice = 0;
            try {
                choice = kbd.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("An error has occurred: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("An error has occurred: " + e.getMessage());
            }
            //Main menu switch statement
            switch(choice) {
                case 1:
                    do {
                        System.out.println("\nAstronaut Menu\n" + 
                                           "1. Add Astronaut\n" +
                                           "2. Edit Astronaut\n" +
                                           "3. Delete Astronaut\n" +
                                           "4. Go Back");
                        //Int for astronaut menu switch loop
                        choice2 = 0;
                        try {
                            choice2 = kbd.nextInt();
                        } catch (NumberFormatException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        }
                        int field = 0;
                        //Astronaut menu switch loop
                        switch (choice2) {
                        case 1:
                            //Asks user for value for new astronaut object's fields
                            System.out.print("\nPlease enter the astronaut's first name: ");
                            kbd.nextLine().trim();
                            String firstName = kbd.nextLine().trim();
                            System.out.print("Please enter the astronaut's last name: ");
                            String lastName = kbd.nextLine().trim();
                            String astroName = firstName + " " + lastName;
                            System.out.print("Please enter the astronaut's date of birth (DD/MM/YYYY): ");
                            String astroDateOfBirth = (kbd.nextLine()).trim();
                            while (!checker.checkBirthdateString(astroDateOfBirth)) {
                                System.out.print("Please reenter the astronaut's date of birth (DD/MM/YYYY): ");
                                astroDateOfBirth = (kbd.nextLine()).trim();
                            }
                            System.out.print("Please enter the astronaut's address: ");
                            String astroAddress = (kbd.nextLine()).trim();
                            System.out.print("Please enter the astronaut's email (name@example.com): ");
                            String astroEmail = (kbd.nextLine()).trim();
                            while (!checker.checkEmail(astroEmail)) {
                                System.out.print("Please reenter the astronaut's email (name@example.com): ");
                                astroEmail = kbd.nextLine();
                            }
                            System.out.print("Please enter the astronaut's phone number [(XXX)XXX-XXXX]: ");
                            String astroPhone = (kbd.nextLine()).trim();
                            while (!astroPhone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                                System.out.print("Please reenter the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                astroPhone = (kbd.nextLine()).trim();
                            }
                            System.out.print("Please enter the first name of the astronaut's next of kin: ");
                            String nextOfKinFirst = (kbd.nextLine()).trim();
                            System.out.print("Please enter the last name of the astronaut's next of kin: ");
                            String nextOfKinLast = (kbd.nextLine()).trim();
                            String astroNextOfKin = nextOfKinFirst + " " + nextOfKinLast;
                            System.out.print("Please enter the astronaut's planetary status (On Earth/In Space): ");
                            String astroStatus;
                            do {
                                astroStatus = (kbd.nextLine()).trim();
                                if (astroStatus.equalsIgnoreCase("on earth")) {
                                    astroStatus = "On Earth";
                                } else if (astroStatus.equalsIgnoreCase("in space")) {
                                    astroStatus = "In Space";
                                } else {
                                    System.out.println("Astronaut status must be \"On Earth\" or \"In Space\".");
                                    System.out.println("Please try again.");
                                }
                            } while (!astroStatus.equalsIgnoreCase("on earth") && !astroStatus.equalsIgnoreCase("in space"));
                            double astroPayRate = 0;
                            do {
                                System.out.print("Please enter the astronaut's pay rate per hour: ");
                                try {
                                    astroPayRate = kbd.nextDouble();
                                    if (astroPayRate <= 7.25) {
                                        System.out.print("The federal minimum wage is $7.50");
                                    }
                                } catch (NumberFormatException e ) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                    kbd.nextLine();
                                } catch (InputMismatchException e) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                    kbd.nextLine();
                                }
                            } while (astroPayRate <= 7.25);
                            double astroWeight = 0;
                            do {
                                System.out.print("Please enter the astronaut's weight in pounds: ");
                                try {
                                    astroWeight = kbd.nextDouble();
                                    if (!(astroWeight >= 110 && astroWeight <= 209)) {
                                        System.out.println("Astronaut must be between 110 and 209 pounds");
                                    }
                                } catch (NumberFormatException e ) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                    kbd.nextLine();
                                } catch (InputMismatchException e) {
                                    System.out.println("An error occurred: " + e.getMessage());
                                    kbd.nextLine();
                                }
                            } while (!(astroWeight >= 110 && astroWeight <= 209));
                            String change = "";
                            kbd.nextLine();
                            do {
                                //Displays the information entered by the user for verification
                                System.out.println("\nPlease verify information before saving.\n" +
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
                                    //Gives fields to edit
                                    System.out.println("\nWhich field do you wish to change?");
                                    System.out.println("1. Name\n" +
                                                       "2. Date of Birth\n" +
                                                       "3. Address\n" +
                                                       "4. Email\n" + 
                                                       "5. Phone Number\n" +
                                                       "6. Next of Kin\n" +
                                                       "7. Status\n" +
                                                       "8. Pay Rate\n" +
                                                       "9. Weight\n" );
                                    //Int for editing switch loop
                                    System.out.print("Please enter the corresponding number: ");
                                    try {
                                        field = kbd.nextInt();
                                    } catch (NumberFormatException e) {
                                        System.out.println("An error has occurred: " + e.getMessage());
                                    } catch (InputMismatchException e) {
                                        System.out.println("An error has occurred: " + e.getMessage());
                                    }
                                    //Editing switch loop
                                    switch (field) {
                                        case 1:
                                            System.out.print("\nPlease enter the astronaut's first name: ");
                                            kbd.nextLine().trim();
                                            firstName = kbd.nextLine().trim();
                                            System.out.print("Please enter the Astronaut's last name: ");
                                            lastName = kbd.nextLine().trim();
                                            astroName = firstName + " " + lastName;
                                            break;
                                        
                                        case 2:
                                            System.out.print("\nPlease enter the astronaut's date of birth (DD/MM/YYYY): ");
                                            kbd.nextLine();
                                            astroDateOfBirth = (kbd.nextLine()).trim();
                                            while (!checker.checkBirthdateString(astroDateOfBirth)) {
                                                System.out.print("Please reenter the astronaut's date of birth (DD/MM/YYYY): ");
                                                astroDateOfBirth = (kbd.nextLine()).trim();
                                            }
                                            break;

                                        case 3:
                                            System.out.print("\nPlease enter the astronaut's address: ");
                                            kbd.nextLine();
                                            astroAddress = (kbd.nextLine()).trim();
                                            break;

                                        case 4: 
                                            System.out.print("\nPlease enter the astronaut's email (name@example.com): ");
                                            kbd.nextLine();
                                            astroEmail = (kbd.nextLine()).trim();
                                            while (!checker.checkEmail(astroEmail)) {
                                                System.out.print("Please reenter the astronaut's email (name@example.com): ");
                                                astroEmail = kbd.nextLine();
                                            }
                                            break;

                                        case 5: 
                                            System.out.print("\nPlease enter the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                            kbd.nextLine();
                                            astroPhone = (kbd.nextLine()).trim();
                                            while (!astroPhone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                                                System.out.print("Please reenter the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                                astroPhone = (kbd.nextLine()).trim();
                                            }
                                            break;

                                        case 6: 
                                            System.out.print("\nPlease enter the first name of the astronaut's next of kin: ");
                                            kbd.nextLine();
                                            nextOfKinFirst = (kbd.nextLine()).trim();
                                            System.out.print("Please enter the last name of the astronaut's next of kin: ");
                                            nextOfKinLast = (kbd.nextLine()).trim();
                                            astroNextOfKin = nextOfKinFirst + " " + nextOfKinLast;
                                            break;

                                        case 7: 
                                            System.out.print("\nPlease enter the astronaut's planetary status (On Earth/In Space): ");
                                            kbd.nextLine();
                                            do {
                                                astroStatus = (kbd.nextLine()).trim();
                                                if (astroStatus.equalsIgnoreCase("on earth")) {
                                                    astroStatus = "On Earth";
                                                } else if (astroStatus.equalsIgnoreCase("in space")) {
                                                    astroStatus = "In Space";
                                                } else {
                                                    System.out.println("Astronaut status must be \"On Earth\" or \"In Space\".");
                                                    System.out.println("Please try again.");
                                                }
                                            } while (!astroStatus.equalsIgnoreCase("on earth") && !astroStatus.equalsIgnoreCase("in space"));
                                            break;

                                        case 8: 
                                            do {
                                                System.out.print("\nPlease enter the astronaut's pay rate: ");
                                                try {
                                                    astroPayRate = kbd.nextDouble();
                                                    if (astroPayRate <= 7.25) {
                                                        System.out.print("The federal minimum wage is $7.50. " +
                                                                         "Please enter a new pay rate per hour: ");
                                                    }
                                                } catch (NumberFormatException e ) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                }
                                            } while (astroPayRate <= 7.25);
                                            break;

                                        case 9: 
                                        do {
                                            System.out.print("\nPlease enter the astronaut's weight in pounds: ");
                                            try {
                                                astroWeight = kbd.nextDouble();
                                                if (!(astroWeight >= 110 && astroWeight <= 209)) {
                                                    System.out.println("Astronaut must be between 110 and 209 pounds");
                                                }
                                            } catch (NumberFormatException e ) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                                kbd.nextLine();
                                            } catch (InputMismatchException e) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                                kbd.nextLine();
                                            }
                                        } while (!(astroWeight >= 110 && astroWeight <= 209));
                                            break;

                                        default: 
                                            System.out.println("\nPlease enter a number 1-9.");
                                            kbd.nextLine();
                                            break;
                                    }
                                    
                                }
                            }  while (!change.equalsIgnoreCase("no"));
                            //Checks for empty Astronaut object in array and creates new object
                            int count = 0;
                            for (count = 0; count < astros.length; count++) {
                                if (astros[count] == null) {
                                    astros[count] = new Astronaut(astroName, astroDateOfBirth, astroAddress, astroEmail, astroPhone, astroNextOfKin, astroStatus, astroPayRate, astroWeight);
                                    break;
                                }
                            }
                            //Tries to add Astronaut information to database
                            dbManager.addAstroToDatabase(astros[count]);
                            break;

                        case 2:
                            //Editing an astronaut object
                            do {
                                Astronaut astroToEdit;
                                if (!checker.checkForAstronauts(astros)) {
                                    System.out.println("\nThere are no astronauts to edit.");
                                    break;
                                }
                                int astroChoice = astroSelection(kbd, astros);
                                astroToEdit = astros[astroChoice - 1];
                                //Displays current information for astronaut
                                System.out.println("\nThis is the current information for " + astroToEdit.getName());
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
                                //Displays editable fields and asks user to choose one
                                System.out.println("\nFields\n" +
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
                                System.out.print("Please enter the corresponding number: ");
                                //Int for astronaut editing switch loop
                                field = 0;
                                try {
                                    field = kbd.nextInt();
                                } catch (NumberFormatException e) {
                                    System.out.println("An error has occurred: " + e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("An error has occurred: " + e.getMessage());
                                }
                                //Astronaut editing switch loop
                                switch (field) {
                                    case 1:
                                        System.out.print("\nPlease enter/edit the astronaut's first name: ");
                                        kbd.nextLine().trim();
                                        firstName = kbd.nextLine().trim();
                                        System.out.print("Please enter/edit the Astronaut's last name: ");
                                        lastName = kbd.nextLine().trim();
                                        astroName = firstName + " " + lastName;
                                        correct = "";
                                        do {
                                            System.out.println("The astronaut's current name in the database is "
                                                               + astroToEdit.getName() + "\n" +
                                                               "You entered: " + astroName + "\n" +
                                                               "If this correct, please enter \"Correct\".\n" +
                                                               "If you wish to go back enter \"Go back\".");
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setName(astroName);
                                                dbManager.setAstroName(astroName, astroToEdit.getSerialNumber());
                                            } else if (correct.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                System.out.print("Please enter/edit the astronaut's first name: ");
                                                kbd.nextLine().trim();
                                                firstName = kbd.nextLine().trim();
                                                System.out.print("Please enter/edit the Astronaut's last name: ");
                                                lastName = kbd.nextLine().trim();
                                                astroName = firstName + " " + lastName;
                                                astroName = (kbd.nextLine()).trim();
                                            }
                                        } while (!correct.equalsIgnoreCase("correct"));
                                        break;

                                    case 2:
                                        System.out.print("\nPlease edit the astronaut's date of birth (DD/MM/YYYY): ");
                                        kbd.nextLine();
                                        astroDateOfBirth = (kbd.nextLine()).trim();
                                        while (!checker.checkBirthdateString(astroDateOfBirth)) {
                                            System.out.print("Please reenter the astronaut's date of birth (DD/MM/YYYY): ");
                                            astroDateOfBirth = (kbd.nextLine()).trim();
                                        }
                                        correct = "";
                                        do {
                                            System.out.println("The astronaut's current date of birth in the database is "
                                                            + astroToEdit.dateOfBirth() + "\n" +
                                                            "You entered: " + astroDateOfBirth + "\n" +
                                                            "If this correct, please enter \"Correct\".\n" +
                                                            "If you wish to go back enter \"Go back\".");
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setdateOfBirth(astroDateOfBirth);
                                                dbManager.setAstroBirthDate(astroDateOfBirth, astroToEdit.getSerialNumber());
                                            } else if (correct.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                System.out.print("Please edit the astronaut's date of birth (DD/MM/YYYY): ");
                                                kbd.nextLine();
                                                astroDateOfBirth = (kbd.nextLine()).trim();
                                                while (!checker.checkBirthdateString(astroDateOfBirth)) {
                                                    System.out.print("Please reenter the astronaut's date of birth (DD/MM/YYYY): ");
                                                    astroDateOfBirth = (kbd.nextLine()).trim();
                                                }
                                            }
                                        } while (!correct.equalsIgnoreCase("correct"));
                                        break;

                                    case 3:
                                        System.out.print("\nPlease edit the astronaut's address:");
                                        kbd.nextLine();
                                        astroAddress = (kbd.nextLine()).trim();
                                        correct = "";
                                        do {
                                            System.out.println("The astronaut's current address in the database is "
                                                    + astroToEdit.address() + "\n" +
                                                    "You entered: " + astroAddress + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setAddress(astroAddress);
                                                dbManager.setAstroAddress(astroAddress, astroToEdit.getSerialNumber());
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
                                        System.out.print("\nPlease edit the astronaut's email (name@example.com): ");
                                        kbd.nextLine();
                                        astroEmail = (kbd.nextLine()).trim();
                                        while (!checker.checkEmail(astroEmail)) {
                                            System.out.print("Please reenter the astronaut's email (name@example.com): ");
                                            astroEmail = kbd.nextLine();
                                        }
                                        correct = "";
                                        do {
                                            System.out.println("The astronaut's current email in the database is "
                                                    + astroToEdit.email() + "\n" +
                                                    "You entered: " + astroEmail + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setEmail(astroEmail);
                                                dbManager.setAstroEmail(astroEmail, astroToEdit.getSerialNumber());
                                            } else if (correct.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                System.out.print("Please edit the astronaut's email (name@example.com): ");
                                                kbd.nextLine();
                                                astroEmail = (kbd.nextLine()).trim();
                                                while (!checker.checkEmail(astroEmail)) {
                                                    System.out.print("Please reenter the astronaut's email (name@example.com): ");
                                                    astroEmail = kbd.nextLine();
                                                }
                                            }
                                        } while (!correct.equalsIgnoreCase("correct"));
                                        break;

                                    case 5:
                                        System.out.print("\nPlease edit the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                        kbd.nextLine();
                                        astroPhone = (kbd.nextLine()).trim();
                                        while (!astroPhone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                                            System.out.print("Please reenter the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                            astroPhone = (kbd.nextLine()).trim();
                                        }
                                        correct = "";
                                        do {
                                            System.out
                                                    .println("The astronaut's current phone number in the database is "
                                                            + astroToEdit.phoneNumber() + "\n" +
                                                            "You entered: " + astroPhone + "\n" +
                                                            "If this correct, please enter \"Correct\".\n" +
                                                            "If you wish to go back enter \"Go back\".");
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setPhoneNumber(astroPhone);
                                                dbManager.setAstroPhoneNumber(astroPhone, astroToEdit.getSerialNumber());
                                            } else if (correct.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                System.out.print(
                                                        "Please edit the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                                kbd.nextLine();
                                                astroPhone = (kbd.nextLine()).trim();
                                                while (!astroPhone.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                                                    System.out.print("Please reenter the astronaut's phone number [(XXX)XXX-XXXX]: ");
                                                    astroPhone = (kbd.nextLine()).trim();
                                                }
                                            }
                                        } while (!correct.equalsIgnoreCase("correct"));
                                        break;

                                    case 6:
                                        System.out.print("\nPlease enter/edit the first name of the astronaut's next of kin: ");
                                        kbd.nextLine();
                                        nextOfKinFirst = (kbd.nextLine()).trim();
                                        System.out.print("Please enter/edit the last name of the astronaut's next of kin: ");
                                        nextOfKinLast = (kbd.nextLine()).trim();
                                        astroNextOfKin = nextOfKinFirst + " " + nextOfKinLast;
                                        correct = "";
                                        do {
                                            System.out.println("The astronaut's current next of kin in the database is "
                                                    + astroToEdit.nextOfKin() + "\n" +
                                                    "You entered: " + astroNextOfKin + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setNextOfKin(astroNextOfKin);
                                                dbManager.setAstroNextOfKin(astroNextOfKin, astroToEdit.getSerialNumber());
                                            } else if (correct.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                System.out.print("Please enter the first name of the astronaut's next of kin: ");
                                                kbd.nextLine();
                                                nextOfKinFirst = (kbd.nextLine()).trim();
                                                System.out.print("Please enter the last name of the astronaut's next of kin: ");
                                                nextOfKinLast = (kbd.nextLine()).trim();
                                                astroNextOfKin = nextOfKinFirst + " " + nextOfKinLast;
                                            }
                                        } while (!correct.equalsIgnoreCase("correct"));
                                        break;

                                    case 7:
                                        do {
                                            System.out.print("\nPlease edit the astronaut's planetary status (On Earth/In Space): ");
                                            kbd.nextLine();
                                            astroStatus = (kbd.nextLine()).trim();
                                            if (astroStatus.equalsIgnoreCase("on earth")) {
                                                astroStatus = "On Earth";
                                            } else if (astroStatus.equalsIgnoreCase("in space")) {
                                                astroStatus = "In Space";
                                            } else {
                                                System.out.println(
                                                        "Astronaut status must be \"On Earth\" or \"In Space\".");
                                                System.out.println("Please try again.");
                                            }
                                        } while (!astroStatus.equalsIgnoreCase("on earth")
                                                && !astroStatus.equalsIgnoreCase("in space"));
                                            correct = "";
                                        do {
                                            System.out.println(
                                                    "The astronaut's current planetary status in the database is "
                                                            + astroToEdit.status() + "\n" +
                                                            "You entered: " + astroStatus + "\n" +
                                                            "If this correct, please enter \"Correct\".\n" +
                                                            "If you wish to go back enter \"Go back\".");
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setStatus(astroStatus);
                                                dbManager.setStatus(astroStatus, astroToEdit.getSerialNumber());
                                            } else if (correct.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                System.out.print(
                                                        "Please edit the astronaut's planetary status (On Earth/In Space): ");
                                                kbd.nextLine();
                                                do {
                                                    astroStatus = (kbd.nextLine()).trim();
                                                    if (astroStatus.equalsIgnoreCase("on earth")) {
                                                        astroStatus = "On Earth";
                                                    } else if (astroStatus.equalsIgnoreCase("in space")) {
                                                        astroStatus = "In Space";
                                                    } else {
                                                        System.out.println(
                                                                "Astronaut status must be \"On Earth\" or \"In Space\".");
                                                        System.out.println("Please try again.");
                                                    }
                                                } while (!astroStatus.equalsIgnoreCase("on earth")
                                                        && !astroStatus.equalsIgnoreCase("in space"));
                                            }
                                        } while (!correct.equalsIgnoreCase("correct"));
                                        break;

                                    case 8:
                                        astroPayRate = 0;
                                        do {
                                            System.out.print("\nPlease edit the astronaut's pay rate: ");
                                            try {
                                                astroPayRate = kbd.nextDouble();
                                                if (astroPayRate <= 7.25) {
                                                    System.out.print("The federal minimum wage is $7.50. " +
                                                            "Please enter a new pay rate per hour: ");
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                                kbd.nextLine();
                                            } catch (InputMismatchException e) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                                kbd.nextLine();
                                            }
                                        } while (astroPayRate <= 7.25);
                                        correct = "";
                                        do {
                                            System.out.println("The astronaut's current pay rate in the database is "
                                                    + astroToEdit.payRate() + "\n" +
                                                    "You entered: " + astroPayRate + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                            kbd.nextLine();
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setPayRate(astroPayRate);
                                                dbManager.setPayRate(astroPayRate, astroToEdit.getSerialNumber());
                                            } else if (correct.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                do {
                                                    System.out.print("Please edit the astronaut's pay rate: ");
                                                    try {
                                                        astroPayRate = kbd.nextDouble();
                                                        if (astroPayRate <= 7.25) {
                                                            System.out.print("The federal minimum wage is $7.50. " +
                                                                    "Please enter a new pay rate per hour: ");
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("An error occurred: " + e.getMessage());
                                                        kbd.nextLine();
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("An error occurred: " + e.getMessage());
                                                        kbd.nextLine();
                                                    }
                                                } while (astroPayRate <= 7.25);
                                            }
                                        } while (!correct.equalsIgnoreCase("correct"));
                                        break;

                                    case 9:
                                        astroWeight = 0;
                                        do {
                                            System.out.print("\nPlease enter the astronaut's weight in pounds: ");
                                            try {
                                                astroWeight = kbd.nextDouble();
                                                if (!(astroWeight >= 110 && astroWeight <= 209)) {
                                                    System.out.println("Astronaut must be between 110 and 209 pounds");
                                                }
                                            } catch (NumberFormatException e ) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                                kbd.nextLine();
                                            } catch (InputMismatchException e) {
                                                System.out.println("An error occurred: " + e.getMessage());
                                                kbd.nextLine();
                                            }
                                        } while (!(astroWeight >= 110 && astroWeight <= 209));
                                        correct = "";
                                        do {
                                            System.out.println("The astronaut's current weight in the database is "
                                                    + astroToEdit.weight() + "\n" +
                                                    "You entered: " + astroWeight + "\n" +
                                                    "If this correct, please enter \"Correct\".\n" +
                                                    "If you wish to go back enter \"Go back\".");
                                            kbd.nextLine();
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("Correct")) {
                                                astroToEdit.setWeight(astroWeight);
                                                dbManager.setWeight(astroWeight, astroToEdit.getSerialNumber());
                                            } else if (correct.equalsIgnoreCase("Go back")) {
                                                break;
                                            } else {
                                                do {
                                                    System.out.print("Please enter the astronaut's weight in pounds: ");
                                                    try {
                                                        astroWeight = kbd.nextDouble();
                                                        if (!(astroWeight >= 110 && astroWeight <= 209)) {
                                                            System.out.println("Astronaut must be between 110 and 209 pounds");
                                                        }
                                                    } catch (NumberFormatException e ) {
                                                        System.out.println("An error occurred: " + e.getMessage());
                                                        kbd.nextLine();
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("An error occurred: " + e.getMessage());
                                                        kbd.nextLine();
                                                    }
                                                } while (!(astroWeight >= 110 && astroWeight <= 209));
                                            }
                                        } while (!correct.equalsIgnoreCase("correct"));
                                        break;

                                    case 10:
                                        System.out.println("\nGoing back to previous menu");
                                        break;

                                    default:
                                        System.out.println("\nPlease enter a number 1-10.");
                                        kbd.nextLine();
                                        break;
                                }
                                astros[astroChoice - 1] = astroToEdit;
                            } while (field != 10 && !correct.equalsIgnoreCase("correct"));
                            break;
                        
                        case 3:
                            //Deleting astronauts
                            if (!checker.checkForAstronauts(astros)) {
                                System.out.println("\nThere are no astronauts to delete.");
                                break;
                            }
                            System.out.println("\nWARNING: Deleting an astronaut is permanent.\n" +
                                               "Are you sure you wish to proceed? (Yes/No)");
                            String deletionConfirmation = kbd.nextLine();
                            while (!deletionConfirmation.equalsIgnoreCase("no") && !deletionConfirmation.equalsIgnoreCase("yes")) {
                                System.out.println("Please enter \"yes\" or \"no\".");
                                deletionConfirmation = kbd.nextLine();
                            }
                            if (deletionConfirmation.equalsIgnoreCase("no")) {
                                break;
                            }
                            int astroChoice;
                            //Has user select and delete an astronaut
                            do{
                                astroChoice = astroSelection(kbd, astros);
                                AstroRemoval removeAstro = new AstroRemoval(1);
                                removeAstro.addAstro(astros[astroChoice - 1]);
                                astros[astroChoice - 1] = removeAstro.removeAstronauts(dbManager);
                                astros = dbManager.databaseAstronautArrayRetrieval();
                                break;
                            } while (!(astroChoice <= 0));
                            break;

                        case 4:
                            System.out.println("\nGoing back to previous menu.");
                            break;

                        default:
                            System.out.println("\nPlease enter a number from 1-4");
                            kbd.nextLine();
                            break;
                        }
                    } while (choice2 != 4);
                    break;

                case 2:
                    do{
                        //Ship menu
                        System.out.println("\nShip Menu\n" +
                                           "1. Add Ship\n" +
                                           "2. Edit Ship\n" +
                                           "3. Delete Ship\n" +
                                           "4. Assign Astronaut To Ship\n" +
                                           "5. Go Back");
                        //Int for ship menu switch loop
                        choice2 = 0;
                        try {
                            choice2 = kbd.nextInt();
                        } catch (NumberFormatException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        }
                        int field = 0;
                        //Ship menu loop
                        switch (choice2) {
                            case 1:
                                //Asks user to provide values for new ship object's fields
                                System.out.print("\nPlease enter the ship's name: ");
                                kbd.nextLine();
                                String shipName = (kbd.nextLine()).trim();
                                double shipFuelCapacity = 0;
                                do {
                                    System.out.print("Please enter the ship's fuel capacity: ");
                                    try {
                                        shipFuelCapacity = kbd.nextDouble();
                                    } catch (NumberFormatException e ) {
                                        System.out.println("An error occurred: " + e.getMessage());
                                        kbd.nextLine();
                                    } catch (InputMismatchException e) {
                                        System.out.println("An error occurred: " + e.getMessage());
                                        kbd.nextLine();
                                    }
                                } while (shipFuelCapacity <= 0);
                                double shipCurrentFuel = 0;
                                do {
                                    System.out.print("Please enter the ship's current fuel level: ");
                                    try {
                                        shipCurrentFuel = kbd.nextDouble();
                                        if (shipCurrentFuel > shipFuelCapacity) {
                                            System.out.println("The ship's fuel capacity cannot be " +
                                                               "larger than its capacity (" + shipFuelCapacity +
                                                               ").");
                                        }
                                    } catch (NumberFormatException e ) {
                                        System.out.println("An error occurred: " + e.getMessage());
                                        kbd.nextLine();
                                    } catch (InputMismatchException e) {
                                        System.out.println("An error occurred: " + e.getMessage());
                                        kbd.nextLine();
                                    }
                                } while (shipCurrentFuel > shipFuelCapacity);
                                int shipCrewCapacity = 0;
                                do {
                                    System.out.print("Please enter the ship's crew capacity: ");
                                    try {
                                        shipCrewCapacity = kbd.nextInt();
                                    } catch (NumberFormatException e ) {
                                        System.out.println("An error occurred: " + e.getMessage());
                                        kbd.nextLine();
                                    } catch (InputMismatchException e) {
                                        System.out.println("An error occurred: " + e.getMessage());
                                        kbd.nextLine();
                                    }
                                } while (shipCrewCapacity <= 0);
                                String change = "";
                                kbd.nextLine();
                                //Displays entered informaton for verification
                                do {
                                    System.out.println("\nPlease verify information before saving.\n" +
                                                    "Name: " + shipName + "\n" +
                                                    "Fuel Capacity: " + shipFuelCapacity + "\n" +
                                                    "Current Fuel: " + shipCurrentFuel + "\n" +
                                                    "Crew Capacity: " + shipCrewCapacity);
                                    System.out.println("Is there anything you wish to change? (yes/no)");
                                    change = (kbd.nextLine()).trim();
                                    //Displays fields to edit
                                    if (change.equalsIgnoreCase("yes")) {
                                        System.out.println("\nWhich field do you wish to change?\n");
                                        System.out.println("1. Ship Name\n" +
                                                           "2. Fuel Capacity\n" +
                                                           "3. Current Fuel\n" +
                                                           "4. Crew Capacity\n" +
                                                           "5. Go Back");
                                        System.out.print("Please enter the corresponding number: ");
                                        //Int for ship editing switch loop
                                        try {
                                            field = kbd.nextInt();
                                        } catch (NumberFormatException e) {
                                            System.out.println("An error has occurred: " + e.getMessage());
                                        } catch (InputMismatchException e) {
                                            System.out.println("An error has occurred: " + e.getMessage());
                                        }
                                        //Ship editing switch loop
                                        switch (field) {
                                            case 1:
                                            System.out.print("\nPlease enter the ship's name: ");
                                            kbd.nextLine();
                                            shipName = (kbd.nextLine()).trim();
                                            break;

                                            case 2:
                                            do {
                                                System.out.print("\nPlease enter the ship's fuel capacity in pounds: ");
                                                try {
                                                    shipFuelCapacity = kbd.nextDouble();
                                                    while (shipCurrentFuel > shipFuelCapacity) {
                                                        System.out.println("The current fuel level is higher than the capacity.");
                                                        System.out.print("Please enter the ship's current fuel level in pounds: ");
                                                        shipCurrentFuel = kbd.nextDouble();
                                                    }
                                                } catch (NumberFormatException e ) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                }
                                            } while (shipFuelCapacity <= 0);
                                            break;

                                            case 3:
                                            do {
                                                System.out.print("\nPlease enter the ship's current fuel level in pounds: ");
                                                try {
                                                    shipCurrentFuel = kbd.nextDouble();
                                                    if (shipCurrentFuel > shipFuelCapacity) {
                                                        System.out.println("The ship's fuel capacity cannot be " +
                                                                           "larger than its capacity (" + shipFuelCapacity +
                                                                           ").");
                                                    }
                                                } catch (NumberFormatException e ) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                }
                                            } while (shipCurrentFuel > shipFuelCapacity);
                                            break;

                                            case 4:
                                            do {
                                                System.out.print("\nPlease enter the ship's crew capacity: ");
                                                try {
                                                    shipCrewCapacity = kbd.nextInt();
                                                } catch (NumberFormatException e ) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                }
                                            } while (shipCrewCapacity <= 0);
                                            break;

                                            case 5:
                                                System.out.println("\nGoing back to previous menu");

                                            default:
                                            System.out.println("\nPlease enter a number 1-5");
                                            kbd.nextLine();
                                            break;
                                        }
                                    }
                                } while (!change.equalsIgnoreCase("no"));
                                int count = 0;
                                for (count = 0; count < ships.length; count++) {
                                    if (ships[count] == null) {
                                        ships[count] = new Ship();
                                        ships[count].setSName(shipName);
                                        ships[count].setFCap(shipFuelCapacity);
                                        ships[count].setFuel(shipCurrentFuel);
                                        ships[count].setSCap(shipCrewCapacity);
                                        ships[count].setData(dbManager);
                                        break;
                                    }
                                }
                                //Tries to save ship info to database
                                dbManager.addShipToDatabase(ships[count]);
                                break;

                            case 2:
                                //Editing ships
                                if (!checker.checkForShips(ships)) {
                                    System.out.println("\nThere are no ships to edit.");
                                    break;
                                }
                                int shipChoice = shipSelection(kbd, ships);
                                Ship shipToEdit = ships[shipChoice - 1];
                                
                                //Gives current information for the chosen ship
                                System.out.println("\nThis is the current information for " + shipToEdit.getSName() + ".\n" +
                                                   "Ship Name: " + shipToEdit.getSName() + "\n" +
                                                   "Fuel Capacity: " + shipToEdit.getFCap() + "\n" +
                                                   "Fuel: " + shipToEdit.getFuel() + "\n" +
                                                   "Ship Capacity: " + shipToEdit.getSCap());
                                System.out.println("\nFields\n" +
                                                    "1. Ship name\n" +
                                                    "2. Fuel Capacity\n" +
                                                    "3. Fuel\n" +
                                                    "4. Ship Capacity\n" +
                                                    "5. Go Back");
                                System.out.println("Please select a field: ");
                                //Int for ship editing switch loop
                                try {
                                    field = kbd.nextInt();
                                } catch (NumberFormatException e) {
                                    System.out.println("An error has occurred: " + e.getMessage());
                                } catch (InputMismatchException e) {
                                    System.out.println("An error has occurred: " + e.getMessage());
                                }
                                //Ship editing switch loop
                                switch (field) {
                                    case 1:
                                        String theKey = "";
                                        boolean changeSuccessful = false;
                                        do {
                                            System.out.println("\nPlease edit the ship's name: ");
                                            kbd.nextLine();
                                            shipName = (kbd.nextLine()).trim();
                                            System.out.println("The ship's current name in the database is \'" + shipToEdit.getSName() + "\'.\n" +
                                                               "You entered the name \'" + shipName + "\'.\n" +
                                                               "If this is correct, enter \"correct\".\n" +
                                                               "If you wish to go back, enter \"Go back\".");
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                dbManager.setShipName(shipToEdit.getSName(), shipName);
                                                shipToEdit.setSName(shipName); 
                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) && !(changeSuccessful));
                                        break;

                                    case 2:
                                        theKey = "";
                                        changeSuccessful = false;
                                        do {
                                            shipFuelCapacity = 0;
                                            do {
                                                System.out.println("\nPlease edit the ship's fuel capacity in pounds: ");
                                                try {
                                                    shipFuelCapacity = kbd.nextDouble();
                                                } catch (NumberFormatException e ) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                }
                                            } while (shipFuelCapacity <= 0);
                                            System.out.println("The ship's current fuel capacity in the database is \'" + shipToEdit.getFCap() + "\'.\n" +
                                                            "You entered the number \'" + shipFuelCapacity + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                shipCurrentFuel = shipToEdit.getFuel();
                                                do {
                                                    try {
                                                        
                                                        while (shipCurrentFuel > shipFuelCapacity || !(changeSuccessful)) {
                                                            System.out.println("The current fuel level is higher than the capacity.");
                                                            System.out.print("Please enter the ship's current fuel level in pounds: ");
                                                            shipCurrentFuel = kbd.nextDouble();
                                                            System.out.println("The ship's current fuel amount in the database is \'" + shipToEdit.getFuel() + "\'.\n" +
                                                                            "You entered the number \'" + shipCurrentFuel + "\'.\n" +
                                                                            "If this is correct, enter \"correct\".");
                                                            kbd.nextLine();
                                                            correct = kbd.nextLine();
                                                            if (correct.equalsIgnoreCase("correct") && shipCurrentFuel <= shipFuelCapacity) {
                                                                shipToEdit.setFuel(shipCurrentFuel); 
                                                                dbManager.setShipFuel(shipToEdit.getSName(), shipCurrentFuel);
                                                                changeSuccessful = true;
                                                            }
                                                        }
                                                    } catch (NumberFormatException e ) {
                                                        System.out.println("An error occurred: " + e.getMessage());
                                                        kbd.nextLine();
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("An error occurred: " + e.getMessage());
                                                        kbd.nextLine();
                                                    }
                                                } while (!changeSuccessful);
                                                shipToEdit.setFCap(shipFuelCapacity); 
                                                dbManager.setShipFuelCapacity(shipToEdit.getSName(), shipFuelCapacity);
                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(correct.equalsIgnoreCase("go back")) && !(changeSuccessful));
                                        break;

                                    case 3:
                                        theKey = "";
                                        changeSuccessful = false;
                                        do {
                                            shipCurrentFuel = 0;
                                            do {
                                                System.out.println("\nPlease edit the ship's current fuel in pounds: ");
                                                try {
                                                    shipCurrentFuel = kbd.nextDouble();
                                                    if (shipCurrentFuel > shipToEdit.getFCap()) {
                                                        System.out.println("The ship's fuel capacity cannot be " +
                                                                           "larger than its capacity (" + shipToEdit.getFCap() +
                                                                           ").");
                                                    }
                                                } catch (NumberFormatException e ) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                } catch (InputMismatchException e) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                    kbd.nextLine();
                                                }
                                            } while (shipCurrentFuel > shipToEdit.getFCap());
                                            System.out.println("The ship's current fuel amount in the database is \'" + shipToEdit.getFuel() + "\'.\n" +
                                                            "You entered the number \'" + shipCurrentFuel + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            correct = kbd.nextLine();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                shipToEdit.setFuel(shipCurrentFuel); 
                                                dbManager.setShipFuel(shipToEdit.getSName(), shipCurrentFuel);
                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(theKey.equalsIgnoreCase("go back")) && !(changeSuccessful));
                                        break;

                                    case 4:
                                        changeSuccessful = false;
                                        do {
                                            shipCrewCapacity = 0;
                                            do {
                                                System.out.println("\nPlease edit the ship's crew capacity: ");
                                                try {
                                                    shipCrewCapacity = kbd.nextInt();
                                                } catch (NumberFormatException e ) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                } catch (InputMismatchException e) {
                                                    System.out.println("An error occurred: " + e.getMessage());
                                                }
                                            } while (shipCrewCapacity <= 0);
                                            System.out.println("The ship's current crew capacity in the database is \'" + shipToEdit.getSCap() + "\'.\n" +
                                                            "You entered the number \'" + shipCrewCapacity + "\'.\n" +
                                                            "If this is correct, enter \"correct\".\n" +
                                                            "If you wish to go back, enter \"Go back\".");
                                            kbd.nextLine();
                                            correct = (kbd.nextLine()).trim();
                                            if (correct.equalsIgnoreCase("correct")) {
                                                shipToEdit.setSCap(shipCrewCapacity); 
                                                dbManager.setShipCapacity(shipToEdit.getSName(), shipCrewCapacity);
                                                changeSuccessful = true;
                                            } else if (correct.equalsIgnoreCase("go back")) {
                                                break;
                                            }
                                        } while (!(correct.equalsIgnoreCase("go back")) && !(changeSuccessful));
                                        break;

                                    case 5: 
                                        System.out.println("\nGoing back to the previous menu.");
                                        break;

                                    default:
                                        System.out.println("\nPlease enter a number 1-5");
                                        kbd.nextLine();
                                        break;
                                    }
                                ships[shipChoice - 1] = shipToEdit;
                                break;

                            case 3:
                                //Deleting ships
                                if (!checker.checkForShips(ships)) {
                                    System.out.println("\nThere are no ships to delete.");
                                    break;
                                }
                                System.out.println("\nWARNING: Deleting an ship is permanent.\n" +
                                                   "Are you sure you wish to proceed? (Yes/No)");
                                String deletionConfirmation = kbd.nextLine();
                                while (!deletionConfirmation.equalsIgnoreCase("no") && !deletionConfirmation.equalsIgnoreCase("yes")) {
                                    System.out.println("Please enter \"yes\" or \"no\".");
                                    deletionConfirmation = kbd.nextLine();
                                }
                                if (deletionConfirmation.equalsIgnoreCase("no")) {
                                    break;
                                }
                                //Removes ship after asking for ship to delete and verifying
                                do {
                                    shipChoice = shipSelection(kbd, ships);
                                    ShipRemoval removeShip = new ShipRemoval(ships[shipChoice - 1]);
                                    ships[shipChoice - 1] = removeShip.removeShip(dbManager);
                                    ships = dbManager.databaseShipArrayRetrieval();
                                } while (shipChoice <= 0);
                                break;

                            case 4:
                                //Assigning astronauts to ships
                                if (!checker.checkForShips(ships)) {
                                    System.out.println("\nThere are no ships to assign astronauts to.");
                                    break;
                                } else if (!checker.checkForAstronauts(astros)) {
                                    System.out.println("\nThere are no astronauts to assign.");
                                    break;
                                }
                                //Asks for astronaut to assign and ship to assign to, then adds astronaut to ship
                                int astroChoice = astroSelection(kbd, astros);
                                shipChoice = shipSelection(kbd, ships);
                                ships[shipChoice -1].addAstro(astros[astroChoice - 1]);
                                break;

                            case 5:
                                System.out.println("\nGoing back to previous menu.");
                                break;

                            default:
                                System.out.println("\nPlease enter a number 1-5.");
                                kbd.nextLine();
                                break;
                        }
                    } while (choice2 != 5);
                    break;

                case 3:
                    do {
                        //Launch menu
                        System.out.println("\n1. Select a Ship\n" +
                                           "2. Back to main menu");
                        //Int for ship menu switch loop
                        try {
                            choice2 = kbd.nextInt();
                        } catch (NumberFormatException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        }
                        int shipChoice;
                        //Ship menu switch loop
                        switch (choice2) {
                            case 1:
                                if (!checker.checkForShips(ships)) {
                                    System.out.println("\nThere are no ships to launch.");
                                    break;
                                }
                                shipChoice = shipSelection(kbd, ships);
                                String launchConfirmation = "";
                                do {
                                    System.out.println("\nWARNING: Launching is irreversible and can result in death when gone wrong.\n" +
                                                       "Are you sure you wish to proceed? (Yes/No)");
                                    launchConfirmation = (kbd.nextLine()).trim();
                                    if (launchConfirmation.equalsIgnoreCase("yes")) {
                                        ships[shipChoice - 1].launch();
                                        if (ships[shipChoice -1].getFailure()) {
                                            ShipRemoval shipRemoval = new ShipRemoval(ships[shipChoice - 1]);
                                            shipRemoval.removeShip(dbManager);
                                            ships = dbManager.databaseShipArrayRetrieval();
                                        }
                                    } else if (launchConfirmation.equalsIgnoreCase("no")) {
                                        System.out.println("The ship will not be launched.");
                                        break;
                                    }
                                } while (!(launchConfirmation.equalsIgnoreCase("yes") && !launchConfirmation.equalsIgnoreCase("no")));
                                break;

                            case 2:
                                System.out.println("\nGoing back to previous menu.");
                                break;

                            default:
                                System.out.println("\nPlease enter a number 1-2.");
                                kbd.nextLine();
                                break;
                        }
                    } while (choice2 != 2);
                    break;
                    

                case 4:
                    System.out.println("\nClosing program...");
                    break;

                default:
                    System.out.println("\nPlease select a number 1-4");
                    kbd.nextLine();
                    break;
            }
        } while (choice != 4);
    }
    
    dbManager.cutConnection();
    kbd.close();
    System.exit(0);
}

/**
 * Has the user attempt to login to the application
 * @param scan The scanner used to gather input from the user
 * @return Whether the user is allowed to enter the application
 */
public static boolean LoggingInPassword(Scanner scan) {
    //Method Variables
    boolean createPassword = true;
    boolean allowedEntry = false;
    File file = new File("ApplicationPassword.dat");
    int applicationPassword = -800305;

    //Checks for the existence of a password file
    if (file.exists()) {
        try {
            //Reads value from file and assigns it to a variable
            Scanner fileReader = new Scanner(file);
            applicationPassword = fileReader.nextInt();
            fileReader.close();
            createPassword = false;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    if (createPassword) {
        //First time application is run
        createApplicationPassword(file);
        createPassword = false;
        allowedEntry = true;
    } else {
        //After first time application is run
        int loginChoice = 0;
        do {
            //Login Menu
            System.out.println("\n1. Enter Password to Application\n" +
                               "2. Enter Admin Password to Reset Application Password\n" +
                               "3. Quit");
            //Int for login menu switch loop
            try {
                loginChoice = scan.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("An error has occurred: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("An error has occurred: " + e.getMessage());
            }
            //Login menu switch loop
            switch (loginChoice) {
                case 1:
                    String enteredPassword = "";
                    scan.nextLine();
                    do {
                        //Asks for application password and allows entry if correct
                        System.out.println("Please enter the password for the application or \"Go Back\": ");
                        try {
                            enteredPassword = scan.nextLine();
                        } catch (NumberFormatException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        }
                        if (enteredPassword.equalsIgnoreCase("Go back")) {
                            break;
                        }else if (enteredPassword.equalsIgnoreCase(String.valueOf(applicationPassword))) {
                            allowedEntry = true;
                        } else {
                            System.out.println("You input the wrong password.");
                        }
                    } while (!allowedEntry && !enteredPassword.equalsIgnoreCase("go back"));
                    break;

                case 2:
                    //Asks for admin password. Resets application password and allows entry if correct
                    int trueAdminPass = -298756;
                    File adminFile = new File("adminPassword.dat");
                    try {
                        Scanner fileReader = new Scanner(adminFile);
                        trueAdminPass = fileReader.nextInt();
                        fileReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    String adminPass = "";
                    scan.nextLine();
                    do {
                        System.out.println("Please enter the admin password or \"Go Back\": ");
                        try {
                            adminPass = scan.nextLine();
                        } catch (NumberFormatException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("An error has occurred: " + e.getMessage());
                        }
                        if (adminPass.equalsIgnoreCase(String.valueOf(trueAdminPass))) {
                            createApplicationPassword(file);
                            allowedEntry = true;
                        } else if (adminPass.equalsIgnoreCase("Go back")) {
                            break;
                        } else {
                            System.out.println("You input the wrong password.");
                        }
                    } while (!(adminPass.equalsIgnoreCase("Go back")) && !allowedEntry);
                    
                    break;

                case 3:
                    System.out.println("Quitting the application");
                    break;

                default:
                    System.out.println("\nPlease enter a number 1-3.");
                    scan.nextLine();
                    break;
            }
        } while ((loginChoice != 3) && (allowedEntry == false));

    }
    return allowedEntry;
}

/**
 * Creates a new password for the application and updates the file for it
 * @param f The file object for the password that is updated
 */
public static void createApplicationPassword(File f) {
    //Creates password
    System.out.println("Creating Password...");
    Random r = new Random();
    int passNum = 0;
    String pass, pass2 = "";
    for (int i = 0; i < 9; i++) {
        pass = Integer.toString(r.nextInt(10));
        pass2 += pass;
    }
    //Displays password
    passNum = Integer.parseInt(pass2);
    System.out.println("Please write down the following password: " + passNum);
    System.out.println("This password will be required the next time the application is opened.");
    //Saves password to file
    try {
        PrintWriter pw = new PrintWriter(f);
        pw.print(passNum);
        pw.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}

/**
 * Has the user select an Astronaut object
 * @param kbd The scanner used to gather user input
 * @param astros The Astronaut array from which the object is chosen
 * @return An integer to represent the chosen object, 1 more than the index of the object in the array
 */
public static int astroSelection(Scanner kbd, Astronaut[] astros) {
    // Ask user to select an astronaut
    int count = 0;
    int astroChoice = 0;
    String astroConfirmation = "";
    do {
        do {
            //Shows existing astronauts in array and asks user to chose one
            System.out.println("Please choose the corresponding integer to select an astronaut:");
            astroChoice = 0;
            count = 0;
            for (Astronaut a : astros) {
                if (a != null) {
                    count++;
                    System.out.println(count + ". " + a.getName());
                }
            }
            //User selects Astronaut object
            try {
                astroChoice = kbd.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("An error has occurred: " + e.getMessage());
            }  catch (InputMismatchException e) {
                System.out.println("An error has occurred: " + e.getMessage());
                kbd.nextLine();
            }
        } while (!(astroChoice >= 1 && astroChoice <= count));
        //User confirms whether it is the correct astronaut
        astroConfirmation = "";
        System.out.println("Chosen astronaut: " + astros[astroChoice - 1].getName());
        System.out.println("Is this the correct astronaut? (Yes/No)");
        kbd.nextLine();
        astroConfirmation = (kbd.nextLine()).trim();
    } while (!astroConfirmation.equalsIgnoreCase("yes"));
    return astroChoice;
}

/**
 * Has the user select a Ship object
 * @param kbd The scanner used to gather input from the user
 * @param ships The Ship array from which the object is chosen
 * @return An integer to represent the chosen object, 1 more than the index of the object in the array
 */
public static int shipSelection(Scanner kbd, Ship[] ships) {
    // Ask the user to select a ship
    int count = 0;
    int shipChoice = 0;
    String shipConfirmation = "";
    do {
        do {
            //Shows existing ships in array and asks user to choose one
            System.out.println("Please choose the corresponding integer to select a ship:");
            shipChoice = 0;
            count = 0;
            for (Ship s : ships) {
                if (s != null) {
                    count++;
                    System.out.println(count + ". " + s.getSName());
                }
            }
            //User selects a Ship object
            try {
                shipChoice = kbd.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("An error has occurred: " + e.getMessage());
                kbd.nextLine();
            }
        } while (!(shipChoice >= 1 && shipChoice <= count));
        //User confirms whether it is the correct Ship object
        shipConfirmation = "";
        System.out.println("Chosen ship: " + ships[shipChoice - 1].getSName());
        System.out.println("Is this the correct ship? (Yes/No)");
        kbd.nextLine();
        shipConfirmation = (kbd.nextLine()).trim();
    } while (!shipConfirmation.equalsIgnoreCase("yes"));
    return shipChoice;
}
}
