<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Care Manager_服务商管理</title>
#parse("/common/top.tpl")
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<script src="$request.contextPath/assets/js/jquery-2.1.4.min.js"></script>
<link href="$request.contextPath/assets/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="$request.contextPath/assets/js/bootstrap.min.js"></script>
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/common.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
#if($!{sessionUser.getCateEnum()}!="STREET")
<script>
	function addVender(){
		window.open('/professional/vender/add', '_self');
	}
</script>
#end
</head>
<body class="body1">
#parse("/common/masklayer.tpl")
<div class="wrapper body1">
    #parse("/common/head.tpl")
    
    <div class="body bodyline pad10">
        <div class="usedetail clearfix">
            <div class="searchli">
				<ul class="inpubox clearfix">
					<form action="/professional/vender/list" method="post" name="searchForm">
					<li><label>名称：</label><input class="text150" type="text" name="venderName" value="$!{venderName}"/></li>
					<li><input class="ibtn button_gm" type="submit" value="搜索"></li>
					#if($!{sessionUser.getCateEnum()}!="STREET")
					<li>
						<!--<input class="ibtn button_gm" type="button" value="添加服务商" onclick="addVender()"> -->
						<input class="ibtn button_gm" type="button" value="添加服务商" data-toggle="modal" data-target="#addalbum" id="addchbutton" >
						<!-- <button data-toggle="modal" data-target="#addalbum" class="btn button_add" id="addchbutton" >创建相册</button>   -->
						
					</li>
					#end
					</form>
				</ul>
			</div>
			
			<!-- 新加  -->
			
    <div id="addalbum" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  	<form role="form" id="addAlbumform" method="post" action="/professional/vender/add">
    <div class="modal-dialog">
	      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		          <h4 class="modal-title" id="myModalLabel">添加服务商</h4>
		        </div>
		        <div class="modal-body">
							<div class="form-group">
							 	<label>请输入唯一标识码</label>
							    <input type="text" id="idCardNo" style="width:80%" class="albumname form-control" name="idCardNo">
						 	</div>
						  
		        </div>
		        <div class="modal-footer">
		          <button type="submit" class="btn btn-primary" id="yes" ">确认</button>
		          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		        </div>
	      </div>
    	</div>
    	</form>
    </div>
			
			
			
			
			
			
			
			<!-- 上部新加  -->
			<table class="table100 usertable trclick pointer">
                <tr>
                	<th>服务商名称</th>
                	<th>管理员</th>
                	<th>联系电话</th>
                	<th>联系地址</th>
                	<!--<th>服务商类型</th>-->
                	<th>简介</th>
                	<!--<th>准入资质</th>-->
                </tr>
                #foreach($vender in $page.result)
                <tr>
                	<td>$!{vender.name}</td>
                	<td>$!{vender.userName}</td>
                	<td>$!{vender.contactPhone}</td>
                	<td>$!{vender.contactAddr}</td>
                	<td class="hiddentext">$!{vender.introduction}</td>
                	<input type="hidden" value="/professional/vender/detail?venderId=${vender.id}"/>
                </tr>
                #end
            </table>
             #if($page.result.size()>0)
				#parse("/common/page.tpl")
			 #end
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>