/**
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 3, 2015, JDK 8
 */
package address.gui;

import address.AddressBookApplication;
import address.data.*;
import address.gui.event.DisplayBtn;
import address.gui.event.EditBtn;
import address.gui.event.ExitBtn;
import address.gui.event.FindBtn;
import address.gui.event.LoadBtn;
import address.gui.event.NewBtn;
import address.gui.event.RemoveBtn;
import address.gui.event.SaveBtn;
import address.gui.event.ViewBtn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Purpose: Used to create the main window for the application.
 * Contains all the buttons for each functionality of the program and 
 * the list of entries created after a load from the database has been
 * completed. 
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class Window extends JFrame {
	JList<KeyNamePair> list;
	DefaultListModel<KeyNamePair> AddressBookEntries;
	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddressBookEntries = new DefaultListModel<KeyNamePair>();
		list = new JList<KeyNamePair>(AddressBookEntries);
		
		setTitle("Address Book");
		setBounds(100, 100, 600, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		DisplayBtn btnDisplay = new DisplayBtn(this);
		GridBagConstraints gbc_btnDisplay = new GridBagConstraints();
		gbc_btnDisplay.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplay.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplay.gridx = 0;
		gbc_btnDisplay.gridy = 0;
		getContentPane().add(btnDisplay.getBtnDisplay(), gbc_btnDisplay);
		
		NewBtn btnNew = new NewBtn(this);
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew.gridx = 1;
		gbc_btnNew.gridy = 0;
		getContentPane().add(btnNew.getNewBtn(), gbc_btnNew);
		
		EditBtn btnEdit = new EditBtn(Window.this, list);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 0;
		getContentPane().add(btnEdit.getEditBtn(), gbc_btnEdit);
		
		RemoveBtn btnRemove = new RemoveBtn(list, AddressBookEntries);
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 3;
		gbc_btnRemove.gridy = 0;
		getContentPane().add(btnRemove.getBtnRemove(), gbc_btnRemove);
		
		JScrollPane AddressBookList = new JScrollPane(list);
		GridBagConstraints gbc_AddressBookList = new GridBagConstraints();
		gbc_AddressBookList.fill = GridBagConstraints.BOTH;
		gbc_AddressBookList.insets = new Insets(0, 0, 5, 5);
		gbc_AddressBookList.gridx = 0;
		gbc_AddressBookList.gridy = 1;
		getContentPane().add(AddressBookList, gbc_AddressBookList);
		
		ViewBtn btnView = new ViewBtn(list);
		GridBagConstraints gbc_btnView = new GridBagConstraints();
		gbc_btnView.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnView.insets = new Insets(0, 0, 0, 5);
		gbc_btnView.gridx = 0;
		gbc_btnView.gridy = 2;
		getContentPane().add(btnView.getViewBtn(), gbc_btnView);
		
		LoadBtn btnLoad = new LoadBtn();
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLoad.insets = new Insets(0, 0, 0, 5);
		gbc_btnLoad.gridx = 1;
		gbc_btnLoad.gridy = 2;
		getContentPane().add(btnLoad.getLoadBtn(), gbc_btnLoad);
		
		SaveBtn btnSave = new SaveBtn();
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 2;
		getContentPane().add(btnSave.getSaveBtn(), gbc_btnSave);
		
		FindBtn btnFind = new FindBtn();
		GridBagConstraints gbc_btnFind = new GridBagConstraints();
		gbc_btnFind.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFind.insets = new Insets(0, 0, 0, 5);
		gbc_btnFind.gridx = 3;
		gbc_btnFind.gridy = 2;
		getContentPane().add(btnFind.getFindBtn(), gbc_btnFind);
		
		ExitBtn btnExit = new ExitBtn(this);
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 4;
		gbc_btnExit.gridy = 2;
		getContentPane().add(btnExit.getExitBtn(), gbc_btnExit);
	}
	
	public void displayList() {
		AddressBookEntries.clear();
		List<KeyNamePair> entries = AddressBookApplication.addressBook.getKeyNames();
		for(KeyNamePair entry: entries) {
			AddressBookEntries.addElement(entry);
		}
		list.setModel(AddressBookEntries);
	}
    
}