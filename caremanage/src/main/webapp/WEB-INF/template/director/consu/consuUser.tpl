<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>会诊记录</title>
<link rel="stylesheet" type="text/css" href="../assets/director/style/filing.css">
</head>
<body>#set($dirUser=$!{session.getAttribute("dirUser")})
#parse("/common/dtop.tpl")
#parse("/common/duser.tpl")
<div class="main1">
<div class="contentPer">#parse("/common/dleft.tpl")</div>
	<div class="personInfo_right fl">
	
	 
			<form method="post" id="selectC" action="/consu/pageResult"  >
		   		 <input type="hidden" class="userId" name="userId" value="$dirUser.id">
		   		<label class="label_c">查询日期:
		   			<input class="timedate input2"  name="start" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!dateCond.start)">
		   		至<input class="timedate input2" name="end" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!dateCond.end)" >
			    <select name="desc" class="select260 select_w input2">
			   		<option #if($desc==0) selected = "selected" #end value="0">按申请时间降序</option>
			   		<option  #if($desc==1) selected = "selected" #end  value="1">按申请时间升序</option>
		   		</select>
		   		<a href="#" onclick="submit()" class="btnBg">查询</a>		   		
		   		<a href="#"  class="btnBg" id="dayins">打印</a>
		   		</label>
		   		</form>
			 	<table class="commonTable" id="dayin" style="width:900px; text-align: center;">
		   			<tr>
		   				<th>会诊日期</th>
		   				<th style="display:none">会诊申请时间</th>
		   				<th style="display:none">审批时间</th>
		   				<th style="display:none">会诊地点</th>
		   				<th style="display:none">审批人</th>
		   				<th style="display:none">id</th>
		   				<th style="display:none">结论</th>
		   				<th>会诊需求概述</th>
		   				<th>会诊医生</th>
		   				<th>巡诊组</th>
		   				<th>结论</th>
		   			</tr>
		   			#if($page)
		                #foreach($u in $page.result)
		    			<tr class="pointer1">
		        			<td>$!date.format('yyyy-MM-dd HH:mm:ss',$!{u.applyTime_})</td>
		        			<td style="display:none">$!date.format('yyyy-MM-dd HH:mm:ss',$!{u.createTime})</td>
		        			<td style="display:none">$!date.format('yyyy-MM-dd HH:mm:ss',$!{u.changeTime})</td>
		        			<td style="display:none"> $!{u.address}</td>
		        			<td style="display:none"> $!{u.changeBy}</td>
		        			<td style="display:none"> $!{u.id}</td>
		        			<td style="display:none"> $!{u.ultimateness}</td>
		        			<td> 
		        			#set($str=$!u.content)
		        			#if($str.length()>6)
		        				#set($strs=$str.substring(0,6))
    							$!strs...
    						#else
    							$!u.content	
		        			#end
		        			</td>
		        			<td style="display: none;">$!u.content</td>
			                <td> $!{u.department} </td>
			                <td> $!{u.groupName} </td>
			                #if(!$u.applyTime_)
			              		<td class="btnBg">待主任批准</td>
					         #else
					                	#if($u.ultimateness.length()>0)
					                	 <td class="jielun btnBg">查看结论</td>
					                	#else
					                		 #if(!$sessionUser.super_)
					                	 		<td class="jielun btnBg">添加结论$!sessionUser.name</td>
					                	 	#else
					                	 		 <td class="jielun btnBg">查看结论</td>
					                	 	#end
					                	#end
					                #end
		        		</tr>
		        		#end
		    		#end
		   		</table>
		      #parse("/common/page.tpl")
   		 </div>
  </div>
   <div  class="Detail" style="display: none; position: absolute;z-index: 10; left: 20%;top:20%; ">
     <form action="/consu/addHConsultation" method="post"> 
			 <table  border="0.5" style="width:950px; height:250px; background-color: #def2f5; margin: 2px;" class="commonTable">
				<tr>
					<td style="width:130px;text-align:right;">会诊申请时间：</td>
					<td style="text-align:center;" id="hstime"></td>
					<td style="text-align:right;width:100px;">巡诊组：</td>#set($user=$session.getAttribute("sessionUser"))
					<td style="text-align:center;width:200px;" id="sqr"></td>
					<td style="text-align:right;width:100px;">审批时间：</td>
					<td style="text-align:center;" id="sptime"></td>
				</tr>
				<tr>
				<td style="width:130px;text-align:right;">会诊时间：</td>
				<td style="text-align:center;" id="htime"></td>
				<td style="text-align:right;width:100px;">会诊地点：</td>
				<td style="text-align:center;width:200px;" id="addse"></td>
				<td style="text-align:right;width:100px;">审批人：</td>
				<td style="text-align:center;" id="shr"></td>
				<input type="hidden" name="id" id="id" />
			</tr>
			<tr>
				<td style="width:130px;text-align:right;">会诊概述：</td>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td style="width:130px;text-align:right;"></td>
				<td colspan="5" rowspan="1" id="content" style="text-align: left;">&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td style="width:130px;text-align:right;">会诊记录：</td>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td colspan="6" rowspan="1"><textarea name="ultimateness" class="medhis"  id="jielun"></textarea></td>
			</tr>
			<tr>
				<td colspan="6" style="text-align:right;" >记录人：$!user.name &nbsp;&nbsp;&nbsp; 
				#if(!$sessionUser.super_)
				<input type="submit" style="width:100px;" class="btnBg tijiao" value="提交" />
				#else
					<input type="button" style="width:100px;" class="btnBg1 btnBg tijiao" value="提交"/>
				#end
					<input type="button" style="width:100px;" class="btnBg1 btnBg close" value="取消" />
						&nbsp;&nbsp;&nbsp;</td>
			</tr>
			</table>
			</form>
    </div>
<script type="text/javascript" src="/assets/js/jquery-1.8.0.min.js"></script> 
<script type="text/javascript" src="/assets/js/jquery.jqprint-0.3.js"></script>
<script type="text/javascript" src="/assets/js/calendar.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
function submit(){
	 $("#selectC").submit();
}
$(function(){
$(".personInfo .personInfo_left .sidebar li a").eq(5).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
	$("#dayins").click(function(){
  		$("#dayin").jqprint(); 
    });
    $(".close").click(function(){
    	location.reload();
  		$(".Detail").hide();
    });
	$(".jielun").click(function(){
		var a=$(this).parent().children().eq(0).text();
		$("#htime").text(a);
		var b=$(this).parent().children().eq(1).text();
		$("#hstime").text(b);
		var c=$(this).parent().children().eq(2).text();
		$("#sptime").text(c);
		var d=$(this).parent().children().eq(3).text();
		$("#addse").text(d);
		var e=$(this).parent().children().eq(4).text();
		$("#shr").text(e);
		var f=$(this).parent().children().eq(5).text();
		$("#id").val(f);
		var g=$(this).parent().children().eq(6).text();
		$("#jielun").text(g);
		var con=$(this).parent().children().eq(8).text();
		$("#content").text(con);
		var h=$(this).parent().children().eq(10).text();
		$("#sqr").text(h);
		var ga=$.trim(g);
		if(ga!=""){
			$(".tijiao").attr({"disabled":"disabled"});
			$(".tijiao").addClass("btnBg1");
		}
		$(".Detail").show();
	});
	$(".timedate").calendar({ format:'yyyy-MM-dd HH:mm:ss' });
});

</script>
</body>
</html>