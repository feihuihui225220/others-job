<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/newCss/wucha.css" />
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
				<input type="button" class="btn-default add_first btn" value="签到" id="signIn"/>
            #if($seccess=="seccess")
            	<input type="button" class="btn-default add_first btn" value="已签到" id="success"/>
            #end 
            <input id="goOn" class="btn-default add_first btn" type="button" value="返回">
		  <form id="activity_voluntary" action="/professional/activity/add_voluntary" method="post" name="searchForm">
			   <input type="hidden" id="activityId" name="activityId" value="$!activityId"/>
			   <input type="hidden" id="pubdate" name="pubdate" value="$!date.format('yyyy-MM-dd',$!pubdate)"/>
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
		        			<td><input class="verification" type="checkbox" name="volunteerId" value="$!{n.id}" />$i </td>
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
	 		$('#goOn').click(function(){
				var activityId=$activityId;
				location.href="/professional/activity/update?id="+activityId;
			});
	 		$('#success').click(function(){
	 			var pubdate=$('#pubdate').val();
	 			var activityId=$('#activityId').val();
	 			location.href="/professional/activity/see_voluntary?activityId="+activityId+"&pubdate="+pubdate;
	 		});
	 
    		$('#signIn').click(function(){
    			$('#voluntary', window.parent.document).val(111);
    			var len = $(".verification:checkbox:checked").length; 
    			if(len==0){
    				alert("请选择签到人员");
    				return false;
    			}else{   
    				$('#activity_voluntary').submit();
    			}
    		});
           $("#checkall").click(function(){ 
				if(this.checked){ 
					$("input[name='volunteerId']").each(function(){this.checked=true;}); 
				}else{ 
					$("input[name='volunteerId']").each(function(){this.checked=false;}); 
					} 
			   });
    });
	</script>
</body>
</html>