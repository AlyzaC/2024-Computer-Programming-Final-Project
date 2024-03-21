import java.util.Scanner;

public class Ship
{
    double fuel;
    String shipName;
    int shipCapacity;
  //crew = Astronaut[] 99% sure this dosent work
  int numOfCrew;
  boolean parachutesDeployed;
  Scanner keyboard = new Scanner
System.out.println("blah blah blah gimme a number between 1-4");
System.out.println("1 to add astronaut, 2 to launch, 3 to deploy parachutes 4 to open doors");
int choice = keyboard.nextInt();
//nextline

public void addAstro()
{
if (choice = 1)
{
 System.out.println ("which one?");
}
}

public void launch()
{
if (choice = 2)
{
 if (numOfCrew < shipCapacity)
 {
   System.out.println ("not enough people in ship make new choice");
   choice = keyboard.nextInt();
   //next line
 } else{

 
  System.out.println ("launching metal tube into orbit");
 }
}
}


public void deployParachutes()
{
  if (choice = 3)
  {
    System.out.println ("Deploying parachutes");
  }
}

public void openDoors()
{
  if (choice = 4)
  {
    System.out.println ("teaching astronauts how doorknobs work...");
  }
}

  public void explode()
  {
    if (choice = 800177)
    {

    System.out.println  ("kaboom?");
    System.out.println ("Yes " + shipName + ", kaboom.");
  }
}
}







