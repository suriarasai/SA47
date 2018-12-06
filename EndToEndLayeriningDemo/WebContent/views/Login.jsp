<html>
<link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
<head>

</head>
<body>

<h1 align="center"> My Precious Login Page</h1>
    <form action="${pageContext.request.contextPath}/login" method="post" style="">
   
	<table > 
		<tr>
			<td width="35%">User Name:</td>
			<td><input type="text" name="username" size=25 maxlength=30>
			</td>
		</tr>
		<tr>
			<td width="35%">User Password:</td>
			<td><input type="text" name="password" size=25 maxlength=30>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="SUBMIT">
			</td>
		</tr>

	</table>
	</form>
	</body>
</html>