<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>添加活动</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap-select.css"/>
    <link rel="stylesheet" href="/assets/newCss/plan.css"/>
    <link rel="stylesheet" href="/assets/newCss/index.css" />
    <style>
    	.divhide{display: none;}
    </style>
</head>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
	<div id="right" >
		<div class="right_top main_">
			<label class="main_lable lable_c2 lable1 ">①基本信息</label>
			<label class="main_lable lable_c1 lable2">②选择站点时间</label>
			<label class="main_lable lable_c1 label3">③完成站点课程</label>
		</div>
		<form method="post" id="addActivity" action="/professional/activity/addthree"  >
		<div class="TokinagaZ"></div>
		<div class="div_one" date-id="0">
			<label>选择站点：</label>
			<select class="selectpicker " multiple data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
              #foreach($m in $mVenderSite)
              	<option value="$m.id">$m.siteName</option>
              #end
            </select><br><br><br><br>
			<label>活动时间：</label>
			<select class="time_1">
				#foreach($foo in [0..23])
				<option value=$foo>$foo 时</option>
				#end
			</select>
			<select class="min_1">
				#foreach($foo in [0..59])
				<option value=$foo>$foo 分</option>
				#end
			</select>-
			<select  class="time_2">
				#foreach($foo in [0..23])
				<option value=$foo>$foo 时</option>
				#end
			</select>
			<select class="min_2">
				#foreach($foo in [0..59])
				<option value=$foo>$foo 分</option>
				#end
			</select><label> 活动时长：</label> <input id="min" placeholder="自动生成，不可编辑" readOnly="true" >分钟 <br><br><br><br>
			<label>方案时间：</label><input class="timedate start" type="text" value="$!date.format('yyyy-MM-dd',$!dateCond.end)">-<input class="timedate end" type="text" value="$!date.format('yyyy-MM-dd',$!dateCond.end)"><br><br><br><br>
			<input id="checkes" type='checkbox'>选择<br>特别提示：<input disabled="true" placeholder="节假日等特殊情况说明，未举办缘由显示备注。" id="remark" name="remark">
			<div class="top_bottom">
				<input class="btn-default add_first btn add_one" type="button" value="下一步">
			</div>
		</div>
		<div class="div_two divhide"><!-- divhide -->
			<table class="table _tale1">
				<tr class="_active">
					<th>站点名称</th>
					<th>星期一</th>
					<th>星期二</th>
					<th>星期三</th>
					<th>星期四</th>
					<th>星期五</th>
					<th>星期六</th>
					<th>星期日</th>
				</tr>
			</table>
			<div class="top_bottom ">
				<input class="btn-default add_first btn add_two" type="button" value="下一步">
			</div>
		</div>
		<div class="div_three table_diaplay">
			<label class="weeks"></label>
			<div class="_div_three"></div>
			<div class="top_bottom">
				<input class="btn-default add_first btn add_three" type="button" style="margin-right: 0px;" value="下一步">
			</div>
		</div>
		</form>
        </div> 
	</div>	
</div>	
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/cookie.js"></script>
<script src="/assets/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/assets/newJs/plan.js"></script>
<script>
$(function(){
    $(".timedate").calendar({
        format : 'yyyy-MM-dd'
    }).css({
        width : '90px',
        height : '28px'
    });
});
</script>
</html>