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
    
    private int accesslevel;
    private String typeGradUndergrad;
    private Collection<Lecture> lectureCollection;
    private Department departmentDepartmentId;
    private User user;

    public int getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(int accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getTypeGradUndergrad() {
        return typeGradUndergrad;
    }

    public void setTypeGradUndergrad(String typeGradUndergrad) {
        this.typeGradUndergrad = typeGradUndergrad;
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
