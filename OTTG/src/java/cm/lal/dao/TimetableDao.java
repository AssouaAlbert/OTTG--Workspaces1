/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.lal.dao;

import cm.lal.model.Timetable;
import cm.lal.util.DbUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author user
 */
public class TimetableDao {

    Connection conn = null;

    public TimetableDao() {
        conn = DbUtil.getConnection();
    }

    public Timetable getCurrentTimetable() {
        Timetable timetable = new Timetable();
        String queryString = "select * from timetable where "
                + "validity_start < curdate() and validity_end > curdate()";
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(queryString);
            if (rs.next()) {
                timetable.setIdtimetable(rs.getInt("idtimetable"));
                timetable.setValidityStart(rs.getDate("validity_start"));
                timetable.setValidityEnd(rs.getDate("validity_end"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timetable;
    }
}

