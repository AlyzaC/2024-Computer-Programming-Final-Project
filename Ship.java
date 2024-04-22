import java.util.Scanner;
public class Ship
{

    private double fuel;
    private String shipName;
   private  int shipCapacity;
    private double fuelCapacity;
    private int crewNum;
    private Astronaut[] crew; //dont forget to get crew names from 
    boolean inSpace = false; // if true choose an astronaut for a spacewalk
    boolean parachutesDeployed = false; // will decrease decell
    boolean doorIsOpen = false;
    boolean failure = false; // if true all astronauts are removed and (maybe ship)
    boolean returning = false; // if true ship can land,
    double fuelBurnRate; //ship will accelerate 30 per second per pound of fuel burned
    boolean spaceWalkComplete = false;
    double speed; // goes above 3000 in atmos = death
    double accel; //  burning fuel increases this. (no shit)
    String YON; // yes or no
    double deccel = 9.81; //gravity pulls at 9.81 meters a second
    double altitude = 0; //above 70k in space.
  

int choice; 

//setters and getters
public Astronaut[] getCrew()
{
  return crew;
}
//public void setCrew()
public int getCN()
{
  return crewNum;
}
public void setCN(int newCN)
{
  this.crewNum = newCN;
}
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

//end of setters and getters

public void Space()
{
  if (altitude > 70000)
  {
    inSpace = true;
    //time stuff here
  if (fuel == 0) 
 {

 
    System.out.println("Please choose an astronaut to go on a spacewalk.");
    //astronaut stuff here
    System.out.println("(person stuff here) Has been sent on a spacewalk");
    //more time stuff here
    System.out.println("(name stuff here) has returned into the ship in time");
  spaceWalkComplete = true;
 }
  }
  if (altitude < 70000 && inSpace == true)
  {
    inSpace = false;
    returning = true;
  }
  if (spaceWalkComplete = false && returning == true )
  {
   System.out.println ("The Spacewalking astronaut failed to get in the ship before reentry started.");
   System.out.println("We can only hope his death was quick and painless");
   //code here saying the astronaut died so that astro removal can take care of it
  }
}

public void ship(int speed,boolean inSpace )
{

  if (speed > 3000 && inSpace == false)
  {
 System.out.println ("the ship burned in the atmosphere");
 failure = true;
  }

 if (speed > -7 && altitude == 0 && returning == true)
 {
  System.out.println("You crashed attempting to land");
  failure = true;
 }
 if (speed < -7 && altitude == 0 & returning ==true)
 {
  System.out.println ("The ship has landed sucessfully");
  doorIsOpen = true;
  //remove crew from ship and assume fuel is completely empty
  fuel = 0;
 }

 
  }
  

  



public void shipMenu ()
{
 System.out.println("test");
 /*
  1 is adding astronauts
  2 is fueling
  3 is launch
  4 is doors(?)


  */
 choice = scanner.nextInt();
}
Scanner scanner = new Scanner(System.in);
 //crew = Astronaut[] 99% sure this dosent work
 int numOfCrew;  
/**
* Adds an astronaut to the ship's crew
* @param choice ??
*/


// everything below may not be useful and could be changed.
public void addAstro(int choice)
{
  
if (choice == 1)
{
  if (shipCapacity > crewNum)
  {

  
  
  //code will check that there is room
  //if not the code will tell the user that this is not possible and will send them back to the menu to make a new choice
 System.out.println ("which one?");
 //user will give the astronauts name
 //check that astronaut is both real and alive
 //code will add person to crew, telling them this has happend
 System.out.println ("astronaut has been added to ship.");
  
 if (shipCapacity > crewNum)
 {
  System.out.println ("Would you like to add another? Y or N.");
  YON = scanner.nextLine();
 if (YON = Y)// why tf does it think this is a variable
{
choice = 1;
}

if (YON = N) //????
{
  System.out.println("test message");
  choice = scanner.nextInt();
}
if (YON != Y && YON != N) // w h y
{
  System.out.println("hey buddy thats not a Y or N try again");
 YON = scanner.nextLine();
}
 }
 else
 {
  System.out.println("The ship is now full");
 }
} else
{
  System.out.println("The ship is full.");
}

 //code will ask if theres another astronaut to add if not full
 //code will bring back up the menu and ask for a new choice



}
}

/**
 * Launches the ship after checking the current number of crew and fuel measure
 * @param choice ??
 */
public void launch()
{
  
if (choice == 3)
{
  
 if (numOfCrew <= shipCapacity)
 {
   System.out.println ("There are not enough crew to start the ship.");
   System.out.println("Would you like to add new astronauts to the ship? Y or N.");
   // code will bring back up menu and ask for a new choice
   
  
 } else if (fuel < fuelCapacity)
 {
System.out.println("The Ship needs more fuel for a sucessful launch.");
System.out.println("Would you like to refuel the ship? Y or N.");

 }
 
 
 //set boolean
 else {

  //code will set boolean to true
  //
  
  System.out.println ("launching metal tube into orbit");

/* accel and decell code here.
altitude = altitude + speed;
speed = speed + accel - deccel;
tldr.  +speed is up -speed is down 
thats why the parachute gives -7 deccel

  
 */

 }
}
}

/**
 * Deploys the ship's parachutes
 * 
 */
public void deployParachutes()
{
  if (altitude < 10000 && returning == true)
  {
    //this will lower speed to no more than 7 meters per second by the time the ship lands
    System.out.println ("Deploying parachutes");
    deccel = deccel - 7;
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
    System.out.println ("teaching astronauts how doorknobs work...");

  }
}
/**
 * The ship explodes
 * @param choice
 */
  public void Destruction()
  {
    if (failure == true)
    {
   // set a boolean to true cus why not
    System.out.println  ("All astronauts did not survive");
    System.out.println ("womp womp");
    //code here saying all astros died to astroremoval can take care of it
    //(maybe) code saying the ship has been destroyed so it can (maybe) get removed
    //(maybe) make code bring back up main menu for sake of getting new ship 
    // if not this than idk?
  }
  }
}