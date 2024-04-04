<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>
    <h2>Login Here</h2>
    <form action="UserServlet" method="post">
        Name: <input type="text" name="username"><br>
        Email: <input type="email" name="email"><br>
        Password: <input type="password" name="password"><br>
        User Type: 
        <select name="usertype">
            <option value="Retailer">Retailer</option>
            <option value="Consumer">Consumer</option>
            <option value="Charitable Organization">Charitable Organization</option>
        </select><br>
        <input type="hidden" name="action" value="login">
        <input type="submit" value="Login">
    </form>
</body>
</html>