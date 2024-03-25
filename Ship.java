
public class Ship
{
    double fuel;
    String shipName;
    int shipCapacity;
  //crew = Astronaut[] 99% sure this dosent work
  int numOfCrew;
  boolean parachutesDeployed;


public void addAstro(int choice)
{
if (choice == 1)
{
 System.out.println ("which one?");
 //user will give the astronauts name
 //code will add person to crew, telling them
 //code will ask if theres another astronaut to add if not full
 //code will bring back up the menu
}
}

public void launch(int choice)
{
if (choice == 2)
{
 if (numOfCrew < shipCapacity)
 {
   System.out.println ("not enough people in ship make new choice");
   // code will bring back up menu
   //next line
   //code will set a boolean to true
 } else{

 
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
    //code will set boolean to true
    System.out.println ("teaching astronauts how doorknobs work...");
  }
}

  public void explode(int choice)
  {
    if (choice == 800177)
    {
   //pretty clear what this does kaboom = funny
    System.out.println  ("kaboom?");
    System.out.println ("Yes " + shipName + ", kaboom.");
  }
}
}







