<%@ page contentType="text/html;charset=utf-8"%>

<HTML>
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
<BODY>
	<div class="container text-center">
		<img src="image/f2.jpg" />
		<h1>새글쓰기</h1>
		
		<form action="insertProcess" method="post">
			<div class="form-group text-left">
				<label for="title">제 목:</label> 
				<input type="text"	class="form-control" name="title">
			</div>

			<div class="form-group text-left">
				<label for="pw">패스워드:</label> 
				<input type="password"	class="form-control" name="pass">
			</div>
			<div class="form-group text-left">
				<label for="name">이 름:</label> 
				<input type="text"	class="form-control" name="name">
			</div>
			<div class="form-group text-left">
				<label for="comment">내 용:</label>
				<textarea class="form-control" rows="5" id="comment" name="content"></textarea>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<a href="list">전체화면</a>
		<br><br>
	</div>

</BODY>
</HTML>











