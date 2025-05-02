package BLL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.StudentDAO;
import DTO.StudentDTO;

public class StudentBLL {
    private StudentDAO studentDAO;

    public StudentBLL() {
        studentDAO = new StudentDAO();
    }

    public boolean isValidID(String id) {
        return id != null && id.length() == 10;
    }

    public boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.length() == 10;
    }

    public boolean isValidCitizenID(String citizenID) {
        return citizenID != null && citizenID.matches("\\d{12}");
    }

    public boolean isValidConductScore(int conductScore) {
        return conductScore >= 0 && conductScore <= 100;
    }

    public boolean isValidAcademicScore(float academicScore) {
        return academicScore >= 0 && academicScore <= 10;
    }

    public boolean isValidClassID(String classID) {
        return classID != null && !classID.trim().isEmpty();
    }

    public boolean isValidProvinceId(int provinceId) {
        return provinceId > 0;
    }

    public boolean isValidDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth == null) {
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            String dateStr = sdf.format(dateOfBirth);
            sdf.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidStudent(StudentDTO student) {
        return isValidID(student.getID()) &&
               isValidName(student.getName()) &&
               isValidPhoneNumber(student.getPhoneNumber()) &&
               isValidCitizenID(student.getCitizenID()) &&
               isValidConductScore(student.getConductScore()) &&
               isValidAcademicScore(student.getAcademicScore()) &&
               isValidClassID(student.getClassID()) &&
               isValidProvinceId(student.getProvince_id()) &&
               isValidDateOfBirth(student.getDateOfBirth());
    }

    public boolean addStudent(StudentDTO student) {
        if (!isValidStudent(student)) {
            return false;
        }

        for (StudentDTO s : studentDAO.getAllStudents()) {
            if (s.getID().equals(student.getID())) {
                return false;
            }
        }

        return studentDAO.add(student);
    }

    public boolean updateStudent(StudentDTO student) {
        if (!isValidStudent(student)) {
            return false;
        }

        boolean exists = false;
        for (StudentDTO s : studentDAO.getAllStudents()) {
            if (s.getID().equals(student.getID())) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            return false;
        }

        return studentDAO.update(student);
    }

    public boolean deleteStudent(String id) {
        if (!isValidID(id)) {
            return false;
        }

        return studentDAO.delete(id);
    }

    public ArrayList<StudentDTO> findStudentByName(String name) {
        if (!isValidName(name)) {
            return new ArrayList<>();
        }

        return studentDAO.findByName(name);
    }

    public ArrayList<StudentDTO> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}