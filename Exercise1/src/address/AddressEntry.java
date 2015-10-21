package address;

/**
 * Purpose: The class is used to represent a single entry in an address book.
 * @author Jesus Ramos
 * @version 2.0
 * @since Oct 14, 2015, JDK 8
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
	 * Purpose: Creates and entry that has all the needed data needed to create a
	 * full entry
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
	 * Purpose: Returns all the elements in an address entry in a formatted
	 * String used for storing to a file. 
	 * @return a formatted string of all the info in an entry
	 */
	public String toFile(){
		String result;
		
		result = firstName + "\n"
				+ lastName + "\n" 
				+ street + "\n" 
				+ city + "\n" 
				+ state + "\n" 
				+ zip + "\n"
				+ email + "\n"
				+ phone;
		
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

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
