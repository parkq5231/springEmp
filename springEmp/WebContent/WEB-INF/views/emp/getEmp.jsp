<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getEmp.jsp</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function() {
		$("#btnUpd").on("click", function() {
			//location.href="";
			location.assign("updateEmp?employee_id=${emp.employee_id}");
		})//end of btnUpd
	});//end of function
</script>

</head>
<body>
	<div>
		${employee}
		${empVO}
		사번:${emp.employee_id}<br>
		이름:${emp.first_name} ${emp.last_name}<br>
		이메일:${emp.email}<br>
		급여:${emp.salary}<br>
		부서:${emp.department_id}<br>
	</div>
	<button id="btnUpd">수정</button>
	<a href="deleteEmp?employee_id=${emp.employee_id}">삭제</a>
	<a href="getSearchEmp">목록</a>
</body>
</html>