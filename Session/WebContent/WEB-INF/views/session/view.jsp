<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function del() {
		
		location.href = "/session/delete";
	}
</script>

</head>
<body>

	<h1>세션 확인 페이지</h1>
	<hr>
	
	Session ID : <%=session.getId() %> <br><br>
	Session CreationTime : <%=new Date(session.getCreationTime()) %> <br><br>
	Session LastAccessedTime : <%=new Date(session.getLastAccessedTime()) %> <br><br>
	Session MaxInactiveInterval : <%=session.getMaxInactiveInterval() %> <br><br>
	Session isNew : <%=session.isNew() %> <br><br>

	<br>

	<hr>
	<a href="/session/create"><button>세션 생성</button></a>
	<button onclick="del();">세션 삭제</button>

</body>
</html>