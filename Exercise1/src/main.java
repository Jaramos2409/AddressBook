import address.AddressBook;
import address.AddressEntry;

import java.io.*;
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
	 * Purpose: Prints out titles for all the elements in an AddressEntry 
	 * 
	 * @author Jesus Ramos
	 * @version 1.0
	 * @since Oct 14, 2015, JDK 8
	 * 
	 */
	class Menu {
		/**
		 * Purpose: Prints out all the available commands for the program
		 */
		void CommandList() // Prints out the command list.
		{
			System.out.println("Command List:");
			System.out.println("Lo - Load an address book from a file of your choosing");
			System.out.println("A - Add an entry");
			System.out.println("R - Remove an entry ");
			System.out.println("F - Find an entry ");
			System.out.println("Li: - List all your contacts");
			System.out.println("Q: - Save your address book and quit the program");
			System.out.println();
		}
		
		/**
		 * Purpose: Print the intro to the program and call the command print list
		 */
		public void PrintIntro() // Prints out all the intro info.
		{
			System.out.println("#########################################");
			System.out.println("#"); 
			System.out.println("#"); 
			System.out.println("#\t\t Address Book");
			System.out.println("#\t\t by Jesus Ramos");
			System.out.println("#\t\t for CS3340");
			System.out.println("#########################################");
			System.out.println();

			CommandList();
		}
		
		/**
		 * Purpose: Opens up a file based off the name the user inputs and reads it into the
		 * program
		 * 
		 * @throws IOException
		 */
		public void load() throws IOException{
			String filename = new String();
			
			System.out.println("Enter in FileName:");
			System.out.println();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			try 
			{
				filename = br.readLine();
			} 
			catch (IOException ioe) {
				System.out.println("IO error trying to read your choice!");
				System.exit(1);
			}
			
			int counter = addressBook.read("src/files/" + filename);
			
			System.out.println("Read in " + counter
			+ " new addresses. \n"
			+ "Book currently contains " + addressBook.numOfContacts() +
			" addresses");
		}
		
		/**
		 * Purpose: Guides the user through entering in data that is used to 
		 * create a new entry in the address book
		 */
		public void add () {
			String firstName = new String(), lastName = new String(), street = new String(), 
					city = new String(), state =new String(), zip = new String(), 
					email = new String(), phone = new String(); 
			boolean check = true;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("First Name:");
				System.out.println();
				try 
				{
					firstName = br.readLine();
				} 
				catch (IOException ioe) {
					System.out.println("IO error trying to read your choice!");
					System.exit(1);
				}
				check = firstName.matches("^[\\p{L} .'-]+[\\pL\\pZ\\pP]{0,}+$");
				if (!check) System.out.println("Invalid input. Please try again "
						+ "with only alphabet characters");
			}while (!check);
			
			do {
				System.out.println("Last Name:");
				System.out.println();
				try 
				{
					lastName = br.readLine();
				} 
				catch (IOException ioe) {
					System.out.println("IO error trying to read your choice!");
					System.exit(1);
				}
				check = lastName.matches("^[\\p{L} .'-]+[\\pL\\pZ\\pP]{0,}+$");
				if (!check) System.out.println("Invalid input. Please try again "
						+ "with only alphabet characters");
			}while (!check);
			
			do {
				System.out.println("Street:");
				System.out.println();
				try 
				{
					street = br.readLine();
				} 
				catch (IOException ioe) {
					System.out.println("IO error trying to read your choice!");
					System.exit(1);
				}
				check = street.matches("\\d.*");
				if (!check) System.out.println("Invalid input. Please try again "
						+ "with a valid address i.e. 123 Example St.");
			}while (!check);
			
			do {
				System.out.println("City:");
				System.out.println();
				try 
				{
					city = br.readLine();
				} 
				catch (IOException ioe) {
					System.out.println("IO error trying to read your choice!");
					System.exit(1);
				}
				check = city.matches("^[\\p{L} .'-]+[\\pL\\pZ\\pP]{0,}+$");
				if (!check) System.out.println("Invalid input. Please try again "
						+ "with only alphabet characters");
			}while (!check);	
				
			do {
				System.out.println("State:");
				System.out.println();
				try 
				{
					state = br.readLine();
				} 
				catch (IOException ioe) {
					System.out.println("IO error trying to read your choice!");
					System.exit(1);
				}
				check = state.matches("[a-zA-Z]+");
				if (!check) System.out.println("Invalid input. Please try again "
						+ "with only alphabet characters i.e. AZ or CA");
			}while (!check);
				
			do {	
				System.out.println("Zip Code:");
				System.out.println();
				try 
				{
					zip = br.readLine();
				} 
				catch (IOException ioe) {
					System.out.println("IO error trying to read your choice!");
					System.exit(1);
				}
				check = zip.matches("[0-9]+");
				if (!check) System.out.println("Invalid input. Please try again "
						+ "with only numbers");
			}while (!check);	
			
			do {
				System.out.println("Email:");
				System.out.println();
				try 
				{
					email = br.readLine();
				} 
				catch (IOException ioe) {
					System.out.println("IO error trying to read your choice!");
					System.exit(1);
				}
				check = email.contains("@");
				if (!check) System.out.println("Invalid input. Please try again "
						+ "with a valid email i.e. dangerousmuffin@hotmail.com");
			}while (!check);	
				
			do {
				System.out.println("Phone:");
				System.out.println();
				try 
				{
					phone = br.readLine();
				} 
				catch (IOException ioe) {
					System.out.println("IO error trying to read your choice!");
					System.exit(1);
				}
				check = phone.matches("[0-9]+");
				if (!check) System.out.println("Invalid input. Please try again "
						+ "with a valid phone number i.e. 555-999-2345");
			}while (!check);	
			
			addressBook.insertAddress(new AddressEntry(firstName, lastName, street, city, 
					state, zip, phone, email));
		}
		
		/**
		 * Purpose: Searches for a particular entry by last name and then asks
		 * the user which one of the search results they want to remove. Allows the user
		 * to revert their decision if they change their mind. 
		 */
		public void remove() {
			AddressBook selections = new AddressBook();
			String searchTerm = new String(), undo = new String();
			String[] selectionKeys;
			int keyIndex = 0;
			AddressEntry removedEntry = new AddressEntry();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter in Last Name of contact to remove:");
			System.out.println();
			try 
			{
				searchTerm = br.readLine();
			} 
			catch (IOException ioe) {
				System.out.println("IO error trying to read your choice!");
				System.exit(1);
			}
			
			selections = addressBook.find(searchTerm);
			
			if(selections.numOfContacts() <= 0) {
				System.out.println("No matches were found in address book.");
				return;
			}
			
			selectionKeys = selections.getKeys();
			
			selections.list();
			System.out.println("These entries were found in the address book,\nselect number "
					+ "of entry you wish to remove (-1 if you wish to quit:");
			try 
			{
				keyIndex = Integer.parseInt(br.readLine());
			} 
			catch (IOException ioe) {
				System.out.println("IO error trying to read your choice!");
				System.exit(1);
			}
			
			if(keyIndex <= -1 || keyIndex > selections.numOfContacts()) return;
			
			removedEntry = addressBook.remove(selectionKeys[keyIndex-1]);
			System.out.println("The following entry was removed from your address book:");
			System.out.println();
			System.out.println(keyIndex + ": " + removedEntry.toString());
			System.out.println();
			System.out.println("Do you wish to revert your actions?");
			System.out.println("Y or N?:");
			try 
			{
				undo = br.readLine();
			} 
			catch (IOException ioe) {
				System.out.println("IO error trying to read your choice!");
				System.exit(1);
			}
			
			if ("Y".equals(undo)) {
				addressBook.insertAddress(removedEntry);
				System.out.println("Entry readded to address book.");
			}
			
		}
		
		/**
		 * Purpose: Finds a list of entries based off a last name-based search and
		 * lists the results for the user
		 */
		public void find() {
			AddressBook selections = new AddressBook();
			String searchTerm = new String();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter in Last Name of contact you want to find:");
			System.out.println();
			try 
			{
				searchTerm = br.readLine();
			} 
			catch (IOException ioe) {
				System.out.println("IO error trying to read your choice!");
				System.exit(1);
			}
			
			selections = addressBook.find(searchTerm);
			
			if(selections.numOfContacts() <= 0) {
				System.out.println("No matches were found in address book.");
				return;
			}
			
			System.out.println("The following " + selections.numOfContacts() +" entries "
					+ "were found in the address book \nfor a last name starting with \"" 
					+ searchTerm +"\":");
			selections.list();
		}
		
		/**
		 * Prints the entire address book in alphabetical order
		 */
		public void list() {
			addressBook.list();
		}
		
		/**
		 * Purpose: A menu that allows the user to choose from the six available
		 * options and guides the user to the proper function when they choose what 
		 * they want to use. 
		 *  
		 * @return the last choice made in the menu
		 * @throws IOException
		 */
		public String choices() throws IOException{
			String result = new String();
			
			System.out.println("What would you like to do?");
			System.out.println();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			try 
			{
				result = br.readLine();
			} 
			catch (IOException ioe) {
				System.out.println("IO error trying to read your choice!");
				System.exit(1);
			}
			
			if ("Lo".equals(result)) {
				this.load();
			}
			else if ("A".equals(result)) {
				this.add();
			}
			else if ("R".equals(result)) {
				this.remove();
			}
			else if ("F".equals(result)) {
				this.find();
			}
			else if ("Li".equals(result)) {
				this.list();
			}
			
			return result;
		}
		
		/**
		 * Purpose: Calls the intro/command list functions and keeps the program
		 * working until the user decides to quit. 
		 * 
		 * @throws IOException
		 */
		public void menu() throws IOException {
			String status = new String(); 
			this.PrintIntro();
			
			do
			{
				status = this.choices();
				System.out.println();
			}
			while (!"Q".equals(status));
		}
	}
	
	/**
	 * Purpose: Reads in all the contacts from string "filename" set in main. Is always 
	 * called at the beginning of the program. It throws an exception if the file does 
	 * not open. Otherwise it loads up the address book with all the entries stored in
	 * filename
	 * 
	 * @param filename the name/directory/address of file which stores all entries
	 * @throws IOException 
	 */
	void init(String filename) throws IOException {
		int counter = addressBook.read(filename);
		System.out.println("Loaded " + counter + " entries from " + filename);
	}
	
	/**
	 * Purpose: Called at the end of the program. Asks the user what they want
	 * to name the output file that will store the entire address book. It then 
	 * outputs it to said file (creates a new file if it does not exist). It prints
	 * a goodbye message as it is the last method ran before the program terminates. 
	 * 
	 * @throws IOException
	 */
	void close() throws IOException {
		String filename = new String();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter in the name of the file you wish to save your "
				+ "\naddress book to:");
		System.out.println();
		try 
		{
			filename = br.readLine();
		} 
		catch (IOException ioe) {
			System.out.println("IO error trying to read your choice!");
			System.exit(1);
		}
		
		addressBook.close("src/files/" + filename);
		System.out.println();
		System.out.println("Thank you, your AddressBook has been backed up "  
				+ "\nto the file " + filename + ". Goodbye!");
	}
	
	
	/**
	 * Purpose: Calls the init() method, runs the Menu() method, then calls the 
	 * function close() method which does the file data storage, and then finally 
	 * ends the main program.
	 * @throws IOException
	 */
	public static void main (String arguments[]) throws IOException {
		String filename = "src/files/AddressInputDataFile.txt";
    	app.init(filename);
    	AddressBookApplication.Menu menu = app.new Menu();
    	menu.menu();
    	app.close();
    }
}
