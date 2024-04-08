<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Success</title>
</head>
<body>
    <h2>Update Successful</h2>
    <p>The item's quantity was successfully updated.</p>
    
      <form action="manageFoodItems.jsp" method="get">
        <input type="submit" value="Back to Home">
    </form>
    
        <form action="updateItemQuantity.jsp" method="get">
        <input type="submit" value="Update another item">
    </form>
</body>
</html>
