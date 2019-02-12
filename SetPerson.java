/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
import java.util.*;

class SetPerson extends Action implements Constants
{
	public SetPerson(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		Vector results = mainRef.getPeople().findPerson(mainRef.getNouns());
		Person person = (Person)results.firstElement();
		mainRef.setCurrentPerson(person.getPersonNo());
		return false;
	}
}