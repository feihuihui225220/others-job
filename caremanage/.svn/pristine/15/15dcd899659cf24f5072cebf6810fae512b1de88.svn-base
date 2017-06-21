<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>节目11</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<style>
	 a{color: black;}
	  body{background:#D9EBEB}
</style>

</head>
<body>
	<div class="searchli">
	<br/>
    	<input type="button" class="ibtn button_add"  id="add_aged" value="签到"/>
	</div>
	<div class="tablediv">
		<form id="activity_aged" action="/professional/activity/add_aged" method="post">
			<input type="hidden" id="activityId" name="activityId" value="$!activityId" />
			<input type="hidden" id="communityId" name="communityId" value="$!communityId" />
		   <table class="usertable" style="width:100%" >
		 	<tr>
			 	<th>姓名</th>
			 	<th style="width:25%">手机号</th>
			 	<th>姓名</th>
			 	<th style="width:25%">手机号</th>
			 	<th>姓名</th>
			 	<th style="width:25%">手机号</th>
		 	</tr>
		 	#set($i=1)
		 	#foreach($foo in [0..$length])
		 	<tr>
		 		#set($a=$i % 3)
		 		#set($f=$foo+1)
		 		#set($f2=$foo+2)
		 		#if($a==1&&$foo<$length)
			 		<td><input type="checkbox" value=$!user[$foo].userId  class="be_worth" />$!user[$foo].userName</td>
			 		<td>$!user[$foo].contactPhone</td>
			 		#if($f<$length)
			 		<td><input type="checkbox" value=$!user[$f].userId  class="be_worth" />$!user[$f].userName</td>
			 		<td>$!user[$f].contactPhone</td>
			 		#else
			 		<td></td>
			 		<td></td>
			 		#end
			 		#if($f2<$length)
			 		<td><input type="checkbox" value=$!user[$f2].userId  class="be_worth" />$!user[$f2].userName</td>
			 		<td>$!user[$f2].contactPhone</td>
			 		#else
			 		<td></td>
			 		<td></td>
			 		#end
	 			#end
		 		#set($i=$i+1)
		 	</tr>	
		 	#end
			
		 	
            </table>
	   </form>
	</div>
<script>
    $(function(){
    
    	$('#add_aged').click(function(){
    	var ids="";
    	var activityId=$activityId;
		var len = $(".be_worth:checkbox:checked").length; 
    		$(".be_worth:checkbox:checked").each(function(){
    				ids+=$(this).val();
    				ids+=",";
    			});
    			ids=ids.substring(0,ids.length-1);
    			if(len==0){
    				alert("请选择签到人员");
    				return false;
    			}else{   
    				$('#default', window.parent.document).val(111);
    				$.ajax({
                   		url: "/professional/activity/add_aged?activityId="+activityId+"&ids="+ids,
                   		type: "post",
                   		success: function (mjson) {
                       		alert(mjson);
                    }
               });
               }
    	});
    		
    });
   
</script>
</body>
</html>