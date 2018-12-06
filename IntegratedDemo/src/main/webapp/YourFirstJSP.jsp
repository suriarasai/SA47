<%--A JSP that gets a name and displays a welcome message --%>
<%@ page import="java.util.*" %>
<%! static final String message = "Welcome"; %>
<html><body>
<h1>Welcome JSP</h1>
<%
//Get the value of name from request object
String name = request.getParameter("name");
%>
<!--Print out the message with the name -->
<%= message %> <%= name %>
</body></html>