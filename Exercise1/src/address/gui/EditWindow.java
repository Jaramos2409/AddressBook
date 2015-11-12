package address.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import address.AddressBookApplication;
import address.data.Address;
import address.data.AddressEntry;
import address.data.Name;
import address.data.Note;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

public class EditWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField fNField;
	private JTextField lNField;
	private JTextField strField;
	private JTextField cityField;
	private JTextField staField;
	private JTextField zipField;
	private JTextField emailField;
	private JTextField phoneField;

	/**
	 * Create the dialog.
	 */
	public EditWindow(Window mainWindow) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		String key = mainWindow.list.getSelectedValue().getKey();
		AddressEntry pickedEntry = 
				AddressBookApplication.addressBook.getEntry(key);
		
		setTitle("Edit Address:");
		setBounds(100, 100, 230, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblFirstName = new JLabel("First Name:");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
			gbc_lblFirstName.gridx = 1;
			gbc_lblFirstName.gridy = 0;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			fNField = new JTextField(pickedEntry
					.getName().getFirstName(),5);
			GridBagConstraints gbc_fNField = new GridBagConstraints();
			gbc_fNField.insets = new Insets(0, 0, 5, 0);
			gbc_fNField.fill = GridBagConstraints.HORIZONTAL;
			gbc_fNField.gridx = 2;
			gbc_fNField.gridy = 0;
			contentPanel.add(fNField, gbc_fNField);
			fNField.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last Name:");
			GridBagConstraints gbc_lblLastName = new GridBagConstraints();
			gbc_lblLastName.anchor = GridBagConstraints.EAST;
			gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
			gbc_lblLastName.gridx = 1;
			gbc_lblLastName.gridy = 1;
			contentPanel.add(lblLastName, gbc_lblLastName);
		}
		{
			lNField = new JTextField(pickedEntry
					.getName().getLastName(),5);
			GridBagConstraints gbc_lNField = new GridBagConstraints();
			gbc_lNField.insets = new Insets(0, 0, 5, 0);
			gbc_lNField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lNField.gridx = 2;
			gbc_lNField.gridy = 1;
			contentPanel.add(lNField, gbc_lNField);
			lNField.setColumns(10);
		}
		{
			JLabel lblStreet = new JLabel("Street:");
			GridBagConstraints gbc_lblStreet = new GridBagConstraints();
			gbc_lblStreet.anchor = GridBagConstraints.EAST;
			gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
			gbc_lblStreet.gridx = 1;
			gbc_lblStreet.gridy = 2;
			contentPanel.add(lblStreet, gbc_lblStreet);
		}
		{
			strField = new JTextField(pickedEntry
					.getAddress().getStreet(),5);
			GridBagConstraints gbc_strField = new GridBagConstraints();
			gbc_strField.insets = new Insets(0, 0, 5, 0);
			gbc_strField.fill = GridBagConstraints.HORIZONTAL;
			gbc_strField.gridx = 2;
			gbc_strField.gridy = 2;
			contentPanel.add(strField, gbc_strField);
			strField.setColumns(10);
		}
		{
			JLabel lblCity = new JLabel("City:");
			GridBagConstraints gbc_lblCity = new GridBagConstraints();
			gbc_lblCity.anchor = GridBagConstraints.EAST;
			gbc_lblCity.insets = new Insets(0, 0, 5, 5);
			gbc_lblCity.gridx = 1;
			gbc_lblCity.gridy = 3;
			contentPanel.add(lblCity, gbc_lblCity);
		}
		{
			cityField = new JTextField(pickedEntry
					.getAddress().getCity(),5);
			GridBagConstraints gbc_cityField = new GridBagConstraints();
			gbc_cityField.insets = new Insets(0, 0, 5, 0);
			gbc_cityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cityField.gridx = 2;
			gbc_cityField.gridy = 3;
			contentPanel.add(cityField, gbc_cityField);
			cityField.setColumns(10);
		}
		{
			JLabel lblState = new JLabel("State");
			GridBagConstraints gbc_lblState = new GridBagConstraints();
			gbc_lblState.anchor = GridBagConstraints.EAST;
			gbc_lblState.insets = new Insets(0, 0, 5, 5);
			gbc_lblState.gridx = 1;
			gbc_lblState.gridy = 4;
			contentPanel.add(lblState, gbc_lblState);
		}
		{
			staField = new JTextField(pickedEntry
					.getAddress().getState(),5);
			GridBagConstraints gbc_staField = new GridBagConstraints();
			gbc_staField.insets = new Insets(0, 0, 5, 0);
			gbc_staField.fill = GridBagConstraints.HORIZONTAL;
			gbc_staField.gridx = 2;
			gbc_staField.gridy = 4;
			contentPanel.add(staField, gbc_staField);
			staField.setColumns(10);
		}
		{
			JLabel lblZip = new JLabel("Zip");
			GridBagConstraints gbc_lblZip = new GridBagConstraints();
			gbc_lblZip.anchor = GridBagConstraints.EAST;
			gbc_lblZip.insets = new Insets(0, 0, 5, 5);
			gbc_lblZip.gridx = 1;
			gbc_lblZip.gridy = 5;
			contentPanel.add(lblZip, gbc_lblZip);
		}
		{
			zipField = new JTextField(pickedEntry
					.getAddress().getZip(),5);
			GridBagConstraints gbc_zipField = new GridBagConstraints();
			gbc_zipField.insets = new Insets(0, 0, 5, 0);
			gbc_zipField.fill = GridBagConstraints.HORIZONTAL;
			gbc_zipField.gridx = 2;
			gbc_zipField.gridy = 5;
			contentPanel.add(zipField, gbc_zipField);
			zipField.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 1;
			gbc_lblEmail.gridy = 6;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			emailField = new JTextField(pickedEntry
					.getEmail(),5);
			GridBagConstraints gbc_emailField = new GridBagConstraints();
			gbc_emailField.insets = new Insets(0, 0, 5, 0);
			gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
			gbc_emailField.gridx = 2;
			gbc_emailField.gridy = 6;
			contentPanel.add(emailField, gbc_emailField);
			emailField.setColumns(10);
		}
		{
			JLabel lblPhone = new JLabel("Phone:");
			GridBagConstraints gbc_lblPhone = new GridBagConstraints();
			gbc_lblPhone.anchor = GridBagConstraints.EAST;
			gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
			gbc_lblPhone.gridx = 1;
			gbc_lblPhone.gridy = 7;
			contentPanel.add(lblPhone, gbc_lblPhone);
		}
		{
			phoneField = new JTextField(pickedEntry
					.getPhone(),5);
			GridBagConstraints gbc_phoneField = new GridBagConstraints();
			gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
			gbc_phoneField.gridx = 2;
			gbc_phoneField.gridy = 7;
			contentPanel.add(phoneField, gbc_phoneField);
			phoneField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AddressEntry entry = new AddressEntry( pickedEntry.getID(),
								new Name(fNField.getText(), lNField.getText()), 
								new Address(strField.getText(), cityField.getText(), 
										staField.getText(),zipField.getText())
								,emailField.getText(), phoneField.getText()
								,pickedEntry.getNotes());
						AddressBookApplication.addressBook.insertAddress(entry);
						
						mainWindow.displayList();
						
						setVisible(false);
		                dispatchEvent(new WindowEvent(EditWindow.this
		                		, WindowEvent.WINDOW_CLOSING));
					}
				});
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
		                dispatchEvent(new WindowEvent(EditWindow.this
		                		, WindowEvent.WINDOW_CLOSING));
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

}
