<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Food Item Added</title>
</head>
<body>
    <h2>Food Item Added Successfully!</h2>
    
    <!-- Daha fazla ürün eklemek için buton -->
    <form action="retailerSuccess.jsp" method="get">
        <input type="submit" value="Add More Items">
    </form>
    
    <!-- Çıkış yapmak için buton -->
    <form action="login.jsp" method="get">
        <input type="submit" value="Logout">
    </form>
    
      <form action="manageFoodItems.jsp" method="get">
        <input type="submit" value="Back to Home">
    </form>
    
</body>
</html>