<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>北科乐活堂站点管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="/assets/js/manage/css/style.css"/> 
<style>
canvas {
	z-index: -1;
	position: absolute;
}
.top{
width:1100px;
margin:0 auto;
padding:5px 0px;
}
.top img{
width:161px;
height:47px;
}
.container-fluid{
	width: 100%;
    background: url(/assets/newImg/loginBanner.png);
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    overflow: hidden;
    padding: 77px 0 107px;
}
.wrap{width:1100px;margin:0 auto;}
.admin_login {
	float:right;
    width: 356px;
    height: 380px;
    background:#fcfcfc;
    border-radius: 5px;
    margin:0;
    padding:0;
    box-shadow:none;
}
.admin_login dt h3{
	text-align:center;
	color:#0696da;
	font-size:18px;
	margin:20px auto;
	font-weight:normal;
}
.admin_login dd{
	width:86%;
	border:1px solid #bfbfbf;
	height:50px;
	line-height:50px;
	margin:24px auto;
	border-radius:4px;
	position:relative;
}
.admin_login dd .login_txtbx{
	border:none;
	overflow:hidden;
	height:50px;
	line-height:50px;
	background-color:#fff;
	padding:0 5%;
	color:#bfbfbf;
	font-size:14px;
	float:right;
	width:80%;
}
/*.admin_login dd .login_txtbx:before{
	font-family: 'adminthemesregular';
    position: absolute;
    top: 0;
    left: 10px;
    height: 50px;
    line-height: 50px;
    font-size: 20px;
    color: #0c9076;
}*/
.admin_login dd .checkcode input{
	color:#bfbfbf;
	font-size:14px;
}
/*.admin_login dd:before{
	font-size:35px;
	color:#bfbfbf;
	height:50px;
	line-height:50px;
}*/
.admin_login dd .submit_btn{
	background-color:#0696da;
	color:#fff;
	height:50px;
	line-height:50px;
	font-size:16px;
	width:100%;
	border:none;
}
.admin_login dd .submit_btn:hover{
	background-color:#0696da;
}
.admin_login dt{text-shadow:none;}
.bottom{
	color:#9d9d9d;
	font-size:14px;
	text-align:center;
	margin:0 auto;
	width:100%;
	padding:10px 0px;
}
</style>
<script src="/assets/js/manage/js/jquery.js"></script>
<script src="/assets/js/login.js"></script>
<script src="/assets/js/manage/js/verificationNumbers.js"></script>
<script src="/assets/js/manage/js/Particleground.js"></script>
<script>
	
</script>
<script>
	$(document).ready(function() {
		//粒子背景特效
		//$('body').particleground({
		//	dotColor : '#5cbdaa',
		//	lineColor : '#5cbdaa'
		//});
		//验证码
		createCode();

	});
	function validate1() {
		alert(code);

	}
</script>
</head>
<body>
	<div class="top"><img src="/assets/newImg/logo.png"></div>
	<div class="container-fluid">
		<div class="wrap">
			<dl class="admin_login" style="padding-top: 0px;">
			<dt style="padding-top: 0px;">
				<!-- <br> <img src="/assets/newImg/lehuotang.png"
					style="width: 250px; height: 70px; padding: 0px; margin-buttom: 0px;" />
				<br>
				<lable style="position: relative;">居家养老服务系统</lable> -->
				<h3>用户登录</h3>
			</dt>
			<form action="/permission/login" method="post" id="userLogin">
				<dd class="user_icon">
					<input type="text" name="name"
						placeholder="#if(!$!userName)账号 #else $!userName #end"
						class="login_txtbx" name="username" />
				</dd>
				<dd class="pwd_icon">
					<input type="password"
						placeholder="#if(!$!userName)密码#else $!userName #end"
						name="password" class="login_txtbx" name="password" />
				</dd>
				<dd class="val_icon">
					<div class="checkcode">
						<input type="text" id="J_codetext" placeholder="验证码" maxlength="4"
							class="login_txtbx1">
						<canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
					</div>
					<!-- <input type="button" value="验证码核验" class="ver_btn"
						onClick="validate();"> -->
				</dd>
				<dd>
					<input type="button" name="keyword" value="登录" class="submit_btn" />
				</dd>
				
			</form>
			
		
		</dl>
		</div>
		
	</div>
	<div class="bottom">Copyright © 2016 by 北京怡养科技有限公司 京ICP备16056595号-1</div>
	<script type="text/javascript">
		$(function() {
			$("input").blur(function() {
				$(this).val($(this).val().replace(/\s+/g, ""));
			});
		});
	</script>
</body>
</html>
