/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

import java.util.*;

class Examine extends Action implements Constants
{
	public Examine(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		if(mainRef.getCurrentPerson() != mainRef.getPlayerPerson())
			return false;
		if(mainRef.getNouns().compareTo("") == FOUND)
		{
			System.out.println("examine what?");
			return false;
		}		
		Vector results = mainRef.getObjects().findObj(mainRef.getNouns());
		Enumeration vector_scan = results.elements();
		Object next;
		int count = 0;
		
		while(vector_scan.hasMoreElements())
		{
			next = (Object)vector_scan.nextElement();
			if(next.getLoc() != mainRef.getRoom() && next.getLoc() != HELD)
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
				System.out.println("I don't see that object here");
				break;
			case 1:
				Object ref = (Object)results.firstElement();
				System.out.println(ref.getDesc());
				break;
			default:
				System.out.println("I see more than one " + mainRef.getNouns() + " here.");
				System.out.println("Please be more specific");
				break;
		}		
		return false;
	}
}