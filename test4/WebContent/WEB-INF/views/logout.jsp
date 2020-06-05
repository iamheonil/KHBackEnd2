<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">
	function logout() {
		location.href = "/delete";
	}
</script>

<title>Insert title here</title>
</head>
<body>
	<div>
		<label>${loginUser }님</label>
		<div>
			<button>정보수정</button>
			<button id="logoutBtn" onclick="logout();">로그아웃</button>
		</div>
	</div>
</body>
</html>