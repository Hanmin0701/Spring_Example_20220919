<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	 <!-- -->
 	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> 

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"	crossorigin="anonymous"></script>
	
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
		<form action="/lesson06/ex01/add_user" method="post">
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예)20010701">
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일을 입력하세요.">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea type="text" id="introduce" name="introduce" class="form-control col-3"></textarea>
			</div>
			
			<!-- form 태그를 위한 submit 버튼 -->
			<!-- <input type="submit" class="btn btn-success" value="회원가입"> -->
			
			<!-- AJAX를 위한 버튼 -->
			<input type="button" id="join" class="btn btn-success" value="회원가입">
		</form>		
	</div>
	
	<script type="text/javascript">
		$(doucument).ready(function(){
			// 1) jquery의 submit 기능 이용하기
		/* 	    $('form').on('submit', function(){
				// alert("서브밋");
				e.preventDefault(); // 서브밋 되는 것을 막는다.
				
				// vaildation
				let name = $('name').val().trim();
				if(name.length == '') {
					alert("이름을 입력하세요");
					return false;  // return false라고 써야만 서브밋이 되지 않는다.
				}
				
				let yyyymmdd = $('yyyymmdd').val().trim();
				if(yyyymmdd.length < 1) {
					alert("생년월일을 입력하세요");
					return false;
				} 
				
				// 여기까지 도달하면 submit
				alert("서브밎"); 
			}); */
			
			// 2) jquery의 AJAX 통신 이용하기
			$('join').on('click', function(){
				// alert("aaaa");
			
				let name = $('name').val().trim();
				if(name.length == '') {
					alert("이름을 입력하세요");
					return; // submit이 아니니까 그냥 return만 해준다.
				}
				
				let yyyymmdd = $('yyyymmdd').val().trim();
				if(yyyymmdd.length < 1) {
					alert("생년월일을 입력하세요");
					return;
				} 
				
				if(isNaN(yyyymmdd)) { // 모두 숫자가 아닌 경우 참
					alert("숫자만 입력해주세요.")
					return;
				}
				
				let email = $('email').val().trim();
				console.log(email);
				
				let introduce = $('introduce').val();
				console.log(introuduce);
				
				// AJAX
				$.ajax({
					// request 
					type:"POST"
					, url:"/lesson06/ex01/add_user"
					, date:{"name": name, "yyyymmdd": yyyymmdd, "email": email, "introduce": introduce}
					
					// response
					, success:function(data) {
						alert(data);
						// 화면 이동
						location.href="/lesson06/ex01/after_add_user_view";
					}
					
					// complete는 굳이 사용을 하지 않는다.
                    , complete:function(data) {
                    	alert("완료");
                    }		
                    
                    , error:function(e) {
                    	alert("에러")
                    }
				});
			});
		});
	</script>
</body>
</html>