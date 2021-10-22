<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Create User</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="../resource/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resource/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resource/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resource/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="../resource/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resource/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="../resource/css/util.css">
	<link rel="stylesheet" type="text/css" href="../resource/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="../resource/images/img-01.png" alt="IMG"  onclick="location.href='/index.do'">
				</div>

				<form class="login100-form validate-form" action="../user/InsertStart.do" method="post">
					<span class="login100-form-title">
						Join
					</span>
					<span class="id_ok">사용 가능한 아이디입니다.</span>
					<span class="id_already" >누군가 이 아이디를 사용하고 있어요.</span>
					<div class="wrap-input100 validate-input" data-validate = "아이디를 입력해주세요">
						<input class="input100" type="text" name="user_id" placeholder="User id" >
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "이름을 입력해주세요">
						<input class="input100" type="text" name="user_name" placeholder="User name">
						<div class="check_font" id="id_check"></div>
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "비밀번호를 입력해주세요">
						<input class="input100" type="password" name="user_pwd" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "확인 비밀번호를 입력해주세요">
						<input class="input100" type="password" name="check_pwd" placeholder="Check Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					<br>					
					<div class="container-login100-form-btn">
						<input type="button" class="login100-form-btn" id="signupbtn" onclick="NullCheck()" value="회원가입">
					</div>
						<input type="submit" style="display:none" name="InsertStart" id="InsertStart"/>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
			function NullCheck(){
	        	$(function(){
	        		$('#signupbtn').on('click', function(){
		        		var user_id = $("input[name=user_id]").val();
		        		if (user_id == ""){
		        			alert("아이디를 입력해주세요");
	        			}else{
	        				NameCheck();
	        				console.log("user_id" + user_id);
	        			}
	        		});
	        	});

	        }
			
			function NameCheck(){
	        	$(function(){
		        		var user_name = $("input[name=user_name]").val();
		        		if (user_name == ""){
		        			alert("이름를 입력해주세요");
	        			}else{
	        				PWDCheck();
	        				console.log("user_name" + user_name);
	        			}
	        		});
	        }
			
		function PWDCheck(){
	        	$(function(){
		        		var user_pwd = $("input[name=user_pwd]").val();
		        		var check_pwd = $("input[name=check_pwd]").val();
		        		if (user_pwd == ""){
		        			alert("비밀번호를 입력해주세요");
	        			}else if(check_pwd == ""){
	        				alert("확인 비밀번호를 입력해주세요");
	        			}else{
	        				CheckPWD();
	        			
	        			}
	        		});
	        }
		function CheckPWD(){
	        	$(function(){
		        		var user_pwd = $("input[name=user_pwd]").val();
		        		var check_pwd = $("input[name=check_pwd]").val();
		        		if (user_pwd === check_pwd ){
		        			//alert("회원가입에 적합합니다.");
		        			document.all.InsertStart.click();
		        		}else{
	        				alert("비밀번호가 다릅니다. 다시 입력해주세요 ");
	        			
	        				console.log("user_pwd" + user_pwd);
	        				console.log("check_pwd" + check_pwd);
	        			}
		        	});
	        	}
	</script>
	
<!--===============================================================================================-->	
	<script src="../resource/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../resource/vendor/bootstrap/js/popper.js"></script>
	<script src="../resource/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../resource/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../resource/vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="../resource/js/main.js"></script>
	<script src="../resource/js/main.js"></script>
	<script src="../resource/js/jquery-3.4.1.min.js"></script>
</body>
</html>