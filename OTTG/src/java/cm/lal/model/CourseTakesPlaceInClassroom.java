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
public class CourseTakesPlaceInClassroom {
    
    private String courseCourseCode;
    private String classroomIdclassroom;
    private Collection<Lecture> lectureCollection;
    private Classroom classroom;
    private Course course;

    public CourseTakesPlaceInClassroom() {
    }

    public CourseTakesPlaceInClassroom(String courseCourseCode, String classroomIdclassroom, Collection<Lecture> lectureCollection, Classroom classroom, Course course) {
        this.courseCourseCode = courseCourseCode;
        this.classroomIdclassroom = classroomIdclassroom;
        this.lectureCollection = lectureCollection;
        this.classroom = classroom;
        this.course = course;
    }

    public String getCourseCourseCode() {
        return courseCourseCode;
    }

    public void setCourseCourseCode(String courseCourseCode) {
        this.courseCourseCode = courseCourseCode;
    }

    public String getClassroomIdclassroom() {
        return classroomIdclassroom;
    }

    public void setClassroomIdclassroom(String classroomIdclassroom) {
        this.classroomIdclassroom = classroomIdclassroom;
    }

    public Collection<Lecture> getLectureCollection() {
        return lectureCollection;
    }

    public void setLectureCollection(Collection<Lecture> lectureCollection) {
        this.lectureCollection = lectureCollection;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "CourseTakesPlaceInClassroom{" + "courseCourseCode=" + 
                courseCourseCode + ", classroomIdclassroom=" + classroomIdclassroom + '}';
    }
}
