package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import address.gui.NewWindow;
import address.gui.Window;

/**
 * Purpose: Used to create a button that, when pressed, will
 * take the user to a window that allows them to create a whole
 * new entry in the address book. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */

public class NewBtn implements ActionListener{
	JButton newBtn;
	Window parentWindow;
	
	public NewBtn(Window mainWindow) {
		parentWindow = mainWindow;
		newBtn = new JButton("New");
		newBtn.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		NewWindow newWindow = new NewWindow(parentWindow);
		newWindow.setVisible(true);
	}
	/**
	 * @return the newBtn
	 */
	public JButton getNewBtn() {
		return newBtn;
	}
	/**
	 * @param newBtn the newBtn to set
	 */
	public void setNewBtn(JButton newBtn) {
		this.newBtn = newBtn;
	}
}
