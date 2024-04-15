public class SerialNumberGenerator {
    int currentSerial;

     //Constructor to set the starting point
     /**
      * The constructor for the SerialNumberGenerator class.  Asks for a starting point for the generator
      * @param startingPointSN The starting point for the serial number generator
      */
     public SerialNumberGenerator(int startingPointSN){
        this.currentSerial = startingPointSN;
    }

        //creates a random number to be serialNumber
        //Counter makes it sequential
        /**
         * Creates the next serial number and returns its value
         * @return The value of the serial number
         */
        public int generateNextSerial(){
            int serialNumber = currentSerial;
            currentSerial++;

            //Output the Serial Number (return serialNumber)
            return serialNumber;
        }
        
        //Gives a Sequentially Generated Serial Number & outputs it
    
        public static void main(String[] args){
            SerialNumberGenerator generator = new SerialNumberGenerator(0);
            for (int i = 0; i < 10; i++){
                System.out.println(generator.generateNextSerial());
            }
        }
}
