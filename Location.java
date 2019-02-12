/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

public class Location implements Constants
{
	private String description = "";
	private int exits[] = new int[NO_OF_DIRECTIONS];

	public Location(String desc, int n, int e, int w, int s, int u, int d)
	{
		description = desc;
		exits[NORTH] = n;
		exits[EAST] = e;
		exits[WEST] = w;
		exits[SOUTH] = s;
		exits[UP] = u;
		exits[DOWN] = d;
	}
	
	public String toString()
	{
		return description;	
	}
	
	public int getMove(int direction)
	{
		if(direction >=0 && direction <=5)
			return exits[direction];
		else
			return -1;	
	}
	
	public void setNorth(int direction)
	{
		exits[NORTH] = direction;
	}
	
	public void setEast(int direction)
	{
		exits[EAST] = direction;
	}
	
	public void setWest(int direction)
	{
		exits[WEST] = direction;
	}

	public void setSouth(int direction)
	{
		exits[SOUTH] = direction;
	}
	
	public void setUp(int direction)
	{
		exits[UP] = direction;
	}

	public void setDown(int direction)
	{
		exits[DOWN] = direction;
	}		
}
