<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />
<c:set var="t" value="true" />
<title>Student Form</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/student/process"
		method=post>
		<table border=1>
			<tr>
				<th width="45%">Description</th>
				<th width="55%">Detail</th>
			</tr>
			<tr>
				<td>ID</td>
				<td><c:if test="${param['insert']=='true'}">
						<input type="text" name="id" value="" size=15 maxlength=20>
						<input type="hidden" name="ins" value="true" />
					</c:if> <c:if test="${param['update']=='true'}">
						<input type="text" name="id" value="${param['id']}" size=15
							maxlength=20 readonly="readonly">
						<input type="hidden" name="ins" value="false" />

					</c:if></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${param['name']}"
					size=30 maxlength=50></td>
			</tr>
			<tr>
				<td>NICK NAME</td>
				<td><input type="text" name="nick" value="${param['nick']}"
					size=10 maxlength=20></td>
			</tr>
			<tr>
				<td>Mentor ID</td>
				<td><input type="text" name="mid" value="${param['mid']}"
					size=15 maxlength=20></td>
			</tr>

		</table>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
	</form>
</body>
</html>