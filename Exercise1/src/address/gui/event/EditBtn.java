package address.gui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;

import address.gui.EditWindow;
import address.gui.KeyNamePair;
import address.gui.Window;

/**
 * Purpose: Used to created a button that, when pressed
 * will take the user to the window that allows them to 
 * edit an existing entry if they have selected one 
 * from the scrolling list. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */

public class EditBtn implements ActionListener{
	JButton editBtn;
	Window parentWindow;
	JList<KeyNamePair> list;

	public EditBtn(Window mainWindow, JList<KeyNamePair> l) {
		parentWindow = mainWindow;
		list = l;
		editBtn = new JButton("Edit");
		editBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(list.getSelectedIndex() != -1) {
			EditWindow editWindow = new EditWindow(parentWindow);
			editWindow.setVisible(true);
		}
	}

	/**
	 * @return the editBtn
	 */
	public JButton getEditBtn() {
		return editBtn;
	}

	/**
	 * @param editBtn the editBtn to set
	 */
	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
	}
	
	
}
