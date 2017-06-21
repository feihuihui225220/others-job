<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>角色管理</title>
<link href="/assets/director/style/XZuserm.css" rel="stylesheet" type="text/css">
</head>
<body>#set($sessionUser=$!{session.getAttribute("sessionUser")})
  #parse("/common/dtop.tpl")
  #parse("/common/dmain.tpl")
<div class="main1">
  <div>
    <div class="personInfo_right fl" style="float: left;">
	            <div class="f_l left pad10">
	                <div class="usertitle mgb10 strong clearfix">
	                	<div style="margin-left: 800px;">
	                		<button onclick="window.location.href='/director/addRole'" class="btnBg">添加</button>
	                	</div>
	                </div>
	                <div class="tablebox">
	                    <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable">
	                        <tr><th>名称</th><th>描述</th><th>操作</th></tr>
	                        #if ($roles)
		                		#foreach ($r in $roles)
		                        	<tr class="limitid_$!r.id">
			                        	<td #if($r.id==$role.id)style="color:#0000FF"#end>$!r.name</td>
			                        	<td>$!r.descr</td>
			                        	<td class="operate">
			                        		<input onclick="window.location.href='/director/modifyRole/$!r.id'" type="button" class="btnBg" limitid='$!r.id' value="编辑" />
			                        		<!--<input limitid='$!r.id' class="delulimit mgl5 button_delete btnBg btnBg1 cancel_all " type="button" value="删除">-->
			                        		<input type="hidden" value="/director/roles?id=$!r.id">
			                        	</td>
		                        	</tr>
		                        #end
		                    #end    
	                    </table>
	                </div>
	            </div>
				<form action="/director/bindResources" method="post" onsubmit="layer.load('正在保存...');">
				<input type="hidden" name="roleId" value="$!role.id"/>
	            <div style="text-align: center;">
	                <div ><div class="f_r fr_itbn mgb5">&nbsp;</div>权限点</div>
	                	<ul class="userlimit">
	                		#if ($resources)
		                		#foreach ($resource in $resources)
									#set($checked=false)
									#if ($resource && $role.resources)
	                					#foreach ($res in $role.resources)
	                       					#if($resource.id==$res.id)
	                       						#set($checked=true)
	                       					#end
	                       				#end
									#end
	                    			<li><input type="checkbox" name="resIds" value="$!resource.id" #if($checked)checked="checked"#end id="">$!resource.name</li>
		                   		#end
	                   		#end
	                	</ul>
	                	<div class="centerbtn pad10">
	                	<button class="btnBg" type="submit" #if($roles.size()<=0)disabled="true"#end>授权</button></div>
	            	</div>
	            	</form>
	        	</div>
    	</div>
    	
    	<!-- <div class="limitbox pad10 hide">
		    <ul class="inpubox clearfix">
		        <li><label>角色名称：</label><input class="text150" type="text" /></li>
		        <li><label>描述：</label><textarea name="" id="" cols="30" rows="6"></textarea></li>
		    </ul>
		</div>  -->
  	</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
$(".main .main_left .sidebar li a").eq(7).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
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
    $(".delulimit").click(function(event){
    	// 阻止事件向上冒泡
        //event.stopPropagation();
        var limitid = $(this).attr("limitid");
        layer.confirm('是否确定删除该角色?', function(index){
        	$.get("/director/removeRole/"+limitid,function(result){
    			if(result=='success'){
	    			// 移除记录
		            $('.limitid_'+limitid).remove();
            		layer.close(index);
            		// 没有记录时置灰操作按钮
            		if($(".tablebox").find("tr").length>1){
	            		// 被选中的记录删除后刷新页面到第一条
	            		if($!role.id == limitid){
	            			window.location.href = "/permission/roles";
	            		}else{
		            		// 有记录恢复按钮可用
	            			$(".centerbtn button").removeAttr("disabled");
	            		};
            		}else{
            			$(".centerbtn button").attr("disabled","true");
            		};
    			};
  			});
        }, function(index){
            //console.log(index);
        });
    });
});
</script>
</html>
