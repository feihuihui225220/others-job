<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
 a{color:black;}
 body{background:#D9EBEB}
</style>

</head>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
	<div class="main">
    		#parse("/common/providers.tpl")
	<div id="right" > 
		<div class="tablediv">
		<br/>
			<input type="button" class="btn-default add_first btn" onclick="javascript:window.history.go(-1)" value="返回"/>
		  <form id="activity_voluntary" action="/professional/activity/addTwo_voluntary" method="post" name="searchForm">
			   <input type="hidden" id="activityId" name="id" value="$!activityId"/>
			   <input type="hidden" id="pubdate" name="pubdate" value="$!date.format('yyyy-MM-dd',$pubdate)"/>
			   <table class="table _tale1">
				<tr  class="_active">
				 <th>序号</th>
				 <th>姓名</th>
				 <th>性别</th>
				 <th>年龄</th>
			 	 <th>联系电话</th>
		 		 <th>所属社区</th>
			 	</tr>	
			 	#set($i=1)
	                #foreach ($n in $nVolunteer)
		        		<tr class="ibtn addadver">
		        			<td>$i </td>
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
	</div>
	</div>
</div>
	<script>
	 $(function(){
    		$('#sign').click(function(){
    			 $('#voluntary', window.parent.document).val(111);   
    			$('#activity_voluntary').submit();
    		});
    		$('#two_sign').click(function(){
    		var activityId=$("#activityId").val();
    		var pubdate=$("#pubdate").val();
    			 location.href="$request.contextPath/professional/activity/list_volunteer?activityId="+activityId+"&pubdate="+pubdate;
    		});
           $("#checkall").click(function(){ 
				if(this.checked){ 
					$("input[name='id']").each(function(){this.checked=true;}); 
				}else{ 
					$("input[name='id']").each(function(){this.checked=false;}); 
					} 
			   });
    });
	</script>
</body>
</html>