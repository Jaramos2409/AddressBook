package address;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.io.File;

import org.junit.Test;

/**
 * Purpose: A class using Junit to test all the methods in the class AddressBook
 * @author Jesus Ramos
 * @version 2.0
 * @since Oct 20, 2015, JDK 8
 */
public class AddressBookTest {
	
	/**
	 * Test method for {@link address.AddressBook#insertAddress(address.AddressEntry)}.
	 */
	@Test
	public void testInsertAdd() {
		AddressBook aBook1 = new AddressBook();
		AddressBook aBook2 = new AddressBook();
		
		aBook1.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		assertEquals(false, aBook1.isEmpty());
		assertEquals(1, aBook1.numOfContacts());
		
		aBook2.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		aBook2.insertAddress(new AddressEntry("Shawn", "Michaels", "76 Longhunter Ln", "Toronto", 
				"CA", "10245", "5104648890", "killakillsmith@yahoo.com"));
		assertEquals(false, aBook2.isEmpty());
		assertEquals(2, aBook2.numOfContacts());
	}
	
	
	/**
	 * Test method for {@link address.AddressBook#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		AddressBook aBook1 = new AddressBook();
		AddressBook aBook2 = new AddressBook();
		
		
		assertEquals(true, aBook1.isEmpty());
		
		aBook2.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		assertEquals(false, aBook2.isEmpty());
	}
	
	/**
	 * Test method for {@link address.AddressBook#numOfContacts()}.
	 */
	@Test
	public void testNumOfContacts() {
		AddressBook aBook1 = new AddressBook();
		AddressBook aBook2 = new AddressBook();
		
		assertEquals(0, aBook1.numOfContacts());
		
		aBook2.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		assertEquals(1, aBook2.numOfContacts());
		aBook2.insertAddress(new AddressEntry("Shawn", "Michaels", "76 Longhunter Ln", "Toronto", 
				"CA", "10245", "5104648890", "killakillsmith@yahoo.com"));
		assertEquals(2, aBook2.numOfContacts());
	}

	/**
	 * Test method for {@link address.AddressBook#removeFirst()}.
	 */
	@Test
	public void testRemoveFirst() {
		AddressBook aBook = new AddressBook();
		
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		
		assertEquals(1, aBook.numOfContacts());
		aBook.removeFirst();
		assertEquals(0, aBook.numOfContacts());
	}
	
	/**
	 * Test method for {@link address.AddressBook#remove(java.lang.String)}.
	 */
	@Test
	public void testRemove() {
		System.out.println("----------------------------------------");
		System.out.println("remove() Test:");
		System.out.println();
		AddressBook aBook = new AddressBook();
		
		aBook.insertAddress(new AddressEntry("Shawn", "Michaels", "76 Longhunter Ln", "Toronto", 
				"CA", "10245", "5104648890", "killakillsmith@yahoo.com"));
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@hotmail.com"));
		aBook.insertAddress(new AddressEntry("Adrian", "Ramos", "777 Lucky Dr", "San Mateo", 
				"CA", "94684", "9256667893", "adriansmith@gmail.com"));
		aBook.insertAddress(new AddressEntry("Jesus", "Ramos", "2409 Kendree St", "Antioch", 
				"CA", "94509", "9234567888", "blacksmith@email.com"));
		
		assertEquals(4, aBook.numOfContacts());
		System.out.println("List before remove:");
		aBook.list();
		
		aBook.remove("Michaels,Shawn");
		assertEquals(3, aBook.numOfContacts());
		
		System.out.println("List after remove:");
		aBook.list();
	}
	
	/**
	 * Test method for {@link address.AddressBook#find(java.lang.String)}.
	 */
	@Test
	public void testFind() {
		System.out.println("----------------------------------------");
		System.out.println("find() Test 1:");
		System.out.println();
		AddressBook aBook = new AddressBook();
		AddressBook results = new AddressBook();
		
		aBook.insertAddress(new AddressEntry("Shawn", "Michaels", "76 Longhunter Ln", "Toronto", 
				"CA", "10245", "5104648890", "killakillsmith@yahoo.com"));
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@hotmail.com"));
		aBook.insertAddress(new AddressEntry("Adrian", "Ramos", "777 Lucky Dr", "San Mateo", 
				"CA", "94684", "9256667893", "adriansmith@gmail.com"));
		aBook.insertAddress(new AddressEntry("Jesus", "Ramos", "2409 Kendree St", "Antioch", 
				"CA", "94509", "9234567888", "blacksmith@email.com"));
		
		results = aBook.find("Ram");
		assertEquals(2, results.numOfContacts());
		results.list();
		
		results.clear();
		
		System.out.println("----------------------------------------");
		System.out.println("find() Test 2:");
		System.out.println();
		results = aBook.find("Zest");
		assertEquals(1, results.numOfContacts());
		results.list();
	}
	
	/**
	 * Test method for {@link address.AddressBook#read(java.lang.String)}.
	 * @throws IOException if the file does not successfully open
	 */
	@Test
	public void testRead() throws IOException {
		AddressBook aBook = new AddressBook();
		
		System.out.println("----------------------------------------");
		System.out.println("read() Test:");
		System.out.println("");
		System.out.println("List before read:");
		aBook.list();
		
		int number = aBook.read("src/files/file_test2.txt");
		assertEquals(5, number);
		assertEquals(5, aBook.numOfContacts());
		
		System.out.println("List after read:");
		aBook.list();	
	}
	
	/**
	 * Test method for {@link address.AddressBook#close(java.lang.String)}.
	 * @throws IOException if the file does not successfully open
	 */
	@Test
	public void testClose() throws IOException {
		AddressBook aBook = new AddressBook();
		
		aBook.insertAddress(new AddressEntry("Shawn", "Michaels", "76 Longhunter Ln", "Toronto", 
				"CA", "10245", "5104648890", "killakillsmith@yahoo.com"));
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@hotmail.com"));
		aBook.insertAddress(new AddressEntry("Adrian", "Ramos", "777 Lucky Dr", "San Mateo", 
				"CA", "94684", "9256667893", "adriansmith@gmail.com"));
		
		aBook.close("src/files/file_test.txt");
		
		
		File fileTest = new File("src/files/file_test.txt");
		if(!fileTest.exists()) {
			fail("File not found. ");
		} 
	}

	/**
	 * Test method for {@link address.AddressBook#clear()}.
	 */
	@Test
	public void testClear() {
		AddressBook aBook = new AddressBook();
		
		aBook.insertAddress(new AddressEntry("Shawn", "Michaels", "76 Longhunter Ln", "Toronto", 
				"CA", "10245", "5104648890", "killakillsmith@yahoo.com"));
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@hotmail.com"));
		aBook.insertAddress(new AddressEntry("Adrian", "Ramos", "777 Lucky Dr", "San Mateo", 
				"CA", "94684", "9256667893", "adriansmith@gmail.com"));
		
		assertEquals(false, aBook.isEmpty());
		
		aBook.clear();
		
		assertEquals(true, aBook.isEmpty());
	}

	/**
	 * Test method for {@link address.AddressBook#getKeys()}.
	 */
	@Test
	public void testGetKeys() {
		AddressBook aBook = new AddressBook();
		
		aBook.insertAddress(new AddressEntry("Shawn", "Michaels", "76 Longhunter Ln", "Toronto", 
				"CA", "10245", "5104648890", "killakillsmith@yahoo.com"));
		aBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@hotmail.com"));
		aBook.insertAddress(new AddressEntry("Adrian", "Ramos", "777 Lucky Dr", "San Mateo", 
				"CA", "94684", "9256667893", "adriansmith@gmail.com"));
		
		String[] keys = aBook.getKeys();
		assertEquals(3, keys.length);
		assertEquals("Michaels,Shawn", keys[0]);
		assertEquals("Ramos,Adrian", keys[1]);
		assertEquals("Zesty,Booda", keys[2]);
		
		System.out.println("----------------------------------------");
		System.out.println("getKeys() Test:");
		System.out.println(Arrays.toString(keys));
	}
}

