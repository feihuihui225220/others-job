<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>老年人前端_我的订单</title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/common.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    <div class="body">
        <div class="usermessbox bodyline pad10 mgb10 clearfix">
            <div class="searchli">
						<ul class="inpubox clearfix">
						<form method="post" action="/care/order/searchOrderlist"  name="searchForm" class="reg_area fix_pop" style="width:900px">
							 #set($user=$session.getAttribute("sessionUser"))
							 <input type="hidden" name="userId" value="$!{userId}"/>
							 #if($user.cateEnum.type==6||$user.cateEnum.type==3)
							   <input type="hidden" name="communityId" value="$!{user.communityId}"/>
							 #end
							<li><label>下单时间：</label><input class="text150 timedate" type="text" name="startDate" value="$!date.format('yyyy-MM-dd',$!{seachKey.startDate})"/> 至 <input class="text150 timedate" type="text" name="endDate" value="$!date.format('yyyy-MM-dd',$!{seachKey.endDate})"/></li>
							<li><span class="ssspan"><input class="ibtn button_btn" type="submit" value="搜索"><span></li>
						</form>	
						</ul>
					</div>
					<table class="table100 usertable cen trclick tb table_col6 mgb10 pointer">
                    <tr><th>订单编号</th><th>订单内容</th><th>服务提供商</th><th>下单时间</th><th>响应时间</th><th>服务时间</th><th>完成时间</th><th>订单状态</th></tr>
                 #foreach ($result in $page.result)
	                <tr>
	                <td>${result.id}</td>
	                <td>#foreach ($item in $result.cOrderItem) $item.name #end</td>
	                <td>${result.cVendor.name}</td>
	                <td>$!date.format('yyyy-MM-dd HH:mm',$!{result.createdAt})</td>
	                <td>$!date.format('yyyy-MM-dd HH:mm',$!{result.responseTime})</td>
	                <td>$!date.format('yyyy-MM-dd HH:mm',$!{result.serviceTime})</td>
	                <td>$!date.format('yyyy-MM-dd HH:mm',$!{result.responseTime}) </td>
	                <td>#if($result.orderStatus==1)新订单  #elseif($result.orderStatus==2)已响应 #elseif($result.orderStatus==3||$result.orderStatus==4)已完成 #elseif($result.orderStatus==5)已回访#end 
	                <input type="hidden"  value="/care/order/details?orderId=${result.id}&type=2&auserId=$!{userId}"/>
	                </td>
	                </tr>
                #end
                    </table>
                    #parse("/common/page.tpl")
        </div>
    </div>
    <div class="footer"></div>
</div>
<div class="mask_contact pad10 hide">
    <ul class="inpubox clearfix">
        <li><label>姓名：</label><input class="text150" type="text" /></li>
        <li><label>身份证号：</label><input class="text150" type="text" /></li>
        <li><label>性别：</label><select class="select160" name="" id=""><option value="0">全部</option><option value="0">全部</option></select></li>
        <li><label>出生日期：</label><input class="text150 timedate" type="text" /></li>
        <li><label>手机：</label><input class="text150" type="text" /></li>
        <li><label>与用户关系：</label><input class="text150" type="text" /></li>
        <li class="w520"><label>居住地址：</label><input class="text150" type="text" /></li>
    </ul>
    <!--div class="centerbtn pad10"><button class="button_btn" type="submit">保存</button><button class="pad5 contact_closed">取消</button></div-->
</div>
<div class="mask_evidence pad10 hide">
    <ul class="inpubox clearfix">
        <li><label>材料类型：</label><select class="select160" name="" id=""><option value="0">全部</option><option value="0">全部</option></select></li>
        <div><button id="addfile">增加附件</button></div>
        <div class="iptdiv"><input type="file" name="file[]" class="ipt" /><a href="#" name="rmlink"> X </a></div>
    </ul>
    <!--div class="centerbtn pad10"><button class="button_btn" type="submit">保存</button><button class="pad5 contact_closed">取消</button></div-->
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".clourstitle li").click(function(){
        var index = $(this).attr('index');
        $(this).addClass('on').siblings().removeClass('on');
        $(".actboxlist .actbox"+index).show().siblings().hide();
    });
    $('.addContact').on('click', function(){
        $.layer({
            type : 1,
            title : '添加联系人信息',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            zIndex:99,
            btns: 2,
            success:function(){
                $(".timedate").calendar({ format:'yyyy-MM-dd' });
            },
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                layer.close(index);
            },
            area : ['603px','355px'],
            page : {dom : '.mask_contact'}
        });
    });
    $('.addEvidence').on('click', function(){
        $.layer({
            type : 1,
            title : '添加证据信息',
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
            area : ['603px','auto'],
            page : {dom : '.mask_evidence'}
        });
    });
    $('.editEvidence').on('click', function(){
        var evdeid = $(this).attr("evdeid");
        //console.log('编辑id'+evdeid);
        $.layer({
            type : 1,
            title : '编辑证据信息',
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
            area : ['603px','auto'],
            page : {dom : '.mask_evidence'}
        });
    });
    $(".delEvidence").click(function(){
        var evdeid = $(this).attr("evdeid");
        layer.confirm('是否确定删除该证据信息?', function(index){
            $('.evdeid_'+evdeid).remove();
            layer.close(index);
        }, function(index){
            //console.log(index);
        });
    });
    /*$(".contact_closed").on('click',function(){
        layer.close(layer.index);
    });*/
    // 用来绑定事件(使用unbind避免重复绑定)
    function bindListener(){
         $("a[name=rmlink]").unbind().click(function(){
             $(this).parent().remove(); 
             $(".xubox_main").height($(".xubox_main").height()-21);
         })
    }
    $("#addfile").click(function(){
        addfile();
    });
    function addfile(){ 
       $(".mask_evidence .inpubox").append('<div class="iptdiv"><input type="file" name="img[]" class="ipt" /><a href="#" name="rmlink"> X </a></div>');

    // 为新元素节点添加事件侦听器
       bindListener();
       $(".xubox_main").height($(".xubox_main").height()+21);
    } 
    $(".timedate").calendar({ format:'yyyy-MM-dd' });
});
</script>
</body>
</html>