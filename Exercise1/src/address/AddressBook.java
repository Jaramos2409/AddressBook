package address;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import address.AddressEntry;

/**
 * 
 * @author Jesus Ramos
 * @version 1.0
 * @since Oct 14, 2015, JDK 8
 * Purpose: The class is used to represent an address book and it's many entries
 * 
 */
public class AddressBook {
	/**
	 * A list of all the entries in the address book
	 */
	List<AddressEntry> contacts; 
	
	/**
	 * Creates an empty address book with no entries in it
	 */
	public AddressBook(){
		contacts = new ArrayList<AddressEntry>();
	}
	
	/**
	 * 
	 * @param newAddress a blank entry with no data in it
	 * @return whether the new entry was successfully inserted or not
	 * Purpose: Used to add new entries into the address book
	 * 
	 */
	public boolean insertAddress (AddressEntry newAddress) {
		boolean result = false;
		
		result = contacts.add(newAddress);
		if(result) Collections.sort(contacts);
		
		return result;
	}
	
	/**
	 * 
	 * @return whether the address book has no entries
	 * Purpose: Used to check whether or not the address book is empty
	 * 
	 */
	public boolean isEmpty() {
		return contacts.isEmpty();
	}
	
	/**
	 * 
	 * @return the number of contacts in the address book
	 * Purpose: Used to get the number of contacts in the address book
	 */
	public int numOfContacts() {
		return contacts.size();
	}
	
	/**
	 * 
	 * @return the entry that was just removed
	 * Purpose: Used to retrieve and remove the first entry in the address book
	 */
	public AddressEntry removeFirst() { 
		if (contacts.size() == 0) return new AddressEntry();
		AddressEntry element = contacts.remove(0);
		return element; 
	}
	
	/**
	 * Purpose: Prints out a list of all the entries in the address book
	 */
	public void list()
	{
		for (AddressEntry a: contacts){
			System.out.println(a.toString());
		}
	}
	
}