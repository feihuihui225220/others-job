<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息</title>   
<script src="../../assets/js/common.js"></script>
<script src="../../assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
<style>
	.header .logo {
		width:50%;
	}
	.noborder{
		border:none;
	}
	.fullwidth{
		width:100%;
	}
	.nav-tabs{
		border-bottom:none;
	}
	.nav>li>a{
		padding:10px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
	.nav-tabs>li{
		float:none;
	}
	.nav-tabs>li>a{
		border-radius:0px 0px 0px 0px;
	}
	.nav-tabs>li.active>a{
		border:1px solid transparent;
		color:#428bca;
	}
	.nav-tabs>li.active>a:hover{
		border:1px solid transparent;
		background-color:transparent;
		color:#428bca;
	}
</style>
</head>

<body>

<div class="main1">
  #parse("/common/dtop.tpl")
    #parse("/common/duser.tpl")
  <div>
	<div class="contentPer">#parse("/common/dleft.tpl")</div>
    	<div class="personInfo_right fl" style="float: left;">
     			  #if($sessionUser.cateEnum.type == 1)
		    #parse("/common/head.tpl")
		    #end
		    #if($!{sessionUser.getCateEnum()}=="USER")
				 	<iframe id="userFrame"  width="20%" style="height:800px; margin-left:1%"src="/user/detail" frameborder="0" scrolling="no"></iframe>
		        <div style="width:75%;float:right;"  >
			#else
		        <div>
			 #end
		     #foreach($device in $orderDevices)
		          	<iframe class="fullwidth  " #if($stype==0) src="/professional/service/show?deviceBindId=$device.deviceBindId&metaServiceId=$device.metaServiceId"#else src="/professional/service/diverseShow?stype=$stype&userId=$userId&serviceId=$serviceId"      #end frameborder="0" scrolling="no"></iframe>
		      #end
     			
     
      
    	</div>
  	</div>
   </div>
</div>
</body>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script>
$(function(){
$(".personInfo .personInfo_left .sidebar li a").eq(3).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
	var thisheight = $(document).height()#if($sessionUser.cateEnum.type == 1)-190#end;
	$("iframe").css({height:thisheight});
});
</script>
</html>
