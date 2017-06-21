<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
		<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
		<script src="$request.contextPath/assets/js/calendar.js"></script>
		<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
	</head>
	
	<body>

		<div align="center">
			<form action="/professional/vender/distr/user/commit" method="post">
				<input type="hidden" name="userId" value="${userId}" />
				<table border="1">
					#set($i=0)
					#foreach($auser in $distrUsers)
						<tr>
							<td><input type="radio" name="adminId" value="${auser.adminId}" />${auser.adminName}</td>
						</tr>
						#set($i=$i+1)	
					#end
				</table>
				<br/>
				<input type="submit" value="确定" /> &nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="javascripts:location.href='/professional/service/list?userId=${userId}'" value="取消" />
			</form> 
		</div>

		
	</body>
</html>