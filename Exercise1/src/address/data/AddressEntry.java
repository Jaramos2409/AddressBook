package address.data;

import java.util.UUID;

/**
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 1, 2015, JDK 8
 */
public class AddressEntry {
	/**
	 * The two main components that make up an entire entry: Name and Address
	 */
	String ID;
	Name name;
	Address address; 
	String email;
	String phone;
	
	/**
	 * Purpose: Creates an empty entry 
	 */
	public AddressEntry() {
		ID = "";
		name = new Name();
		address = new Address();
		email = "";
		phone = "";
	}
	
	/**
	 * Purpose: Create an entry with Name and Address objects. Automatically
	 * generates a random unique ID and assigns it to the entry. 
	 * @param n contains the name, email, and phone number for an entry
	 * @param a contains the full address for the entry 
	 */
	public AddressEntry(Name n, Address a, String e, String p) {
		ID = UUID.randomUUID().toString();
		name = n;
		address = a;
		email = e;
		phone = p;
	}
	
	/**
	 * Purpose: Used for when you want to manually assign an ID rather
	 * than automatically generate a random one. Passes in a Name and 
	 * Address Object, along with two strings, and assigns those
	 * to their respective elements to finish up creation of the entry. 
	 * @param id the unique id for the address entry
	 * @param n the name of the person in the entry
	 * @param a the entry's full address
	 * @param e the entry's email
	 * @param p the entry's phone number
	 */
	public AddressEntry(String id, Name n, Address a, String e, String p) {
		ID = id;
		name = n;
		address = a;
		email = e;
		phone = p;
	}
	
	/**
	 * Purpose: Creates and entry that has all the needed data needed to create a
	 * full entry. Automatically generates a random unique id and assigns it to the entry
	 * @param fN the person's first name
	 * @param lN the person's last name
	 * @param str the person's street address
	 * @param c the city the person lives in
	 * @param sta the state the person lives in
	 * @param z the person's zip code
	 * @param p the person's phone number
	 * @param e the person's email
	 */
	public AddressEntry(String fN, String lN, String str,
			String c, String sta, String z, String e, String p){
		ID = UUID.randomUUID().toString();
		name = new Name(fN, lN);
		address = new Address(str, c, sta, z);
		email = e;
		phone = p;
	}
	
	/**
	 * Purpose: Allows creation of an entry using purely passed in string.
	 * Allows manual setting of the entry's ID. 
	 * @param id the unique id for the address entry
	 * @param fN the person's first name
	 * @param lN the person's last name
	 * @param str the person's street address
	 * @param c the city the person lives in
	 * @param sta the state the person lives in
	 * @param z the person's zip code
	 * @param p the person's phone number
	 * @param e the person's email
	 */
	public AddressEntry(String id, String fN, String lN, String str,
			String c, String sta, String z, String e, String p){
		ID = id;
		name = new Name(fN, lN);
		address = new Address(str, c, sta, z);
		email = e;
		phone = p;
	}
	
	/**
	 * Purpose: Used for comparing two entries for sorting purposes
	 * @param otherObject The entry to be compared to the main entry
	 * @return Whether this.entry bigger than otherEntry
	 */
	public int compareTo (AddressEntry otherEntry) {
	       return (this.getName().getLastName()+this.getName().getFirstName())
	    		   .compareTo((otherEntry.getName().getLastName()
	    				   +otherEntry.getName().getFirstName()));
	    }
	
	/**
	 * Purpose: Returns the entry's ID
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Purpose: Sets the entry's ID
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * Purpose: Sets the address using an existing address object.
	 * @param newAddress the new address to replace the current address
	 */
	public void setAddress(Address newAddress) {
		address = newAddress;
	}
	
	/**
	 * Purpose: Sets the address using four string sent into the function.
	 * @param str the name of the street
	 * @param c	the name of the city
	 * @param sta the name of the state
	 * @param z	the zip code
	 */
	public void setAddress(String str, String c, String sta, String z){
		address = new Address(str, c, sta, z);
	}
	
	/**
	 * Purpose: Returns the address of the current entry 
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Purpose: Sets the name in the entry using a name object.
	 * @param newName the new name to be set in the entry
	 */
	public void setName(Name newName){
		name = newName;
	}
	
	/**
	 * Purpose: Sets the name in the entry using some strings
	 * @param fN the new first name
	 * @param lN the new last name
	 * @param phone the new phone number
	 * @param email the new email
	 */
	public void setName(String fN, String lN) {
		name = new Name(fN, lN);
	}
	
	/**
	 * Purpose: Returns the name object in the entry
	 * @return the name object in the entry
	 */
	public Name getName(){
		return name;
	}
	
	
	/**
	 * Purpose: Returns the email in the entry
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Purpose: Sets the email in the entry
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Purpose: Returns the phone number in the entry
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Purpose: Sets the phone number in the 
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Purpose: returns a fully formatted string with all the details
	 * in an address book
	 */
	@Override
	public String toString (){
		String result = new String();
		
		result = name.toString() + address.toString()
				+ email + "\n"
				+ phone;
		
		return result;
	}
	
	/**
	 * Purpose: Returns the string in a format needed to save into a file
	 * properly. 
	 * @return the formatted string for file output
	 */
	public String toFile(){
		String result = new String();
		
		result = name.getFirstName() + "\n"
				+ name.getLastName() + "\n"
				+ address.getStreet() + "\n"
				+ address.getCity() + "\n"
				+ address.getState() + "\n"
				+ address.getZip() + "\n"
				+ email + "\n"
				+ phone;
		
		return result; 
	}
	
}
