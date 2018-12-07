<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>
<h3>New Course page</h3>
<form:form method="POST" modelAttribute="course"
	action="${pageContext.request.contextPath}/staff/course/edit/${course.courseId}.html">
	<form:hidden path="courseId" />
	<form:hidden path="employeeId" />
	<form:hidden path="status" />
	<table>
		<tr>
			<td><spring:message code="fieldLabel.courseName" /></td>
			<td colspan="3"><form:input size="40" path="courseName" /> <form:errors
					path="courseName" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.organiser" /></td>
			<td colspan="3"><form:input size="40" path="organiser" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.startDate" /></td>
			<td><form:input size="16" path="fromDate" type="date"
					id="datepicker1" />
				<form:errors path="fromDate" cssStyle="color: red;" /></td>
			<td><spring:message code="fieldLabel.endDate" /></td>
			<td><form:input size="16" path="toDate" type="date"
					id="datepicker2" /> <form:errors path="toDate"
					cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.fees" /></td>
			<td><form:input size="20" path="fees" /></td>
			<td><spring:message code="fieldLabel.gstIncluded" /></td>
			<td><form:checkbox path="gstIncluded" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.justification" /></td>
			<td colspan="3"><form:textarea cols="64" rows="5"
					path="justification" /></td>
		</tr>
		<tr>
			<td><spring:message code="fieldLabel.status" /></td>
			<td><form:input disabled="true" size="20" path="status" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="2" align="left"><br></br> <form:button
					type="submit">
					<img
						src="${pageContext.request.contextPath}/image/button_submit.gif"
						alt="" align="middle">
				</form:button></td>
		</tr>

	</table>
</form:form>
