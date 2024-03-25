public class SerialNumberGenerator {
    int currentSerial;

     //Constructor to set the starting point
     
     public SerialNumberGenerator(int startingPointSN){
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
        
        //Gives a Sequentially Generated Serial Number & outputs it
    
        public static void main(String[] args){
            SerialNumberGenerator generator = new SerialNumberGenerator(1000);
            for (int i = 0; i < 10; i++){
                System.out.println(generator.generateNextSerial());
            }
        }
}
