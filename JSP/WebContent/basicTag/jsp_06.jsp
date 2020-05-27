<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/basicTag/header.jsp"%>

<style type="text/css">
#myDiv h2 {
	color: tomato
}
</style>

<script type="text/javascript">

// 해당 페이지에서만 적용될 Script 관리하기



</script>

<!-- 주의사항 -->
<!-- header.jsp 에서 추가한 JS, CSS와 충돌나지 않도록 해야한다. -->
<!-- 특히 라이브러리(jQuery 등) 관리에 신경쓸 것!! -->

<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<div id="myDiv">
<!-- 해당 페이지에만 적용될 styleSheet이기 때문에 아이디 값을 줘서 잘 관리, 적용할 수 있도록 해야한다. -->
	<h2>오우!</h2>
	<h4>이런 식으로 인클루드해서 개발하면 된다능 ㅎㅎ</h4>

</div>
<%@include file="/basicTag/footer.jsp"%>





