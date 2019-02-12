/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
import java.util.*;
 
public class Adventure implements Constants
{
	private LocationController locations;
	private ObjectController objects;
	private ActionController actions;
	private PersonController people;
	private Action action;
	private static String directions[] = new String[NO_OF_DIRECTIONS]; 
	private int RoomNo; 
	private int currentPerson;
	private int playerPerson;
	private String commands[] = new String[2];
	private static String [] separators = {".", ";", ",", " and ", " then "}; // words must have space either side
	private boolean exit = false;
	private StringBuffer text;
	private int turns;
	
	public Adventure()
	{
		locations = new LocationController();
		objects = new ObjectController();
		actions = new ActionController();
		people = new PersonController();
		
		locations.addLocation(new Location("base", 1, 2, 3, 4, 5, 6));
		locations.addLocation(new Location("north room", NOEXIT, NOEXIT, NOEXIT, 0, NOEXIT, NOEXIT));
		locations.addLocation(new Location("east room", NOEXIT, NOEXIT, 0, NOEXIT, NOEXIT, NOEXIT));
		locations.addLocation(new Location("west room", NOEXIT, 0, NOEXIT, NOEXIT, NOEXIT, NOEXIT));
		locations.addLocation(new Location("south room", 0, NOEXIT, NOEXIT, NOEXIT, NOEXIT, NOEXIT));
		locations.addLocation(new Location("up room", NOEXIT, NOEXIT, NOEXIT, NOEXIT, NOEXIT, 0));
		locations.addLocation(new Location("down room", NOEXIT, NOEXIT, NOEXIT, NOEXIT, 0, NOEXIT));
		
		objects.addObj(new Object("banana", HELD, 0, "yellow and bent"));
		objects.addObj(new Object("tin of beans",2, NOHOLDER, "Heinz 57 varieties"));
		objects.addObj(new Object("red bag",3, NOHOLDER, "le sac rouge"));
		objects.addObj(new Object("blue bag",4, NOHOLDER, "large and blue"));
		objects.addObj(new Object("green bag", 5, NOHOLDER, "for holding garden waste"));
		objects.addObj(new Object("torch", 6, NOHOLDER, "without a battery"));
		objects.addObj(new Object("old map", 0, NOHOLDER, "pirate map"));
		objects.addObj(new Object("pencil", HELD, 2, "blunt"));
		objects.addObj(new Object("creased map", 0, NOHOLDER, "x marks the spot"));
				
		actions.addVerb(new Move("go"));
		actions.addVerb(new Move("move"));
		actions.addVerb(new Help("help"));
		actions.addVerb(new Quit("quit"));
		actions.addVerb(new Quit("exit"));
		actions.addVerb(new Quit("bye"));
		actions.addVerb(new Quit("goodbye"));
		actions.addVerb(new Take("take"));
		actions.addVerb(new Take("get"));
		actions.addVerb(new Drop("drop"));
		actions.addVerb(new Drop("discard"));
		actions.addVerb(new Look("look"));
		actions.addVerb(new Look("recap"));
		actions.addVerb(new Invent("invent"));
		actions.addVerb(new Invent("i"));
		actions.addVerb(new Examine("examine"));
		actions.addVerb(new SetPerson("setperson"));
		actions.addVerb(new Say("say"));
		actions.addVerb(new Who("who"));
		actions.addVerb(new Swap("swap"));
		actions.addVerb(new Swap("change"));
		actions.addVerb(new Swap("become"));
		
		people.addPerson(new Human("Kirk", 0));
		people.addPerson(new RandomEverything("Fred Bloggs", 0));
		people.addPerson(new RandomMover("Joe Bloggs", 0));
		people.addPerson(new RandomEverything("Frankenstein", 0));
		people.addPerson(new RandomEverything("The Queen", 1));
		people.addPerson(new RandomMover("The Pope", 2));
		people.addPerson(new RandomEverything("Elvis", 3));
		people.addPerson(new Human("Spaceman", 4));
		playerPerson = 0; // Person you control
		RoomNo = people.getPerson(playerPerson).getLoc();
		
		directions[NORTH] = "north";
		directions[EAST] = "east";
		directions[WEST] = "west";
		directions[SOUTH] = "south";
		directions[UP] = "up";
		directions[DOWN] = "down";
	}
	
	// Setter and Getter methods
	
	public LocationController getLocations()
	{
		return locations;
	}
	
	public ObjectController getObjects()
	{
		return objects;
	}
	
	public PersonController getPeople()
	{
		return people;
	}
	
	public String getDirection(int element)
	{
		if(element < 0 || element > NO_OF_DIRECTIONS)
			return "";
		else
			return directions[element];
	}
	
	public void setRoom(int roomNo)
	{
		RoomNo = roomNo;
	}

	public int getRoom()
	{
		return RoomNo;
	}
	
	public String getNouns()
	{
		return commands[1];
	}
	
	public void setCurrentPerson(int value)
	{
		currentPerson = value;
	}
	
	public int getCurrentPerson()
	{
		return currentPerson;
	}
	
	public void addText(String action)
	{
		text.insert(0, action + ",");
	}

	public void clearText()
	{
		text = new StringBuffer("");
	}
	
	public int getPlayerPerson()
	{
		return playerPerson;
	}
	
	public void setPlayerPerson(int value)
	{
		playerPerson = value;
	}

	public int getTurns()
	{
		return turns;
	}
		
	public void playGame()
	{
		int sepFoundAt;
		String textStillToProcess;
		
		while(exit == false)
		{
			currentPerson = playerPerson;
			System.out.println("\n\nYour location is:" + locations.getLocAt(RoomNo));
			System.out.println("\nI can see:");
			Vector results = objects.objList(RoomNo);
			if(results.size() == 0)
				System.out.println("No objects");
			else
			{
				for(int count = 0; count < results.size(); count ++)
					System.out.println((Object)results.elementAt(count));
			}
			for(int count = 0; count < people.getSize(); count++)
			{
				Person nextPerson = people.getPerson(count);
				if(count != playerPerson)
				{
					if(nextPerson.getLoc() == RoomNo)
						System.out.println(nextPerson);
				}
			}
			System.out.print("\nWhat is your command: ");		
			text = new StringBuffer(Keyboard.input());
			turns++;
			// Action each person in the adventure by adding commands to input line
			text.insert(0, "setperson " + people.getPerson(playerPerson).getName() + ",");
			for(int count = 0; count < people.getSize(); count++)
			{
				Person nextPerson = people.getPerson(count);
				if(count != playerPerson)
				{

					String myAction = nextPerson.move(this);
					text.append(", setperson " + nextPerson.getName());
					if(myAction.compareTo("") != FOUND)
						text.append("," + myAction);
				}
			}
			//System.out.println("*** command line: " + text);
			do
			{
				StringBuffer sentence;
				
				sepFoundAt = findSeparator(text);
				if(sepFoundAt != 999)
				{
					sentence = new StringBuffer(text.substring(0, sepFoundAt));
					String temp = text.substring(sepFoundAt);
					for(byte count = 0; count<separators.length; count++)
					{
						if(temp.startsWith(separators[count]))
							text = new StringBuffer(temp.substring(separators[count].length())); // not all separators 1 char in length
					}					
				}
				else
				{
					sentence = text;
					text = new StringBuffer("");
				}
				Parser.read(sentence, commands);
				action = actions.findVerb(commands[0]);
				if(action == null)
				{
					if(currentPerson == playerPerson)
						System.out.println("I don't understand");
				}
				else
					if(action.action(this))
						exit = true;
				//System.out.println("*** command line: " + text);
				textStillToProcess = new String(text);
			}
			while(textStillToProcess.compareTo("")!= FOUND);
		}
	System.out.println("\n\nGoodbye.");
	System.out.println("You played for " + turns + " turn(s)");
	}

	private int findSeparator(StringBuffer text)
	{
		int found = 999; // not found
		int position;
		
		for(byte count = 0; count<separators.length; count++)
		{
			position = text.indexOf(separators[count]);
			if (position != NOTFOUND && position < found)
				found = position;
		}	
		return found;
	}	


	public static void main (String[] args)
		throws java.io.IOException
	{
		Adventure the_game = new Adventure();
		the_game.playGame();
	}
}
