package comprehensive;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a NonTerminal. The NonTerminal contains an ArrayList of terminals
 * that can be printed in place of the NonTerminal tag in the RandomPhrase.
 * 
 * The NonTerminal also stores its tag for easy access. The tag is the name of the NonTerminal (i.e. <verb>)
 * 
 * @author Ian
 *
 */
public class NonTerminal
{
    String tag;
    ArrayList<Terminal> terminals;
    Random rng = new Random();
    
    
    NonTerminal (String tag)
    {
        this.tag = tag;
        this.terminals = new ArrayList<Terminal>();
    }
    
    /**
     * Returns a String representation of a random NonTerminal from all of the possible terminals 
     * for this NonTerminal
     * @return
     */
    public String getString ()
    {
        int randomIndex = rng.nextInt(terminals.size() + 1);
        return terminals.get(randomIndex).getString();
    }
    
    /**
     * Adds to the possible Terminals that may be printed
     * 
     * @param t - terminal to add
     */
    public void addTerminal (Terminal t)
    {
    	terminals.add(t);
    }
    
    /**
     * returns the Tag of the NonTerminal
     * @return
     */
    
    public String getTag ()
    {
        int randomIndex = rng.nextInt(terminals.size() + 1);
        return terminals.get(randomIndex).getString();
    }

}
