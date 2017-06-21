<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>转诊管理</title>
       <link rel="stylesheet" type="text/css" href="/assets/director/style/xunzhenrecord.css">
</head>
<body>
#parse("/common/masklayer.tpl")
  #parse("/common/dtop.tpl")
  #parse("/common/dmain.tpl")
<div class="main1">
  <div>
    <div class="personInfo_right fl" style="float: left;">
    <form action="/director/HTransfer" method="post" name="searchForm">
   			 <div class="toptitle">
		        <label>日期:</label>
		        <input type="hidden" name="uId"/>
				<input class="timedate input1"  name="start" placeholder="开始时间" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!start)">
		        <label class="zhi">至</label>
		        <input class="timedate input1"  name="end" placeholder="结束时间" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!end)" >
		        <select name="state" class="input1">
								<option value="0">按转诊状态查询</option>
								<option value="1" #if($!state=='1') selected="selected" #end>申请中</option>
								<option value="2" #if($!state=='2') selected="selected" #end>已处理</option>
							</select>
					<select name="esc" class="input1">
								<option value="0" #if($!esc=='0') selected="selected" #end>按申请时间降序</option>
								<option value="1" #if($!esc=='1') selected="selected" #end>按申请时间升序</option>
							</select>	
		        <input type="submit" class="btnBg" value="查询" />
		       <!--  <a href="#" onclick="dayin()" class="btnBg">打印</a> -->
		      </div>
				<div class="table">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="commonTable">
						<tr>
							<th>序号</th>
							<th>申请人</th>
							<th>性别</th>
							<th>年龄</th>
							<th style="width:200px;">转诊需求概述</th>
							<th style="width:80px;">转诊状态</th>
							<th>巡诊组</th>				
							<th style="width:200px;">申请时间</th>
						</tr>
				#if($page)
						#foreach($p in $!page.result)<!--date-href="/director/user?userId=$!{p.rUser.id}"-->
							<tr class="pointer1" date-href="/director/HTransfer/byId?htId=$!{p.id}&userId=$!{p.rUser.id}">
							<td>#set($i =$velocityCount + 1)$i</td>
							<td>$!p.rUser.name</td>
							<td>#if($!p.rUser.gender=='0')女
								#else 男  #end</td>
							<td>$!p.rUser.age</td>
							<td class="miaoshu">
							#set($c=$!p.content)
							#if($c.length()>8)
								#set($ce=$c.substring(0,8))
								$!ce...
							#else
								$!c
							#end
							</td>
							<td>#if($!p.state=='1')申请中
								#else 已处理  #end</td>
							<td>$!p.createBy</td>
							<td>$!date.format('yyyy-MM-dd HH:mm:ss',$!p.applyTime)</td>
						</tr>
						#end
						#end
					</table>
						<div class="page fr">
					       	#parse("/common/page.tpl")
					      </div>
					</div>
				</form>
				
				#set($user=$session.getAttribute("sessionUser"))
			</div>
  	</div>
   </div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/assets/js/calendar.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
<script type="text/javascript">
$(function(){
$(".main .main_left .sidebar li a").eq(4).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
		$(".timedate").calendar({ format:'yyyy-MM-dd HH:mm:ss' });
		$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
	
});
</script>
</html>