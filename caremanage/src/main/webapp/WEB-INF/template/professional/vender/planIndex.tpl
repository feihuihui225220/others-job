<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/calendar_user.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<style>
	
	.width{ width:500px;}
</style>
</head>
<body>
	 #parse("/common/head.tpl")
	<div class="wrapper" style="padding-left:1%;">
		 #if($!{sessionUser.getCateEnum()}=="USER")
		 	<iframe id="userFrame"  width="20%" height=800px; src="/user/detail" frameborder="0" scrolling="no"></iframe>
		 #end
		<div class="actbox1" style="width:77%;float:right;">
				<!--div id="cm_plan">
                 <style>
                     .calendar{ width:210px; border:1px solid #ccc; margin:20px auto; position:relative;}
                     .calendar h3{ height:30px; line-height:30px; text-align:center;}
                     .calendar ol{ border-bottom:1px solid #ccc; overflow:hidden;}
                     .calendar ol li{ width:30px; height:30px; line-height:30px; text-align:center; float:left;}
                     .calendar ul{ overflow:hidden;}
                     .calendar ul li{ width:30px; height:30px; line-height:30px; text-align:center; float:left;}

                     .calendar .week{ color:#f00;}
                     .calendar .pass{ color:#ccc;}
                     .calendar .today{ background:#f60;}

                     .calendar .prev{ position:absolute; left:0; top:0;}
                     .calendar .next{ position:absolute; right:0; top:0;}
                 </style>
                 <script>myCalendar();</script>
             </div-->
				<input onclick="new Calendar().show(this);" style="position:relative;left:200px;" class="cal1" />
				<div class="cm_plan">
					<h4>计划详情</h4>
					<table class="table table-bordered table-hover tablewidth">
						<tr  class="active">
							<th>时间</th>
							<th>分类</th>
							<th>内容</th>
							<th>备注</th>
						</tr>
						 #foreach ($result in $mPlanList)
							<tr>
								<td>$!date.format('yyyy-MM-dd HH:mm',$!{result.serviceTime})</td>
								<td>$!{result.mPlanCategory.parentPlanCategory.name}</td>
								<td>$!{result.mPlanCategory.name}</td>
								<td>$!{result.remark}</td>
							</tr>
						#end
					</table>
					#if($sessionUser.cateEnum.type == 4 && ${serviceId})
						<button class="button_gm" onclick="javascripts:location.href='/professional/goToAddPlan?userId=${userId}&serviceId=${serviceId}&orderId=${orderId}'">添加计划</button>
		            #end
					
				</div>
		</div>
		<div class="footer"></div>
	</div>
	<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$(".clourstitle li").click(function() {
				var index = $(this).attr('index');
				if (index != 1) {
					$('#__calendarPanel').css('display', 'none');
					$('#__calendarPanel').css('display', 'none');
					//$(window.frames["__calendarIframe"].document).find('form').css('display', 'none');
				} else {
					$('#__calendarIframe').css('display', 'block');
					$('#__calendarPanel').css('display', 'block');
					//$(window.frames["__calendarIframe"].document).find('form').css('display', 'block');
				}
				$(this).addClass('on').siblings().removeClass('on');
				$(".actboxlist .actbox" + index).show().siblings().hide();
			});

			$(".timedate").calendar({
				format : 'yyyy-MM-dd'
			});

			$('.actbox1 input').trigger('click');

			$(window.frames["__calendarIframe"].document).find('td').on(
			'click', function() {
				//alert($('.actbox1 input').val())
				$.ajax({
					type:'post',
                    url:'/professional/getPlad?userId=${userId}&date='+$('.actbox1 input').val(),
                    //data:$("#form_edit3").serialize(),
                    dataType:'json',
                    success:function(data){
                    	//debugger;
                    	//console.log(data);
                    	var str = '<h4>计划详情</h4><table class="table table-bordered table-hover tablewidth"><tbody><tr class="active"><th>时间</th><th>分类</th><th>内容</th><th>备注</th></tr>';
                    	for(var i=0;i<data.data.length;i++){
                    		var time = data.data[i].serviceTime.split(":"); 
							str += '<tr><td>'+time[0]+':'+time[1]+'</td><td>'+data.data[i].parentCategoryName+'</td><td>'+data.data[i].categoryName+'</td><td>'+data.data[i].remark+'</td></tr>';
						}
						str += '</tbody></table>';
                    	$(".cm_plan").html(str);
                    }
				});
			});
		});
	</script>
</body>
</html>