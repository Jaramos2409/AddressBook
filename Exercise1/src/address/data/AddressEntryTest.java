package address.data;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import address.data.*;

/**
 * Purpose: A class using Junit to test all the methods in the class AddressEntry
 * @author Jesus Ramos
 * @version 2.0
 * @since Oct 20, 2015, JDK 8
 */
public class AddressEntryTest {

	/**
	 * Test method for {@link address.old.AddressEntry#AddressEntry(java.lang.String, 
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddressEntry() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		
		assertEquals("Booda", aEntry.getName().getFirstName());
		assertEquals("Zesty", aEntry.getName().getLastName());
		assertEquals("555 Gehringer St", aEntry.getAddress().getStreet());
		assertEquals("Concord", aEntry.getAddress().getCity());
		assertEquals("CA", aEntry.getAddress().getState());
		assertEquals("94509", aEntry.getAddress().getZip());
		assertEquals("4155044788", aEntry.getPhone());
		assertEquals("bluesmith@gmail.com", aEntry.getEmail());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#toString()}.
	 */
	@Test
	public void testToString() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		
		String desiredResult = "Booda Zesty\n"
				+ "555 Gehringer St\n" 
				+ "Concord," + " CA " + "94509\n"
				+ "bluesmith@gmail.com\n"
				+ "4155044788\n";
		
		assertEquals(desiredResult, aEntry.toString());
		
		//fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link address.old.AddressEntry#toFile()}.
	 */
	@Test
	public void testToFile() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		
		String desiredResult = "Booda\n"
				+"Zesty\n"
				+ "555 Gehringer St\n" 
				+ "Concord\n" 
				+ "CA\n" 
				+ "94509\n"
				+ "bluesmith@gmail.com\n"
				+ "4155044788";
		
		assertEquals(desiredResult, aEntry.toFile());
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("Booda", aEntry.getName().getFirstName());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("Zesty", aEntry.getName().getLastName());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#getStreet()}.
	 */
	@Test
	public void testGetStreet() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("555 Gehringer St", aEntry.getAddress().getStreet());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#getCity()}.
	 */
	@Test
	public void testGetCity() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("Concord", aEntry.getAddress().getCity());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#getState()}.
	 */
	@Test
	public void testGetState() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("CA", aEntry.getAddress().getState());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#getZip()}.
	 */
	@Test
	public void testGetZip() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("94509", aEntry.getAddress().getZip());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#getPhone()}.
	 */
	@Test
	public void testGetPhone() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("4155044788", aEntry.getPhone());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.old.AddressEntry#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("bluesmith@gmail.com", aEntry.getEmail());
		//fail("Not yet implemented");
	}	
	
	/**
	 * Test method for {@link address.data.AddressEntry#loadNotes()}.
	 * @throws SQLException 
	 */
	@Test
	public void testLoadNotes() throws SQLException {
		AddressEntry aEntry = new AddressEntry("A4456","Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "bluesmith@gmail.com", "4155044788");
		aEntry.loadNotes();
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.data.AddressEntry#saveNotes()}.
	 */
	@Test
	public void testSaveNotes() {
		AddressEntry aEntry = new AddressEntry("A4456","Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "bluesmith@gmail.com", "4155044788");
		Note note1 = new Note("A4456", "This is my message");
		Note note2 = new Note("A4456", "This is another message");
		aEntry.insertNote(note1);
		aEntry.insertNote(note2);
		try{
		aEntry.saveNotes();
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
	}

}
