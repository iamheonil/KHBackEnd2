<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

var json = {"a":1, "b":2, "c":"Cherry", "d":true, "e":["1", "2", 3]};
console.log(json);

/* console.log(json.e);

console.log(json.c); */

console.log();

// JSON 객체 -> JSON 텍스트
var jsonText = JSON.stringify(json); // 마샬링
console.log(jsonText);

// JSON Text -> JSON Object
var jsonObject = JSON.parse(jsonText); // 언마샬링
console.log(jsonObject);

</script>
</head>
<body>

</body>
</html>