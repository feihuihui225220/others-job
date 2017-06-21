<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>培训记录添加</title>
  <link href="/assets/newCss/common.css" rel="stylesheet" type="text/css">
    <link href="/assets/newCss/statistics.css" rel="stylesheet" type="text/css">
<link href="/assets/newCss/mytask.css" rel="stylesheet" type="text/css">
<script src="/assets/js/pageNavigator.js"></script>

</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
		#parse("/common/lhtTeacher.tpl")
		<div class="content fl">
    	<div class="wrap">
		<form  action="/professional/activity/missionTOAdd"   method="post" id="missiont"  name="searchForm">
			<div class="impressLabel"><span>印象标签：</span><span class="label1">$!NactivityProgramOfEvent[0]</span><span class="courseTime">课程时长：</span><span>$!NactivityProgramOfEvent[2]min</span></div>
			<div class="addCourse">
        				<span>添加课程：</span>
        				<select name="type" class="courseList">
				            <option #if($!type==0) selected="selected" #end value="0">按印象标签搜索</option>
				            <option #if($!type==1) selected="selected" #end value="1">按课件名称搜索</option>
				            <option #if($!type==2) selected="selected" #end value="2">按其他标签搜索</option>
				            <option #if($!type==3) selected="selected" #end value="3">按辅具搜索</option></select>
				            <input type="text" name="seek" class="otherLabel" placeholder="请输入其他标签或课件名称">
				</label>
				<input type="button" class="select missionTOAdd_" value="确定"></div>
				<input type="hidden" name="planId" value="$planId">
		</form>
		<input id="_times" type="hidden" value="$times">
		<input id="_times1" type="hidden" value="$NactivityProgramOfEvent[2]">
		<form  action="/professional/activity/missionAdd"   method="post" id="missionAdd">
			<input name="progranId" type="hidden" value="$NactivityProgramOfEvent[1]">
			<input name="planId" type="hidden" value="$planId">
		<input class="submit_mission" type="button" value="添加">
			<table class="table _tale1" >
				<tr class="_active">
					<th>序号</th>
					<th>活动主题</th>
					<th>活动时长</th>
					<th>调用次数</th>
					<th><label class="checketx">选择添加<input  class="checket1"  type="checkbox">全选</label></th>
				</tr>
				#foreach($result in $page.result)
				 #set($i = ($velocityCount + 1))
				<tr class=" #if($i%2!=0 ) tr_two #else tr_first #end ibtn addadver" >
					<td>$i</td>
					<td>$result.programName</td>
					<td>$!result.programTime</td>
					<td>$result.count</td>
					<td><label><input type="checkbox" class="checket2">添加<input type="hidden" class="programId" type="hidden" value="$result.id"><input type="hidden" class="programNmae" value="$result.programName"><input type="hidden" class="programTime" value="$result.programTime"></label></td>
				<tr>
				#end
			</table>
			 #parse("/common/page.tpl")
		</form>	
		<div class="buton_"></div>
		</div>
	</div>	
</div>	
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/newJs/plan.js"></script>
<script src="/assets/js/pageNavigator.js"></script>

</html>