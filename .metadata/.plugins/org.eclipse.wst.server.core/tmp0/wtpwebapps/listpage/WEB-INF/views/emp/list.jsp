<%@page import="dto.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<Emp> eList = (List) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid #ccc;
}

td {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	padding: 5px 10px;
}

td:hover {
	background: #FAFAD2;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#name").mousedown(console.log('hi'));

	});
</script>

</head>
<body>

	<h1>EMP 리스트</h1>
	<hr>
	<table id="list">
		<%
			for (int i = 0; i < eList.size(); i++) {
		%>
		<tr>
			<td><%=eList.get(i).getEmpno()%></td>
			<td id="name"><%=eList.get(i).getEname()%></td>
			<td><%=eList.get(i).getJob()%></td>
			<td><%=eList.get(i).getMgr()%></td>
			<td><%=eList.get(i).getHiredate()%></td>
			<td><%=eList.get(i).getSal()%></td>
			<td><%=eList.get(i).getComm()%></td>
			<td><%=eList.get(i).getDeptno()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>







