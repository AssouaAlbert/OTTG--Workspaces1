/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.lal.controllers;

import cm.lal.dao.UserDao;
import cm.lal.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        UserDao userDao = new UserDao();

        String userSession = ""; // attribute for getting user session in next few JSP pages: NB --potential security loophole
        if (userName == null || passWord == null) {
            out.print("Invalid Credentials. Try Again!!!\n");
        } else {
            User userClass = new User();
            out.print("\n Please be patient " + userName + "\n");
            boolean value = false;
            int accesslevel = 3;
// minimize the number of variables used because of space and memory considerations
            try {
                HashMap<User, Boolean> hash = userDao.verifyIdentity(userName, passWord);
                for (Map.Entry<User, Boolean> entry : hash.entrySet()) {
                    userClass = entry.getKey();
                    accesslevel = userClass.getAccesslevel();
                    value = entry.getValue();
                }
                System.out.println("user= " + userName + "pass=" + passWord);
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (value == true) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute(userSession, userClass);
                        ServletContext svContext = getServletContext();
                        svContext.setAttribute("UserName", userClass.getFirstname());
                        svContext.setAttribute("UserID", userClass.getIduser());
                switch (accesslevel) {
                    // core business logic and 
                    case 0:
                        RequestDispatcher rd = request.getRequestDispatcher("deanView.jsp");
                        rd.forward(request, response);
                        response.sendRedirect("deanView.jsp");
                        break;
                    case 1:
                        RequestDispatcher rd1 = request.getRequestDispatcher("dashboard.jsp");
                        rd1.forward(request, response);
                        response.sendRedirect("dashboard.jsp");
                        break;
                    case 2:
                        RequestDispatcher rd2 = request.getRequestDispatcher("hodView.jsp");
                        rd2.forward(request, response);
                        response.sendRedirect("hodView.jsp");
                        break;
                    default:
                        RequestDispatcher rd3 = request.getRequestDispatcher("lecturerView.jsp");
                        rd3.forward(request, response);
                        response.sendRedirect("lecturerView.jsp");
                }
            } else {
                response.sendRedirect("loginPge.jsp");
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
