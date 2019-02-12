/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

public class Object implements Constants
{
	private String name = "";
	private String description = "";
	private int location;
	private int holder;
	
	public Object(String name, int loc, int holder, String desc)
	{
		this.name = name;
		location = loc;
		this.holder = holder;
		description = desc;
	}
	
	public String toString()
	{
		return name;	
	}
	
	public void setHeld(int holder)
	{
		location = HELD;
		this.holder = holder;
	}
	
	public void setDrop(int loc)
	{
		location = loc;
		holder = NOHOLDER;	
	}
	
	public int getHolder()
	{
		return holder;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDesc()
	{
		return description;	
	}
	
	public int getLoc()
	{
		return location;	
	}
}
