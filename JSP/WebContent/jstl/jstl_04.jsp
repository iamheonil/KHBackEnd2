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

<c:if test="true">

<h3>트루입니다. false는 안 나오겠쥬? c:if test="false" 로 바꿔보세요</h3>

</c:if>

<hr>

false 값 출력<br>

<c:if test="false">

<h3>트루입니다. false는 안 나오겠쥬? c:if test="false" 로 바꿔보세요</h3>

</c:if>

<hr>

<% if(true)  { %>
<h3>True 근데 이건 스크립트릿으로 작성한 거</h3>
<% } %>

<hr>

<c:if test="단순 문자열">
	<h4>단순 문자열을 넣었는데 되나?</h4>
</c:if>
<%-- test 속성은 true, false 만 와야한다. --%>

<hr>

<%-- ${10 eq 10 } --%>

<c:if test="${10 eq 10 } ">
	
	<h3> 10 eq 10 ?</h3>
	<h3> 안됨 </h3>
	
</c:if>

<hr>

<%-- 속성값으로 빈 칸이 들어가지 않도록 조심할 것!! "true " 로 되어서 false 처리된다. --%>

<br>

<%-- 서블릿 Controller 에서 DB 조회 결과를 모델값으로 전달했다. --%>
<%-- request 컨텍스트 영역 사용함 --%>
<% request.setAttribute("userList", null); %>

	<c:if test="${empty userList }">

	<h3>조회 된 데이터가 없습니다.</h3>

	</c:if>
	<table>

		<tr>

			<th>아이디</th>
			<th>닉네임</th>

		</tr>

		<tr>

			<td>${userList[0].id }</td>
			<td>${userList[0].pwd }</td>

		</tr>

	</table>



















</body>
</html>