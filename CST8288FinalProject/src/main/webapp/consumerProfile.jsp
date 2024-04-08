<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="net.javaguides.registration.model.FoodItem"%>
<%@ page import="net.javaguides.registration.dao.FoodDao"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Place Food Order</title>
</head>
<body>
    <h2>Place Your Order</h2>
    <form action="TransactionServlet" method="post">
        <div>
            <label for="itemID">Select Food Item:</label>
            <select name="itemID" required>
                <option value="">Select an item...</option>
                <%
                    FoodDao foodDao = new FoodDao();
                    List<FoodItem> foodItems = foodDao.getAllFoodItems();
                    for (FoodItem item : foodItems) {
                        out.println("<option value=\"" + item.getItemID() + "\">" + item.getName() + "</option>");
                    }
                %>
            </select>
        </div>
        <div>
            <label for="quantity">Quantity:</label>
            <input type="number" name="quantity" required>
        </div>
        <div>
            <label for="name">Name:</label>
            <input type="text" name="name" required>
        </div>
        <div>
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" name="phoneNumber" required>
        </div>
        <div>
            <label for="address">Address:</label>
            <input type="text" name="address" required>
        </div>
        <div>
            <label for="deliveryDate">Delivery Date:</label>
            <input type="date" name="deliveryDate" required>
        </div>
        <input type="hidden" name="action" value="Place Order">
        <input type="submit" value="Order Now">
    </form>

<br>
    <br>

    <a href="subscription.jsp" >Subscription</a>
    <br>

    <a href="SubscriptionServlet" >Show Subscription</a>
    <br>
    <a href="NotificationServlet" >Show Notifications</a>

</body>
</html>