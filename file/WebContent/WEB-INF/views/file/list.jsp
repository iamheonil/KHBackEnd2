<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%-- <%
	List<File> List = (List) request.getAttribute("list");
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트 보여주는 페이지 구현</h1>
	<hr>

	<table border="1">

		<tr>
			<th>파일번호</th>
			<th>파일제목</th>
			<th>파일이름</th>
		</tr>

		<c:forEach items="${list }" var="i">

			<tr>
				<td>${i.fileno }</td>
				<td>${i.originName }</td>
				<td>${i.storedName }</td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>