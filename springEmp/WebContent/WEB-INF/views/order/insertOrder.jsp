<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order/insertOrder.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#addGoods").on("click", function() {
			$("tr:last").clone().appendTo($("tbody"));
			$("input").attr("name", "ords[1].no");
			$("input").attr("name", "ords[1].cnt");
		})//end of addGoods		
	});//end of function
</script>
</head>
<body>
	<h2>주문페이지</h2>
	<button type="button" id="addGoods">상품추가</button>

	<form id="frm" action="insertOrder" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input name="name" /></td>
			</tr>
			<tr>
				<td>배송지</td>
				<td><input name="addr" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="tel" /></td>
			</tr>
			<tr>
				<td><input name="ords[0].no" /></td>
				<td><input name="ords[0].cnt" /></td>
			</tr>

		</table>
		<button>주문하기</button>
	</form>
</body>
</html>