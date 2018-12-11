
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
</head>

<body>
   <a href="${pageContext.request.contextPath}/user/new">Add User</a>
   <c:if test="${fn:length(users) gt 0 }">
   <table>
     <tr>
       <td>#</td>
       <td>ID</td>
       <td>NAME</td>
       <td>ADDRESS</td>
       <td>EMAIL</td>
       <td>EDIT</td>
       <td>DELETE</td>
     </tr>
     <c:forEach items="${users}" var="user" varStatus="index">
         <tr>
       <td>${index.index+1}</td>
       <td>${user.id}</td>
       <td>${user.username}</td>
       <td>${user.address}</td>
       <td>${user.email}</td>
       <td><a href="${pageContext.request.contextPath}/user/edit/${user.id}">Edit User</a></td>
       <td><a href="${pageContext.request.contextPath}/user/delete/${user.id}">Delete User</a></td>
       
     </tr>
     </c:forEach>
   </table>
   </c:if>
</body>
</html>