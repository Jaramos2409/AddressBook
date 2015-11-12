/**
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 3, 2015, JDK 8
 */
package address.gui;

import address.AddressBookApplication;
import address.data.*;

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

public class Window extends JFrame {
	JList<KeyNamePair> list;
	DefaultListModel<KeyNamePair> AddressBookEntries;
	//AddressBook AB;
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
		
		JButton btnDisplay = new JButton("Display List");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayList();
			}
		});
		GridBagConstraints gbc_btnDisplay = new GridBagConstraints();
		gbc_btnDisplay.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplay.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplay.gridx = 0;
		gbc_btnDisplay.gridy = 0;
		getContentPane().add(btnDisplay, gbc_btnDisplay);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewWindow newWindow = new NewWindow(Window.this);
				newWindow.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew.gridx = 1;
		gbc_btnNew.gridy = 0;
		getContentPane().add(btnNew, gbc_btnNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditWindow editWindow = new EditWindow(Window.this);
				editWindow.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 0;
		getContentPane().add(btnEdit, gbc_btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				AddressBookApplication.addressBook.remove(list.getSelectedValue()
						.getKey());
				AddressBookEntries.remove(index);
				
				int size = AddressBookEntries.getSize();
				if (size == 0) { 
					btnRemove.setEnabled(false);
				
				} else { 
					if (index == AddressBookEntries.getSize()) {
					    index--;
					}
					list.setSelectedIndex(index);
					list.ensureIndexIsVisible(index);
				}
				
			}
		});
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 3;
		gbc_btnRemove.gridy = 0;
		getContentPane().add(btnRemove, gbc_btnRemove);
		
		JScrollPane AddressBookList = new JScrollPane(list);
		GridBagConstraints gbc_AddressBookList = new GridBagConstraints();
		gbc_AddressBookList.fill = GridBagConstraints.BOTH;
		gbc_AddressBookList.insets = new Insets(0, 0, 5, 5);
		gbc_AddressBookList.gridx = 0;
		gbc_AddressBookList.gridy = 1;
		getContentPane().add(AddressBookList, gbc_AddressBookList);
		
		JButton btnView = new JButton("View Entry");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() != -1) {
					ViewWindow viewWindow = new ViewWindow(list);
					viewWindow.setVisible(true);
				}
			}
		});
		GridBagConstraints gbc_btnView = new GridBagConstraints();
		gbc_btnView.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnView.insets = new Insets(0, 0, 0, 5);
		gbc_btnView.gridx = 0;
		gbc_btnView.gridy = 2;
		getContentPane().add(btnView, gbc_btnView);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddressBookApplication.addressBook.load();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLoad.insets = new Insets(0, 0, 0, 5);
		gbc_btnLoad.gridx = 1;
		gbc_btnLoad.gridy = 2;
		getContentPane().add(btnLoad, gbc_btnLoad);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddressBookApplication.addressBook.save();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 2;
		getContentPane().add(btnSave, gbc_btnSave);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchWindow searchWindow = new SearchWindow();
				searchWindow.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnFind = new GridBagConstraints();
		gbc_btnFind.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFind.insets = new Insets(0, 0, 0, 5);
		gbc_btnFind.gridx = 3;
		gbc_btnFind.gridy = 2;
		getContentPane().add(btnFind, gbc_btnFind);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e ) {
				 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				 System.exit(0);
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 4;
		gbc_btnExit.gridy = 2;
		getContentPane().add(btnExit, gbc_btnExit);
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