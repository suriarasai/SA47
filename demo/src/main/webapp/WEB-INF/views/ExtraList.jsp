<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1> Extra - Many to Many Relationship</h1>
 <h2> Join Table has additional columns.</h2>
 <h2> Lecturer Oogway teaches:
 </h2>
 <c:if test="${fn:length(clist) gt 0}">
  <table>
     <tr> <th>Code</th> <th>Name</th> <th>Lecturer</th></tr>
     <c:forEach items="${clist}" var="course">
     <tr> <td> ${course.courseCode} </td> 
          <td> ${course.courseName}  </td> 
          <td> ${course.lecturer.name} </td></tr>
     </c:forEach>
  </table>
 </c:if>
 <br/> <br/>
 <h2> Students taking course cid 1 :
 </h2>
 <c:if test="${fn:length(slist) gt 0}">
  <table>
     <tr> <th>NRIC</th> <th>Name</th> <th>Nick Name</th></tr>
     <c:forEach items="${slist}" var="student">
     <tr> <td> ${student.nric} </td> 
          <td> ${student.name}  </td> 
          <td> ${student.nickName} </td></tr>
     </c:forEach>
  </table>
 </c:if>
  <h2> Student grades for cid 5 :
 </h2>
 <c:if test="${fn:length(elist) gt 0}">
  <table>
     <tr> <th>Course Name</th> <th>Student Name</th> <th>Grade</th> <th>Mark</th></tr>
     <c:forEach items="${elist}" var="enrolment">
     <tr> <td> ${enrolment.course.courseName} </td> 
          <td> ${enrolment.student.name}  </td> 
          <td> ${enrolment.grade} </td>
          <td> ${enrolment.mark} </td>
          </tr>
     </c:forEach>
  </table>
 </c:if>
</body>
</html>