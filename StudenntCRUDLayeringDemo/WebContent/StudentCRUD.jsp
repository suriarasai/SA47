<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />
<title>Student CRUD Page</title>
</head>
<body>
	<h1>Student Demo</h1>
	<h2>Student CRUD Demo</h2>

	<c:url var="url" scope="page" value="/StudentForm.jsp">
		<c:param name="name" value="" />
		<c:param name="nick" value="" />
		<c:param name="id" value="" />
		<c:param name="mid" value="" />
		<c:param name="insert" value="true" />
	</c:url>
	<a href="${url}">Add Student</a>
	<br />
	<br />
	<table class="borderAll">
		<tr>
			<th>Index</th>
			<th>ID</th>
			<th>Student Name</th>
			<th>Student Nick Name</th>
			<th>Mentor Name</th>
			<th>Edit / Delete</th>
		</tr>
		<c:forEach var="student" items="${students}" varStatus="status">
			<tr class="${status.index%2==0?'even':'odd'}">
				<td class="nowrap">${status.index}</td>
				<td class="nowrap">${student.id}</td>
				<td class="nowrap">${student.name}</td>
				<td class="nowrap">${student.nick}</td>
				<td class="nowrap">${student.mentor.mname}</td>
				<td class="nowrap"><c:url var="updurl" scope="page"
						value="/StudentForm.jsp">
						<c:param name="id" value="${student.id}" />
						<c:param name="name" value="${student.name}" />
						<c:param name="nick" value="${student.nick}" />
						<c:param name="mid" value="${student.mentor.id}" />
						<c:param name="update" value="true" />
					</c:url> <a href="${updurl}"> Edit </a> &nbsp; &nbsp; &nbsp; <c:url
						var="delurl" scope="page" value="/student/delete">
						<c:param name="id" value="${student.id}" />
					</c:url> <a href="${delurl}"> Delete </a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>