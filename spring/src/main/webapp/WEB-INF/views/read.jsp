<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
	<img src="image/f2.jpg"/>
		<h1>사원 정보</h1>		
		<p>
			
			<table class="table table-bordered"><TR>
				<TH>사번</TH>
				<TD>${b.empid }</TD>
				
				<Th>이름</TH>
				<TD>${b.fname}</TD>
			</TR>
			<TR>
				<TH>입사일</TH>
				<TD>${b.hdate }</TD>
				
				<TH>봉급</TH>
				<TD>${b.salary }</TD>
			</TR>
			</div>
			</TR>
		</TABLE>

	 <a href="list">목록</a>
	 <a href="delete?empid=${b.empid }">삭제</a> 	 
	 <a href="modify?empid=${b.empid }">수정</a> 	 	

	  
	<br><br>

	</div>
</body>
</html>






