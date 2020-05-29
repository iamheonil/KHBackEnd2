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


<h1>c:out</h1>
<hr>

<c:out value="1+1 숫자는 안되고 안녕 HELLO 같은 문자만"></c:out><br>
그럴 일 없지만
<hr>

el Data : 
<c:out value="${eldata }" default="null 이기때문에 출력함 default"></c:out> <br>

empty Data : 
<c:out value="${empty eldata }"></c:out><br>
<hr>


<%-- 근데 아래와 같은거는 "" 안에 null 이 들어가 있기 때문에 빈 값이 아니라 문자열이 들어가 있는거 --%>
<c:out value="null" default="null 값이기 때문에 출력한다. Defalut 태그"></c:out> <br>

<%-- 아래는 찐 null 값 --%>
<c:out value="${null }" default="null 값이기 때문에 출력"> </c:out> <br>

<c:out value="${eldata }" default="null 값이기 때문에 출력"> </c:out> <br>

<c:out value="<%=null %>" default="null 값이기 때문에 출력"></c:out><br>

<hr>

<%-- innerText 와 비슷한 동작, 태그가 반영되지 않는다. --%>
<c:out value="<h3>태그출력</h3>"> </c:out>

<%-- 하지만 escapeXml 값을 false 로 설정하면 태그가 반영된다. --%>
<c:out value="<h3>태그출력</h3>" escapeXml="false"> </c:out>


<%="<h3>태그 출력</h3>" %>
<hr>
&laquo; <br>

&raquo; <br>

&larr; <br>

&rarr; <br>

<br>
<hr>

<% String str = "테스트 문자열"; // Java 영역 변수 %>

str 출력 : <c:out value="${str }"></c:out> <br>

str 출력 : <c:out value="${pageScope.str }"></c:out> <br>

str 출력 : <c:out value="<%=str %>"></c:out> <br>

<%-- 스크립트릿은 JSTL의 속성값으로 적용되지 않는다. --%>
<%-- EL과 Expression을 주로 사용해야한다. --%>

str 출력 : <c:out value="<% out.print(str); %>"></c:out> <br>

<hr>

<% request.setAttribute("s", str); // request 컨텍스트 영역에 추가 %>

str 출력 : <c:out value="${s }"></c:out> <br>

str 출력 : <c:out value="${requestScope.s }"></c:out> <br>

<%-- str 출력 : <c:out value="<%=str %>"></c:out> <br> --%>

</body>
</html>