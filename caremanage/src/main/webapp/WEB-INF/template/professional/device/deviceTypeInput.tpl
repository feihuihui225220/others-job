<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>设备类型</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<style>
.limitbox .inpubox li label {width:100px;line-height:normal;}
.limitbox .inpubox li{line-height:normal;padding:10px 5px;}
</style>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <form action="/professional/device/type/commit" method="post" class="reg_area fix_pop" style="width:580px">
         <h2>添加设备</h2>   
             <div class="limitbox pad10">
                 <ul class="inpubox clearfix">
                      
                      <li><label>设备类型名称：</label><input type="text" name="name" value="$!{deviceType.name}" /></li>
                      <li><label>设备类型描述：</label><textarea cols="50" rows="5" name="descr">$!{deviceType.descr}</textarea></li>
                      <li><label>设备类型资质：</label><input type="text" name="qualification" value="$!{deviceType.qualification}" /></li>
                 </ul>
            </div>
         <p class="opt">
            <input type="button" class="btn button_delete" onClick="javascripts:history.go(-1)" value="取 消" />
            <button type="submit" class="btn  button_add">添 加</button>
         </p>
		    <input type="hidden" name="page" value="${page.page}" />
		    <input type="hidden" name="num" value="${page.num}" />
		    <input type="hidden" name="id" value="$!{deviceType.id}" />
	</form>
    <div class="footer">
        
    </div>
</div>

</body>
</html>