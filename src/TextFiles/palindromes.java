/* Author: Kevin Waters
 * Date: 20 November 2020
 * Description: This program reads a .txt file and using a while loop finds any palindromes
 * and prints them to a new .txt file.
 */
package TextFiles;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Formatter;

public class palindromes {
	public static void main(String[] args) {
		
		// open clients.txt, read its contents and close the file
		try(Scanner input = new Scanner(Paths.get("wordList.txt"))) {
			Formatter output = new Formatter ("palindromes.txt"); //create empty file to write to
			// read record from file
			while (input.hasNext()) { // while there is more to read
				
				//read record contents
				String origString = input.nextLine();
				
				// create variable to store reverse order of string
				StringBuffer rev = new StringBuffer(origString);
				rev = rev.reverse();
				
				// compare original and reverse strings
				if(origString.equals(rev.toString())) {
						output.format("%s%n", origString); // if match write to palindromes.txt

						}
					}
			
			output.close();
				}
		
		catch (IOException | NoSuchElementException |
				IllegalStateException e) {
			e.printStackTrace();
		}
	}
}

