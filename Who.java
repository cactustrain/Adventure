/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

class Who extends Action
{
	public Who(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		if(mainRef.getCurrentPerson() == mainRef.getPlayerPerson())
		{
			System.out.println("You are " + mainRef.getPeople().getPerson(mainRef.getCurrentPerson()).getName());
		}
		return false;
	}
}