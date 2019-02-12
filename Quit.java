/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
 
class Quit extends Action
{
	public Quit(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		if(mainRef.getCurrentPerson() == mainRef.getPlayerPerson())
			return true;
		else
			return false;
	}
}
