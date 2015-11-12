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
 * Purpose: Used to create a button that, when pressed, 
 * loads the entire address book off a database. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class LoadBtn implements ActionListener{
	JButton loadBtn;
	
	public LoadBtn() {
		loadBtn = new JButton("Load");
		loadBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			AddressBookApplication.addressBook.load();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @return the loadBtn
	 */
	public JButton getLoadBtn() {
		return loadBtn;
	}

	/**
	 * @param loadBtn the loadBtn to set
	 */
	public void setLoadBtn(JButton loadBtn) {
		this.loadBtn = loadBtn;
	}
}
