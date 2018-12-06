<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />
<fmt:setBundle basename="messages" />
<title><fmt:message key="title" /></title>
</head>
<body>
	<h1>
		<fmt:message key="label.student" />
	</h1>
		<h2>Student CRUD Demo</h2>
	
	<c:url var="url" scope="page" value="/StudentForm.jsp">
		<c:param name="name" value="" />
		<c:param name="nickName" value="" />
		<c:param name="nric" value="" />
		<c:param name="mark" value="" />
		<c:param name="insert" value="true" />
	</c:url>
	<a href="${url}"><fmt:message key="label.student.add" /></a>
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><fmt:message key="label.student.index" /></th>
			<th><fmt:message key="label.student.name" /></th>
			<th><fmt:message key="label.student.nickName" /></th>
			<th><fmt:message key="label.student.nric" /></th>
			<th><fmt:message key="label.student.mark" /></th>
			<th><fmt:message key="label.student.edit" /> <fmt:message
					key="label.student.delete" /></th>
		</tr>
		<c:forEach var="student" items="${students}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index}</td>
				<td class="nowrap">${student.name}</td>
				<td class="nowrap">${student.nickName}</td>
				<td class="nowrap">${student.nric}</td>
				<td class="nowrap">${student.mark}</td>
				<td class="nowrap"><c:url var="updurl" scope="page"
						value="/StudentForm.jsp">
						<c:param name="name" value="${student.name}" />
						<c:param name="nickName" value="${student.nickName}" />
						<c:param name="nric" value="${student.nric}" />
						<c:param name="mark" value="${student.mark}" />
						<c:param name="update" value="true" />
					</c:url> 
					<a href="${updurl}">
					<fmt:message key="label.student.edit" />
					</a>
					&nbsp; &nbsp; &nbsp; 
					<c:url var="delurl" scope="page"
						value="/student/delete">
						<c:param name="nric" value="${student.nric}" />
					</c:url> 
					<a href="${delurl}">
					<fmt:message key="label.student.delete" />
					</a>
					
					</td>
			</tr>
		</c:forEach>
	</table>
<body>

</body>
</html>