/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

class Move extends Action implements Constants
{
	public Move(String name)
	{
		super(name);
	}
	
	public boolean action(Adventure mainRef)
	{
		int currentPerson = mainRef.getCurrentPerson();
		Person currentPlayer = mainRef.getPeople().getPerson(currentPerson);
		
		if(mainRef.getNouns().compareTo("") == FOUND)
		{
			if(currentPerson == mainRef.getPlayerPerson())
				System.out.println("go where?");
			return false;
		}
		int command_no = 999;
		for(int loop = 0; loop < NO_OF_DIRECTIONS; loop++)
		{
			if(mainRef.getNouns().compareTo(mainRef.getDirection(loop)) == FOUND)
			   command_no = loop;
		}
		if(command_no != 999)
		{
			int move = mainRef.getLocations().getLocAt(currentPlayer.getLoc()).getMove(command_no);
			if(move != NOEXIT)
			{
				if(currentPerson == mainRef.getPlayerPerson())
				{
					mainRef.setRoom(move);
					System.out.println("Ok, you move " + mainRef.getDirection(command_no));
				}
				else
				{
					if(currentPlayer.getLoc() == mainRef.getRoom())
						System.out.println(currentPlayer.getName() + " goes " + mainRef.getNouns());
					if(move == mainRef.getRoom())
						System.out.println(currentPlayer.getName() + " enters");
				}
					
				currentPlayer.setLoc(move);
			}
			else
				if(currentPerson == mainRef.getPlayerPerson())
					System.out.println("You can't move in that direction");
		}
		else
			if(currentPerson == mainRef.getPlayerPerson())
			{
				System.out.println("No such direction");	
			}
			else
				System.out.println(currentPlayer.getName() + " explains that they can't move in that direction");
		return false;
	}
}