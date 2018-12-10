
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
</head>

<body>
   <table>
     <tr>
       <td>#</td>
       <td>ID</td>
       <td>NAME</td>
       <td>ADDRESS</td>
       <td>EMAIL</td>
     </tr>
     <c:forEach items="${users}" var="user" varStatus="index">
         <tr>
       <td>${index.index+1}</td>
       <td>${user.id}</td>
       <td>${user.username}</td>
       <td>${user.address}</td>
       <td>${user.email}</td>
     </tr>
     </c:forEach>
   </table>
</body>
</html>