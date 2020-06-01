<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/basicTag/header.jsp"></c:import>

<h1> Import </h1>
<hr>
<%-- <c:import url="https://www.naver.com"></c:import> --%>

<%-- <c:import url="https://www.youtube.com"></c:import> --%>

<%-- <c:import url="https://search.naver.com/search.naver?">
	<c:param name="query" value="Cash"></c:param>	
</c:import>
 --%>

<hr>

<c:redirect url="https://google.com"></c:redirect>

<c:import url="/basicTag/footer.jsp"></c:import>
