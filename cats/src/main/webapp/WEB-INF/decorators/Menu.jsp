<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/logout" var="logout" />
<ul>
	<c:if test="${sessionScope.USERSESSION.user.roleSet.size() gt 0}">
		<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
			<c:choose>
				<c:when test="${role.roleId eq 'admin' }">

					<li><spring:url value="/admin/user/list" var="ulist"
							htmlEscape="true" /> <a href="${ulist}"> <spring:message
								code="menu.admin.ulist" />
					</a></li>
					<li><spring:url value="/admin/role/list" var="rlist"
							htmlEscape="true" /> <a href="${rlist}"> <spring:message
								code="menu.admin.rlist" />
					</a></li>
					<li><spring:url value="/admin/employee/list" var="elist"
							htmlEscape="true" /> <a href="${elist}"> <spring:message
								code="menu.admin.elist" />
					</a></li>
					<li><spring:url value="/admin/department/list" var="dlist"
							htmlEscape="true" /> <a href="${dlist}"> <spring:message
								code="menu.admin.dlist" />
					</a></li>

				</c:when>
				<c:when test="${role.roleId eq 'manager' }">
					<li><spring:url value="/manager/pending" var="pending"
							htmlEscape="true" /> <a href="${pending}"> <spring:message
								code="menu.coursesForApproval" />
					</a></li>
					<li><spring:url value="/manager/shistory" var="shistory"
							htmlEscape="true" /> <a href="${shistory}"> <spring:message
								code="menu.subordinateHistory" />
					</a></li>
					
				</c:when>
				<c:when test="${role.roleId eq 'staff' }">
					<li><spring:url value="/staff/history" var="phistory"
							htmlEscape="true" /> <a href="${phistory}"> <spring:message
								code="menu.personalHistory" />
					</a></li>
					<li><spring:url value="/staff/course/create" var="apply"
							htmlEscape="true" /> <a href="${apply}"> <spring:message
								code="menu.courseSubmit" />
					</a></li>
					<li><spring:url value="/staff/logout" var="logout"
							htmlEscape="true" /> <a href="${logout}"> <spring:message
								code="menu.logout" />
					</a></li>

				</c:when>
			</c:choose>

		</c:forEach>
	</c:if>

</ul>

