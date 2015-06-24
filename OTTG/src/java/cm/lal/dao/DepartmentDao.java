/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.dao;

import cm.lal.model.Department;
import cm.lal.model.Lecture;
import cm.lal.util.DbUtil;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DepartmentDao {
    
    private Connection conn = null;

    public DepartmentDao() {
        conn = DbUtil.getConnection();
    }

    public List<Lecture> getAllLecturesByDept (Department depp) throws SQLException {
        List<Lecture> lecs = new ArrayList<>();
        Statement stat = (Statement) conn.createStatement();
        String queryString ;
        System.out.println("\n" + depp.toString());
        if (depp.getDepartmentId() == null) {

            queryString = "select * from lecture     inner join lecturer on"
                    + " lecturer.user_iduser=lecture.lecturer_user_iduser inner join"
                    + " lecturer_belongs_to_department on lecturer.user_iduser="
                    + "lecturer_belongs_to_department.lecturer_user_iduser inner join"
                    + " department on department.department_id=lecturer_belongs_to_department"
                    + ".department_department_id where department.department_name="
                    + "'" + depp.getDepartmntName() + "'";
            System.out.println(queryString);
        } else {

            queryString = "select * from lecture     inner join lecturer on"
                    + " lecturer.user_iduser=lecture.lecturer_user_iduser inner join"
                    + " lecturer_belongs_to_department on lecturer.user_iduser="
                    + "lecturer_belongs_to_department.lecturer_user_iduser inner join"
                    + " department on department.department_id=lecturer_belongs_to_department"
                    + ".department_department_id where department.department_id="
                    + "'" + depp.getDepartmentId()+ "'";
            System.out.println(queryString);
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
        }
        return lecs;
    }
}
