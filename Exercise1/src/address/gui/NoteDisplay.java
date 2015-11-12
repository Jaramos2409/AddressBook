package address.gui;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import address.data.AddressEntry;
import address.data.Note;

/**
 * Purpose: Used for constructing a scroll pane that contains
 * all the notes associated with the last viewed entry
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class NoteDisplay {
	JScrollPane listDisplay;
	
	/**
	 * Purpose: Creates the scrolling list and ties it
	 * to the constantly updated list of notes. 
	 * @param noteList
	 */
	public NoteDisplay(JList<Note> noteList){
		listDisplay = new JScrollPane(noteList);
	}

	/**
	 * @return the listDisplay
	 */
	public JScrollPane getListDisplay() {
		return listDisplay;
	}

	/**
	 * @param listDisplay the listDisplay to set
	 */
	public void setListDisplay(JScrollPane listDisplay) {
		this.listDisplay = listDisplay;
	}
	
}
