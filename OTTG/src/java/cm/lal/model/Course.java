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
public class Course {
    
    private String courseCode;
    private String courseName;
    private Collection<CourseTakesPlaceInClassroom> courseTakesPlaceInClassroomCollection;

    public Course() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Collection<CourseTakesPlaceInClassroom> getCourseTakesPlaceInClassroomCollection() {
        return courseTakesPlaceInClassroomCollection;
    }

    public void setCourseTakesPlaceInClassroomCollection(Collection<CourseTakesPlaceInClassroom> courseTakesPlaceInClassroomCollection) {
        this.courseTakesPlaceInClassroomCollection = courseTakesPlaceInClassroomCollection;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
