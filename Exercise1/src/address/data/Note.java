/**
 * 
 */
package address.data;

/**
 * Purpose: To contain the notes associated with each AddressEntry
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 9, 2015, JDK 8
 */
public class Note {
	/**
	 * Contains the ID that ties it to it's respective AddressEntry
	 */
	String AddressEntryID;
	/**
	 * Contains the note associated with the specific AddressEntry
	 */
	String note;
	
	public Note () {
		AddressEntryID = "";
		note = "";
	}
	
	/**
	 * @param addressEntryID
	 * @param note
	 */
	public Note(String addressEntryID, String note) {
		AddressEntryID = addressEntryID;
		this.note = note;
	}

	/**
	 * @return the addressEntryID
	 */
	public String getAddressEntryID() {
		return AddressEntryID;
	}

	/**
	 * @param addressEntryID the addressEntryID to set
	 */
	public void setAddressEntryID(String addressEntryID) {
		AddressEntryID = addressEntryID;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	/**
	 * Purpose: Used for it's label in the drop down list in the view
	 * window. 
	 */
    @Override
    public String toString() {
    	String preview = note;
    	if (note.length() > 40) {
    		preview = note.substring(0, 40)+"...";
    	}
        return preview;
    }
}
