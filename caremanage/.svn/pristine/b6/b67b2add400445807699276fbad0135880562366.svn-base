<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>巡诊组管理</title>
    <link href="/assets/director/style/XZuserm.css" rel="stylesheet" type="text/css">
</head>

<body>

  #parse("/common/dtop.tpl")
  #parse("/common/dmain.tpl")
<div class="main1">
  <div>
    <div class="personInfo_right fl" style="float: left;">
   			<div class="table fl"  >
   			<form method="post" id="SelectUser" action="/group/findAll" name="searchForm">
				<table   cellspacing="0" cellpadding="7" class="commonTable" style="width:900px;">
		
						<thead>
							<tr>
								<th>巡诊组名称</th>
								<th>医生</th>
								<th>护士</th>
								<th>负责区域</th>
								<th>操作</th>
							</tr>
						</thead>
					#if($page)	
						#foreach($n in $page.result)
						<tr>
							<td>$!n.userName </td>
							<td style="width: 13%;">$!n.doctor</td>
							<td style="width: 13%;">$!n.nurse</td>
							<td>$!n.community</td>
							<td>
								<a href="/group/findById?id=$n.id">编辑</a>
								 	&nbsp;||&nbsp;
									<a href="#" class="deluser" userid="$!{n.userId}" >删除</a>
							</td>
						</tr>
						#end
					</table>
					 <div class="page fr">
				       	#parse("/common/page.tpl")
				      </div>
					#end
					</form>
			</div>
  	</div>
   </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script>
$(function(){
$(".main .main_left .sidebar li a").eq(3).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
	   $(".deluser").click(function(){
       	var userid = $(this).attr("userid");
	        layer.confirm('是否确定删除该员工?', function(index){
		            $.get("/director/removeUser/"+userid,function(result){
		    			if(result=='success'){
			    			// 移除记录
		            		window.location.reload();
		    			}else{
		    				alert(result);
		    			}
		  			});
	            layer.close(index);
	        }, function(index){
	            //console.log(index);
	        }); 
    	}); 
});
</script>
</html>