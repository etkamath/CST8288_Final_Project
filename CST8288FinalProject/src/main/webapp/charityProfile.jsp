<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,net.javaguides.registration.model.User"%>
<!DOCTYPE html>
<html>
<head>
<title>Charity Profile</title>
</head>
<body>
    <h2>Charity Profile</h2>
    <a href="DonationFoodServlet">Donation Food</a>
    <% 
        // Burada session'dan kullanıcı bilgilerini alıp gösterebilirsiniz.
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null && "Charitable Organization".equals(loggedInUser.getUserType())){
    %>
        Welcome, <%= loggedInUser.getUserName() %>!<br>
        
        <!-- Food Item Bağış Formu -->
        <h3>Donate Food Items</h3>
        <form action="FoodItemServlet" method="post">
            <input type="hidden" name="action" value="donateFoodItem">
            Item Name: <input type="text" name="itemName" required><br>
            Quantity: <input type="number" name="quantity" required min="1"><br>
            Expiry Date: <input type="date" name="expiryDate" required><br>
            <input type="submit" value="Donate">
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