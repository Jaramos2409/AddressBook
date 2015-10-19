/**
 * 
 */
package address;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jesus Ramos
 * @version 1.0
 * @since Oct 19, 2015, JDK 8
 */
public class AddressEntryTest {

	/**
	 * Test method for {@link address.AddressEntry#AddressEntry(java.lang.String, 
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddressEntry() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		
		assertEquals("Booda", aEntry.getFirstName());
		assertEquals("Zesty", aEntry.getLastName());
		assertEquals("555 Gehringer St", aEntry.getStreet());
		assertEquals("Concord", aEntry.getCity());
		assertEquals("CA", aEntry.getState());
		assertEquals("94509", aEntry.getZip());
		assertEquals("4155044788", aEntry.getPhone());
		assertEquals("bluesmith@gmail.com", aEntry.getEmail());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressEntry#toString()}.
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
	 * Test method for {@link address.AddressEntry#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("Booda", aEntry.getFirstName());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressEntry#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("Zesty", aEntry.getLastName());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressEntry#getStreet()}.
	 */
	@Test
	public void testGetStreet() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("555 Gehringer St", aEntry.getStreet());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressEntry#getCity()}.
	 */
	@Test
	public void testGetCity() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("Concord", aEntry.getCity());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressEntry#getState()}.
	 */
	@Test
	public void testGetState() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("CA", aEntry.getState());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressEntry#getZip()}.
	 */
	@Test
	public void testGetZip() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("94509", aEntry.getZip());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressEntry#getPhone()}.
	 */
	@Test
	public void testGetPhone() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("4155044788", aEntry.getPhone());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link address.AddressEntry#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		AddressEntry aEntry = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		assertEquals("bluesmith@gmail.com", aEntry.getEmail());
		//fail("Not yet implemented");
	}

}
