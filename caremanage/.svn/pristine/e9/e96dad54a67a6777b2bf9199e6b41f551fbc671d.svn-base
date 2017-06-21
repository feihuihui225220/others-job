<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<style>
.limitbox .inpubox li label {width:auto;margin:0;}
.limitbox .inpubox li label input {width:auto;vertical-align:text-bottom;margin:0}
.limitbox .inpubox li div {display:inline;}
</style>
</head>
<body>

<div class="wrapper">
	#parse("/common/head.tpl")
    <form method="post" action="/professional/device/commit" class="reg_area fix_pop" style="width:600px">
	    <input type="hidden" name="page" value="${page.page}" />
	    <input type="hidden" name="num" value="${page.num}" />
	    <input type="hidden" name="id" value="$!{device.id}" />
        <h2>添加设备</h2>   
            <div class="limitbox pad10">
                <ul class="inpubox clearfix">
                    <li><label>设备名称：</label><input type="text" name="name" value="$!{device.name}" /></li>
                    <li><label>设备厂商：</label><input type="text" name="vender" value="$!{device.vender}" /></li>
                    <li><label>设备编号：</label><input type="text" name="deviceNo" value="$!{device.deviceNo}" /></li>
                    <li><label>设备价格：</label><input type="text" name="price" value="#if($device) #set($p = $!{device.price}/100) $p #end" /><label>元</label></li>
                    <li><label>功能说明：</label><textarea name="functionDesc" cols="58" rows="5">$!{device.functionDesc}</textarea></li>
                    <li><label>使用说明：</label><textarea name="useDesc"cols="58" rows="5">$!{device.useDesc}</textarea></li>
                    <li class="w520"><label>设备类型：</label>
                        <div>
                        	#foreach($deviceType in $deviceTypes)
                        		<label for="">
		    					<input type="checkbox" name="deviceTypeIds" value="${deviceType.id}" 
		    						#foreach($deviceId in $device.deviceTypeIds)
		    							#if($deviceId == $deviceType.id)
		    								checked
		    							#end
		    						#end
		    					/>${deviceType.name}&nbsp;&nbsp;&nbsp;
		    					</label>
		    				#end
                        </div>
                    </li>
                </ul>
            </div>
        <p class="opt">
        	<button type="button" class="btn button_delete" onclick="javascript:history.go(-1)">取 消</button>
        	<button type="submit" class="btn  button_add">添 加</button>
        </p>
    </form>
    <div class="footer">
    </div>
</div>
</body>
</html>