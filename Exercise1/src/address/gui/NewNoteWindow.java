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

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * Purpose: Used for creating the window in which a note
 * is created and then sent into the database after submission.
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class NewNoteWindow extends JDialog {
	/*
	 * The window from which this one came from
	 */
	ViewWindow parentWindow;

	/*
	 * The panel that contains all the content 
	 * of the window.
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Purpose: Creates a blank text area that which anything could be typed into. When 
	 * submit is pressed, whatever was written in the text area is then tied to the 
	 * corresponding AddressEntryID, and saved onto the database. 
	 * @param pickedEntry the chosen entry with the ID that is to be tied to the new note at submission
	 * @param pW the window from which this one came from 
	 */
	public NewNoteWindow(AddressEntry pickedEntry, ViewWindow pW) {
		parentWindow = pW;
		List<Note> notes = pickedEntry.getNotes();
		
		setTitle("New Note:");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setBounds(35, 11, 46, 14);
		contentPanel.add(lblNote);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setColumns(60);
		textArea.setBounds(35, 26, 342, 203);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Submit");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						notes.add(new Note(pickedEntry.getID()
								, textArea.getText()));
						pickedEntry.setNotes(notes);
						try {
							pickedEntry.saveNotes();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						AddressBookApplication.addressBook.insertAddress(pickedEntry);
						parentWindow.displayList(pickedEntry);
							
						setVisible(false);
		                dispatchEvent(new WindowEvent(NewNoteWindow.this
		                		, WindowEvent.WINDOW_CLOSING));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
		                dispatchEvent(new WindowEvent(NewNoteWindow.this
		                		, WindowEvent.WINDOW_CLOSING));
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
