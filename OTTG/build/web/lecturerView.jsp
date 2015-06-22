<%-- 
    Document   : lecturerView
    Created on : Jun 19, 2015, 11:57:09 AM
    Author     : user
--%>

<%@page import="java.util.List"%>
<%@page import="cm.lal.model.Lecture"%>
<%@page import="cm.lal.model.Lecturer"%>
<%@page import="cm.lal.dao.LecturerDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lecturers View</title>
        <link type="text/css" href="css/ionic.min.css" rel="stylesheet"/>
        <link type="text/css" href="css/ottgstyle.css" rel="stylesheet"/>
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"/>

    </head>
    <body>
        <header>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid btn-default">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav">
                            <li class=""><a href="#"> <span class="sr-only">(current)</span></a></li>
                            <li><a href="help.jsp">Help</a></li>

                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="index.html" class="btn btn-warning">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>


        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-12 col-sm-12 ">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">Lecturer's Dashboard</h3>
                        </div>
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="item"><a href="#">Profile</a></li>
                                <li class="item"><a href="#">Activities</a></li>
                                <li class="item"><a href="#">Settings</a></li>
                            </ul>
                        </div>
                        <form class="form-horizontal" method="post" action="/OTTG/LecturerServlet" id="mipForm">
                            <button type="submit" class="btn btn-success">Show individual List</button>
                        </form>
                    </div>
                </div>

                <div class="col-lg-8 col-md-8 col-sm-6 ">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">Individual Timetable</h3>
                        </div>
                        <%
                            HttpSession sessi = request.getSession(false);
                            // getting ServletContext values set at loginServlet
                            ServletContext con = getServletContext();
                            String username = (String) con.getAttribute("UserName");
                            int userid = (Integer) con.getAttribute("UserID");
                            // creating all objects necessary to get lectures offered by lecturer
                            Lecturer testLecturer = new Lecturer();
                            testLecturer.setUser_iduser(userid);
                            LecturerDao lexeme = new LecturerDao();
                            List<Lecture> lexlist = lexeme.getAllLecturesByLecturer(testLecturer);
                            for (Lecture lex : lexlist) {
                                out.print(lex.getcTPLICcourseCode() + " at " + lex.getcTPLICidClassroom());
                            }
                        %>
                        <div class="panel-body">
                            <div class="bs-component table-responsive">
                                <table class="table table-striped" >
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Monday</th>
                                            <th>Tuesday</th>
                                            <th>Wednesday</th>
                                            <th>Thursday</th>
                                            <th>Friday</th>
                                            <th>Saturday</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td >7am - 9am</td>
                                        </tr>
                                        <tr>
                                            <td >9am - 11am</td>
                                        </tr>
                                        <tr>
                                            <td >11am - 1pm</td>
                                        </tr>
                                        <tr>
                                            <td >1pm - 3pm</td>
                                        </tr>
                                        <tr>
                                            <td >3pm - 5pm</td>
                                        </tr>
                                        <tr>
                                            <td >5pm - 7pm</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>


                <script type="text/javascript" src="js/jquery.min.js"></script>
                <script type="text/javascript" src="js/bootstrap.min.js"></script>

                </body>
                </html>
