import address.AddressBook;
import address.AddressEntry;

class AddressBookApplication {
	
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
	
	public void initAddressBookExercise(){
		AddressEntry entry1 = new AddressEntry("Booda", "Zesty", "555 Gehringer St", "Concord", 
				"CA", "94509", "4155044788", "bluesmith@gmail.com");
		AddressEntry entry2 = new AddressEntry("Jesus", "Ramos", "2409 Kendree St", "Antioch", 
				"CA", "94509", "9234567888", "blacksmith@gmail.com");
		AddressBook addressBook = new AddressBook();

		addressBook.insertAddress(entry1);
		addressBook.insertAddress(entry2);
		
		addressBook.list();
	}

	public static void main (String arguments[]) {
    	AddressBookApplication app = new AddressBookApplication();
    	Menu menu = app.new Menu();
    	String message = menu.prompt_FirstName();
    	System.out.println(message);
    	message = menu.prompt_LastName();
    	System.out.println(message);
    	message = menu.prompt_Street();
    	System.out.println(message);
    	message = menu.prompt_City();
    	System.out.println(message);
    	message = menu.prompt_State();
    	System.out.println(message);
    	message = menu.prompt_Zip();
    	System.out.println(message);
    	message = menu.prompt_Telephone();
    	System.out.println(message);
    	message = menu.prompt_Email();
    	System.out.println(message);
    	System.out.println();
    	app.initAddressBookExercise();
    }
}
