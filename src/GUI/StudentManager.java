package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.StudentBLL;
import DTO.ProvinceDTO;
import DTO.StudentDTO;

public class StudentManager{
	public JPanel contentPane;
	private JTable table;
	private JTextField textField_ID;
	private JTextField textField_Name;
	private JTextField textField_dateOfBirth;
	private JTextField textField_conductScore;
	private JTextField textField_academicScore;
	private JTextField textField_classID;
	private JComboBox comboBox_homeTown;
	private ButtonGroup btn_gender;
	private JTextField textField_find;
	private StudentBLL studentBLL;
	private JButton btn_add, btn_delete, btn_update, btn_OK, btn_cancel, btn_find;
	private DefaultTableModel tableModel;
	private JTextField textField_phoneNumber;
	private JTextField textField_citizenID;
	
	public StudentManager()
	{
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		
		JLabel label_studentList = new JLabel("Student List");
		label_studentList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_studentList.setBounds(10, 45, 163, 23);
		contentPane.add(label_studentList);
		
		tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Name", "Phone Number", "Citizen ID", "Hometown", "Gender", "Date of birth", "Conduct Score", "Academic Score", "Class ID"}
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
		
		JLabel label_classID = new JLabel("Class ID");
		label_classID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_classID.setBounds(307, 356, 75, 23);
		contentPane.add(label_classID);
		
		textField_classID = new JTextField();
		textField_classID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_classID.setColumns(10);
		textField_classID.setBounds(450, 356, 143, 23);
		contentPane.add(textField_classID);
		
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
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(255, 128, 64));
		btn_cancel.setForeground(new Color(255, 255, 255));
		btn_cancel.setBounds(501, 390, 89, 23);
		contentPane.add(btn_cancel);
		
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
		
		studentBLL = new StudentBLL();
		loadStudents();
		
		btn_add.addActionListener(e->{
			StudentDTO student = getInput();
            if (student != null) {
                if (studentBLL.addStudent(student)) {
                    JOptionPane.showMessageDialog(contentPane, "Done!");
                    loadStudents();
                    clearInput();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Failed to add student! ID already exists or the data is invalid", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
		});
		
		btn_delete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String id = tableModel.getValueAt(selectedRow, 0).toString();
                int confirm = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to delete this student?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (studentBLL.deleteStudent(id)) {
                        JOptionPane.showMessageDialog(contentPane, "Done!");
                        loadStudents();
                        clearInput();
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Failed to delete student!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Please choose student to delete", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btn_update.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                StudentDTO student = getInput();
                if (student != null) {
                    if (studentBLL.updateStudent(student)) {
                        JOptionPane.showMessageDialog(contentPane, "Done!");
                        loadStudents();
                        clearInput();
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Fail to update student", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Please choose student to update!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btn_find.addActionListener(e -> {
        	String keyword = textField_find.getText().trim();
            ArrayList<StudentDTO> searchResult = studentBLL.searchStudents(keyword);
            loadStudents(searchResult);
            if (searchResult.isEmpty() && !keyword.isEmpty()) {
                JOptionPane.showMessageDialog(contentPane, "No matching student found!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        btn_cancel.addActionListener(e->{
        	clearInput();
        	table.clearSelection();
        });
		
		table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && table.getSelectedRow() >= 0) {
                int row = table.getSelectedRow();
                textField_ID.setText(tableModel.getValueAt(row, 0).toString());
                textField_Name.setText(tableModel.getValueAt(row, 1).toString());
                textField_phoneNumber.setText(tableModel.getValueAt(row, 2).toString());
                textField_citizenID.setText(tableModel.getValueAt(row, 3).toString());
                comboBox_homeTown.setSelectedItem(tableModel.getValueAt(row, 4).toString());
                String gender = tableModel.getValueAt(row, 5).toString();
                if (gender.equals("Male")) {
                    radioButton_male.setSelected(true);
                } else if (gender.equals("Female")) {
                    radioButton_female.setSelected(true);
                }
                textField_dateOfBirth.setText(tableModel.getValueAt(row, 6).toString());
                textField_conductScore.setText(tableModel.getValueAt(row, 7).toString());
                textField_academicScore.setText(tableModel.getValueAt(row, 8).toString());
                textField_classID.setText(tableModel.getValueAt(row, 9).toString());
            }
        });
	}
	
	public StudentDTO getInput() {
        String id = textField_ID.getText().trim();
        String name = textField_Name.getText().trim();
        String phone = textField_phoneNumber.getText().trim();
        String citizenID = textField_citizenID.getText().trim();
        String classID = textField_classID.getText().trim();
        String dobText = textField_dateOfBirth.getText().trim();

        if (id.isEmpty() || name.isEmpty() || phone.isEmpty() || citizenID.isEmpty() ||
                classID.isEmpty() || dobText.isEmpty() || textField_academicScore.getText().trim().isEmpty() ||
                textField_conductScore.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(contentPane, "Please enter all required fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!studentBLL.isValidID(id)) {
            JOptionPane.showMessageDialog(contentPane, "ID must be exactly 10 characters!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (!studentBLL.isValidName(name)) {
            JOptionPane.showMessageDialog(contentPane, "Name cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (!studentBLL.isValidPhoneNumber(phone)) {
            JOptionPane.showMessageDialog(contentPane, "Phone number must be 10 digits!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!studentBLL.isValidCitizenID(citizenID)) {
            JOptionPane.showMessageDialog(contentPane, "Citizen ID must be exactly 12 digits!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (!studentBLL.isValidClassID(classID)) {
            JOptionPane.showMessageDialog(contentPane, "Class ID cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int provinceID;
        try {
            provinceID = comboBox_homeTown.getSelectedIndex();
            if (!studentBLL.isValidProvinceId(provinceID))
            	throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contentPane, "Please choose province!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        boolean gender;
        try {
            gender = btn_gender.getSelection().getActionCommand().equals("Male");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contentPane, "Please choose gender!", "Input error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Date sqlDate = null;
        try {
            Date utilDate = new SimpleDateFormat("dd-MM-yyyy").parse(dobText);
            sqlDate = new java.sql.Date(utilDate.getTime());
            if (!studentBLL.isValidDateOfBirth(sqlDate))
            	throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contentPane, "Invalid date format! Please enter the date in dd-mm-yyyy format (e.g., 25-06-2004)", "Input error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        float academic;
        try {
            academic = Float.parseFloat(textField_academicScore.getText().trim());
            if (!studentBLL.isValidAcademicScore(academic))
            	throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contentPane, "Please enter academic score again!", "Input error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int conduct;
        try {
            conduct = Integer.parseInt(textField_conductScore.getText().trim());
            if (!studentBLL.isValidConductScore(conduct))
            	throw new Exception();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contentPane, "Please enter conduct score again!", "Input error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new StudentDTO(id, conduct, name, classID, provinceID, sqlDate, gender, academic, citizenID, phone);
    }
	
	private void loadStudents() {
		loadStudents(studentBLL.getAllStudents());
    }
	
	private void loadStudents(ArrayList<StudentDTO> students) {
        tableModel.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        for (StudentDTO student : students) {
            String provinceName = "";
            for (ProvinceDTO province : ProvinceDTO.getListProvince()) {
                if (province.getID() == student.getProvince_id()) {
                    provinceName = province.getName();
                    break;
                }
            }
            tableModel.addRow(new Object[]{
                    student.getID(),
                    student.getName(),          
                    student.getPhoneNumber(),
                    student.getCitizenID(),
                    provinceName,
                    student.isGender() ? "Male" : "Female",
                    sdf.format(student.getDateOfBirth()),
                    student.getConductScore(),
                    student.getAcademicScore(),
                    student.getClassID()
            });
        }
    }
	
	private void clearInput() {
        textField_ID.setText("");
        textField_Name.setText("");
        textField_dateOfBirth.setText("");
        textField_conductScore.setText("");
        textField_academicScore.setText("");
        textField_classID.setText("");
        textField_phoneNumber.setText("");
        textField_citizenID.setText("");
        comboBox_homeTown.setSelectedIndex(0);
        btn_gender.clearSelection();
    }

}
