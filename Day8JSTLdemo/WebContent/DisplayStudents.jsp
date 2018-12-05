<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Student List</h1>

<table border="1">
<tr>
<th> # </th>
<th> Student ID </th>
<th> Student Name </th>
<th> Nick Name </th>
</tr>

<c:forEach var="student" varStatus="idx" items="${slist}">

<tr>
<td> # </td>
<td> ${student.} </td>
<td> ${student.} </td>
<td> ${student.} </td>


</tr>
</c:forEach>

</table>

</body>
</html>