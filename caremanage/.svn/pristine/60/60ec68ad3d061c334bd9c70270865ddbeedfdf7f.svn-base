<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>vip介绍</title>
#parse("/common/top.tpl")
<link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;">
<form action="/icare/vip/add" method="post" enctype="multipart/form-data" >          	
            <div class="actboxlist">
                
                <div class="actbox8 ">
                
                    <table class="table100 usertable" >
                       <tr>
                        	<td>上传图片：<input type="file" name="pic" style="border: 1px solid #CCC;" /><br/>
                     
                        	</td>
                        </tr>
                        <tr>
                        	<td>服务名称：<input type="text" name="serviceName" style="width: 300px;height: 30px;"/></td>
                        </tr>                 
                       
                        <tr>
                        	<td><span>服务流程：</span><textarea name="chargeInfo" style="width: 300px;height: 200px;"></textarea></td>
                        </tr>
                        <tr>
                        	<td><span>服务内容：</span><textarea name="serviceDetail"style="width: 300px;height: 200px;"></textarea></td>
                        </tr>
                    </table>
                    <input style=" margin-left: 200px;" type="submit" value="添加" class="btnBg"/>
                </div>
            </div>
            </form>
<table class="commonTable" style="width: 1000px;">
	<tr>
		
		<th>服务名称</th>
		<th>服务流程</th>
		<th>服务内容</th>
		<th>操作</th>
	</tr>
	
	 #foreach ($u in $vip)
	 <tr class="pointer1" >
		
		<td>$!u.serviceName</td>
		<td>$!u.chargeInfo</td>
		<td>$!u.serviceDetail</td>
		<td><a href="/icare/vip/edit?id=$!{u.id}">编辑</a>
			<a href="/icare/vip/delete?id=$!{u.id}">删除</a></td>
		</tr>
	#end
	
	</table>
	<div>
	</div>
</div>

</body>
<script type="text/javascript" src="../../assets/director/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/assets/js/country_1.js"></script>
 <script type="text/javascript" src="/assets/js/calendar.js"></script>
 <script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
 <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
<script type="text/javascript">
 $(function(){
 	$(".timedate").calendar({ format:'yyyy-MM-dd hh:mm:ss' });
 	$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
 });
 </script>
</html>