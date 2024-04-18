
public class Ship
{

    private double fuel;
    private String shipName;
   private  int shipCapacity;
    private double fuelCapacity;
    boolean inSpace = false;
    boolean parachutesDeployed = false;
    boolean doorIsOpen = false;
    boolean failure = false;
    double fuelBurnRate; //ship will accelerate 30 per second per pound of fuel burned
    double speed; // goes above 3000 in atmos = death
    double accel; //  burning fuel increases this. (no shit)
    double deccel; //gravity, parachute slows this
public String getSName()
{
 return shipName;
}
public void setSName(String newSName)
{
 this.shipName = newSName;
}
public double getFCap()
{
 return fuelCapacity;
}
public void setFCap(double newFCap)
{
 this.fuelCapacity = newFCap;
}
public double getFuel()
{
 return fuel;
}
public void setFuel(Double newFuel)
{
 this.fuel = newFuel;
}
public int getSCap()
{
 return shipCapacity;
}
public void setSCap(int newSCap)
{
 this.shipCapacity = newSCap;
}
 //crew = Astronaut[] 99% sure this dosent work
 int numOfCrew;  
/**
* Adds an astronaut to the ship's crew
* @param choice ??
*/
public void addAstro(int choice)
{
if (choice == 1)
{
  //code will check that there is room
  //if not the code will tell the user that this is not possible and will send them back to the menu to make a new choice
 System.out.println ("which one?");
 //user will give the astronauts name
 //check that astronaut is both real and alive
 //code will add person to crew, telling them this has happend
 //code will ask if theres another astronaut to add if not full
 //code will bring back up the menu and ask for a new choice
}
}

/**
 * Launches the ship after checking the current number of crew and fuel measure
 * @param choice ??
 */
public void launch(int choice)
{
if (choice == 2)
{
  
 if (numOfCrew <= shipCapacity)
 {
   System.out.println ("not enough people in ship make new choice");
   // code will bring back up menu and ask for a new choice
   
  
 } else
 //code will check if it has enough fuel
 //if not it will fail
 //set boolean
 {

  //code will set boolean to true
  //
  
  System.out.println ("launching metal tube into orbit");
 }
}
}

/**
 * Deploys the ship's parachutes
 * @param choice
 */
public void deployParachutes(int choice)
{
  if (choice == 3)
  {
    // code will check if this is possible
    //code will set a boolean to true
    System.out.println ("Deploying parachutes");
  }
}
/**
 * Opens the ship's exterior doors
 * @param choice
 */
public void openDoors(int choice)
{
  if (choice == 4)
  {
    //code will set boolean to true
    // if doing spacewalk, idk
    // if still on ground, do nothing
    System.out.println ("teaching astronauts how doorknobs work...");
  }
}
/**
 * The ship explodes
 * @param choice
 */
  public void explode(int choice)
  {
    if (choice == 800177)
    {
   // set a boolean to true cus why not
    System.out.println  ("kaboom?");
    System.out.println ("Yes " + shipName + ", kaboom.");
  }
}
}