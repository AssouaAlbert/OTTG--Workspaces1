/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.lal.dao;

import cm.lal.model.User;
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
public class UserDao {

    private Connection conn = null;

    public UserDao() {
        conn = DbUtil.getConnection();
    }

    public void addUser(User user) {
        try {
            Statement stat = null;
            String insertString = "insert into user(firstname,middlename,lastname,"
                    + "date_of_birth,gender,password) values("
                    + "'" + user.getFirstname() + "', '" + user.getMiddlename() + "', '" + user.getLastname()
                    + "', " + user.getDateOfBirth() + ", '" + user.getGender()
                    + "', '" + user.getPassword() + "')";
            System.out.println(insertString);
            stat = conn.createStatement();
            stat.executeUpdate(insertString);

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(int userid) throws SQLException {
        String queryString = "delete * from user where id=?";
        PreparedStatement prep = conn.prepareStatement(queryString);
        prep.setInt(1, userid);

        int returnValue = prep.executeUpdate();
        if (returnValue != 0) {
            System.out.println("success with " + returnValue + " rows affected");
        } else {
            System.out.println("success with no return values from SQL");
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update users set firstname=?, lastname=?, "
                            + "date_of_birth=?, middlename=?, password=?,"
                            + " gender=? where userid=?");
// Parameters start with 1
            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setLong(3, user.getDateOfBirth());
            preparedStatement.setString(4, user.getMiddlename());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyIdentity(String uName, String password) throws SQLException {
        boolean value = false;
        Statement stat = null;
        String insString = "select * from user where"
                + " firstname='" + uName + "' and password='" + password + "'";

        System.out.println(insString);
        stat = conn.createStatement();

        ResultSet returnResultSet = stat.executeQuery(insString);
        int i = 0;
        while (returnResultSet.next()) {
            i++;
            System.out.println("i has value "+i);
        }
        if (i == 1) {
            value = true;
        }
        System.out.println("value is " + value);
        return value;

//        String query = "select * from user where firstname=? and password=?";
//        PreparedStatement prep = conn.prepareStatement(query);
//        prep.setString(1, uName);
//        prep.setString(2, password);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setIduser(rs.getInt("iduser"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setMiddlename(rs.getString("middlename"));
                user.setDateOfBirth(rs.getLong("date_of_birth"));
                user.setGender(rs.getString("gender"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(int userId) {
        User user = new User();
        String queryString = "select * from users where userid=" + userId;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(queryString);
            if (rs.next()) {
                user.setIduser(rs.getInt("iduser"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setMiddlename(rs.getString("middlename"));
                user.setDateOfBirth(rs.getLong("date_of_birth"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
