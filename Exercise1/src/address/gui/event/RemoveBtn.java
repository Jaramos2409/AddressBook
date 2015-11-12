package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import address.AddressBookApplication;
import address.gui.KeyNamePair;

/**
 * Purpose: Used to create a button that, when pressed, will allow
 * the user to remove any selected entry from the address book. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class RemoveBtn implements ActionListener{
	JButton btnRemove;
	JList<KeyNamePair> list;
	DefaultListModel<KeyNamePair> AddressBookEntries;
	
	public RemoveBtn (JList<KeyNamePair> l, DefaultListModel<KeyNamePair> aBE)  {
		list = l;
		AddressBookEntries = aBE;
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		int index = list.getSelectedIndex();
		AddressBookApplication.addressBook.remove(list.getSelectedValue()
				.getKey());
		AddressBookEntries.remove(index);
		
		int size = AddressBookEntries.getSize();
		if (size == 0) { 
			btnRemove.setEnabled(false);
		
		} else { 
			if (index == AddressBookEntries.getSize()) {
			    index--;
			}
			list.setSelectedIndex(index);
			list.ensureIndexIsVisible(index);
		}
	}

	/**
	 * @return the btnRemove
	 */
	public JButton getBtnRemove() {
		return btnRemove;
	}

	/**
	 * @param btnRemove the btnRemove to set
	 */
	public void setBtnRemove(JButton btnRemove) {
		this.btnRemove = btnRemove;
	}
	
	
}
