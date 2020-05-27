<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 현재 JSP 페이지에서 에러처리할 수 있도록 만듬 --%>
<%-- Exception 사용 가능 --%>    
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>쓰앵님 에러페이집니다</h1>
<hr>

<%=exception.getMessage() %>
<%=exception.toString() %>

<br>
<h4> 돌아가주세요. </h4>
</body>
</html>