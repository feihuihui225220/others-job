<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body">
        <form method="post" action="/permission/saveResource" class="reg_area fix_pop" style="width:400px">
			#if($resource.id)
            	<h2>修改菜单</h2>
				#set($isAdd=false)
				<input type="hidden" name="id" value="$!resource.id"/>
            #else
            	<h2>添加菜单</h2>
				#set($isAdd=true)
            #end
            <dl>
                <dt>名称：</dt>
                <dd><input name="name" value="$!resource.name"/></dd>
                <dt>URL：</dt>
                <dd><input name="url" value="$!resource.url"/></dd>
            </dl>
            <p class="opt">
				<button onclick="window.location.href='/permission/resources'" type="button" class="btn button_delete" >取 消</button>
				<button type="submit" class="btn  button_gm">保 存</button>
			</p>
        </form>
    </div>
    <div class="footer">
        
    </div>
</div>
</body>
</html>