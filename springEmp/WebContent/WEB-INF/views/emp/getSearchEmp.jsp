<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
	$(function() {
		$(".btnSelect").on("click",function(){
			opener.document.frm.manager_id.value=${emp.employee_id}
		})//end of btnSelect
	})//end of function
</script>
</head>
<body>
	<h3>사원목록</h3>
	<c:forEach items="${list}" var="emp">
	<p>
		<a href="getEmp?employee_id=${emp.employee_id}">${emp.first_name}</a>
		${emp.email} ${emp.salary}<button style="float: right" type="button" class="btnSelect">선택</button>
	</p>
	</c:forEach>
</body>
</html>