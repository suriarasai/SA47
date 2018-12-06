<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setBundle basename="messages" />
<c:set var="t" value="true" />
<title><fmt:message key="title"/> </title>
</head>
<body>
<form action="${pageContext.request.contextPath}/process" method=post>
<center>
<table cellpadding=4 cellspacing=2 border=0>
<tr>
<th width="45%">
Description
</th>
<th width="55%">
Detail
</th>
</tr>
<tr>
<td><fmt:message key="setup.name"/>
</td>
<td>
<c:if test="${param['insert']==t}" >
<input type="text" name="name" value="${param['name']}" size=15 maxlength=20>
<input type="hidden" name="ins" value="true" />
</c:if>
<c:if test="${param['update']==t}" >
<input type="text" name="name" value="${param['name']}" size=15 maxlength=20 readonly="readonly">
<input type="hidden" name="ins" value="false" />
</c:if>
</td>
</tr>
<tr>
<td><fmt:message key="setup.description"/>
</td>
<td><input type="text" name="description" value="${param['description']}" size=15 maxlength=20>
</td>
</tr>
<tr>
<td><fmt:message key="setup.play"/>
</td>
<td><input type="text" name="play" value="${param['play']}" size=15 maxlength=20>
</td>
</tr>
</table>
</center>
<input type="submit" value="Submit"> <input type="reset"  value="Reset">
</form>
</body>
</html>