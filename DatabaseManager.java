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
    public Ship[] databaseShipArrayRetrieval() {
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
