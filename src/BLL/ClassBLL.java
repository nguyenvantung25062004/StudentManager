package BLL;

import java.util.ArrayList;
import DAO.ClassDAO;
import DTO.ClassDTO;

public class ClassBLL {
    private ClassDAO classDAO;

    public ClassBLL() {
        classDAO = new ClassDAO();
    }

    public boolean isValidClassID(String classID) {
        return classID != null && !classID.trim().isEmpty() && classID.length() <= 10;
    }

    public boolean isValidLecturerName(String lecturerName) {
        return lecturerName != null && !lecturerName.trim().isEmpty();
    }

    public boolean isValidStudentCount(int studentCount) {
        return studentCount >= 0;
    }

    public boolean isValidFacultyName(String facultyName) {
        return facultyName != null && !facultyName.trim().isEmpty();
    }

    private boolean isValidClass(ClassDTO classDTO) {
        return isValidClassID(classDTO.getClassID()) &&
               isValidLecturerName(classDTO.getLecturerName()) &&
               isValidStudentCount(classDTO.getStudentCount()) &&
               isValidFacultyName(classDTO.getFacultyName());
    }

    public boolean addClass(ClassDTO classDTO) {
        if (!isValidClass(classDTO)) {
            return false;
        }

        for (ClassDTO c : classDAO.getAllClasses()) {
            if (c.getClassID().equals(classDTO.getClassID())) {
                return false;
            }
        }

        return classDAO.add(classDTO);
    }

    public boolean updateClass(ClassDTO classDTO) {
        if (!isValidClass(classDTO)) {
            return false;
        }

        boolean exists = false;
        for (ClassDTO c : classDAO.getAllClasses()) {
            if (c.getClassID().equals(classDTO.getClassID())) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            return false;
        }

        return classDAO.update(classDTO);
    }

    public boolean deleteClass(String classID) {
        if (!isValidClassID(classID)) {
            return false;
        }

        return classDAO.delete(classID);
    }

    public ArrayList<ClassDTO> searchClasses(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return getAllClasses();
        }
        
        keyword = keyword.toLowerCase().trim();
        ArrayList<ClassDTO> allClasses = classDAO.getAllClasses();
        ArrayList<ClassDTO> result = new ArrayList<>();
        
        for (ClassDTO classDTO : allClasses) {
            if (classDTO.getClassID().toLowerCase().startsWith(keyword) ||
                classDTO.getLecturerName().toLowerCase().startsWith(keyword) ||
                String.valueOf(classDTO.getStudentCount()).startsWith(keyword) ||
                classDTO.getFacultyName().toLowerCase().startsWith(keyword)) {
                result.add(classDTO);
            }
        }
        
        return result;
    }

    public ArrayList<ClassDTO> getAllClasses() {
        return classDAO.getAllClasses();
    }
}