package test;

import java.util.ArrayList;

import DAO.StudentDAO;
import DTO.StudentDTO;

public class test {
	public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        ArrayList<StudentDTO> list = dao.getAllStudents();
        System.out.println("Số lượng sinh viên trong DB: " + list.size());

        for (StudentDTO s : dao.getAllStudents()) {
            System.out.println(s.toString());
        }
    }
}
