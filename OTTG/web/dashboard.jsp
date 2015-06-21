<%-- 
    Document   : dashboard
    Created on : Jun 18, 2015, 4:24:09 AM
    Author     : Arnold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Dashboard</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" href="css/ionic.min.css" rel="stylesheet"/>
        <link type="text/css" href="css/ottgstyle.css" rel="stylesheet"/>
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"/>
        <!-- Favicons -->
        <link rel="apple-touch-icon" href="img/admin.png">
    </head>
    <body>


        <nav class="navbar navbar-inverse">
            <div class="container-fluid btn-default">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><img class="image-responsive" src="img/logo.png" width= "100"% height="500%"></a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                    <ul class="nav navbar-nav">
                        <li class=""><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Help</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Faculties <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu" >
                                <li><a href="#" onclick="alert('Direct this to falcuty')"> Science</a></li>
                                <li><a href="#"> Arts</a></li>
                                <li><a href="#"> Engineering</a></li>
                                <li><a href="#"> Management</a></li>
                                <li><a href="#"> Entertainment</a></li>
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.html" class="btn btn-warning">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <br><br><br>

        <div class="container">
            <div class="row">
                <div class=" card">
                    <div class="col-lg-12 col-md-12 col-sm-12" >
                        <h2><span style="color:black; ">Welcome Admin</span></h2>
                        <div class="item item-thumbnail-left">
                            <img src="img/admin.jpg"> 
                            <h2>Administrator Dashboard</h2>
                            <h2>CRUD timetable</h2>

                        </div>    
                        <ul class="list-group">
                            <li class="item"><a href="#">Profile</a></li>
                            <li class="item"><a href="#">Activities</a></li>
                            <li class="item"><a href="#">Settings</a></li>
                        </ul>


                    </div>
                </div>
                <div class="col-lg-12 col-md-8 col-sm-6 ">
                    <!-- Table manapiulation buttons -->
                    <div class= "row card">
                        <div class="col-lg-6 col-md-4 col-sm-4"> <!-- Button trigger modal add course -->
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#addCourse">
                                Add course
                            </button>
                        </div>&nbsp
                        <div class="col-lg-6 col-md-4 col-sm-4"><!-- Button trigger modal add lecturer -->
                            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addLecturer">
                                Add lecturer
                            </button>
                        </div>&nbsp
                        <div class="col-lg-6 col-md-4 col-sm-4"><!-- Button trigger modal add course -->
                            <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#addRoom">
                                Add classroom
                            </button>
                        </div>&nbsp

                    </div>
                    <!-- Timetable table -->
                    <div class="row">
                        <div class="col-lg-12" >
                            <div class="page-header">
                                <h2>General Timetable</h2>
                            </div>
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
                                        <!--                                    <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td></td>-->
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <!-- Modal Add Course-->
            <div class="modal" id="addCourse">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Add course</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" method="post" action="/OTTG/dashboardController">

                                <div class="form-group">
                                    <label for="" class="control-label">Course Title:</label>
                                    <input type="text" iclass="form-control" id="course-title" name="course-title" required>
                                </div>
                                <div class="form-group">
                                    <label for="" class="control-label">Course Code</label>
                                    <input type="text" class="form-control" id="course-code"  name="course-code"requiered>
                                </div>
                                <div class="form-group">
                                    <label for="" class="control-label">Classroom</label>
                                    <input type="text" class="form-control" id="classroom" name="classroom" requiered>
                                </div>
                                <div class="form-group form-inline">
                                    <h5>Days</h5>
                                    <label for="" class="control-label">Mon</label>
                                    <input type="checkbox" class="form-control" id="mon" name="day" >&nbsp
                                    <label for="" class="control-label">Tue</label>
                                    <input type="checkbox" class="form-control" id="tue" name="day">&nbsp
                                    <label for="" class="control-label">Wed</label>
                                    <input type="checkbox" class="form-control" id="wed" name="day">&nbsp
                                    <label for="" class="control-label">Thu</label>
                                    <input type="checkbox" class="form-control" id="thu" name="day">&nbsp
                                    <label for="" class="control-label">Fri</label>
                                    <input type="checkbox" class="form-control" id="fri" name="day">&nbsp
                                    <label for="" class="control-label">Sat</label>
                                    <input type="checkbox" class="form-control" id="sat" name="day">&nbsp
                                </div>
                                <div class="form-group form-inline">
                                    <h4>Time</h4>

                                    <h5>Start</h5><h5>End</h5>
                                    <select name="startTime" class="form-control" id="startTime" >

                                        <h5>Start</h5>
                                        <select name="start-time" style="color: black">

                                            <option value="7" selected>7:00 am</option>
                                            <option value="9">9:00 am</option>
                                            <option value="11">11:00 am</option>
                                            <option value="13">1:00 pm</option>

                                        </select>
                                        <select name="endTime" class="form-control" id="endTime">
                                            <option value="7" selected>7:00 am</option>
                                            <option value="9">9:00 am</option>

                                            <option value="15">3:00 pm</option>
                                            <option value="17">5:00 pm</option>
                                        </select><h5>End</h5>
                                        <select name="stop-time" style="color: black">
                                            <option value="9" selected>9:00 am</option>

                                            <option value="11">11:00 am</option>
                                            <option value="13">1:00 pm</option>
                                            <option value="15">3:00 pm</option>
                                            <option value="17">5:00 pm</option>
                                            <option value="19">7:00 pm</option>
                                        </select>
                                </div >
                                <button type="submit" class="btn btn-success">Save changes</button>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

            <!-- Modal add lecturer -->
            <div class="modal" id="addLecturer">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Add Lecturer</h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal">
                                <div class="form-group form-inline">
                                    <label for="inputEmail" class=" control-label">Full name</label>
                                    <div class="col-lg-12">
                                        <input type="text" class="form-control" id="firstName" placeholder="First name">
                                        <input type="text" class="form-control" id="middleName" placeholder="Middle name">
                                        <input type="text" class="form-control" id="lastName" placeholder="Last name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                                    <div class="col-lg-10">
                                        <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                                    <div class="col-lg-10">
                                        <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox"> Visiting lecturer
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="textArea" class="col-lg-2 control-label">Course</label>
                                    <div class="col-lg-10">
                                        <input type="text" class="form-control" id="inputCourse" placeholder="Course taking">
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <footer>
            <div class="col-lg-8 col-md-4 col-sm-4" ></div>
            <div class="col-lg-4 col-md-4 col-sm-4" >
                <p style="text-align:center">
                <h5>Powered by Funtech</h5>


                <span class="badge pull-left ">
                    Copyright 2015
                </span>
                </p>
            </div>
        </footer>




        <script type="text/javascript" src="js/jquery.min.js"></script>
        <!--<script type="text/javascript" src="js/bootswatch.js"></script>-->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>


    </body>
</html>
