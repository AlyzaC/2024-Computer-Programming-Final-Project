import java.util.Random;

public class Astronaut{
    //Strings and doubles
    String Name;
    String dateOfBirth;
    String serialNumber;
    String address;
    String email;
    String phoneNumber;
    String nextOfKin;
    String status;
    double payRate;
    double weight;

        //Makes the astronaut go on a space walk? Not sure. ;-;
    public void spaceWalk(){
        //more code goes here? not sure what though xd
    }

        //CREATES SERIAL NUMBER
    public static String generateSerialNumber(){
        //put more code that creates a Serial Number

        //creates a random number to be serialNumber
        Random random = new Random();
        int randomNumber = random.nextInt(99999);

        //
        String serialNumber = "SN" + randomNumber;

        return serialNumber;
    }
    
}