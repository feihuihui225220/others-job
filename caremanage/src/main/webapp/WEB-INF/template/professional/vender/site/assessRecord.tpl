<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title>评估量表-开始评估</title>
        <link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
        <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
        <link rel="stylesheet" href="/assets/newCss/index.css" />
	</head>
	<style>
		.table{width:80%}
	</style>
	<body>
		<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
					<table class="table  _tale1">
						<tr>
							<th>序号</th>
							<th>评估质量名称</th>
							<th>评估质量内容</th>
							<th>操作</th>
						</tr>
						
						#set($i=1)
						#foreach ($assess in $assesses)
						<tr>
						   <td>$i</td>
						   <td>${assess.name}</td>
						   <td>#if(${assess.type} == 2) 社区评估 #end</td>
						   
						   <td><a href="/professional/assess/record?userId=${userId}&assessId=${assess.id}">开始评估>></a></td>
						</tr>
						#set($i=$i+1)
						#end
					</table>
        </div> 
		</div>
	</body>
</html>