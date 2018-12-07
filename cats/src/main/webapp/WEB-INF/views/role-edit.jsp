<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Role page</h3>

<form:form method="POST" commandName="role"
	action="${pageContext.request.contextPath}/admin/role/edit/${role.roleId}e.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.roleId" /></td>
				<td><form:input path="roleId" readonly="true" /></td>
				<td><form:errors path="roleId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.roleName" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: red;" /></td>
			</tr>
		<tr>
				<td><spring:message code="fieldLabel.description" /></td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

