package address.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 1, 2015, JDK 8
 */
public class AddressEntry {
	/**
	 * The two main components that make up an entire entry: Name and Address
	 */
	String ID;
	Name name;
	Address address; 
	String email;
	String phone;
	List<Note> notes;
	
	/**
	 * Purpose: Creates an empty entry 
	 */
	public AddressEntry() {
		ID = "";
		name = new Name();
		address = new Address();
		email = "";
		phone = "";
		notes = new ArrayList<Note>();
	}
	
	/**
	 * Purpose: Create an entry with Name and Address objects. Automatically
	 * generates a random unique ID and assigns it to the entry. 
	 * @param n contains the name, email, and phone number for an entry
	 * @param a contains the full address for the entry 
	 */
	public AddressEntry(Name n, Address a, String e, String p) {
		ID = UUID.randomUUID().toString();
		name = n;
		address = a;
		email = e;
		phone = p;
		notes = new ArrayList<Note>();
	}
	
	/**
	 * Purpose: Used for when you want to manually assign an ID rather
	 * than automatically generate a random one. Passes in a Name and 
	 * Address Object, along with two strings, and assigns those
	 * to their respective elements to finish up creation of the entry. 
	 * @param id the unique id for the address entry
	 * @param n the name of the person in the entry
	 * @param a the entry's full address
	 * @param e the entry's email
	 * @param p the entry's phone number
	 */
	public AddressEntry(String id, Name n, Address a, String e
			, String p, List<Note> not) {
		ID = id;
		name = n;
		address = a;
		email = e;
		phone = p;
		notes = not;
	}
	
	/**
	 * Purpose: Creates and entry that has all the needed data needed to create a
	 * full entry. Automatically generates a random unique id and assigns it to the entry
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
			String c, String sta, String z, String e, String p){
		ID = UUID.randomUUID().toString();
		name = new Name(fN, lN);
		address = new Address(str, c, sta, z);
		email = e;
		phone = p;
		notes = new ArrayList<Note>();
	}
	
	/**
	 * Purpose: Allows creation of an entry using purely passed in string.
	 * Allows manual setting of the entry's ID. 
	 * @param id the unique id for the address entry
	 * @param fN the person's first name
	 * @param lN the person's last name
	 * @param str the person's street address
	 * @param c the city the person lives in
	 * @param sta the state the person lives in
	 * @param z the person's zip code
	 * @param p the person's phone number
	 * @param e the person's email
	 */
	public AddressEntry(String id, String fN, String lN, String str,
			String c, String sta, String z, String e, String p){
		ID = id;
		name = new Name(fN, lN);
		address = new Address(str, c, sta, z);
		email = e;
		phone = p;
		notes = new ArrayList<Note>();
	}
	
	/**
	 * Purpose: Used for comparing two entries for sorting purposes
	 * @param otherObject The entry to be compared to the main entry
	 * @return Whether this.entry bigger than otherEntry
	 */
	public int compareTo (AddressEntry otherEntry) {
	       return (this.getName().getLastName()+this.getName().getFirstName())
	    		   .compareTo((otherEntry.getName().getLastName()
	    				   +otherEntry.getName().getFirstName()));
	    }
	
	/**
	 * Purpose: Returns the entry's ID
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Purpose: Sets the entry's ID
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * Purpose: Sets the address using an existing address object.
	 * @param newAddress the new address to replace the current address
	 */
	public void setAddress(Address newAddress) {
		address = newAddress;
	}
	
	/**
	 * Purpose: Sets the address using four string sent into the function.
	 * @param str the name of the street
	 * @param c	the name of the city
	 * @param sta the name of the state
	 * @param z	the zip code
	 */
	public void setAddress(String str, String c, String sta, String z){
		address = new Address(str, c, sta, z);
	}
	
	/**
	 * Purpose: Returns the address of the current entry 
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Purpose: Sets the name in the entry using a name object.
	 * @param newName the new name to be set in the entry
	 */
	public void setName(Name newName){
		name = newName;
	}
	
	/**
	 * Purpose: Sets the name in the entry using some strings
	 * @param fN the new first name
	 * @param lN the new last name
	 * @param phone the new phone number
	 * @param email the new email
	 */
	public void setName(String fN, String lN) {
		name = new Name(fN, lN);
	}
	
	/**
	 * Purpose: Returns the name object in the entry
	 * @return the name object in the entry
	 */
	public Name getName(){
		return name;
	}
	
	
	/**
	 * Purpose: Returns the email in the entry
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Purpose: Sets the email in the entry
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Purpose: Returns the phone number in the entry
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Purpose: Sets the phone number in the 
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Purpose: returns a fully formatted string with all the details
	 * in an address book
	 */
	@Override
	public String toString (){
		String result = new String();
		
		result = name.toString() + address.toString()
				+ email + "\n"
				+ phone;
		
		return result;
	}
	
	/**
	 * Purpose: Returns the string in a format needed to save into a file
	 * properly. 
	 * @return the formatted string for file output
	 */
	public String toFile(){
		String result = new String();
		
		result = name.getFirstName() + "\n"
				+ name.getLastName() + "\n"
				+ address.getStreet() + "\n"
				+ address.getCity() + "\n"
				+ address.getState() + "\n"
				+ address.getZip() + "\n"
				+ email + "\n"
				+ phone;
		
		return result; 
	}

	/**
	 * Purpose: Loads the notes from the database
	 * @throws SQLException
	 */
	public void loadNotes() throws SQLException {
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
		} catch (InstantiationException 
				| IllegalAccessException 
				| ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:bs8285/RYB5ECyM@"
				+ "mcsdb1.sci.csueastbay.edu:1521/MCSDB1";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ResultSet noteSet = stmt.executeQuery("select * from NOTESTABLE where "
					+ "ADDRESSENTRYID='"+ID+"'");
		if(noteSet.next()){
			String notesList = noteSet.getString(2);
			
			if(notesList != null && !notesList.isEmpty()){
				Scanner sc = new Scanner(notesList);
			    for (String s; (s = sc.findWithinHorizon("(?<=\\[).*?(?=\\])"
			    		, 0)) != null;) {
			    	Note note = new Note(ID, s);
			    	notes.add(note);
			    }
			    sc.close();
			}
		}
		
		noteSet.close();
		stmt.close();
		conn.close();
	}
	
	/**
	 * Purpose: Saves all the notes for the entry in the database
	 * @throws SQLException
	 */
	public boolean saveNotes () throws SQLException {
		boolean result = false;
		PreparedStatement deleteNotes = null;
		PreparedStatement updateNotes = null;
		String deleteString = "delete from NOTESTABLE where ADDRESSENTRYID=?";
		String updateString = "insert into NOTESTABLE (ADDRESSENTRYID, NOTES) VALUES (?,?)";
		
		
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
		} catch (InstantiationException 
				| IllegalAccessException 
				| ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:bs8285/RYB5ECyM@"
				+ "mcsdb1.sci.csueastbay.edu:1521/MCSDB1";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String noteSet = new String();
				
		for (Note note: notes) {
			noteSet = noteSet.concat("["+note.getNote()+"],");
		}
		noteSet = noteSet.substring(0, noteSet.length() - 1);
		
		try {
	        conn.setAutoCommit(false);
	        deleteNotes = conn.prepareStatement(deleteString);
	        updateNotes = conn.prepareStatement(updateString);
	
	        deleteNotes.setString(1,ID);
	        deleteNotes.executeUpdate();
	        
	        updateNotes.setString(1, ID);
	        updateNotes.setString(2, noteSet);
	        updateNotes.executeUpdate();
	            
	        conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(deleteNotes != null) {
				deleteNotes.close();
			}
			if (updateNotes != null){
				updateNotes.close();
			}
			conn.setAutoCommit(true);
		}
		
		conn.close();
		
		return result;
	}

	/**
	 * Purpose: 
	 * @param note the note to be added 
	 */
	public void insertNote(Note note) {
		notes.add(note);
	}

	/**
	 * Purpose: Returns the list of notes in the entry
	 * @return
	 */
	public List<Note> getNotes() {
		return notes;
	}
	
	/**
	 * Purpose: Sets the list of notes
	 */
	public void setNotes(List<Note> newNotes) {
		notes = newNotes;
	}
	
	/**
	 * Purpose: Checks if the entry has any notes loaded
	 * @return true if there are no notes loaded, false otherwise
	 */
	public boolean isNotesEmpty() {
		return notes.isEmpty();
	}
}
