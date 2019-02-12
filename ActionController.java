
/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

import java.util.*;

public class ActionController
{
	private Vector verbs = new Vector();
	
	public void addVerb(Action newVerb)
	{
		verbs.addElement(newVerb);	
	}
	
	public Action findVerb(String desc)
	{
		Enumeration vector_scan = verbs.elements();
		Action next = null;
		 
		while(vector_scan.hasMoreElements())
		{
			next = (Action)vector_scan.nextElement();
			if(next.getName().compareTo(desc) == 0)
				return next;
		}
		return null;
	}	
}
