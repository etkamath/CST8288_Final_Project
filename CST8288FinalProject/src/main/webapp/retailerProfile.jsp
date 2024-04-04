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
            // Retailer türündeki kullanıcı için form göster.
    %>
        <form action="RetailerServlet" method="post">
            Store Name: <input type="text" name="storeName" required><br>
            Location: <input type="text" name="location" required><br>
            <input type="hidden" name="action" value="createRetailer">
            <input type="submit" value="Submit">
        </form>
    <% 
        } else {
            // Eğer kullanıcı Retailer değilse veya oturum açılmamışsa, login sayfasına yönlendir.
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>