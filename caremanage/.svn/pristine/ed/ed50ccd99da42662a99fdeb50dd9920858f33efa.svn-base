<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />

<title>添加角色</title>
<link href="/assets/director/style/XZuserm.css" rel="stylesheet" type="text/css">
</head>
<body>
#parse("/common/dtop.tpl")
#parse("/common/dmain.tpl")
<div class="main1">
    <div class="personInfo_right fl" style="float: left;">
    <div  style="width:300px;">
        <form id="from" method="post" action="/permission/saveRoles" class="reg_area fix_pop" style="width:400px">
            #if($role.id)
            	<h2>修改角色</h2>
				#set($isAdd=false)
				<input type="hidden" name="id" value="$!role.id"/>
            #else
            	<h2>添加角色</h2>
				#set($isAdd=true)
            #end
            <dl>
                <dt>名称：</dt>
                <dd><input  name="name" value="$!role.name" class="tinput"/></dd>
                <dt>描述：</dt>
                <dd><input  name="descr" value="$!role.descr" class="tinput"/></dd>
            </dl>
            <p class="opt" style="margin-top:20px;">
            	<input type="button" id="add_from" class=" button_add btnBg" value="保 存"/>
				<button class="btn button_delete btnBg btnBg1 cancel_all" type="button" onclick='window.location.href="/director/roles" '>取 消</button>
				
			</p>
        </form>
    </div>
</div>
</div>

</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script>
	$(function(){
		$(".main .main_left .sidebar li a").eq(7).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
		$('#add_from').click(function(){
			var name=$('[name=name]').val();
			var descr=$('[name=descr]').val();
			if(name==""){
				alert("名称不能为空!");
				return false;
			}
			if(descr==""){
				alert("描述不能为空!");
				return false;
			}
			$('#from').submit();
		});
	
	});
</script>
</html>