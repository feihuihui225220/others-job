<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Care Manager_服务商管理</title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usedetail clearfix">
            <div class="searchli">
				<ul class="inpubox clearfix">
					<li><label>服务商类别：</label>
					<select class="select160" name="" id="" onchange="window.location.href=this.options[selectedIndex].value">
					<option value="/professional/vender/list">专业服务</option>
					<option value="/care/careManager/list">关爱与便利性服务</option>
					</select></li>
					<li><label>名称：</label><input class="text150" type="text" /></li>
					<li><input class="ibtn button_btn" type="button" value="搜索"></li>
					<li><input class="ibtn button_btn" type="button" value="添加服务商"></li>
				</ul>
			</div>
			<table class="table100 usertable cen">
                <tr><th>服务商名称</th><th>管理员</th><th>联系电话</th><th>联系地址</th><th>服务商类型</th><th>服务分类</th><th>简介</th><th>准入资质</th></tr>
                #foreach ($result in $vendorList)  
                <tr>
	                <td>${result.name}</td>
	                <td>${result.adminName}</td>
	                <td>13800138000</td>
	                <td>XXX</td>
	                <td>健康服务</td>
	                <td>心率检测</td>
	                <td>XXX</td>
	                <td>XXX</td>
                </tr>
                #end
            </table>
        </div>
    </div>
    <div class="footer"></div>
</div>
<div class="limitbox pad10 hide">
    <ul class="inpubox clearfix">
        <li><label>角色名称：</label><input class="text150" type="text" /></li>
        <li><label>描述：</label><textarea name="" id="" cols="30" rows="6"></textarea></li>
    </ul>
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".addulimit").click(function(){
        $.layer({
            type : 1,
            title : '添加角色',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                layer.close(index);
            },
            area : ['450px','270px'],
            page : {dom : '.limitbox'}
        });
    });
    $(".editulimit").click(function(){
        var limitid = $(this).attr("limitid");
        //console.log('编辑id'+limitid);
        $.layer({
            type : 1,
            title : '编辑角色',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                layer.close(index);
            },
            area : ['450px','270px'],
            page : {dom : '.limitbox'}
        });
    });
    $(".delulimit").click(function(){
        var limitid = $(this).attr("limitid");
        layer.confirm('是否确定删除该角色?', function(index){
            $('.limitid_'+limitid).remove();
            layer.close(index);
        }, function(index){
            //console.log(index);
        });
    });
	$(".timedate").calendar({ format:'yyyy-MM-dd' });
});
</script>
</body>
</html>