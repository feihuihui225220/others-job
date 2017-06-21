<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<style>
 body{background:#D9EBEB}
</style>

</head>
<body>
		<div class="tablediv">
		<br/>
	  	<form id="activity_voluntary" action="/professional/activity/addNew_voluntary" method="post" name="searchForm">
		<input id="two_sign"  name="two_sign" class="ibtn button_add" type="submit" value="添加"/>
			   <input type="hidden" id="activityId" name="activityId" value="$!activityId"/>
			   <input type="hidden" id="pubdate" name="pubdate" value="$!date.format('yyyy-MM-dd',$pubdate)"/>
			   <table class="table100 usertable cen table-hover" >
			 	<tr>
				 <th><input type="checkbox" id="checkall" style="float:left; margin:6px 0 0 10px;" />序号</th>
				 <th>姓名</th>
				 <th>性别</th>
				 <th>年龄</th>
			 	 <th>联系电话</th>
		 		 <th>所属社区</th>
			 	</tr>	
			 	#set($i=1)
	                #foreach ($n in $nVolunteer)
		        		<tr class="ibtn addadver">
		        			<td><input type="checkbox" class="volunteerId" name="volunteerId" value="${n.id}" />$i </td>
		        			<td>$!{n.name}</td>
		        			<td>$!{n.sex}</td>
		        			<td>$!{n.age}</td>
		        			<td>$!{n.contact}</td>
			                <td>$!{n.community}</td>
		        		</tr>
		        		#set($i=$i+1)
	        		#end
			   </table> 
	   	</form>
	</div>
	<script>
	 $(function(){
    		
	});
     $("#checkall").click(function(){ 
				if(this.checked){ 
					$("input[name='volunteerId']").each(function(){this.checked=true;}); 
				}else{ 
					$("input[name='volunteerId']").each(function(){this.checked=false;}); 
					} 
  	 });
	</script>
</body>
</html>