package DTO;

public class ClassDTO {
    private String classID;
    private String lecturerName;
    private int studentCount;
    private String facultyName;

    public ClassDTO(String classID, String lecturerName, int studentCount, String facultyName) {
        this.classID = classID;
        this.lecturerName = lecturerName;
        this.studentCount = studentCount;
        this.facultyName = facultyName;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "ClassDTO [classID=" + classID + ", lecturerName=" + lecturerName + 
               ", studentCount=" + studentCount + ", facultyName=" + facultyName + "]";
    }
}