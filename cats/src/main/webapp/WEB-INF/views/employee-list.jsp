
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Employee List page</h3>

<a href="${pageContext.request.contextPath}/admin/employee/create">Add
	Employee</a>
	<c:if test="${fn:length(employeeList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.employeeId" /></th>
				<th><spring:message code="fieldLabel.managerId" /></th>
				<th><spring:message code="fieldLabel.name" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${employeeList}">
				<tr class="listRecord">
					<td>${employee.employeeId}</td>
					<td>${employee.managerId}</td>
					<td>${employee.name}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/employee/edit/${employee.employeeId}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/employee/delete/${employee.employeeId}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
