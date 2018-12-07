<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New User page</h3>
<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/admin/user/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.userId" /></td>
				<td><form:input path="userId" /></td>
				<td><form:errors path="userId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.username" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.password" /></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.employeeId" /></td>
				<td><form:select path="employeeId" items="${eidlist}" /></td>
				<td><form:errors path="employeeId" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

