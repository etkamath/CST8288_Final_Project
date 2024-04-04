<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,net.javaguides.registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<title>User Profile</title>
</head>
<body>
    <h2>User Profile</h2>
    <% 
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null){
    %>
        Welcome, <%= loggedInUser.getUserName() %>!<br>
        Email: <%= loggedInUser.getEmail() %><br>
        User Type: <%= loggedInUser.getUserType() %><br>
        <form action="UserServlet" method="post">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout">
        </form>
    <% 
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>