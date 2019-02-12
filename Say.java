/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
import java.util.*; 
 
class Say extends Action implements Constants
{
	public Say(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		int currentPerson = mainRef.getCurrentPerson();
		String nouns = mainRef.getNouns();
		int position = nouns.indexOf("\""); // find " in nouns
		if(position == NOTFOUND)
				position = nouns.indexOf(" "); // or space if no "
		if(position == NOTFOUND)
		{
			if(currentPerson == mainRef.getPlayerPerson())
			{
				System.out.println("say what?");
			}
			return false;
		}
		String talkingTo = nouns.substring(0, position).trim();
		Vector results = mainRef.getPeople().findPerson(talkingTo);
		Enumeration vector_scan = results.elements();
		Person next;
		int count = 0;
		while(vector_scan.hasMoreElements())
		{
			next = (Person)vector_scan.nextElement();
			if(next.getLoc() != mainRef.getRoom())
			{
				results.removeElementAt(count);			
				vector_scan = results.elements();
				count =0;
			}
			else
				count++;
		}
		switch(results.size())
		{
			case 0:
				if(currentPerson == mainRef.getPlayerPerson())
				{
					System.out.println("I don't see anyone bearing that name");
				}
				break;
			case 1:
				if(currentPerson == mainRef.getPlayerPerson())
				{
					System.out.println("Okay, you talk to " + talkingTo);
				}
				Person person = (Person)results.firstElement();
				int end = nouns.length();
				if(nouns.charAt(end - 1) == '\"')
					end--;
				mainRef.addText("setperson  " + mainRef.getPeople().getPerson(mainRef.getPlayerPerson()).getName());	
				mainRef.addText(nouns.substring(++position, end));
				mainRef.addText("setperson " + person.getName());
				break;
			default:
				if(currentPerson == mainRef.getPlayerPerson())
				{
					System.out.println("There is more than one person with that name here. Please be more specific");
				}
				break;
		}
		return false;
	}
}
