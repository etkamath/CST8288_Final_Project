<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="net.javaguides.registration.model.User"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Retailer Success Page</title>
</head>
<body>
    <h2>Add Food Item</h2>
    <% 
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser != null && "Retailer".equals(loggedInUser.getUserType())) {
            // Retailer türündeki kullanıcı için form göster.
    %>
        <h3>Add Food Item</h3>
    <p>Discount 0 means  donation and above 0 means  sale at reduced price
    </p>

        <form action="FoodItemServlet" method="post">
            Item Name: <input type="text" name="name" required><br>
            Quantity: <input type="number" name="quantity" required min="1"><br>
            Expiry Date: <input type="date" name="expiryDate" required><br>
            Is Surplus: 
            <select name="isSurplus">
                <option value="true">Yes</option>
                <option value="false" selected>No</option>
            </select><br>

            Discount: <input type="number" name="discount"/> <br>
            <input type="hidden" name="action" value="createFood">
            <input type="submit" value="Add Food Item">
        </form>
    <% 
        } else {
            // Eğer kullanıcı Retailer değilse veya oturum açılmamışsa, login sayfasına yönlendir.
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>