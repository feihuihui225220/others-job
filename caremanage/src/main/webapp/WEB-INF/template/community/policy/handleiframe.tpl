<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>社区用户_办理公共服务</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
</head>
<style>
.fr_itbn button{line-height:16px\0;}
</style>
<body>

<div class="wrapper">
    <div class="body bodyline pad10">
        <div class="usertitle strong clearfix"><div class="f_r fr_itbn">
        		#if($sessionUser.cateEnum.type!=3)
        			<button class="addContact button_btn" id="saveBT">办理</button>
        		#end
        		<button class="addContact button_btn" onclick="javascripts:history.go(-1)">返回</button></div>办理公共关系</div>
        <div class="rightbtn pad10"></div>
        <div class="usedetail clearfix">
            <div class="f_l left pad10">
                <div class="udlinebox strong"><span class="f_l strong">名称：</span><p>${recommend.policy.title}</p></div>
                <div class="udlinebox mgb10"><span class="f_l strong">简介：</span><p>${recommend.policy.content}</p></div>
                <div class="udlinebox"><span class="f_l strong">发布单位：</span><p>${recommend.policy.unit}</p></div>
                <div class="udlinebox mgb10"><span class="f_l strong">面向对象：</span><p>${recommend.policy.handleCond}</p></div>
                <div class="udlinebox"><span class="f_l strong">受理单位：</span><p>${recommend.policy.accept}</p></div>
                <div class="udlinebox bordernone">
	                <span class="f_l strong">附件：</span><p>
	                #foreach ($att in $attlist)
	                	<a href="${att.directory}">${att.fileName}</a>
	                #end
	                </p>
                </div>
                <!--<p class="zhu pad10">注：1、附件可以下载</p>-->
            </div>
            <div class="f_l pad10 table47">
                <p class="mgl20 strong">所需材料：</p>
                <div class="mgl20 tablebox">
                    <table class="table100 usertable cen">
                        <tr><th>序号</th><th>材料名称</th><th>材料状态</th><th>备注</th></tr>
                        #foreach ($cat in $catlist)
                        <tr #if(!$cat.status)style="background-color:#F00"#end>
                        	#set($row=$velocityCount + 1)
	                        <td>${row}</td>
	                        <td>${cat.name}</td>
	                        <td>#if($cat.status)已有#else缺少#end</td>
	                        <td>${cat.remark}</td>
	                    </tr>
                        #end
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</div>
<script type="text/javascript">

    $("#saveBT").click(function(){
       $ .ajax({
       		type: "get",
       		data:{status:$("#status").val(),id:${recommend.id}},
			url: "handle",
			success: function(data){
				if("done"==data){
					window.location.href=document.referrer;
				}else{
					alert("处理失败！");
				}
			}
       });
    });
</script>
</body>
</html>