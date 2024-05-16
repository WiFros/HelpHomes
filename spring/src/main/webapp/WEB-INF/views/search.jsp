<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Bootstrap Example</title>
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
		<img src="resources/image/f1.jpg" />

		<h1>검색 결과</h1>
		<jsp:include page="loginCheck.jsp" />
		<c:if test="${!empty list}">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${list }" var="b">
						<tr>
							<td>${b.num }</td>
							<td><a href="read?num=${b.num }">${b.title }</a></td>
							<td>${b.name }</td>
							<td>${b.wdate}</td>
							<td>${b.count }</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:if>
		<c:if test="${empty list}">
			<h3>검색결과가 없습니다.</h3>
		</c:if>
		
		<br> <a href="list">초기화면</a> <br>
		<br>
	</div>
</body>
</html>



