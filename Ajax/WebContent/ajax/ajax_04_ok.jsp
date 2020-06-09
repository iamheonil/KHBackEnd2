<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="name" value="${param.username }" />
<c:set var="content" value="${param.content }" />


<div>
<br>
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= <br>
name : ${name }	<br>
content : ${content }	<br>
<br>
${name }님, ${content }	<br>
<br>
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
<br>
</div>