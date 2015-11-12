/**
 * 
 */
package address.gui;

/**
 * Purpose: Used for pairing an individual's whole name with
 * the key that's associated with them in the address book.
 * Used for displaying the name in a JList while keeping the 
 * ID attached to the name when selected for editing/viewing/removing. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 8, 2015, JDK 8
 */
public class KeyNamePair {

	/*
	 * The AddressEntryID associated with the name
	 */
    private String key;
    /*
     * The name associated with the AddressEntryID
     */
    private String name;

    /*
     * Purpose: Created a blank pairing
     */
    public KeyNamePair() {
        this.key = "";
        this.name = "";
    }
    
    /*
     * Purpose: Creates a pairing with both key and name set
     */
    public KeyNamePair(String key, String name) {
        this.key = key;
        this.name = name;
    }

    /*
     * @return the AddressEntryID
     */
    public String getKey() {
        return this.key;
    }

    /*
     * @return the name 
     */
    public String getName() {
        return this.name;
    }

    /*
     * Purpose: Used for when printing out the JList elements
     * in the main scroll pane.
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
