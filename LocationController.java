/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

import java.util.Vector;

public class LocationController
{
	private Vector locations = new Vector();
	private static int noOfLocations;
	
	public void addLocation(Location newloc)
	{
		locations.addElement(newloc);
		noOfLocations++;	
	}
	
	public int getNoOfLocations()
	{
		return noOfLocations;
	}
	
	public Location getLocAt(int pos)
	{
		try
		{
			return (Location)locations.elementAt(pos);	
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{
			return null;	
		}
	}
}
