<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>反馈建议</title> 
    #parse("/common/top.tpl")  
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
  </head>
  
  <body>
  #parse("/common/masklayer.tpl")
   #parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl") 
<div class="wrapper" style="margin: 0 auto;width: 800px;"> 
<form action="/icare/feedback/getList" method="post" name="searchForm">
    <div style=" width: 1000px;">
	手机号：<input type="text" class="input2" name="userContact" value="$!userContact"/>
	反馈日期：<input type="text"  class="timedate input2" name="startTime" placeholder="开始时间" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!startTime)"/>
	<input type="text"  class="timedate input2" name="endTime" placeholder="结束时间" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!endTime)"/>
	<input type="submit" value="查询"  class="btnBg" style="width: 100px;margin-left: -0px;"/>
	</div> 
   <table class="commonTable" style="width: 1000px;">
	<tr>
		<th>序号</th>
		<th>反馈建议</th>
		<th>用户电话号码</th>
		<th>处理状态</th>
		<th>是否有效</th>
		<th>反馈时间</th>
		<th>操作</th>
	</tr>
	#if($page)
	 #foreach ($u in $page.result)
	 <tr class="pointer1" > #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
		<!-- <td>$!u.id</td> -->
		<td>$!{i}</td>
		<td>$!u.content</td>
		<td>$!u.userContact</td>
		
		<td>#if($!u.status=='1')已处理#elseif($!u.status=='0')未处理#end</td>
		<td>#if($!u.available=='true')是#elseif($!u.available=='false')否#end</td>
		<td>$date.format("yyyy-MM-dd hh:mm:ss",$!u.createTime)</td>
		<td><a href="/icare/feedback/detail?id=$!{u.id}">查看</a>
		 <input type="button"  value="回复"  class="btnBg " onclick="add1('light1')">
		
		</td>
		</tr>
		
	#end
	#end
	</table>
	<div>
	 <div class="page fr">#parse("/common/page.tpl")</div>
	</div>
</form>
<form action="">
<div style="display:none;" id="light1">
		<input type="text" name="userContact" value="$!u.userContact">
		<input type="text" name="content">
</div>
</form>
</div>	
</body>
  <script type="text/javascript" src="../../assets/director/js/jquery-1.12.4.min.js"></script>
  <script src="/assets/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
  <script type="text/javascript" src="/assets/js/calendar.js"></script>
 <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
 <script>
 function add1(light1){
	 if(document.getElementById(light1).style.display != "block")   
     {   
         document.getElementById(light1).style.display = "block";   
     }   
     else  
     {   
         document.getElementById(light1).style.display = "none";   
     }   
   
 }
 function move1(){
     document.getElementById('light1').style.display='none';
   
 }
 </script>
 <script type="text/javascript">
 $(function(){
 	$(".timedate").calendar({ format:'yyyy-MM-dd hh:mm:ss' });
 	$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
 });
 </script>
 
</html>
