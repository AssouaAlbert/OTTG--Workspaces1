/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.dao;

import cm.lal.model.HeadDept;
import cm.lal.model.User;
import cm.lal.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author headdept
 */
public class HeadDeptDao {
    
    
    private Connection conn = null;

    public HeadDeptDao() {
        conn = DbUtil.getConnection();
    }

    public void addHeadDeptDao(HeadDept headdept) throws SQLException {
        UserDao user = new UserDao();
        user.addUser(headdept.getUser());
        PreparedStatement prep = conn.prepareStatement(
        "insert into head_dept values (?,?,?)");
        prep.setInt(1, headdept.getDuration());
        prep.setInt(2, headdept.getUser().getIduser());
        prep.setInt(3,headdept.getDepartmentDepartmentId().getDepartmentId());
        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void deleteHeadDept(int headdeptid) throws SQLException {
        String queryString = "delete * from head_dept where user_iduser=?";
        PreparedStatement prep = conn.prepareStatement(queryString);
        prep.setInt(1, headdeptid);

        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void updateHeadDept(HeadDept headdept) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update head_dept duration=?, user_iduser=?, "
                            + "department_department_id=?  where headdeptid=?");
// Parameters start with 1
            UserDao user = new UserDao();
            preparedStatement.setInt(1, headdept.getDuration());
            preparedStatement.setInt(2, headdept.getUser().getIduser());
            preparedStatement.setInt(3, headdept.getDepartmentDepartmentId().getDepartmentId());
            preparedStatement.executeUpdate();
            user.updateUser(headdept.getUser());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyIdentity(String uName, String password) throws SQLException {
        boolean value = false;

        String query = "select * from headdept where firstname=? and password=?";
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
//        List<User> headdepts = new ArrayList();
//        try {
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery("select * from headdepts");
//            while (rs.next()) {
//                User headdept = new User();
//                headdept.setIdheaddept(rs.getInt("idheaddept"));
//                headdept.setFirstname(rs.getString("firstname"));
//                headdept.setLastname(rs.getString("lastname"));
//                headdept.setMiddlename(rs.getString("middlename"));
//                headdept.setDateOfBirth(rs.getLong("date_of_birth"));
//                headdept.setGender(rs.getString("gender"));
//                headdept.setPassword(rs.getString("password"));
//                headdepts.add(headdept);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return headdepts;
//    }

    public HeadDept getHeadDeptId(int headdeptId) {
        HeadDept headdept = new HeadDept();
        String queryString = "select * from headdepts where headdeptid=" + headdeptId;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(queryString);
            if (rs.next()) {
                headdept.setUser_iduser(rs.getInt("user_iduser"));
                headdept.setDuration(rs.getInt("duration"));
                headdept.setDepartment_department_id(rs.getInt("department_department_id"));
                //headdept.setUser(rs.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return headdept;
    }
    
}
