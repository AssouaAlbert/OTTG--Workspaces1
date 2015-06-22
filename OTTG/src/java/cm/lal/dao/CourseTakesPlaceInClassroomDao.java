/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.lal.dao;

import cm.lal.model.CourseTakesPlaceInClassroom;
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
public class CourseTakesPlaceInClassroomDao {

    Connection conn = null;

    public CourseTakesPlaceInClassroomDao() {
        conn = DbUtil.getConnection();
    }

    public void addCourseTakesPlace(CourseTakesPlaceInClassroom ctpic) throws SQLException {
        //UserDao user = new UserDao();
        //user.addUser(headdept.getUser());

        PreparedStatement prep = conn.prepareStatement(
                "insert into course_takes_place_in_classroom values (?, ?)");
        prep.setString(1, ctpic.getCourseCourseCode());
        prep.setString(2, ctpic.getClassroomIdclassroom());
        prep.executeUpdate();
    }
    
    public List<CourseTakesPlaceInClassroom> getCourseTakesPlaceByCourseId(String courseCode) 
            throws SQLException {
        List<CourseTakesPlaceInClassroom> ctpic = new ArrayList<>();
        Statement stat ;
        String queryString = "select * from course_takes_place_in_classroom"
                + " where course_course_code='" + courseCode + "'";
        System.out.println(queryString);
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(queryString);
        
        while (rs.next()) {            
            CourseTakesPlaceInClassroom ctpic1 = new CourseTakesPlaceInClassroom();
            ctpic1.setClassroomIdclassroom(rs.getString("classroom_idclassroom"));
            ctpic1.setCourseCourseCode(rs.getString("course_course_code"));
            ctpic.add(ctpic1);
        }
        return ctpic;
    }
    
    public List<CourseTakesPlaceInClassroom> getCourseTakesPlaceByClassId(String idclassroom)
            throws SQLException {
        List<CourseTakesPlaceInClassroom> ctpic = new ArrayList<>();
        Statement stat;
        String queryString = "select * from course_takes_place_in_classroom"
                + " where classroom_idclassroom='" + idclassroom + "'";
        System.out.println(queryString);
        stat = conn.createStatement();
        ResultSet res = stat.executeQuery(queryString);
        
        while (res.next()) {            
            CourseTakesPlaceInClassroom ctpic1 = new CourseTakesPlaceInClassroom();
            ctpic1.setClassroomIdclassroom(res.getString("classroom_idclassroom"));
            ctpic1.setCourseCourseCode(res.getString("course_course_code"));
            ctpic.add(ctpic1);
        }
        return ctpic;
    }
    
    public CourseTakesPlaceInClassroom getCourseTakesPlaceId(
            String idClassroom, String idCourse) throws SQLException {
        CourseTakesPlaceInClassroom ctpic = new CourseTakesPlaceInClassroom();
        Statement stat;
        String queryString = "select * from course_takes_place_in_classroom where "
                + "classroom_idclassroom='" + idClassroom + "' and "
                + "course_course_code='" + idCourse + "'";
        System.out.println(queryString);
        stat = conn.createStatement();
        ResultSet res = stat.executeQuery(queryString);
        
        while (res.next()) {            
            ctpic.setClassroomIdclassroom(res.getString("classroom_idclassroom"));
            ctpic.setCourseCourseCode(res.getString("course_course_code"));
        }
        return ctpic;
    }
    
    public List<CourseTakesPlaceInClassroom> getAllCoursesClassroomsId()
            throws SQLException {
        List<CourseTakesPlaceInClassroom> ctpic = new ArrayList<>();
        Statement stat;
        String queryString = "select * from course_takes_place_in_classroom";
        System.out.println(queryString);
        stat = conn.createStatement();
        ResultSet res = stat.executeQuery(queryString);
        
        while (res.next()) {
            CourseTakesPlaceInClassroom ctpic1 = new CourseTakesPlaceInClassroom();
            ctpic1.setClassroomIdclassroom(res.getString("classroom_idclassroom"));
            ctpic1.setCourseCourseCode(res.getString("course_course_code"));
            ctpic.add(ctpic1);
        }
        return ctpic;
    }
    
}
