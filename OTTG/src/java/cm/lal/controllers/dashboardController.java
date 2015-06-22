/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.controllers;

import cm.lal.dao.LectureDao;
import cm.lal.model.CourseTakesPlaceInClassroom;
import cm.lal.model.Lecture;
import cm.lal.model.Timetable;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class dashboardController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dashboardController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dashboardController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String courseTitle = request.getParameter("course-title");
        String courseCode = request.getParameter("course-code");
        String classroom = request.getParameter("classroom");
        String weekdays[] = request.getParameterValues("day");
        int startTime = Integer.parseInt(request.getParameter("start-time"));
        int stopTime = Integer.parseInt(request.getParameter("stop-time"));
        System.out.println("startAt="+startTime+"classroom="+stopTime);
//        int lecturer = Integer.parseInt(request.getParameter("lecturer"));
        System.out.println("course="+courseCode+" title="+courseTitle);
        
        Timetable timed = (Timetable) request.getSession().getAttribute("timetable");
        if (timed == null) {
            timed = new Timetable();
        }
        
        if (weekdays != null) {
            for (String string : weekdays) {
                
                String dayString = string;
                int day = 0;
                if (dayString.equalsIgnoreCase("SUN")) {
                    day = 1;
                } else if (dayString.equalsIgnoreCase("MON")) {
                    day = 2;
                } else if (dayString.equalsIgnoreCase("TUE")) {
                    day = 3;
                } else if (dayString.equalsIgnoreCase("WED")) {
                    day = 4;
                } else if (dayString.equalsIgnoreCase("THU")) {
                    day = 5;
                } else if (dayString.equalsIgnoreCase("FRI")) {
                    day = 6;
                } else if (dayString.equalsIgnoreCase("SAT")) {
                    day = 6;
                }
// First create a relation betwen classroom and course
                CourseTakesPlaceInClassroom ctpic = new CourseTakesPlaceInClassroom();
                ctpic.setClassroomIdclassroom(classroom);
                ctpic.setCourseCourseCode(courseCode);
// Now create the lecture and set its properties
                Lecture lec = new Lecture();
                lec.setLectureDay(day);
                lec.setStartTime(startTime);
                lec.setStopTime(stopTime);
                lec.setCourseTakesPlaceInClassroom(ctpic);
                out.println(timed);
//                lec.setTimetableIdtimetable(timed.getIdtimetable());
                //lec.setLecturerUserIduser(lecturer);
               
                LectureDao lectureDao = new LectureDao();
                try {
                    lectureDao.addLecture(lec);
                    System.out.println("success");
                } catch (SQLException ex) {
                    Logger.getLogger(dashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
