package address.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import address.AddressBookApplication;
import address.data.AddressEntry;
import address.data.Note;
import address.gui.event.CloseCancelBtn;
import address.gui.event.NewNoteBtn;
import address.gui.event.ViewEditNoteBtn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

/**
 * Purpose: Used for creating the window where a user
 * views an entire Address Entry and the list of notes
 * associated with that entry. It also contains the buttons
 * that, when clicked, allow the user to create and edit
 * notes for that specific entry. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class ViewWindow extends JDialog {
	private String selectedNoteID;
	private AddressEntry pickedEntry;
	JList<Note> noteList;
	DefaultListModel<Note> noteEntries;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ViewWindow(JList<KeyNamePair> list) {	
		String key = list.getSelectedValue().getKey();
		pickedEntry = AddressBookApplication.addressBook.getEntry(key);
		noteEntries = new DefaultListModel<Note>();
		noteList = new JList<Note>(noteEntries);
		
		
		setTitle("View Address:");
		setBounds(100, 100, 430, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
		
		JLabel lblAddress = new JLabel("Address:");
		
		JTextArea textArea = new JTextArea(pickedEntry.toString());
		textArea.setColumns(10);
		textArea.setRows(5);
		
		JLabel label = new JLabel("Notes for "
				+pickedEntry.getName().toString()+":");
		
		if (pickedEntry.isNotesEmpty()) {
			try {
				pickedEntry.loadNotes();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		NoteDisplay noteDisplay = new NoteDisplay(noteList);
		displayList(pickedEntry);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(noteDisplay.getListDisplay(), GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textArea, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddress)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(noteDisplay.getListDisplay(), GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{	
				ViewEditNoteBtn btnViewNotes = new ViewEditNoteBtn(pickedEntry, noteList, this);
				NewNoteBtn btnNewNote = new NewNoteBtn(pickedEntry, this);
				CloseCancelBtn btnClose = new CloseCancelBtn(this, "Close");
				buttonPane.add(btnViewNotes.getViewEditNoteBtn());
				buttonPane.add(btnNewNote.getNewNoteBtn());
				buttonPane.add(btnClose.getBtnCancel());
			}
		}
	}

	/**
	 * @return the selectedNoteID
	 */
	public String getSelectedNoteID() {
		return selectedNoteID;
	}

	/**
	 * @param selectedNoteID the selectedNoteID to set
	 */
	public void setSelectedNoteID(String selectedNoteID) {
		this.selectedNoteID = selectedNoteID;
	}
	
	/**
	 * Purpose: To display the list. 
	 */
	public void displayList(AddressEntry pickedEntry) {
		noteEntries.clear();
		List<Note> entries = pickedEntry.getNotes();
		for(Note entry: entries) {
			noteEntries.addElement(entry);
		}
		noteList.setModel(noteEntries);
	}
	
}
