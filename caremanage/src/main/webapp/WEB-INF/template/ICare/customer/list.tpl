<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>客户管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div class="wrapper" style="float:left; width: 1000px;">
<form action="/customer/list" method="post" name="searchForm">
	<div style=" width: 1000px;">
	姓名：<input type="text" class="input2" name="name" value="$!user.name"/>
	手机号：<input type="text" class="input2" name="mobilePhone" value="$!user.mobilePhone"/>
	cm：<select class="input1"><option>全部</option></select>
	分配状态：<select name="active" class="input1">
		<option #if($!user.active=='99') selected="selected" #end value="99">全部</option>
		<option #if($!user.active=='0') selected="selected" #end value="0">审核中</option>
		<option #if($!user.active=='1') selected="selected" #end value="1">未分配</option>
		<option #if($!user.active=='2') selected="selected" #end value="2">已分配</option>
	</select>   <br/>
	身份证号：<input type="text" class="input2"  name="idCardNo" value="$!user.idCardNo"/>
	
	录入时间：<input type="text"  class="timedate input2" name="startTime" placeholder="开始时间" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!startTime)"/>
		   <input type="text" class="timedate input2" name="endTime" placeholder="结束时间"  value="$!date.format('yyyy-MM-dd hh:mm:ss',$!endTime)"/>
	<input type="submit" value="查询"  class="btnBg" style="width: 100px;margin-left: -0px;"/>
	<a href="/customer/modifyHtml" class="btnBg" style="width:100px;margin-left: -10px;">添加</a>
	</div>
<table class="commonTable" style="width: 1000px;">
	<tr>
		<th>序号</th>
		<th>姓名</th>
		<th>身份证号</th>
		<th>手机号</th>
		<th>性别</th>
		<th>所属cm</th>
		<th>分配状态</th>
		<th>录入时间</th>
		<th>操作</th>
	</tr>
	#if($page)
	 #foreach ($u in $page.result)
	 <tr #if($u.rContact!='[]') class="pointer1" #end style="cursor:pointer;"  date-href="/customer/customer?id=$!{u.id}" date-parameter=$!{u.rContact} > #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
		<!-- <td>$!u.id</td> -->
		<td>$!{i}</td>
		<td>$!u.name</td>
		<td>$!u.idCardNo</td>
		
		<td>#if($u.mobilePhone=='')
			$!u.contactPhone
		#else
			$!u.mobilePhone
		#end</td>
		<td>#if($!u.gender=='0')女#elseif($!u.gender=='1')男#end</td>
		<td>$!u.createdBy</td>
		<td>#if($u.active=='0')审核中
		#elseif($u.active=='1')未分配
		#elseif($u.active=='2')已分配#end</td>
		<td>$!date.format("yyyy-MM-dd hh:mm:ss",$!u.createdAt)</td>
		<td><a date-para=${u.id} class="btnBg update" style="width:60px;">编辑</a>
		<!-- <a class="btnBg" onclick="deletes($u.id)" style="width:60px;">删除</a> -->
		</td>
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
 $(".sidebar li a").eq(2).css("background-color","#16A5AD").css("color","#fff");
 	$(".timedate").calendar({ format:'yyyy-MM-dd hh:mm:ss' });
 	 $('.pointer1').click(function(){
 	 	var parameter = $(this).attr("date-parameter");
 	 	if(parameter!=""&&parameter!=null){
 	 		location.href=$(this).attr('date-href');
 	 	}else{
 	 		alert("该信息尚不完整，请先补充信息！");
 	 	}
		
	});
	$("table tr td:not(:last-child)").click(function(){
		alert("该信息尚不完整，请先补充信息！");
	});
	$(".update").click(function(){
		var id = $(this).attr("date-para");
		location.href="/customer/modifyHtml?id="+id;
	});
 });
 function deletes(id){
 	var con=confirm("是否删除？");///ICare/userPhoto/delete
		if(con){
			location.href ="/customer/delete?cId="+id;
		}
 };
 </script>
</html>