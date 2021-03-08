<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td {
	text-align: right;
}
</style>
</head>
<body>
	<div id="show" align="center">
		<h2>패스워드 변경</h2>
		<form id="frm" name="frm" action="changePw" method="post">
			<table id="tbl">
				<tr>
					<td>현재 패스워드 :</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>변경할 패스워드 :</td>
					<td><input type="password" name="newpassword"></td>
				</tr>
				<tr>
					<td>변경할 패스워드 확인 :</td>
					<td><input type="password" name="newpassword2"></td>
				</tr>
			</table>
			<br>
			<button type="submit">변경</button>
			<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>