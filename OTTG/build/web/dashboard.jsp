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
                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
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
<<<<<<< Updated upstream
            <div class="row">
                <div class=" card">
                    <div class="col-lg-12 col-md-12 col-sm-12" >
                        <h2><span style="color:black; ">Welcome Admin</span></h2>
                        <div class="item item-thumbnail-left">
                            <img src="img/admin.jpg"> 
                            <h2>Ddenine sieernbskjberjs</h2>
                            <h2>Ddenine sieresnbnnbelrne</h2>

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
                            <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">
                                Add course
                            </button>
                        </div>&nbsp
                        <div class="col-lg-6 col-md-4 col-sm-4"><!-- Button trigger modal add lecturer -->
                            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                                Add lecturer
                            </button>
                        </div>&nbsp
                        <div class="col-lg-6 col-md-4 col-sm-4"><!-- Button trigger modal add course -->
                            <button type="button" class="btn btn-default btn-lg" data-toggle="modal" data-target="#myModal">
                                Add classroom
                            </button>
                        </div>&nbsp

                    </div>
                    <!-- Timetable table -->
                    <div class="row">
                        <div class="col-lg-12" >
                            <div class="page-header">
                                <h2>Populated Timetable</h2>
=======
            <div class="row" >
                <div class="Absolute-Center is-Responsive  card ">
                    <h1 style="color:white;">Administrator</h1>
                    <div class="col-sm-12 col-md-10 col-md-offset-1">

                        <form >
                            <a href="timetable.jsp" class="btn btn-primary">Manage Timetable</a>
                            <a href="student.jsp" class="btn btn-primary">Manage Student</a>
                            <a href="timetable.jsp" class="btn btn-primary">Manage Lecturer</a>
                            <a href="timetable.jsp" class="btn btn-primary">Manage Courses</a>
>>>>>>> Stashed changes
                            </div>
                            <div class="bs-component table-responsive">
                                <table class="table table-striped table-bordered">
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
                                            <td >7am -9 am</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <!-- Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Add course</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="">
                                <div class="form-group">
                                    <label for="" class="control-label">Course Title:</label>
                                    <input type="text" class="form-control" id="course-title" required>
                                </div>
                                <div class="form-group">
                                    <label for="" class="control-label">Course Code</label>
                                    <input type="text" class="form-control" id="course-code"  requiered>
                                </div>
                                <div class="form-group">
                                    <label for="" class="control-label">Classroom</label>
                                    <input type="text" class="form-control" id="classroom"  requiered>
                                </div>
                                <div class="form-group form-inline">
                                    <h5>Days</h5>
                                    <label for="" class="control-label">Mon</label>
                                    <input type="checkbox" class="form-control" id="mon" >&nbsp
                                    <label for="" class="control-label">Tuesday</label>
                                    <input type="checkbox" class="form-control" id="tue" >&nbsp
                                    <label for="" class="control-label">Wednesday</label>
                                    <input type="checkbox" class="form-control" id="wed" >&nbsp
                                    <label for="" class="control-label">Thursday</label>
                                    <input type="checkbox" class="form-control" id="thu" >&nbsp
                                    <label for="" class="control-label">Friday</label>
                                    <input type="checkbox" class="form-control" id="fri" >&nbsp
                                    <label for="" class="control-label">Saturday</label>
                                    <input type="checkbox" class="form-control" id="sat" >&nbsp
                                </div>
                                <div class="form-group form-inline">
                                    <h4>Time</h4>
                                    <h5>Start</h5><h5>End</h5>
                                    <select name="dropdown" style="color: black">
                                        <option value="7" selected>7:00 am</option>
                                        <option value="9">9:00 am</option>
                                        <option value="11">11:00 am</option>
                                        <option value="13">1:00 pm</option>
                                    </select>
                                    <select name="dropdown" style="color: black">
                                        <option value="7" selected>7:00 am</option>
                                        <option value="9">9:00 am</option>
                                        <option value="11">11:00 am</option>
                                        <option value="13">1:00 pm</option>
                                    </select>
                                </div>

                            </form>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success">Save changes</button>
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

        <!-- <div class="container">
             <div class="row" >
                 <div class="Absolute-Center is-Responsive  card ">
                     <h1 style="color:white;">Administratorsss</h1>
                     <div class="col-sm-12 col-md-10 col-md-offset-1">
 
                         <form >
                             <div class="form-group input-group">
                             <div class="form-group">
 
                                 <h:commandButton class="btn btn-primary btn-block" type="edit" value="Manage Timetable" action="timetable"></h:commandButton>
                                 <h:commandButton class="btn btn-primary btn-block" type="edit" value="Manage Student" action="index"></h:commandButton>
                                     <h:commandButton class="btn btn-primary btn-block" type="edit" value="Manage Lecturers" action="index"></h:commandButton>
                                     <h:commandButton class="btn btn-primary btn-block" type="edit" value="Manage Courses" action="index"></h:commandButton>
                             </div>
                             </div>
                         </form>  
 
                     </div
                 </div>    
             </div>
         </div>
         </div> -->

    </body>
</html>
