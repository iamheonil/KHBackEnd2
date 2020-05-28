<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>EL 테스트 03</h1>
<h3>EL의 컨텍스트 정보</h3>
<hr>

<% 

int localData = 100;

pageContext.setAttribute("pageData", 200);
request.setAttribute("requestData", 300);
session.setAttribute("sessionData", 400);
application.setAttribute("applicationData", 500);

%>

<%-- Java 영역(Local Scope)에 만들어진 변수를 EL로 참조할 수 없다 --%>
<%-- 잘 기억해두기! 섞어쓰다보면 혼동이 온당 --%>
localData : ${localData }<br>

<hr>
page : ${pageScope.pageData } <br>
request : ${requestScope.requestData } <br>
session : ${sessionScope.sessionData } <br>
application : ${applicationScope.applicationData } <br>

<hr>
<%-- el의 컨텍스트 정보 내장 객체들은 생략 가능하다 --%>
<%-- 컨텍스트 정보를 page -> request -> session -> application 순으로 찾는다 --%>
page : ${pageData }<br>
request : ${requestData}<br>
session : ${sessionData }<br>
application : ${applicationData }<br>

</body>
</html>