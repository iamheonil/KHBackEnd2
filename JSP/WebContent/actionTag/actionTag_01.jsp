<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>액션태그 테스트</h1>
	<h3>useBean</h3>
	<h3>setProperty, getProperty</h3>
	<hr>

	<%
	// 1. 스크립트릿을 이용한 객체 생성
	User user1 = new User();
	
	// page 컨텍스트에 user1 객체를 저장
	// pageContext.setAttribute("user1", user1);
	
	// request 컨텍스트에 user1 객체를 저장
	request.setAttribute("user1", user1);
	
	%>


	<%-- 액션태그를 이용한 JavaBean 생성 - page 영역에 생성됨. --%>
	<%-- <jsp:useBean id="user2" class="dto.User" >
	</jsp:useBean> --%>
	
	<%-- 액션태그를 이용한 JavaBean 생성 - Scope 가 Session 이기 때문에 Session 영역에 생성됨. --%>
	<jsp:useBean id="user2" class="dto.User" scope="session" > </jsp:useBean>

	<%-- JavaBean 의 프로퍼티 값 설정하기 --%>
	<jsp:setProperty property="id" name="user1" value="id1" />
	<jsp:setProperty property="pwd" name="user1" value="pwd1" />

	<jsp:setProperty property="id" name="user2" value="id2" />
	<jsp:setProperty property="pwd" name="user2" value="pwd2" />

	<%-- 자바영역의 객체 출력하기 --%>
	user 1 : <%=user1 %><br>
	user 2 : <%=user2 %><br>
	
	<hr>
	
	<%-- pageContext 영역에서 user1, user2 찾아서 출력하기 --%>
	JavaBean 객체 통째로 가져오기<br>
	[Page 컨텍스트] user 1 : <%= pageContext.getAttribute("user1") %> <br>
	[Page 컨텍스트] user 2 : <%= pageContext.getAttribute("user2") %> <br>

	<hr>
	
	<%-- Session 컨텍스트 영역에서 위와 같은 출력 --%>
	<%-- 유효범위는 딱 페이지 까지 --%>
	[Session 컨텍스트] user1 : <%= session.getAttribute("user1") %> <br>
	[Session 컨텍스트] user1 : <%= session.getAttribute("user2") %> <br>
	
	<hr>
	
	user1.id : <%= ((User)request.getAttribute("user1")).getId() %> <br>
	<%-- user1.pw : <jsp:getProperty property="pwd" name="user1"/><br><br> --%>
	<br>
	user2.id : <jsp:getProperty property="id" name="user2"/><br>
	user2.pw : <%= ((User)session.getAttribute("user2")).getPwd() %><br>

	
</body>
</html>