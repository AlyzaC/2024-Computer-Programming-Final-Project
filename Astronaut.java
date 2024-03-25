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
    public String generateSerialNumber(){

        //Constructor to set the starting point
    public SerialNumberGenerator(int StartingPointSN){
        this.currentSerial = startingPointSN;
    }

        //creates a random number to be serialNumber
        //Counter makes it sequential
        public int generateNextSerial(){
            int serialNumber = currentSerial;
            currentSerial++;

            //Output the Serial Number (return serialNumber)
            return serialNumber;
        }
        

        //Need to figure out how to make it a "*Sequentially* Generated Serial Number" (1, 2, 3, 4, 5,)
    }
    
}