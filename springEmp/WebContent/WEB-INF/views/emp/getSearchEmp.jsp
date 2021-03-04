<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>사원목록</h3>
		<form action="getSearchEmp" id ="searchFrm" name="searchFrm">
			<input type="hidden" name="page" value="1">
			부서 <input name = "department_id" value="${empSearchVO.department_id }">
			JOB <input name ="job_id" value="${empSearchVO.job_id}">
			NAME <input name="first_name" value="${empSearchVO.first_name}">
			<button>검색</button>
		</form>
		
		<c:forEach items="${list}" var="emp">
			<a href="getEmp?employee_id=${emp.employee_id}">${emp.last_name}</a>
			<br>
		이메일: ${emp.email}<br>급여: ${emp.salary}<br>
		부서명:${emp.department_name}<br>직업이름:${emp.job_title}<hr>
		</c:forEach>
	</div>
	<my:paging paging="${paging}" jsFunc="goPage" />
	<script>
		function goPage(p) {
			//location.href = "getSearchEmp?page=" + p;
			searchFrm.page.value = p;
			searchFrm.submit();
		}
	</script>
</body>
</html>