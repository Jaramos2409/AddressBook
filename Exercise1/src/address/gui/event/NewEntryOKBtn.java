/**
 * 
 */
package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import address.AddressBookApplication;
import address.data.Address;
import address.data.AddressEntry;
import address.data.Name;
import address.gui.NewWindow;
import address.gui.Window;

/**
 * Purpose: Used to create a button that, when pressed, will allow the user to 
 * submit a newly created address entry in the address book. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 11, 2015, JDK 8
 */
public class NewEntryOKBtn implements ActionListener{
	JButton btnOK;
	NewWindow parentWindow;
	Window mainWindow;
	
	public NewEntryOKBtn (NewWindow newWindow, Window mWind) {
		parentWindow = newWindow;
		mainWindow = mWind;
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		parentWindow.setAllWhite();
		if(!parentWindow.textCheck()) return;
		
		AddressEntry entry = new AddressEntry(
				new Name(parentWindow.getfNField().getText(), parentWindow.getlNField().getText()), 
				new Address(parentWindow.getStrField().getText(), parentWindow.getCityField().getText(), 
						parentWindow.getStaField().getText(),parentWindow.getZipField().getText())
				,parentWindow.getEmailField().getText(), parentWindow.getPhoneField().getText());
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
