<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>量表查询</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/newCss/index.css" />
    <link rel="stylesheet" href="/assets/newCss/wenjuan.css"/>
</head>
<style>
#pview textarea{
    border:0;  
    background-color:transparent;  
    color: #666464;  
    height: auto;  
    resize:none;
    font-size:28px;
}
#pview{
	font-size:28px;
}
#pview input{
    width: 20px;
    height: 20px;
    margin-top: 13px;
}
#print{
	text-align:center;
	cursor:pointer;
}
#yl{
cursor:pointer;
	text-align:center;
}
#fanhui{
cursor:pointer;
	text-align:center;
}
</style>
<body>
<div class="wrapper">
        #parse("/common/head.tpl")
        <div class="main">
            #parse("/common/providers.tpl")
            <div id="right" > 
            <input type="submit" name="back" class="fanhui button_fh" onclick="javascript:history.back(-1);" value="返回"/>
            <input id="yl" class=" button_fh" value="预览"/>
                $nVolunteerAssess.detail
            </div>  
        </div>
          
</div> 
<div id="pview" style="padding:30px;padding-top:0px;display:none;position: absolute;top:0px;left:0px;width:1000px;height:100%;z-index=9999;">
	<div id="print" class=" button_fh">打印</div>
	<div id="fanhui" class=" button_fh">返回</div>
	<div style="text-align:center;font-size:30px;">$!activity服务记录</div>
	<div style="text-align:right;font-size:24px;">活动日期:$!date</div>
	$nVolunteerAssess.detail
</div>
</body>
 <script src="/assets/js/jquery-2.1.4.min.js"></script>
<script>
$("#print").click(function(){
	$("#print").hide();
	$("#fanhui").hide();
	window.print();
	$("#print").show();
	$("#fanhui").show();
});
$("#fanhui").click(function(){
	$("#pview").hide();
	$(".wrapper").show();
});
$("#yl").click(function(){
$("#pview>textarea").attr("rows","10");
	$(".wrapper").hide();
	$("#pview").show();
	var duixiangzu=$("#pview>.radio>label>input[type='checkbox']");
	
	for(var i=0;i<duixiangzu.length;i++){
		duixiangzu.eq(i).css("display","none");
		if(!duixiangzu.eq(i).is(":checked")){
			duixiangzu.eq(i).parents("label").css("display","none");
		}
	}
});
$(window).on('load', function() {
    $('.btn-default1').remove();
    $('.btn-default2').remove();
    $('.btn-primary1').remove();
});
</script>
</html>