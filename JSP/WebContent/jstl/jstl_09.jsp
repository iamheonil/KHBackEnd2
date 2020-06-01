<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>c:catch</h1>
	<hr>

	전달 파라미터 확인 : ${param.id }
	<br>

	<c:catch var="e">

		<%
			request.getParameter("id").equals("test");
		%>

	</c:catch>

	<c:if test="${not empty e }">
		발생한 예외객체는? : ${e }<br><br>
		
		파라미터가 없습니다! 확인하세요!<br><br>
		
		아이디가 입력되지 않았습니다!<br><br>
		
		<script type="text/javascript">
		
			alert('아이디 입력하세요!');
			
			var res = prompt("아이디 입력 안했어요!");
			
			console.log(res);
		
		</script>
	</c:if>

</body>
</html>


















