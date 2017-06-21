<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>治疗记录</title>
<link rel="stylesheet" type="text/css" href="/assets/director/style/xunzhenrecord.css">
</head>
<body>
#parse("/common/masklayer.tpl")
#parse("/common/dtop.tpl")
#parse("/common/duser.tpl")
<div class="main1">
     <div>
     #set ($sessionUser=$!{session.getAttribute("sessionUser")})
     <div class="contentPer">#parse("/common/dleft.tpl")</div>
	 <form method="post" id="tijiao" action="/director/htreatuser/page" name="searchForm"> 
     <div class="personInfo_right fl" style="float: left;">         
	      <div class="toptitle">	      
	        <label>日期:</label>
			<input class="timedate input1"  name="start" placeholder="开始时间" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!start)">
	        <label class="zhi">至</label>
	        <input class="timedate input1"  name="end" placeholder="结束时间" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!end)" >
	        <input type="hidden" name="userId" id="userId" value="$!userId" /> 
	        <a  onclick="submit()" class="btnBg">查询</a>
            <a  class="btnBg" id="print">打印</a>
	   		<!-- <a href="/director/htreatuser/savehtml?userId=$!{userId}" id="add" class="btnBg">新添加</a>  			 -->
	      </div>
	      
	      <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="dayin" >
	        <tbody>
	        <tr>
   				<th>序号</th>
   				<th>申请人</th>
   				<th>巡诊组</th>
   				<th>治疗需求</th>
   				<th>创建时间</th>
   				<th>登记人</th>
   			</tr>  
   			#if ($page)
		                #foreach ($u in $page.result)
		                 #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
	        			<tr class="" date-href="/director/user?userId=$!{u.id}">
		        			<td>$!{i}</td>
		        			<td>$!{u.get(1)}</td>
			                <td>
			                #set($strs=$!u.get(2))
			                #if($strs.length()>12)
			                    #set($strs=$strs.substring(0,12))
			                    $!strs...
			                #else
			                	$!u.get(2)
			                #end
			               </td>
			                <td> 
			                #set($str=$!u.get(4))
			                #if($str.length()>12)
			                    #set($str=$str.substring(0,12))
			                    $!str...
			                #else
			                	$!u.get(4)
			                #end
			               </td>
			                <td> $!{u.get(3)} </td>
			                <td> $!{u.get(5)}</td>
		        		</tr>
		        		#end
    		#end
	       	</tbody>  	
	      </table>
		      <div class="page fr">
		       	#parse("/common/page.tpl")
		      </div>
       </div>
     </form>
</div>
</div>
<script src="/assets/js/jquery-1.8.0.min.js"></script> 
<script src="$request.contextPath/assets/js/jquery.jqprint-0.3.js"></script>
<script src="/assets/js/country_1.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script>
function submit(){
	 $("#tijiao").submit();
	
}
$(function(){
	$("#print").click(function(){
		 $("#dayin").jqprint();
	});
$(".personInfo .personInfo_left .sidebar li a").eq(7).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
	$(".timedate").calendar({ format:'yyyy-MM-dd ' });
	$("#add").click(function(){
		$('#SelectUser').submit();
	});
	$(".pointer1").click(function(){
		location.href=$(this).attr('date-href');
	});
	
});
</script>
</body>
</html>