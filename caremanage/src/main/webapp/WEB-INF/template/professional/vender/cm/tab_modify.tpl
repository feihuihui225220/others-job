<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>CallCenter事务办理_公共服务</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
    <div class="body bodyline pad10" style="width:900px;margin:10px auto">
        <form method="post" action="/professional/vender/tab/modify/commit">
        	<input type="hidden" name="id" value="${venderVO.id}" /> 
        	<input type="hidden" name="longitude" value="$!{venderVO.longitude}">
        <input type="hidden" name="latitude" value="$!{venderVO.latitude}">
            <div class="usedetail clearfix fix_complain">
                <table class="tb">
                    <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/><col class="col5"/><col class="col6"/>
                    <tr>
                        <td class="t_r">服务商名称：</td>
                        <td class="t_l"><input type="text" name="name" value="${venderVO.name}" /></td>
                        <td class="t_r">联系电话：</td>
                        <td class="t_l"><input type="text" name="contactPhone" value="${venderVO.contactPhone}" /></td>
                        <td class="t_r">管理员：</td>
                        <td class="t_l">${venderVO.userName}</td>
                    </tr>
                    <tr>
                        <td class="t_r">服务类别：</td>
                        <td class="t_l">专业服务</td>
                        <td class="t_r">服务分类：</td>
                        <td class="t_l">${venderVO.categoryName}</td>
                        <td class="t_r">评级</td>
                        <td class="t_l">
                        	#if($venderVO.star > 0)
	                    		#foreach($i in [1..6])
	                    		★
		                    		#if($i == $venderVO.star)
		                    			#break;
		                    		#end
	                    		#end
                    		#end
                        </td>
                    </tr>
                    <tr>
                        <td class="t_r">办公地址：</td>
                        <td colspan="3" class="t_l"><input type="text" name="contactAddr" value="${venderVO.contactAddr}" size="50" /></td>
                        <td class="t_r">位置：</td>
                        <td class="t_l"><input type="button" value="点击选择" id="pos_btn"></td>
                    </tr>
                    <tr>
                        <td class="t_r">简介：</td>
                        <td colspan="5" class="t_l"><textarea name="introduction" cols="44" rows="4">${venderVO.introduction}</textarea></td>
                    </tr>
                </table>
            </div>
            <div class="usertitle mgb10 strong clearfix">
            	<div class="f_r fr_itbn">
            	<button class="addulimit button_gm">保 存</button>
            	<button class="button_delete" type="button" onClick="javascripts:history.go(-1)"> 返 回</button>
            </div>
           </div>
        </form>
    </div>
    <div class="footer"></div>
		<div id="map" class="hide" style="width:600px;height:459px;">
</div>
</p>
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
<script type="text/javascript">
$(function(){
	//百度地图api
	var map = new BMap.Map("map",{enableMapClick:false});   
	//单击获取点击的经纬度
	map.addEventListener("click",function(e){
		console.debug(e.point.lng+","+e.point.lat)
		//删除原有点
		var allOverlay = map.getOverlays();
		for (var i = 0; i < allOverlay.length; i++){
			map.removeOverlay(allOverlay[i]); 
		}
		//设置input值
		$("input[name='longitude']").val(e.point.lng);
		$("input[name='latitude']").val(e.point.lat);
		//画点
		var clickpoint = new BMap.Point(e.point.lng, e.point.lat);
		var marker = new BMap.Marker(clickpoint);
		map.addOverlay(marker);
		//改变按钮颜色
		$('#pos_btn').css({background:'#3385ff',width:'auto'});
		$('#pos_btn').val(e.point.lng+","+e.point.lat);
	});
	var point = new BMap.Point(116.404081,39.924226);
	map.centerAndZoom(point, 15);
	map.enableScrollWheelZoom(true);
	map.setDefaultCursor("crosshair");
	
	 //地图
    $('#pos_btn').click(function(){
    	$.layer({
            type : 1,
            title : '选择位置',
            offset:['100px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            area : ['600px','460'],
            page : {dom : '#map'}
        });

    });

    $(window).unload(function(){
        window.parent.location.reload();
    });
});
</script>
</body>
</html>