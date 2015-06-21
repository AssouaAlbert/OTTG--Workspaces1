<%-- 
    Document   : lecturerView
    Created on : Jun 19, 2015, 11:57:09 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    </div>
                </div>

                <div class="col-lg-8 col-md-8 col-sm-6 ">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">Individual Timetable</h3>
                        </div>
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
