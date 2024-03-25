//import java.util.Random;

public class Astronaut{
    
    //Strings and doubles
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

        //Makes the astronaut go on a space walk? Not sure. ;-;
    public void spaceWalk(){
        //more code goes here? not sure what though xd
    }

    // Did in new class commented out because we don't need it anymore.
    // public int getSerialNumber() {
    //     return serialNumber;
    // }
    
}