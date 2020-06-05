<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="logout.*"%>
<%
 Member loginUser = (Member)session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
  <div>
   <label>홍길동님</label>
   <div>
    <button>정보수정</button>
    <button id="logoutBtn" onclick="logout();">로그아웃</button>
   </div>
  </div>
</body>
</html>