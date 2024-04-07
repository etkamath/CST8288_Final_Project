<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Food Items</title>
    <script type="text/javascript">
        function redirectTo(page) {
            window.location.href = page;
        }
    </script>
</head>
<body>
    <h2>Manage Food Items</h2>
    <button type="button" onclick="redirectTo('retailerSuccess.jsp');">Add Food Item</button>
    <button type="button" onclick="redirectTo('updateItemQuantity.jsp');">Update Item Quantity</button>
    <button type="button" onclick="redirectTo('listSurplusItems.jsp');">View Surplus Food Items</button>
</body>
</html>
