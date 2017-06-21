<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" type="text/css" href="/assets/css/workflow.css"/>
		<script src="/assets/js/jquery-2.1.4.min.js"></script>
		<script src="/assets/js/layer.min.js"></script>
		<script src="/assets/js/country.js"></script>
	</head>
	<body>
		<div class="nav">
			
		</div>
		<div class="main_register">
			 <div class="logintop">Login In</div>
			 <form method="post" action="/user/regist" class="reg_area" id="registFrom">
				 <div class="login" style="height:400px;">
				 	<ul>
				 		<img src="/assets/css/img/icon_phone.gif"  /><label>手机注册：</label>
				 		<input type="text" name="mobilePhone" id="mobilePhone"  class="input"/>
				 	</ul>
				 	<ul>
				 		<img src="/assets/css/img/icon_user.gif" /><label>用户名称：</label>
				 		<input type="text" name="name"  id="username" class="input"/>
				 	</ul>
				 	<ul>
				 		<img src="/assets/css/img/icon_user.gif" /><label>用户性别：</label>
				 		<input type="radio" name="gender" value="0"  />男
				 		<input type="radio" name="gender" value="1" />女
				 	</ul>
				 	<ul>
				 		<img src="/assets/css/img/icon_user.gif" /><label>社区名称：</label>
				 	<div style="position:relative;top:-30px;left:120px;">
				 		<select class='ocountry' id="province" next="city" class="input">
		                	<option value="0">=请选择=</option>
		                </select>
		                <select class='ocountry' id="city" next="region" class="input">
		                    <option value="-1">=请选择=</option>
		                </select><br/>
		                <select class='ocountry' id="region" next="street" class="input">
		                    <option value="-1">=请选择=</option>
		                </select>
		                <select class='ocountry' id="street" next="community" class="input">
		                    <option value="-1">=请选择=</option>
		                </select><br/>
		                <select class='ocountry' id="community" name="communityId">
		                    <option value="-1">=请选择=</option>
		                </select>
				 	</div>
				 	</ul>
					 <div style="position:relative;top:-30px;">
						 	<ul>
						 		<img src="/assets/css/img/icon_pwd.gif" /><label>密 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
						 		<input type="password" name="password" class="input"/>
						 	</ul>
						 	<ul>
						 		<img src="/assets/css/img/icon_pwd.gif" /><label>确认密码：</label>
						 		<input type="password" name="password2" class="input"/>
						 	</ul>
						 	<ul>
						 		<img src="/assets/css/img/icon_safe.png" /><label>验证码：</label>
						 		<input type="safe" name="validateCode"  class="safe"/>
						 		<img src="$request.contextPath/permission/validateCode" id="img" height="20" width="90">
						 		$!code
						 	</ul>
				 	  </div>
					  <div style="position:relative;top:-50px;">
						 	<div class="login-position"><button type="submit" id="sub" class="loginbtn">提 交</button></div>
						    <div class="regiser-position">
						    	<button class="registerbtn" type="button" 
						    	onclick='window.location.href="/permission/toLogin" '>取 消</button>
						    </div>
					  </div>
				  </div>
				 
				 </div>
				 </from>
		 </div>
	</body>
 
	<script>

$("#mobilePhone").blur(function(){
	var mobilePhone = $("#mobilePhone").val().trim();
	var reg = mobilePhone.length;  
   if(reg!=11){  
       layer.alert("请输入11位手机号！");  
       return  false;  
   }else{
			$.get("/community/user/mobilePhone/"+mobilePhone, function(data) {
				if(data.code==0){
					//alert("证件号可用");
				}else{
					layer.alert(data.data[0]);
				}
			},"json");
		}
	});
		 
    $('#sub').click(function () {
    var mobilePhone = $("#mobilePhone").val().trim();
    var username = $("#username").val().trim();
    var community = $("#community").val().trim();
	var reg = mobilePhone.length;  
	   if(reg!=11){
	       layer.alert("请输入11位手机号！");  
	       return  false;  
	   }
	    if (username == '') {
            layer.alert('请输入用户名称');
            return false;
        }
	    if (community ==-1) {
            layer.alert('请选择社区');
            return false;
        }
        if ($('input:eq(2)').val() == '') {
            layer.alert('还没有输入密码');
            return false;
        }
        if ($('input:eq(4)').val() != $('input:eq(5)').val()) {
            layer.alert('两次输入的密码不一致');
            return false;
        }
    });
	$("#img").click(function(){
			$("#img").attr("src","/permission/validateCode?"+new Date().getTime());
		});
		
	$(function(){
		 //selected="selected";
	});	
</script>
</html>
