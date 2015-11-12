package address.gui;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import address.data.AddressEntry;
import address.data.Note;

public class NoteDisplay {
	JScrollPane listDisplay;
	
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
