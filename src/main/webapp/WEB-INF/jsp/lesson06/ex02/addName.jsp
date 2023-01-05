<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 중복 확인</title>
  <!-- 부트 스트랩 -->
 <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> 

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"	crossorigin="anonymous"></script>
	
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
			
		<div class="form-group">
			<label for="name">이름</label>
			<div class="d-flex">
				<input type="text" class="form-control col-3" id="name">
				<button type="button" class="btn btn-info" id="nameCheckBtn">중복확인</button>
			</div>
			
			<small id="nameStatusArea"></small>
		</div>
		
		<button type="button" class="btn btn-success" id="joinBtn">가입하기</button>
	</div>
</body>

	<script type="text/javascript">
		$(document).ready(function(){
			// 중복 확인 버튼
			$('#nameCheckBtn').on('click', function(){
				// nameStatusArea의 하위 태그들 초기화
				$('#nameStatusArea').empty(); // 자식 태그들을 모두 비운다.
				
				let name = $('name').val().trim();
				
				// 이름이 입력됐는지 확인 validation
				if (name == '') {
					$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
					return;
				}
				
				// 이름 중복 확인 -> DB에서 조회 => AJAX 통신
				$.ajax({
					
					// request
					type:"get"
					, url:"/lesson06/ex02/is_duplication"
					, data:{"name":name}
						
					// response
					, success:function(data){
						// alert(data.is_duplication); => is_duplication 있는지 확인하기 위해서
						if (data.is_duplication) {
							$('#nameStatusArea').append('<span class="text-danger"> 중복된 이름입니다.</span>');						
						}
					}
					
					,error:function(e) {
						alert("실패" + e);						
					}
				});
			});
		});
	</script>

</html>