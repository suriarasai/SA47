<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
	<h3>
		<spring:message code="${title.courseDetailsHistory}" />
	</h3>

	<table>
		<tr>
			<th align="right"><spring:message code="fieldLabel.courseId" /></th>
			<td colspan="3"><c:out value="${course.courseId}" /></td>
		</tr>
		<tr>
			<th align="right"><spring:message code="fieldLabel.courseName" /></th>
			<td colspan="3"><c:out value="${course.courseName}" /></td>
		</tr>
		<tr>
			<th align="right"><spring:message code="fieldLabel.organiser" /></th>
			<td colspan="3"><c:out value="${course.organiser}" /></td>
		</tr>
		<tr>
			<th align="right"><spring:message code="fieldLabel.startDate" /></th>
			<td><fmt:formatDate value="${course.fromDate}"
					pattern="${APPL_DATE_FORMAT}" /></td>
			<th align="right"><spring:message code="fieldLabel.endDate" /></th>
			<td><fmt:formatDate value="${course.toDate}"
					pattern="${APPL_DATE_FORMAT}" /></td>
		</tr>
		<tr>
			<th align="right"><spring:message code="fieldLabel.fees" /></th>
			<td><c:out value="${course.fees}" /></td>
			<th align="right"><spring:message code="fieldLabel.gstIncluded" /></th>
			<td><c:choose>
					<c:when test="${course.gstIncluded}">
						<spring:message code="caption.yes" />
					</c:when>
					<c:otherwise>
						<spring:message code="caption.no" />
					</c:otherwise>
				</c:choose></td>
		</tr>
		<tr>
			<th align="right"><spring:message
					code="fieldLabel.justification" /></th>
			<td colspan="3"><c:out value="${course.justification}" /></td>
		</tr>
		<tr>
			<th align="right"><spring:message code="fieldLabel.status" /></th>
			<td colspan="3"><c:out value="${course.status}" /></td>
		</tr>
	</table>
	<form:form method="POST" modelAttribute="approve"
		action="${pageContext.request.contextPath}/manager/course/edit/${course.courseId}.html">
		<table>
			<tr>
				<td><form:radiobutton path="decision" value="APPROVED" id="decision"/> <spring:message
						code="caption.approve" /> &nbsp;&nbsp; <form:radiobutton
						path="decision" value="REJECTED" id="decision" /> <spring:message
						code="caption.reject" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.managerComment" /><br>
					<form:textarea path="comment" cols="60" rows="4" id="comment"/></td>
			</tr>
		</table>
		<form:button name="submit" type="submit" value="s">
			<img src="${pageContext.request.contextPath}/image/button_submit.gif"
				width="59" height="22" alt="" border="0">
		</form:button>
	</form:form>
</body>
</html>