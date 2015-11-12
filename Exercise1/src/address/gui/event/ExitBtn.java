/**
 * 
 */
package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import address.gui.Window;

/**
 * Purpose: Used to create a button that, when pressed,
 * will completely exit out of the entire program. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class ExitBtn extends JFrame implements ActionListener {
	JButton exitBtn;
	Window parentWindow;
	
	public ExitBtn(Window mainWindow) {
		parentWindow = mainWindow;
		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e ) {
		 parentWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		 System.exit(0);
	}

	/**
	 * @return the exitBtn
	 */
	public JButton getExitBtn() {
		return exitBtn;
	}

	/**
	 * @param exitBtn the exitBtn to set
	 */
	public void setExitBtn(JButton exitBtn) {
		this.exitBtn = exitBtn;
	}
	
	
}
