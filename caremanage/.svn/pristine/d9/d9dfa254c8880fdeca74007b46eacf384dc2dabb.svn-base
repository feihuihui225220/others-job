<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>客户管理</title>
 <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
 <script type="text/javascript">
 $(function(){
 	$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
 });
 </script>
</head>
<body>
#parse("/common/masklayer.tpl")
#parse("/common/dtop.tpl")
#parse("/ICare/ICleft.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;">
<form action="/ICare/customer/list" method="post" name="searchForm">
	姓名：<input type="text" name="name" value="$!user.name"/>
	<input type="submit" value="查询" />
<table border='1' class="commonTable">
	<tr>
		<th>序号</th>
		<th>已分配人员数量</th>
		<th>负责区域</th>
		<th>操作</th>
	</tr>
	#if($page)
	 #foreach ($u in $page.result)
	 <tr class="pointer1" date-href="/ICare/customer/customer?id=$!{u.id}"> #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
		<!-- <td>$!u.id</td> -->
		<td>$!{i}</td>
		<td>$!u.name</td>
		<td>$!u.createdBy</td>
		<td><a href="#">分配</a></td>
		</tr>
	#end
	#end
	</table>
	<div>
	#parse("common/page.tpl")
	</div>
	</form>
</div>
</body>
</html>