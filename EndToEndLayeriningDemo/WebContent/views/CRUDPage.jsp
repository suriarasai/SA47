<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="<c:url value='/styles/style.css'/>" rel="stylesheet" type="text/css"/>
<fmt:setBundle basename="messages" />
<title> <fmt:message key="title"/> </title>
</head>
<body>
        <h1><fmt:message key="label.hero"/></h1>
        <c:url var="url" scope="page" value="/views/SetUpPage.jsp">
        		<c:param name="name" value=""/>
                <c:param name="description" value=""/>
                <c:param name="play" value=""/>
                <c:param name="insert" value="true"/>
        </c:url>
        <a href="${url}"><fmt:message key="label.hero.add"/></a>
        <br/><br/>
        <table class="borderAll">
            <tr>
               <th>#</th>
                <th><fmt:message key="label.hero.name"/></th>
                <th><fmt:message key="label.hero.description"/></th>
                <th><fmt:message key="label.hero.play"/></th>
                <th><fmt:message key="label.hero.edit"/> <fmt:message key="label.hero.delete"/></th>
            </tr>
            <c:forEach var="hero" items="${heros}" varStatus="status">
                <tr class="${status.index%2==0?'even':'odd'}">
                     <td class="nowrap">${status.index + 1}</td>
                    <td class="nowrap">${hero.name}</td>
                    <td class="nowrap">${hero.description}</td>
                    <td class="nowrap">${hero.play}</td>
                    <td class="nowrap">
                        <c:url var="updurl" scope="page" value="/views/SetUpPage.jsp">
                            <c:param name="name" value="${hero.name}"/>
                            <c:param name="description" value="${hero.description}"/>
                            <c:param name="play" value="${hero.play}"/>
                             <c:param name="update" value="true"/>
                        </c:url>
                        <a href="${updurl}"><fmt:message key="label.hero.edit"/></a>
                        &nbsp;&nbsp;&nbsp;
                        <c:url var="delurl" scope="page" value="/deleteHero">
                            <c:param name="name" value="${hero.name}"/>
                        </c:url>
                        <a href="${delurl}"><fmt:message key="label.hero.delete"/></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>