package address;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import address.AddressEntry;

public class AddressBook {
	List<AddressEntry> contacts; 
	
	public AddressBook(){
		contacts = new ArrayList<AddressEntry>();
	}
	public boolean insertAddress (AddressEntry newAddress) {
		boolean result = false;
		
		result = contacts.add(newAddress);
		if(result) Collections.sort(contacts);
		
		return result;
	}
	public void list()
	{
		for (AddressEntry a: contacts){
			System.out.println(a.toString());
		}
	}
}