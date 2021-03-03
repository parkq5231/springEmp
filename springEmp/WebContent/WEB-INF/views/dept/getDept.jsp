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
			location.assign("updateDept?department_id=${dept.department_id}");
		})//end of btnUpd
	});//end of function
</script>

</head>
<body>
	<div>
		${dept}<br>
		부서번호:${dept.department_id}<br>
		부서이름:${dept.department_name}<br>
		매니저:${dept.manager_id}<br>
		지역번호:${dept.location_id}<br>
		도시:${dept.city}<br>
		이름:${dept.last_name}<br>
	</div>
	<button id="btnUpd">수정</button>
	<a href="deleteDept?department_id=${dept.department_id}">삭제</a>
	<a href="getSearchDept">목록</a>
</body>
</html>