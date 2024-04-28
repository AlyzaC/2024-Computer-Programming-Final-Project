import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputAndArrayChecker {
    //Fields and Objects
    boolean objectsExist = false;
    boolean stringIsValid = false;

    //Methods
    /**
     * Checks for the existence of at least one Astronaut object in an Astronaut array
     * @param astroArrayToBeChecked The Astronaut array to be checked for objects
     * @return Whether there is at least one object in the array
     */
    public boolean checkForAstronauts(Astronaut[] astroArrayToBeChecked) {
        objectsExist = false;
        for (Astronaut a : astroArrayToBeChecked) {
            if (a != null) {
                objectsExist = true;
                break;
            }
        }
        return objectsExist;
    }

    /**
     * Checks for the existence of at least one Ship object in an Ship array
     * @param shipArrayToBeChecked The Ship array to be checked for objects
     * @return Whether there is at least one object in the array
     */
    public boolean checkForShips(Ship[] shipArrayToBeChecked) {
        objectsExist = false;
        for (Ship s : shipArrayToBeChecked) {
            if (s != null) {
                objectsExist = true;
                break;
            }
        }
        return objectsExist;
    }

    /**
     * Checks the validity of a birthdate input string
     * @param birthString The birthdate string to be checked for validity
     * @return Whether the birthdate string is valid
     */
    public boolean checkBirthdateString(String birthString) {
        //Method variables
        stringIsValid = true;
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String firstNumStr = "", secondNumStr = "", thirdNumStr = "";
        int firstNum = 0, secondNum = 0, thirdNum = 0;
        try {
            firstNumStr = birthString.substring(0, 2);
            secondNumStr = birthString.substring(3, 5);
            thirdNumStr = birthString.substring(6, 10);
        } catch (StringIndexOutOfBoundsException e) {
            stringIsValid = false;
        }
        try {
            firstNum = Integer.parseInt(firstNumStr);
            secondNum = Integer.parseInt(secondNumStr);
            thirdNum = Integer.parseInt(thirdNumStr);
        } catch (NumberFormatException e) {
            stringIsValid = false;
        } catch (InputMismatchException e) {
            stringIsValid = false;
        }

        try {
            if (!birthString.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
                stringIsValid = false;
                System.out.println("String does not follow pattern/format");
            } else {
                if (!(firstNum >= 1 && firstNum <= daysInMonths[secondNum - 1])) {
                    stringIsValid = false;
                    System.out.println("The day exceeds the number of days for that month");
                } else if (!(secondNum >= 1 && secondNum <= 12)) {
                    stringIsValid = false;
                    
                } else if (!(thirdNum >= 1944)) {
                    System.out.println("How about we don't send someone over 80 onto a spacecraft, yeah?");
                    stringIsValid = false;
                } else if (!(thirdNum <= 2005)) {
                    stringIsValid = false;
                    System.out.println("Astronaut must be older than eighteen (18) years of age");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Number for months must be between 1 and 12");
            stringIsValid = false;
        }

        return stringIsValid;
    }

    /**
     * Checks the validity of an email input string
     * @param email
     * @return Whether the email string is valid
     */
    public boolean checkEmail(String email) {
        //Method Variables
        stringIsValid = true;
        int symbolIndex = email.indexOf("@");
        int symbolCount = 0;
        char[] stringCharacters = new char[email.length()];
        email.getChars(0, email.length(), stringCharacters, 0);
        Pattern emailDomain1 = Pattern.compile(".com");
        Pattern emailDomain2 = Pattern.compile("@");
        Matcher matcher1 = emailDomain1.matcher(email);
        Matcher matcher2 = emailDomain2.matcher(email);
    
        for (char c : stringCharacters) {
            if (c == '@') {
                symbolCount++;
            }
        }
        for (char c: stringCharacters) {
            if (Character.isWhitespace(c)) {
                stringIsValid = false;
            } else if (!Character.isLetterOrDigit(c) && !(c == '@') && !(c == '.')) {
                stringIsValid = false;
            }
        }
    
        try {
            if (matcher1.find() && matcher2.find()) {
                if (symbolCount != 1) {
                    System.out.println("Email cannot have more than one (1) \'@\' symbol.");
                    stringIsValid = false;
                } else if (email.lastIndexOf(".") < email.indexOf("@")) {
                    System.out.println("Email extension must included at the end of the email");
                    stringIsValid = false;
                } else if (!(Character.isLetter(stringCharacters[symbolIndex + 1]) && Character.isLetter(stringCharacters[symbolIndex + 2]))) {
                    System.out.println("Domain name must be at included in email");
                    stringIsValid = false;
                } else if (!Character.isLetterOrDigit(stringCharacters[0])) {
                    System.out.println("Email must include a username/local-part at beginning of email");
                    stringIsValid = false;
                }
            } else {
                stringIsValid = false;
            }
        } catch (NullPointerException e) {
            System.out.println("Email must include a domain and extension at the end");
        }
        
        return stringIsValid;
    }
}
