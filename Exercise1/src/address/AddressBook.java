package address;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import address.AddressEntry;

/**
 * Purpose: The class is used to represent an address book and it's many entries
 * 
 * @author Jesus Ramos
 * @version 2.0
 * @since Oct 14, 2015, JDK 8
 * 
 */
public class AddressBook {
	/**
	 * A list of all the entries in the address book
	 */
	TreeMap<String, AddressEntry> contacts;
	
	/**
	 * Creates an empty address book with no entries in it
	 */
	public AddressBook() {
		contacts = new TreeMap<>();
	}
	
	/**
	 * Purpose: Used to add new entries into the address book
	 * @param newAddress a blank entry with no data in it
	 */
	public void insertAddress (AddressEntry newAddress) {
		contacts.put(newAddress.getLastName() + "," + newAddress.getFirstName(), newAddress);
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
	 * Purpose: Used to retrieve and remove the first entry in the address book
	 * @return the entry that was just removed
	 */
	public AddressEntry removeFirst() { 
		if (contacts.size() == 0) return new AddressEntry();
		AddressEntry element = contacts.remove(contacts.firstKey());
		return element; 
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
	 * 
	 */
	public String[] getKeys() {
		String[] result = new String[this.numOfContacts()]; 
		
		int pos = 0;
		for (String key : this.contacts.keySet()) {
		    result[pos++] = key;
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
			String [] buf = entry.getKey().split(",");
			if (buf[0].contains(searchTerm)) {
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
	 * Purpose: Reads in all the contacts from a file. It throws an exception if the file 
	 * does not open. Otherwise it loads up the addressBook instance up with 
	 * AddressEntry objects
	 * @param filename contains the name of the file 
	 * @throws IOException if the file does not successfully open
	 * @return the number of entries entered during the current read in.
	 */
	public int read(String filename) throws IOException {
		int counter = 0;
		String fnBuf, lnBuf, strBuf, 
		cityBuf, stateBuf, zipBuf, phoneBuf, emailBuf;
		
		File file_handle = new File(filename);
		if(!file_handle.exists()) {
		    file_handle.createNewFile();
		}
		FileReader file_input = new FileReader(file_handle);
		BufferedReader BR = new BufferedReader(file_input);
		
		while ((fnBuf = BR.readLine()) != null) {
			counter++;
			lnBuf = BR.readLine();
			strBuf = BR.readLine();
			cityBuf = BR.readLine();
			stateBuf = BR.readLine();
			zipBuf = BR.readLine();
			emailBuf = BR.readLine();
			phoneBuf = BR.readLine();
			
			this.insertAddress(new AddressEntry(fnBuf, lnBuf, strBuf, cityBuf, 
					stateBuf, zipBuf, phoneBuf, emailBuf));
		}
		
		
		BR.close();
		file_input.close();
		return counter;
	}
	
	/**
	 * Purpose: Used to save all the data in addressBook into a file named
	 * filename.
	 * @param filename the name of the file that all the data will be saved into.
	 * @throws IOException if the file does not successfully open 
	 */
	public void close(String filename) throws IOException {
		File file_handle = new File(filename);
		if(!file_handle.exists()) {
		    file_handle.createNewFile();
		} 
	    FileWriter file_output = new FileWriter(file_handle);
	    BufferedWriter BW = new BufferedWriter(file_output);
	    
	    while (!contacts.isEmpty()) {
	    	String bufString = this.removeFirst().toFile();
	    	BW.write(bufString, 0, bufString.length());
	    	if (!contacts.isEmpty()) BW.newLine();
	    }
	    
	    BW.close();
	    file_output.close();
	}
}