package address.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import address.data.Note;
import address.gui.event.CloseCancelBtn;
import address.gui.event.SearchAddressBtn;
import address.gui.event.SearchNotesBtn;
import address.gui.event.ViewBtn;
import address.gui.event.ViewEditNoteBtn;
import javax.swing.BoxLayout;

/**
 * Purpose: Used to create the window which is used for searching
 * the database for matching notes to a search term submitted by the 
 * user. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class SearchNotesWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultListModel<Note> foundEntries;
	JList<Note> foundList;
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public SearchNotesWindow() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		foundEntries = new DefaultListModel<Note>();
		foundList = new JList<Note>(foundEntries);
		
		setTitle("Find Notes:");
		setBounds(100, 100, 360, 316);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSearch = new JLabel("Search:");
			lblSearch.setBounds(30, 11, 132, 14);
			contentPanel.add(lblSearch);
		}
		{
			textField = new JTextField();
			textField.setBounds(30, 30, 189, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel searchBtnPanel = new JPanel();
			searchBtnPanel.setBounds(231, 29, 91, 23);
			searchBtnPanel.setLayout(new BorderLayout(0, 0));
			contentPanel.add(searchBtnPanel);
			
			SearchNotesBtn btnSearch = new SearchNotesBtn(this, foundEntries, foundList);
			searchBtnPanel.add(btnSearch.getSearchBtn());
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 58, 290, 163);
			contentPanel.add(scrollPane);
			{
				scrollPane.setViewportView(foundList);
			}
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

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @param textField the textField to set
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
}
