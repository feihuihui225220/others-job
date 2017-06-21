<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>元服务</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<style>
.fix_yuan_add .fix {padding:20px 0 20px 71px;border-bottom:1px dashed #ddd;margin-bottom:20px;}
.fix_yuan_add .admin_cate_opt {font-weight:normal;}
.fix_yuan_add .table_col6 .col1 {width:10%;}
.fix_yuan_add .table_col6 .col2 {width:25%;}
.fix_yuan_add .table_col6 .col3 {width:25%;}
.fix_yuan_add .table_col6 .col4 {width:10%;}
.fix_yuan_add .table_col6 .col5 {width:10%;}
.fix_yuan_add .table_col6 .col6 {width:20%;}
.fix_yuan_add .table_col6 td {text-align:center;}
.fix_yuan_add .table_col6 input {margin:0;vertical-align:middle;}
.yuan_div{width:300px;float:left;}
.yuan_div span{display:inline-block;width:100px;text-align:right;}
.fix_yuan_add .fix{padding-left:15px;}
</style>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <form method="post" action="/professional/meta/commit" class="reg_area fix_pop" style="width:960px">
        <h2>添加元服务</h2>
        <input type="hidden" name="page" value="${page.page}" />
		<input type="hidden" name="num" value="${page.num}" />
	    <input type="hidden" name="id" value="$!{meta.id}" />
        <div class="limitbox pad10 fix_yuan_add">
            <div class="fix clearfix">
                <div class="yuan_div "><span>名称：</span><input type="text" name="name" value="$!{meta.name}" /></div>
                <div class="yuan_div"><span>设备类型：</span><select name="deviceTypeId" style="width:173px;">
                        #foreach($device in $devices)
		    			<option value="${device.id}" #if($device.id == $meta.deviceTypeId) selected #end>${device.name}</option>
		    			#end
                    </select>
                </div>
                 <div class="yuan_div "><span>服务费用：</span><input type="text" name="price" value="$!{meta.price}" style="width:30px;"/>元</div>
            </div>
            <div class="admin_cate_opt clearfix">
                <div class="yuan_div"><span>数据模块名称：</span><input type="text" name="dataModule.name" value="$!{meta.dataModule.name}" /></div>
                <div class="yuan_div"><span>数据集合名称：</span><input type="text" name="dataModule.tableName" value="$!{meta.dataModule.tableName}" /></div>
                <button class="btn btn2 button_gm" type="button">添加字段</button>
            </div>
            <table class="tb table_col6 tab_115">
                <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/><col class="col6"/>
                <tr>
                    <th>序号</th>
                    <th>字段名称</th>
                    <th>字段说明</th>
                    <th>是否显示</th>
                    <!--
                    <th>是否报警</th>
                    -->
                    <th>操作</th>
                </tr>
                #if($meta)
			    		#set($i = 1)
			    		#foreach($item in $meta.dataModule.items)
				    		<tr>
				    			<td>
				    				$i
				    			</td>
				    			<td><input type="text" name="dataModule.items[$!{velocityCount}].name" value="$!{item.name}" /></td>
				    			<td><input type="text" name="dataModule.items[$!{velocityCount}].desc" value="$!{item.desc}" /></td>
				    			<td><input type="checkbox" name="dataModule.items[$!{velocityCount}].isShow" #if($item.isShow) checked #end value="1" /></td>
				    			<!--
				    			<td><input type="checkbox" name="dataModule.items[$!{velocityCount}].isAlarm" #if($item.isAlarm) checked #end value="1" /></td>
				    			-->
				    			<td><span class="tb_remove2 button_delete">删除</span></td>
				    		</tr>
				    	#set($i=$i+1)	
			    		#end
		    		#end
            </table>
        </div>
        <p class="opt">
           <input type="button" class="btn button_delete" onClick="javascripts:history.go(-1)" value="取 消" />
           <button type="submit" class="btn  button_gm">添 加</button>
        </p>
    </form>
    <div class="footer">
        
    </div>
</div>

<script>

$(function(){

    $('.btn2').click(function () {
        $('.table_col6').append('<tr><td>'+($('.table_col6 tr').length)+'</td><td><input type="text"/></td><td><input type="text"/></td><td><input type="checkbox" /></td><td><span class="tb_remove2 button_delete">删除</span></td></tr>');
        $('.table_col6 input').each(function (index, domEle) {
            //console.log($(this).parent().parent())
            switch (index % 3) {
                case 0 :
                    $(this).attr('name', 'dataModule.items['+($(this).parent().parent().index()-1)+'].name');
                    break;
                case 1 :
                    $(this).attr('name', 'dataModule.items['+($(this).parent().parent().index()-1)+'].desc');
                    break;
                case 2 :
                    $(this).attr('name', 'dataModule.items['+($(this).parent().parent().index()-1)+'].isShow');
                    break;
                //case 3 :
                //    $(this).attr('name', 'dataModule.items['+($(this).parent().parent().index()-1)+'].isAlarm');
                //    break;
            }
        });
    });

    $('.tb_remove2').live('click', function () {
        $(this).parent().parent().remove();
        $('.table_col6 tr').find('td:eq(0)').each(function (index, domEle) {
            $(domEle).html(index+1);
        });
        $('.table_col6 input').each(function (index, domEle) {
            //console.log($(this).parent().parent())
            switch (index % 3) {
                case 0 :
                    $(this).attr('name', 'dataModule.items['+($(this).parent().parent().index()-1)+'].name');
                    break;
                case 1 :
                    $(this).attr('name', 'dataModule.items['+($(this).parent().parent().index()-1)+'].desc');
                    break;
                case 2 :
                    $(this).attr('name', 'dataModule.items['+($(this).parent().parent().index()-1)+'].isShow');
                    break;
                //case 3 :
                //    $(this).attr('name', 'dataModule.items['+($(this).parent().parent().index()-1)+'].isAlarm');
                //    break;
            }
        });
    });
});
</script>
</body>
</html>