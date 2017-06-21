<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>健康数据</title>
    <script type="text/javascript" src="../../assets/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../assets/director/js/common.js"></script>
    <script type="text/javascript" src="../../assets/director/js/index.js"></script>
</head>

<body>
#parse("/common/dtop.tpl")
    #parse("/common/duser.tpl")
<div class="main1">
  <div>
		<div class="contentPer">#parse("/common/dleft.tpl")</div>
		    <div class="personInfo_right fl" style="float: left;">
		     	 #if($sessionUser.cateEnum.type==4)
    #end
	#if ($specList)
		<table width="100%" border="0" cellspacing="0" cellpadding="1" class="commonTable">
			<tr>
				<th>服务名称</th>
				<th>开通时间</th>
				<th>到期时间</th>
				<th>开通状态</th>
				#if($sessionUser.cateEnum.type==3)
				<th>操作</th>
				#end
			</tr>
			#foreach ($service in $specList)
			<tr #if($sessionUser.cateEnum.type==4) onclick="serviceSet(${userId}, ${service.serviceId}, ${service.status},'${service.startTime}','${service.endTime}',$service.orderId,'$!{service.stype}')" #end>
				<td><a href="#if($service.status) /director/service/history?userId=${userId}&serviceId=${service.serviceId}&type=$service.type #end">${service.serviceName} </td>
				<td>$!date.format('yyyy-MM-dd',$!service.startTime)</td>
				<td>$!date.format('yyyy-MM-dd',$!service.endTime)</td>
				<td>
					#if($service.status==1) 
						已开通							
					#else
						未开通
					#end
				</td>
				#if($sessionUser.cateEnum.type==3)
				<td>
					#if($service.status)
						<input class="tb_edit button_kai" style="margin-left:10px;" type="button" value="续用" onclick="javascript:window.location.href='/professional/service/checkout?orderId=${service.orderId}&serviceId=${service.serviceId}&userId=${userId}'" />
						<input  class="tb_edit button_delete" type="button" value="关闭" onclick="javascript:window.location.href='/professional/service/close?orderId=${service.orderId}&serviceId=${service.serviceId}&userId=${userId}'" />
					#else
						<input class="tb_edit button_kai" style="margin-left:10px;" type="button" value="开通" onclick="javascript:window.location.href='/professional/service/checkout?serviceId=${service.serviceId}&userId=${userId}'" />
					#end
				</td>
				#end
			</tr>	
			#end
		</table>	
	#end
		      
		    </div>
	  </div>
   </div>
</body>
<script type="text/javascript" src="../../assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="../../assets/js/layer.min.js"></script>
<script type="text/javascript" src="../../assets/js/highcharts.js"></script>
<script type="text/javascript">
$(function(){
$(".personInfo .personInfo_left .sidebar li a").eq(3).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
    $("#distribution").click(function(){
    	var userid = $(this).attr("userid");
    	var that = this;
    	$.ajax({
    		type:'get',
    		url:'/professional/vender/distr/users?userId='+userid,
    		dataType:'json',
    		success:function(data){
    			console.log(data);
    			if(data.code==0){
    				var str = '';
    				str +='<table class="usertable usertableborder">';
    				str +='<tr><td></td><td>姓名</td><td>已分配人员数量</td></tr>';
    				for(var i=0;i<data.data.length;i++){
    					str +='<tr><td><input class="uradio" type="radio" name="radiouser" value="'+data.data[i].adminId+'" /></td><td>'+data.data[i].adminName+'</td><td>'+data.data[i].count+'</td></tr>';
    				}
    				str +='</table>';
    				$('.distributionList').html(str);
    				$.layer({
			            type : 1,
			            title : '分配人员',
			            offset:['20px', ''],
			            border : false,
			            shadeClose:true,
			            fadeIn: 300,
			            btns: 2,
			            move: false,
			            btn: ['保存', '取消'],
                        success: function () {$('div[class*=xubox_layer]').css({position: 'absolute', top: '20px'})},
                        move: '.xubox_title',
			            yes:function(index){
			                //console.log("保存",index);
			                var adminId = $(".uradio:checked").val();
			                var adminval = $(".uradio:checked").parent().next('td').text();
			                $(".adminName").html(adminval);

			                /*alert(adminId);
			                location.href = '/professional/vender/distr/user/commit?userId='+userid+'&adminId='+adminId;*/
			                //debugger;
			                $.ajax({
					    		type:'post',
					    		url:'/professional/vender/distr/user/commit',
					    		data:'userId='+userid+'&adminId='+adminId,
					    		dataType:'json',
					    		success:function(data){
					    			//debugger;
					    			console.log(data);
					    		}
					    	});
			                layer.close(index);
			            },
			            area : ['450px','320px'],
			            page : {dom : '.distributionList'}
			        });
    			}else{
    				console.log("失败");
    			}
    		}
    	});
        
    });
});
</script>
</html>
