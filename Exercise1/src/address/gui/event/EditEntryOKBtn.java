package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import address.AddressBookApplication;
import address.data.Address;
import address.data.AddressEntry;
import address.data.Name;
import address.gui.EditWindow;
import address.gui.NewWindow;
import address.gui.Window;

/**
 * Purpose: Used to create a button that, when pressed
 * will submit a newly edited entry into the address book.
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class EditEntryOKBtn implements ActionListener{
	JButton btnOK;
	EditWindow parentWindow;
	Window mainWindow;
	
	public EditEntryOKBtn (EditWindow editWindow, Window mWind) {
		parentWindow = editWindow;
		mainWindow = mWind;
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		AddressEntry entry = new AddressEntry(parentWindow.getPickedEntry().getID(),
				new Name(parentWindow.getfNField().getText(), parentWindow.getlNField().getText()), 
				new Address(parentWindow.getStrField().getText(), parentWindow.getCityField().getText(), 
						parentWindow.getStaField().getText(),parentWindow.getZipField().getText())
				,parentWindow.getEmailField().getText(), parentWindow.getPhoneField().getText() 
				,parentWindow.getPickedEntry().getNotes());
		AddressBookApplication.addressBook.insertAddress(entry);
		
		mainWindow.displayList();
		
		parentWindow.setVisible(false);
		parentWindow.dispatchEvent(new WindowEvent(parentWindow
        		, WindowEvent.WINDOW_CLOSING));
	}

	/**
	 * @return the btnOK
	 */
	public JButton getBtnOK() {
		return btnOK;
	}

	/**
	 * @param btnOK the btnOK to set
	 */
	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}
	
	
}
