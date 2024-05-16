<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<body>
<c:if test="${empty user}">
	<a href="login">로그인</a>
</c:if>

<c:if test="${!empty user}">
	Welcome, ${user.id}!!!
	<a href="logout">로그아웃</a>
</c:if>

</body>
</html>