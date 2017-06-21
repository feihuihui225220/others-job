<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>活动列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
</head>
<body>
#parse("/common/masklayer.tpl")
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;">
<form action="/active/listAllActive" method="post" name="searchForm">
	<div style=" width: 1000px;">
	活动名称：<input type="text" class="input2" name="activeName" value="$!activeName" autocomplete='on'/>
	录入时间：<input type="text"  class="timedate input2" name="startTime" placeholder="开始时间" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!startTime)" autocomplete='on'/>
		   <input type="text" class="timedate input2" name="endTime" placeholder="结束时间"  value="$!date.format('yyyy-MM-dd hh:mm:ss',$!endTime)" autocomplete='on'/>
	<input type="submit" value="查询"  class="btnBg" style="width: 100px;margin-left: -0px;"/>
	<a href="/active/findActive" class="btnBg" style="width:100px;margin-left: -10px;">添加</a>
	</div>
<table class="commonTable" style="width: 1000px;">
	<tr>
		<th>序号</th>
		<th>活动名称</th>
		<th>活动时间</th>
		<th>联系人</th>
		<th>联系电话</th>
		<th>状态</th>
		<th>操作</th>
	</tr>
	#if($page)
	 #foreach ($u in $page.result)
	 <tr> #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
		<!-- <td>$!u.id</td> -->
		<td style="display: none;">$!date.format("yyyy-MM-dd HH:mm:ss",$!u.endTime)</td>
		<td>$!{i}</td>
		<td>$!u.activeName</td>
		<td>$!date.format("yyyy-MM-dd HH:mm:ss",$!u.startTime)-
			$!date.format("yyyy-MM-dd HH:mm:ss",$!u.endTime)
			$!u.activeTime</td>
		<td>$!u.activeLxr</td>	
		<td>$!u.activePhone</td>
		<td>
		</td>
		<td><a href="/active/findActive?id=${u.id}" class="btnBg" style="width:60px; float: left;">编辑</a>
			<a class="btnBg" onclick="deletes($u.id)" style="width:60px;float: left;"">删除</a></td>
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
	var myDate = new Date();
	/* myDate.getYear(); //获取当前年份(2位)
	myDate.getFullYear(); //获取完整的年份(4位,1970-????)
	myDate.getMonth(); //获取当前月份(0-11,0代表1月)
	myDate.getDate(); //获取当前日(1-31)
	myDate.getDay(); //获取当前星期X(0-6,0代表星期天)
	myDate.getTime(); //获取当前时间(从1970.1.1开始的毫秒数)
	myDate.getHours(); //获取当前小时数(0-23)
	myDate.getMinutes(); //获取当前分钟数(0-59)
	myDate.getSeconds(); //获取当前秒数(0-59) */
	//myDate=myDate.getTime();
	var yyyy=myDate.getFullYear()+"-";
	var MM=myDate.getMonth()+1;
	var dd=myDate.getDate();
	var HH=myDate.getHours();
	var mm=myDate.getMinutes();
	var ss=myDate.getSeconds();
	var time=yyyy+MM+"-"+dd+" "+HH+":"+mm+":"+ss;
	var len=$(".commonTable tr").length;
	for(var i=1;i<len;i++){
		var td=$(".commonTable tr:eq("+i+") td:eq(0)").text();
	    var start=Date.parse(new Date(td));
	    var end=Date.parse(new Date(time));
	   	if(start>end){  
	        $(".commonTable tr:eq("+i+") td:eq(6)").html("准备中");
	    }else{
	    	 $(".commonTable tr:eq("+i+") td:eq(6)").html("已过期");
	    }
	}
 });
  function deletes(id){
 	var con=confirm("是否删除？");///ICare/userPhoto/delete
		if(con){
			 $.ajax({
				url:"/active/delete?cId="+id,
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