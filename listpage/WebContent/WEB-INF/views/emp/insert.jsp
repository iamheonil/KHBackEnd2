<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
input {
	width: 170px;
}

label {
	display: inline-block;
	width: 505px;
}
</style>

</head>
<body>

	<h1>사원 등록 페이지</h1>
	<hr>

	<form action="/emp/insert" method="POST">

		<label>EMPNO(사원번호) : <input type="text" name="empno" id="empno" min="1" max="9999" required="required"></label><br>
		<label>ENAME(이름) : <input type="text" name="ename" id="ename"></label><br>
		<label>JOB(직책) : <input type="text" name="job" id="job"></label><br>
		<label>MGR(매니저) : <input type="number" name="mgr" id="mgr" min="1" max="9999"></label><br> 
		<label>HIREDATE(입사일자) : <input type="date" name="hiredate" id="hiredate"></label><br>
		<label>SAL(보너스) : <input type="number" name="sal" id="sal"></label><br>
		<label>COMM(월급) : <input type="number" name="comm" id="comm"></label><br>
		<label>DEPTNO(부서번호) : <select id="deptno" name="deptno">
				<option value=""></option>
				<option value="10">ACCOUNT</option>
				<option value="20">RESEARCH</option>
				<option value="30">SALES</option>
				<option value="40">OPERATIONS</option>
		</select>
		</label> <br> <br> <input type="submit" value="추가">
	</form>

<hr>
<button onclick="history.go(-1)">뒤로가기</button>

<hr>
<button onclick="location.href='/emp/list'">목록</button>

</body>
</html>