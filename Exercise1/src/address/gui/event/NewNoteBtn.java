/**
 * 
 */
package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import address.AddressBookApplication;
import address.data.AddressEntry;
import address.gui.NewNoteWindow;
import address.gui.ViewWindow;

/**
 * Purpose: Used to create a button that, when pressed, takes the user
 * to the window that allows them to create a new note. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class NewNoteBtn implements ActionListener{
	JButton newNoteBtn;
	AddressEntry pickedEntry;
	ViewWindow parentWindow;
	
	public NewNoteBtn(AddressEntry pE, ViewWindow pW) {
		pickedEntry = pE;
		parentWindow = pW;
		newNoteBtn = new JButton("New Note");
		newNoteBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		NewNoteWindow newNote = new NewNoteWindow(pickedEntry, parentWindow);
		newNote.setVisible(true);
		pickedEntry = AddressBookApplication.addressBook.getEntry(pickedEntry.getID());
		parentWindow.displayList(pickedEntry);
	}
	/**
	 * @return the newNoteBtn
	 */
	public JButton getNewNoteBtn() {
		return newNoteBtn;
	}
	/**
	 * @param newNoteBtn the newNoteBtn to set
	 */
	public void setNewNoteBtn(JButton newNoteBtn) {
		this.newNoteBtn = newNoteBtn;
	}
	
	
}
