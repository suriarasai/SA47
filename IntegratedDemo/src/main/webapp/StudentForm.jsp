<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="messages" />
<c:set var="t" value="true" />
<title><fmt:message key="title" /></title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/student/process" method=post>
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
					<td><fmt:message key="setup.nric" /></td>
					<td><c:if test="${param['insert']=='true'}">
							<input type="text" name="nric" value="" size=15
								maxlength=20 >
							<input type="hidden" name="ins" value="true" />
						</c:if> 
						
						<c:if test="${param['update']=='true'}">
							<input type="text" name="nric" value="${param['nric']}" size=15
								maxlength=20 readonly="readonly">
							<input type="hidden" name="ins" value="false" />
						
						</c:if></td>
				</tr>
				<tr>
					<td><fmt:message key="setup.name" /></td>
					<td><input type="text" name="name" value="${param['name']}"
						size=30 maxlength=50></td>
				</tr>
				<tr>
					<td><fmt:message key="setup.nickName" /></td>
					<td><input type="text" name="nickName"
						value="${param['nickName']}" size=10 maxlength=20></td>
				</tr>
				<tr>
					<td><fmt:message key="setup.mark" /></td>
					<td><input type="text" name="mark" value="${param['mark']}"
						size=15 maxlength=20></td>
				</tr>

			</table>
		</center>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
	</form>
</body>
</html>