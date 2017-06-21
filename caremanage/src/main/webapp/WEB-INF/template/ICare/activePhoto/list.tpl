<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>CM照片列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
<style>
	.bgt{
		display: inline-block;
	    width: 80px;
	    height: 35px;
	    line-height: 35px;
	    color: #fff;
	    background-color: #1badc3;
	    border-radius: 5px;
	    border: none;
	}
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
#parse("/common/head.tpl")
#parse("/ICare/ICleft.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;">
<form action="/active/CMUserPhotoList" method="post" name="searchForm">
	<div style=" width: 1000px;">
	活动名称：<input type="text" class="input2" name="activeName" value="$!activeName" autocomplete='on'/>
	录入时间：<input type="text"  class="timedate input2" name="startTime" placeholder="开始时间" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!startTime)" autocomplete='on'/>
		   <input type="text" class="timedate input2" name="endTime" placeholder="结束时间"  value="$!date.format('yyyy-MM-dd hh:mm:ss',$!endTime)" autocomplete='on'/>
	<input type="submit" value="查询"  class="btnBg" style="width: 100px;margin-left: -0px;"/>
	<a href="/active/CMUserAddPhotoHtml" class="btnBg" style="width:100px;margin-left: -10px;">添加</a>
	</div>
<table class="commonTable" style="width: 1000px;">
	<tr>
		<th>序号</th>
		<th>活动名称</th>
		<th>活动时间</th><!-- 
		<th>活动介绍</th> -->
		<th>联系人</th>
		<th>联系方式</th>
		<th>操作</th>
	</tr>
	#if($page)
	 #foreach ($u in $page.result)
	 <tr> #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
		<!-- <td>$!u.id</td> -->
		<td>$!{i}</td>
		<td>$!u.activeName</td>
		<td>$!date.format("yyyy-MM-dd hh:mm:ss",$!u.startTime)
			- $!date.format("yyyy-MM-dd hh:mm:ss",$!u.endTime)</td>
		<td>$!u.activeLxr</td>
		<td>$!u.activePhone</td>
		<!-- <td>$date.format("yyyy-MM-dd hh:mm:ss",$!u.createAt)</td> -->
		<td>
			#if($u.activePoster)
				<a href="/active/CMUserAddPhotoHtml?aId=$!{u.id}" class="bgt">照片编辑</a>
			#else
				<a href="/active/CMUserAddPhotoHtml?aId=$!{u.id}" class="bgt">上传照片</a>
			#end
			<a class="bgt" onclick="deletes($u.id)">删除</a></td>
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
<script type="text/javascript" src="../../assets/director/js/jquery-1.12.4.min.js"></script>
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
				url:"/active/CMdele?id="+id,
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