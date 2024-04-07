<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.javaguides.registration.model.User"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Retailer Information</title>
</head>
<body>
    <h2>Enter Retailer Information</h2>
    <% 
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null && "Retailer".equals(loggedInUser.getUserType())) {
            // Show form for users of type 'Retailer'.
    %>
        <form action="RetailerServlet" method="post">
            Store Name: <input type="text" name="storeName" required><br>
            Location: <input type="text" name="location" required><br>
            <input type="hidden" name="action" value="createRetailer">
            <input type="submit" value="Submit">
        </form>
    <% 
        } else {
            // If the user is not a Retailer or not logged in, redirect to the login page.
            response.sendRedirect("login.jsp");
        }
    %>
    
    <!-- Logout button to redirect to register.jsp -->
    <form action="login.jsp" method="get">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
