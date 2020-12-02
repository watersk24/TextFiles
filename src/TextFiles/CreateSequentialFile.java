package TextFiles;
// Writing objects to a file with JAXB and BufferedWriter
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.xml.bind.JAXB;

public class CreateSequentialFile {
	public static void main(String[] args) {
		// open clients.xml, write objects to it then close file
		try(BufferedWriter output =
				Files.newBufferedWriter(Paths.get("clients.xml"))) {
			
			Scanner input = new Scanner(System.in);
			
			// store the accounts before the XML serialization
			Accounts accounts = new Accounts();
			
			System.out.printf("%s%n%s%n? ",
					"Enter account number, first name, last name, and balance.", 
					"Enter end of file indicator to end input.");
			
			while (input.hasNext()) { // loop until end of file indicator
				try {
					// create new record
					Account record = new Account (input.nextInt(),
							input.next(), input.next(), input.nextDouble());
					// add to account list
					accounts.getAccounts().add(record);
				}
				
				catch (NoSuchElementException elementException) {
					System.err.println("Invalid input. Please try again.");
					input.nextLine(); // discard input so user can try again	
				}
				
				System.out.print("? ");
			}
			
			// write AccountLists XML to output
			JAXB.marshal(accounts, output);
		}
		catch (IOException ioException) {
			System.err.println("Error opening file. Terminating program.");
		}
	}
}
