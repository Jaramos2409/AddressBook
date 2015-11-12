package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;

import address.gui.KeyNamePair;
import address.gui.ViewWindow;

/**
 * Purpose: Used to create a button that, when pressed, will 
 * take the user to the view window that will display
 * all of the elements of the selected entry. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */

public class ViewBtn implements ActionListener {
	JButton viewBtn;
	JList<KeyNamePair> list;
	
	public ViewBtn (JList<KeyNamePair> l) {
		list = l;
		viewBtn = new JButton("View Entry");
		viewBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(list.getSelectedIndex() != -1) {
			ViewWindow viewWindow = new ViewWindow(list);
			viewWindow.setVisible(true);
		}
	}

	/**
	 * @return the viewBtn
	 */
	public JButton getViewBtn() {
		return viewBtn;
	}

	/**
	 * @param viewBtn the viewBtn to set
	 */
	public void setViewBtn(JButton viewBtn) {
		this.viewBtn = viewBtn;
	}
	
	/**
	 * Purpose: Set the bounds of the button on the frame
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */
	public void setBounds (int x, int y, int z, int w){
		viewBtn.setBounds(x, y, z, w);
	}
	
}
