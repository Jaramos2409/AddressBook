package address.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import address.AddressBookApplication;
import address.data.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.List;

public class SearchWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultListModel<KeyNamePair> foundEntries;
	JList<KeyNamePair> foundList;
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public SearchWindow() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		foundEntries = new DefaultListModel<KeyNamePair>();
		foundList = new JList<KeyNamePair>(foundEntries);
		
		setTitle("Find Address:");
		setBounds(100, 100, 300, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSearch = new JLabel("Search:");
			lblSearch.setBounds(32, 15, 49, 14);
			contentPanel.add(lblSearch);
		}
		{
			textField = new JTextField();
			textField.setBounds(79, 12, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddressBook selections = AddressBookApplication.addressBook
							.find(textField.getText());
					foundEntries.clear();
					List<KeyNamePair> entries = selections.getKeyNames();
					for(KeyNamePair entry: entries) {
						foundEntries.addElement(entry);
					}
					foundList.setModel(foundEntries);
				}
			});
			btnSearch.setBounds(172, 11, 91, 23);
			contentPanel.add(btnSearch);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 40, 231, 163);
			contentPanel.add(scrollPane);
			{
				scrollPane.setViewportView(foundList);
			}
		}
		
		JButton btnViewEntry = new JButton("View Entry");
		btnViewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindow viewWindow = new ViewWindow(foundList);
				viewWindow.setVisible(true);
			}
		});
		btnViewEntry.setBounds(32, 206, 231, 23);
		contentPanel.add(btnViewEntry);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnClose = new JButton("Close");
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
		                dispatchEvent(new WindowEvent(SearchWindow.this
		                		, WindowEvent.WINDOW_CLOSING));
					}
				});
				buttonPane.add(btnClose);
			}
		}

	}
}
