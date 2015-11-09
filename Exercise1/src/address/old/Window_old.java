package address.old;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class Window_old {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_old window = new Window_old();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window_old() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setBounds(0, 0, 479, 23);
		btnDisplay.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(btnDisplay);
		
		String categories[] = { "Household", "Office", "Extended Family",
		        "Company (US)", "Company (World)", "Team", "Will",
		        "Birthday Card List", "High School", "Country", "Continent",
		        "Planet" };
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 21, 283, 360);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList(categories);
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("New ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 380, 117, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBounds(116, 380, 91, 23);
		frame.getContentPane().add(btnNewButton_1);
		
	}

}
