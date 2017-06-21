<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>设备管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script>
	function add(page, num) {
		window.open('/professional/device/add?page=' + page + '&num=' + num, '_self');
	}
</script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usedetail clearfix">
            <div class="searchli">
				<ul class="inpubox clearfix">
				<form action="/professional/device/query" method="post" name="searchForm">
					<li><label>设备名称：</label><input class="text150" type="text" name="deviceName" value="$!{deviceName}" /></li>
					<li><label>设备厂商：</label><input class="text150" type="text" name="deviceVender" value="$!{deviceVender}"  /></li>
					<!--<li><label>设备类型：</label><input class="text150" type="text" name="deviceType" /></li>-->
					<li><input class="ibtn button_gm" type="submit" value="搜索"></li>
					<li><input class="ibtn button_gm" type="button" value="添加设备" onclick="add(${page.pageNo}, ${page.pageSize})"></li>
				</form>
				</ul>
			</div>
			#if ($page)
				<table class="table100 usertable">
					<tr>
						<th>设备名称</th>
						<th>设备厂商</th>
						<th>设备编号</th>
						<th>使用说明</th>
						<th>功能说明</th>
						<th>价格</th>
						<th style="width:160px;">编辑</th>
						<th style="width:160px;">删除</th>
					</tr>
					#foreach ($device in $page.result)
					<tr>
						<td>${device.name}</td>
						<td>${device.vender}</td>
						<td>${device.number}</td>
						<td>${device.useDesc}</td>
						<td>${device.functionDesc}</td>
						<td>#set($p = $device.price/100) $p元</td>
						<td style="height:60px;">
							<a href="/professional/device/modify?page=${page.pageNo}&num=${page.pageSize}&id=${device.id}">编辑>></a>						
						</td>
						<td style="height:60px;">
							<a href="/professional/device/delete?page=${page.pageNo}&num=${page.pageSize}&id=${device.id}">删除>></a>						
						</td>
					</tr>	
					#end
				</table>
				#parse("/common/page.tpl")		
			#end
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
<script type="text/javascript" src="js/layer.min.js"></script>
<script type="text/javascript" src="js/lhgcalendar.min.js"></script>
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