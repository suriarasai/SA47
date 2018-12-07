<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Department page</h3>
<form:form method="POST" modelAttribute="department"
	action="${pageContext.request.contextPath}/admin/department/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.departmentId" /></td>
				<td><form:input path="departmentId" /></td>
				<td><form:errors path="departmentId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.managerId" /></td>
				<td><form:select path="managerInCharge" items="${eidlist}" /></td>
				<td><form:errors path="managerInCharge" cssStyle="color: red;" /></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Create" class="blcass"/></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

