import address.AddressBook;
import address.AddressEntry;
import address.AddressBookTest;

import java.io.*;
/**
 * 
 * @author Jesus Ramos
 * @version 0.0.1
 * @since Oct 14, 2015, JDK 8
 * 
 * Purpose: Creates an instance of AddressBook, reads in AddressEntry elements 
 * from a file, adds two new instances of AddressEntry, stores them in the previously
 * created AddressBook instance, and then stores new entries into the previously opened 
 * file. 
 * 
 */
class AddressBookApplication {
	/**
	 * The main class object
	 */
	static AddressBookApplication app = new AddressBookApplication();
	/**
	 * The AddressBook object that carries a list of AddressEntry objects
	 */
	static AddressBook addressBook = new AddressBook();
			
	/**
	 * 
	 * @author Jesus Ramos
	 * @version 1.0
	 * @since Oct 14, 2015, JDK 8
	 * Purpose: Prints out titles for all the elements in an AddressEntry 
	 * 
	 */
	class Menu {
		String prompt_FirstName() {
			return "First Name:";
		}
		String prompt_LastName(){
			return "Last Name:";
		}
		String prompt_Street(){
			return "Street:";
		}
		String prompt_City(){
			return "City:";
		}
		String prompt_State(){
			return "State:";
		}
		String prompt_Zip(){
			return "Zip:";
		}
		String prompt_Telephone(){
			return "Telephone:";
		}
		String prompt_Email(){
			return "Email:";
		}
	}
	
	/**
	 * 
	 * @param filename contains the name of the file 
	 * @throws IOException 
	 * Purpose: Reads in all the contacts from a file. Is always called at 
	 * the beginning of the program. It throws an exception if the file does not open. 
	 * Otherwise it loads up the addressBook instance up with AddressEntry objects
	 * 
	 */
	void init(String filename) throws IOException {
		String fnBuf, lnBuf, strBuf, 
		cityBuf, stateBuf, zipBuf, phoneBuf, emailBuf, lineBuf;
		
		File file_handle = new File(filename);
		FileReader file_input = new FileReader(file_handle);
		BufferedReader BR = new BufferedReader(file_input);
		
		while ((fnBuf = BR.readLine()) != null) {
			lnBuf = BR.readLine();
			strBuf = BR.readLine();
			cityBuf = BR.readLine();
			stateBuf = BR.readLine();
			zipBuf = BR.readLine();
			emailBuf = BR.readLine();
			phoneBuf = BR.readLine();
			
			addressBook.insertAddress(new AddressEntry(fnBuf, lnBuf, strBuf, cityBuf, 
					stateBuf, zipBuf, phoneBuf, emailBuf));
		}
		
		BR.close();
		file_input.close();
	}
	
	/**
	 * 
	 * @param filename
	 * @throws IOException
	 * Purpose: Always called at the end of the program in order to save all
	 * the data in addressBook into a file. 
	 * 
	 */
	public void close(String filename) throws IOException {
		AddressEntry buf = new AddressEntry ();
		File file_handle = new File(filename);
	    FileWriter file_output = new FileWriter(file_handle);
	    BufferedWriter BW = new BufferedWriter(file_output);
	    
	    int length = addressBook.numOfContacts();
	    for (int counter = 1; counter <= length; counter++)
	    {
	    	buf = addressBook.removeFirst();
	    	BW.write(buf.getFirstName(), 0, buf.getFirstName().length());
	    	BW.newLine();
	    	BW.write(buf.getLastName(), 0, buf.getLastName().length());
	    	BW.newLine();
	    	BW.write(buf.getStreet(), 0, buf.getStreet().length());
	    	BW.newLine();
	    	BW.write(buf.getCity(), 0, buf.getCity().length());
	    	BW.newLine();
	    	BW.write(buf.getState(), 0, buf.getState().length());
	    	BW.newLine();
	    	BW.write(buf.getZip(), 0, buf.getZip().length());
	    	BW.newLine();
	    	BW.write(buf.getEmail(), 0, buf.getEmail().length());
	    	BW.newLine();
	    	BW.write(buf.getPhone(), 0, buf.getPhone().length());
	    	if (counter != length) BW.newLine();
	    }
	    
	    BW.close();
	    file_output.close();
	}
	
	/**
	 * Purpose: Adds two AddressEntry objects into addressBook
	 */
	public void initAddressBookExercise() {
		addressBook.insertAddress(new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com"));
		addressBook.insertAddress(new AddressEntry("Jesus", "Ramos", "2409 Kendree St", "Antioch", 
				"CA", "94509", "9234567888", "blacksmith@gmail.com"));
		addressBook.list();
	}
	
	/**
	 * 
	 * @throws IOException
	 * Purpose: Calls the functions that opens, reads, writes, and closes the file
	 * 
	 */
	public static void main (String arguments[]) throws IOException {
		String filename = "src/files/AddressInputDataFile.txt";
    	app.init(filename);
    	app.initAddressBookExercise();
    	app.close(filename);
		//AddressTest test = new AddressTest();
		//test.insertAddTest();
    }
}
