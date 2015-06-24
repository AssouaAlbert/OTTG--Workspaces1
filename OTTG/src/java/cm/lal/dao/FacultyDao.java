/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.lal.dao;

import cm.lal.model.Faculty;
import cm.lal.model.Lecture;
import cm.lal.util.DbUtil;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author faculty
 */
public class FacultyDao {

    private Connection conn = null;

    public FacultyDao() {
        conn = DbUtil.getConnection();
    }

    public void addFaculty(Faculty faculty) throws SQLException {
        UserDao user = new UserDao();
        //user.addUser(faculty.getUser());
        PreparedStatement prep = conn.prepareStatement(
                "insert into faculty values (?,?,)");
        prep.setInt(1, faculty.getIdfaculty());
        prep.setString(2, faculty.getFacultyname());
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void deleteFaculty(int facultyid) throws SQLException {
        String queryString = "delete * from faculty where idfaculty=?";
        PreparedStatement prep = conn.prepareStatement(queryString);
        prep.setInt(1, facultyid);

        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void updateFaculty(Faculty faculty) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update faculty set idfaculty=?, facultyname=?,"
                            + "where idfaculty=?");
// Parameters start with 1
            preparedStatement.setInt(1, faculty.getIdfaculty());
            preparedStatement.setString(2, faculty.getFacultyname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Lecture> getAllLecturesInFac(Faculty fac) throws SQLException {
        List<Lecture> lecs = new ArrayList<>();
        Statement stat = (Statement) conn.createStatement();
        String queryString ;
        if (fac.getIdfaculty() == null) {

            queryString = "select * from lecture     inner join lecturer on"
                    + " lecturer.user_iduser=lecture.lecturer_user_iduser inner join"
                    + " lecturer_belongs_to_department on lecturer.user_iduser="
                    + "lecturer_belongs_to_department.lecturer_user_iduser inner join"
                    + " department on department.department_id="
                    + "lecturer.user_iduser inner join faculty on faculty.idfaculty="
                    + "department.faculty_idfaculty"
                    + " where faculty.facultyname=" + fac.getFacultyname();
        } else {

            queryString = "select * from lecture     inner join lecturer on"
                    + " lecturer.user_iduser=lecture.lecturer_user_iduser inner join"
                    + " lecturer_belongs_to_department on lecturer.user_iduser="
                    + "lecturer_belongs_to_department.lecturer_user_iduser inner join"
                    + " department on department.department_id="
                    + "lecturer.user_iduser inner join faculty on faculty.idfaculty="
                    + "department.faculty_idfaculty"
                    + " where faculty.idfaculty=" + fac.getIdfaculty();
        }

        ResultSet rs = stat.executeQuery(queryString);
        while (rs.next()) {
            Lecture lec = new Lecture();
            lec.setIdlecture(rs.getInt("idlecture"));
            lec.setLectureDay(rs.getInt("lecture_day"));
            lec.setStartTime(rs.getInt("start_time"));
            lec.setStopTime(rs.getInt("stop_time"));
            lec.setcTPLICcourseCode("course_takes_place_in_classroom_course_course_code");
            lec.setcTPLICidClassroom("course_takes_place_in_classroom_classroom_idclassroom");
            lec.setTimetableIdtimetable(rs.getInt("timetable_idtimetable"));
            lec.setLecturerUserIduser(rs.getInt("lecturer_user_iduser"));
            lecs.add(lec);
            System.out.println(lec.toString());
        }
        return lecs;
    }

//    public List<User> getAllUsers() {
//        List<User> facultys = new ArrayList();
//        try {
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("select * from facultys");
//            while (rs.next()) {
//                User faculty = new User();
//                faculty.setIdfaculty(rs.getInt("idfaculty"));
//                faculty.setFirstname(rs.getString("firstname"));
//                faculty.setLastname(rs.getString("lastname"));
//                faculty.setMiddlename(rs.getString("middlename"));
//                faculty.setDateOfBirth(rs.getLong("date_of_birth"));
//                faculty.setGender(rs.getString("gender"));
//                faculty.setPassword(rs.getString("password"));
//                facultys.add(faculty);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return facultys;
//    }
}
