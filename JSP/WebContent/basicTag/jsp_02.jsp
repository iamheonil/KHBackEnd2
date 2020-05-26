<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%-- 선언 해보기 --%>

<%-- 접근제한자를 사용하여 변수 선언 가능 --%>
<%!private int age = 11;%>


<%-- 멤버필드에 추가 될 것이고 --%>
<%!String name = "Alice";%>


<%-- _jspService() 메소드의 지역 변수로 추가 된다. --%>
<%
	String hobby = "Soccer";
%>


<%-- 메소드 정의 --%>
<%!public void method() {
	System.out.println("Hello " + name);
}%>


<%-- 메소두 호출하기 --%>
<% method(); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>