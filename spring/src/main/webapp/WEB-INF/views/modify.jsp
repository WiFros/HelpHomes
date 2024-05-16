<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><body><center>	

<jsp:include page="loginCheck.jsp"/>
<h1>사원 정보 수정</h1><p>

<form action ="modifyProcess" method="post">
<input type="hidden" name="empid" value="${b.empid}"> 

<TABLE BORDER=2 CELLSPACING=2 CELLPADDING = 2>
 		<TR>
				<TH WIDTH=200>사번</TH><TD  width=300 align=center>${b.empid }</TD>
				<TH WIDTH=300>이름</TH><TD width=300 align=center>${b.fname }</TD>
		</TR> 
		<TR><TH WIDTH=200>입사일</TH><TD width=300 align=center>${b.hdate }</TD>
					<TH WIDTH=300>직책</TH><TD width=300 align=center>${b.jobtitle}</TD>
		</TR>
		<TR><TH WIDTH=200>봉급</TH><TD width=300 align=center><input type="text" name="salary" value="${b.salary }"></TD>
					<TH WIDTH=300>부서</TH><TD width=300 align=center><input type="text" name="deptname" value="${b.deptname }"></TD>
		</TR>
	</TABLE><br>
	<input type="submit" value="수정하기">
	</form>
	</center></body></html>
	
</table>
