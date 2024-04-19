//import java.util.Random;

public class Astronaut{
    
    //Strings, doubles and the ints.
    String Name;
    String dateOfBirth;
    int serialNumber;
    String address;
    String email;
    String phoneNumber;
    String nextOfKin;
    String status;
    double payRate;
    double weight;

    /**
     * The constructor for the astronaut class. Asks for field values and creates a serial number for the astronaut.
     * @param astroName The name of the astronaut
     * @param astroDateOfBirth The astronaut's date of birth
     * @param astroAddress The astronaut's living adress
     * @param astroEmail The astronaut's email address
     * @param astroPhoneNumber The astronaut's phone number
     * @param astroNextOfKIn The name of the astronaut's next of kin
     * @param astroStatus Whether the astronaut is currently in space or on Earth
     * @param astroPayRate The astronaut's pay rate
     * @param astroWeight The astronauts weight in pounds
     */
    public Astronaut(){
        SerialNumberGenerator snGenerator = new SerialNumberGenerator(0);
        serialNumber = snGenerator.generateNextSerial();

    }

    /**
     * Makes an astronaut go on a spacewalk
     * @param astro The astronaut sent on a spacewalk
     */
    public void spaceWalk(){
        //more code goes here? not sure what though xd
    }

        //***We Need this***
    /**
     * Gives the value of the astronaut's serial number
     * @return The astronaut's serial number
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    //Getter And Setters for the Variables
    //String Name
    /**
     * Gives the value of the astronaut's
     * @return The string value of the astronaut's name
     */
    public String getName(){
        return Name;
    }
    /**
     * Overwrites the astronaut's name with a new, user-supplied value
     * @param newName The new string value of the astronaut's name
     */
    public void setName(String newName){
        this.Name = newName;
    }

    //String dateOfBirth
    /**
     * Gives the value of the astronaut's date of birth
     * @return The string value of the astronaut's date of birth
     */
    public String dateOfBirth(){
        return dateOfBirth;
    }
    /**
     * Overwrites the astronaut's date of birth with a new, user-supplied value
     * @param newSetDateOfBirth The new string value of the astronaut's date of birth
     */
    public void setdateOfBirth(String newSetDateOfBirth){
        this.dateOfBirth = newSetDateOfBirth;
    }

    //int serialNumber
    /**
     * Gives the value of the astronaut's serial number
     * @return The integer value of the astronaut's serial number
     */
    public int serialNumber(){
        return serialNumber;
    }
    /**
     * Overwrites the astronaut's serialNumber with a new, user-supplied value
     * @param newSerialNumber The new integer value of the astronaut's serial number
     */
    public void setSerialNumber(int newSerialNumber){
        this.serialNumber = newSerialNumber;
    }

    //String address
    /**
     * Gives the value of the astronaut's living address
     * @return The string value of the astronaut's address
     */
    public String address(){
        return address;
    }
    /**
     * Overwrites the astronaut's living address with a new, user-supplied value
     * @param newAddress The new string value of the astronaut's living address
     */
    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    //String email
    /**
     * Gives the value of the astronaut's email address
     * @return The string value of the astronaut's email address
     */
    public String email(){
        return email;
    }
    /**
     * Overwrites the astronaut's email address with a new, user-supplied value
     * @param newEmail The new string value of the astronaut's email address
     */
    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    //String phoneNumber
    /**
     * Gives the value of the astronaut's phone number
     * @return The string value of the astronaut's phone number
     */
    public String phoneNumber(){
        return phoneNumber;
    }
    /**
     * Overwrites the astronaut's phone number with a new, user-supplied value
     * @param newPhoneNumber The new string value of the astronaut's phone number
     */
    public void setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
    }

    //String nextOfKin
    /**
     * Gives the value of the astronaut's next of kin
     * @return The string value of the name of the astronaut's next of kin
     */
    public String nextOfKin(){
        return nextOfKin;
    }
    /**
     * Overwrites the name of the astronaut's next of kin with a new, user-supplied value
     * @param newNextOfKin The new string value for the name of the astronaut's next of kin
     */
    public void setNextOfKin(String newNextOfKin){
        this.nextOfKin = newNextOfKin;
    }

    //String status
    /**
     * Gives the string value of the astronaut's status
     * @return Whether the astronaut is in space or on Earth
     */
    public String status(){
        return status;
    }
    /**
     * Overwrites the astronaut's status with a new, user-supplied value
     * @param newStatus The new string value of the astronaut's status
     */
    public void setStatus(String newStatus){
        this.status = newStatus;
    }

    //double payRate
    /**
     * Gives the value of the astronaut's pay rate
     * @return The double value of the astronaut's pay rate
     */
    public double payRate(){
        return payRate;
    }
    /**
     * Overwrites the astronaut's pay rate with a new, user-supplied value
     * @param newPayRate The new double value of the astronaut's pay rate
     */
    public void setPayRate(double newPayRate){
        this.payRate = newPayRate;
    }

    //double weight
    /**
     * Gives the value of the astronaut's weight in pounds
     * @return The double value of the astronaut's weight
     */
    public double weight(){
        return weight;
    }
    /**
     * Overwrites the astronaut's weight with a new, user-supplied value
     * @param newWeight The new double value of the astronaut's weight in pounds
     */
    public void setWeight(double newWeight){
        this.weight = newWeight;
    }
}