<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	// AJAX 객체인 XHR 을 생성하는 펑션 - 크로스 브라우징 처리
	function createXMLHttpRequest() {

		// XML 객체 변수
		var xmlReq = new XMLHttpRequest();

		if (window.XMLHttpRequest) { // XMLHttpRequest 객체가 존재한다면

			// IE 7.0 이상일 때
			// IE 브라우저가 아닐 때(크롬, 사파리, 오페라 등)
			xmlReq = new XMLHttpRequest();

		} else if (window.ActiveXObject) { // ActiveXObject 객체가 존재한다면

			// IE 계열 브라우저

			try {
				// 비교적 최근의 인터넷 익스플로러
				xmlReq = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e1) {
				try {
					// 비교적 예전버전의 인터넷 익스플로러
					xmlReq = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e2) {
					console.log("AJAX 객체 생성 실패");
				}
			}
		}
		return xmlReq;
	}
</script>

<script type="text/javascript">
	function send() {

		xmlHttp = createXMLHttpRequest();

		//	console.log(xmlHttp);

		var n1 = num1.value;
		var n2 = num2.value;
		var op = oper.value;

		//	console.log(n1);
		//	console.log(n2);
		//	console.log(op);

		// AJAX 요청 전 설정

		// 요청 URL
		// var query = "num1 = " + n1 + "&num2 = " + n2 + "&oper = " + op;
		var query = "num1=" + n1 + "&num2=" + n2 + "&oper=" + op;

		var url = "/ajax/ajax_02_ok.jsp" + "?" + query;

		console.log(url);

		// 요청 Method
		var method = "GET";

		// 서버로부터 전달된 응답 데이터 처리 콜백 함수
		xmlHttp.onreadystatechange = callback;

		// 위 까지가 0번	

		// 1번
		// XHR 객체가 서버로 통신할 준비를 함 - 서버로 접속함(통신 스트림 개설)
		xmlHttp.open(method, url);

		// 2번?
		xmlHttp.send(null);

	}

	function callback() {
		//	console.log("Callback Called");

		if (xmlHttp.readyState == 4) { // readyState 4, DONE, 응답 완료
			if (xmlHttp.status == 200) {
				// console.log("정상 응답");
				printData();
			} else if (xmlHttp.status == 404) { // Page Not Found
				console.log("페이지 없음")
			} else if (xmlHttp.status == 405) { // Method Now Allowed
				console.log("메소드 처리 불가")
			} else if (xmlHttp.status == 500) { // Internal Server ERror
				console.log("서버 에러")
			} else {
				console.log(xmlHttp.statusText)
			}

		}

	}

	function printData() {

		// div#resultLayout 에 결과 반영하기
		resultLayout.innerHTML = xmlHttp.responseText;

	}
</script>


</head>
<body>

	<h1>계산기 02</h1>
	<h3>AJAX 통신 (비동기식)</h3>
	<hr>

	<input type="text" id="num1">

	<select id="oper">

		<option value="add">더하기</option>
		<option value="sub">빼기</option>
		<option value="mul">곱하기</option>
		<option value="div">나누기</option>

	</select>

	<input type="text" id="num2">

	<button onclick="send();">=</button>

	<hr>

	<!-- AJAX 요청의 결과(응답)가 추가될 div -->
	<div id="resultLayout"></div>

</body>
</html>