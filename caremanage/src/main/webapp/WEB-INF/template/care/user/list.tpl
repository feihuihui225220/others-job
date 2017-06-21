<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script>
	$(function(){
		$('.adduser').click(function(){
			location.href="/professional/vender/addUser";
		});
	});
	
	 $(function(){
		$('.deleted').click(function(){
			var id=$(this).attr("date-value");
			var gnl=confirm("你真的打算删除吗?");
				if (gnl==true){
					location.href="/professional/vender/user/delete/"+id;
				}else{
					return false;
				}
		});
})
</script>
<style>
	.th_wid{width:80px;}
	.tablebox{width:97%}
	.mux_a{ background:#4AC6CE;}
	.margin_top{margin-top:20px;}
	#select{width:120px;}
	#conclusion{width:120px;}
	#if($sessionUser.cateEnum.type==3)
		#left{background-color: #16A5AD;}
		.nav1{background-color: #16A5AD;}
		.a_Special_4{position: relative;top: -45px;color: #F7FCFC;}
	#end
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
	#parse("/common/head.tpl")
     <div id="left">
	        #parse("/common/providers.tpl")
       </div> 
    <div id="right"> 
    <div class="body">
		<div class=" bodyline pad10">
			<form action="/care/user/list" method="post" name="searchForm">
				<div class="searchli">
					<ul class="inpubox clearfix">
						
						<li><label>姓名：</label><input name="name" value="$!user.name" class="text150" type="text"  maxlength="5"/></li>
						<li><label>身份证号：</label><input name="idCardNo" value="$!user.idCardNo" class="text150" type="text"  maxlength="18"/></li>
						<li>
							<label>社区：</label>
							<select class="select160" name="communityId" id="">
								<option value="-1">全部</option>
								#foreach ($commt in $communitys)
									<option value="$!commt.id" #if($!communityId==$!commt.id)selected="true"#end>$!commt.name</option>
								#end
							</select>
						</li>
						<li>
							<label>状态：</label>
							<input type="hidden" id="active" value="$active">
							<select id="active_1" class="select160" name="active" id="">
								<option value="-1">---请选择---</option>
								<option value="0">得审核</option>
								<option value="1">待分配</option>
								<option value="2">已分配</option>
							</select>
						</li>
						<li><input class="button_add" type="submit" value="搜索"></li>
						<li><input class="adduser button_add" type="button" value="添加用户"/></li>
					</ul>
				</div>
			</form>
			<div class="actboxlist">
                   <table class="table100 usertable  trclick ">
                        <tr><th>姓名</th><th style="width:22%">身份证号</th><th class="th_list">性别</th><th class="th_list">年龄</th><th style="width:10%">联系电话</th><th>状态</th><th style="width:12%">添加人</th><th  class="th_list">详情</th><th  class="th_list">删除</th></tr>
                        #if ($page)
			                #foreach ($u in $page.result)
				        		<tr>
				        			<td>$!{u.name}</td>
				        			<td >$!{u.idCardNo}</td>
				        			<td>#if($!{u.gender}==0)女#else男#end</td>
				        			<td>$!{u.age}</td>
				        			<td>$!{u.contactPhone}</td>
			        				#if (!$u.contacts.isNull() && $u.contacts.size()>0)
									#else
										<td>
											#if($!{u.active}==0)
												待审核
											#elseif($!{u.active}==1)
												待分配
											#elseif($!{u.active}==2)
												已分配
											#end	
										</td>
										<td>$!{u.createdBy}</td>
										
										<td><a href="/professional/vender/user/detail/$!u.id">详情>></a></td>
										#if($sessionUser.name==$!{u.createdBy})
											<td><a date-value="$!u.id" class="deleted" href="#">删除>></a></td>
										#else
											<td><a class="alert_permission"> 删除<<</a></td>
										#end
									#end
				        		</tr>
			        		#end
		        		#end
                    </table>
                    #parse("/common/page.tpl")
                </div>
		</div>
    </div>
    </div>
    <div class="footer"></div>
</div>
<script>
	$(function(){
		$('.alert_permission').click(function(){
			alert("您无权操作！")
		});
	});
	$(function(){
		var a=$('#active').val();
		$('#active_1 option').each(function () {
			    var $option = $(this);
			    var html = $option.html();
			    var value = $option.val();
			    if(value==a){
			    	$(this).attr('selected','selected');
			    }
		});
	});
</script>
</body>
</html>