
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3>User List page</h3>
<a href="${pageContext.request.contextPath}/admin/user/create">Add
	User</a>
<c:if test="${fn:length(userList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.userId" /></th>
				<th><spring:message code="fieldLabel.username" /></th>
				<th><spring:message code="fieldLabel.password" /></th>
				<th><spring:message code="fieldLabel.employeeId" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr class="listRecord">
					<td>${user.userId}</td>
					<td>${user.name}</td>
					<td>${user.password}</td>
					<td>${user.employeeId}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/user/edit/${user.userId}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/user/delete/${user.userId}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>