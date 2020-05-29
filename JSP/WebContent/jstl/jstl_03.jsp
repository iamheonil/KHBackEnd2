<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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

<h1> c:set </h1>

<hr>

<% Map map = new HashMap(); %>

map : ${map } <br><br>

<%-- JSTL을 이용한 Map 객체의 프로퍼티 삽입 (map.put(key, value)) --%>

<c:set target="<%= map %>" property="A" value="Alice"></c:set>
<c:set target="<%= map %>" property="B" value="Bob"></c:set>
<hr>
<br>
A Key : <%=map.get("A") %><br>
<br>
B Key : ${map.B }<br>

<br>
<hr>
<%-- JSTL을 이용한 Map 객체를 Session 컨텍스트 정보로 등록하기 --%>
<c:set var="m" value="<%=map %>" scope="session"></c:set>

m : ${m }<br>

m : ${m.A }<br>
m : ${m.B }<br>

<br>

<hr>

<% out.print( ((Map)request.getSession().getAttribute("m")).get("A") ); %>

<br>
<br>
<hr>

<jsp:useBean id="userBean" class="dto.User"></jsp:useBean>

<jsp:setProperty property="id" name="userBean" value="AAA"/>

<c:set target="${userBean }" property="pwd" value="BBB" />

user : ${userBean } <br>

<br>

<%-- JSTL을 이용하여 자바빈 userBean을 세션정보로 등록하기 --%>
<c:set var="sessionUser" value="${userBean }" scope="session"></c:set> <br>

user 객체 : ${sessionUser }<br>


<Br>

<hr>




<%-- 세션 컨텍스트 정보 삽입(만들기) --%>
<c:set var="sessionData" value="세션데이터입" scope="session" ></c:set>

<a href="./jstl_03_session.jsp"> 세션 확인하기 </a>

<%-- 모든 컨텍스트 영역에서 "sessionData"로 등록된 변수 제거 --%>

<c:remove var="sessionData"/>

<c:remove var="sessionData" scope="session"/>

<% session.removeAttribute("sessionData"); %>

</body>
</html>