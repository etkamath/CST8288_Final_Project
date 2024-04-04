<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Kayıt Formu</h2>
    <form action="UserServlet" method="post">
        Username: <input type="text" name="username" required><br>
        E-mail: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        Kullanıcı Tipi:
        <select name="usertype" required>
            <option value="Retailer">Retailer</option>
            <option value="Consumer">Consumer</option>
            <option value="Charitable Organization">Charitable Organization</option>
        </select><br>
        <input type="hidden" name="action" value="register">
        <input type="submit" value="Register">
    </form>
</body>
</html>