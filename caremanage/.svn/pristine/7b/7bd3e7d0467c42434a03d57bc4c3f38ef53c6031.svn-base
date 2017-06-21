<!DOCTYPE html>
<html>
#set ($dirUser=$!{session.getAttribute("dirUser")})
<head>
    <meta charset="utf-8">
    <title>用户首页-公用</title>
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/common.css">
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/common1.css">
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/userFiling.css">
    <script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../assets/director/js/common.js"></script>
    <script type="text/javascript" src="../../assets/director/js/index.js"></script>
</head>

<body>
<div class="header clearfix">
  <div class="logo fl">羊坊店街道医养结合服务平台</div>
  <div class="set fr"><a href="#" class="wel">欢迎您</a><a>$!sessionUser.name</a><span class="line"></span><a href="#" class="setpassword">修改密码</a><span class="line"></span><a href="/permission/logout">退出</a></div>
</div>
<!-- 修改密码 -->#set ($dirUser=$!{session.getAttribute("dirUser")})
<div class="modify">
<form action="/permission/resetPass" method="post" onsubmit="tijiao">
  <div class="title">
    <span class="fl span_add">修改密码</span>
    <span class="fr close"></span>
  </div>
  
  <div class="userInfo">
    <p class="pass"><label>用户名:</label><input type="text" value="$!sessionUser.name" disabled=true;></p>
    <p class="pass"><label>原密码:</label><input type="text" name="oldPass" id="oldPass"></p>
    <p class="pass"><label>新密码:</label><input type="text" name="newPass" id="newpwd" placeholder="只能输入数字或字母" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"
></p>
    <p class="pass"><label>确认密码:</label><input type="text" name="newPass2" id="npwd"  placeholder="只能输入数字或字母"  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"
    ></p>
  </div>
  <input type="submit"  class="btnBg btnlg" value="确定" />
  <a href="#" class="btnBg btnBg1 cancel_all">取消</a>
 </form>
</div>
<div class="mask"></div>
</body>
<script>
function checkForm(){
		var old=$("#oldpwd").val();
		var newpwd=$("#newpwd").val();
		var npwd=$("#npwd").val();
		if(old==""){
			alert("密码不能为空!");
			return false;
		}
		if(newpwd==""){
			alert("新密不能为空!");
			return false;
		}
		if(newspwd=""){
			alert("确认密码不能为空!");
			return false;
		}
		if(newpwd.length!=npwd.length){
			alert("输入的新密码长度不一致!");
			return false;
		}
		if(newpwd!=npwd){
			alert("输入的新密码不一致");
			return false;
		}	
}
</script>
</html>
