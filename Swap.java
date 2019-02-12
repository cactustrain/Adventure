/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
import java.util.*; 
 
class Swap extends Action implements Constants
{
	public Swap(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		int currentPerson = mainRef.getCurrentPerson();
		Person currentPlayer = mainRef.getPeople().getPerson(currentPerson);		
		
		if(currentPerson == mainRef.getPlayerPerson())
		{
			if(mainRef.getNouns().compareTo("") == FOUND)
			{
				System.out.println("who do you want to be?");
				return false;
			}
			Vector results = mainRef.getPeople().findPerson(mainRef.getNouns());
			switch(results.size())
			{
				case 0:
					System.out.println("I don't know anyone of that name");
					break;
				case 1:
					Person person = (Person)results.firstElement();
					System.out.println("Okay, you are now " + person.getName());
					mainRef.setPlayerPerson(person.getPersonNo());
					mainRef.setRoom(person.getLoc());
					mainRef.clearText();
					break;
				default:
					System.out.println("There is more than one person with that name here. Please be more specific");
					break;
			}
		}
		return false;
	}
}
