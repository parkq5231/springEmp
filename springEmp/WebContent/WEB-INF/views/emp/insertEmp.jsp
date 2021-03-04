<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script
  src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script>
  	$(function(){
  		//이메일중복채크
  		$("#btnEmail").on("click",function(){
  			//var param = {email : $("[name=email]").val()};
  			var param = "email=" + $("[name=email]").val();
  			//ajax
  			$.ajax({
  					url: "../EmailCheck?",
  					data : param,		// 서버에 보낼 parameter
  					dataType:"xml",	// 결과 타입을 의미함
  					//data : {email : $("[name=email]").val()},
  					success : function(response) {
  						//result span tag
  						
  						//json
  						/* if(response.email){	//true false를 의미
  							$("#emailResult").html("<font color='blue'>사용가능</font>");
  						}else{
  							$("#emailResult").html("<font color='red'>사용불가능</font>");
  						} */
  						
  						//xml
  							$("#emailResult").html($(response).find("email").html());
  						
  					}//end of success
  				});//end of ajax
  		});//end of btnEmail
  		$("#search").on("click",function(){
  			//매니저 ,이름
  			var id = "managerId=" + $("[name=manager_id]").val();
  			//search 눌렀을 때의 화면
  			$.ajax({
  				url: "../EmpSearch?",
  				data : id,
  				success: function(response){
  			window.open("../EmpSearch","매니저 조회", "toolbar=yes,scrollbars=yes,resizable=yes,top=100,left=600,width=400,height=400");
  				}
  			})
  		})
  	});
  </script>
</head>
<body>
<h3 id="top">사원등록</h3>
<form:form modelAttribute="empVO" action="insertEmp" method="post" name="frm">
	employee_id <form:input path="employee_id" /><br>
	first_name  <form:input path="first_name"/><br>
	last_name   <form:input path="last_name"/><br>
	email       <form:input path="email" />
				<button type="button" id="btnEmail">중복채크</button>
				<span id ="emailResult"></span><br>
	phone_number<form:input type="text" path="phone_number"/><br>
	hire_date   <form:input type="date" path="hire_date"/><br>		
	department_id <form:radiobuttons path="department_id" items="${deptList}"  itemLabel="department_name" itemValue="department_id"/><br>
	job_id <form:select path="job_id">
				<option value="">선택</option>
		<form:options items="${jobList}" itemLabel="job_title" itemValue="job_id" />
	</form:select><br><br>
	manager_id 
	<form:input path="manager_id"/><input type="text" name="name">
	<button type="button" onclick="window.open('empSearch','emp',' top=100,left=600, width=600, height=600')">사원검색</button><br>	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form:form>
</body>
</html>
