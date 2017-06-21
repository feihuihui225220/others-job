<!DOCTYPE html>
<html>
  <head>
    <title>个人巡诊计划详情</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script src="/assets/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/assets/js/top.js"></script>
	<link rel="stylesheet" href="/assets/director/style/XZxunzhen.css" type="text/css">
	<style type="text/css">
		 
	 	.wrapper li{float: left;margin-left:30px;}
		body{font-size:14px;}
		.plan{padding-top:10px;}
	</style>
  </head>
  
  <body>
    #parse("/common/dtop.tpl")
  #parse("/common/duser.tpl")
   <div class="main1">
	#parse("/common/dleft.tpl")
		 
		<div class="plan">
		<ul>
			<li>
				#foreach($p in $plan.keySet())
				服务内容：$p，
				服务时间：$!date.format("yyyy-MM-dd HH:mm:ss",$plan.get($p).visitTime)
				#end 
			</li>
		</ul>	
		</div>
	 
		
	</div>
  </body>
  <script type="text/javascript" src="/assets/js/My97DatePicker/WdatePicker.js"></script> 
  <script src="$request.contextPath/assets/js/jquery.validate.js"></script>
  <script type="text/javascript">
  	$(function(){
  	$(".personInfo .personInfo_left .sidebar li a").eq(4).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
  		$("#category").change(function(){
  		var parentId = $(this).val();
  		var h="";
  			$.ajax({
  				url:'/admin/getCategory/'+parentId,
  				type: "post",
  				success:function(data){
  					var category = eval('('+data+')');
	  					$.each(category,function(id,json){
	  						if(json[0]){
  							h+="<li class='category' data-id="+json[0].id+" >"+json[0].name+"</li>";
	  						}
  					});
  					console.info(h);
  					$("#www_zzjs_ne").empty();
  					$("#www_zzjs_ne").append(h);
  				}
  			});
  		});
  		$(".category").click(function(){
  			alert($(this).text());
  		});
  	});
  </script>
<script type="text/javascript">
var code = "";
$(document).on('click','.category',function() {
  code+= $(this).attr("data-id") + ","; 
  var h = "<li class='xz' data-id='"+$(this).attr("data-id")+"' >"+$(this).text()+"</li>";
  $("#rightul").append(h);
  $(this).remove();
   console.info(code);
   $("#code").val(code);
	console.info($(this).attr("data-id"));
	var nu=$("#num").text();
		nu++;
		$("#num").text(nu);
});
$(document).on('click','.xz',function() {
	    $(this).remove();
	    code = code.replace($(this).attr("data-id")+",", "");
	     console.info(code);
	     $("#code").val(code);
	    var h = "";
	    h+="<li class='category' data-id="+$(this).attr("data-id")+" >"+$(this).text()+"</li>";
	    $("#www_zzjs_ne").append(h);
	    var nu=$("#num").text();
		nu--;
		$("#num").text(nu);
});

$("#visitplanForm").validate({
    rules: {
   time: "required",
   code: "required",
  },
   messages: {
   time: "<span style='color:#f00;'>*请选择巡访时间</span>",
   code: "<span style='color:#f00;'>*请选择服务</span>",
  }
 });
</script> 
 
</html>
