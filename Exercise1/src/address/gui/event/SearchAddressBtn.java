/**
 * 
 */
package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import address.AddressBookApplication;
import address.data.AddressBook;
import address.gui.KeyNamePair;
import address.gui.SearchAddressBookWindow;

/**
 * Purpose: Used to create a button that, when pressed, will
 * search the entire address book for the entry that
 * the user is looking for. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class SearchAddressBtn implements ActionListener{
	private JButton searchBtn;
	private SearchAddressBookWindow parentWindow;
	private DefaultListModel<KeyNamePair> foundEntries;
	private JList<KeyNamePair> foundList;
	
	public SearchAddressBtn(SearchAddressBookWindow pW, DefaultListModel<KeyNamePair> fE, JList<KeyNamePair> fL){
		parentWindow = pW;
		foundEntries = fE;
		foundList = fL;
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		AddressBook selections = AddressBookApplication.addressBook
				.find(parentWindow.getTextField().getText());
		foundEntries.clear();
		List<KeyNamePair> entries = selections.getKeyNames();
		for(KeyNamePair entry: entries) {
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
