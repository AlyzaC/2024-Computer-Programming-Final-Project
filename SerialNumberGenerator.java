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
        
        //Need to figure out how to make it a "*Sequentially* Generated Serial Number" (1, 2, 3, 4, 5,)
    
        public static void main(String[] args){
            SerialNumberGenerator generator = new SerialNumberGenerator(1000);
            for (int i = 0; i < 10; i++){
                System.out.println(generator.generateNextSerial());
            }
        }
}
