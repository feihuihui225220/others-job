<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title>评估结果表</title>
        <link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
        <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
        <script src="$request.contextPath/assets/js/jquery.PrintArea.js"></script>
	</head>
	
	<body>
	
		<div class="printArea">
			<div class="body">
				<div class="useractbox bodyline pad10 vv" >
					<table class="table100 usertable cen trclick">
                        <tr><th>编号</th><th>评估名称</th><th>时间</th><th>操作</th></tr>
                        #foreach($li in $list)
                        
                        <tr class="ibtn addadver">
		        			<td>$li.id</td>
		        			<td>体适能评估</td>
		        			<td><a href="/fitness/resultDetail?resultId=${li.id}">$li.createTime</a></td>
		        			<td><a href="/fitness/delete?resultId=${li.id}">删除>></a></td>
		        		</tr>
                        #end
                        </table>
					    			
					</table>
				</div>
			</div>
		</div>
	
        
	</body>
</html>
