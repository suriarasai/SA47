<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Employee page</h3>
<form:form method="POST" modelAttribute="employee"
	action="${pageContext.request.contextPath}/admin/employee/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.employeeId" /></td>
				<td><form:input path="employeeId" /></td>
				<td><form:errors path="employeeId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.managerId" /></td>
				<td><form:select path="managerId">
						<form:option value="" label="...." />
						<form:options items="${eidlist}" />
					</form:select></td>
				<td><form:errors path="managerId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

