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
	<h3>부서목록</h3>
	<c:forEach items="${deptList}" var="dept">
		<p>
			<a href="getDept?department_id=${dept.department_id}">${dept.department_name}</a>
			${dept.manager_id} ${dept.location_id}
			<button style="float: right" type="button" class="btnSelect">선택</button>
		</p>
	</c:forEach>
</body>
</html>