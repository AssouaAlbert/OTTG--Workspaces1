/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.lal.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author user
 */
public class DbUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {

            return connection;
        } else {
            try {
//                Properties prop = new Properties();
//                InputStream inputStream
//                        = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");

//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("user");
//                String password = prop.getProperty("password");
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/mydb";
                String user = "root";
                String password = "";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();

            }
            return connection;
        }
    }

//    public static void setConnection(Connection connection) {
//        DbUtil.connection = connection;
//    }
}
