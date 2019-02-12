/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
import java.util.Vector;

class Invent extends Action implements Constants
{
	public Invent(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		if(mainRef.getCurrentPerson() == mainRef.getPlayerPerson())
		{
			System.out.println("You are carrying:");
			Vector results = mainRef.getObjects().objHeld(mainRef.getPlayerPerson());
			if(results.size()== 0)
				System.out.println("Nothing");
			else
			{
				for(int count = 0; count < results.size(); count ++)
					System.out.println((Object)results.elementAt(count));
			}
		}
		return false;
	}
}