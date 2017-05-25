<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>날짜</th>
			<th>금액</th>
		</tr>
		<c:forEach items="${alist }" var="map">
		<tr>
			<td>${map.sabun }</td>
			<td><a href="detail.do?idx=${map.sabun }">${map.name }</a></td>
			<td>${map.nalja }</td>
			<td>${map.pay }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="add.do">입력</a>
</body>
</html>