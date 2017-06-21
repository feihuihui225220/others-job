<!DOCTYPE html>
<html>
  <head>
    <title>添加巡诊计划</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script src="/assets/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/assets/js/top.js"></script>
	<link rel="stylesheet" href="/assets/director/style/XZxunzhen.css" type="text/css">
	<style type="text/css">
		 
	 	.wrapper li{float: left;margin-left:30px;}
		body,td,th{font-size:14px;}
		#rightbar,#zzjs_net{border:1px solid #ccc;padding:10px;width:220px;height:300px;overflow:auto;}
		#rightbar{float:right;}
		#zzjs_net{float:left;}
		#le_ho_cn{width:600px;margin:0 auto;padding:15px;}
		#le_ho_cn ul{padding-top:5px;}
		#le_ho_cn ul li{line-height:1.8;cursor:pointer;width:100px;height:20px;margin:3px 0;list-style:none;}
		#num{color:#f00;}
		 
	</style>
  </head>
  
  <body>
    #parse("/common/dtop.tpl")
  #parse("/common/duser.tpl")
   <div class="main1">
	#parse("/common/dleft.tpl")
		<form action="/visit/plan/added" id="visitplanForm">
		<div class="body">
		<ul>
			<li>
			上门时间：<input class="shangmenInput" id="visitTime" type="text" 
			name="time"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete="off">
				#set($user=$session.getAttribute("sessionUser"))
			
			服务内容
			<select class="shangmenInput" name="category" id="category">
				<option value="0">请选择</option>
				#foreach($c in $catetory)
				<option value="$c.id" class="category">$c.name</option>
				#end
			</select>
			 </li>
			 <li>
			   <div id="le_ho_cn">
				  <div id="zzjs_net">
				    <div id="_zzjs_net">你最多可以选择100个</div>
				    <ul id="www_zzjs_ne">
				    </ul>
				  </div>
				  <div id="rightbar">
				         您已经选择了<strong id="num">0</strong>个！
				    <ul id="rightul"></ul>
				  </div>
				</div>
				<input type="hidden" name="code" id="code">
				<input type="hidden" name="userId" value="$userId">
			</li>
		</ul>	
		</div>
		<input type="submit" value="确定" class="button_gm btnBg input2" />
		<input type="button" value="取消" class="button_gm btnBg1 btnBg input2" onclick="JavaScript:history.back(-1);"/>
		</form>	 
		
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
