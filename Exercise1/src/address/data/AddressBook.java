package address.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import address.gui.*;

/**
 * Purpose: The class is used to represent an address book and it's many entries
 * 
 * @author Jesus Ramos
 * @version 3.0
 * @since Oct 14, 2015, JDK 8
 * 
 */
public class AddressBook {
	/**
	 * A list of all the entries in the address book
	 */
	HashMap<String, AddressEntry> contacts;
	
	/**
	 * Creates an empty address book with no entries in it
	 */
	public AddressBook() { 
		contacts = new LinkedHashMap<String, AddressEntry>();
	}
	
	/**
	 * Purpose: Used to keep the ordering of the contacts in order of last name 
	 * @param map
	 * @return
	 */
	private static HashMap<String, AddressEntry> 
	sortByValues(HashMap<String, AddressEntry> map) { 
	       List<Entry<String,AddressEntry>> list = 
	    		   new LinkedList<Entry<String,AddressEntry>> (map.entrySet());
	       
	       Collections.sort(list, new Comparator<Entry<String,AddressEntry>>() {
	            public int compare(Entry<String,AddressEntry> o1
	            		,Entry<String,AddressEntry> o2) {
	               return o1.getValue().compareTo(o2.getValue());
	            }
	       });

	       HashMap<String, AddressEntry> sortedHashMap = 
	    		   new LinkedHashMap<String, AddressEntry>();
	       for (Iterator<Entry<String, AddressEntry>> it = 
	    		   list.iterator(); it.hasNext();) {
	    	   	Entry<String, AddressEntry> entry = 
	    	   			(Entry<String, AddressEntry>) it.next();
	    	   	sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
	  }
	
	/**
	 * Purpose: Used to add new entries into the address book
	 * @param newEntry a blank entry with no data in it
	 */
	public void insertAddress (AddressEntry newEntry) {
		contacts.put(newEntry.getID(), newEntry);
		contacts = sortByValues(contacts);
	}
	
	/**
	 * Purpose: Returns the AddressEntry at the specified Key
	 * @param key the key 
	 * @return the address entry at the specified key
	 */
	public AddressEntry getEntry(String key) {
		AddressEntry result = new AddressEntry();
		
		result = contacts.get(key);
		
		return result;
	}
	
	/**
	 * Purpose: Used to check whether or not the address book is empty
	 * @return whether the address book has no entries
	 */
	public boolean isEmpty() {
		return contacts.isEmpty();
	}
	
	/**
	 * Purpose: Clears the entire AddressBook
	 */
	public void clear () {
		contacts.clear();
	}
	
	/**
	 * Purpose: Used to get the number of contacts in the address book
	 * @return the number of contacts in the address book
	 */
	public int numOfContacts() {
		return contacts.size();
	}
	
	/**
	 * Purpose: Removes the element tied to the given key
	 * @param key a string containing the key to the to be removed object
	 * @return true if the entry was successfully removed, false if otherwise
	 */
	public AddressEntry remove(String key) {
		return contacts.remove(key);
	}
	
	/**
	 * Purpose: Used to get an array of all the keys in the contacts-TreeMap
	 * @return the keys in contacts
	 */
	public List<KeyNamePair> getKeyNames() {
		List<KeyNamePair> result = new ArrayList<KeyNamePair>(); 
		
		for (Entry<String, AddressEntry> entry : contacts.entrySet()){
			KeyNamePair newPair = new KeyNamePair(entry.getKey(),
					entry.getValue().getName().getFullName());
		    result.add(newPair);
		}
		
		return result;
	}
	
	/**
	 * Purpose: Searches contacts for entries that have keys that contain
	 * the key given to the function as searchTerm. It collects these entries
	 * in a new AddressBook object, and passes it back to where the method was 
	 * called. 
	 * @param searchTerm a string that carries a last name/partial last name
	 * that is used to search and identify a matching key within contacts
	 * @return an AddressBook object with the search selections in it
	 */
	public AddressBook find(String searchTerm) {
		AddressBook selections = new AddressBook();
		
		for (Entry<String, AddressEntry> entry : contacts.entrySet()) {
			String buf = entry.getValue().getName().getLastName();
			buf = buf.toLowerCase();
			searchTerm = searchTerm.toLowerCase();
			int sizeSearchTerm = searchTerm.length();
			if (buf.regionMatches(0, searchTerm, 0, sizeSearchTerm)) {
				selections.insertAddress(entry.getValue());
			}
		}
		
		return selections;
	}
	
	
	/**
	 * Purpose: Prints out a list of all the entries in the address book
	 */
	public void list()
	{
		int counter = 0;
		for (Entry<String, AddressEntry> entry : contacts.entrySet()) {
			counter++; System.out.println();
			System.out.println(counter + ": " + entry.getValue().toString());
		}
	}
	
	/**
	 * Purpose: Reads in all the contacts from a database. It throws an exception 
	 * if the connection or query fails. Otherwise it loads up the addressBook 
	 * instance up with AddressEntry objects
	 * @param filename contains the name of the file 
	 * @throws SQLException 
	 * @return the number of entries entered during the current read in.
	 */
	public int load() throws SQLException {
		int counter = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
		} catch (InstantiationException 
				| IllegalAccessException 
				| ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:bs8285/RYB5ECyM@"
				+ "mcsdb1.sci.csueastbay.edu:1521/MCSDB1";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ResultSet addressSet = stmt.executeQuery("select * from ADDRESSENTRYTABLE");
		
		while (addressSet.next ()) {      
			counter++;
			String ID = addressSet.getString(1);
			String firstName = addressSet.getString(2);
			String lastName = addressSet.getString(3);
			String street = addressSet.getString(4);
			String city = addressSet.getString(5);
			String state = addressSet.getString(6);
			String zip = addressSet.getString(7);
			String email = addressSet.getString(8);
			String phone = addressSet.getString(9);

			this.insertAddress(new AddressEntry(ID, firstName, lastName, street,
					city, state, zip, email, phone));
		}
		
		addressSet.close();
		stmt.close();
		conn.close();
		return counter;
	}
	

	/**
	 * Purpose: Saves the entire Address Book into a database
	 * @throws SQLException 
	 */
	public void save() throws SQLException{
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
		} catch (InstantiationException 
				| IllegalAccessException 
				| ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:bs8285/RYB5ECyM@"
				+ "mcsdb1.sci.csueastbay.edu:1521/MCSDB1";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		stmt.execute("TRUNCATE TABLE ADDRESSENTRYTABLE");
		
		for (Entry<String, AddressEntry> entry : contacts.entrySet()) {
			String ID = entry.getValue().getID();
			String firstName = entry.getValue().getName().getFirstName();
			String lastName = entry.getValue().getName().getLastName();
			String street = entry.getValue().getAddress().getStreet();
			String city = entry.getValue().getAddress().getCity();
			String state = entry.getValue().getAddress().getState();
			String zip = entry.getValue().getAddress().getZip();
			String email = entry.getValue().getEmail();
			String phone = entry.getValue().getPhone();
			
			String query = "INSERT INTO ADDRESSENTRYTABLE VALUES "
					+"('"+ID+"','"+firstName+"','"+lastName+"','"
					+street+"','"+city+"','"+state+"','"
					+zip+"','"+email+"','"+phone+"')";
			
			try {
				stmt.execute(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				if (e1.getErrorCode() != 1) e1.printStackTrace();
			}
		}
		stmt.close();
		conn.close();
	}
	
	/**
	 * Purpose: Searches the notes database for matching notes and returns them in a 
	 * list.
	 * @param searchTerm the search term the user typed in
	 * @return a list of matching notes
	 * @throws SQLException
	 */
	public List<Note> findNotes(String searchTerm) throws SQLException {
		List<Note> selections = new ArrayList<Note>();
		String searchTermQuery = "%"+searchTerm+"%";	
		PreparedStatement findNotes = null;
		String findNotesString = "SELECT * FROM NOTESTABLE WHERE NOTES LIKE ?";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
		} catch (InstantiationException 
				| IllegalAccessException 
				| ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:bs8285/RYB5ECyM@"
				+ "mcsdb1.sci.csueastbay.edu:1521/MCSDB1";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		ResultSet foundNotes = null;
		
		try {
	        conn.setAutoCommit(false);
	        findNotes = conn.prepareStatement(findNotesString);
	        findNotes.setString(1, searchTermQuery);
	        foundNotes = findNotes.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		while (foundNotes.next ()) {  
			String found = foundNotes.getString(2);
			
			Matcher matcher = Pattern.compile("\\[([^\\]]+)").matcher(found);

		    int pos = -1;
		    while (matcher.find(pos+1)){
		        pos = matcher.start();
		        if((matcher.group(1)).contains(searchTerm)) {
		        	Note foundNote = new Note(foundNotes.getString(1),matcher.group(1));
					selections.add(foundNote);
		        }
		    }
		}
			
		findNotes.close();
		conn.setAutoCommit(true);
		conn.close();
		
		return selections;
	}
}


