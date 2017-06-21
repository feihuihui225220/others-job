<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>会诊信息</title>
<link href="/assets/director/style/XZuserm.css" rel="stylesheet" type="text/css" />
    <style>
    	table tr td{border:solid #CCC; border-width:0px 1px 1px 0px;}
		table{border:solid #CCC; border-width:1px 0px 0px 1px;}
    </style>
</head>
<body>
#parse("/common/masklayer.tpl")
#parse("/common/dtop.tpl")
#parse("/common/dmain.tpl")
<div class="personInfo_right fl" style="float: left;">	
<form method="post" id="SelectUser" action="/director/modifyHConsulation" name="searchForm">
   		<div class="table-wrapper" id="table_w" >
   		<table class="detail_chart_list main table_w" id="tab_" style="width:600px;margin-left:10px;">
   			<tr>
   				<td>巡诊组</td><td>
   				#set($xun=$!xunZuName)
   				#if($xun.length()>12)
   					#set($xuns=$xun.substring(0,8))
   					$!xuns...
   				#else
   					$!xunZuName
   					#end
   					</td>
   			</tr>
   			<tr>
   				<td>申请日期</td><td>$!date.format('yyyy-MM-dd',$!HConsultation.createTime)</td>
   			</tr>
   			<tr>
   				<td>申请人</td><td>$!HConsultation.user.name</td>
   			</tr>
   		</table>
   		<input type="hidden" name="userId" value="$!userId">
   		<input type="hidden" name="id" value="$!cid">
   		<h4>&nbsp;&nbsp;&nbsp;&nbsp;会诊需求概述：</h4>
   		<label style="margin-left:90px;"><textarea name="content" cols="60" rows="5">$!HConsultation.content</textarea></label>
     	<h4>&nbsp;&nbsp;&nbsp;&nbsp;会诊时间：<input class="tinput" name="applyTime" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!HConsultation.applyTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"></h4> <br/>
     	<h4>&nbsp;&nbsp;&nbsp;&nbsp;会诊地点：<input class="tinput" name="address" value="$!{HConsultation.address}"></h4>  <br/>
     	<h4>&nbsp;&nbsp;&nbsp;&nbsp;会诊人员：</label><input class="tinput" name="department" value="$!{HConsultation.department}"></h4>
     	#if($!HConsultation.state=='2')
     	<h4>&nbsp;&nbsp;&nbsp;&nbsp;会诊结论：</h4>
     	<label style="margin-left:90px;"><textarea name="ultimateness" cols="60" rows="5">$!HConsultation.ultimateness</textarea></label>
     	#end
     	<!-- <h4>&nbsp;&nbsp;&nbsp;&nbsp;审核状态：</label>
    			<input type="radio" name="state" #if($!HConsultation.state=='0') checked="checked" #end value="0" />未审核
    			<input type="radio" name="state" #if($!HConsultation.state=='1') checked="checked" #end value="1"/>已处理
    			<input type="radio" name="state" #if($!HConsultation.state=='2') checked="checked" #end value="2"/>会诊完成
     	</h4> -->
     	<input type="hidden" value="$!HConsultation.state" id="wancheng">
     	<div>#if($!HConsultation.state=='2')
     			<button  class="chakan btnBg" style="margin-left:300px;" >返回</button>
     		#else
     			<button  style="margin-left:300px;" class="btnBg">提交</button>
     			<button  class="chakan btnBg1 btnBg" >返回</button>
     		#end
     	</div><br/>      
      </div></form>
    </div> 
<script type="text/javascript" src="/assets/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/country_1.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script>
$(function(){
	$(".timedate").calendar({ format:'yyyy-MM-dd ' });
	$('.button_gm').click(function(){
		
		$('#selectC').submit();
	
	});
	$(".chakan").click(function(){
		window.history.go(-1);
	});
	var wan=$("#wancheng").val();
	if(wan==2){
		$('input:text').css("border","0");
		$('input:text').attr("disabled",true);
		$("textarea").css("border","0");
		$("textarea").attr("disabled",true);
		$('input:radio').attr("disabled",true);
	}
$('.gm_right').click(function(){
		 var text=$('.text_ta').val();
		 var id=$(this).attr('date-id');
		  $.ajax({
                    url: "/director/updateTrxt?id="+id+"&ultimateness="+text,
                    success: function (mjson) {
                    alert(mjson);
                    }
            });
	});
	
$(function(){
$(".main .main_left .sidebar li a").eq(5).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
	$(".timedate").calendar({ format:'yyyy-MM-dd HH:mm' });
	$('.button_gm').click(function(){
		var time=$('.timedate').val();
		var address=$('.address').val();
		/*var content=$('.content').val();*/
		if(time!=""&&address!=""){
			$('#SelectUser').submit();
		}else{
			alert("有文本框未填写!");
			return false;
		}
	});
});	
	
});
</script>
</body>
</html>