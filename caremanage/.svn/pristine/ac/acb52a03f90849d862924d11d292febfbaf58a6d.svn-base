<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>患者管理</title>
 <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
<link href="/assets/director/style/XZuserm.css" rel="stylesheet" type="text/css">
</head>
<body>
#parse("/common/masklayer.tpl")
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
  #parse("/common/dtop.tpl")
  #parse("/common/dmain.tpl")
<div class="main1">
  <div>
    <div class="personInfo_right fl" style="float: left;">
		    <div class="pad10">
		        <div class="usedetail clearfix" style="width:850px;">
		           <form method="post"  class="allca" action="/director/hgroupUser/toAllocation" name="searchForm">
		           		<select name="avaible" class="tinput">
							<option #if($avaible==2) selected="selected" #end value="2">请选择</option>           		
							<option #if($avaible==0) selected="selected" #end value="0">已分配</option>           		
							<option #if($avaible==1) selected="selected" #end value="1">未分配</option>           		
		           		</select>
		   				<input class="button_gm btnBg" type="button" value="查询">
		           </form>
		               <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" style="width:800px">
							<tr>               
								<th>序号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>添加时间</th>
								<th>分配</th>
							</tr> 
							
							#if ($page)
				                #foreach ($u in $page.result)
				                 #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
			        			<tr class="pointer1" date-href="/director/user?userId=$!{u.id}">
				        			<td>$i</td>
				        			<td>$!{u.name}</td>
				        			<td> #if($!{u.gender}==0)女#else男#end</td>
					                <td> $!{u.createdAt} </td>
					                <td>
					                #if(!$u.groupId) 
					                 <input type="button"  data-groupId="" data-hId="" data-id="$!{u.id}" data-toggle="modal" data-target="#addUser"  class="btnBg  btn-primary usderId" value="分配"> 
					                #else 
					                <input type="button" data-groupId="$u.groupId" data-hId="$!u.hId"  data-id="$!{u.id}" data-toggle="modal" data-target="#addUser" class="btnBg1 btnBg btn-primary usderId" style="margin-top: 0px;"  value="已分配"> 
				                   #end</td>
				        		</tr>
				        		#end
		    				#end
		   			
				   		</table>
				   			<div class="page fr">
						       	#parse("/common/page.tpl")
						      </div>   
		    	</div>
			   			
			</div>
			
			
			
			<div id="addUser" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
			    <div class="modal-dialog">
				      <div class="modal-content">
						        <div class="modal-header">
						          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						          <h4 class="modal-title" id="myModalLabel">分配用户</h4>
						        </div>
						        <div class="modal-body">
									<div class="form-group">
									  <form  id="addUserFrom" method="post" action="/director/hgroupUser/addGrouIdUser">
										<input AUTOCOMPLETE="off" type="hidden" name=userId id="userId">
										<input AUTOCOMPLETE="off" type="hidden"  name=id id="hId">
									 		<table  style="width:500px; text-align: center;">
									 			<tr>
									 				<th>序号</th>
									 				<th>巡诊组</th>
									 				<th>分配</th>
									 			</tr>
									 		#foreach($h in $ausers)
									 		#if($h.super_!=true)
									 			#set($i = $velocityCount)
									 			
									 			<tr>
									 				<td>$i</td>
									 				<td>$h.name</td>
									 				<td><input AUTOCOMPLETE="off" class="grop_id" type="radio" value="$h.id" name=groupId></td>
									 			</tr>
									 			#end
									 		#end
									 		</table>
										</form>
								 	</div>
						        </div>
					        <div class="modal-footer">
					          <button type="button" class="btnBg"  onclick="addUser()">确认</button>
					          <button type="button" class="btnBg btnBg1 cancel_all" data-dismiss="modal">取消</button>
					        </div>
				      </div>
			   </div>
			</div>
  	</div>
   </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
$(".main .main_left .sidebar li a").eq(8).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
  $('.usderId').click(function(){
  	var id=$(this).attr('data-id');
  	var groupId=$(this).attr('data-groupId');
  	var hId=$(this).attr('data-hId');
  	if(hId!=""){
  		$('#hId').val(hId);
  	}
  	$('#userId').val(id);
  	$('.grop_id').each(function(){
  		if($(this).val()==groupId){
  			$(this).attr( "checked",true );
  		}
  	});
  });
  
  $('.button_gm').click(function(){
  	$('.allca').submit();
  });
  
  $('.cancel_all').click(function(){
  	$('#addUser').hide();
  	location.reload();
  	$(".msk").hide();
  	
  });
  
  $('.close').click(function(){
  	$('#addUser').hide();
  	location.reload();
  	$(".msk").hide();
  	
  });
});
 function addUser(){
  	$('#addUserFrom').submit();
  }
</script>
</html>
