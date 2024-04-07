<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="net.javaguides.registration.model.FoodItem"%>
<%@ page import="net.javaguides.registration.dao.FoodDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Item Quantity</title>
</head>
<body>
    <h2>Update Item Quantity</h2>
    <form action="FoodItemServlet" method="post">
        Item ID:
        <select name="itemId" required>
            <option value="">Select an item...</option>
            <%
                FoodDao foodDao = new FoodDao();
                List<FoodItem> foodItems = foodDao.getAllFoodItems(); // Assumes this method exists and returns a List<FoodItem>
                for(FoodItem item : foodItems) {
                    out.println("<option value=\"" + item.getItemID() + "\">" + item.getName() + " (ID: " + item.getItemID() + ")</option>");
                }
            %>
        </select><br>
        New Quantity: <input type="number" name="newQuantity" required><br>
        <input type="hidden" name="action" value="updateQuantity">
        <input type="submit" value="Update">
    </form>
</body>
</html>
