/********************************************************** 
 *             Adventure Game Engine                      *
 *                Michael Russell                         *
 *        BSc Computing with Software Engineering         *
 *               Bradford College                         *
 *                   2006/07                              *
 *                 Version 1.1                            *
 **********************************************************/

import java.io.*;
import java.util.*;

public class Parser
{
	private static String disallowed[] = 
		// determiners
		{"a", "an", "some","the", "this", "those", "that", 
		// prepositions
		"to", "in", "upon", "into", "on", "of", "with", "over", "under",
		// adverbs
		"quickly", "slowly", "fast", "slow"};
	
	// remove disallowed words, place first word in array position zero = verb
	// subsequent words in arrray position one = nouns
	public static void read(StringBuffer input, String verbnoun[])
	{
		String nextWord;
		StringBuffer nouns = new StringBuffer();
        StringTokenizer words = new StringTokenizer(new String(input));

		verbnoun[0] = "";
        while(words.hasMoreTokens())
        {
        	boolean flag = false;
        	
        	nextWord = words.nextToken();
        	for(int count = 0; count < disallowed.length; count++)
        	{ 
        		if(nextWord.compareTo(disallowed[count]) == 0)
        			flag = true;       			
        	}
        	// if acceptable word
        	if (flag == false)
        	{
        		if (verbnoun[0].equals(""))
        			verbnoun[0] = nextWord;
        		else
        			nouns.append(" " + nextWord);
        	}
        }
        verbnoun[1] = new String(nouns).trim();
    }
}
