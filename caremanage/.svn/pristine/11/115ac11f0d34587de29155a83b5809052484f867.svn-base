<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>专业服务-客户管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css">
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script>
$(function(){
 $(".timedate").calendar({ format:'yyyy-MM-dd' });
})
</script>
<style>
	 
	#if($sessionUser.cateEnum.type==3)
		#left{background-color: #16A5AD;}
		.nav1{background-color: #16A5AD;}
		.a_Special_4{position: relative;top: -45px;color: #F7FCFC;}
	#end
	 #assess{margin-left:25%;padding-top:50px;}
</style>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
       <div id="left">
	        #parse("/common/providers.tpl")
       </div>
   	   <div class="main">
    		<div id="assess">
    			<h1>根据游戏Id下载选中时间段内游戏评估信息</h1><br><br>
    			<p>ps:终止时间不包括当天，即选择2016/11/16数据时请选择2016-11-17</p><br>
    			<form id="fromdown" action="/gamet/assessgds/game">
    				游戏Id:<select class="text150" name="gameId">
    					<option value="9">抢元宝</option>
    					<option value="10">咬手指</option>
    					<option value="11">摘苹果</option>
    					<option value="12">闪格子</option>
    					<option value="13">采花朵</option>
    					<option value="14">找水果</option>
    					<option value="15">转转乐</option>
    					<option value="16">转魔方</option>
    				</select>
    		  	 时间：
    		  	 <input class="timedate text150 start" name="start" value="$!date.format('yyyy-MM-dd',$!start)"">
    		  	 <input class="timedate text150 end" name="end" value="$!date.format('yyyy-MM-dd',$!end)""> 
    			 <input type="button" class="button_gm" value="下载">
    			</form>
    		</div>
       </div> 
</div>
<script>
$(function(){
$('.button_gm').click(function(){
	var start=$('.start').val();
	var end=$('.end').val();
	var time1 = new Date(start);
	var time2 = new Date(end);
	if(time1>time2){
		alert("初试时间不能大于终止时间！");
		return false;
	}
	$('#fromdown').submit();
});
	
	
})
</script>
</body>
</html>