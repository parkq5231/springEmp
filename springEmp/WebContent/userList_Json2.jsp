<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./resources/js/json.min.js"></script>
<script type="text/javascript" >
	$(function (){
		userList();

		userSelect();
		
		userDelete();
		
		userInsert();
	
		userUpdate();
		
		init();
	//초기화
	function init(){
		$("#btnInit").on("click",function(){
			$("#form1").each(function(){
				this.reset();
			})
		})
	}//end of init
		
	//삭제	
	
		
	});//end of function
</script>
</head>
<body>
	<div id ="container">
		<form id="form1" name="form1" class= "form-horizontal">
		<h2>사용자 등록 및 수정</h2>
		<div class="form-group">
			<label >아이디:</label>
			<input type="text"  class="form-control" name="id" >
		</div>
		<div class="form-group">
			<label>이름:</label>
			<input type="text"  class="form-control"  name="name" >
		</div>
		<div class="form-group">
			<label>패스워드:</label>
			<input type="text"  class="form-control"  name="password" >
		</div>
		<div class="form-group">
			<label>역할:</label>
			<select class="form-control" name="role">
		   		<option value="Admin">관리자</option>
		   		<option value="User">사용자</option>
			</select>
		</div>
		<div class="btn-group">
			<input type="button"  class="btn btn-primary" value="등록"  id="btnInsert" /> 
			<input type="button"  class="btn btn-primary" value="수정"  id="btnUpdate" />
			<input type="button"  class="btn btn-primary" value="초기화" id="btnInit" />
		</div>
		</form>
	</div>	
<div id="container">
	<h2>사용자 목록</h2>
	<table class="table text-center">
	<thead>
		<tr>
			<th class="text-center">아이디</th>
			<th class="text-center">이름</th>
			<th class="text-center">패스워드</th>
			<th class="text-center">권한</th>	
		</tr>
	</table>	
</div>
</body>
</html>