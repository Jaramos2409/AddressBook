package address.data;

/**
 * Purpose: The class is used to represent a single address. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 1, 2015, JDK 8
 */
public class Address {
	/**
	 * All the information that would make up an entire contact's information
	 * in an address object
	 */
	private String street, 
	city, state, zip;
	
	/**
	 * Creates an empty address object.
	 */
	public Address(){
		street = "";
		city = "";
		state = ""; 
		zip = "";
	}
	
	/**
	 * Purpose: Creates and entry that has all the needed data needed to create a
	 * full address object
	 * @param str the person's street address
	 * @param c the city the person lives in
	 * @param sta the state the person lives in
	 * @param z the person's zip code
	 */
	public Address(String str,
			String c, String sta, String z){
		street = str;
		city = c;
		state = sta; 
		zip = z;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * Purpose: Sends a formatted version of all the data in an address
	 * as a whole string. 
	 */
	public String toString(){
		String result;
		
		result = street + "\n" 
				+ city + ", " + state + " " + zip + "\n";
		
		return result;
	}

	
}
