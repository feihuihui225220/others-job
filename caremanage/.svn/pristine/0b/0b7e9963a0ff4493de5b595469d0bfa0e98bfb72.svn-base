<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel=stylesheet href="$request.contextPath/assets/css/jquery.calendarPicker.css" type="text/css" media="screen">
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="$request.contextPath/assets/js/jquery.calendarPicker.js"></script>
<script type="text/javascript" src="$request.contextPath/assets/js/jquery.mousewheel.js"></script>
<style>
.margin{margin-top:10px;position: relative; width:50px; height:50px; background-color:#12D4E0; border-radius:25px; float:left ; z-index:12}
label{font-size:16px;}
.lable34{position: relative; left:-381px;}
.lable1{ display: inline-block; vertical-align: middle;autosize:false; Dock:FILL; height:110px;padding-top:30px;margin-right:20px;}
.lable3{ display: inline-block; vertical-align: middle;width:300px; autosize:false;Dock:FILL;height:110px;padding-top:30px;margin-right:20px;}
.lable2{display: inline-block; vertical-align: middle;autosize:false;width:200px;Dock:FILL;height:110px;padding-top:30px;margin-right:20px;}
.span{height:50px; line-height:50px; display:block; color:#FFF; text-align:center;}
.button_x{margin-left:93%;}
.tex{font-family:"Microsoft YaHei",微软雅黑,"MicrosoftJhengHei",华文细黑,STHeiti,MingLiu;font-weight:bold;}
</style>
</head>
<body>
	<div class="wrapper">
				<div id="dsel1" style="width:840px"></div><br>
				<!--<button class="button_gm button_x" userId='$!{userId}'  onclick="addOther(this);">制定计划</button>-->
         			<ul id="paln_ul">
         					#set($i=1)
         					#foreach ($result in $mPlanList)
							#if($i%2==0)
							<li class="remove" style="height:120px; background-color:#EBDDF5; position: relative; ">
								<div class="margin" >
								<span class="span" >$i</span>
								</div>
								<div style=" float:left;border-right:1px dashed blue; height:120px; width:1px;position:relative;left:-25px;"></div>
								<label class="lable1"> $!{result.planTime}</label>
								<label class="lable3">$!{result.planName}</label>
								 	#foreach($vo in $result.programOfVO)
										#if($!{velocityCount}==0)
										<label class="lable34"><text class='tex'>专业老师：$vo.teacher </text>  时长： $vo.duration 课题名称： $vo.progranName    </label> 
										#end  
									#end  
							</li>
							#else
							<li class="remove" style="height:120px; background-color:#CECBC8; position: relative; ">
								<div class="margin" >
								<span class="span" >$i</span>
								</div>
								<div style=" float:left;border-right:1px dashed blue; height:120px; width:1px;position:relative;left:-25px;"></div>
								<label class="lable1"> $!{result.planTime}</label>
								<label class="lable3">$!{result.planName}</label>
								 	#foreach($vo in $result.programOfVO)
										#if($!{velocityCount}==0)
										<label class="lable34">&nbsp;<text class='tex'>专业老师：$vo.teacher </text> 时长： $vo.duration  课题名称： $vo.progranName </label>  
										#end
									#end 
							</li>
							#end
							#set($i=$i+1)
						#end
         			<ul>
		</div>
		<div class="footer"></div>
	</div>
	<script >
		var calendarPicker1 = $("#dsel1").calendarPicker({
		    monthNames:["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		   });
		 $(function(){
			 var userId=$userId;
			 $('.calElement').live('click',function(){
			 	var date=$(this).find('.dayNumber').attr('id');
						 
				 if(date="undefined"){
				 date=$('.selected').find('.dayNumber').attr('id');
				 }
				 var plan=$('#paln_ul');
				 $('.remove').remove();
				 $.ajax({
					 url:"/professional/getPlad?userId="+userId+"&date="+date,
					 success:function(mjson){
					 	 
				 		var plan=eval('('+mjson+')');
				 		var length=plan.mPlanVo.length;
				 		for(var i=0;i<length;i++){
				 			var a=i+1;
				 			if(a%2==0){
				 			var li=("<li class='remove' style='height:120px; background-color:#EBDDF5; position: relative;'><div class='margin' ><span class='span' >"+a+"</span></div><div style='float:left;border-right:1px dashed blue; height:120px; width:1px;position:relative;left:-25px;'></div><label class='lable1'>"+plan.mPlanVo[i].planTime+"</label><label class='lable3'>"+plan.mPlanVo[i].planName+"</label><lable class='lable34'><text class='tex'>专业老师："+plan.mPlanVo[i].programOfVO[0].teacher+"</text> 课题时长："+plan.mPlanVo[i].programOfVO[0].duration+" 课题名称："+plan.mPlanVo[i].programOfVO[0].progranName+"</lable></li>");
				 			}else{
				 			var li=("<li class='remove' style='height:120px; background-color:#CECBC8; position: relative;'><div class='margin' ><span class='span' >"+a+"</span></div><div style='float:left;border-right:1px dashed blue; height:120px; width:1px;position:relative;left:-25px;'></div><label class='lable1'>"+plan.mPlanVo[i].planTime+"</label><label class='lable3'>"+plan.mPlanVo[i].planName+"</label><lable class='lable34'>&nbsp;<text class='tex'>专业老师："+plan.mPlanVo[i].programOfVO[0].teacher+"</text> 课题时长："+plan.mPlanVo[i].programOfVO[0].duration+" 课题名称：："+plan.mPlanVo[i].programOfVO[0].progranName+"</lable> </li>");
				 			}
				 			
				 			
				 			$('#paln_ul').append(li);
				 		}
				 	}
				 });
			 })
		  		
		});
		 
	 	window.addOther = function(t){
			var userId = $(t).attr('userId');
			var ckDate = $('#ckDate').val();
			date=$('.selected').find('.dayNumber').attr('id');
			location.href='/professional/goToAddPlan?userId='+userId+'&ckDate='+date;
		}
	</script>
</body>
</html>