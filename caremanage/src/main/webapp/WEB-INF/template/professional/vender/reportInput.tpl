<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
     function check(){
           if(!document.getElementById("contentArea").value){
                alert("内容不能为空！");
           } else {
                document.getElementById("reportForm").submit();
           }
     }
</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>服务报告添加</title>
		<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
        <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
	</head>
	<body>
		<div class="wrapper">
			<div class="body">
				<div class="useractbox bodyline pad10 vv">
					<div class="huifujianyi">
					    <form id="reportForm" action="/professional/report/commit" method="post">
					        <input type="hidden" name="userId" value="${userId}" />
				            <input type="hidden" name="serviceId" value="${serviceId}" />
				            <input type="hidden" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)" />
				            <input type="hidden" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)" />
						    <p class="huifujianyi_p">请在这里输入服务报告（注意：最多输入200字。）</p>
						    <textarea id="contentArea" maxlength="200" name="content" style="width: 99%; height: 100px; margin: 0 auto; display: block; margin-bottom: 10px;"></textarea>
						    <input class="ibtn button_btn" onClick="check()" value="提交"/>
						    <input class="ibtn button_btn" onClick="javascripts:history.go(-1)" value="取消"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
	
</html>