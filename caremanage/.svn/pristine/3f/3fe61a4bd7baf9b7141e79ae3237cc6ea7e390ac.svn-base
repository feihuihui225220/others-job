<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>培训记录添加</title>
<link href="/assets/newCss/index.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/bootstrap-select.css" />
<script src="/assets/js/pageNavigator.js"></script>
<style>
	#todaytask1{background-color:#35b5f1;color:#fff;}
</style>
</head>
<style>
</style>
<body>
#parse("/common/masklayer.tpl")
	#parse("/common/head.tpl")
	<div class="location">
		<span class="currentlocation">当前位置：</span><span>首页</span>
	</div>
	<div class="main">
		#parse("/common/lhtTeacher.tpl")
		<div class="main_ right content fl">
			<input type="hidden" id="sit" value="$siteIds">
			<div class="search">
				<form action="/professional/activity/mission" id="activity"
					method="post" name="searchForm">
					<label>站点筛选：</label> <select class="selectpicker " name="siteIds"
						multiple data-live-search="true"
						data-live-search-placeholder="Search" data-actions-box="true">
						#foreach($s in $site)
						<option value="$s.id">$s.siteName</option> #end
					</select> <label class="lable_1">日期选择：</label> <input name="start"
						class=" timedate" type="text"
						value="$!date.format('yyyy-MM-dd',$!dateCond.start)" />-<input
						class=" timedate" name="end" type="text"
						value="$!date.format('yyyy-MM-dd',$!dateCond.end)" />  <a class="select" href="#">确定</a>
				</form>
			</div>
			<br>
			<div class="table">
				<table class="table _tale1">
					<tr class="_active">
						<th class="first_">时间</th>
						<th>活动站点</th>
						<th>活动时间</th>
						<th>活动地点</th>
						<th>站点负责人</th>
						<th>联系方式</th>
						<th>课程时长</th>
						<th>印象标签</th>
						<th>专业老师</th>
						<th>活动主题</th>
						<th>活动内容</th>
						<th>活动时长</th>
						<th>活动操作</th>
						<th>排课状态</th>
					</tr>
					#foreach($result in $page.result) #set($m=0) #set($i =
					(($velocityCount + 1)+(${page.pageNo} - 1)*10))
					<tr
						class=" #if($i%2!=0 ) tr_two #else tr_first #end ibtn addadver userid_$!result.id"
						data-id="$!e.id">
						<td>$!date.format('yyyy-MM-dd',$result.pubdate)</td>
						<td>$!result.siteIdName</td>
						<td>$!result.planTime</td>
						<td>活动站点</td>
						<td>站点负责人</td>
						<td>联系方式</td> #set($sessionUser=$!{session.getAttribute("sessionUser")})
						#foreach($npr in $result.programOfVO)
						#if($!npr.teacher==$sessionUser.name&&$npr.parentNode==0)
						<td>$!npr.duration min</td>
						<td>$!npr.keyword</td>
						<td>$!npr.teacher</td> #end #end #foreach($npr in
						$result.programOfVO)
						#if($!npr.teacher==$sessionUser.name&&$npr.parentNode!=0&&$m==0)
						#set($m = $m+1)
						<td>$!npr.progranName</td>
						<td>$!npr.courseContent</td>
						<td>$!npr.duration min</td> #break #end #end #if($m==0)
						<td></td><td></td><td></td> #end
						<td><input type="button"
							class="btn-default add_first toadd  btn" date-id="$!result.id"
							date-parentId="$!result.id" value="排课"></td>
						<td>#if($m==0)未完成#else 已完成 #end</td>
					</tr>
					#foreach($npr in $result.programOfVO)
					#if($!npr.teacher==$sessionUser.name&&$npr.parentNode!=0)
					<tr>
						<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
						<td>$!npr.teacher</td>
						<td>$!npr.progranName</td>
						<td>$!npr.courseContent</td>
						<td>$!npr.duration min</td>
						<td></td>
						<td></td>
					</tr>
					#end #end #foreach($npr in $result.programOfVO)
					#if($!npr.teacher!=$sessionUser.name&&$npr.parentNode==0)
					<tr>
						<td colspan="6"></td>
						<td>$!npr.duration</td>
						<td>$!npr.keyword</td>
						<td>$!npr.teacher</td>
						<td></td><td></td><td></td><td></td><td></td>
					</tr>
					#end #end #end
				</table>
				#parse("/common/page.tpl")

			</div>
			<div class="buton_"></div>
		</div>
	</div>
	</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script>
	$(function() {
	$(".timedate").calendar({format: 'yyyy-MM-dd'});
		$('.toadd')
				.click(
						function() {
							location.href = "/professional/activity/missionTOAdd?planId="
									+ $(this).attr('date-id');
						});
	});
</script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/newJs/plan.js"></script>

</html>