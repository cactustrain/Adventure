/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/
 
public abstract class Person 
{
	protected String name;
	protected int location;
	protected int personNo;
	protected static int nextPersonNo;
	
	public Person(String name, int location)
	{
		this.name = name;
		this.location = location;
		personNo = nextPersonNo++;
	}
	
	public String toString()
	{
		return name;	
	}
		
	public String getName()
	{
		return name;
	}
	
	public int getLoc()
	{
		return location;
	}
	
	public void setLoc(int location)
	{
		this.location = location;
	}
	
	public int getPersonNo()
	{
		return personNo;
	}
	
	public abstract String move(Adventure mainRef);
}
