<%@ page import="java.util.List"%>
<%@ page import="net.javaguides.registration.model.FoodItem"%>
<%@ page import="net.javaguides.registration.dao.FoodDao"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Surplus Food Items</title>
</head>
<body>
<h2>Surplus Food Items for Donation or Sale</h2>
<%
    FoodDao dao = new FoodDao();
    List<FoodItem> surplusItems = dao.getSurplusFoodItems();
    for(FoodItem item : surplusItems) {
        out.println("<p>" + item.getName() + " - Quantity: " + item.getQuantity() + 
                    " - Type: " + (item.isSurplus() ? item.getSurplusType() : "N/A") + "</p>");
    }
    if(surplusItems.isEmpty()) {
        out.println("<p>No surplus items available.</p>");
    }
%>
</body>
</html>
