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
		<fmt:message key="label.user" />
	</h1>
	<c:url var="url" scope="page" value="/views/UserForm.jsp">
		<c:param name="name" value="" />
		<c:param name="password" value="" />
		<c:param name="role" value="" />
		<c:param name="mid" value="" />
		<c:param name="insert" value="true"/>
	</c:url>
	<a href="${url}"><fmt:message key="label.user.add" /></a>
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><fmt:message key="label.user.id" /></th>
			<th><fmt:message key="label.user.name" /></th>
			<th><fmt:message key="label.user.password" /></th>
			<th><fmt:message key="label.user.role" /></th>
			<th><fmt:message key="label.user.mid" /></th>
			<th><fmt:message key="label.user.edit" /> <fmt:message
					key="label.user.delete" /></th>
		</tr>
		<c:forEach var="user" items="${users}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${user.userId}</td>
				<td class="nowrap">${user.name}</td>
				<td class="nowrap">${user.password}</td>
				<td class="nowrap">${user.role}</td>
				<td class="nowrap">${user.mgrId}</td>
				<td class="nowrap"><c:url var="updurl" scope="page"
						value="/views/UserForm.jsp">
						<c:param name="name" value="${user.name}" />
						<c:param name="password" value="${user.password}" />
						<c:param name="role" value="${user.role}" />
						<c:param name="mid" value="${user.mgrId}" />
						<c:param name="update" value="true" />
					</c:url> <a href="${updurl}"><fmt:message key="label.user.edit" /></a>
					&nbsp;&nbsp;&nbsp; <c:url var="delurl" scope="page"
						value="/user/delete">
						<c:param name="name" value="${user.name}" />
					</c:url> <a href="${delurl}"><fmt:message key="label.user.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
<body>

</body>
</html>