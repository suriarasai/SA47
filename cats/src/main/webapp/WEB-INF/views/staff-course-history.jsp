<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body>
	<h3>
		Employee Course History
	</h3>
	<c:if test="${fn:length(chistory) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.reference" /></th>
				<th><spring:message code="fieldLabel.name" /></th>
				<th><spring:message code="fieldLabel.courseName" /></th>
				<th><spring:message code="fieldLabel.startDate" /></th>
				<th><spring:message code="fieldLabel.endDate" /></th>
				<th><spring:message code="fieldLabel.fees" /></th>
				<th><spring:message code="fieldLabel.status" /></th>
				<th><spring:message code="fieldLabel.update" /></th>
				<th><spring:message code="fieldLabel.withdraw" /></th>
			</tr>
			<c:forEach var="course" items="${chistory}">
				<tr class="listRecord">
					<td>${course.courseId}</td>
					<td>${course.employeeId}</td>
					<td>${course.courseName}</td>
					<td>${course.fromDate}</td>
					<td>${course.toDate}</td>
					<td>${course.fees}</td>
					<td>${course.status}</td>
					<c:if
						test="${course.status eq 'SUBMITTED' || course.status eq 'UPDATED' }">
						<td><a
							href="${pageContext.request.contextPath}/staff/course/edit/${course.courseId}.html"><spring:message
									code="fieldLabel.update" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/staff/course/withdraw/${course.courseId}.html"><spring:message
									code="fieldLabel.withdraw" /></a></td>
					</c:if>
					<c:if
						test="${course.status eq 'WITHDRAWN' || course.status eq 'APPROVED' ||course.status eq 'REJECTED' }">
						<td></td>
						<td></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>