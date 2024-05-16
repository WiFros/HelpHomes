<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><body>
<center>
		<img src="image/f1.jpg">	
				
		<h1>EMP-DEPT</h1>	
		<jsp:include page="loginCheck.jsp"/>		
		
		<form action="insertProcess" method="post">		
		<br>	
		<TABLE BORDER=1 CELLSPACING=1 CELLPADDING = 1>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>항목</th>
				<th bgcolor=#113366><font color=#ffffee size=2>입력</th>				
			</tr>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>사번</th>
				<td align=center bgcolor=pink><input name="empid"></td>
			</tr>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>이름</th>
		        <td align=center bgcolor=pink><input name="fname"></td>
			</tr>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>이메일</th>
		        <td align=center bgcolor=pink><input name="email"></td>
			</tr>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>전화번호</th>
   		        <td align=center bgcolor=pink><input name="phone"></td>
			</tr>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>입사일</th>
		        <td align=center bgcolor=pink><input name="hdate"></td>
			</tr>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>직책</th>
				<td align=center bgcolor=pink><input name="jobtitle"></td>
			</tr>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>봉급</th>
		        <td align=center bgcolor=pink><input name="salary"></td>	      		       
			</tr>
			<tr>
				<th bgcolor=#113366><font color=#ffffee size=2>부서명</th>
	  	        <td align=center bgcolor=pink><input name="deptname"></td>	      		       
			</tr>
		</table>
		<br>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	   
<br></br>
<a href=list>돌아가기</a>
</body></html>