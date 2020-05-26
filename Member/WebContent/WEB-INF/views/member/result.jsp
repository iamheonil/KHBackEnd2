<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="dto.Member"%>
<%-- 컨트롤러가 Request 객체에 저장해서 전달한 객체 꺼내기 --%>

<%
	Member m = (Member) request.getAttribute("res");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>결과페이지</h1>
	<hr>

	<table>
		<tr>
			<th>유저번호</th>
			<th>유저아이디</th>
			<th>유저닉네임</th>
			<th>유저이메일</th>
		</tr>

		<tr>
			<td><%=m.getUserno()%></td>
			<td><%=m.getId()%></td>
			<td><%=m.getNickname()%></td>
			<td><%=m.getEmail()%></td>
		</tr>
	</table>
</body>
</html>