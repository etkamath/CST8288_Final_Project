<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,net.javaguides.registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<title>Charity Profile</title>
</head>
<body>
    <h2>Charity Profile</h2>
    <% 
        // Burada session'dan kullanıcı bilgilerini alıp gösterebilirsiniz.
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null && "Charitable Organization".equals(loggedInUser.getUserType())){
    %>
        Welcome, <%= loggedInUser.getUserName() %>!<br>
        
        <!-- Food Item Bağış Formu -->
        <h3>Charitable Organization Information</h3>
        <form action="CharityServlet" method="post">
    Organization Name: <input type="text" name="organizationName" required><br>
    Location: <input type="text" name="location" required><br>
    <input type="hidden" name="action" value="createCharitableOrganization">
    <input type="submit" value="Save">
</form>
        
        <form action="UserServlet" method="post">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout">
        </form>
    <% 
        } else {
            // Eğer kullanıcı doğru tipte değilse ya da oturum açmamışsa, login sayfasına yönlendir.
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>