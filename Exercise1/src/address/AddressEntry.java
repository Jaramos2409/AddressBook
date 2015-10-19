package address;

/**
 * 
 * @author Jesus Ramos
 * @version 1.0
 * @since Oct 14, 2015, JDK 8
 * Purpose: The class is used to represent a single entry in an address book.
 */
public class AddressEntry implements Comparable<AddressEntry>{
	/**
	 * All the information that would make up an entire contact's information
	 * in an address entry
	 */
	private String firstName, lastName, street, 
		city, state, zip, phone, email;
	
	/**
	 * Creates an empty entry.
	 */
	public AddressEntry(){
		firstName = "";
		lastName = "";
		street = "";
		city = "";
		state = ""; 
		zip = "";
		phone = "";
		email = "";
	}
	
	/**
	 * 
	 * @param fN the person's first name
	 * @param lN the person's last name
	 * @param str the person's street address
	 * @param c the city the person lives in
	 * @param sta the state the person lives in
	 * @param z the person's zip code
	 * @param p the person's phone number
	 * @param e the person's email
	 * Purpose: Creates and entry that has all the needed data needed to create a
	 * full entry
	 */
	public AddressEntry(String fN, String lN, String str,
			String c, String sta, String z, String p, String e){
		firstName = fN;
		lastName = lN;
		street = str;
		city = c;
		state = sta; 
		zip = z;
		phone = p;
		email = e;
	}
	
	/**
	 * Purpose: Used to compare the last name of each entry
	 * in the address book in order to order the entire
	 * address book alphabetically
	 */
	public int compareTo(AddressEntry other) {
	        return lastName.compareTo(other.lastName);
	}
	
	/**
	 * Purpose: Sends a formatted version of all the data in a entry
	 * as a string. 
	 */
	public String toString(){
		String result;
		
		result = firstName + " " + lastName + "\n" 
				+ street + "\n" 
				+ city + ", " + state + " " + zip + "\n"
				+ email + "\n"
				+ phone + "\n";
		
		return result;
	}
	
	/**
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @return the street number and street name
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 
	 * @return the city name
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @return the name of the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @return the zip code
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * 
	 * @return the phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 
	 * @return the email 
	 */
	public String getEmail() {
		return email;
	}
	
	
}
