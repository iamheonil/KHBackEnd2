<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>EL 테스트 04</h1>
<h3>EL Parameter 정보</h3>

<hr>

${param }
<hr>

<h3>표현언어</h3>
id : ${param.id } <br>
pw : ${param.pw } <br>

<hr>

<h3>표현식</h3>
id : <%= request.getParameter("id") %><br>
pwd : <%= request.getParameter("pwd") %><br>

<hr>
<h3>스크립트릿</h3>
id : <% out.print(request.getParameter("id")); %><br>
pwd : <% out.print(request.getParameter("pwd")); %><br>

<hr>
<h3>paramValues</h3>
${paramValues }<br>
<br>
${paramValues.pwd[0] }<br>
Null Test : ${paramValues.pwd[1] }<br>
</body>
</html>