/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
public abstract class Action 
{
	protected String verb;

	public Action(String name)
	{
		verb = name.toLowerCase();
	}

	public String getName()
	{
		return verb;
	}
	
	public abstract boolean action(Adventure mainRef);	
}
