/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.dao;

import cm.lal.model.Faculty;
import cm.lal.model.User;
import cm.lal.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                    .prepareStatement("update faculty set idfaculty=?, facultyname=?,"+
                            "where idfaculty=?");
// Parameters start with 1
            preparedStatement.setInt(1, faculty.getIdfaculty());
            preparedStatement.setString(2, faculty.getFacultyname());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
