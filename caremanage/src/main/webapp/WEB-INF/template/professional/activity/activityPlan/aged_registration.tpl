<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>节目11</title>
#parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
	 a{color: black;}
	  body{background:#D9EBEB}
</style>
<script>
	$(function(){
		$('#whole').click(function(){
			var activityId=$activityId;
			location.href="/professional/activity/whole?activityId="+activityId;
		});
		$('#goOn').click(function(){
			var activityId=$activityId;
			location.href="/professional/activity/update?id="+activityId;
		});
		$('#signin').click(function(){
			var activityId=$activityId;
			location.href="/professional/activity/activity_yiqian?id="+activityId+"&pubdate="+$('#_pubdate').val();
		});
		
		
		
	});
</script>
</head>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
	<div id="right" > 
	<div class="searchli">
	<br/>
        	<form action="/professional/activity/activity_aged" method="post" name="searchForm">
	            
	            <ul class="inpubox clearfix">
	            	<li><input type="button" class="btn-default add_first btn"  id="add_aged" value="签到"/></li>
	                <input type="hidden"  name="siteId" value="$!siteId" />
	                <input type="hidden"  name="id" value="$!activityId" />
	                <input type="hidden"  name="communityId" value="0" />
	                <input type="hidden" name="pubdate"  id="_pubdate" value="$!date.format('yyyy-MM-dd',$pubdate)" />
	                <li><label>姓名：</label><input name="name" value="$!name" class="text150" type="text" /></li>
	                <li><label>身份证号：</label><input name="idCard" value="$!idCard" class="text150" type="text" /></li>
					<!-- <li><label>所在社区：</label>
						<select name="communityId"  class="select1"  style="height:25px;">
							<option   value=0>-----请选择-----</option>
							#foreach ($o in $oCuntry)
								<option   value=$!o.id>$!o.name</option>
							#end
						</select>
					</li> -->
					<li><input class="btn-default add_first btn" type="submit" value="搜索"></li>
					#if($!{sessionUser.isSuper_()}==false)
					<li><input id="whole" class="btn-default add_first btn" type="button" value="全员"></li>
					#end
					<li><input id="goOn" class="btn-default add_first btn" type="button" value="返回"></li>
					#if($Signin)
					<li><input id="signin" class="btn-default add_first btn" type="button" value="已签人员"></li>
					#end
	            </ul>
            </form>
	</div>
	<div class="tablediv">
		<form id="activity_aged" action="/professional/activity/add_aged" method="post">
			<input type="hidden" id="activityId" name="activityId" value="$!activityId" />
			<input type="hidden" id="communityId" name="communityId" value="$!communityId" />
			<input type="hidden"  name="siteId" value="$!siteId" />
		   <table class="table _tale1" style="width:100%" >
		 	<tr  class="_active">
			 	<th style="width:10%"><input type="checkbox" id="checkall" style="float:left; margin:6px 0 0 10px;" />序号</th>
			 	<th>姓名</th>
			 	<th style="width:25%">身份证号</th>
			 	<th>性别</th>
			 	<th>年龄</th>
			 	<!--<th>联系电话</th>-->
			 	<th>所属社区</th>
		 	</tr>
               	#if ($page)
           			#if($page.result)
		                #foreach ($u in $page.result)
		                	#set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
			        		<tr class=" #if($i%2!=0 ) tr_two #else tr_first #end ibtn addadver ">
			        			<td><input type="checkbox" class="userId" name="userId" value="$!{u.userId}" />$i </td>
			        			<td>$!{u.userName}</td>
			        			<td>$!{u.idCard}</td>
			        			<td>#if($!{u.gender}==0)女#else男#end</td>
			        			<td>$!{u.age}</td>
			        			<!-- <td>$!{u.contactPhone}</td> -->
				                <td>$!{u.communityName}</td>
				                <input type="hidden" value="/professional/vender/user/detail/$u.userId"/>
			        		</tr>
		        		#end
		        	#else	
		        		#foreach ($u in $page)
		                	#set($i=$math.sub($velocityCount,-1))
			        		<tr class="ibtn addadver">
			        			<td><input type="checkbox" class="userId" name="userId" value="$!{u.userId}" />$i </td>
			        			<td>$!{u.userName}</td>
			        			<td>$!{u.idCard}</td>
			        			<td>#if($!{u.gender}==0)女#else男#end</td>
			        			<td>$!{u.age}</td>
			        			<td>$!{u.contactPhone}</td>
				                <td>$!{u.communityName}</td>
				                <input type="hidden" value="/professional/vender/user/detail/$u.userId"/>
			        		</tr>
		        		#end
		        	#end	
        		#end
		   </table> 
		   #parse("/common/page.tpl") 
	   </form>
        </div> 
	</div>
	</div>
<script>
    $(function(){
    		if($('#communityId').val()!=0){
    			$("select option[value=${communityId}]").attr("selected", "selected");
    		}
    		$('#add_aged').click(function(){
	    		$('#voluntary', window.parent.document).val(111);
	    		var len = $(".userId:checkbox:checked").length; 
	    		var activityId=$('#activityId').val();
	    		var communityId=$('#communityId').val();
	    		var ids="";
    			$(".userId:checkbox:checked").each(function(){
    				$(this).attr("disabled","true");
    				$(this).attr("checked",false);
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
    				
    				//$('#activity_aged').submit();
    			}
    			
    		});
    		
           $("#checkall").click(function(){ 
				if(this.checked){ 
					$("input[name='userId']").each(function(){this.checked=true;}); 
				}else{ 
					$("input[name='userId']").each(function(){this.checked=false;}); 
					} 
			   });
    });
   
</script>
</body>
</html>