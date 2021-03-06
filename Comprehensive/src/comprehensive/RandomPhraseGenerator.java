package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class RandomPhraseGenerator {

	private static Hashtable<String, NonTerminal> nonTerminals;

	private static boolean inDefinition;

	private static boolean inTerminal;

	private static int iterations;

	public static void main(String[] args) throws FileNotFoundException {
		iterations = Integer.parseInt(args[1]);
		parseFile(args[0]);
		sentenceCreator(iterations);
	}

	private static void parseFile(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scn = new Scanner(file);
		String currTag = null;

		while (scn.hasNextLine()) {
			String curr = scn.nextLine();
			if (curr.charAt(0) == '{') {
				inDefinition = true;
				String line = scn.nextLine();
				currTag = line;
				nonTerminals.put(line, new NonTerminal(line));
				curr = scn.nextLine();
			}

			StringBuilder created = new StringBuilder();
			Terminal original = null;
			Terminal currentTerminal = null;
			for (int i = 0; i < curr.length(); i++) {
				if (curr.charAt(i) == '<') // if nonTerminal is encountered
				{
					inTerminal = true;
					StringBuilder tag = new StringBuilder();

					if (original == null) // Check original terminal and assign if it's the first terminal
					{
						original = new Terminal(created.toString());
						currentTerminal = original;
						nonTerminals.get(currTag).addTerminal(original);
					} else // if original is set, add to continuation
					{
						currentTerminal = new Terminal(created.toString());
						original.addContinuation(currentTerminal);
						
					}
					for (int j = i; curr.charAt(j) != '>'; j++) // get the tag and increment the outside loop
					{
						tag.append(curr.charAt(j));
						i++;
					}
					tag.append(">"); //TODO Make sure that this increments to the correct spot
					i++;
					if (!nonTerminals.containsKey(tag.toString())) // Check if hashmap contains the tag
					{
						nonTerminals.put(tag.toString(), new NonTerminal(tag.toString()));
					}
					currentTerminal.setReferencedNonT(nonTerminals.get(tag.toString()));

					created = new StringBuilder();
					inTerminal = false;
				}

				if (curr.charAt(i) != '<' && curr.charAt(i) != '>') // TODO Not sure if we need the conditional
				{
					created.append(curr.charAt(i));
				}

			}
			if (original == null) // No more non terminal encountered, Check original terminal and assign if it's
									// the first terminal
			{
				original = new Terminal(created.toString());
				nonTerminals.get(currTag).addTerminal(original);
			} else {
				original.addContinuation(new Terminal(created.toString()));
			}

		}

	}
	
	private static void sentenceCreator(int iterations)
	{
		for (int i = 0; i < iterations; i++)
			System.out.println(nonTerminals.get("<Start>").toString());
	}

}
