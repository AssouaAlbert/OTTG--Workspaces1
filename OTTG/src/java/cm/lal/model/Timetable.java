/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.model;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author user
 */
public class Timetable {

    public Timetable() {
    }
    
    private Integer idtimetable;
    private Date validityStart;
    private Date validityEnd;
    private Collection<Lecture> lectureCollection;

    public Integer getIdtimetable() {
        return idtimetable;
    }

    public void setIdtimetable(Integer idtimetable) {
        this.idtimetable = idtimetable;
    }

    public Date getValidityStart() {
        return validityStart;
    }

    public void setValidityStart(Date validityStart) {
        this.validityStart = validityStart;
    }

    public Date getValidityEnd() {
        return validityEnd;
    }

    public void setValidityEnd(Date validityEnd) {
        this.validityEnd = validityEnd;
    }

    public Collection<Lecture> getLectureCollection() {
        return lectureCollection;
    }

    public void setLectureCollection(Collection<Lecture> lectureCollection) {
        this.lectureCollection = lectureCollection;
    }

    @Override
    public String toString() {
        return "Timetable{" + "idtimetable=" + idtimetable + ", validityStart="
                + "" + validityStart + ", validityEnd=" + validityEnd + '}';
    }

}
