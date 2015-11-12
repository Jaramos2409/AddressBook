/**
 * 
 */
package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import address.AddressBookApplication;
import address.data.AddressBook;
import address.data.Note;
import address.gui.KeyNamePair;
import address.gui.SearchAddressBookWindow;
import address.gui.SearchNotesWindow;

/**
 * Purpose: Used to create a button that, when pressed, 
 * will search through the notes database to find matching notes
 * to the one that the user is looking for. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class SearchNotesBtn implements ActionListener{
	private JButton searchBtn;
	private SearchNotesWindow parentWindow;
	private DefaultListModel<Note> foundEntries;
	private JList<Note> foundList;
	
	public SearchNotesBtn(SearchNotesWindow pW, DefaultListModel<Note> fE, JList<Note> fL){
		parentWindow = pW;
		foundEntries = fE;
		foundList = fL;
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String searchTerm = parentWindow.getTextField().getText();
		List<Note> searchResults = new ArrayList<Note>();
		List<Note> finalSearchResult = new ArrayList<Note>();
		try {
			searchResults = AddressBookApplication.addressBook
					.findNotes(searchTerm);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		foundEntries.clear();
		
		for(Note entry: searchResults) {
			if(entry.getNote().contains(searchTerm))
			{
				finalSearchResult.add(entry);
			}
		}
		
		for(Note entry: finalSearchResult) {
			foundEntries.addElement(entry);
		}
		
		foundList.setModel(foundEntries);
	}

	/**
	 * @return the searchBtn
	 */
	public JButton getSearchBtn() {
		return searchBtn;
	}

	/**
	 * @param searchBtn the searchBtn to set
	 */
	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}
	
	

}
