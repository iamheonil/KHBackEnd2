<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>





<%

	int num = 123;

	out.print("브라우저 : " + num);
	
	System.out.println("이클립스 : " + num);
	
%>



<%= "표현식 : " + num %>







<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Ha Ha Ha</h3>
	<hr>

<h1><%="태그안쪽에서도 사용 가능" %></h1>
</body>
</html>