package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DTO.ProvinceDTO;

public class testGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_Name;
	public JTextField textField_dateOfBirth;
	public JTextField textField_conductScore;
	public JTextField textField_academicScore;
	public JTextField textField_position;
	public JComboBox comboBox_homeTown;
	public ButtonGroup btn_gender;
	public JTextField textField_find;
	public JButton btn_add, btn_delete, btn_update, btn_OK, btn_cancle, btn_find;
	private JTextField textField_phoneNumber;
	private JTextField textField_citizenID;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testGUI frame = new testGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);
		
		JLabel label_studentList = new JLabel("Student List");
		label_studentList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_studentList.setBounds(10, 45, 163, 23);
		contentPane.add(label_studentList);
		
		tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Name", "Phone Number", "Citizen ID", "Hometown", "Gender", "Date of birth", "Conduct Score", "Academic Score", "Position"}
        );
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		table.getColumnModel().getColumn(6).setPreferredWidth(130);
		table.getColumnModel().getColumn(7).setPreferredWidth(110);
		table.getColumnModel().getColumn(8).setPreferredWidth(110);
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.WHITE);


		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 68, 583, 114);
		contentPane.add(scrollPane);
		
		JLabel label_studentInfo = new JLabel("Student Infomation");
		label_studentInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_studentInfo.setBounds(10, 186, 179, 23);
		contentPane.add(label_studentInfo);
		
		JLabel label_ID = new JLabel("ID");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_ID.setBounds(10, 220, 93, 23);
		contentPane.add(label_ID);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ID.setColumns(10);
		textField_ID.setBounds(139, 220, 143, 23);
		contentPane.add(textField_ID);
		
		JLabel label_Name = new JLabel("Name");
		label_Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_Name.setBounds(10, 254, 93, 23);
		contentPane.add(label_Name);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Name.setColumns(10);
		textField_Name.setBounds(139, 254, 143, 23);
		contentPane.add(textField_Name);
		
		JLabel label_academicScore = new JLabel("Academic Score");
		label_academicScore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_academicScore.setBounds(307, 288, 133, 23);
		contentPane.add(label_academicScore);
		
		textField_academicScore = new JTextField();
		textField_academicScore.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_academicScore.setColumns(10);
		textField_academicScore.setBounds(450, 288, 143, 23);
		contentPane.add(textField_academicScore);
		
		JLabel label_homTown = new JLabel("Hometown");
		label_homTown.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_homTown.setBounds(10, 288, 93, 23);
		contentPane.add(label_homTown);
		
		comboBox_homeTown = new JComboBox();
		ArrayList<ProvinceDTO> listProvince = ProvinceDTO.getListProvince();
		comboBox_homeTown.addItem("Choose province");
		for (ProvinceDTO province:listProvince)
		{
			comboBox_homeTown.addItem(province.getName());
		}
		comboBox_homeTown.setBounds(139, 288, 143, 23);
		contentPane.add(comboBox_homeTown);
		
		JLabel label_dateOfBirth = new JLabel("Date Of Birth");
		label_dateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_dateOfBirth.setBounds(10, 356, 119, 23);
		contentPane.add(label_dateOfBirth);
		
		textField_dateOfBirth = new JTextField();
		textField_dateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_dateOfBirth.setColumns(10);
		textField_dateOfBirth.setBounds(139, 356, 143, 23);
		contentPane.add(textField_dateOfBirth);
		
		JLabel label_gender = new JLabel("Gender");
		label_gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_gender.setBounds(307, 220, 119, 23);
		contentPane.add(label_gender);
		
		JRadioButton radioButton_male = new JRadioButton("Male");
		radioButton_male.setActionCommand("Male");
		radioButton_male.setBackground(new Color(255, 255, 255));
		radioButton_male.setBounds(450, 220, 56, 23);
		contentPane.add(radioButton_male);
		
		JRadioButton radioButton_female = new JRadioButton("Female");
		radioButton_female.setActionCommand("Female");
		radioButton_female.setBackground(new Color(255, 255, 255));
		radioButton_female.setBounds(525, 220, 68, 23);
		contentPane.add(radioButton_female);
		
		btn_gender = new ButtonGroup();
		btn_gender.add(radioButton_male);
		btn_gender.add(radioButton_female);
		
		JLabel label_conductScore = new JLabel("Conduct Score");
		label_conductScore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_conductScore.setBounds(307, 254, 133, 23);
		contentPane.add(label_conductScore);
		
		textField_conductScore = new JTextField();
		textField_conductScore.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_conductScore.setColumns(10);
		textField_conductScore.setBounds(450, 254, 143, 23);
		contentPane.add(textField_conductScore);
		
		JLabel label_position = new JLabel("Position");
		label_position.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_position.setBounds(307, 356, 75, 23);
		contentPane.add(label_position);
		
		textField_position = new JTextField();
		textField_position.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_position.setColumns(10);
		textField_position.setBounds(450, 356, 143, 23);
		contentPane.add(textField_position);
		
		btn_add = new JButton("Add");
		btn_add.setBackground(new Color(0, 128, 192));
		btn_add.setForeground(new Color(255, 255, 255));
		btn_add.setBounds(58, 390, 89, 23);
		contentPane.add(btn_add);
		
		btn_delete = new JButton("Delete");
		btn_delete.setBackground(new Color(255, 128, 128));
		btn_delete.setForeground(new Color(255, 255, 255));
		btn_delete.setBounds(169, 390, 89, 23);
		contentPane.add(btn_delete);
		
		btn_update = new JButton("Update");
		btn_update.setBackground(new Color(128, 255, 128));
		btn_update.setForeground(new Color(255, 255, 255));
		btn_update.setBounds(278, 390, 89, 23);
		contentPane.add(btn_update);
		
		btn_OK = new JButton("OK");
		btn_OK.setBackground(new Color(128, 255, 255));
		btn_OK.setForeground(new Color(255, 255, 255));
		btn_OK.setBounds(388, 390, 89, 23);
		contentPane.add(btn_OK);
		
		btn_cancle = new JButton("Cancle");
		btn_cancle.setBackground(new Color(255, 128, 64));
		btn_cancle.setForeground(new Color(255, 255, 255));
		btn_cancle.setBounds(501, 390, 89, 23);
		contentPane.add(btn_cancle);
		
		textField_find = new JTextField();
		textField_find.setBounds(344, 12, 136, 20);
		contentPane.add(textField_find);
		textField_find.setColumns(10);
		
		btn_find = new JButton("Find");
		btn_find.setBackground(new Color(0, 128, 255));
		btn_find.setForeground(new Color(255, 255, 255));
		btn_find.setBounds(504, 11, 89, 23);
		contentPane.add(btn_find);
		
		JLabel label_phoneNumber = new JLabel("Phone Number");
		label_phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_phoneNumber.setBounds(10, 322, 119, 23);
		contentPane.add(label_phoneNumber);
		
		textField_phoneNumber = new JTextField();
		textField_phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_phoneNumber.setColumns(10);
		textField_phoneNumber.setBounds(139, 322, 143, 23);
		contentPane.add(textField_phoneNumber);
		
		JLabel label_citizenID = new JLabel("CitizenID");
		label_citizenID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_citizenID.setBounds(307, 322, 75, 23);
		contentPane.add(label_citizenID);
		
		textField_citizenID = new JTextField();
		textField_citizenID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_citizenID.setColumns(10);
		textField_citizenID.setBounds(450, 322, 143, 23);
		contentPane.add(textField_citizenID);
	}
}
