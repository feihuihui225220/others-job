<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>节目修改</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script>
	$(function(){
		var id=$!nProgram.id;
		$('#addVideo').click(function(){
			location.href="/professional/fete/video/toAdd?id="+id;
		});
	})
</script>
</head>
<body>
	<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="word">
		#set($nProgram=$nProgram)
		<form id="from1" action="$request.contextPath/professional/fete/update_update?id=$nProgram.id" method="post">
			<table >
				<tr>
					<td>节目名称：</td>
					<td><input id="u31_input" name="programName" value=$!nProgram.programName type="text"style=" width:200px;"></td>
				</tr>
					<td ><p style="position: relative; top: -55px;" >节目描述：</p></td>
					<td><textarea id="u34_input" style=" width:800px;height:120px;" name="programDesc">$!nProgram.programDesc</textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" id="addVideo" class="m_left ibtn button_add" value="视频添加"  style="float:right"/><button id="verify" class="m_left ibtn button_add" style="float:right">确认</button></td>
					
				</tr>
			</table>
		</form>	
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$('#verify').click(function(){
			 var val1=$('#u31_input').val().replace(/\s+/g,"");
			 var val2=$('#u34_input').val().replace(/\s+/g,"");
			 if(val1!=""&&val2!=""){
				$('#from1').submit();			
			}else{
				alert("不能为空");
				return false;
			}
			});
		});
		
	</script>
</body>
</html>