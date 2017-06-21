<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>微信-引导页</title>
 
</head>
<body>
#parse("/common/dtop.tpl")
#parse("/ICare/ICleft.tpl")
<div class="major" >
	<form action="/guidePhoto/add" method="post" enctype="multipart/form-data">
		<label>添加图片:<input  id="tu" type="file" multiple name="pic" ></label> 
		<button  type="submit">添加</button>
	</form>
</div>
<table class="commonTable" style="width: 1000px;">
	<tr>
		<th>序号</th>
		<th>图片</th>
		<th>链接地址</th>
		<th>上传时间</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	#if($page)
	 #foreach ($u in $page.result)
	 <tr class="pointer1" date-href="/ICare/customer/customer?id=$!{u.id}"> #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
		<!-- <td>$!u.id</td> -->
		<td>$!{i}</td>
		<td><img src="/$!u.photoUrl" width="100" height="60"/></td>
		<td>$!u.photoUrl</td>
		<td>$!date.format("yyyy-MM-dd hh:mm:ss",$!u.createdAt)</td>
		<td>
		#if($!u.available == true)
		<a href="modify?id=$!u.id&type=0">已启用</a>
		#else
		<a href="modify?id=$!u.id&type=1">已停用</a>
		#end
		</td>
		<td>
			<a href="remove/$!u.id">删除</a></td>
		</tr>
	#end
	#end
	</table>
	<div>
	 <div class="page fr">
	#parse("/common/page.tpl")
	 </div>
	</div>
</body>
</html>