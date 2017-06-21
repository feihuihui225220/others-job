<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>用户上传照片记录</title>
#parse("/common/top.tpl")
<link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
</head>
<body>
#parse("/common/masklayer.tpl")
#parse("/common/head.tpl")
#parse("/ICare/ICleft.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;">
<form action="/userPhoto/list" method="post" name="searchForm">
	录入时间：<input type="text"  class="timedate input2" name="startTime" placeholder="开始时间" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!startTime)" autocompleted='false'/>
		   <input type="text" class="timedate input2" name="endTime" placeholder="结束时间"  value="$!date.format('yyyy-MM-dd hh:mm:ss',$!endTime)" autocompleted='false'/>
	<input type="submit" value="查询" class="btnBg" />
	<a href="/userPhoto/addPhotHtml" class="btnBg" >添加记录</a>
<table class="commonTable" style="width: 800px;">
	<tr>
		<th>序号</th>
		<th>上传日期</th>
		<th>上传人</th>
		<th>操作</th>
	</tr>
	#if($page)
	 #foreach ($u in $page.result)
	 <tr> #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
		<!-- <td>$!u.id</td> -->
		<td>$!{i}</td>
		<td>$!date.format('yyyy-MM-dd hh:mm:ss',$!u.createdAt)</td>
		<td>$!u.createdBy</td>
		<td>
		<a href="/userPhoto/addPhotHtml?id=${u.id}" class="btnBg" style="width:60px;">编辑</a>
		<a href="" class="btnBg" onclick="deletes($u.id)" style="width:60px;">删除</a></td>
		</tr>
	#end
	#end
	</table>
	<div>
	 <div class="page fr">
			#parse("/common/page.tpl")
			</div>
	</div>
	</form>
</div>
</body>

<script type="text/javascript" src="/assets/js/country_1.js"></script>
 <script type="text/javascript" src="/assets/js/calendar.js"></script>
 <script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
 <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
<script type="text/javascript">
 $(function(){
 	$(".timedate").calendar({ format:'yyyy-MM-dd hh:mm:ss' });
 });
 function deletes(id){
 	var con=confirm("是否删除？");///ICare/userPhoto/delete
		if(con){
			$.ajax({
				url:"/userPhoto/Udelete?id="+id,
				type:"get",
				success: function(result){
							var res = String($.trim(result)); 
							if(res=="OK"){ 
								alert("删除成功");
								window.location.reload();
							}else{ 
								alert("删除失败");
							} 
				} 
			});
		}
 };
 </script>
</html>