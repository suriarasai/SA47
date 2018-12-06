<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
</head>
<body>
	<fmt:setBundle basename="MessagesSample" />
	<h1>
		<fmt:message key="languagepage.hello">
			<fmt:param value="gg" />
		</fmt:message>
	</h1>

	<h2>
		<fmt:message key="languagepage.greeting" />
		<br />
		<fmt:message key="languagepage.message"/>

		<br />
		<fmt:message key="languagepage.bye" />
		<br />

	</h2>
</body>
</html>