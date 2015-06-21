/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.lal.model;

/**
 *
 * @author user
 */
public class Dean {

    private String formerPosition;
    private int accesslevel;
    private Integer duration;
    private Faculty facultyIdfaculty;
    private User user;

    public Dean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFormerPosition() {
        return formerPosition;
    }

    public void setFormerPosition(String formerPosition) {
        this.formerPosition = formerPosition;
    }

    public int getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(int accesslevel) {
        this.accesslevel = accesslevel;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Faculty getFacultyIdfaculty() {
        return facultyIdfaculty;
    }

    public void setFacultyIdfaculty(Faculty facultyIdfaculty) {
        this.facultyIdfaculty = facultyIdfaculty;
    }

    @Override
    public String toString() {
        return "Dean{" + "userID=" + user.getIduser() + " facultyIdfaculty=" + facultyIdfaculty + '}';
    }
}
