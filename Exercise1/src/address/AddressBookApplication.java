package address;

import address.data.*;
import address.gui.*;

import java.io.*;
import java.awt.EventQueue;

/**
 * Purpose: Creates an instance of AddressBook, reads in AddressEntry elements 
 * from a file, adds two new instances of AddressEntry, stores them in the previously
 * created AddressBook instance, and then stores new entries into the previously opened 
 * file. 
 * 
 * @author Jesus Ramos
 * @version 2.0
 * @since Oct 14, 2015, JDK 8
 * 
 * 
 */
public class AddressBookApplication {
	/**
	 * The main class object
	 */
	static AddressBookApplication app = new AddressBookApplication();
	/**
	 * The AddressBook object that carries a list of AddressEntry objects
	 */
	public static AddressBook addressBook = new AddressBook();
	
	/**
	 * Purpose: Launches the GUI in window
	 */
	public static void main (String arguments[]) throws IOException {
    	EventQueue.invokeLater(new Runnable() {
	        public void run() {
		        try {
		        	Window window = new Window();
		            window.setVisible(true);
		        } 
		        catch (Exception e) {
		        	e.printStackTrace();
		        }
			}
		});
    }
}
