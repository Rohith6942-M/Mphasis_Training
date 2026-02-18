<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="age" scope="session" value="${50}"></c:set>
	<c:out value="${age}"></c:out>
	<c:if test="${ age > 18 }">
	<c:out value="age is valid"></c:out></c:if>
	<c:choose>
	<c:when test="${age >= 18}">
	<c:out value="eligible for voter id"></c:out></c:when>
	<c:otherwise><c:out value="not eligible"></c:out>
	</c:otherwise>
	</c:choose>
	<br>
	<c:forEach var="dt" begin="1" end="10">
	<c:out value="${dt}"></c:out><br>
	</c:forEach>
	<c:set var="cdate" value="<%= new Date()%>"></c:set>
	<c:out value="${cdate}"></c:out>
	<c:set var="cdate" value="<%= new Date()%>"></c:set>
	<c:out value="${cdate}"></c:out>
	<h1>Date Time format</h1>
	<h3>
		Time: <fmt:formatDate type="time" value="${cdate}"/>
	</h3>
	<h3>
		Date: <fmt:formatDate type="date" value="${cdate}"/>
	</h3>
	<h3>
		Date & Time: <fmt:formatDate type="both" value="${cdate}"/>
	</h3>
	<h3>
		Date & Time Short: <fmt:formatDate type="both" dateStyle="short" value="${cdate}"/>
	</h3>
	
</body>
</html>