<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>视频添加</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
.colltab{width:70%;margin-top:3%;}
.colwidth{width:20%;padding-left:7%;}
.colwidthTwo{width:80%}
.button_add{margin-left:20px;}
.textarea_1{width:80%;height:200px;}
.btu{position:relative;left:380px;margin-left:20px;margin-top:20px;}
</style>
</head>
<body>
#parse("/common/head.tpl")
	<center>
		<div>
			<form action="/professional/fete/video/add/$programId" method="post" enctype="multipart/form-data">
				<table class="tb colltab" >
					<tr>
						<td class="colwidth">选择视频</td>
						<td class="colwidthTwo"><input type="file" name="vedioFile" /></td>
					</tr>
					<tr>
						<td class="colwidth">视频标题</td>
						<td><input type="text" name="title" /></td>
					</tr>
					<tr>
						<td class="colwidth">注意事项</td>
						<td><textarea name="descript" class="textarea_1"></textarea></td>
					</tr>
				</table>
				<input type="submit" class="button_add btu" value="上传视频"/> <input class="button_delete btu" type="reset" value="重新选择"/>
			</form>
		</div>
	</center>
<script type="text/javascript">
</script>
</body>

</html>