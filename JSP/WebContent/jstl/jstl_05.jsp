<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>c:choose</h1>
<h3>form 전송 페이지</h3>
<hr>

<form action="./jstl_05_choose.jsp" method="get">

<select name="sel">
	<option value="0" selected="selected">선택해주세요</option>
	<option>1</option>
	<option>2</option>
	<option>3</option>
</select>

<button>전송</button>

</form>


</body>
</html>