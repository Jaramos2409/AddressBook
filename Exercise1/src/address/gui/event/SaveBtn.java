/**
 * 
 */
package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import address.AddressBookApplication;

/**
 * Purpose: Used to create a button that, when pressed, will 
 * save the entire current address book onto the database. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class SaveBtn implements ActionListener{
	JButton saveBtn;
	
	public SaveBtn() {
		saveBtn = new JButton("Save");
		saveBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			AddressBookApplication.addressBook.save();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @return the saveBtn
	 */
	public JButton getSaveBtn() {
		return saveBtn;
	}

	/**
	 * @param saveBtn the saveBtn to set
	 */
	public void setSaveBtn(JButton saveBtn) {
		this.saveBtn = saveBtn;
	}
	
	
}
