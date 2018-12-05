<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<list>
<ul> DATA 1: ${requestScope.D1} </ul>
<ul> DATA 2: ${sessionScope.D2} </ul>    
 <ul> DATA 3:  ${applicationScope.D3} </ul>   
    </list>
</body>
</html>