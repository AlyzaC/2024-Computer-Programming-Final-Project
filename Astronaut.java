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

    public Astronaut(){
        SerialNumberGenerator snGenerator = new SerialNumberGenerator(0);
        serialNumber = snGenerator.generateNextSerial();

    }

        //Makes the astronaut go on a space walk?
    public void spaceWalk(){
        //more code goes here? not sure what though xd
    }

        //***We Need this***
    public int getSerialNumber() {
        return serialNumber;
    }

    //Getter And Setters for the Variables
    //String Name
    public String getName(){
        return Name;
    }
    public void setName(String newName){
        this.Name = newName;
    }

    //String dateOfBirth
    public String dateOfBirth(){
        return dateOfBirth;
    }
    public void setdateOfBirth(String newSetDateOfBirth){
        this.dateOfBirth = newSetDateOfBirth;
    }

    //int serialNumber
    public int serialNumber(){
        return serialNumber;
    }
    public void setSerialNumber(int newSerialNumber){
        this.serialNumber = newSerialNumber;
    }

    //String address
    public String address(){
        return address;
    }
    public void setAddress(String newAddress){
        this.address = newAddress;
    }

    //String email
    public String email(){
        return email;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    //String phoneNumber
    public String phoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String newPhoneNumber){
        this.phoneNumber = newPhoneNumber;
    }

    //String nextOfKin
    public String nextOfKin(){
        return nextOfKin;
    }
    public void setNextOfKin(String newNextOfKin){
        this.nextOfKin = newNextOfKin;
    }

    //String status
    public String status(){
        return status;
    }
    public void setStatus(String newStatus){
        this.status = newStatus;
    }

    //double payRate
    public double payRate(){
        return payRate;
    }
    public void setPayRate(double newPayRate){
        this.payRate = newPayRate;
    }

    //double weight
    public double weight(){
        return weight;
    }
    public void setWeight(double newWeight){
        this.weight = newWeight;
    }
}