package DAO;

import java.sql.*;
import java.util.ArrayList;
import DTO.ClassDTO;

public class ClassDAO {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/studentmanager?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }

    public ArrayList<ClassDTO> getAllClasses() {
        ArrayList<ClassDTO> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM class")) {
            while (rs.next()) {
                ClassDTO c = new ClassDTO(
                        rs.getString("Class_ID"),
                        rs.getString("Lecturer_Name"),
                        rs.getInt("Student_Count"),
                        rs.getString("Faculty_Name")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean add(ClassDTO c) {
        String sql = "INSERT INTO class (Class_ID, Lecturer_Name, Student_Count, Faculty_Name) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getClassID());
            pstmt.setString(2, c.getLecturerName());
            pstmt.setInt(3, c.getStudentCount());
            pstmt.setString(4, c.getFacultyName());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(ClassDTO c) {
        String sql = "UPDATE class SET Lecturer_Name = ?, Student_Count = ?, Faculty_Name = ? WHERE Class_ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, c.getLecturerName());
            pstmt.setInt(2, c.getStudentCount());
            pstmt.setString(3, c.getFacultyName());
            pstmt.setString(4, c.getClassID());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String classID) {
        String sql = "DELETE FROM class WHERE Class_ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, classID);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ClassDTO> findByName(String lecturerName) {
        ArrayList<ClassDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM class WHERE Lecturer_Name LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + lecturerName + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ClassDTO c = new ClassDTO(
                        rs.getString("Class_ID"),
                        rs.getString("Lecturer_Name"),
                        rs.getInt("Student_Count"),
                        rs.getString("Faculty_Name")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}