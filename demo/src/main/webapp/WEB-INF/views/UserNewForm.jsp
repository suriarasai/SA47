<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
</head>
<body>
  <h1>This is new user page</h1>
  <form:form action="${pageContext.request.contextPath}/user/new.html" method="POST" modelAttribute="user">
    ID: <form:input path="id" size="10" /> <br/>
    Name: <form:input path="username" size="40"/> <br/>
    EMAIL: <form:input path="email" size="50" /> <br/>
    ADDRESS: <form:textarea path="address" size = "200"/> <br/>
    <input type="submit" value ="Submit"/> <br/>
    <input type="reset" value ="Cancel"/> <br/>
  </form:form>
</body>
</html>