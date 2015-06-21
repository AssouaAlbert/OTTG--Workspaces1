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
public class Department {
    
    private Integer departmentId;
    private String departmntName;
    private Collection<Lecturer> lecturerCollection;
    private Collection<Student> studentCollection;
    private HeadDept headDept;
    private Faculty facultyId;

    public Department() {
    }

    public Faculty getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Faculty facultyId) {
        this.facultyId = facultyId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmntName() {
        return departmntName;
    }

    public void setDepartmntName(String departmntName) {
        this.departmntName = departmntName;
    }

    public Collection<Lecturer> getLecturerCollection() {
        return lecturerCollection;
    }

    public void setLecturerCollection(Collection<Lecturer> lecturerCollection) {
        this.lecturerCollection = lecturerCollection;
    }

    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public HeadDept getHeadDept() {
        return headDept;
    }

    public void setHeadDept(HeadDept headDept) {
        this.headDept = headDept;
    }

    @Override
    public String toString() {
        // ", departmntName=" + departmntName + ", headDept=" + headDept + 
        return "Department{" + "departmentId=" + departmentId + '}';
    }
}
