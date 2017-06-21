<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Care Manager_责任管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script type="text/javascript" src="/assets/js/top.js"></script>
</head>
<body>
<div class="limitbox pad10">
    <ul class="inpubox clearfix">
    	#if ($ocountrys)
	    	#foreach ($comt in $ocountrys)
        		<li><input type="checkbox" name="communityIds" value="$!comt.id"/><label>$!comt.name</label></li>
        	#end
        #end
    </ul>
    <input type="button" id="button" value="修改" />
</div>
<script>
$(function(){
	$("#button").click(function(){
	debugger
		parent.reload();
	});
});
</script>
</body>
</html>