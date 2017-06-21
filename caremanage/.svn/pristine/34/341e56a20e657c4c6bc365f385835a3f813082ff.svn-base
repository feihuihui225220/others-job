<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>社区用户_权限管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
</head>
<style>
button.pad5{line-height:16px\0;}
</style>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usertitle mgb10 strong clearfix"><div class="f_r fr_itbn">
        	<button onclick="window.location.href='/permission/addResource'" class="button_gm">添加</button>
        </div>
		一级菜单
	</div>
    <div class="tablebox">
        <table class="table100 policy usertable cen">
            <tr><th>菜单名称</th><th>操作</th></tr>
            #if ($resources)
        		#foreach ($res in $resources)
            		<tr class="menuid_$!res.id">
            			<td>$!res.name</td>
            			<td class="operate">
            				<input onclick="window.location.href='/permission/modifyResource/$!res.id'" type="button" class="button_gm" menuid="$!res.id" value="编辑"/>
            				<input class="delmenu mgl5 button_delete" menuid="$!res.id" type="button" value="删除"/>
            			</td>
            		</tr>
        		#end
            #end
        </table>
    </div>
</div>
<div class="footer"></div>
</div>
<div class="menubox pad10 hide">
    <ul class="inpubox clearfix">
        <li><label>名称：</label><input class="text150" type="text" /></li>
        <li><label>URL：</label><input class="text150" type="text" /></li>
    </ul>
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".addmenu").click(function(){
        $.layer({
            type : 1,
            title : '添加菜单',
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
            area : ['350px','200px'],
            page : {dom : '.menubox'}
        });
    });
    $(".editmenu").click(function(){
        var menuid = $(this).attr("menuid");
        //console.log('编辑id'+menuid);
        $.layer({
            type : 1,
            title : '编辑菜单',
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
            area : ['350px','200px'],
            page : {dom : '.menubox'}
        });
    });
    $(".delmenu").click(function(){
        var menuid = $(this).attr("menuid");
        layer.confirm('是否确定删除该菜单?', function(index){
        	$.get("/permission/removeResource/"+menuid,function(result){
    			if(result=='success'){
	    			// 移除记录
            		$('.menuid_'+menuid).remove();
    			}
  			});
            layer.close(index);
        }, function(index){
            //console.log(index);
        });
    });
});
</script>
</body>
</html>