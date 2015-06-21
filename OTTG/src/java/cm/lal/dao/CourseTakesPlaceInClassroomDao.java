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
import java.sql.SQLException;

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
}
