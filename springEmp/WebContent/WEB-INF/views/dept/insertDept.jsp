<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
</head>
<body>
<h3 id="top">부서등록</h3>
	<form action="updateDept" method="post" name="frm">
	department_id: <input type="number" name="department_id" value="${dept.department_id}"><br>
	department_name: <input type="text" name="department_name" value="${dept.department_name}"><br>
	location_id: <input type="number" name="location_id"><br>
	manager_id: <input type="number" name="manager_id"><br>


	<input type="text" name="manager_id" value="${dept.manager_id}">
	<input type="text" name="name">
	<button type="button" onclick="window.open('getSearchDept','dept',' top=100,left=600, width=600, height=600')">사원검색</button><br>	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
	</form>
</body>
</html>
