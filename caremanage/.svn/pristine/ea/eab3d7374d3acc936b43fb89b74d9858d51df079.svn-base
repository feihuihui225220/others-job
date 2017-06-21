<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>填写用户信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="/assets/css//bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/assets/icare/css/common.css">
    <link rel="stylesheet" type="text/css" href="/assets/icare/css/a.css">
    <style>
    i{font-style:normal;}
    .form-control{border:none;}
    .col-xs-3,.col-xs-9{padding-right:0;}
    input,button{margin:0;padding:0;}
    .notnull{color:red;font-size:12px;}
    .serviceTime{font-size:12px;}
    .ownBtn1{margin-top:50px;}
    .textinput{width:50px;}
    #price,#day{color: red;}
    </style>
</head>
<body>
<form action="../modify" method="get" class="container" id="newOrder">
<ul class="list-group">
	<li class="list-group-item row">
        <!--姓名只能输入中/英文-->
        <!--maxlength限制输入不能超过10个字符-->
      <div class="col-xs-2 text-left">姓名</div>
      <div class="col-xs-4">$!order.name</div>
 		<div class="col-xs-2 text-left">联系方式</div>
   		 <div class="col-xs-4">$!order.phone</div>
   	</li>
    <li class="list-group-item row">
      <!--服务需求不超过80位-->
    <div class="col-xs-3 text-left">服务需求</div>
    <div class="col-xs-9">
    	$!order.serviceRequest
    </div>
  	</li>
  <li class="list-group-item row">
    <div class="col-xs-3 text-left">开通日期 <span class="notnull">*</span></div>
      <!--居住地址不超过50位-->
    <div class="col-xs-9">
    #if($order.days==0)
<input class="form-control" id="visitTime" type="text" 
			name="openingDate"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'new Date()'})" autocomplete="off">
	#end
	#if($order.days >= 1)
<input class="form-control" id="visitTime" disabled="disabled" type="text" value="$date.format('yyyy-MM-dd',$order.openingDate)"
			name="openingDate"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'new Date()'})" autocomplete="off">
	#end
</div>
  </li>  
 <li class="list-group-item row">
    <div class="col-xs-3 text-left">有效时间</div>
    <div class="col-xs-9">
      <a class="btn btn-default minus btn-sm"  role="button" style="margin-left:12px;">-</a>
      <input class="btn btn-default textinput btn-sm"  type="text" id="monthNum" name="monthNum" value="1">
      <a class="btn btn-default plus btn-sm"  role="button">+</a>
      <span>月</span>
    </div>
    <div class="clearfix" style="padding-top:40px;padding-bottom:5px;">
      <div class="col-xs-3 text-left">应付金额</div>
      <div class="col-xs-9" style="padding-left:27px;" ><span id="price">$price</span>元</div>
    </div> 
    <div style="padding-left:15px;">
      <span class="notnull">*</span>
      <span class="serviceTime">服务有效期至<i class="year"></i>年<i class="month"></i>月<i class="day"></i>日,自付款当日起，有效天数为<span id="day">30</span>天</span>
    </div>
  </li>
</ul>
<input type="hidden" name="id" value="$id">
<input type="hidden" name="days" value="" id="days">
<input type="button" class="ownBtn1" value="提交" onclick="addOrder();" >
</form>
<script type="text/javascript" Charset="UTF-8" src="/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" Charset="UTF-8" src="/assets/icare/js/order.js"></script>
<script type="text/javascript" src="/assets/js/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript">
function addOrder(){
	   var visitTime = $("#visitTime").val();
	   if (visitTime == null || visitTime =="") {
		alert("开始日期不能为空！");
		return false;
	   }
	    $("#newOrder").submit();
 	};
</script>
</body>
</html>