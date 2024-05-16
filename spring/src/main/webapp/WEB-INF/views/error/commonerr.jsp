<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<H1>예외 메세지</H1>
	<hr>
	<div class="container">
		<c:if test="${!empty errmsg }">
			<%-- errmsg가 있다면 표현해준다.  --%>
			<h5>${errmsg }</h5>
		</c:if>
		<c:if test="${empty errmsg }">
			<%-- errmsg가 없다면 기본 에러 메시지를 표현한다.  --%>
			<h5>서버 오류입니다. 다시 시도해주세요.</h5>
		</c:if>
		<a href="list">back</a>
	</div>
</body>
</html>