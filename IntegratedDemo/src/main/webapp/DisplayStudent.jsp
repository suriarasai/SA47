<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudenteDEtail Page</title>
</head>
<body>
<h1> Student Detail Page</h1>
<jsp:useBean id="student" scope="request" class="model.Student"/>

<jsp:getProperty property="name" name="student"/>
<jsp:getProperty property="nickName" name="student"/>
<jsp:getProperty property="nric" name="student"/>
<jsp:getProperty property="mark" name="student"/>

<jsp:useBean id="student2" scope="request" class="model.Student"/>
<jsp:setProperty property="name" name="student2" value="Yawn"/>
<jsp:setProperty property="nickName" name="student2" value="snorlax"/>
<jsp:setProperty property="nric" name="student2" value ="S1234567H"/>
<jsp:setProperty property="mark" name="student2" value="23"/>

<jsp:getProperty property="name" name="student2"/>
<jsp:getProperty property="nickName" name="student2"/>
<jsp:getProperty property="nric" name="student2"/>
<jsp:getProperty property="mark" name="student2"/>

</body>
</html>