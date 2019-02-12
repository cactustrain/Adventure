/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

import java.io.*;

public class Keyboard 
{
	public static String input()
	{
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		boolean ok = false;
		
		while(!ok)
		{
    		try
    		{
    			input = in.readLine();
				input = input.toLowerCase();
				ok = true;
			}
			catch(IOException e)
        	{
        	   	System.err.println(e);
        	}
        }
        return input;		
	}
}
