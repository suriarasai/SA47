<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h3>Role List page</h3>
	<a href="${pageContext.request.contextPath}/admin/role/create">Add
		Role</a>
	<c:if test="${fn:length(roleList) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th><spring:message code="fieldLabel.roleId" /></th>
					<th><spring:message code="fieldLabel.roleName" /></th>
					<th><spring:message code="fieldLabel.roleDesc" /></th>
					<th><spring:message code="caption.edit" /></th>
					<th><spring:message code="caption.delete" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="role" items="${roleList}">
					<tr class="listHeading">
						<td>${role.roleId}</td>
						<td>${role.name}</td>
						<td>${role.description}</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/admin/role/edit/${role.roleId}.html"><spring:message
									code="caption.edit" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/role/delete/${role.roleId}.html"><spring:message
									code="caption.detail" /></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>