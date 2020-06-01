<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1> fmt : formatNumber </h1>
<hr>

<fmt:formatNumber value="1234567890"></fmt:formatNumber> <br><br>
<fmt:formatNumber value="1234567890" type="number"></fmt:formatNumber> <br><br>
<fmt:formatNumber value="1234567890" type="currency"></fmt:formatNumber> <br><br>
<fmt:formatNumber value="1234567890" type="percent"></fmt:formatNumber> <br><br>

<hr>

<fmt:formatNumber value="1234567890" type="number" groupingUsed="false"></fmt:formatNumber> <br><br>

<fmt:formatNumber value="1234567890" type="currency" currencySymbol="$" minFractionDigits="2"></fmt:formatNumber> <br><br>

<hr>

<fmt:formatNumber value="7" type="currency" currencySymbol="$" minIntegerDigits="5"></fmt:formatNumber>

<br>
<br>
<hr>

<fmt:formatNumber value="12345.60" type="currency" currencyCode="USD"></fmt:formatNumber>
<br><br>
<fmt:formatNumber value="12345.60" type="currency" currencyCode="JPY"></fmt:formatNumber>

<br>
<br>
<hr>

<fmt:formatNumber value="12345.67890" type="number" pattern="#####.#"></fmt:formatNumber>

<br>
<br>
<hr>

<fmt:formatNumber value="12345.67890" type="number" pattern="###,###,###.###"></fmt:formatNumber>

<br>
<br>
<hr>

<fmt:formatNumber value="12345.6" type="number" pattern="0000000000.0000000000"></fmt:formatNumber>

<br>
<br>
<hr>

<fmt:formatNumber value="12345.6" type="number" pattern="$#,###.00"></fmt:formatNumber>

<br>
<br>
<hr>

<fmt:formatNumber value="12345.6" type="number" pattern="USD#,###.00"></fmt:formatNumber>
<hr>
<br><br><br>










</body>
</html>



































