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
public class Classroom {
    
    private String idclassroom;
    private String roomLocation;
    private Integer capacity;
    private Collection<CourseTakesPlaceInClassroom> courseTakesPlaceInClassroomCollection;

    public Classroom() {
    }

    public String getIdclassroom() {
        return idclassroom;
    }

    public void setIdclassroom(String idclassroom) {
        this.idclassroom = idclassroom;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Collection<CourseTakesPlaceInClassroom> getCourseTakesPlaceInClassroomCollection() {
        return courseTakesPlaceInClassroomCollection;
    }

    public void setCourseTakesPlaceInClassroomCollection(Collection<CourseTakesPlaceInClassroom> courseTakesPlaceInClassroomCollection) {
        this.courseTakesPlaceInClassroomCollection = courseTakesPlaceInClassroomCollection;
    }

    @Override
    public String toString() {
        return "Classroom{" + "idclassroom=" + idclassroom + ", roomLocation=" + roomLocation + '}';
    }
    
}
