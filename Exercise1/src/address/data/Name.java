package address.data;

/**
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 1, 2015, JDK 8
 */
public class Name {
	/**
	 * All the information that would make up an entire contact's information
	 * in an name object
	 */
	private String firstName, lastName;
	
	/**
	 * Creates an empty name object.
	 */
	public Name() {
		firstName = "";
		lastName = "";
	}
	
	/**
	 * Purpose: Creates and entry that has all the needed data needed to create a
	 * full name object
	 * @param fN the person's first name
	 * @param lN the person's last name
	 * @param p the person's phone number
	 * @param e the person's email
	 */
	public Name(String fN, String lN) {
		firstName = fN;
		lastName = lN;
	}
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Purpose: Returns the full name in last name to first name form
	 * @return the entire full name on the entry
	 */
	public String getFullName() {
		return lastName+","+firstName;
	}


	/**
	 * Purpose: Sends a formatted version of all the data in a name
	 * as a whole string. 
	 */
	public String toString(){
		String result;
		
		result = firstName + " " + lastName + "\n";
		
		return result;
	}
}
