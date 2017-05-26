<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form span{
		color :red;
	}
</style>
</head>
<body>
	<div>${err}</div>
	<h1>입력/수정 페이지</h1>
	<form action="insert.do" method="post">
		<div>
		<label for="name">이름</label>
		<input type="text" id="name" name="name" value="${bean.name}"/><span>${errs.name}</span>
		</div>
		<div>
		<label for="nalja">날짜</label>
		<input type="date" id="" name="nalja" value="${bean.nalja}"/><span>${errs.nalja}</span>
		</div>
		<div>
		<label for="pay">금액</label>
		<input type="number" id="pay" name="pay" value="${bean.pay}"/> <span>${errs.pay}</span>
		</div>
		<button type="submit">입력</button>
	</form>
</body>
</html>