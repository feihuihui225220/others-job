<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>转诊信息</title>
    <link href="/assets/director/style/XZuserm.css" rel="stylesheet" type="text/css" />
    <style>
    	table tr td{border:solid #CCC; border-width:0px 1px 1px 0px;}
	table{border:solid #CCC; border-width:1px 0px 0px 1px;}

    </style>
</head>

<body>
#parse("/common/masklayer.tpl")
  #parse("/common/dtop.tpl")
    #parse("/common/duser.tpl")
<div class="main1" >
  <div>
	<div class="contentPer">#parse("/common/dleft.tpl")</div>
    <div class="personInfo_right fl" style="float: left;">
    	<form method="post" id="SelectUser" action="/director/HTransfer/ModifyHtransfer" name="searchForm">
    		<div class="table-wrapper" id="table_w" >
   			<table id="tab_" style="width:600px;margin-left:10px;">
	   			<tr>
	   				<td>巡诊组</td><td>
	   				#set($xun=$!htransfer.hGroup.userName)
	   				#if($xun.length()>12)
	   					#set($xuns=$xun.substring(0,8))
	   					$!xuns...
	   				#else
	   					$!xun
	   					#end
	   					</td>
	   			</tr>
	   			<tr>
	   				<td>申请日期</td><td>$!date.format('yyyy-MM-dd',$!htransfer.createTime)</td>
	   			</tr>
	   			<tr>
	   				<td>申请人</td><td>$!htransfer.rUser.name</td>
	   			</tr>
	   			</table>
	   			<input type="hidden" name="id" value="$!htransfer.id">
		   		<h4>&nbsp;&nbsp;&nbsp;&nbsp;转诊需求概述：</h4>
		   		<label style="margin-left:90px;"><textarea name="content" cols="60" rows="5" id="co">$!htransfer.content</textarea></label>
		   		<h4>&nbsp;&nbsp;&nbsp;&nbsp;转诊结论：</h4>
		   		<label style="margin-left:90px;"><textarea name="handleResult" cols="60" rows="5" id="cs">$!htransfer.handleResult</textarea></label>
		   		<h4>&nbsp;&nbsp;&nbsp;&nbsp;原来医院：<input class="tinput" name="originalHospital" value="$!{htransfer.originalHospital}"></h4>  <br/>
		     	<h4>&nbsp;&nbsp;&nbsp;&nbsp;转诊时间：<input class="tinput" name="applyTime" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!htransfer.applyTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"></h4> <br/>
		     	<h4>&nbsp;&nbsp;&nbsp;&nbsp;转诊医院：<input class="tinput" name="targetHospital" value="$!{htransfer.targetHospital}"></h4>  <br/>
		     	<h4>&nbsp;&nbsp;&nbsp;&nbsp;转诊医生：<input class="tinput" name="changeBy"   value="$!htransfer.hGroup.doctor" readonly="readonly"></h4>
		
		     	<div>#if($sessionUser.super_==false)
		     		<input type="hidden" value="0" id="wancheng">
     					<a href="javascript:history.go(-1)"  style="margin-left:300px;" class="chakan btnBg btnBg1 cancel_all" id="fanhui"  >返回</a>
		     		#else
		     			<input type="hidden" value="1" id="wancheng">
		     			<button  class="button_gm btnBg" style="margin-left:300px;" >提交</button>
		     			<a href="javascript:history.go(-1)"  class="chakan btnBg btnBg1 cancel_all" id="fanhui"  >返回</a>
		     		#end
     			</div>
   		
   		</div>
   		</form>
  	</div>
   </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script>
$(function(){
	/* $('.button_gm').click(function(){
		$('#selectC').submit();
	}); */
/* 	$("#fanhui").click(function(){
		window.location.href="/director/HTransfer";
	}); */
	var wan=$("#wancheng").val();
	if(wan=="0"){
		$('input:text').css("border","0");
		$('input:text').attr("disabled",true);
		$("#co").css("border","0");
		$("#co").attr("disabled",true);
		$("#cs").css("border","0");
		$("#cs").attr("disabled",true);
		$('input:radio').attr("disabled",true);
	};
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

$(".personInfo .personInfo_left .sidebar li a").eq(6).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
	$(".timedate").calendar({ format:'yyyy-MM-dd HH:mm:ss' });
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
	

</script>
</html>