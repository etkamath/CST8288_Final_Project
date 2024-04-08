<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="net.javaguides.registration.model.FoodItem"%>
<%@ page import="net.javaguides.registration.dao.FoodDao"%>
<!DOCTYPE html>
<html>
<head>
    <title>Charity Page</title>
</head>
<body>

<h2>Place an Order</h2>

<form action="TransactionServlet" method="post">
    Select Food Item:
    <select name="itemID">
        <% 
            FoodDao foodItemDao = new FoodDao();
            List<FoodItem> foodItems = foodItemDao.getAllFoodItems();
            for (FoodItem item : foodItems) {
        %>
            <option value="<%= item.getItemID() %>"><%= item.getName() %></option>
        <% 
            }
        %>
    </select><br>
    
    Address: <input type="text" name="address" required><br>
    Phone Number: <input type="text" name="phoneNumber" required><br>
    Name: <input type="text" name="name" required><br> 
    Quantity: <input type="number" name="quantity" min="1" required><br>
    Delivery Date: <input type="date" name="deliveryDate" required><br>
    
    <input type="submit" value="Place Order">
</form>

</body>
</html>
