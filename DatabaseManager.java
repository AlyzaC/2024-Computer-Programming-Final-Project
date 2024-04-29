import java.io.*;
import java.sql.*;

public class DatabaseManager {
    //Fields and Objects
    private Connection appConnect = null;
    private Statement stmnt = null;
    private File database = new File("ApplicationDatabase.sqlite");
    private Astronaut[] astrosFromDatabase = new Astronaut[20];
    private Ship[] shipsFromDatabase = new Ship[10];

    //Constructor 
    /**
     * The constructor for the DatabaseManager class. Creates Connection and Statement 
     * objects for a sqlite database. If the database does not already exist, a new one 
     * will be created with tables for astronauts and ships.
     */
    public DatabaseManager() {
        try {
            if (database.exists()) {
                Class.forName("org.sqlite.JDBC");
                appConnect = DriverManager.getConnection("jdbc:sqlite:ApplicationDatabase.sqlite");
                stmnt = appConnect.createStatement();
            } else if (database.createNewFile()) {
                Class.forName("org.sqlite.JDBC");
                appConnect = DriverManager.getConnection("jdbc:sqlite:ApplicationDatabase.sqlite");
                stmnt = appConnect.createStatement();
                createTables(stmnt);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    //Methods
    /**
     * Closes the class's Connection and Statement objects
     */
    public void cutConnection() {
        try {
            stmnt.close();
            appConnect.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Adds Astronaut and Ship tables to the database
     * @param s A Java SQL statement object used to perform updates
     */
    public void createTables(Statement s) {
        try {
            //Creates tables for astronauts
            String updateString = "create table Astronauts (" +
                                "Names tinytext," +
                                "SerialNumbers smallint," +
                                "Birthdates tinytext," +
                                "Addresses tinytext," +
                                "Emails tinytext," +
                                "PhoneNumbers tinytext," +
                                "NextOfKin tinytext," +
                                "Statuses tinytext," +
                                "PayRates double(5, 2)," +
                                "Weights double(5, 2)" +
                                ");";
            s.execute(updateString);
            //Creates table for ships
            updateString = "create table Ships (" +
                        "ShipNames tinytext," +
                        "FuelCapacities double(6, 2)," +
                        "Fuel double(7, 2)," +
                        "ShipCapacities smallint" +
                        ");";
            s.execute(updateString);
        } catch (SQLException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }

    /**
     * Retrieves data from the Astronauts table in ApplicationDatabase
     * @param stmnt A Java SQL Statement used for queries
     * @return The Astronaut array with information from the database
     */
    public Astronaut[] databaseAstronautArrayRetrieval() {
        astrosFromDatabase = new Astronaut[20];
        int count = 0;
        try {
            ResultSet r = stmnt.executeQuery("select * from Astronauts;");
            while (r.next()) {
                String dbName = r.getString("Names");
                int dbSerialNumber = r.getInt("SerialNumbers");
                String dbBirthdate = r.getString("Birthdates");
                String dbAddress = r.getString("Addresses");
                String dbEmail = r.getString("Emails");
                String dbPhoneNumber = r.getString("PhoneNumbers");
                String dbNextOfKin = r.getString("NextOfKin");
                String dbStatus = r.getString("Statuses");
                double dbPayRate = r.getDouble("PayRates");
                double dbWeight = r.getDouble("Weights");
                if (dbName != null) {
                    astrosFromDatabase[count] = new Astronaut(dbName, dbBirthdate, dbAddress, dbEmail, dbPhoneNumber, dbNextOfKin, dbStatus, dbPayRate, dbWeight);
                    astrosFromDatabase[count].setSerialNumber(dbSerialNumber);
                }
                count++;
            }
            r.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("An error occured: " + e.getMessage());
        }
        return astrosFromDatabase;
    }

    /**
     * Retrieves data from the Ships table in ApplicationDatabase
     * @param stmnt A Java SQL Statement used for queries
     * @return The Ship array with information from the database
     */
    public Ship[] databaseShipArrayRetrieval(DatabaseManager db) {
        shipsFromDatabase = new Ship[10];
        int count = 0;
        try {
            ResultSet r = stmnt.executeQuery("select * from Ships;");
            while (r.next()) {
                String name = r.getString("ShipNames");
                double fCap = r.getDouble("FuelCapacities");
                double fuel = r.getDouble("Fuel");
                int sCap = r.getInt("ShipCapacities");
                if (name != null) {
                    shipsFromDatabase[count] = new Ship();
                    shipsFromDatabase[count].setSName(name);
                    shipsFromDatabase[count].setFCap(fCap);
                    shipsFromDatabase[count].setFuel(fuel);
                    shipsFromDatabase[count].setSCap(sCap);
                    shipsFromDatabase[count].setData(db);
                }
                count++;
            }
            r.close();
        } catch (SQLException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        return shipsFromDatabase;
    }

    //Adding Astronaut and Ship
    /**
     * Adds an astronaut to the database
     * @param a The astronaut added to the database
     */
    public void addAstroToDatabase(Astronaut a) {
        try {
            String addingAstronautUpdate = "insert into Astronauts(Names, SerialNumbers, Birthdates, Addresses, " +
                                           "Emails, PhoneNumbers, NextOfKin, Statuses, PayRates, Weights) " +
                                           "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = appConnect.prepareStatement(addingAstronautUpdate);
            ps.setString(1, a.getName());
            ps.setInt(2, a.getSerialNumber());
            ps.setString(3, a.dateOfBirth());
            ps.setString(4, a.address());
            ps.setString(5, a.email());
            ps.setString(6, a.phoneNumber());
            ps.setString(7, a.nextOfKin());
            ps.setString(8, a.status());
            ps.setDouble(9, a.payRate());
            ps.setDouble(10, a.weight());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("An error has occured while saving astronaut to database: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("An error has occured while saving astronaut to database: " + e.getMessage());
        }
    }

    /**
     * Adds a ship to the database
     * @param s The ship added to the database
     */
    public void addShipToDatabase(Ship s) {
        try {
            String addShipUpdate = "insert into Ships(ShipNames, FuelCapacities, Fuel, ShipCapacities) values (?, ?, ?, ?);";
            PreparedStatement ps = appConnect.prepareStatement(addShipUpdate);
            ps.setString(1, s.getSName());
            ps.setDouble(2, s.getFCap());
            ps.setDouble(3, s.getFuel());
            ps.setInt(4, s.getSCap());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("An error occurred while saving ship to database: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("An error occurred while saving ship to database: " + e.getMessage());
        }
    }

    //Setting Methods
    /**
     * Changes an astronaut's name in the database
     * @param name The new name for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setAstroName(String name, int serialNumber) {
        String updateString = "update Astronauts set Names = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setString(1, name);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes an astronaut's birthdate in the database
     * @param birthdate The new birthdate for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setAstroBirthDate(String birthdate, int serialNumber) {
        String updateString = "update Astronauts set Birthdates = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setString(1, birthdate);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes an astronaut's address in the database
     * @param address The new address for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setAstroAddress(String address, int serialNumber) {
        String updateString = "update Astronauts set Addresses = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setString(1, address);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes an astronaut's email in the database
     * @param email The new email for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setAstroEmail(String email, int serialNumber) {
        String updateString = "update Astronauts set Emails = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setString(1, email);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes an astronaut's phone number in the database
     * @param phone The new phone number for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setAstroPhoneNumber(String phone, int serialNumber) {
        String updateString = "update Astronauts set PhoneNumbers = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setString(1, phone);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes an astronaut's next of kin in the database
     * @param kin The new next of kin for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setAstroNextOfKin(String kin, int serialNumber) {
        String updateString = "update Astronauts set NextOfKin = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setString(1, kin);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes an astronaut's status in the database
     * @param status The new status for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setStatus(String status, int serialNumber) {
        String updateString = "update Astronauts set Statuses = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setString(1, status);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes an astronaut's pay rate in the database
     * @param payRate The new pay rate for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setPayRate(double payRate, int serialNumber) {
        String updateString = "update Astronauts set PayRates = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setDouble(1, payRate);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes an astronaut's weight in the database
     * @param weight The new weight for the astronaut
     * @param serialNumber The serial number of the astronaut, used to identify which astronaut to edit
     */
    public void setWeight(double weight, int serialNumber) {
        String updateString = "update Astronauts set Weights = ? where serialNumbers = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setDouble(1, weight);
            ps.setInt(2, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes a ship's name in the database
     * @param name The ship's name, used to identify which ship to edit
     * @param newName The new name for the ship
     */
    public void setShipName(String name, String newName) {
        String updateString = "update Ships set ShipNames = ? where ShipNames = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setString(1, newName);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes a ship's fuel capacity in the database
     * @param name The ship's name, used to identify which ship to edit
     * @param fuelCapacity The new fuel capacity for the ship
     */
    public void setShipFuelCapacity(String name, double fuelCapacity) {
        String updateString = "update Ships set FuelCapacities = ? where ShipNames = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setDouble(1, fuelCapacity);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes a ship's current fuel level in the database
     * @param name The ship's name, used to identify which ship to edit
     * @param currentFuel The new fuel level for the ship
     */
    public void setShipFuel(String name, double currentFuel) {
        String updateString = "update Ships set Fuel = ? where ShipNames = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setDouble(1, currentFuel);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    /**
     * Changes a ship's crew capacity in the database
     * @param name The ship's name, used to identify which ship to edit
     * @param shipCapacity The new crew capacity for the ship
     */
    public void setShipCapacity(String name, int shipCapacity) {
        String updateString = "update Ships set ShipCapacities = ? where ShipNames = ?;";
        try {
            PreparedStatement ps = appConnect.prepareStatement(updateString);
            ps.setInt(1, shipCapacity);
            ps.setString(2, name);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong while updating database: " + e.getMessage());
        }
    }

    //Removing Astronaut and Ship
    /**
     * Removes an astronaut from the database
     * @param serialNumber The serial number of the astronaut to remove
     */
    public void removeAstroFromDatabase(int serialNumber) {
        try {
            String updateForRemoval = "delete from Astronauts where SerialNumbers = ?";
            PreparedStatement ps = appConnect.prepareStatement(updateForRemoval);
            ps.setInt(1, serialNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    /**
     * Removes a ship from the database
     * @param shipName The name of the astronaut to remove
     */
    public void removeShipFromDatabase(String shipName) {
        try {
            String updateForRemoval = "delete from Ships where ShipNames = ?";
            PreparedStatement ps = appConnect.prepareStatement(updateForRemoval);
            ps.setString(1, shipName);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

}
