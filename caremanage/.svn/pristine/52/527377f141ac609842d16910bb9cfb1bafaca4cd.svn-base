<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/home.css" />
<link rel="stylesheet" href="/assets/css/reg.css" />
<script>
	function serviceSet(userId, serviceId, status, start, end, orderId,stype){
	    if(status == 1){
		   var x = parent.document.getElementById('userFrame');
		  //x.src = "/professional/service/user/set?userId=" + userId + "&serviceId=" + serviceId + "&start=" + start + "&end="+ end + "&orderId="+ orderId+"&stype="+stype;
	    }
	}
</script>
<style>
.distributionList{padding-left:80px;margin-top:20px;height:200px;overflow:auto;width:100%;}
.uradio{margin:0 10px;}
.distributionList{text-align: center;}
.usertableborder{border:1px solid #f00;}
.usertableborder td,.usertableborder th{border:1px solid #555;padding:5px 10px;}
</style>
<style>
.tC{padding:10px;border:1px solid #ddd;	overflow:hidden;width:300px; z-index:9999;background:white;margin:0 auto;margin-top:20%;}
.t_left{float:left;	font-size:16px;	}
.t_left:nth-child(1){margin-right:10px;width:33%;}
.t_left:nth-child(2){width:60%;}
.t_left>label{display:block;text-align:right;height:25px;
			line-height:25px;margin-bottom:5px;	}
.t_left>input{display:block;text-align:left;height:20px;line-height:20px;
			margin-bottom:5px;	width:100%;	}
.anNiu{	clear:both;text-align:center;padding-top:10px;}
.anNiu>input{
    font-size: 12px;
    background: #4CEDF7;
    width: 75px;
    height: 25px;
    border: 0px;
    color: #EBF8FB;}
 .anNiu>.button_deletes{
    font-size: 12px;
    background: #7A9292;
    width: 75px;
    height: 25px;
    border: 0px;
    color: #EBF8FB;
}
	</style>
</head>
<body>
 <div class="">
        <div class="bodyposition">
            <div id="mainDiv">
                <div id="rightIframe" class="rightIframe">
                    <div class="bodyline ">
	<br/><br/>
    #if($sessionUser.cateEnum.type==4)
    #end
	#if ($specList)
		<table class="table100 usertable cen trclick">
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
				<td class="chakan" data-href="#if($service.status)/professional/service/history?userId=${userId}&serviceId=${service.serviceId}&type=$service.type #end">${service.serviceName} </td>
				<td class="chakan" data-href="#if($service.status)/professional/service/history?userId=${userId}&serviceId=${service.serviceId}&type=$service.type #end">$!date.format('yyyy-MM-dd',$!service.startTime)</td>
				<td class="chakan" data-href="#if($service.status)/professional/service/history?userId=${userId}&serviceId=${service.serviceId}&type=$service.type #end">$!date.format('yyyy-MM-dd',$!service.endTime)</td>
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
						<input class="tb_edit button_kai" style="margin-left:10px;" type="button" value="续用" onclick="javascript:window.location.href='/professional/service/checkout?orderId=${service.orderId}&serviceId=${service.serviceId}&userId=${userId}&type=$service.type'" />
						<input  class="tb_edit button_delete" type="button" value="关闭" onclick="javascript:window.location.href='/professional/service/close?orderId=${service.orderId}&serviceId=${service.serviceId}&userId=${userId}&type=$service.type'" />
					#else
						<input class="tb_edit button_kai open" style="margin-left:10px;" type="button" value="开通" serviceId="${service.serviceId}"  serviceType="$service.type" />
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
           
        </div>
    </div>
	

<!--  onclick="javascript:window.location.href='/professional/service/checkout?serviceId=${service.serviceId}&userId=${userId}'" -->
<div class="distributionList"></div>
<!-- 弹窗 -->

<div id="mask_zz" style="position:fixed;background:rgba(0,0,0,0.5);width:100%;height:100%;top:0;display:none;">
	 	<form action="/rContact/saveRContacts" method="post">
<!-- userId -->
<input type="hidden" id="userId" name="id" value="${userId}" />
<input type="hidden" id="serviceId" name="serviceId" />

	 	<div class="tC">
			<div class="t_left addLeft">
				<label>用户姓名:</label>
				<label>绑定电话:</label>
				<label>紧急联系人1:</label>
				<label>紧急电话1:</label>
				
			</div>
			<div class="t_left addRight">
				<label id="user_id" style="float:left;text-align:left;"></label><label class="adds" style="color:red;">+</label>
				<input type="text" id="phone" name="phone" placeholder="请输入11位电话号码" pattern="\d{11}" />
				<input type="text" id="r_name" name="name" onKeypress="javascript:if(event.keyCode==32)event.returnValue=false;" />
				<input type="text" id="phone1" name="sphone" placeholder="请输入11位电话号码" pattern="\d{11}" />
				<input type="hidden" id="uname" name="urgentName" />
				<input type="hidden" id="uphone" name="urgentPhone" />
			</div>
			<div class="anNiu">
				<input type="submit" id="submit" style="margin-right:30px;" value="确定">
				<input type="reset" class="button_deletes" id="qX" value="取消">
			</div>
		</div></form>
</div>
		
<script src="$request.contextPath/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script src="/assets/js/highcharts.js"></script>
<script src="/assets/js/highcharts-more.src.js"></script>
<script>
 
var jishu={
	jishu:1
}
$(document).ready(function(){ 
	//do something 
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
    			};
    		}
    	});
        
    });
    //开通服务验证
    $(".open").click(function(){
    jishu.jishu=2;
    	//根据id查询该用户是否又紧急联系人
    	var userId=$("#userId").val();
    	var serviceId=$(this).attr("serviceId");
    	var serviceType=$(this).attr("serviceType");
    	if(userId!=""){
    		  $.ajax({
				type:'post',
				url:'/rContact/rContactsById',
				data:'id='+userId,
				success:function(result){
					//debugger;
					console.log(result);
					if(result.trim()=="OK"){
						window.location.href="/professional/service/checkout?serviceId="+serviceId+"&userId="+userId+"&type="+serviceType;
					}else{
						$("#mask_zz").show();	
						$("#user_id").html(result.trim());
						$("#serviceId").val(serviceId);
						
					};
				}});
    	}else{
    		alert("该用户ID为空！");
    	};
    });
    //提交验证
     $("#submit").click(function(){
     			/*var phone=$("#phone").val();
				var phone1=$("#phone1").val();
				var name=$("#r_name").val();
				yzName(name);
				yzPhone(phone);
				yzPhone(phone1);*/
				var arr = new Array();
				var size = $("input[name='name']").length;
				for(var i =0;i<size;i++){
					var urgentName = $("input[name='name']").get(i).value;
					arr.push(urgentName);
				}
				var arrPhone = new Array();
				var sizePhone = $("input[name='sphone']").length;
				for(var j =0; j<sizePhone;j++){
					var urgentPhone = $("input[name='sphone']").get(j).value;
					arrPhone.push(urgentPhone);
				}
				$("#uname").val(arr);
				$("#uphone").val(arrPhone);
			}); 
	 //取消
	$("#qX").click(function(){
		$("#mask_zz").hide();	
	});
	
	
});

$('.chakan').click(function(){
		var href=$(this).attr("data-href")
		location.href=href;
	});
	//添加多的紧急联系人
	$(".adds").click(function(){
		if(!(jishu.jishu>3)){
			$(".addLeft").append('<label>紧急联系人'+jishu.jishu+':</label>');
			$(".addLeft").append('<label>紧急电话'+jishu.jishu+':</label>');
			$(".addRight").append('<input type="text" id="r_name'+jishu.jishu+'" name="name" onKeypress="javascript:if(event.keyCode==32)event.returnValue=false;" />');
			$(".addRight").append('<input type="text" id="phone'+jishu.jishu+'" name="sphone" placeholder="请输入11位电话号码"/>');
		}
		jishu.jishu++;
	});
	//验证手机号
	function yzPhone(phone){
		var pattern ="/^1[34578]\d{9}$/";
		var isPhone="/^((0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/";
		if(Phone==""){
			alert("紧急电话不能为空！");
			return false;
		}
		if(!pattern.test(phone)||!isPhone.test(phone)){
			alert("电话号码格式不对！");
			return false;
		}
	}
	function yzName(name){
		if(name==""){
			alert("紧急联系人不能为空！");
			return false;
		}
		var pattern2 = /^[\u4e00-\u9fa5]+$/;
		if(!pattern2.test(name)){
			alert("名称必须为中文且不能有空格和特殊符号！");
			return false;
		}	
	}
</script>
</body>
</html>