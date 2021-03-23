<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
img {
	width: 100px;
	height: 100px;
	cursor: pointer;
}

img:hover {
	transform: scale(3, 1);
}
</style>
</head>
<body>
	<h3>부서목록</h3>
	<c:forEach items="${deptList}" var="dept">
		<img src="./resources/images/Lighthouse.jpg">
		<p>
			<a href="getDept?department_id=${dept.department_id}">${dept.department_name}</a>
			이름: ${dept.last_name} 매니저: ${dept.manager_id} 지역번호: ${dept.location_id} 도시: ${dept.city}
			<button style="float: right" type="button" class="btnSelect">선택</button>
		</p>
	</c:forEach>
	<my:paging paging="${paging}" jsFunc="goPage" />
	<script>
		function goPage(p) {
			location.href = "getSearchDept?page=" + p;
		}
	</script>
</body>
</html>