package address.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import address.gui.event.CloseCancelBtn;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

/**
 * Purpose: Used for creating the window that allows
 * the user to pick what type of search they want to do:
 * through the address book or through the notes database. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class SearchPickWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public SearchPickWindow() {
		setTitle("Which Search?");
		setBounds(100, 100, 286, 124);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JButton btnSearchAddressBook = new JButton("Search Address Book");
			btnSearchAddressBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
			        dispatchEvent(new WindowEvent(SearchPickWindow.this
			        		, WindowEvent.WINDOW_CLOSING));
					SearchAddressBookWindow searchAddressWindow = new SearchAddressBookWindow();
					searchAddressWindow.setVisible(true);
				}
			});
			contentPanel.add(btnSearchAddressBook);
		}
		{
			JButton btnSearchNotes = new JButton("Search Notes");
			btnSearchNotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
			        dispatchEvent(new WindowEvent(SearchPickWindow.this
			        		, WindowEvent.WINDOW_CLOSING));
			        SearchNotesWindow searchNotesWindow = new SearchNotesWindow();
			        searchNotesWindow.setVisible(true);
				}
			});
			contentPanel.add(btnSearchNotes);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				CloseCancelBtn btnClose = new CloseCancelBtn(this, "Close");
				buttonPane.add(btnClose.getBtnCancel());
			}
		}
	}

}
