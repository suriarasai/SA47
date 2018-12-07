<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<c:url value="/css/style.css" var="ss"/>
<link rel="STYLESHEET" type="text/css"
	href="${ss}" />
</head>
<body>
<h1> Student CRUD Demo</h1>
<%@include file="Menu.jsp"%>
	<table style="width: 100%">
		<tr>
			<td>
				<div>
					<dec:body />
				</div>
			</td>
		</tr>
	</table>
	
	<!-- ======== Footer ======== -->
				<div id="footer" align="center">
				  <hr>
					<small> &copy; ISS NUS SA47 2018 </small>
				</div>
</body>
</html>
