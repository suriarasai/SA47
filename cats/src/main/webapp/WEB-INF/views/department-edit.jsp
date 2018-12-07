<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Department page</h3>
<form:form method="POST" modelAttribute="department"
	action="${pageContext.request.contextPath}/admin/department/edit/${department.departmentId}.html">
	
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.departmentId" /></td>
				<td><form:input path="departmentId" readonly="true" /></td>
				<td><form:errors path="departmentId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.managerId" /></td>
				<td><form:select path="managerInCharge" items="${eidlist}" /></td>
				<td><form:errors path="managerInCharge" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" class="blcass"/></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

