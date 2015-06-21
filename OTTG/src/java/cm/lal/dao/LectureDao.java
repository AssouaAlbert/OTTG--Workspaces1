/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.dao;

import cm.lal.model.Lecture;
import cm.lal.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class LectureDao {

    Connection conn = null;
    
    public LectureDao() {
        conn = DbUtil.getConnection();
    }
    
    public void addLecture(Lecture lecture) throws SQLException {
        CourseTakesPlaceInClassroomDao ctpicd = new CourseTakesPlaceInClassroomDao();
        // persist using a persistence add method
        
        PreparedStatement prep = conn.prepareStatement(
                "insert into lecture(lecture_day=?, start_time=?, stop_time=?,"
                        + "course_takes_place_in_classroom_course_course_code=?,"
                        + "course_takes_place_in_classroom_classroom_idclassroom=?,"
                        + "timetable_idtimetable=?");//, lecturer_user_iduser=?");
        System.out.println(lecture.getLectureDay());
        prep.setInt(1, lecture.getLectureDay());
        prep.setInt(2, lecture.getStartTime());
        prep.setInt(3, lecture.getStopTime());
        prep.setString(4, lecture.getCourseTakesPlaceInClassroom().getCourseCourseCode());
        prep.setString(5, lecture.getCourseTakesPlaceInClassroom().getClassroomIdclassroom());
        prep.setInt(6, lecture.getTimetableIdtimetable());
//        prep.setInt(7, lecture.getLecturer().getUser().getIduser());
        prep.executeUpdate();
        ctpicd.addCourseTakesPlace(lecture.getCourseTakesPlaceInClassroom());
    }
}
