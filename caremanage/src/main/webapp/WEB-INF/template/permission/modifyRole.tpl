<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<title>添加角色</title>
#parse("/common/top.tpl")
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body">
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
                <dd><input  name="name" value="$!role.descr" maxlength="6"/></dd>
                <dt>描述：</dt>
                <dd><input  name="descr" value="$!role.descr"/></dd>
            </dl>
            <p class="opt">
				<button class="btn button_delete" type="button" onclick='window.location.href="/permission/roles" '>取 消</button>
				<input type="button" id="add_from" class="btn  button_add" value="保 存"/>
			</p>
        </form>
    </div>
</div>
</body>
<script>
	$(function(){
		$('#add_from').click(function(){
			var name=$('[name=name]').val();
			var descr=$('[name=descr]').val();
			if(name!=null&&name!=""){
				$('#from').submit();
			}
			
		});
	
	})
</script>
</html>