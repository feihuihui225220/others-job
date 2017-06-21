<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>老年人前端_订购服务</title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/common.js"></script>
<script src="/assets/js/jquery.validate.js"></script>
</head>
<style>
.addContact{line-height:14px\0;}
</style>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usertitle strong clearfix"><div class="f_r fr_itbn"><button onclick="javascript:history.back();" class="addContact button_btn">返回</button></div>订购服务</div>
        <div class="rightbtn pad10"></div>
        <div class="usedetail clearfix">
         <div>
        	<form id="searchVendor" onkeypress="if(event.keyCode==13||event.which==13){return false;}">
        		<input type="text" name="name">
        		<input type="hidden" name="userId" value="$!{searchUserVo.id}">
        		<input type="button" id="btn_vendor" value="搜索服务商" class="ibtn button_btn">
        		<input type="button" id="btn_menu" value="搜索菜单" class="ibtn button_btn"></form>
        </div>
			<div class="ggtext">
	         <table class="table100 usertable cen trclick pointer">
	         	<tr>
	         		<th>服务商</th>
	         		<th>服务商地址</th>
	         		<th>菜单</th>
	         		<th>单价</th>
	         		<th>描述</th>
	         	</tr>
	         	#foreach($item in $menus)
	         	<tr>
	         		<td>$!item.cVendor.name<input type="hidden" value="/care/menu/list?vendorId=$!item.cVendor.id&userId=$!userId&serviceType="></td>
	         		<td>$!item.cVendor.address</td>
	         		<td>$!item.name</td>
	         		<td>$!item.price</td>
	         		<td>$!item.remarks</td>
	         	</tr>
	         	#end
	         </table>

			</div>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
<script type="text/javascript">
$(function(){
	$('#btn_vendor').click(function(){
		$('#searchVendor').attr('action','/care/vendor/search');
		$('#searchVendor').submit();
	});
	$('#btn_menu').click(function(){
		$('#searchVendor').attr('action','/care/vendor/searchMenu');
		$('#searchVendor').submit();
	});
	$("#searchVendor").validate({
		rules:{
			name:{
				required:true
			}
		},
		messages:{
			name:{
				required:"<span style='color:#f00;'>*请输入搜索内容</span>"
			}
		}
	});
});
</script>
</html>