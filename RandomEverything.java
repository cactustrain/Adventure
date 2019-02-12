/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
 import java.util.*;
 
class RandomEverything extends Person implements Constants 
{
	private static Random random;
	
	public RandomEverything(String name, int location)
	{
		super(name, location);
		random = new Random();
	}
	
	public String move(Adventure mainRef)
	{
		String move = "";
		Vector results = new Vector();
		int decision = random.nextInt(3);
		switch(decision)
		{
			case 0:
				move = "go " + mainRef.getDirection(random.nextInt(NO_OF_DIRECTIONS));
				break;
			case 1:	
				results = mainRef.getObjects().objList(location);
				if(results.size()>0)
					move = "take " + results.elementAt(random.nextInt(results.size()));
				break;
			case 2:
				results = mainRef.getObjects().objHeld(personNo);
				if(results.size()>0)
					move = "drop " + results.elementAt(random.nextInt(results.size()));
				break;
		}
		return move;
	}
}