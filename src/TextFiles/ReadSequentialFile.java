package TextFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.bind.JAXB;

public class ReadSequentialFile {
	public static void main(String[] args) {
		//try to open file for deserialization
		try(BufferedReader input =
				Files.newBufferedReader(Paths.get("clients.xml"))) {
			// unmarshal the files contents
			Accounts accounts = JAXB.unmarshal(input, Accounts.class);
			
			// display contents
			System.out.printf("%-10s%-12s%-12s%10s%n", "Account",
					"First Name", "Last Name", "Balance");
			
			for (Account account : accounts.getAccounts()) {
				System.out.printf("%-10d%-12s%-12s%10.2f%n",
						account.getAccountNumber(), account.getFirstName(),
						account.getLastName(), account.getBalance());
			}
		}
		
		catch (IOException ioException) {
			System.err.println("Error opening file.");
		}
	}
}
