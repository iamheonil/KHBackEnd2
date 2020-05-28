<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>

<h3>여기는 서브페이지</h3>
<p>include 된 페이지 영역

<p>전달 파라미터 : <%=request.getParameter("data") %></p>
<p>컨텍스트 : <%=request.getAttribute("requestData") %></p>

</div>
    
    