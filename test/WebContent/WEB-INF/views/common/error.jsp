<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러페이지</h1>
	<br>
	<hr>

	<h3>${message }</h3>

	<a href="/file/list">파일 목록으로 가기</a>

	<br>

	<!-- history.go 는 JS 객체 -->
	<!-- 그래서 javascript: 를 넣어서 js 객체인것을 브라우저에 알려주는 것. -->
	<a href="javascript:history.go(-1);">이전 페이지로 이동</a>
</body>
</html>