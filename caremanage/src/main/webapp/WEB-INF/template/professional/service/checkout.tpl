<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<style>
.inpubox li {width:290px;}
.mask_contact {padding-top:20px;}
.mask_contact table {width:72%;margin-left:112px;}
.mask_contact table a {color:#333;}
.mask_contact .inpubox li.w520 {width:640px;}
.col2 {width:6em;}
.fix_car {padding-left:112px;margin-bottom:15px;}
.table100 select, .table100 input {margin:0;}
.sum {margin-bottom:5px;}
.sum b {color:red;margin-right:5px;}
.tip {color:#666;}
.pianyi{position:relative;left:-33px; }
</style>
</head>
<body>

<div class="wrapper">
    <form id="oForm" method="post" action="/professional/service/open" class="reg_area fix_pop" style="width:960px">
        	<input type="hidden"  name="type" value="$type" />
        	<input type="hidden"  name="serviceId" value="${checkout.serviceId}" />
        	<input type="hidden" id="price"  name="price"  />
		<input type="hidden" name="userId" value="${checkout.userId}" />
		#if($checkout.orderId)<input type="hidden" name="orderId" value="${checkout.orderId}" />#end
        <h2>#if($checkout.orderId)续用服务#else开通服务#end</h2>
        <div class="mask_contact pad10">
            <ul class=" clearfix">
                <li><label>服务名称&nbsp;：</label>${checkout.serviceName}</li>
      <!-- ========================================暂时未定=========================================== -->          
                <li><label>服务费用&nbsp;：</label><span class="per">${checkout.price}元/天</span></li>
                <li><label> &nbsp;申 &nbsp;请  人：</label>${checkout.userName}</li>
                <li><label>身份证号&nbsp;：</label>${checkout.idCard}</li>
                <li class="w520">
                	<label>开通时间&nbsp;：</label>
                		#if($checkout.orderId)
                			<input type="text" name="dateCond.start" value="$!date.format('yyyy-MM-dd',$!checkout.dateCond.start)" readOnly="true"/><font color="red">*必填项</font>
                		#else
                			<input class="timedate" name="dateCond.start"/><font color="red">*</font>
                		#end
                		&emsp;&emsp;
                		　到期时间：<input class="timedate" name="dateCond.end" value="$!date.format('yyyy-MM-dd',$!checkout.dateCond.end)"/><font color="red">*必填项</font>
                </li>
                <li class="w520"><label>选择设备&nbsp;：</label>
                <table class="table100 usertable pianyi">
					<tr>
						<td>设备类型</td>
						<td>设备名称</td>
						<td>设备ID</td>
					</tr>
					#foreach($deviceGroup in $checkout.deviceGroups)
						<tr>
							<td>${deviceGroup.deviceType.name}</td>
							<td>
							    <input type="hidden" name="deviceParam[$!{velocityCount}].metaServiceId" value="${deviceGroup.metaServiceId}" />
							    <input type="hidden" name="deviceParam[$!{velocityCount}].deviceTypeId" value="${deviceGroup.deviceType.id}" />
							    <input type="hidden" name="deviceParam[$!{velocityCount}].deviceTypeName" value="${deviceGroup.deviceType.name}" />
								<select name="deviceParam[$!{velocityCount}].deviceId">
									#if($checkout.orderId)
										#foreach($device in $deviceGroup.devices)
										    #set($pay = ${device.price}/100)
										    #foreach($deviceParam in $checkout.deviceParam)
												#if($deviceParam.deviceId == $device.id)
										    		<option value="${device.id}" money="$pay">${device.name}&nbsp;&nbsp;&nbsp;$pay元</option>
												#end
											#end
										#end
									#else
										#foreach($device in $deviceGroup.devices)
										    #set($pay = ${device.price}/100)
											<option value="${device.id}" money="$pay">${device.name}&nbsp;&nbsp;&nbsp;$pay元</option>
										#end
									#end
								</select>
							</td>
							<td>
								<input type="text" placeholder="请输入设备ID" name="deviceParam[$!{velocityCount}].deviceBindId"  value="$!checkout.deviceParam[$!{velocityCount}].deviceBindId" #if($checkout.orderId)readOnly="true"#end  maxlength="60"/><font color="red">*必填项</font>
							</td>		
						</tr>
					#end
				</table>
                </li>
            </ul>
            <p class="sum">合计费用：<b>0.00</b>元</p>
            <span class="tip">计算方式：服务单价/日 * 订购天数 </span>
        </div>
        <p class="opt"><button type="button" class="btn button_delete" onclick="javascript:history.go(-1)">取 消</a><button type="button" class="btn button_add" onclick="openService()">#if($checkout.orderId)续 用#else开 通#end</button></p>
    </form>
    <div class="footer">
        
    </div>
</div>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script>

var type = 0;
if('$!{checkout.orderId}' != ''){
	type = 1;
}

var etime = $('.timedate:eq(0)').val();

$('.timedate').calendar({ format:'yyyy-MM-dd', zIndex:222222222});
function maxDay(month){
    var d= new Date();
    return new Date(d.getFullYear(), month,0).getDate();
}

setInterval(function () {
if(type == 0) {
	if ($('.timedate:eq(0)').val() && $('.timedate:eq(1)').val()) {
        var arr1 = $('.timedate:eq(0)').val().split('-');
        var arr2 = $('.timedate:eq(1)').val().split('-');
        var long = new Date($('.timedate:eq(1)').val()) - new Date($('.timedate:eq(0)').val());
        //console.log($('.timedate:eq(0)').val());
        if (Math.ceil((long/3600/24/1000)) >= 0) {
            var m = Math.ceil((long/3600/24/1000));
            m+=1;
            var sumopt = 0;
            $('table select').each(function () {
                if (!isNaN($(this).find('option:selected').attr("money"))) {
                    sumopt+=parseInt($(this).find('option:selected').attr("money"));
                }
            });
            $('.sum b').html((m*(parseInt($('.per').html()))).toFixed(2));
            $('#price').val(m*parseInt($('.per').html()));
        }
    }
}else if(type == 1) {
        var long = new Date($('.timedate:eq(0)').val()) - new Date(etime);
       	 var m =0;
        if (Math.ceil((long/3600/24/1000)) >= 0) {
             m = Math.ceil((long/3600/24/1000));
            m+=1;
            $('.sum b').html((m*(parseInt($('.per').html()))).toFixed(2));
        }	
}    
}, 100);

function openService() {
	var start = new Date($('.timedate:eq(0)').val());
	var end = new Date($('.timedate:eq(1)').val());
	var cur = new Date();
	cur.setHours(0);
	cur.setMinutes(0);
	cur.setSeconds(0);
	if(type == 0) {
		if(start > end || start < cur || end < cur) {
			alert("开始时间必须小于结束时间 且 开始时间不能小于当前时间！");
			return false;
		}
	}else if(type == 1) {
		var orginDate = new Date(etime);
		var newDate = new Date($('.timedate:eq(0)').val());
		if(newDate <= orginDate) {
			alert("续用的结束时间必须大于之前订购的结束时间！");
			return false;		
		}
	}
	
	document.getElementById("oForm").submit();
}
</script>
</body>
</html>