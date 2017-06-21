<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<style type="text/css">
.limitbox1 .inpubox li{width:auto;float:left;}
.actbox10{zoom: 1;margin-top: 20px;}
</style>
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>

</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body">
        <div class="useractbox bodyline pad10">
            <ul class="clourstitle strong mgb10">
               <li index="1" class="rel  on" onclick='location.href="findCategoryItem"'>字典管理</li>
               <li index="2" class="rel" onclick='location.href="findStatueCategory?parentId=1"'>状态管理</li>
               <li index="3" class="rel" onclick='location.href="findPlanCategory?parentId=1"'>计划管理</li>
               <li index="4" class="rel" onclick='location.href="findCategoryRounds?parentId=1"'>巡诊管理</li>
            </ul>
            <div class="actboxlist">
                <div class="actbox10">
                   <div class="admin_cate_opt">
				   <button class="btn button_add">添 加</button>
                   <form action="findCategoryItem" name="form" method="post" >
                        分类项目选择：
                            <select name="categoryId" id="categoryId"   onChange="form.submit();">
                               
                            #if($category)
                                #foreach($cate in $category)
                                <option value="$!{cate.id}" #if($!{cate.id}==$!{categoryId})selected=true#end>$!{cate.name}</option>
                                #end
                             #end
                            </select>
                      </form>
                    </div>
                    #if($categoryItem)
                    <table class="tb table_col3">
                        <col class="col1"/><col class="col2"/><col class="col3"/>
                        <tr><th>分类名称</th><th>分类描述</th><th>操作</th></tr>
                        
                           #foreach($cateItem in $categoryItem)
                        <tr>
                            <td>${cateItem.itemName}</td>
                            <td>$!{cateItem.itemValue}</td>
                            <td item_id="${cateItem.id}" data-itemId="${cateItem.itemId}"><span class="tb_edit button_gm">编 辑</span>
                            	<!--<span class="tb_remove">删 除</span>-->
                            </td>
                       </tr>
                          #end  
                        
                    </table>
                     #end
                </div>
    </div>
    <div class="footer"></div>
</div>

<form action="addCategoryItem" method="post" name="categoryItem" id="categoryItem"  enctype="multipart/form-data">
<div class="limitbox pad10 hide">
    <ul class="inpubox clearfix">  
        <li><label>分类名称：</label><input class="text150" type="text"  id="itemName" name="itemName" 
         required="required" placeholder="请子项名称" /></li>
        <li ><label style="vertical-align:top;">描述：</label><textarea cols="30" rows="6" name="itemValue" id="itemValue"></textarea></li>
       	#if($categoryId==124)
        <li class="edit">
        <label>封面：</label>
        <input name="coverUrl" type="file">
        </li>
        <li class="edit">
        <label>背景：</label>
        <input name="bgUrl" type="file">
        </li> 
        #end
        <input type="hidden" name="categoryId" id="categoryId" value="${categoryId}"/>
        #set ($sessionUser=$!{session.getAttribute("sessionUser")})
        <input type="hidden" name="changedBy" id="changedBy" value="$!{sessionUser.getName()}"/>
        <input type="hidden" name="createdBy" id="createdBy" value="$!{sessionUser.getName()}"/>
    </ul>
</div>
</form>

<form action="editCategoryItemById" method="post" name="editCategoryItem" id="editCategoryItem" enctype="multipart/form-data">
<div class="limitbox1 pad10 hide">
    <ul class="inpubox clearfix">
        <li class="cateEditName"><label>分类名称：</label><input class="text150" type="text"   name="itemName" id="editItemName"  /></li>
        <li class="edit"><label>描述：</label><textarea  cols="30" rows="6" name="itemValue" id="editItemValue"></textarea></li>
       <input type="hidden" name="id" id="selfId" />
       <input type="hidden" name="itemId" id="itemId_" />
        <input type="hidden" name="categoryId" id="categoryId" value="${categoryId}"/>
        <!--   新加    -->
     	#if($categoryId==124)
        <li class="edit">
        <label>封面：</label>
        <input name="coverUrl" type="file">
        </li>
        <li class="edit">
        <label>背景：</label>
        <input name="bgUrl" type="file">
        </li> 
        #end
        #set ($sessionUser=$!{session.getAttribute("sessionUser")})
        <input type="hidden" name="changedBy" id="changedBy" value="$!{sessionUser.getName()}"/>
        
    </ul>
</div>
</form>

<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".clourstitle li").click(function(){
        var index = $(this).attr('attr');
        $(this).addClass('on').siblings().removeClass('on');
        $(".actboxlist .actbox"+index).show().siblings().hide();
    });

    $('.actbox10 .btn').click(function () {
       
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
				var name = $("#itemName").val(); 
				if(name==""||name==null){
				alert("名称不能为空");
					return false;
				}
				else{
				
					$("#categoryItem").submit();
	                //console.log("保存",index);
	                layer.close(index);
                }
            },
            #if($categoryId==124)
            area : ['450px','380px'],
            #else
            area : ['450px','330px'],
            #end
            page : {dom : '.limitbox'}
        });
    });

    $('.actbox10 .tb_edit').live('click', function () {
        
        $('.cateEditName input ').val($(this).parent().prev().prev().html());
        $('.edit textarea ').val($(this).parent().prev().html());
        
		var id = $.trim($(this).parent().attr("item_id"));
		var itemId = $.trim($(this).parent().attr("data-itemId"));
		document.getElementById("selfId").value=id;
		document.getElementById("itemId_").value=itemId;
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
				
				var name = $("#editItemName").val(); 
				if(name==""||name==null){
				alert("名称不能为空");
					return false;
				}else{
					var itemName=
					$("#editCategoryItem").submit();
	                //console.log("保存",index);
	
	                layer.close(index);
                }
            },
            #if($categoryId==124)
            area : ['450px','380px'],
            #else
            area : ['450px','270px'],
            #end
            page : {dom : '.limitbox1'}
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