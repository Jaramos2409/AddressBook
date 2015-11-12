package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

import address.gui.NewWindow;

/**
 * Purpose: Used to create a close or cancel button
 * that will close any window it lays on. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class CloseCancelBtn implements ActionListener{
	JButton btnCancel;
	JDialog parentWindow;
	
	public CloseCancelBtn (JDialog newWindow, String name) {
		parentWindow = newWindow;
		btnCancel = new JButton(name);
		btnCancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		parentWindow.setVisible(false);
        parentWindow.dispatchEvent(new WindowEvent(parentWindow
        		, WindowEvent.WINDOW_CLOSING));
	}

	/**
	 * @return the btnCancel
	 */
	public JButton getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @param btnCancel the btnCancel to set
	 */
	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}
	
}
