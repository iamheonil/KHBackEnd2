<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<jsp:include page="/basicTag/header.jsp"></jsp:include>

<h1>Action Tag_04 include 액션 확인</h1>
<hr>

<% request.setCharacterEncoding("utf-8"); %>
<% request.setAttribute("requestData", "하하하하ㅏ하핳"); %>

<jsp:include page="./includePage.jsp">

<jsp:param value="안녕! Hello" name="data"/>

</jsp:include>


<br>
<jsp:include page="/basicTag/footer.jsp"></jsp:include>