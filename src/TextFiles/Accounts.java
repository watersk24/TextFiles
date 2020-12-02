package TextFiles;
// Maintains a List<Account>
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

public class Accounts {
	// @XmlElement specifies XML element name for each object in the list
	@XmlElement(name="account")
	private List<Account> accounts = new ArrayList<>(); // stores Accounts
	
	// returns the List<Accounts>
	public List<Account> getAccounts() {return accounts;}
}
