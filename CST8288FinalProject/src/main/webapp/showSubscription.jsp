<%@ page import="net.javaguides.registration.model.Subscription" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Subscription</title>
</head>
<body>
<%
Subscription subscription= (Subscription) request.getAttribute("sub");
if(subscription!=null){
  out.println("<p>Location: "+subscription.getLocation()+"</p>");
  out.println("<br><p>Subscription ID: "+subscription.getSubscriptionID()+"</p>");
  out.println("<br><p>Preferences: "+subscription.getPreferences()+"</p>");
  out.println("<br><p>Contact Method:"+subscription.getContactMethod()+"</p>");
}
%>
<br>
<a href="consumerProfile.jsp">Profile</a>
</body>
</html>
