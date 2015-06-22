/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.dao;

import cm.lal.model.Lecturer;
import cm.lal.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class LecturerDao {
    
    private Connection conn = null;

    public LecturerDao() {
        conn = DbUtil.getConnection();
    }

    public void addLecturer(Lecturer lec) throws SQLException {
        PreparedStatement prep = conn.prepareStatement(
                "insert into lecturer values (?,?)");
        // insert parameter values starting with 1
        prep.setString(1, lec.getTypePartOrFull());
        prep.setInt(2, lec.getUser_iduser());
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void deleteLecturer(int idLecturer) throws SQLException {
        PreparedStatement prep = conn.prepareStatement(
                "delete from lecturer where user_iduser=?");

        prep.setInt(1, idLecturer);
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void updateLecturer(Lecturer lec) throws SQLException {
        PreparedStatement prep = conn.prepareStatement(
                "update lecturer set type(part or full)=? where "
                + "user_iduser=?");

        prep.setString(1, lec.getTypePartOrFull());
        prep.setInt(2, lec.getUser_iduser());
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public Lecturer getLecturerById(int idLec) {
        Lecturer lecturer = new Lecturer();
        String queryString = "select * from lecturer where user_iduser=" + idLec;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(queryString);
            if (rs.next()) {
                lecturer.setTypePartOrFull(rs.getString("type(part or full)"));
                lecturer.setUser_iduser(rs.getInt("user_iduser"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecturer;
    }
    
    public List<Lecturer> getAllLecturers() {
        List<Lecturer> lecs = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from classroom");
            while (rs.next()) {
                Classroom classroom = new Classroom();
                classroom.setIdclassroom(rs.getString("idclassroom"));
                classroom.setRoomLocation(rs.getString("room_location"));
                classroom.setCapacity(rs.getInt("capacity"));
                classes.add(classroom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
}
