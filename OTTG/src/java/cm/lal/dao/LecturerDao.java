/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.dao;

import cm.lal.model.Lecture;
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
            ResultSet rs = statement.executeQuery("select * from lecturer");
            while (rs.next()) {
                Lecturer lec = new Lecturer();
                lec.setUser_iduser(rs.getInt("idclassroom"));
                lec.setDepartment_department_id(rs.getInt("department_department_id"));
                lec.setTypePartOrFull(rs.getString("type(part or full)"));
                lecs.add(lec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lecs;
    }
    
    public List<Lecture> getAllLecturesByLecturer (Lecturer lecturer) throws SQLException {
        List<Lecture> lecs = new ArrayList<>();
        com.mysql.jdbc.Statement stat = (com.mysql.jdbc.Statement) conn.createStatement();
        String queryString ;
        
        queryString = "select * from lecture inner join lecturer on"
                + " lecturer.user_iduser=lecture.lecturer_user_iduser"
                + " where lecturer.user_iduser=" + lecturer.getUser_iduser();
        
        ResultSet rs = stat.executeQuery(queryString);
        while (rs.next()) {
            Lecture lecture = new Lecture();
            lecture.setIdlecture(rs.getInt("idlecture"));
            lecture.setLectureDay(rs.getInt("lecture_day"));
            lecture.setStartTime(rs.getInt("start_time"));
            lecture.setStopTime(rs.getInt("stop_time"));
            lecture.setcTPLICcourseCode(rs.getString("course_takes_place_in_classroom_course_course_code"));
            lecture.setcTPLICidClassroom(rs.getString("course_takes_place_in_classroom_classroom_idclassroom"));
            lecture.setTimetableIdtimetable(rs.getInt("timetable_idtimetable"));
            lecture.setLecturerUserIduser(rs.getInt("lecturer_user_iduser"));
            lecs.add(lecture);
            System.out.println(lecture.toString());
        }
        return lecs;
    }
}
