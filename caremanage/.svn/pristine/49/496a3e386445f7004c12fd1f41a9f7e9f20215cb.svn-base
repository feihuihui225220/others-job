<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title>服务报告</title>
		<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
		<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
		<script src="$request.contextPath/assets/js/calendar.js"></script>
		<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
		<script src="/assets/js/pageNavigator.js"></script>
	</head>
	
	<body>
	#parse("/common/masklayer.tpl")
		<div class="wrapper">
			<div class="body">
				<div class="useractbox bodyline pad10 vv">
					<div class="searchli">
						<ul class="inpubox clearfix">
						    <form action="/professional/report/query" method="post" name="searchForm">
						        <input type="hidden" name="userId" value="${userId}"/>
						        <input type="hidden" name="serviceId" value="${serviceId}"/>
						        <li><label>选择日期：</label>
						            <input name="start" readonly="true" class="text150 timedate" type="text" value="$!date.format('yyyy-MM-dd',$!dateCond.start)"/> 至 <input name="end" readonly="true" class="text150 timedate" type="text" value="$!date.format('yyyy-MM-dd',$!dateCond.end)"/></li>
							    <li><input class="ibtn button_btn" type="submit" value="搜索"></li>
						    </form>
							<li class="rightbtn pad10"><button onclick="javascripts:location.href='/professional/report/add?userId=${userId}&serviceId=${serviceId}&start=$!date.format('yyyy-MM-dd',$!dateCond.start)&end=$!date.format('yyyy-MM-dd',$!dateCond.end)'" class="button_btn addEvidence">添加报告</button></li>
						</ul>
					</div>
					<div class="pj_result">
						<div class="pj_result_list">
						#foreach($report in $page.result)
						    <p class="pj_result_list_p1">$!date.format('yyyy-MM-dd HH:mm',$!report.createdAt)</p>
							<span class="pj_result_list_span">服务报告：</span>
							<span style="word-wrap:break-word;">${report.content}</span>
							<hr/>
					    #end
						</div>
					</div>
					#if($page.result.size()>0)
						#parse("/common/page.tpl")
					#end
				</div>
			</div>
		</div>
<script type="text/javascript">
$(function(){
    $(".timedate").calendar({ format:'yyyy-MM-dd' });
});

</script>
	</body>
</html>