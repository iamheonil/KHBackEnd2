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

	<h1>로그인 요청 폼</h1>

	로그인 중인가? : <%=session.getAttribute("login")%>

	<br>
	<br>
	<c:if test="${empty login }">
		<form action="/login" method="POST">

			<label>아이디 : <input type="text" name="uid"></label> <br>
			<br> <label>비밀번호 : <input type="text" name="upwd"></label><br>
			<br>

			<button>전송하기</button>
		</form>
	</c:if>
	<hr>



	<c:if test="${not empty login }">
		<a href="/logout">로그아웃하기</a>
	</c:if>

</body>
</html>