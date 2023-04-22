import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();
	
	public MorseCodeConverter()
	{
		
	}
	
	/*
	 * returns a string with all the data in the tree in LNR order with an space in between them. 
	 * @return - the data in the tree in LNR order separated by a space. 
	 */
	public static java.lang.String printTree()
	{
		String data ="";
		ArrayList<String> list = new ArrayList<String>();
		list = tree.toArrayList();
		for(int i=0; i<list.size(); i++)
		{
			data += list.get(i);
		}
		data = data.trim();
		return data;
	}
	
	/*
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’
	 * @param code - the morse code
	 * @return - the English translation 
	 */
	public static java.lang.String convertToEnglish(java.lang.String code)
	{
		String[] words;
		String[] letters;
		String result = "";
		words = code.split("/");
		
		for(int i=0; i<words.length; i++)
		{
			words[i] = words[i].trim();
			letters = words[i].split(" ");
			for(int j=0; j<letters.length; j++)
			{
				result += tree.fetch(letters[j]);
			}
			result += " ";
		}
		result = result.trim();
		return result;
		
	}
	
	/*
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’
	 * @param codeFile - name of the File that contains Morse Code
	 * @return - the English translation of the file
	 */
	public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException
	{
		 	try (Scanner in = new Scanner(codeFile)) {
				String result ="";
				while(in.hasNext())
				{
					result += convertToEnglish(in.nextLine());
				}
				in.close();
				return result;
			}
		 	catch(FileNotFoundException e)
		 	{
		 		throw new FileNotFoundException("An unwanted exception was caught");
		 	}
	}	
}
