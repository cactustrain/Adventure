/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

class Help extends Action implements Constants
{
	public Help(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		if(mainRef.getCurrentPerson() == mainRef.getPlayerPerson())
		{
			if(mainRef.getNouns().compareTo("") != FOUND)
				System.out.println("help what?");
			else
				switch(mainRef.getTurns())
				{
					case 1:
					case 2:
					case 3:
						System.out.println("It's a bit early for that yet!");
						break;
					case 4:
					case 5:
					case 6:
						System.out.println("Try moving around and exploring");
						break;
					case 7:
					case 8:
					case 9:
						System.out.println("Try using objects");
						break;												
					case 10:
						System.out.println("There's no helping you!");
						break;
					default:
						System.out.println("You must be joking!");
				}
		}
		return false;
	}
}