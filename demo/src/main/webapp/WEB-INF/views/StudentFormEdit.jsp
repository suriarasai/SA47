<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet"
	type="text/css" />
</head>
<body>

<form:form method="POST" modelAttribute="student"
	action="${pageContext.request.contextPath}/student/edit/${student.nric}.html">
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th width="45%">Description</th>
					<th width="55%">Detail</th>
				</tr>
				<tr>
				   <td><s:message code="label.student.name" /> *</td>
				   <td><form:input path="name"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.nickName" /></td>
				   <td><form:input path="nickName"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.nric" /> * Readonly</td>
				   <td><form:input path="nric" readonly="true"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.mark" /></td>
				   <td><form:input path="mark"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.dob" /></td>
				   <td><form:input path="dob"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.phoneNumber" /></td>
				   <td><form:input path="phoneNumber"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.email" /></td>
				   <td><form:input path="email"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.address" /></td>
				   <td><form:input path="address"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.userName" /></td>
				   <td><form:input path="userName"/></td>
				 </tr>
				<tr>
				   <td><s:message code="label.student.password" /></td>
				   <td><form:input path="password"/></td>
				 </tr>
				 <tr>
				 <td><input type="submit" value="Submit"> </td>
				 <td><input type="reset" value="Reset"></td>
				 </tr>
		</table>
		</center>
	
	</form:form>
</body>
</html>