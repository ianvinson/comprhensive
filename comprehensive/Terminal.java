package comprehensive;

public class Terminal
{
    String words;
    NonTerminal referencedNT;
    
    Terminal ()
    {
    	
    }
    
	public String getString()
    {
        if (referencedNT == null)
        	return words;
		return words + referencedNT.getString();
    }

}
