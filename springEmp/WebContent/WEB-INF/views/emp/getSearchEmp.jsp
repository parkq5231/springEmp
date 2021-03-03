<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>사원목록</h3>
		<c:forEach items="${list}" var="emp">
			<a href="getEmp?employee_id=${emp.employee_id}">${emp.last_name}</a><br>
		이메일: ${emp.email}<br>급여: ${emp.salary}<br>
		부서명:${emp.department_name}<br>직업이름:${emp.job_title}<hr>
		</c:forEach>
	</div>
</body>
</html>