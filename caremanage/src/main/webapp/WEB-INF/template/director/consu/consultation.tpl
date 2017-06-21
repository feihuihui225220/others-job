<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>会诊管理</title>
     <link rel="stylesheet" type="text/css" href="/assets/director/style/xunzhenrecord.css">
</head>

<body>
#parse("/common/masklayer.tpl")
  #parse("/common/dtop.tpl")
  #parse("/common/dmain.tpl")
<div class="main1">
  <div>
    <div class="personInfo_right fl" style="float: left;">
   			<div class="toptitle">
   			<form method="post" id="selectC" action="/director/managementconsultation" name="searchForm" >
		        <label>日期:</label>
		        <input type="hidden" name="uId"/>
				<input class="timedate input1"  name="start" placeholder="开始时间" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!dateCond.start)">
		        <label class="zhi">至</label>
		        <input class="timedate input1"  name="end" placeholder="结束时间" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!dateCond.end)" >
		        <select name="statas" class="input1">
		        				<option #if($status==0) selected = "selected" #end value="99">查询全部</option>
								<option #if($status==0) selected = "selected" #end value="0">未审核</option>
						   		<option  #if($status==1) selected = "selected" #end  value="1">已处理</option>
						   		<option  #if($status==2) selected = "selected" #end  value="2">会诊完成</option>
							</select>
					<select name="desc" class="input1">
								<option #if($desc==0) selected = "selected" #end value="0">按申请时间降序</option>
	   							<option  #if($desc==1) selected = "selected" #end  value="1">按申请时间升序</option>
							</select>	
		         <input type="submit" class="btnBg" value="查询" />
		       <!--  <a href="#" onclick="dayin()" class="btnBg">打印</a> -->
		       </form>
		      </div>
		      <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="tab_">
   			<tr>
   				<th>序号</th>
   				<th>申请人</th>
   				<th>性别</th>
   				<th>年龄</th>
   				<th>会诊需求概述</th>
   				<th>会诊状态</th>
   				<th>创建人</th>
   				<th>申请时间</th>
   			</tr>
   			#if ($page)
		                #foreach ($u in $page.result)
		                 #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
	        			<tr class="pointer1" date-href="/director/hconsultation?userId=$!{u.user.id}&id=$u.id">
		        			<td>$i</td>
		        			<td>$!{u.user.name}</td>
		        			<td> #if($!{u.user.gender}==0)女#else男#end</td>
			                <td> $!{u.user.age} </td>
			                <td style="width:300px;"> 
			                #set($str=$!{u.content})
			                #if($str.length()>12)
			                    #set($str=$str.substring(0,12))
			                    $!str ...
			                #else
			                	$!{u.content}
			                #end
			                </td>
			                <td>#if($!{u.state}==0)未审核 #elseif($!{u.state}==1)已处理 #elseif($!{u.state}==2)会诊完成  #end </td>
			                <td> $!{u.createBy} </td>
			                <td>$!date.format('yyyy-MM-dd HH:mm:ss',$!u.createTime)</td>
			                
		        		</tr>
		        		#end
    		#end
   			
   		</table>
			<div class="page fr">
				       	#parse("/common/page.tpl")
				      </div>
  	</div>
   </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script>
$(function(){
$(".main .main_left .sidebar li a").eq(5).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
	$(".timedate").calendar({ format:'yyyy-MM-dd HH:mm:ss' });
	$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
	
	$('.button_gm').click(function(){
		
		$('#selectC').submit();
	
	});
});
</script>
</html>
