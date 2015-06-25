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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class LectureDao {

    Connection conn = null;
    
    public LectureDao() {
        conn = DbUtil.getConnection();
    }
    
    
    
    public List<Lecture> getAllLectures() throws SQLException {
        List<Lecture> lecs = new ArrayList<>();
        Statement stat;
        String queryString = 
                "select * from lecture";
        System.out.println(queryString);
        stat = conn.createStatement();
        ResultSet res = stat.executeQuery(queryString);
        
        while (res.next()) { 
            Lecture lec = new Lecture();
            lec.setIdlecture(res.getInt("idlecture"));
            lec.setLectureDay(res.getInt("lecture_day"));
            lec.setStartTime(res.getInt("start_time"));
            lec.setStopTime(res.getInt("stop_time"));
            lec.setcTPLICcourseCode("course_takes_place_in_classroom_course_code");
            lec.setcTPLICidClassroom("course_takes_place_in_classroom_classroom_idclassroom");
            lec.setTimetableIdtimetable(res.getInt("timetable_idtimetable"));
            lec.setLecturerUserIduser(res.getInt("lecturer_user_iduser"));
            lecs.add(lec);
        }
        return lecs;
    }
    
    public Lecture getLecture(int idlecture) throws SQLException {
        Lecture lec = new Lecture();
        Statement stat;
        String queryString = 
                "select * from lecture where idlecture=" + idlecture + "";
        System.out.println(queryString);
        stat = conn.createStatement();
        ResultSet res = stat.executeQuery(queryString);
        
        while (res.next()) {            
            lec.setIdlecture(res.getInt("idlecture"));
            lec.setLectureDay(res.getInt("lecture_day"));
            lec.setStartTime(res.getInt("start_time"));
            lec.setStopTime(res.getInt("stop_time"));
            lec.setcTPLICcourseCode("course_takes_place_in_classroom_course_code");
            lec.setcTPLICidClassroom("course_takes_place_in_classroom_classroom_idclassroom");
            lec.setTimetableIdtimetable(res.getInt("timetable_idtimetable"));
            lec.setLecturerUserIduser(res.getInt("lecturer_user_iduser"));
        }
        return lec;
    }
    
    public List<Lecture> getLecturesByDay(int lecday) throws SQLException {
        List<Lecture> lecs = new ArrayList<>();
        Statement stat;
        String queryString = 
                "select * from lecture where lecture_day=" + lecday + "";
        System.out.println(queryString);
        stat = conn.createStatement();
        ResultSet res = stat.executeQuery(queryString);
        
        while (res.next()) { 
            Lecture lec = new Lecture();
            lec.setIdlecture(res.getInt("idlecture"));
            lec.setLectureDay(res.getInt("lecture_day"));
            lec.setStartTime(res.getInt("start_time"));
            lec.setStopTime(res.getInt("stop_time"));
            lec.setcTPLICcourseCode("course_takes_place_in_classroom_course_code");
            lec.setcTPLICidClassroom("course_takes_place_in_classroom_classroom_idclassroom");
            lec.setTimetableIdtimetable(res.getInt("timetable_idtimetable"));
            lec.setLecturerUserIduser(res.getInt("lecturer_user_iduser"));
            lecs.add(lec);
        }
        return lecs;
    }
    
    public List<Lecture> getLecturesByLecturer(int idlecturer) throws SQLException {
        List<Lecture> lecs = new ArrayList<>();
        Statement stat;
        String queryString = 
                "select * from lecture where lecturer_user_iduser=" + idlecturer + "";
        System.out.println(queryString);
        stat = conn.createStatement();
        ResultSet res = stat.executeQuery(queryString);
        
        while (res.next()) {
            Lecture lec = new Lecture();
            lec.setIdlecture(res.getInt("idlecture"));
            lec.setLectureDay(res.getInt("lecture_day"));
            lec.setStartTime(res.getInt("start_time"));
            lec.setStopTime(res.getInt("stop_time"));
            lec.setcTPLICcourseCode(res.getString("course_takes_place_in_classroom_course_code"));
            lec.setcTPLICidClassroom(res.getString("course_takes_place_in_classroom_classroom_idclassroom"));
            lec.setTimetableIdtimetable(res.getInt("timetable_idtimetable"));
            lec.setLecturerUserIduser(res.getInt("lecturer_user_iduser"));
            lecs.add(lec);
        }
        return lecs;
    }
    
    public void addLecture(Lecture lecture) throws SQLException {
        CourseTakesPlaceInClassroomDao ctpicd = new CourseTakesPlaceInClassroomDao();
        // persist using a persistence add method
        try {
            Statement stat = null;
            String insertString = "insert into lecture(lecture_day,start_time,stop_time,"
                    + "course_takes_place_in_classroom_course_course_code,"
                    + "course_takes_place_in_classroom_classroom_idclassroom,"
                    + "timetable_idtimetable, lecturer_user_iduser) values("
                    + lecture.getLectureDay()+ ", " + lecture.getStartTime()+ ", " + lecture.getStopTime()
                    + ", '" + lecture.getCourseTakesPlaceInClassroom().getCourseCourseCode()+ "', '" 
                    + lecture.getCourseTakesPlaceInClassroom().getClassroomIdclassroom() + "', " 
                    + lecture.getTimetableIdtimetable()+ ")";
            System.out.println(insertString);
            stat = conn.createStatement();
            stat.executeUpdate(insertString);

        } catch (SQLException ex) {
            Logger.getLogger(LectureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
