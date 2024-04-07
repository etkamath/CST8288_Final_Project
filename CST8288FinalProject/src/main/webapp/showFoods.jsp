<%@ page import="net.javaguides.registration.model.FoodItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  List< FoodItem> foods = (List<FoodItem>) request.getAttribute("foods");

%>

<table>
  <tr>
    <th>Name</th>
    <th>Quantity</th>
    <th>ExpiryDate</th>
    <th>Purchase</th>
  </tr>
  <%

    for (FoodItem foodItem:foods)

    {
out.println("<tr>");
out.println("<td>");
out.println(foodItem.getName());
      out.println("</td>");
      out.println("<td>");

out.println(foodItem.getQuantity());
      out.println("</td>");
      out.println("<td>");

out.println(foodItem.getExpiryDate());
      out.println("</td>");
      out.println("<td>");

      out.println("<form action='ConsumerServlet' method=get>");
        out.println("<input name='id' type='hidden' value='"+foodItem.getItemID()+"' />");
        out.println("<input name='number' type='number' />");

      out.println("<input type='submit'/>");
//out.println("<a href='ConsumerServlet/?id="+foodItem.getItemID()+"'>Purchase</a>");

      out.println("</form>");

      out.println("</td>");
out.println("</tr>");
    }%>


</table>

</body>
</html>
