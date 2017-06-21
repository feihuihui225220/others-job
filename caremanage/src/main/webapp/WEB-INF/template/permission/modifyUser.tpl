<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
#if($user.getCateEnum()=="PRO")
<link rel="stylesheet" href="/assets/newCss/index.css" />
#end
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
</head>
<style>
	.div1{position:relative;left:40%}
</style>
<body>

<div class="wrapper">
   #parse("/common/head.tpl")
    <div class="body">
        <form method="post" action="/permission/saveUser" class="reg_area fix_pop" style="width:400px">
            #if($user.id)
            	<h2>修改用户</h2>
				#set($isAdd=false)
				<input type="hidden" name="id" value="$user.id"/>
            #else
            	<h2>添加用户</h2>
				#set($isAdd=true)
            #end	
            <dl>
                <dt>姓名：</dt>
                <dd><input name="name" value="$!user.name" #if(!$isAdd)disabled="disabled"#end  maxlength="5"/></dd>
                <dt>登录密码：</dt>
                <dd><input name="password" /><text class="hidden_t" style="color:red; display:none;" >  *长度不小于6位</text></dd>
                <dt>联系电话：</dt>
                <dd><input name="contactPhone" value="$!user.contactPhone"/></dd>
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
				<button class="btn button_delete" type="button" onclick='window.location.href="/permission/users" '>取 消</button>
				<button type="submit" class="btn  button_gm">保 存</button>
			</p>
        </form>
    </div>
    <div class="footer">
        
    </div>
</div>
</body>
<script>
$(function(){
	$('input[name="password"]').change(function(){
		var length=$(this).val().length;
		if(length<6){
			alert($('.hidden_t').remove('visibility'));
		}
	});
});
</script>
</html>