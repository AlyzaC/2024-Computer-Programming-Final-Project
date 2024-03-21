
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
}
}

public void launch(int choice)
{
if (choice == 2)
{
 if (numOfCrew < shipCapacity)
 {
   System.out.println ("not enough people in ship make new choice");
   
   //next line
 } else{

 
  System.out.println ("launching metal tube into orbit");
 }
}
}


public void deployParachutes(int choice)
{
  if (choice == 3)
  {
    System.out.println ("Deploying parachutes");
  }
}

public void openDoors(int choice)
{
  if (choice == 4)
  {
    System.out.println ("teaching astronauts how doorknobs work...");
  }
}

  public void explode(int choice)
  {
    if (choice == 800177)
    {

    System.out.println  ("kaboom?");
    System.out.println ("Yes " + shipName + ", kaboom.");
  }
}
}







