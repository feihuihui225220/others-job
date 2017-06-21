<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
		<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
		<style>
			table{margin-left:3%}
		</style>
	</head>
	
	<body>
		<div class="wrapper">
			<br/>
			<table class="table100 usertable cen trclick">
				<tr>
					<th>序号</th>			
					<th>服务商名</th>			
					<th>开通</th>	
				</tr>
				 #if ($page)
				 	#set($i=1)
	                #foreach ($u in $page.result)
		        		<tr>
		        			<td>$i</td>
		        			<td>$!{u.name}</td>
		        			<td>
		        			#if($map.get($u.id)=="存在")
		        						<button  class="button_add" onclick="javascript:location.href='/professional/facilitator/delete?userId=$userId&venderId=$!{u.id}'">停用</button>
		        			#else
		        						<button class="button_gm"  onclick="javascript:location.href='/professional/facilitator/add?userId=$userId&venderId=$!{u.id}'">开通</button></td>
		        			#end
		        		</tr>
		        		#set($i=$i+1)
	        		#end
        		  #end		
			</table>
		</div>
	<script type="text/javascript">
	</script>
	</body>
</html>