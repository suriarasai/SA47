<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %><html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title><decorator:title /></title>
<link rel="stylesheet" type="text/css" href="/styles/style.css" />
<decorator:head />
</head>
<body>
	<table class="mainTable" id="page-container" cellpadding="5"
		cellspacing="0" border="1" align="center" width="100%">
		<tr>
			<td colspan="2" id="page-header"><%@ include
					file="/includes/header.jsp"%></td>
		</tr>
		<tr>
			<td id="nav-container" colspan="2"><%@ include
					file="/includes/navigation.jsp"%></td>
		</tr>
		<tr>
			<td id="left-nav-container"><%@ include
					file="/includes/navigationLeft.jsp"%></td>
			<td id="content-container"><decorator:body /></td>
		</tr>
		<tr>
			<td colspan="2" id="page-footer"><%@ include
					file="/includes/footer.jsp"%></td>
		</tr>
	</table>
</body>
</html>

