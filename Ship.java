
public class Ship
{
  // I have no idea what I am doing :(
    double fuel;
    String shipName;
    int shipCapacity;
    double fuelCapacity;
    boolean inSpace = false;
    boolean parachutesDeployed = false;
    boolean doorIsOpen = false;
    boolean failure = false;


  //crew = Astronaut[] 99% sure this dosent work
  int numOfCrew;
  


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

public void launch(int choice)
{
if (choice == 2)
{
  
 if (numOfCrew < shipCapacity)
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


public void deployParachutes(int choice)
{
  if (choice == 3)
  {
    // code will check if this is possible
    // code will determine the outcome of this
    //code will set a boolean to true
    System.out.println ("Deploying parachutes");
  }
}

public void openDoors(int choice)
{
  if (choice == 4)
  {
    //code will check the outcome of this
    // if not a good outcome ask if the user is sure about doing this
    //if they chicken out send them back to the menu and ask for a new choice
    //if they dont back down, open the doors anyways
    //code will set boolean to true
    // if already in space, and not doing spacewalk, kill all astronauts and set a boolean
    // if doing spacewalk, idk
    // if still on ground, do nothing
    System.out.println ("teaching astronauts how doorknobs work...");
  }
}

  public void explode(int choice)
  {
    if (choice == 800177)
    {
   //pretty clear what this does kaboom = funny
   // set a boolean to true cus why not
    System.out.println  ("kaboom?");
    System.out.println ("Yes " + shipName + ", kaboom.");
  }
}
}







