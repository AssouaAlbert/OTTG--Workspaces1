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
public class HeadDept {
    
    private int accesslevel;
    private Integer duration;
    private Department departmentDepartmentId;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Department getDepartmentDepartmentId() {
        return departmentDepartmentId;
    }

    public void setDepartmentDepartmentId(Department departmentDepartmentId) {
        this.departmentDepartmentId = departmentDepartmentId;
    }

    @Override
    public String toString() {
        return "HeadDept{" + "userID=" + user.getIduser() + ", "
                + "departmentDepartmentId=" + departmentDepartmentId + '}';
    }
}
