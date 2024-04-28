public class ShipRemoval {
    //Fields
        private Ship shipToRemove;

    //Constructor
        public ShipRemoval(Ship s) {
            shipToRemove = s;
            System.out.println(shipToRemove.getSName());
        }

    //Method  
    /**
     * Removes ship
     * @param c A SQL connection provided by the user
     */
        public Ship removeShip(DatabaseManager d) {
            d.removeShipFromDatabase(shipToRemove.getSName());
            shipToRemove.setSName(null);
            shipToRemove.setSCap(0);
            shipToRemove.setFCap(0);
            shipToRemove.setFuel(0.0);
            shipToRemove = null;
            System.out.println("\nShip has been successfully removed.");
            return shipToRemove;
        }
}
