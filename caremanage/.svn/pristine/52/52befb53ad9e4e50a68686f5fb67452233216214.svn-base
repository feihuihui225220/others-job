<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>员工管理</title>
</head>
<body>
#parse("/common/masklayer.tpl")#set ($sessionUser=$!{session.getAttribute("sessionUser")})
  #parse("/common/dtop.tpl")
  #parse("/common/dmain.tpl")
<div class="main1">
  <div>
    <div class="personInfo_right fl" style="float: left;">
				<div  >
					<div class="usertitle mgb10 strong clearfix">
						<div class="f_r fr_itbn">
							<button onclick="window.location.href='/director/addUser'"
								class="btnBg" style="margin-left: 800px;">添加员工</button>
						</div>
					</div>
					<div class="tablebox">
						<form action="/director/users" method="post" name="searchForm">
							<table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable">
								<tr>
									<th>姓名</th>
									<th>联系电话</th>
									<th>角色</th>
									<th>编辑</th>
									<th>删除</th>
								</tr>
								#if($page) #foreach ($u in $page.result)
								<tr class="userid_$!{u.id}">
									<td>$!u.name</td>
									<td>$!u.contactPhone</td>
									<td>#if ($u.roles && $u.roles.size()>0) #foreach ($r in
										$u.roles) #if ($velocityCount==0) $r.name #end #end #else - #end
									</td>
									<td class="operate"><a href="/director/modifyUser/$!u.id">编辑>></a>
									</td>
									<td class="operate"><a class="deluser" userid="$!{u.id}">删除>></a>
									</td>
								</tr>
								#end #end
							</table>
							<div class="page fr">
						       	#parse("/common/page.tpl")
						      </div>
						</form>
						#set($user=$session.getAttribute("sessionUser"))
						 
					</div>
				</div>
   			
   			<!-- <div class="userbox pad10 hide">
				<ul class="inpubox clearfix">
					<li><label>姓名：</label><input class="text150" name="" type="text" /></li>
					<li><label>登录密码：</label><input class="text150" type="text" /></li>
					<li><label>联系电话：</label><input class="text150 timedate"
						type="text" /></li>
					<li><label>选择角色：</label><select class="select160" name="" id=""><option
								value="0">全部</option>
							<option value="0">全部</option></select></li>
				</ul>
			</div> -->
  	</div>
   </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
$(".main .main_left .sidebar li a").eq(6).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
    $(".deluser").click(function(){
        var userid = $(this).attr("userid");
        layer.confirm('是否确定删除该员工?', function(index){
            $.get("/director/removeUser/"+userid,function(result){
    			if(result=='success'){
	    			// 移除记录
            		$('.userid_'+userid).remove();
    			}else{
    				alert(result);
    			}
  			});
            layer.close(index);
        }, function(index){
            //console.log(index);
        });
    });// 
    
    $(".delsite").click(function(){
        var mid = $(this).attr("mid");
        layer.confirm('是否确定删除站点信息?', function(index){
            $.get("/professional/vender/site/delete?id="+mid,function(result){
    			if(result=='success'){
	    			// 移除记录
            		$('.mid_'+mid).remove();
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
