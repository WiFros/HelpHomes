<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<title>Spring Boot MVC</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container text-center">
		<img src="image/f1.jpg" />
		<br>
		
		<h1>부서원 목록</h1>
		<jsp:include page="loginCheck.jsp"/>
		
		<form method="post" action="search">
			입사기간: <input type="text" name="from">&nbsp;-&nbsp;
			<input type="text" name="to">
			<input type="submit" value="검색">				 			
		</form>
		
		
		<form method="post" action="multidelete">
			<table class="table table-striped">
				<thead>
					<tr>
						<c:if test="${user.id == 'admin'}">
							<th>check</th>
						</c:if>
						<th>사번</th>
						<th>이름</th>
						<th>입사년월</th>
						<th>봉급</th>
						<th>부서명</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="e">
						<tr>
							<c:if test="${user.id == 'admin'}">
								<td><input type="checkbox" name="empids" value="${e.empid}"></td>
							</c:if>
							<td><a href="read?empid=${e.empid }">${e.empid }</a></td>	
							<td>${e.fname }</td>	
							<td>${e.hdate }</td>	
							<td>${e.salary}</td>	
							<td>${e.deptname }</td>	
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<a href="insertForm">부서원 추가</a><br><br>
			<c:if test="${user.id == 'admin'}">
				<input type="submit" value="선택 삭제">
			</c:if>
		</form>
		<br><br>
	</div>
</body>
</html>



