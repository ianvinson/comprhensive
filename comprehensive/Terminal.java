package comprehensive;

import java.util.ArrayList;

/**
 * A class that represents Terminals.This is any string of characters that is not a NonTerminal.
 * A terminal always has a reference to a NonTerminal, even if there is no nonterminal following it, the referenced
 * NonTerminal would be set to null. This is the base case and represents the end of the terminal.
 * Whenever the NonTerminal is not null, continuations are possible.
 * Continuations are terminals that follow after a NonTerminal (e.g. "The Dog" <verb> "at home")
 * In the above example "at home" is the continuation.
 * Continuations are stored in an ArrayList.
 * 
 * A terminal can have 3 cases:
 * 
 * 1. A terminal followed by a non terminal. (e.g. "The dog" <verb>). Continuations are possible
 * 2. A terminal with the words set to an empty string followed by non terminal. (e.g. <verb>). Continuations are possible
 * 3. A terminal followed by no nonterminal and the referenced NonTerminal is set to null. (e.g. "The Dog")
 * Continuations are not possible.
 * 
 * @author Ian
 *
 */
public class Terminal
{
    String words;
    NonTerminal referencedNT;
    ArrayList<Terminal> continuations;
    
    Terminal (String s)
    {
    	words = s;
    	referencedNT = null;
    	continuations = new ArrayList<Terminal>();
    }
    
	/**
	 * Returns a string representation of the terminal and its continuations
	 * @return - the string representation of the terminal and its continuations.
	 */
    public String getString()
    {
        if (referencedNT == null) //base case.
        {
        	if (words == null)
        		return "";
    		return words; //If there is no nonterminal following a terminal, there will be no continuation
        }

    	String total = words + referencedNT.getString(); //otherwise, get the terminal and its following non-terminal
    	if (continuations.size() > 0)
    	{
    		for (int i = 0; i < continuations.size(); i++) //add any continuations
        	{
        		total = total + continuations.get(i).getString();
        	}
    	}
    	
    	return total;
    }
	
	/**
	 * Adds to the array list that stores continuations terminals.
	 * 
	 * Continuation terminals happen if there is more terminals after a nonterminal
	 * @param t
	 */
	public void addContinuation(Terminal t)
	{
		continuations.add(t);
	}
	
	/**
	 * sets the terminal's referenced non terminal. 
	 * 
	 * @param nt - the NonTerminal to reference
	 */
	public void setReferencedNonT(NonTerminal nt)
	{
		referencedNT = nt;
	}

}
