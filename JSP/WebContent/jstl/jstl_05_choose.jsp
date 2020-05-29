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

<h1>c:choose</h1>
<hr>
<h3>전달 파라미터 choose 페이지</h3>

<c:choose>
	
	<c:when test="${param.sel eq 1 }"> 1을 선택하셨습니다 </c:when>
	<c:when test="${param.sel eq 2 }"> 2을 선택하셨습니다 </c:when>
	<c:when test="${param.sel eq 3 }"> 3을 선택하셨습니다 </c:when>

	<c:otherwise>
		값을 제대로 선택해주세요.
	</c:otherwise>
</c:choose>

<h3><a href="./jstl_05.jsp">돌아가기</a></h3>

</body>
</html>