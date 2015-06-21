<%-- 
    Document   : help
    Created on : Jun 21, 2015, 4:41:50 AM
    Author     : Arnold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OTTG Help</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" href="css/ionic.min.css" rel="stylesheet"/>
        <link type="text/css" href="css/ottgstyle.css" rel="stylesheet"/>
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"/>

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
                    <a class="navbar-brand" href="index.html">Home</a>  
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                    <ul class="nav navbar-nav">
                        <li class=""><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Help</a></li>
                       <!-- <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" >Faculties <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu" >
                                <li><a href="#"> Science</a></li>
                                <li><a href="#"> Arts</a></li>
                                <li><a href="#"> Engineering</a></li>
                                <li><a href="#"> Management</a></li>
                                <li><a href="#"> Entertainment</a></li>
                            </ul>
                        </li> -->
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="loginPge.jsp" class="btn btn-info">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-7 col-sm-6 ">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">Online TimeTable Generator</h3>
                        </div>
                        <div class="panel-body">
                            This project is carried by three brillant students from the <br>
                            faculty of engineering and Technology, University of Buea.<br>
                            Visit the Help link above to have more insight of the application.

                        </div>
                    </div>

                </div>
                <div class="col-lg-4 col-md-5 col-sm-6 ">
                    <div class="">
                        <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">Team ALA </h3>
                        </div>
                        <div class="panel-body">
                            <div class="item item-avatar">  
                            <img src="img/admin.jpg">
                            <h2>Arnold Chuenffo</h2>
                            <p>Front-end Developer</p>
                        </div>
                        <div class="item item-avatar">  
                            <img src="img/logo.png">
                            <h2>Lawrence Mingo </h2>
                            <p>Back-end Developer</p>
                        </div>
                        <div class="item item-avatar">  
                            <img src="img/logo.png">
                            <h2>Assoua Albert</h2>
                            <p>Product Designer</p>
                        </div>
                        </div>
                    </div>
                        
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <!--<script type="text/javascript" src="js/bootswatch.js"></script>-->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </body>
</html>
