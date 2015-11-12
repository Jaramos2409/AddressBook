package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import address.gui.Window;

/**
 * Purpose: Used to create a button that, when pressed,
 * will display the currently loaded address book onto it's
 * accompanying scroll list. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */

public class DisplayBtn implements ActionListener{
	JButton btnDisplay;
	Window parentWindow;
	
	public DisplayBtn(Window mainWindow) {
		parentWindow = mainWindow;
		btnDisplay = new JButton("Display List");
		btnDisplay.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		parentWindow.displayList();
	}

	/**
	 * @return the btnDisplay
	 */
	public JButton getBtnDisplay() {
		return btnDisplay;
	}

	/**
	 * @param btnDisplay the btnDisplay to set
	 */
	public void setBtnDisplay(JButton btnDisplay) {
		this.btnDisplay = btnDisplay;
	}
	
	
}
