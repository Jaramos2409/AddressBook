package address.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import address.gui.event.CloseCancelBtn;
import address.gui.event.SearchAddressBtn;
import address.gui.event.ViewBtn;

public class SearchAddressBookWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	DefaultListModel<KeyNamePair> foundEntries;
	JList<KeyNamePair> foundList;
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public SearchAddressBookWindow() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		foundEntries = new DefaultListModel<KeyNamePair>();
		foundList = new JList<KeyNamePair>(foundEntries);
		
		setTitle("Find Address:");
		setBounds(100, 100, 360, 316);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSearch = new JLabel("Search by Last Name:");
			lblSearch.setBounds(32, 11, 132, 14);
			contentPanel.add(lblSearch);
		}
		{
			textField = new JTextField();
			textField.setBounds(32, 30, 189, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel searchBtnPanel = new JPanel();
			searchBtnPanel.setBounds(231, 29, 91, 23);
			searchBtnPanel.setLayout(new BorderLayout(0, 0));
			contentPanel.add(searchBtnPanel);
			
			SearchAddressBtn btnSearch = new SearchAddressBtn(this, foundEntries, foundList);
			searchBtnPanel.add(btnSearch.getSearchBtn());
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 58, 290, 163);
			contentPanel.add(scrollPane);
			{
				scrollPane.setViewportView(foundList);
			}
		}
		
		JPanel viewEntryPanel = new JPanel();
		viewEntryPanel.setBounds(32, 224, 290, 23);
		viewEntryPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(viewEntryPanel);
		
		ViewBtn btnViewEntry = new ViewBtn(foundList);
		viewEntryPanel.add(btnViewEntry.getViewBtn());
		{
			
		}
		

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				CloseCancelBtn btnClose = new CloseCancelBtn(this, "Close");
				buttonPane.add(btnClose.getBtnCancel());
			}
		}

	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @param textField the textField to set
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
}
