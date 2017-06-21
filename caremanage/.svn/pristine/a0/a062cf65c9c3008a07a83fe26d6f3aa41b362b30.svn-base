<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>评估量列表</title>
	</head>
	
	<body>
		<div align="center">
		    <input type="button" value="添加" style="color:fff;"/>&nbsp;
			#if ($page)
				<table border="1">
					<tr>
						<td>名称</td>
						<td>简介</td>
						<td>类型</td>
						<td>操作</td>
					</tr>
					#foreach ($assess in $page.result)
					<tr>
						<td>${assess.name}</td>
						<td>${assess.descr}</td>
						<td>${assess.type}</td>
						<td>
							<input type="button" value="编辑" />&nbsp;
							<input type="button" value="试题" />&nbsp;
							<input type="button" value="结论" />&nbsp;
							<input type="button" value="删除" />&nbsp;
							<input type="button" value="发布" />&nbsp;
							<a>问题列表</a>&nbsp;
							<a>结论列表</a>
						</td>
					</tr>	
					#end
				</table>	
			#end
		</div>
	</body>
</html>