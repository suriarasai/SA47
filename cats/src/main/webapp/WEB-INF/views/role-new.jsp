<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Role page</h3>
<form:form method="POST" commandName="role"
	action="${pageContext.request.contextPath}/admin/role/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.roleId" /></td>
				<td><form:input path="roleId" /></td>
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
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

