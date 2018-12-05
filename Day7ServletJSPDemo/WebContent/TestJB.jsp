<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="silly" class="javabean.Student" scope="request"/>
 <h3>
 <jsp:getProperty property="name" name="silly"/>
 <!-- looking getName and setName -- name -->
 <br/>
 <jsp:getProperty property="id" name="silly"/>
 </h3>
</body>
</html>