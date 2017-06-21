<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>消息管理</title>   
    #parse("/common/top.tpl")
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
  </head>
  
  <body>
  #parse("/common/masklayer.tpl")
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;"> 
<form action="/icare/notice/getList" method="post" name="searchForm">
    <div style=" width: 1000px;">
	手机号：<input type="text" class="input2" name="userContact" value="$!userContact"/>
	来源：<select name="type" class="input1">
	                <option #if($!type==9) selected = "selected" #end value="9">全部</option>
			   		<option #if($!type==2) selected = "selected" #end value="2">发送</option>
			   		<option  #if($!type==1) selected = "selected" #end  value="1">接收</option>
		</select>
	反馈日期：<input type="text"  class="timedate input2" name="startTime" placeholder="开始时间" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!startTime)"/>
	<input type="text"  class="timedate input2" name="endTime" placeholder="结束时间" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!endTime)"/>
	<input type="submit" value="查询"  class="btnBg" style="width: 100px;margin-left: -0px;"/>
	</div> 
	</form>
   <table class="commonTable" style="width: 1000px;">
	<tr>
		<th>序号</th>
		<th>反馈建议</th>
		<th>用户电话号码</th>
		
		<th>来源</th>
		<th>反馈时间</th>
		<th>操作</th>
	</tr>
	#if($page)
	 #foreach ($u in $page.result)
	 <tr  > #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
		<!-- <td>$!u.id</td> -->
		<td>$!{i}</td>
		<td>$!u.content</td>
		<td>$!u.userContact</td>		
		<td>#if($!u.type=='2')已发送#elseif($!u.type=='1')接收#end</td>
		<td>$date.format("yyyy-MM-dd hh:mm:ss",$!u.createTime)</td>
		<td><a href="/icare/notice/get?id=$!{u.id}">查看</a></td>
		</tr>
	#end
	#end
	</table>
	<div>
	 <div class="page fr">#parse("/common/page.tpl")</div>
	</div>

</div>	
</body>
  <script type="text/javascript" src="../../assets/director/js/jquery-1.12.4.min.js"></script>
 <script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
  <script type="text/javascript" src="/assets/js/calendar.js"></script>
 <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
 
 <script type="text/javascript">
 $(function(){
 	$(".timedate").calendar({ format:'yyyy-MM-dd hh:mm:ss' });
 	$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
 });
 </script>
</html>
