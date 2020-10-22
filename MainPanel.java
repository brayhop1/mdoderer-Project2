// Brayden Hopkins
// 10/21/2020

package project2;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import project2.AllData;
import project2.Person;

public class MainPanel extends JPanel {
	private final int WIDTH = 800, HEIGHT = 500;
	private JPanel controlPanel;
	private ImagePanel imagePanel;
	private AllData myData;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private JTextArea textArea;
	private JMenuItem mntmOpen;
	
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String phone;
	private String status;
	private String contact;
	private BufferedImage image;
	
	public MainPanel()
	{
		myData = new AllData("/contactData.txt");
		System.out.println(myData);
		
		controlPanel = new JPanel();
		controlPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
		controlPanel.setBackground(Color.BLACK);
		controlPanel.setLayout(new BorderLayout());
		imagePanel = new ImagePanel(WIDTH/2, HEIGHT);
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.CYAN);
		add(controlPanel, BorderLayout.WEST);
		
		
		/*
		 * Buttons
		 */
		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Person p = new Person(id, firstName, lastName, birthday, phone, status);
				myData.add(p);
				//myData.addContact(p, c);
				myData.writeFile("./contactData.txt");
			}
		});
		controlPanel.add(Add, BorderLayout.SOUTH);
		
		/*
		 * Labels
		 */
		JLabel existing = new JLabel("Existing");
		existing.setFont(new Font("Tahoma", Font.PLAIN, 16));
		existing.setBounds(10, 11, 115, 29);
		controlPanel.add(existing);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainPanel.class.getResource("/project2/syringe.jpg")));
		lblNewLabel.setBounds(300,105,85,73);
		controlPanel.add(lblNewLabel);
		
		JLabel id = new JLabel("ID");
		id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		id.setBounds(10, 61, 115, 29);
		controlPanel.add(id);
		
		JLabel firstName = new JLabel("First Name");
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstName.setBounds(10, 111, 115, 29);
		controlPanel.add(firstName, JLabel.CENTER);
		
		JLabel lastName = new JLabel("Last Name");
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lastName.setBounds(10, 161, 115, 29);
		controlPanel.add(lastName);
		
		JLabel birthday = new JLabel("Birthday");
		birthday.setFont(new Font("Tahoma", Font.PLAIN, 16));
		birthday.setBounds(10, 211, 115, 29);
		controlPanel.add(birthday);
		
		JLabel classification = new JLabel("Phone");
		classification.setFont(new Font("Tahoma", Font.PLAIN, 16));
		classification.setBounds(10, 261, 115, 29);
		controlPanel.add(classification);
		
		JLabel status = new JLabel("Status");
		status.setFont(new Font("Tahoma", Font.PLAIN, 16));
		status.setBounds(10, 311, 115, 29);
		controlPanel.add(status);
		
		/*
		 * Text Fields
		 */
		JTextField idField = new JTextField(20);
		idField.setBounds(100, 61, 115, 29);
		controlPanel.add(idField);
		
		JTextField fnField = new JTextField(20);
		fnField.setBounds(100, 111, 115, 29);
		controlPanel.add(fnField);
		
		JTextField lnField = new JTextField(20);
		lnField.setBounds(100, 161, 115, 29);
		controlPanel.add(lnField);
		
		JTextField birthField = new JTextField(20);
		birthField.setBounds(100, 211, 115, 29);
		controlPanel.add(birthField);
		
		JTextField phoneField = new JTextField(20);
		phoneField.setBounds(100, 261, 115, 29);
		controlPanel.add(phoneField);
		
		/*
		 * Radio Buttons
		 */
		
		JRadioButton sick = new JRadioButton("Sick");
		sick.setSelected(true);
		buttonGroup.add(sick);
		sick.setBounds(100, 321, 109, 23);
		controlPanel.add(sick);
		
		JRadioButton well = new JRadioButton("Well");
		buttonGroup.add(well);
		well.setBounds(100, 341, 109, 23);
		controlPanel.add(well);
		
		JRadioButton cured = new JRadioButton("Cured");
		buttonGroup.add(cured);
		cured.setBounds(100, 361, 109, 23);
		controlPanel.add(cured);
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 247, 133, 111);
		controlPanel.add(scrollPane);*/
		
		ArrayList<String> ids = new ArrayList<String>();
		
		JComboBox idComboBox = new JComboBox();
		idComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String id = idComboBox.getSelectedItem().toString();
				Person p = myData.findPerson(id);
				textArea.setText(p.toString());
			}
		});
		idComboBox.setModel(new DefaultComboBoxModel(ids.toArray()));
		idComboBox.setBounds(100, 10, 115, 29);
		controlPanel.add(idComboBox);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 20, 22);
		controlPanel.add(menuBar);

		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("./");

				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					imagePanel.changeImage(selectedFile.getAbsolutePath());
				}  

			}
		});
		mnFile.add(mntmOpen);
		
		add(imagePanel,BorderLayout.EAST);

		
	}
	
	
	
}
