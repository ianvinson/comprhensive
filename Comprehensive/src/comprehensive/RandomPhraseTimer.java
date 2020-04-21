package comprehensive;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 * Timer class to time the efficiency of methods.
 * 
 * @author Eli Hunt && Trina Luong
 *
 */
public class RandomPhraseTimer
{
    public static void main (String[] args)
    {
        int timesToLoop = 10000;  
        Random rand = new Random();

        
        int incr = 1000;
        for (int probSize = 1000; probSize <= 10000; probSize += incr)
        {
        	
            // First, spin computing stuff until one second has gone by.
            // This allows this thread to stabilize.

            long stopTime, midpointTime, startTime = System.nanoTime();

            while (System.nanoTime() - startTime < 1000000000)
            { // empty block
            }

            // Collect running times.
            startTime = System.nanoTime();
            for (int i = 0; i < timesToLoop; i++)
            {
            }

            midpointTime = System.nanoTime();

            // Capture the cost of running the loop and any other operations done
            // above that are not the essential method call being timed.
            for (int i = 0; i < timesToLoop; i++)
            {
            }

            stopTime = System.nanoTime();

            // Compute the time, subtract the cost of running the loop
            // from the cost of running the loop and searching.
            // Average it over the number of runs.
            double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;
            System.out.println(probSize + "\t" + averageTime);

        }
    }
}
