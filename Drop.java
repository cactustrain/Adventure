/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

import java.util.*;

class Drop extends Action implements Constants
{
	public Drop(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		int currentPerson = mainRef.getCurrentPerson();
		Person currentPlayer = mainRef.getPeople().getPerson(currentPerson);
		
		if(mainRef.getNouns().compareTo("") == FOUND)
		{
			if(currentPerson == mainRef.getPlayerPerson())
				System.out.println("drop what?");
			return false;
		}		
		Vector results = mainRef.getObjects().findObj(mainRef.getNouns());
		Enumeration vector_scan = results.elements();
		Object next;
		int count = 0;
		
		while(vector_scan.hasMoreElements())
		{
			next = (Object)vector_scan.nextElement();
			if(next.getHolder() != currentPerson)
			{
				results.removeElementAt(count);			
				vector_scan = results.elements();
				count =0;
			}
			else
				count++;
		}
		switch(results.size())
		{
			case 0:
				if(currentPerson == mainRef.getPlayerPerson())
					System.out.println("You don't have that object");
				break;
			case 1:
				if(currentPerson == mainRef.getPlayerPerson())
					System.out.println("Okay, you drop the " + results.firstElement());
				else
					if(mainRef.getRoom()== currentPlayer.getLoc())
						System.out.println(currentPlayer.getName() + " drops the " + results.firstElement());
				Object ref = (Object)results.firstElement();
				ref.setDrop(currentPlayer.getLoc());
				break;
			default:
				if(currentPerson == mainRef.getPlayerPerson())
				{
					System.out.print("You have more than one " + mainRef.getNouns());
					System.out.println(". Please be more specific");
				}
				break;
		}
		return false;
	}
}