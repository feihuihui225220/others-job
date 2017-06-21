#set($user=$session.getAttribute("sessionUser"))
#if($user.getCateEnum()=="PRO")
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>用户管理</title> 
<script type="text/javascript" src="/assets/js/top.js"></script>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/newJs/user.js"></script>
<link rel="stylesheet" href="/assets/newCss/index.css" />
</head>
<style>
button.pad5 {
	line-height: 16px;
}
</style>
<body>
	#parse("/common/masklayer.tpl")
	## 当角色不为服务商时，应该将站点屏蔽掉
	<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
			#parse("/common/providers.tpl")
			<div id="right">
				<div class="plan_css"
					style="width: 50%; float: left; margin-right: 20px;">
					<button class="add_first_1 add_first btn-default  btn ">添加员工</button>
					<div style="display: none;"
						class=" div_from3 panel-primary plan_ product-container">
						<form method="post" action="/permission/saveUser"
							style="width: 500px;" name="addUser">
							<br> <label class="lable_1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input
								name="name"></label> <label class="lable_1">登录密码：<input
								name="password"></label> <br> <br> <label
								class="lable_1">联系电话：<input name="contactPhone" value=""></label>
							<br> <br> <label class="lable_1">选择角色：</label> <br>
							<input id="_sites" name="sites" type="hidden"> <label
								class="lable_1"> #foreach ($r in $roles)
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input
									type="checkbox" name="roleIds" value="$!r.id"
									style="margin: 0;" />$!r.name</label> #end
							</label>
							<div style="height: 350px;">
								<label
									style="float:left; margin-top: 12px;padding-left: 3px;;height:35px">添加站点：</label>
								<div id="see_siteName" class="see_siteName"
									style="overflow:hidden;"></div>
								<input id="search" autocomplete="off" class="sousuo" 
									placeholder="搜索" /> <input class="btn-default btn delete"
									value="取消" /><br> <br>
								<ul id="suspension_add" class="suspension" style="">
								</ul>
								<a class="huanyihuan">换一换</a>
								<div class="1 div_1">#foreach($m in $mVenderSiteList)
									#set($i = $velocityCount+1 ) #if($i%20==0&&$i!=1)
									#set($x=$i/20)</div>
								<div class="$x div_1">
									#end
									<div class="_div_mdule_site div_module_site"
										date-value="$!m.id">$!m.siteName</div>
									#end
								</div>

							</div>
							<button class="btn button_delete margin_" type="button"
								onclick="window.location.href='/permission/users'">取 消</button>
							<input class="btn margin_  button_gm _user_add" value="保 存"
								type="button"> <br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
							<br>
						</form>
					</div>
					
					<div class="usertitle mgb10 strong clearfix">员工管理</div>
					<form action="/permission/users" method="post" name="searchForm">
						姓名：<input name="userName" value="$!userName"> <button class="button_gm">查询</button>
						<table class="table _tale1">
							<tr class="_active">
								<th>姓名</th>
								<th>联系电话</th>
								<th>角色</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
							#if($page) #foreach ($u in $page.result) #set($i =
							(($velocityCount + 1)+(${page.pageNo} - 1)*10))
							<tr
								class="userid_$!{u.id} #if($i%2!=0 ) tr_two #else tr_first #end"
								data-id="$!e.id">
								<td>$!u.name</td>
								<td>$!u.contactPhone</td>
								<td>#if ($u.roles && $u.roles.size()>0) #foreach ($r in
									$u.roles) #if ($velocityCount==0) $r.name #end #end #else -
									#end</td>
								<td class="operate"><a data-target="#addUser"
									data-toggle="modal" date-id="$!{u.id}" date-name="$!u.name"
									date-contactphone="$!u.contactPhone"
									class=" _button_add _see_user">编辑</a></td>
								<td class="operate"><a class="deluser" userid="$!{u.id}">删除</a>
								</td>
							</tr>
							#end #end
						</table>
						#parse("/common/page.tpl")
					</form>
				</div>
				<!-- -----------------------------------------------------权限--------------------------------------- -->
				<div style="float: left; width: 44%;">
					<div class=>
						<button class="add_first_2 add_first btn-default  btn">添加</button>
						<div style="display: none;"
							class=" div_from3 panel-primary plan_addRoles product-container">
							<form method="post" action="/permission/saveRoles"
								style="width: 500px;" name="addRoles">
								<h4>添加角色</h4>
								<ul class="userlimit">
									<li>名称：<input name="name" id="addjs_name"></li>
									<li>描述：<input name="descr" id="addjs_descr"></li> #if ($resources)
									#foreach ($resource in $resources)
									<li><input type="checkbox" name="resIds"
										value="$!resource.id" #if($checked)checked="checked" #end
										id="">$!resource.name</li> #end #end
								</ul>
								<button class="btn button_delete" type="button"
									onclick="window.location.href=&quot;/permission/users&quot; ">取
									消</button>
								<input class="btn  button_gm _user_roles" value="保 存"
									type="button">
							</form>
						</div>
						<div class="usertitle mgb10 strong clearfix">角色</div>
					</div>
					<div class="tablebox">
						<table class="table _tale1">
							<tr class="_active">
								<th>名称</th>
								<th>描述</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
							#if ($roles) #foreach ($r in $roles) #set($i =$velocityCount + 1)
							<tr
								class="limitid_$!r.id  #if($i%2!=0 ) tr_two #else tr_first #end">
								<td #if($r.id==$role.id)style= "color:#0000FF"#end>$!r.name</td>
								<td>$!r.descr</td>
								<td class="operate"><a class="updateRoles"
									data-target="#addRoles_" data-toggle="modal" date-id="$!r.id"
									date-name="$!r.name" date-descr="$!r.descr" limitid='$!r.id'>编辑<a /></td>
								<td class="operate"><a limitid='$!r.id'
									class="delulimit mgl5 ">删除<a /> <input type="hidden"
										value="/permission/roles?id=$!r.id"></td>
							</tr>
							#end #end
						</table>
					</div>
				</div>

				<div id="addRoles_" class="modal fade" tabindex="-1" role="dialog"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">修改信息</h4>
							</div>
							<div class="modal-body">
								<form method="post" action="/permission/saveRoles"
									style="width: 500px;" name="UpdateRoles">
									<ul class="userlimit">
										<li>名称：<input id="name_roles" name="name"></li>
										<li>描述：<input id="descr_roles" name="descr"></li>
										<input type="hidden" id="id_roles" name="id"> #if
										($resources) #foreach ($resource in $resources)
										<li><input class="_rolesPro" type="checkbox"
											name="resIds" value="$!resource.id"
											#if($checked)checked="checked" #end>$!resource.name</li>
										#end #end
									</ul>
									<button class="btn button_delete" type="button"
										onclick="window.location.href=&quot;/permission/users&quot; ">取
										消</button>
									<input class="btn  button_gm _update_roles" value="保 存"
										type="button">
								</form>
							</div>
						</div>
					</div>
				</div>

				<!-- -----------------------------------------------------权限--------------------------------------- -->
			</div>
		</div>
		<div class="footer"></div>
		<!-- 修改 -->
		<div id="addUser" class="modal fade" tabindex="-1" role="dialog"
			aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改信息</h4>
					</div>
					<div class="modal-body">
						<form method="post" action="/permission/saveUser"
							style="width: 500px;" name="updateUser">
							<br>
							<input name="id" type="hidden" id="id_" /> <label class="lable_1">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input
								name="name" id="name_"></label> <label class="lable_1">登录密码：<input
								name="password"></label> <br> <br> <label
								class="lable_1">联系电话：<input id="contactPhone_"
								name="contactPhone" /></label> <br> <br> <label
								class="lable_1">选择角色：</label> <br> <input id="sites_u"
								name="sites" type="hidden" value="" /> <label class="lable_1">
								#foreach ($r in $roles) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label><input
									type="checkbox" class="_roleIds" name="roleIds" value="$!r.id"
									style="margin: 0;" />$!r.name</label> #end
							</label>
							<div style="height: 305px;">
								<label>添加站点：</label><br>
								<div id="_update_see_siteName" class="see_siteName"
									style="overflow:hidden;"></div>
								<input autocomplete="off" class="sousuo" id="search_" placeholder="搜索">
								<input class="btn-default btn delete" value="取消"><br>
								<br>
								<ul id="suspension_update" class="suspension" style="">
								</ul>
								<a class="huanyihuan">换一换</a>
								<div class="1 div_1">#foreach($m in $mVenderSiteList)
									#set($i = $velocityCount+1 ) #if($i%20==0&&$i!=1)
									#set($x=$i/20)</div>
								<div class="$x div_1">
									#end
									<div class="_div_module_site div_module_site"
										date-value="$!m.id">$!m.siteName</div>
									#end
								</div>
							</div>
							<button class="btn button_delete" type="button"
								onclick="window.location.href=&quot;/permission/users&quot; ">取
								消</button>
							<input class="btn  button_gm _user_update" value="保 存"
								type="button">
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>	
		<div class="userbox pad10 hide">
			<ul class="inpubox clearfix">
				<li><label>姓名：</label><input class="text150" name=""
					type="text" /></li>
				<li><label>登录密码：</label><input class="text150" type="text" /></li>
				<li><label>联系电话：</label><input class="text150 timedate"
					type="text" /></li>
				<li><label>选择角色：</label><select class="select160" name="" id=""><option
							value="0">全部</option>
						<option value="0">全部</option></select></li>
			</ul>
		</div>
		<script>
		$('.updateRoles').click(function() {
		
			var id = $(this).attr('date-id');
			var name = $(this).attr('date-name');
			var descr = $(this).attr('date-descr');
			$('#id_roles').val(id);
			$('#name_roles').val(name);
			$('#descr_roles').val(descr);
			$.ajax({
					url : "/permission/rolesPro?id="+ id,
					type : "get",
					success : function(json) {
						var msg = eval("("+json+")"); 
						var length = msg.length;
						for (var i = 0; i < length; i++) {
							$('._rolesPro').each(function() {
								if ($(this).val() == msg[i].id) {
									$(this).attr('checked',true);
								}
							});
						}
						
	
	
					}
				});

		});
	</script>
</body>
</html>
#else
<html>
<head>
<meta charset="utf-8" />
<title>用户管理</title> #parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
</head>
<style>
button.pad5 {
	line-height: 16px\0;
}
</style>
<body>
#parse("/common/masklayer.tpl")
	## 当角色不为服务商时，应该将站点屏蔽掉
	<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="body bodyline pad10">
			<div class="usertitle mgb10 strong clearfix">
				<div class="f_r fr_itbn">
					<button onclick="window.location.href='/permission/addUser'"
						class="button_gm">添加员工</button>
				</div>
				员工管理
			</div>
			<div class="tablebox">
				<form action="/permission/users" method="post" name="searchForm">
					<table class="table100 policy usertable cen pointer">
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
							<td class="operate"><a href="/permission/modifyUser/$!u.id">编辑>></a>
							</td>
							<td class="operate"><a class="deluser" userid="$!{u.id}">删除>></a>
							</td>
						</tr>
						#end #end
					</table>
					#parse("/common/page.tpl")
				</form>
				#set($user=$session.getAttribute("sessionUser"))
				#if($user.getCateEnum()=="PRO")
				<div class="pad10">
					<div class="usertitle mgb10 strong clearfix">
						<div class="f_r fr_itbn">
							<button
								onclick="window.location.href='/professional/vender/site/tosave'"
								class="button_gm">添加站点</button>
						</div>
						站点管理
					</div>
					<table class="table100 usertable cen trclick">
						<tr>
							<th>序号</th>
							<th>站点</th>
							<th>添加时间</th>
							<th>编辑</th>
							<th>删除</th>
						</tr>
						#set($i=1) #foreach($m in $mVenderSiteList)
						<tr class="mid_$!{m.id}">
							<td>$i
							</th>
							<td>$m.siteName
							</th>
							<td>$!date.format('yyyy-MM-dd ',$!m.createdAt)
							</th>
							<td class="operate"><a
								href="/professional/vender/site/toupdate?id=$m.id">编辑>></a></td>
							<td class="operate"><a class="delsite" mid="$!{m.id}">删除>></a>
							</td>
						</tr>
						#set($i=$i+1) #end

					</table>
				</div>
				#end
			</div>
		</div>
	</div>
	</div>
	<div class="footer"></div>
	</div>
	<div class="userbox pad10 hide">
		<ul class="inpubox clearfix">
			<li><label>姓名：</label><input class="text150" name="" type="text" /></li>
			<li><label>登录密码：</label><input class="text150" type="text" /></li>
			<li><label>联系电话：</label><input class="text150 timedate"
				type="text" /></li>
			<li><label>选择角色：</label><select class="select160" name="" id=""><option
						value="0">全部</option>
					<option value="0">全部</option></select></li>
		</ul>
	</div>
	<script type="text/javascript" src="/assets/js/layer.min.js"></script>
	<script type="text/javascript">
$(function(){
    $(".deluser").click(function(){
        var userid = $(this).attr("userid");
        layer.confirm('是否确定删除该员工?', function(index){
            $.get("/permission/removeUser/"+userid,function(result){
    			if(result=='success'){
	    			// 移除记录
            		$('.userid_'+userid).remove();
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
</body>
</html>
#end
