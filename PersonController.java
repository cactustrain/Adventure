/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.0                            *
 **********************************************************/

import java.util.*;

public class PersonController implements Constants
{
	private Vector people = new Vector();
	private static int noOfPeople;
	
	public void addPerson(Person newPerson)
	{
		people.addElement(newPerson);
		noOfPeople++;
	}

	public int getNoOfPeople()
	{
		return noOfPeople;
	}

	public int getSize()
	{
			return people.size();
	}
	
	public Person getPerson(int pos)
	{
		try
		{
			return (Person)people.elementAt(pos);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return null;	
		}
	}
	
	public Vector findPerson(String desc) // Search for description matches and return list
	{
		Enumeration vector_scan = people.elements();
		Person next = null;
		Vector found = new Vector();
		 
		while(vector_scan.hasMoreElements())
		{
			next = (Person)vector_scan.nextElement();
			if(next.getName().toLowerCase().indexOf(desc.toLowerCase()) != NOTFOUND)
				found.addElement(next);
		}
		return found;
	}
}
