/**
 * 
 */
package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;

import address.AddressBookApplication;
import address.data.AddressEntry;
import address.data.Note;
import address.gui.ViewEditNoteWindow;
import address.gui.ViewWindow;

/**
 * Purpose: Used to create a button that, when pressed, 
 * take the user to the window where they can edit an
 * existing note of the currently viewed entry. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class ViewEditNoteBtn implements ActionListener{
	JButton viewEditNoteBtn;
	AddressEntry pickedEntry;
	JList<Note> noteList;
	ViewWindow parentWindow;
	
	public ViewEditNoteBtn (AddressEntry pE, JList<Note> list, ViewWindow pW) {
		pickedEntry = pE;
		noteList = list;
		parentWindow = pW;
		viewEditNoteBtn = new JButton("View/Edit Note");
		viewEditNoteBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(noteList.getSelectedIndex() != -1) {
			ViewEditNoteWindow viewEditNote = 
					new ViewEditNoteWindow(noteList.getSelectedIndex(), pickedEntry, parentWindow);
			viewEditNote.setVisible(true);
			pickedEntry = AddressBookApplication.addressBook.getEntry(pickedEntry.getID());
			parentWindow.displayList(pickedEntry);
		}
	}

	/**
	 * @return the viewNoteBtn
	 */
	public JButton getViewEditNoteBtn() {
		return viewEditNoteBtn;
	}

	/**
	 * @param viewNoteBtn the viewNoteBtn to set
	 */
	public void setViewEditNoteBtn(JButton viewNoteBtn) {
		this.viewEditNoteBtn = viewNoteBtn;
	}
	
}
