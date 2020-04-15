package comprehensive;

import java.util.ArrayList;
import java.util.Random;

public class NonTerminal
{
    String tag;
    ArrayList<Terminal> values;
    Random rng = new Random();
    Terminal continuation;
    
    NonTerminal (String tag)
    {
        this.tag = tag;
    }
    
    public String getString ()
    {
        int randomIndex = rng.nextInt(values.size() + 1);
        return values.get(1).getString();
    }
    
    public void addTerminal (Terminal t)
    {
        values.add(t);
    }
    

}
