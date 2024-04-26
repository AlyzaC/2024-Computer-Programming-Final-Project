import java.sql.Connection;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;
public class Ship
{
 int placeHolder; // THIS IS USELESS AND SHOULD BE REMOVED WHEN POSSIBLE
    private double fuel;
    private String shipName;
   private  int shipCapacity;
    private double fuelCapacity;
    private int crewNum = 0; //crewNum is the ammount of Strings in crew
    private Astronaut[] crew; 
    private boolean failure2;
    boolean inSpace = false; 
    boolean parachutesDeployed = false; // will decrease decell
    boolean doorIsOpen = false;
    boolean failure = false; // if true all astronauts are removed and (maybe ship)
    boolean returning = false; // if true ship can land,
    double fuelBurnRate; //ship will accelerate 30 per second per pound of fuel burned
    boolean spaceWalkComplete = false;
    boolean spacewalk = false;
    double speed; // goes above 3000 in atmos = death
    double accel; //  burning fuel increases this. (no shit)
    double deccel = 9.81; //gravity pulls at 9.81 meters a second
    double altitude = 0; //above 70k in space.
  Scanner scanner = new Scanner(System.in);
  int seconds;
  Connection connection;
  //make connection object, make setConnection(), connection will be put into AstroRemoval object

int choice; 


//setters and getters
public Astronaut[] getCrew()
{
  return crew;
}
public boolean getFailure()
{
  return failure2;
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
    //the ship will keep burning fuel until it runs out
  if (fuel == 0) 
 {
  Scanner scanner = new Scanner(System.in);
  for (int i = 0; i < crew.length; i++) 
  {
    System.out.println((i + 1) + ". " + crew[i]);
 
    System.out.println("Please choose an astronaut to go on a spacewalk.");
    int choice = scanner.nextInt();
    if (choice >= 1 && choice <= crew.length) 
    {
      Astronaut selectedAstronaut = crew[choice - 1]; // Get the selected astronaut
      System.out.println(selectedAstronaut + " has been sent on a spacewalk");
      spacewalk = true;

      Timer timer = new Timer();

      timer.schedule(new TimerTask()
      {
        public void run()
        {
          System.out.println(selectedAstronaut + " has returned to the ship in time");
          spaceWalkComplete = true;
          timer.cancel();
        }
      }, 30 * 1000);
    } else {
      System.out.println ("your choice is invalid. please choose correctly next time smh.");
    }
     //Scanner will show a menu of all of the Strings in crew[] 
   //if valid a 5 minute timer starts and boolean spacewalk is true
  //if notvalid Code will state that no astronaut name could be found and will ask them to try again
    System.out.println("(person stuff here) Has been sent on a spacewalk");
    spacewalk = true;
    //after 30 seconds the astronaut will return to the ship
    System.out.println("(name stuff here) has returned into the ship in time");
  spaceWalkComplete = true;
 }
 //if altitude goes below 70000 and inSpace is true returning is true and inSpace is false
  }
  if (altitude < 70000 && inSpace == true)
  {
    inSpace = false;
    returning = true;
  }
  // if spaceWalkComplete is false and returning is true whichever astronaut went on the spacewalk has to be removed as AstroRemoval.java
  if (!spaceWalkComplete && returning == true)
  {
   System.out.println ("The Spacewalking astronaut failed to get in the ship before reentry started.");
   System.out.println("We can only hope his death was quick and painless");
   //Tell AstroRemoval.java to remove the astronaut
  }
  }
}

public void ship(int speed,boolean inSpace )
{
// if speed >3000 while inSpace is false set failure to true
  if (speed > 3000 && inSpace == false)
  {
 System.out.println ("the ship burned in the atmosphere");
 failure = true;
  }
//etc
 if (speed > -7 && altitude == 0 && returning == true)
 {
  System.out.println("You crashed attempting to land");
  failure = true;
 } //etc
 if (speed < -7 && altitude == 0 & returning ==true)
 {
  System.out.println ("The ship has landed sucessfully");
  doorIsOpen = true;
  //clear the String array "crew" and set fuel to zero
  clearCrew();
  fuel = 0;
 }

 
  }
/**
* Adds an astronaut to the ship's crew
* @param choice ??
*/



public void addAstro(Astronaut astronaut)
{
  // if main1.java sends a perimeter to add an astronaut
 if (crewNum < shipCapacity)
  { if (crew == null)
    {
      crew = new Astronaut[shipCapacity];
    }
    crew[crewNum] = astronaut;
    crewNum++;
 //The code will add this astro sent by main to the array "crew"
 System.out.println ("astronaut has been added to ship.");
} else
{
  // the astro is not added to the array
  System.out.println("The ship is full.");
 }
} 
public void launch() //might need to be a private
{ 
if (placeHolder == 4)// might need to be removed
{
  //The code will first make sure that crewNum is equal to shipCapacity
 if (crewNum == shipCapacity)
 { 
  //if not the code will not launch.
   System.out.println ("There are not enough crew to start the ship.");

 } else if (fuel < fuelCapacity)
 { //the ship will not launch
System.out.println("The Ship needs more fuel for a sucessful launch.");
 }
 else {
// if fuel = fuelCapacity and crewNum = shipCapacity the launch will start
  System.out.println ("launching metal tube into orbit");
  
   while (fuel > 0) {
                    // Update altitude and speed every second until desired conditions are met
                    try {
                        TimeUnit.SECONDS.sleep(1); // Wait for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    seconds++;
                    altitude += speed;
                    speed += accel - deccel;
                    fuel -= fuelBurnRate;
/* accel and decell code here.
altitude = altitude + speed; <-- needs to happen every second
speed = speed + accel - deccel; <-- needs to happen every second
tldr.  +speed is up -speed is down 
thats why the parachute gives -7 deccel

 */
 }
}
}
}
public void deployParachutes()
{ // if altitude goes lower than 10000 while returning is true parachutes will be deployed
  if (altitude < 10000 && returning == true)
  {
    //this will lower speed to no more than 7 meters per second by the time the ship lands
    parachutesDeployed = true;
    System.out.println ("Deploying parachutes");
    if (speed > -7)
    {
      speed = -7;
    }
  }
}
private void clearCrew()
{
  if (crew != null)
  {
    for (int i = 0; i < crew.length; i++)
    {
      crew[i] = null;
    }
  }
}
  public void Destruction(Connection connection)
  {
    if (failure == true)
    {
   // if failure is ever set to true
    System.out.println  ("All astronauts did not survive");
    System.out.println ("womp womp");
    
    
    fuelCapacity = 0.0;
    
    shipCapacity = 0;
    fuel = 0.0;
failure = false;
crewNum = 0;
  
  public static void removeAstronauts(Connection connection Scanner scanner) {
    AstroRemoval.removeAstronauts(connection, scanner);
}

AstroRemoval placeholderremoval = new AstroRemoval(crewNum);

   shipName = null;
   clearCrew();
   failure2 = true;
    // clear String crew, Int crewNum, double fuelcapacity, String shipname , int shipcapacity, double fuel
    //tell astroremoval to remove all astronauts that were part of crew
    //tell shipremoval to remove the ship
    //set failure back to false once everything is done so that way the next test dosent automatically fail
  }
  }
}