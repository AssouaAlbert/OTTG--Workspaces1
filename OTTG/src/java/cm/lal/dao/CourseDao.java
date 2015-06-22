/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.dao;

import cm.lal.model.Classroom;
import cm.lal.model.Course;
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
public class CourseDao {
    
    Connection conn = null;

    public CourseDao() {
        conn = DbUtil.getConnection();
    }
    
    public void addCourse(Course course) throws SQLException {
        PreparedStatement prep = conn.prepareStatement(
                "insert into course values (?,?)");
        // insert parameter values starting with 1
        prep.setString(1, course.getCourseCode());
        prep.setString(2, course.getCourseName());
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void deleteCourse(String courseID) throws SQLException {
        PreparedStatement prep = conn.prepareStatement(
                "delete from course where course_code=?");

        prep.setString(1, courseID);
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void updateCourse(Course course) throws SQLException {
        PreparedStatement prep = conn.prepareStatement(
                "update course set course_name=? where "
                + "course_code=?");

        prep.setString(1, course.getCourseName());
        prep.setString(2, course.getCourseCode());
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public Course getCourseById(String idCourse) {
        Course course = new Course();
        String queryString = "select * from course where course_code=" + idCourse;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(queryString);
            if (rs.next()) {
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
    
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from course");
            while (rs.next()) {
                Course course = new Course();
                course.setCourseCode(rs.getString("course_code"));
                course.setCourseName(rs.getString("course_name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    
}
