<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>已签到人员</title>
#parse("/common/top.tpl")
 <link rel="stylesheet" href="/assets/newCss/plan.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap-select.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
  	<script src="/assets/js/pageNavigator.js"></script>
  	<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
	 a{color: black;}
	 body{background:#D9EBEB}
	 #right{margin-top:30px;}
</style>
</head>
<body>
<div class="wrapper">
	#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
        
	<div id="right" > 
	<div > <input type="button" class="btn-default add_first btn" onclick="javascript:window.history.go(-1)" value="返回"/>
		   <table class="table _tale1"" style="width:100%" >
		 	<tr class="_active">
			 	<th>序号</th>
			 	<th>姓名</th>
			 	<th style="width:25%">身份证号</th>
			 	<th>性别</th>
			 	<th>年龄</th>
			 	<th>联系电话</th>
			 	<th>删除</th>
		 	</tr>
		 	#set($user=$session.getAttribute("sessionUser"))
		 	#if($user.super_)
               	#foreach($u in $page.result)
                #set($i =  (($velocityCount + 1)+(${page.pageNo} - 1)*10))
               	<tr class=" #if($i%2!=0 ) tr_two #else tr_first #end">
		        			<td>$i </td>
		        			<td>$!{u.name}</td>
		        			<td >$!{u.idCardNo}</td>
		        			<td>#if($!{u.gender}==0)女#else男#end</td>
		        			<td>$!{u.age}</td>
		        			<td>$!{u.contactPhone}</td> 
		        			<td><a href="#" class="remove_id" date-id="$u.id" >删除</a></td>
			                <input type="hidden" value="/professional/vender/user/detail/$u.id"/>
        		</tr>
        		#end
        		<tr>
					<td colspan="7">
						<form action="/professional/activity/activity_yiqian" method="post" name="searchForm">
							<input type="hidden"  value="$activityId" name="id"/>
							<input type="hidden" value="$!date.format('yyyy-MM-dd',$pubdate)" name="pubdate"/>
						</from>
						#parse("/common/page.tpl")
					</td>
				</tr>
    		#else
    			#if ($page)
	                #foreach ($u in $page)
	                	#set($i=$math.sub($velocityCount,-1))
		        		<tr class="ibtn addadver ">
		        			<td>$i </td>
		        			<td>$!{u.name}</td>
		        			<td >$!{u.idCardNo}</td>
		        			<td>#if($!{u.gender}==0)女#else男#end</td>
		        			<td>$!{u.age}</td>
		        			<td>$!{u.contactPhone}</td>
		        			<td><a href="#" class="remove_id" date-id="$u.id" >删除</a></td>
			                <input type="hidden" value="/professional/vender/user/detail/$u.id"/>
		        		</tr>
	        		#end
        		#end
    		
    		#end
        		
		   </table>
	</div> 	   
	</div>
	</div>
</div>

<script>
	
			$('.addadver').click(function(){
				var m=$(this).find('input').val();
				top.location.href=m;
			});
			$('.remove_id').click(function(){
                 var id=$(this).attr("date-id");
                 $.ajax({  
                    url:"/professional/activity/yiqian_remove?activityId=$activityId&userId="+id,  
                    type:"get",          
                    success:function(data){
                           alert(data);
                          window.location.reload();
                    }
                 });
            });
	
</script>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
</html>