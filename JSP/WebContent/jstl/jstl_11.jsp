<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>fmt:formatDate</h1>
<hr>

<c:set var="now" value="<%=new Date() %>"></c:set>

<br>
<hr>
<br>

now : ${now }

<br>
<hr>
<br>

default : <fmt:formatDate value="${now }" type="date" dateStyle="default"></fmt:formatDate> <br><br>
short : <fmt:formatDate value="${now }" type="date" dateStyle="short"></fmt:formatDate> <br><br>
medium : <fmt:formatDate value="${now }" type="date" dateStyle="medium"></fmt:formatDate> <br><br>
long : <fmt:formatDate value="${now }" type="date" dateStyle="long"></fmt:formatDate> <br><br>
full : <fmt:formatDate value="${now }" type="date" dateStyle="full"></fmt:formatDate> <br><br>

<br>
<hr>
<br>

default : <fmt:formatDate value="${now }" type="time" timeStyle="default"></fmt:formatDate> <br><br>
short : <fmt:formatDate value="${now }" type="time" timeStyle="short"></fmt:formatDate> <br><br>
medium : <fmt:formatDate value="${now }" type="time" timeStyle="medium"></fmt:formatDate> <br><br>
long : <fmt:formatDate value="${now }" type="time" timeStyle="long"></fmt:formatDate> <br><br>
full : <fmt:formatDate value="${now }" type="time" timeStyle="full"></fmt:formatDate> <br><br>

<br>
<hr>
<br>

<fmt:formatDate value="${now }" type="both"/> <br><br>
<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="short" /> <br><br>

<br>
<hr>
<br>

yyyy-MM-dd : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/> <br><br>


HH:mm:ss.S : <fmt:formatDate value="${now }" pattern="HH:mm:ss.S"></fmt:formatDate> <br><br>

<br>
<hr>
<br>

<%-- java.util.Date : 고정된(상수) 시간을 저장 --%>

<%-- java.util.Calendar : 지정된 시간 저장, 저장된 시간을 변경할 수 있음 --%>

<%-- java.util.GregorianCalendar --%>

<c:set var="testTime" value="<%= new GregorianCalendar(2020, 05, 01, 12, 5, 8).getTime() %>"></c:set>

testTime : ${testTime }<br><br>

<br>
<hr>
<br>

<fmt:formatDate value="${testTime }" type="both" />

<br>
<hr>
<br>

KK : <fmt:formatDate value="${testTime }" pattern="KK" />

<br>
<hr>
<br>

a : <fmt:formatDate value="${testTime }" pattern="a" /> <br><br>
z : <fmt:formatDate value="${testTime }" pattern="z" /> <br><br>
Z : <fmt:formatDate value="${testTime }" pattern="Z" /> <br><br>
X : <fmt:formatDate value="${testTime }" pattern="X" /> <br><br>

<br>
<hr>
<br>




</body>
</html>





































