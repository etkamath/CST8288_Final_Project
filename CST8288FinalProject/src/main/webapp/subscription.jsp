
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Subscription</h1>
<form action="SubscriptionServlet" method="post">
    Preferences: <input type="text" name="pref"><br>
    Location: <input type="text" name="location"><br>
    Contact method:
    <select name="contactmethod">
        <option value="Email">Email</option>
        <option value="Phone">Phone number</option>
    </select>
    <br>
    <input type="submit" value="Subscription">
</form>

</body>
</html>
