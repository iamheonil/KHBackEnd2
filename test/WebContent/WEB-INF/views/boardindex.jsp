<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/binsert" method="post" enctype="multipart/form-data">

		<table align="center">

			<tr>
				<td>제목</td>

				<td><input type="text" name="btitle"></td>
			</tr>

			<tr>
				<td>작성자</td>
																<%-- <%=loginUser.getUserId()%> --%>
				<td><input type="text" readonly name="bwriter" value=""></td>
			</tr>

			<tr>
				<td>첨부파일</td>

				<td><input type="file" name="upfile"></td>
			</tr>

			<tr>
				<td>내용</td>

				<td><textarea cols="50" rows="7" name="bcontent"></textarea></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"value="등록하기"><br>
				<a href="/first/blist?page=1">목록으로</a></td>
			</tr>

		</table>

	</form>


</body>
</html>