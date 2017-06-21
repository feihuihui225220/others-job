<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>转诊记录</title>
    <link rel="stylesheet" type="text/css" href="/assets/director/style/xunzhenrecord.css">
	<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
</head>

<body>
#parse("/common/masklayer.tpl")
#parse("/common/dtop.tpl")
#parse("/common/duser.tpl")
<div class="main1">
  <div>
	<div class="contentPer">#parse("/common/dleft.tpl")</div>
   <form action="/director/HTransfer" method="post"  name="searchForm" id="tijiao">
    <div class="personInfo_right fl" style="float: left;">
	      <div class="toptitle">
	        <label>日期:</label>
	        <input type="hidden" name="userId" value="$dirUser.id"/>
			<input class="timedate input1"  name="start" placeholder="开始时间" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!start)">
	        <label class="zhi">至</label>
	        <input class="timedate input1"  name="end" placeholder="结束时间" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!end)" >
	        <select name="state" class="input1 xulie">
							<option value="0">按转诊状态查询</option>
							<option value="1" #if($!state=='1') selected="selected" #end>申请中</option>
							<option value="2" #if($!state=='2') selected="selected" #end>已处理</option>
						</select>
				<select name="esc" class="input1 xulie">
							<option value="1" #if($!esc=='1') selected="selected" #end>按巡诊日期升序</option>
							<option value="0" #if($!esc=='0') selected="selected" #end>按巡诊日期降序</option>
						</select>	
	        <a href="#" onclick="submit()" class="btnBg">查询</a>
	        <a href="#"  class="btnBg da">打印</a>
	      </div>
	      <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="dayin">
	        <tr>
	          <th>转诊日期</th>
	          <th>巡诊组</th>
	          <th>诊断日期</th>
	          <th>诊断机构</th>
	          <th>诊断医生</th>
	          <th>患者症状描述</th>
	          <th>诊断结论</th>
	        </tr>
	       #if ($page)
							#foreach($p in $!page.result)
								<tr class="pointer1" date-href="/director/HTransfer/byId?htId=$!{p.id}&userId=$dirUser.id">
								<td>$!date.format('yyyy-MM-dd HH:mm:ss',$!p.applyTime)</td>
								<td>$!p.createBy</td>
								<td>$!date.format('yyyy-MM-dd HH:mm:ss',$!p.createTime)</td>
								<td>$!p.originalHospital</td>
								<td>$!p.hGroup.doctor</td>
								<td>
								#set($c=$!p.content)
								#if($c.length()>8)
									#set($ce=$c.substring(0,8))
									$!ce...
								#else
									$!c
								#end
								</td>
								<td class="pointer1 btnBg">
									查看
								<!-- #set($h=$!p.handleResult)
								#if($h.length()>8)
									#set($he=$h.substring(0,8))
									$!he...
								#else
									$!h
								#end -->
							</td>
							</tr>
							#end
				#end    
	      </table>
		      <div class="page fr">
		       	#parse("/common/page.tpl")
		      </div>
    </div></form>
  </div>
</div>
</body>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/js/calendar.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script src="$request.contextPath/assets/js/jquery.jqprint-0.3.js"></script>
   <script type="text/javascript">
		$(function(){
		$(".personInfo .personInfo_left .sidebar li a").eq(6).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
			$(".pointer1").click(function(){
				location.href=$(this).attr('date-href');
			});
			$(".timedate").calendar({ format:'yyyy-MM-dd HH:mm:ss' });
			$(".da").click(function(){
		  		$("#dayin").jqprint(); 
		    });
		});  
		function submit(){
			 $("#tijiao").submit();
		}
		
	</script> 
</html>
