<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Using EL</h1>

The Student Name is : ${requestScope.student.name} <br/>
The Student Nick Name is : ${requestScope.student.nickName} <br/>
The Student NRIC is : ${requestScope.student.nric} <br/>
The Student marks is : ${requestScope.student.mark} <br/>
The Student dob is : ${ empty requestScope.student.dob ? "Empty" : requestScope.student.dob}



<h1> Using Use Bean</h1>

<jsp:useBean id="student" scope="request" class="model.Student"/>

<jsp:getProperty property="name" name="student"/> <br/>
<jsp:getProperty property="nickName" name="student"/> <br/>
<jsp:getProperty property="nric" name="student"/> <br/>
<jsp:getProperty property="mark" name="student"/> <br/>

</body>
</html>