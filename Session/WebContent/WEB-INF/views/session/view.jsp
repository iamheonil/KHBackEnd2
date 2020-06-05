<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function del() {
		
		location.href = "/logout/delete";
	}
</script>

</head>
<body>

	<h1>세션 확인 페이지</h1>
	<hr>

	test : ${test }
	<br>

	<hr>
	<a href="/session/create"><button>세션 생성</button></a>
	<button onclick="del();">세션 삭제</button>

</body>
</html>