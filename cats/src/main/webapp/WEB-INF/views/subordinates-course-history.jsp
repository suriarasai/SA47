<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body>

	<h2>Subordinates Course History Page</h2>

	<c:forEach var="subordinate" items="${submap}">

		<c:if test="${fn:length(subordinate.value) gt 0}">
			<h3>${subordinate.key.name}Course History</h3>


			<table style="cellspacing: 2; cellpadding: 2; border: 1;">
				<tr class="listHeading">
					<th><spring:message code="fieldLabel.reference" /></th>
					<th><spring:message code="fieldLabel.name" /></th>
					<th><spring:message code="fieldLabel.courseName" /></th>
					<th><spring:message code="fieldLabel.startDate" /></th>
					<th><spring:message code="fieldLabel.endDate" /></th>
					<th><spring:message code="fieldLabel.fees" /></th>
					<th><spring:message code="fieldLabel.status" /></th>
				</tr>
				<c:forEach var="course" items="${subordinate.value}">
					<tr class="listRecord">
						<td>${course.courseId}</td>
						<td>${course.employeeId}</td>
						<td>${course.courseName}</td>
						<td>${course.fromDate}</td>
						<td>${course.toDate}</td>
						<td>${course.fees}</td>
						<td>${course.status}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</c:forEach>
</body>
</html>