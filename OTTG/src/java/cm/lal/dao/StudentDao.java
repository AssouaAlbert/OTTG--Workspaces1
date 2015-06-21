/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.dao;

import cm.lal.model.Student;
import cm.lal.model.User;
import cm.lal.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author student
 */
public class StudentDao {
    
    
    private Connection conn = null;

    public StudentDao() {
        conn = DbUtil.getConnection();
    }

    public void addStudent(Student student) throws SQLException {
        UserDao user = new UserDao();
        user.addUser(student.getUser());
        PreparedStatement prep = conn.prepareStatement(
        "insert into student values (?,?,?,?)");
        prep.setInt(1, student.getAccesslevel());
        prep.setString(2, student.getTypeGradUndergrad());
        prep.setInt(3, student.getUser().getIduser());
        prep.setInt(4,student.getDepartmentDepartmentId().getDepartmentId());
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void deleteStudent(int studentid) throws SQLException {
        String queryString = "delete * from student where id=?";
        PreparedStatement prep = conn.prepareStatement(queryString);
        prep.setInt(1, studentid);

        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void updateStudent(Student student) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update student set accesslevel=?, type(grad undergrad)=?,"+
                            " department_department_id=? where studentid=?");
// Parameters start with 1
            UserDao user = new UserDao();
            preparedStatement.setInt(1, student.getAccesslevel());
            preparedStatement.setString(2, student.getTypeGradUndergrad());
            preparedStatement.setInt(3, student.getDepartmentDepartmentId().getDepartmentId());
            preparedStatement.setInt(4, student.getUser().getIduser());
            preparedStatement.executeUpdate();
            user.updateUser(student.getUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyIdentity(String uName, String password) throws SQLException {
        boolean value = false;

        String query = "select * from student where firstname=? and password=?";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, uName);
        prep.setString(2, password);
        ResultSet returnResultSet = prep.executeQuery();
        int i = 0;
        while (returnResultSet.next()) {
            i++;
        }
        if (i == 1) {
            value = true;
        }
        return value;
    }

//    public List<User> getAllUsers() {
//        List<User> students = new ArrayList();
//        try {
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("select * from students");
//            while (rs.next()) {
//                User student = new User();
//                student.setIdstudent(rs.getInt("idstudent"));
//                student.setFirstname(rs.getString("firstname"));
//                student.setLastname(rs.getString("lastname"));
//                student.setMiddlename(rs.getString("middlename"));
//                student.setDateOfBirth(rs.getLong("date_of_birth"));
//                student.setGender(rs.getString("gender"));
//                student.setPassword(rs.getString("password"));
//                students.add(student);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return students;
//    }

    public Student getStudentById(int studentId) {
        Student student = new Student();
        String queryString = "select * from student where user_userid=" + studentId;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(queryString);
            if (rs.next()) {
                student.setAccesslevel(rs.getInt("accesslevel"));
                student.setTypeGradUndergrad(rs.getString("type(grad underegrad)"));
                //student.setu(rs.getString("lastname")); logic to set user
                //student.setDepartmentDepartmentId(rs.getString("middlename")); logic to set department
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
