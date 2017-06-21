<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
		<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
	</head>
	
	<body>
		<div class="wrapper">
			<div class="body">
				<div class="useractbox bodyline pad10 vv">
					<ul class="ooootitle strong mgb10">
						<li id="1" class="rel on">历史数据</li>
						<li id="2" class="rel">服务计划</li>
						<li id="3" class="rel">评估</li>
						<li id="4" class="rel">服务报告</li>
						<li id="5" class="rel">实时消息</li>
						<li id="6" class="rel">警报阀值</li>
						<li id="7" class="rel">数据录入</li>
						<li id="8" ><button type="button" class="ibtn button_btn" onclick="javascripts:window.parent.document.getElementById('userFrame').src='/professional/service/list?userId=${userId}'">返回</button></li>
					</ul>
	
					<div class="oooolist">
					    <!--
							<iframe id="serviceSetF" src="/professional/service/user/history?userId=${userId}&serviceId=${serviceId}" scrolling="yes" width="100%"  style="height:555px;" frameborder="0"></iframe>
						-->
						 
						<iframe id="serviceSetF" src="#if($stype) /professional/service/diverseShow?userId=${userId}&serviceId=${serviceId}&stype=$!stype #else /professional/service/history?userId=${userId}&serviceId=${serviceId} #end" scrolling="yes" width="100%"  style="height:555px;" frameborder="0"></iframe>
						
					</div>
					
				</div>
			</div>
		</div>
	
		<script type="text/javascript">
			$(function() {
				$(".ooootitle li").click(function() {
					var index = $(this).attr('id');
					$(this).addClass('on').siblings().removeClass('on');
					//$(".oooolist .oooo" + index).show().siblings().hide();
					if(index == 1) {
						$(".oooolist iframe").attr("src", "#if($stype) /professional/service/diverseShow?userId=${userId}&serviceId=${serviceId}&stype=$!stype #else /professional/service/history?userId=${userId}&serviceId=${serviceId} #end");
					}else if(index == 2) {
						$(".oooolist iframe").attr("src", "/professional/plan?userId=${userId}&serviceId=${serviceId}&orderId=${orderId}");
					}else if(index == 3) {
						$(".oooolist iframe").attr("src", "/professional/vender/service/assess?userId=${userId}&serviceId=${serviceId}");
					}else if(index == 4) {
						$(".oooolist iframe").attr("src", "/professional/report/query?userId=${userId}&serviceId=${serviceId}&start=$!date.format('yyyy-MM-dd',$!dateCond.start)&end=$!date.format('yyyy-MM-dd',$!dateCond.end)");
					}else if(index == 5) {
						$(".oooolist iframe").attr("src", "/professional/msg?userId=${userId}&serviceId=${serviceId}");
					}else if(index == 6) {
						$(".oooolist iframe").attr("src", "/professional/alarm/setup?userId=${userId}&serviceId=${serviceId}");
					}else if(index == 7){
						$(".oooolist iframe").attr("src", "/professional/input?userId=${userId}&serviceId=${serviceId}");
					}
				});
			});
		</script>
	</body>
</html>