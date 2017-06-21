<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Axu6Vo2pmKAP6DfD6NCwMaQICmmpDNBc
"></script>
	<title>添加动画标注点</title>
</head>
<body>
	<div id="allmap"></div>
</body>
<script type="text/javascript">
	#foreach ($c in $positionlist)
	var aa=${c.get(0)};
	console.log(aa);
	
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(${c.get(0)},${c.get(1)});
	map.centerAndZoom(point, 15);
	var marker = new BMap.Marker(point);  // 创建标注
	map.addOverlay(marker);               // 将标注添加到地图中
	map.enableScrollWheelZoom();
	marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
	
	#end
</script>
</html>

