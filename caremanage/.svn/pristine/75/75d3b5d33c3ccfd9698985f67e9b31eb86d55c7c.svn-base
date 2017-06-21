<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>活动管理</title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>

<link href="$request.contextPath/assets/css/fullcalendar.css" rel='stylesheet' />
<link href='$request.contextPath/assets/css/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='$request.contextPath/assets/js/moment.min.js'></script>
<script src='$request.contextPath/assets/js/fullcalendar.min.js'></script>
<script src='$request.contextPath/assets/js/zh-cn.js'></script>
<style>
.actbox1{height:50%; margin-right:10%;margin-left:10%;}
.cm_addplan{margin-left:10%;float：both;}
 body{background:#D9EBEB}
</style>
</head>
<body>

	<div class="wrapper">
	 #parse("/common/head.tpl")
	  
		<div class="cm_addplan">
			<br/>
			<button class="button_add"   onclick="addPlan();">添加活动</button>
		</div>
		<div>
				<div class="actbox1" id='calendar'></div>
		</div>	
		</div>
		<form method="post" id="addform" action="/professional/activity/jumptopage" class="reg_area fix_pop" style="width:600px;display:none;">
    
        <h2>添加活动</h2>   
            <div class="limitbox pad10">
                <ul class="inpubox clearfix">
                    <li><label>时间：</label><input type="text" name="pubdate" class="timedate" onclick="init();" ></li>
                     
                     <li><label>活动名称：</label>  <input type="text" name="planName" > 
                    </li>
                    <li><label>活动内容：</label><textarea cols="58" rows="5" name="planDesc" >$!{result.remark}</textarea></li>
                </ul>
            </div>
        <p class="opt">
	        <a href="" class="btn button_btn" onclick="cancel();">取 消</a>
	        <button type="submit" class="btn  button_btn">添 加</button>
        </p>
    </form>
	</div>
	<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
	 <script>
	 	 
	 	function addPlan(){
	 		location.href="/professional/activity/jumptopage";
	 	}
 
	 	function init(){
	 		$(".timedate").calendar({ format:'yyyy-MM-dd  HH:mm:ss' });
	 	}
	
$('#calendar').fullCalendar({
	 
	header: {
		left: 'prev,next today',
		center: 'title',
	},
	slotMinutes:240,
	minTime:'00:00:00',
	maxTime:'23:59:59',
	editable: false,
	allDaySlot : false,	
	monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    monthNamesShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
   
	events: [
		 		 #foreach ($result in $activityList)
				{   
					title: '活动：$!result.planName',
				    start: '$!date.format('yyyy-MM-dd HH:mm',$!result.pubdate)',
				    url:'/professional/activity/oneactivity?id=$!result.id'
				},
				#end
		 
	],
});
	 </script>
	  
	  
</body>

</html>