<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
		<title>状态</title>
	</head>
	
	<body>
		<div align="center">
			<form action="/professional/state/commit" method="post">
				<input type="hidden" name="userId" value="${userId}" />
				<table border="1">
					#set($i=0)
					#foreach($state in $states)
						<tr>
							<td>
								${state.name}
							</td>
							#set($j=0)
							#foreach($_state in $state.states)
								<td><input type="radio" name="states[$i]" value="${state.id},${_state.id}" #if($j==0) checked="checked" #end/>${_state.name}</td>
								#set($j=$j+1)
							#end
						</tr>
						#set($i=$i+1)	
					#end
				</table>
				<br/>
				<textarea cols="60" rows="6" name="bakup"></textarea><br/><br/>
				<input type="submit" class="button_add" value="确定" /> &nbsp;&nbsp;&nbsp;&nbsp;<input class="button_delete" type="button" onclick="javascripts:location.href='/professional/state/query?userId=${userId}'" value="取消" />
			</form> 
		</div>
	</body>
</html>