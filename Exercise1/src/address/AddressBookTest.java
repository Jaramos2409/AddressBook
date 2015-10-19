package address;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class AddressBookTest {
	
	/**
	 * Test method for {@link address.AddressBook#insertAddress(address.AddressEntry)}.
	 */
	@Test
	public void testInsertAdd() {
		AddressBook aBook = new AddressBook();
		
		assertEquals(true, aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com")));
	}
	
	
	/**
	 * Test method for {@link address.AddressBook#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		AddressBook aBook = new AddressBook();
		
		assertEquals(true, aBook.isEmpty());
		
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		
		assertEquals(false, aBook.isEmpty());
	}
	
	/**
	 * Test method for {@link address.AddressBook#numOfContacts()}.
	 */
	@Test
	public void testNumOfContacts() {
		AddressBook aBook = new AddressBook();
		assertEquals(0, aBook.numOfContacts());
		
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		assertEquals(1, aBook.numOfContacts());
		
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		assertEquals(2, aBook.numOfContacts());
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressBook#remove()}.
	 */
	@Test
	public void testRemoveFirst() {
		AddressBook aBook = new AddressBook();
		
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		
		assertEquals(1, aBook.numOfContacts());
		
		aBook.removeFirst();
		
		assertEquals(0, aBook.numOfContacts());
		
		//fail("Not yet implemented");
	}

	
}

