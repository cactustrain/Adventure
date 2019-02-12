/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
 import java.util.Random;
 
class RandomMover extends Person implements Constants 
{
	private static Random random;
	
	public RandomMover(String name, int location)
	{
		super(name, location);
		random = new Random();
	}
	
	public String move(Adventure mainRef)
	{
		return "go " + mainRef.getDirection(random.nextInt(NO_OF_DIRECTIONS));
	}
}
