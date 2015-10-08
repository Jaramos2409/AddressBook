package address;

public class AddressEntry implements Comparable<AddressEntry>{
	String firstName;
	String lastName;
	String street;
	String city;
	String state; 
	String zip;
	String phone;
	String email;
	
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
	public int compareTo(AddressEntry other) {
	        return lastName.compareTo(other.lastName);
	}
	public String toString(){
		String result;
		
		result = firstName + " " + lastName + "\n" 
				+ street + "\n" 
				+ city + ", " + state + " " + zip + "\n"
				+ email + "\n"
				+ phone + "\n";
		
		return result;
	}
}
