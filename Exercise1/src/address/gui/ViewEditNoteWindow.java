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
 * Purpose: Used to create the window that allows
 * the user to edit an already existing note from the database.
 * Once submitted, the note is updated in the database. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class ViewEditNoteWindow extends JDialog {
	ViewWindow parentWindow;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ViewEditNoteWindow(int selectedIndex, AddressEntry pickedEntry, ViewWindow pW) {
		parentWindow = pW;
		List<Note> notes = pickedEntry.getNotes();
		
		setTitle("View/Edit Note:");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNote = new JLabel("Note:");
		lblNote.setBounds(35, 11, 46, 14);
		contentPanel.add(lblNote);
		
		JTextArea textArea = new JTextArea(notes.get(selectedIndex).getNote());
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
						notes.set(selectedIndex, new Note(pickedEntry.getID()
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
		                dispatchEvent(new WindowEvent(ViewEditNoteWindow.this
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
		                dispatchEvent(new WindowEvent(ViewEditNoteWindow.this
		                		, WindowEvent.WINDOW_CLOSING));
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
