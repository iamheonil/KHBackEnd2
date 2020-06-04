<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>쿠키 확인</h1>
	<hr>

	${cookie }
	<br><br>
	
	${cookie.PASS }
	<br><br>
	
	${cookie.PASS.value }
	<br><br>

	<hr>
	<% Cookie[] arr = request.getCookies(); 
	
		for(int i = 0; i < arr.length; i++) {	%>
		
			<%= arr[i].getName() %> = <%=arr[i].getValue() %><br>
		
	<% } %>
	
	<hr>
	<a href="/cookie/create"><button>쿠키 생성</button></a>
	<a href="/cookie/update"><button>쿠키 수정</button></a>
	<a href="/cookie/delete"><button>쿠키 삭제</button></a>
	

</body>
</html>