<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>The Student List</h1>
	<table>
		<thead>
			<tr>
			    <td>Index</td>
				<td>Name</td>
				<td>Nick Name</td>
				<td>NRIC</td>
				<td>Marks</td>
			</tr>
		</thead>
		<c:forEach items="${slist}" var="student" varStatus="st">
			<tr>
			    <td>${st.index+1}</td>
				<td>${student.name}</td>
				<td>${student.nickName}</td>
				<td>${student.nric}</td>
				<td>${student.mark}</td>
			</tr>

		</c:forEach>
	</table>
	
	<h2> Hyperlink Demo</h2>
	<c:url var="testlink" value="/YourFirstJSP.jsp">
	   <c:param name="name" value="HUNGRY"/>
	</c:url>
	<a href="${testlink}"> This is my hyperlink </a>

</body>
</html>