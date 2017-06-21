<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>投诉管理</title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">

		#set ($sessionUser=$!{session.getAttribute("sessionUser")})
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usedetail clearfix">
            <div class="searchli">
				<ul class="inpubox clearfix">
				    <form method="get" action="/care/complaint/searchComplaintBykey"  name="searchForm">
				    #set($user=$session.getAttribute("sessionUser"))
				   <!-- <input   class="timedate" type="hidden" name="createBy" value="${user.name}"/>  -->
					<li><label>姓名：</label>
					<input class="text150" type="text" name="name" value="#if($searchKey.name)${searchKey.name}#end"/>
					</li>
					<li><label>身份证号：</label>
					<input class="text150" type="text"  name="idCart" value="#if($searchKey.idCart)${searchKey.idCart}#end"/>
					</li>
					<li><label>订单号：</label>
					<input class="text150" type="text" name="orderId" value="#if($searchKey.orderId)${searchKey.orderId}#end"/>
					</li>
					<li><label>状态：</label>
					<select class="select160" name="status" id="">
					<option value="-1" #if($seachKey.status==-1)selected#end>全部</option>
					<option value="0" #if($seachKey.status==0)selected#end>新投诉</option>
					<option value="1" #if($seachKey.status==1)selected#end>已处理</option>
					<option value="2" #if($seachKey.status==2)selected#end>已回访</option>
					</select>
					</li>
					<li><label>投诉时间：</label>
					<input class="text150 timedate" type="text" name="starDate" value="#if($searchKey.starDate)${searchKey.starDate}#end"/> 
					至 
					<input class="text150 timedate" type="text" name="endDate" value="#if($searchKey.endDate)${searchKey.endDate}#end"/></li>
					<li><input class="ibtn button_gm" type="submit" value="搜索"></form></li>
					#if($!{sessionUser.getCateEnum()}!="STREET")
					<li>
					<input type="button" class="ibtn button_gm" onclick="javascripts:location.href='/care/complaint/goToAdd' " value="添加投诉" />
					 </li>
					#end
					
				</ul>
			</div>
			<table class="table100 usertable cen">
                <tr><th>姓名</th><th>身份证号</th><th>联系方式</th><th>订单号</th><th>服务类型</th><th>投诉时间</th><th>状态</th><th>操作</th></tr>
                 #foreach ($result in $page.result) 
                <tr><td>${result.rUser.name}</td>
                <td>${result.rUser.idCardNo}</td>
                <td>${result.rUser.mobilePhone}</td>
                <td>${result.cOrder.id}</td>
                <td>关爱服务</td>
                <td>$!date.format('yyyy-MM-dd HH:mm',$!{result.createdAt})</td>
                <td>#if($result.status==0) 新投诉  #elseif ($result.status==1) 已处理 #else 已回访  #end</td>
                <td>
                #if($!{sessionUser.getCateEnum()}!="STREET")
                <button class="tb_edit" onclick="javascripts:location.href='/care/complaint/details?id=${result.id}'">#if($result.status==0) 处理  #elseif ($result.status==1) 回访 #else 查看  #end</button>
                #else
                <button class="tb_edit" onclick="javascripts:location.href='/care/complaint/details?id=${result.id}'">查看</button>
                #end
                </td>
                </tr>
                 #end
            </table>
            #parse("/common/page.tpl")
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