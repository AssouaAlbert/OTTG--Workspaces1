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
public class Faculty {

    private Integer idfaculty;
    private String facultyname;
    private Dean dean;
    private Collection<Department> departmentCollection;

    public Faculty() {
    }

    public Integer getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(Integer idfaculty) {
        this.idfaculty = idfaculty;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    public Dean getDean() {
        return dean;
    }

    public void setDean(Dean dean) {
        this.dean = dean;
    }

    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    @Override
    public String toString() {
        // ", facultyname=" + facultyname + ", dean=" + dean +
        return "Faculty{" + "idfaculty=" + idfaculty +  '}';
    }

}
