/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.model;

import java.util.Collection;

/**
 *
 * @author user
 */
public class Lecturer {
    
    private User user;
    private String typePartOrFull;
    private int user_iduser;
    private Collection<Department> departmentCollection;
    private Collection<Lecture> lectureCollection;

    public Lecturer() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTypePartOrFull() {
        return typePartOrFull;
    }

    public void setTypePartOrFull(String typePartOrFull) {
        this.typePartOrFull = typePartOrFull;
    }

    public int getUser_iduser() {
        return user_iduser;
    }

    public void setUser_iduser(int user_iduser) {
        this.user_iduser = user_iduser;
    }

    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    public Collection<Lecture> getLectureCollection() {
        return lectureCollection;
    }

    public void setLectureCollection(Collection<Lecture> lectureCollection) {
        this.lectureCollection = lectureCollection;
    }

    @Override
    public String toString() {
        return "Lecturer{" + "userID=" + user.getIduser() + ", typePartOrFull=" + typePartOrFull + '}';
    }

}
