<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/resources/js/httpRequest.js">
	
</script>

<script type="text/javascript">
	// 서버로 Ajax 요청을 보내는 함수
	function ajaxToServer() {
		/* console.log("Call ajaxToServer"); */

		// 전달 파라미터 준비 작업
		var params = "username=" + document.f.username.value;
		console.log(params);

		// AJAX 요청
		sendRequest("POST", "/ajax/ajax_03_ok.jsp", params, ajaxFromServer);

	}

	// 서버로부터 온 Ajax 응답을 처리하는 함수 (콜백함수)
	function ajaxFromServer() {
		if (httpRequest.readyState == 4) { //readyState 4, DONE, 응답 완료
			if (httpRequest.status == 200) { // OK.
				/* console.log("정상 응답"); */

				console.log("서버 응답 : " + httpRequest.responseText);
			} else {

				console.log("AJAX 응답, 요청 에러");

			}

		}

	}
</script>

</head>
<body>

	<h1>AJAX 03</h1>
	<hr>

	<form name="f">

		<input type="text" name="username" id="username"> <br> <br>

		<button type="button" onclick="ajaxToServer();">입력</button>


	</form>



</body>
</html>