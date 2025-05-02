package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.StudentBLL;
import DTO.ProvinceDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testGUIClassManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_lecturer;
	public JTextField textField_faculty;
	public JTextField textField_find;
	public JButton btn_add, btn_delete, btn_update, btn_cancel, btn_find;
	private DefaultTableModel tableModel;
	private JTextField textField_count;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testGUIClassManager frame = new testGUIClassManager();
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
	public testGUIClassManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		
		JLabel label_classesList = new JLabel("Classes List");
		label_classesList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_classesList.setBounds(10, 45, 163, 23);
		contentPane.add(label_classesList);
		
		tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Student Count", "Leturer", "Faculty"}
        );
		
//		table = new JTable();
//		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		table.setModel(tableModel);
//		
//		table.getTableHeader().setBackground(Color.BLACK);
//		table.getTableHeader().setForeground(Color.WHITE);
		
		table = new JTable(tableModel);
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        table.getColumnModel().getColumn(0).setPreferredWidth(100); 
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(120); 
        table.getColumnModel().getColumn(3).setPreferredWidth(180);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(Color.WHITE);
        

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 68, 600, 150);
        contentPane.add(scrollPane);


//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(10, 68, 521, 114);
//		contentPane.add(scrollPane);
		
		JLabel label_classInfo = new JLabel("Class Infomation");
		label_classInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_classInfo.setBounds(10, 186, 179, 23);
		contentPane.add(label_classInfo);
		
		JLabel label_ID = new JLabel("ID");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_ID.setBounds(10, 229, 93, 23);
		contentPane.add(label_ID);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ID.setColumns(10);
		textField_ID.setBounds(139, 229, 163, 23);
		contentPane.add(textField_ID);
		
		JLabel label_lecturer = new JLabel("Lecturer Name");
		label_lecturer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_lecturer.setBounds(10, 263, 119, 23);
		contentPane.add(label_lecturer);
		
		textField_lecturer = new JTextField();
		textField_lecturer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_lecturer.setColumns(10);
		textField_lecturer.setBounds(139, 263, 163, 23);
		contentPane.add(textField_lecturer);
		
		JLabel label_count = new JLabel("Count");
		label_count.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_count.setBounds(345, 230, 71, 23);
		contentPane.add(label_count);
		
		
		JLabel label_faculty = new JLabel("Faculty");
		label_faculty.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_faculty.setBounds(345, 264, 71, 23);
		contentPane.add(label_faculty);
		
		textField_count = new JTextField();
		textField_count.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_count.setColumns(10);
		textField_count.setBounds(441, 229, 169, 23);
		contentPane.add(textField_count);
		
		textField_faculty = new JTextField();
		textField_faculty.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_faculty.setColumns(10);
		textField_faculty.setBounds(441, 263, 169, 23);
		contentPane.add(textField_faculty);
		
		btn_add = new JButton("Add");
		btn_add.setBackground(new Color(0, 128, 192));
		btn_add.setForeground(new Color(255, 255, 255));
		btn_add.setBounds(103, 310, 89, 23);
		contentPane.add(btn_add);
		
		btn_delete = new JButton("Delete");
		btn_delete.setBackground(new Color(255, 128, 128));
		btn_delete.setForeground(new Color(255, 255, 255));
		btn_delete.setBounds(214, 310, 89, 23);
		contentPane.add(btn_delete);
		
		btn_update = new JButton("Update");
		btn_update.setBackground(new Color(128, 255, 128));
		btn_update.setForeground(new Color(255, 255, 255));
		btn_update.setBounds(323, 310, 89, 23);
		contentPane.add(btn_update);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setBackground(new Color(255, 128, 64));
		btn_cancel.setForeground(new Color(255, 255, 255));
		btn_cancel.setBounds(435, 310, 89, 23);
		contentPane.add(btn_cancel);
		
		textField_find = new JTextField();
		textField_find.setBounds(366, 12, 136, 20);
		contentPane.add(textField_find);
		textField_find.setColumns(10);
		
		btn_find = new JButton("Find");
		btn_find.setBackground(new Color(0, 128, 255));
		btn_find.setForeground(new Color(255, 255, 255));
		btn_find.setBounds(526, 11, 89, 23);
		contentPane.add(btn_find);

		setContentPane(contentPane);
	}

}
