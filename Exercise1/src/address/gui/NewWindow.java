package address.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import address.gui.event.CloseCancelBtn;
import address.gui.event.NewEntryOKBtn;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

/**
 * Purpose: Used to create a window that is used to add a new
 * Address Book Entry to the Address Book
 * @author Jesus Ramos
 * @version 1.0
 * @since Nov 12, 2015, JDK 8
 */
public class NewWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	/*
	 * The first name
	 */
	private JTextField fNField;
	/*
	 * The last name
	 */
	private JTextField lNField;
	/*
	 * The Street Address
	 */
	private JTextField strField;
	/*
	 * The City name
	 */
	private JTextField cityField;
	/*
	 * The state
	 */
	private JTextField staField;
	/*
	 * The Zip code
	 */
	private JTextField zipField;
	/*
	 * Email
	 */
	private JTextField emailField;
	/*
	 * Phone Number
	 */
	private JTextField phoneField;

	/**
	 * Purpose: Creates a window with various text areas each tied to a certain
	 * element of an address book entry. Also contains a submit button that, when hit
	 * adds the newly created entry to the Address Book.
	 * @param mainWindow the window from which this one came from
	 */
	public NewWindow(Window mainWindow) {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 224, 300);
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
			gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.gridx = 1;
			gbc_lblFirstName.gridy = 0;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			fNField = new JTextField();
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
			lNField = new JTextField();
			GridBagConstraints gbc_lNField = new GridBagConstraints();
			gbc_lNField.insets = new Insets(0, 0, 5, 0);
			gbc_lNField.fill = GridBagConstraints.HORIZONTAL;
			gbc_lNField.gridx = 2;
			gbc_lNField.gridy = 1;
			contentPanel.add(lNField, gbc_lNField);
			lNField.setColumns(10);
		}
		{
			JLabel lblStreet = new JLabel("Street");
			GridBagConstraints gbc_lblStreet = new GridBagConstraints();
			gbc_lblStreet.anchor = GridBagConstraints.EAST;
			gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
			gbc_lblStreet.gridx = 1;
			gbc_lblStreet.gridy = 2;
			contentPanel.add(lblStreet, gbc_lblStreet);
		}
		{
			strField = new JTextField();
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
			cityField = new JTextField();
			GridBagConstraints gbc_cityField = new GridBagConstraints();
			gbc_cityField.insets = new Insets(0, 0, 5, 0);
			gbc_cityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cityField.gridx = 2;
			gbc_cityField.gridy = 3;
			contentPanel.add(cityField, gbc_cityField);
			cityField.setColumns(10);
		}
		{
			JLabel lblState = new JLabel("State:");
			GridBagConstraints gbc_lblState = new GridBagConstraints();
			gbc_lblState.insets = new Insets(0, 0, 5, 5);
			gbc_lblState.anchor = GridBagConstraints.EAST;
			gbc_lblState.gridx = 1;
			gbc_lblState.gridy = 4;
			contentPanel.add(lblState, gbc_lblState);
		}
		{
			staField = new JTextField();
			GridBagConstraints gbc_staField = new GridBagConstraints();
			gbc_staField.insets = new Insets(0, 0, 5, 0);
			gbc_staField.fill = GridBagConstraints.HORIZONTAL;
			gbc_staField.gridx = 2;
			gbc_staField.gridy = 4;
			contentPanel.add(staField, gbc_staField);
			staField.setColumns(10);
		}
		{
			JLabel lblZip = new JLabel("Zip:");
			GridBagConstraints gbc_lblZip = new GridBagConstraints();
			gbc_lblZip.insets = new Insets(0, 0, 5, 5);
			gbc_lblZip.anchor = GridBagConstraints.EAST;
			gbc_lblZip.gridx = 1;
			gbc_lblZip.gridy = 5;
			contentPanel.add(lblZip, gbc_lblZip);
		}
		{
			zipField = new JTextField();
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
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.gridx = 1;
			gbc_lblEmail.gridy = 6;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			emailField = new JTextField();
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
			gbc_lblPhone.insets = new Insets(0, 0, 0, 5);
			gbc_lblPhone.anchor = GridBagConstraints.EAST;
			gbc_lblPhone.gridx = 1;
			gbc_lblPhone.gridy = 7;
			contentPanel.add(lblPhone, gbc_lblPhone);
		}
		{
			phoneField = new JTextField();
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
				NewEntryOKBtn btnOk = new NewEntryOKBtn(this, mainWindow);
				buttonPane.add(btnOk.getBtnOK());
				getRootPane().setDefaultButton(btnOk.getBtnOK());
			}
			{
				CloseCancelBtn btnCancel = new CloseCancelBtn(this, "Cancel");
				buttonPane.add(btnCancel.getBtnCancel());
			}
		}
	}
	
	/**
	 * Purpose: Reset all text boxes to a white background
	 */
	public void setAllWhite () {
		fNField.setBackground(Color.white);
		lNField.setBackground(Color.white);
		strField.setBackground(Color.white);
		cityField.setBackground(Color.white);
		staField.setBackground(Color.white);
		zipField.setBackground(Color.white);
		emailField.setBackground(Color.white);
		phoneField.setBackground(Color.white);
	}

	/*
	 * Purpose: Checks if the user is inputting proper data for each
	 * element in the entry
	 * @return true if all the tests passed, false if the user has input invalid
	 * data
	 */
	public boolean textCheck() {
		boolean check = fNField.getText().matches("^[\\p{L} .'-]+[\\pL\\pZ\\pP]{0,}+$");
		if (!check) {
			fNField.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(NewWindow.this,
					"Invalid input. Please try again "
							+ "with only alphabet characters",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
			return check;
		}
		check = lNField.getText().matches("^[\\p{L} .'-]+[\\pL\\pZ\\pP]{0,}+$");
		if (!check) {
			lNField.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(NewWindow.this,
					"Invalid input. Please try again "
							+ "with only alphabet characters",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
			return check;
		}
		check = strField.getText().matches("\\d.*");
		if (!check) {
			strField.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(NewWindow.this,
					"Invalid input. Please try again "
							+ "with a valid address i.e. 123 Example St.",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
			return check;
		}
		check = cityField.getText().matches("^[\\p{L} .'-]+[\\pL\\pZ\\pP]{0,}+$");
		if(!check) {
			cityField.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(NewWindow.this,
					"Invalid input. Please try again "
							+ "with only alphabet characters",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
			return check;
		}
		check = staField.getText().matches("[a-zA-Z]+");
		if(!check) {
			staField.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(NewWindow.this,
					"Invalid input. Please try again "
							+ "with only alphabet characters i.e. AZ or CA",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
			return check;
		}
		check = zipField.getText().matches("[0-9]+");
		if(!check) {
			zipField.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(NewWindow.this,
					"Invalid input. Please try again "
							+ "with only numbers",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
			return check;
		}
		check = emailField.getText().contains("@");
		if(!check) {
			emailField.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(NewWindow.this,
					"Invalid input. Please try again "
							+ "with a valid email i.e. dangerousmuffin@hotmail.com",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
			return check;
		}
		check = phoneField.getText().matches("\\d{3}-\\d{3}-\\d{4}");
		if(!check) {
			phoneField.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(NewWindow.this,
					"Invalid input. Please try again "
							+ "with a valid phone number i.e. 555-999-2345",
				    "ERROR",
				    JOptionPane.ERROR_MESSAGE);
			return check;
		}
		return check;
	}

	/**
	 * @return the fNField
	 */
	public JTextField getfNField() {
		return fNField;
	}

	/**
	 * @param fNField the fNField to set
	 */
	public void setfNField(JTextField fNField) {
		this.fNField = fNField;
	}

	/**
	 * @return the lNField
	 */
	public JTextField getlNField() {
		return lNField;
	}

	/**
	 * @param lNField the lNField to set
	 */
	public void setlNField(JTextField lNField) {
		this.lNField = lNField;
	}

	/**
	 * @return the strField
	 */
	public JTextField getStrField() {
		return strField;
	}

	/**
	 * @param strField the strField to set
	 */
	public void setStrField(JTextField strField) {
		this.strField = strField;
	}

	/**
	 * @return the cityField
	 */
	public JTextField getCityField() {
		return cityField;
	}

	/**
	 * @param cityField the cityField to set
	 */
	public void setCityField(JTextField cityField) {
		this.cityField = cityField;
	}

	/**
	 * @return the staField
	 */
	public JTextField getStaField() {
		return staField;
	}

	/**
	 * @param staField the staField to set
	 */
	public void setStaField(JTextField staField) {
		this.staField = staField;
	}

	/**
	 * @return the zipField
	 */
	public JTextField getZipField() {
		return zipField;
	}

	/**
	 * @param zipField the zipField to set
	 */
	public void setZipField(JTextField zipField) {
		this.zipField = zipField;
	}

	/**
	 * @return the emailField
	 */
	public JTextField getEmailField() {
		return emailField;
	}

	/**
	 * @param emailField the emailField to set
	 */
	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	/**
	 * @return the phoneField
	 */
	public JTextField getPhoneField() {
		return phoneField;
	}

	/**
	 * @param phoneField the phoneField to set
	 */
	public void setPhoneField(JTextField phoneField) {
		this.phoneField = phoneField;
	}

	/**
	 * @return the contentPanel
	 */
	public JPanel getContentPanel() {
		return contentPanel;
	}
	
}
