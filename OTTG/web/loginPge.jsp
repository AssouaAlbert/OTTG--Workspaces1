<%-- 
    Document   : loginPge
    Created on : Jun 16, 2015, 7:37:58 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Online Timetable Generator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" href="css/ionic.min.css" rel="stylesheet"/>
        <link type="text/css" href="css/ottgstyle.css" rel="stylesheet"/><!---->
        <link type="text/css" href="css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body >
        <!---->

        <%            String username = (String) session.getAttribute("username");
            if (username != null) {
                out.print("Nice having you " + username + "<a href=\"Logout.jsp\">Logout</a>");
            } else {
        %>

        <div class="container">
            <div class="row" >
                <div class="Absolute-Center is-Responsive  card ">
                    <h1 style="color:white;">Online Timetable Generator</h1>
                    <div class="col-sm-12 col-md-10 col-md-offset-1">

                        <form action="/OTTG/LoginServlet" id="loginForm" method="post">
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input required="true" class="form-control" type="text" name='username' placeholder="username"/>          
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-tower"></i></span>
                                <input required="true" class="form-control" type="password" name='password' placeholder="password"/>     
                            </div>
                            <br>
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block">Login</button>
                            </div>
                            <div class="form-group text-center" >
                                <a href="#">Forgot Password</a>&nbsp;|&nbsp;<a href="#">Support</a>
                            </div>
                        </form>  

                    </div>  
                </div>    
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>
