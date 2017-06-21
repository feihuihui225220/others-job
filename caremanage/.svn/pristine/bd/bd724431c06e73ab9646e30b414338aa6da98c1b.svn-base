<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title>评估量表-开始评估</title>
        <link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
        <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
	</head>
	
	<body>
		<div class="wrapper">
			<div class="body">
				<div class="useractbox bodyline pad10 vv">
					<table class="table100 usertable cen">
						<tr>
							<th>序号</th>
							<th>评估质量名称</th>
							<th>评估质量内容</th>
							<th>操作</th>
						</tr>
						<tr>
							<td>1</td>
							<td>老年人失能失智调查问卷</td>
							<td>综合题</td>
							<td><a href="/handle/assess?userId=${userId}"/>开始评估>></td>
						</tr>
						<tr>
							<td>2</td>
							<td>体适能检测表</td>
							<td>综合题</td>
							<td><a href="/fitness/fitness?userId=${userId}"/>开始评估>></td>
						</tr>
						#set($i=3)
						#foreach ($assess in $assesses)
						<tr>
						   <td>$i</td>
						   <td>${assess.name}</td>
						   <td>#if(${assess.type} == 0) 分数题  #else 组合题 #end</td>
						   
						   <td><a href="/professional/assess/record?userId=${userId}&assessId=${assess.id}">开始评估>></a></td>
						</tr>
						#set($i=$i+1)
						#end
					</table>
				</div>
			</div>
		</div>
	</body>
</html>