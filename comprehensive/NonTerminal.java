package comprehensive;

import java.util.ArrayList;
import java.util.Random;

public class NonTerminal extends Terminal
{
    String tag;
    ArrayList<String> values;
    Random rng = new Random();
    
    NonTerminal (String tag)
    {
        this.tag = tag;
    }
    
    public String getText ()
    {
        int randomIndex = rng.nextInt(values.size() + 1);
        return values.get(randomIndex);
    }
    
    public void addString (String s)
    {
        values.add(s);
    }
    

}
