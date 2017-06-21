<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>

</head>
<style>
/*.admin_cate_opt .btn{width:100px;}*/
.l4{width:49%;}
.r6{width:50%;}
</style>
<body>

<div class="wrapper">
   #parse("/common/head.tpl")
    <div class="body">
        <div class="useractbox bodyline pad10">
            <ul class="clourstitle strong mgb10">
               <li index="1" class="rel" onclick='location.href="findCategoryItem"'>字典管理</li>
               <li index="2" class="rel" onclick='location.href="findStatueCategory?parentId=1"'>状态管理</li>
               <li index="3" class="rel  on" onclick='location.href="findPlanCategory?parentId=1"'>计划管理</li>
             <li index="4" class="rel" onclick='location.href="findCategoryRounds?parentId=1"'>巡诊管理</li>
            </ul>
            <div class="actboxlist">
               
                <div class="actbox2">
                    <div class="l4">
                        <div class="admin_cate_opt clearfix">
                            <button class="btn button_add">添 加</button>计划分类
                            
                        </div>
                        <table class="tb table_col2 tab_115" trclick>
                            <col class="col1"/><col class="col2"/>
                            <tr>
                                <th>计划分类</th>
                                <th>操作</th>
                            </tr>
                            #if($planCategory)
                            	#foreach($sc in $planCategory)
                            <tr>
                                <td ><a href="findPlanCategory?parentId=$!{sc.id}" target="_self">$!{sc.name}</a>
                               
                                </td>                   
                                <td cateId="$!{sc.id}"><span class="tb_edit button_gm">编 辑</span>                              
                                <!--<span class="tb_remove">删 除</span>-->
                                </td>
                            </tr>
                           	 #end
                            #end 
                        </table>
                    </div>
                    <div class="r6">
                        <div class="admin_cate_opt">
                            计划内容
                            <button class="btn button_add">添 加</button>
                        </div>
                        <table class="tb table_col2 tab_115">
                            <col class="col1"/><col class="col2"/>
                            <tr>
                                <th>描述分类</th>
                                <th>操作</th>
                            </tr>
                            #if($planCategoryValue)
                            	#foreach($scv in $planCategoryValue)
                            <tr>         
                                <td>$!{scv.name}</td> 
                                <td _id="${scv.id}"><span class="tb_edit button_gm" >编 辑</span>
                                 <!--<span class="tb_remove">删 除</span>-->
                                 #end
                            #end
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <div class="footer"></div>
</div>

<form action="addPlanType" method="post" name="statueType" id="statueType">
<div class="limitbox2 pad10 hide" style="height:90px;">
    <ul class="inpubox clearfix">
    #set ($sessionUser=$!{session.getAttribute("sessionUser")})
        <li><label>分类名称：</label><input class="text150" type="text" name="name"  id="name" /></li>
        <input type="hidden" name="parentId" id="parentId" value="${parentId}"/>
         <input type="hidden" name="createdBy" id="createdBy" value="$!{sessionUser.getName()}"/>
        <input type="hidden" name="changedBy" id="changedBy" value="$!{sessionUser.getName()}"/>
    </ul>
</div>
</form>

<form action="editPlanCategoryById" method="post" name="editType" id="editType">
<div class="limitbox3 pad10 hide">
    <ul class="inpubox clearfix">
    
    #set ($sessionUser=$!{session.getAttribute("sessionUser")})
        <li class="catename1"><label>分类名称：</label><input class="text150" type="text" name="name"  id="cateName"  /></li>
        <input type="hidden" name="id" id="cateId"  />
        <input type="hidden" name="parentId" id="parentId" value="0" />
        <input type="hidden" name="createdBy" id="createdBy" value="$!{sessionUser.getName()}"/>
        <input type="hidden" name="changedBy" id="changedBy" value="$!{sessionUser.getName()}"/>
    </ul>
</div>
</form>

<form action="editPlanCategoryById" method="post" name="editTypeValue" id="editTypeValue">
<div class="limitbox4 pad10 hide">
    <ul class="inpubox clearfix">
    
    #set ($sessionUser=$!{session.getAttribute("sessionUser")})
        <li class="catename2"><label>分类名称：</label><input class="text150" type="text" name="name"  id="nameValue" /></li>
        <input type="hidden" name="id" id="selfid"  />
        <input type="hidden" name="parentId" id="parentId" value="$!{parentId}" />
        <input type="hidden" name="changedBy" id="changedBy" value="$!{sessionUser.getName()}"/>
        <input type="hidden" name="createdBy" id="createdBy" value="$!{sessionUser.getName()}"/>
    </ul>
</div>
</form>

<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".clourstitle li").click(function(){
        var index = $(this).attr('index');
        $(this).addClass('on').siblings().removeClass('on');
        $(".actboxlist .actbox"+index).show().siblings().hide();
    });
	
    $('.actbox2 .btn:eq(0)').click(function () {
	   $("#parentId").val(0);
	   
        $.layer({
            type : 1,
            title : '添加分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
            	var name = $("#name").val(); 
				if(name==""||name==null){
				alert("名称不能为空");
					return false;
				}
				else{
					$("#statueType").submit();
	                //console.log("保存",index);
	                layer.close(index);
                }
            },
            area : ['300px','auto'],
            page : {dom : '.limitbox2'}
        });
    });

    $('.actbox2 .btn:eq(1)').click(function () {
        
        $.layer({
            type : 1,
            title : '添加分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                var name = $("#name").val(); 
				if(name==""||name==null){
				alert("名称不能为空");
					return false;
				}
				else{
					$("#statueType").submit();
	                //console.log("保存",index);  
	                layer.close(index);
                }
            },
            area : ['300px','145px'],
            page : {dom : '.limitbox2'}
        });
    });


    $('.l4 .tb_edit').live('click', function () {
      
        $('.catename1 input ').val($.trim($(this).parent().prev().text()));  
		var id=$.trim($(this).parent().attr("cateId"));
	
		//给编辑的文本框赋获取到的id
		document.getElementById("cateId").value=id;
        $.layer({
            type : 1,
            title : '编辑分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
				var name = $("#cateName").val(); 
				name = $.trim(name);
				if(name==""||name==null){
					alert("名称不能为空");
					return false;
				}else{
					$("#editType").submit();
	         		//console.log("保存",index);	
	                layer.close(index);
                }
            },
            area : ['300px','145px'],
            page : {dom : '.limitbox3'}
        });
    });
	
	 $('.r6 .tb_edit').live('click', function () {
	 
	 	 $('.catename2 input ').val($(this).parent().prev().text());
		var id=$.trim($(this).parent().attr("_id"));
		//alert($(this).parent().html());
		//给编辑的文本框赋获取到的id
		document.getElementById("selfid").value=id;
        $.layer({
            type : 1,
            title : '编辑分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
				var name = $("#nameValue").val(); 
				if(name==""||name==null){
					alert("名称不能为空");
					return false;
				}else{
					$("#editTypeValue").submit();					
	                //console.log("保存",index);
	                layer.close(index);
	             }
            },
            area : ['300px','145px'],
            page : {dom : '.limitbox4'}
            
        });
    });


    $('.tb_remove').live('click', function () {
        var _this = $(this)
        $.layer({
            shade: [0],
            area: ['auto','auto'],
            dialog: {
                msg: '确定要删除吗？',
                btns: 2,                    
                type: 4,
                btn: ['删除','取消'],
                yes: function(){
                    $(_this).parent().parent().remove();
                    layer.msg('删除', 1, 1);
                }, no: function(){
                    //layer.msg('取消', 1, 13);
                }
            }
        });
    });

});
</script>
</body>
</html>