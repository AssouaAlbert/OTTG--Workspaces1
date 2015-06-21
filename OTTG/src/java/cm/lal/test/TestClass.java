/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.test;

import cm.lal.dao.UserDao;
import cm.lal.model.User;
import java.util.Date;

/**
 *
 * @author user
 */
public class TestClass {
    
    private static UserDao dao = null;
    private static User user = null;

    public TestClass() {
    }

    public static void main(String[] args) {
        
        try {
            user = new User();
            user.setDateOfBirth(new Date().getTime());
            user.setFirstname("na milk");
            user.setLastname("limpopo");
            user.setPassword("alloa");
            user.setGender("F");
            dao = new UserDao();
            System.out.println("success");
            dao.addUser(user);
            dao.deleteUser(1);
        } catch (Exception e) {
        }
    }
}
