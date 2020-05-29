

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

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


<style type="text/css">
div {
	text-align: center;
}

div.result {
	
}

div[id^=res] {
	border: 1px solid #ccc;
	width: 130px;
	display: inline-block;
	margin: 0 5px;
	padding: 6px 0;
}

div[id^=res]:hover {
	background: skyblue;
}

#gugudan {
	min-width: 960px;
}
</style>


</head>
<body>

	<h1>c:forEach</h1>
	<hr>

	<h3>c:forEach 구문</h3>

	<c:forEach var="i" begin="1" end="10">

		<h3>${i }</h3>

	</c:forEach>

	<hr>


	<%-- 1~100 까지의 합 --%>

	<c:set var="total" value="0">
	</c:set>

	<c:forEach var="i" begin="1" end="100">

		<c:set var="total" value="${total + i }"></c:set>
	</c:forEach>
	
	<h3>1~100까지의 합 : ${total } </h3>
	
	
	<br>
	<hr>
	
	<%-- 2~9까지 구구단 --%>
	
<%-- 	정신차려 정신!!
<c:set var="res" value="0" />
	<c:set var="f" value="2" />
	<c:set var="b" value="1" />
	<c:forEach var="x" begin="1" end="8" step="1">
		<c:forEach var="i" begin="1" end="9" step="1">

			<c:set var="res" value="${f * b }"></c:set>


			<c:set var="b" value="${b + 1 }" />


			
		</c:forEach>
		<h3> ${f } 의 값 : ${res } </h3>
		<c:set var="f" value="${f + 1 }" />
	</c:forEach> 
	
	--%>

	<div id=gugudan>
		<c:forEach var="i" begin="1" end="9">
		<div>
			<c:forEach var="j" begin="2" end="9">
			<div class="result" id="res${j }${i }">
				<c:out value="${j } * ${i } = ${i*j }" />
			</div>
			</c:forEach>
		</div>
		</c:forEach>
	</div>




<hr>

<h3>c:forEach 를 Iterator로 활용하기</h3>


<% Map<Integer, String> map = new HashMap<>(); %>
<% map.put(1, "Apple"); %>
<% map.put(2, "Banana"); %>
<% map.put(3, "Cherry"); %>

<br>

<c:forEach var="iter" items="<%= map %>">

	${iter }<br>
	${iter.key } : ${iter.value } <br>
	----------- <br>

</c:forEach>

<hr>

	<table border="1">


		<tr>
			<th>키</th>
			<th>밸류</th>
		</tr>

		<c:forEach var="iter" items="<%=map %>">
			<tr>
				<td>${iter.key }</td>
				<td>${iter.value }</td>
			</tr>
		</c:forEach>
	</table>


<hr>

<br>

<%

	List<String> list = new ArrayList<>();

	list.add("Alice");
	list.add("Bob");
	list.add("Clare");
	list.add("Dave");
	list.add("Edward");
	

%>


<c:forEach var="iter" items="<%=list %>" begin="0" end="4" step="2" varStatus="stat">


	<c:if test="${stat.first }">
		<span style="color:red; font-size:8px;">첫번째 반복입니다.</span><br>
	</c:if>
	
	iter : ${iter }<br>
	반복 중 현재 인덱스 : ${stat.index }<br>
	반복 중 현재 횟수 : ${stat.count }<br>

	first : ${stat.first }<br>
	last : ${stat.last }<br>
	step : ${stat.step }<br>

	<c:if test="${not stat.last }">
	------------------<br>
	</c:if>
	<c:if test="${stat.last }" >
		<span style="color:red; font-size:8px;"> 마지막 반복입니다. </span><br>
	</c:if>

</c:forEach>










</body>
</html>