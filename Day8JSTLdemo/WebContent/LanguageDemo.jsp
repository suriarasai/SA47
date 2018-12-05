<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<fmt:setBundle basename="Messages" />
	<h1>
		<fmt:message key="languagepage.hello">
			<fmt:param value="${el}" />
		</fmt:message>
	</h1>

	<h2>
		<fmt:message key="languagepage.greeting" />
		<br />
		<fmt:message key="languagepage.message">
			<fmt:param value="dd" />
			<fmt:param value="dd" />
		</fmt:message>
		<br />
		<fmt:message key="languagepage.bye" />
		<br />
		<fmt:message key="languagepage.silent" />
	</h2>
</body>
</html>