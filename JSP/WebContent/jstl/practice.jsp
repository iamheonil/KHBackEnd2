<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="may" value="<%= new GregorianCalendar(2020, 04, 12, 15, 13, 57).getTime() %>"></c:set>
<c:set var="today" value="<%= new GregorianCalendar(2020, 05, 01, 10, 43, 57).getTime() %>"></c:set>
<c:set var="now" value="<%= new Date() %>"></c:set>

may : ${may } <br><br>
today : ${today } <br><br>
now : ${now } <br><br>

<hr>
<br>

<c:if test="${now > may }" var="test" scope="session">

	기준날짜보다 이전 날이면 연-월-일<br>
	<fmt:formatDate value="${may }" type="date" dateStyle="short" pattern="yyyy-MM-dd"/>
	

</c:if>

<hr>
<br>

<fmt:formatDate var="todayfmt" value="${today }" type="date" dateStyle="short"/>
<fmt:formatDate var="nowfmt" value="${now }" type="date" dateStyle="short"/>

<c:if test="${nowfmt eq todayfmt}" var="test2" scope="session">
	
	기준 날짜와 같은 날이면 시:분으로 출력 <br>
	<fmt:formatDate value="${today }" type="time" pattern="HH:mm"/>
	

</c:if>

<%-- ${todayfmt } <br>
${nowfmt } <br> --%>


</body>
</html>





























