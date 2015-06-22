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
public class Student {
    
    private String typeGradUndergrad;
    private int user_id_iduser;
    private int department_department_id;
    private Collection<Lecture> lectureCollection;
    private Department departmentDepartmentId;
    private User user;

    public Student() {
    }

    public String getTypeGradUndergrad() {
        return typeGradUndergrad;
    }

    public void setTypeGradUndergrad(String typeGradUndergrad) {
        this.typeGradUndergrad = typeGradUndergrad;
    }

    public int getUser_id_iduser() {
        return user_id_iduser;
    }

    public void setUser_id_iduser(int user_id_iduser) {
        this.user_id_iduser = user_id_iduser;
    }

    public int getDepartment_department_id() {
        return department_department_id;
    }

    public void setDepartment_department_id(int department_department_id) {
        this.department_department_id = department_department_id;
    }
    
    public Collection<Lecture> getLectureCollection() {
        return lectureCollection;
    }

    public void setLectureCollection(Collection<Lecture> lectureCollection) {
        this.lectureCollection = lectureCollection;
    }

    public Department getDepartmentDepartmentId() {
        return departmentDepartmentId;
    }

    public void setDepartmentDepartmentId(Department departmentDepartmentId) {
        this.departmentDepartmentId = departmentDepartmentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student{" + "typeGradUndergrad=" + typeGradUndergrad
                + ", userIduser=" + user.getIduser() + '}';
    }
}
