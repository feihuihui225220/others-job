<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap {height:100%; width: 100%;}
		#control{width:100%;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Axu6Vo2pmKAP6DfD6NCwMaQICmmpDNBc"></script>
	<title>行走路线</title>
</head>
<body>
	<div id="allmap"></div>
	<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	 
	map.centerAndZoom(
	new BMap.Point(${positionlist.get(0).get(0)}, ${positionlist.get(1).get(1)}), 17.5);//设置中心城市
	
	map.enableScrollWheelZoom();
	//遍历后台发过来的数据
	var polyline = new BMap.Polyline([
	#foreach ($c in $positionlist)
		new BMap.Point(${c.get(0)}, ${c.get(1)}),
	#end
		],{strokeColor:"#76EE00", strokeWeight:4, strokeOpacity:1});   //创建折线
	map.addOverlay(polyline);   //增加折线
	var markerA = new BMap.Marker(
	new BMap.Point(${positionlist.get(0).get(0)}, ${positionlist.get(0).get(1)}));//起点创建标注
	
	var markerB = new BMap.Marker(
	new BMap.Point(${positionlist.get($size).get(0)}, ${positionlist.get($size).get(1)}));//终点创建标注
	console.log($size);
	var label = new BMap.Label("终点",{offset:new BMap.Size(20,-10)});
	markerB.setLabel(label);//在终点添加标注
	var labe2 = new BMap.Label("起点",{offset:new BMap.Size(20,-10)});
	markerA.setLabel(labe2);//在起点添加标注
	map.addOverlay(markerB);		//添加标注
	map.addOverlay(markerA);		//添加标注
	markerB.setAnimation(BMAP_ANIMATION_BOUNCE); //给重点添加跳动标注
	
</script>
</body>
</html>
		