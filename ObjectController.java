/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

import java.util.*;

public class ObjectController implements Constants
{
	private Vector objects = new Vector();
	private static int noOfObjects;
	
	public Object getObjAt(int pos)
	{
		try
		{
			return (Object)objects.elementAt(pos);	
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{
			return null;	
		}
	}
	
	public void addObj(Object newobj)
	{
		objects.addElement(newobj);
		noOfObjects++;
	}
	
	public int getNoOfObjects()
	{
		return noOfObjects;
	}

	public Vector objList(int loc) // Search for location matches and return list 
	{
		 Enumeration vector_scan = objects.elements();
		 Object next = null;
		 Vector found = new Vector();
		 
		 while(vector_scan.hasMoreElements())
		 {
			 next = (Object)vector_scan.nextElement();
			 if(next.getLoc() == loc)
				found.addElement(next);
		 }
		 return found;
	}

	public Vector objHeld(int holder) // List of objects held 
	{
		 Enumeration vector_scan = objects.elements();
		 Object next = null;
		 Vector found = new Vector();
		 
		 while(vector_scan.hasMoreElements())
		 {
			 next = (Object)vector_scan.nextElement();
			 if(next.getHolder() == holder)
				 found.addElement(next);
		 }
		 return found;
	}
	
	public Vector findObj(String desc) // Search for description matches and return list
	{
		Enumeration vector_scan = objects.elements();
		Object next = null;
		Vector found = new Vector();
		 
		while(vector_scan.hasMoreElements())
		{
			next = (Object)vector_scan.nextElement();
			if(next.getName().indexOf(desc) != NOTFOUND)
				found.addElement(next);
		}
		return found;
	}
}
