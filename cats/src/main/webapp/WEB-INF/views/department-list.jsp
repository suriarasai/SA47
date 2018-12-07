
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Department List page</h3>
<a href="${pageContext.request.contextPath}/admin/department/create">Add
	Department</a>
<c:if test="${fn:length(departmentList) gt 0}">
<table style="cellspacing: 2; cellpadding: 2; border: 1;">

	<tr class="listHeading">
		<th><spring:message code="fieldLabel.departmentId" /></th>
		<th><spring:message code="fieldLabel.managerId" /></th>
		<th><spring:message code="caption.edit" /></th>
		<th><spring:message code="caption.delete" /></th>
	</tr>


	<c:forEach var="department" items="${departmentList}">
		<tr class="listRecord">
			<td align="left">${department.departmentId}</td>
			<td align="left">${department.managerInCharge}</td>
			<td align="center"><a
				href="${pageContext.request.contextPath}/admin/department/edit/${department.departmentId}.html"><spring:message
						code="caption.edit" /></a></td>
			<td><a
				href="${pageContext.request.contextPath}/admin/department/delete/${department.departmentId}.html"><spring:message
						code="caption.delete" /></a></td>
		</tr>
	</c:forEach>

</table>
</c:if>
