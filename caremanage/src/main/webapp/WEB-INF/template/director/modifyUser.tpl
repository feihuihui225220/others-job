<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>添加用户</title>
<link href="/assets/director/style/XZuserm.css" rel="stylesheet" type="text/css">
</head>
<body>
#parse("/common/dtop.tpl")
#parse("/common/dmain.tpl")
<div class="main1">
    <div class="personInfo_right fl" style="float: left;">
        <form method="post" action="/director/saveUser" onsubmit="return yz()" class="reg_area fix_pop" style="width:400px">
            #if($user.id)
            	<h2>修改用户</h2>
				#set($isAdd=false)
				<input type="hidden" name="id" value="$user.id"/>
            #else
            	<h2>添加用户</h2>
				#set($isAdd=true)
            #end	
            <dl>
                <dt>用户名：</dt><!--#if(!$isAdd)disabled="disabled"#end-->
                <dd><input name="name" id="name" class="tinput" placeholder="只能输入中文或字母" value="$!user.name"  /></dd>
                <dt>登录密码：</dt>
                <dd><input name="password" id="pass" class="tinput"/></dd>
                <dt>联系电话：</dt>
                <dd><input name="contactPhone" id="phone" value="$!user.contactPhone" class="tinput"/></dd>
                <dt>选择角色：</dt>
                <dd style="height:auto;">
                    <ul>
                    	#if ($roles)
                			#foreach ($r in $roles)
                				#set($checked=false)
								#if ($user && $user.roles)
                					#foreach ($ur in $user.roles)
                       					#if($ur.id==$r.id)
                       						#set($checked=true)
                       					#end
                       				#end
								#end
                       			<li><label><input type="checkbox" name="roleIds" value="$!r.id" #if($checked)checked="checked"#end style="margin:0;" />$!r.name</label></li>
                       		#end
		        		#end

                    </ul>
                </dd>
            </dl>
            <p class="opt">
            <button type="submit" class="btn btnBg">保 存</button>
			<button class="btnBg btnBg1 cancel_all btn" type="button" onclick='window.location.href="/director/users" '>取 消</button>
			
			</p>
        </form>
    </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".main .main_left .sidebar li a").eq(6).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
});
	function yz(){
		var name=$("#name").val();
		var re = /^[\u4e00-\u9fa5a-z]+$/gi;//只能输入汉字和英文字母
		if(name==""){
			alert("用户名不能为空!");
        	 return false;
		}
		if (!re.test(name)) {
			alert("用户名中不能包含特殊字符，只能输入汉字或者英文字母");
        	 return false;
	    }
	    var pass=$("#pass").val();
	    if(pass==""){
			alert("登录密码不能为空!");
        	 return false;
		}
	    if(pass.length<6||pass.length>20){
	    	alert("登录密码位数太短，不能低于6位!");
	    	 return false;
	    }
	   var phone=$("#phone").val();
	    if(phone==""){
			alert("联系电话不能为空!");
        	 return false;
		}
	    var ps=/^0?1[3|4|5|8][0-9]\d{8}$/;
	   if(!ps.test(phone)){
	   	alert("联系电话号码格式不对!");
	   	return false;
	   }
	}
</script>
</html>