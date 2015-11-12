/**
 * 
 */
package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import address.gui.SearchPickWindow;

/**
 * Purpose: Used to create a button that, when pressed, will
 * take the user to a window that allows them to choose what type
 * of search they want to do on the address book, 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class FindBtn implements ActionListener{
	JButton findBtn;
	
	public FindBtn () {
		findBtn = new JButton("Find");
		findBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		SearchPickWindow searchWindow = new SearchPickWindow();
		searchWindow.setVisible(true);
	}

	/**
	 * @return the findBtn
	 */
	public JButton getFindBtn() {
		return findBtn;
	}

	/**
	 * @param findBtn the findBtn to set
	 */
	public void setFindBtn(JButton findBtn) {
		this.findBtn = findBtn;
	}
	
	
}
