package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.StudentDTO;

public class StudentDAO {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/studentmanager?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }

    public ArrayList<StudentDTO> getAllStudents() {
        ArrayList<StudentDTO> list = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {
            while (rs.next()) {
                StudentDTO s = new StudentDTO(
                        rs.getString("ID"),
                        rs.getInt("Conduct_Score"),
                        rs.getString("Name"),
                        rs.getString("Class_ID"),
                        rs.getInt("Province_id"),
                        rs.getDate("Date_Of_Birth"),
                        rs.getBoolean("Gender"),
                        rs.getFloat("Academic_Score"),
                        rs.getString("Citizen_ID"),
                        rs.getString("Phone_number")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean add(StudentDTO st) {
        String sql = "INSERT INTO student (ID, Name, Phone_number, Citizen_ID, Province_id, Date_Of_Birth, Gender, Conduct_Score, Academic_Score, Class_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, st.getID());
            pstmt.setString(2, st.getName());
            pstmt.setString(3, st.getPhoneNumber());
            pstmt.setString(4, st.getCitizenID());
            pstmt.setInt(5, st.getProvince_id());
            pstmt.setDate(6, new Date(st.getDateOfBirth().getTime()));
            pstmt.setBoolean(7, st.isGender());
            pstmt.setInt(8, st.getConductScore());
            pstmt.setFloat(9, st.getAcademicScore());
            pstmt.setString(10, st.getClassID());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(StudentDTO st) {
        String sql = "UPDATE student SET Name = ?, Phone_number = ?, Citizen_ID = ?, Province_id = ?, Date_Of_Birth = ?, Gender = ?, Academic_Score = ?, Conduct_Score = ?, Class_ID = ? WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, st.getName());
            pstmt.setString(2, st.getPhoneNumber());
            pstmt.setString(3, st.getCitizenID());
            pstmt.setInt(4, st.getProvince_id());
            pstmt.setDate(5, new java.sql.Date(st.getDateOfBirth().getTime()));
            pstmt.setBoolean(6, st.isGender());
            pstmt.setFloat(7, st.getAcademicScore());
            pstmt.setInt(8, st.getConductScore());
            pstmt.setString(9, st.getClassID());
            pstmt.setString(10, st.getID());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM student WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<StudentDTO> findByName(String name) {
        ArrayList<StudentDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM student WHERE Name LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentDTO s = new StudentDTO(
                        rs.getString("ID"),
                        rs.getInt("Conduct_Score"),
                        rs.getString("Name"),
                        rs.getString("Class_ID"),
                        rs.getInt("Province_id"),
                        rs.getDate("Date_Of_Birth"),
                        rs.getBoolean("Gender"),
                        rs.getFloat("Academic_Score"),
                        rs.getString("Citizen_ID"),
                        rs.getString("Phone_number")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}