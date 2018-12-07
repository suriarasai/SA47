<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />

<a href="${pageContext.request.contextPath}/student/create">Add
	Student</a>
<c:if test="${fn:length(students) gt 0}">
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th><s:message code="label.student.index" /></th>
			<th><s:message code="label.student.name" /></th>
			<th><s:message code="label.student.nickName" /></th>
			<th><s:message code="label.student.nric" /></th>
			<th><s:message code="label.student.mark" /></th>
			<th><s:message code="label.student.dob" /></th>
			<th><s:message code="label.student.phoneNumber" /></th>
			<th><s:message code="label.student.email" /></th>
			<th><s:message code="label.student.address" /></th>
			<th><s:message code="label.student.userName" /></th>
			<th><s:message code="label.student.password" /></th>
			<th><s:message code="label.student.edit" /></th>
			<th><s:message code="label.student.delete" /></th>
		</tr>
		<c:forEach var="student" items="${students}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index}</td>
				<td class="nowrap">${student.name}</td>
				<td class="nowrap">${student.nickName}</td>
				<td class="nowrap">${student.nric}</td>
				<td class="nowrap">${student.mark}</td>
				<td class="nowrap"><fmt:formatDate value="${student.dob}" pattern="MM.dd.yyyy" /></td>
				<td class="nowrap">${student.phoneNumber}</td>
				<td class="nowrap">${student.email}</td>
				<td class="nowrap">${student.address}</td>
				<td class="nowrap">${student.userName}</td>
				<td class="nowrap">${student.password}</td>
				<td align="center"><a
					href="${pageContext.request.contextPath}/student/edit/${student.nric}.html">
						<s:message code="label.student.edit" />
				</a></td>
				<td><a
					href="${pageContext.request.contextPath}/student/delete/${student.nric}.html">
					<s:message
							code="label.student.delete" /></a></td>

			</tr>
		</c:forEach>
	</table>
</c:if>