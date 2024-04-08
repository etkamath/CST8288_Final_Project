<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Failure</title>
</head>
<body>
    <h2>Update Failed</h2>
    <p>There was a problem updating the item's quantity. Please try again.</p>
    
      <form action="manageFoodItems.jsp" method="get">
        <input type="submit" value="Back to Home">
    </form>
    
        <form action="updateItemQuantity.jsp" method="get">
        <input type="submit" value="Try to update another item">
    </form>
</body>
</html>
