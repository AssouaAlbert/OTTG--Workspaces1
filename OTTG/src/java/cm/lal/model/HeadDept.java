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
    
    private Integer duration;
    private int user_iduser;
    private int department_department_id;
    private Department departmentDepartmentId;
    private User user;

    public HeadDept() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public int getUser_iduser() {
        return user_iduser;
    }

    public void setUser_iduser(int user_iduser) {
        this.user_iduser = user_iduser;
    }

    public int getDepartment_department_id() {
        return department_department_id;
    }

    public void setDepartment_department_id(int department_department_id) {
        this.department_department_id = department_department_id;
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
