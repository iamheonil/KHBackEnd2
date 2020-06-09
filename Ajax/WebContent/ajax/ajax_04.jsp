<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- httpRequest 생성 라이브러리 -->
<script type="text/javascript" src="/resources/js/httpRequest.js"></script>

<script type="text/javascript">
	//서버로 ajax 요청을 보내는 함수
	function ajaxToServer() {
		console.log("ajaxToServer called");

		//전달 파라미터 준비
		/* 5/1 강의 참고 */
		var params = "username=" + document.f.username.value + "&content="
				+ document.f.content.value;
		console.log(params);

		//ajax 요청
		sendRequest("POST", "/ajax/ajax_05_ok.jsp", params, callback);

	}

	//서버로부터 온 ajax 응답을 처리하는 함수
	function callback() {
		if (httpRequest.readyState == 4) {//readyState 4 , DONE , 응답 완료
			if (httpRequest.status == 200) { // ok.
				console.log("정상응답");

				appendRequest();

			} else {
				console.log("ajax요청/응답 에러");

			}

		}

	}
</script>

</head>
<body>

	<h1>AJAX 04</h1>
	<hr>

	<!-- 이름, <input>태그 id="username" -->
	<!-- 내용, <input>태그 id="content" -->
	<!-- 이름, 내용 두가지 데이터를 ajax_04_ok.jsp 로 전송 -->
	<!-- 전송한 데이터를 이용하여 응답데이터로 작성한다 -->
	<!-- 응답 받은 데이터를 이용하여 <div>를 생성하고 그 안에 데이터를 기록 -->

	<!-- 예시
<div>
	name : Alice
	content : 안녕하세요!
	
	Alice님, 안녕하세요!
</div>

단 응답 데이터는 button 하단에 계속 추가되도록 만든다.
	
	 -->
	<form name="f">
		이름 : <input type="text" name="username" id="username"> 내용 : <input
			type="text" name="content" id="content">

		<button type="button" onclick="ajaxToServer();">보내기</button>

	</form>

	<hr>
	<br>

	<div id="main"></div>



</body>
</html>