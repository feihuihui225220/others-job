<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>政策详情</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
</head>
<style>
.fr_itbn button{line-height:16px\0;}
</style>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usertitle strong clearfix"><div class="f_r fr_itbn">
        <button class="addContact button_btn" onclick="location.href='policylist'">返回</button>
        </div>政策详情</div>
        <div class="rightbtn pad10"></div>
        <div class="usedetail clearfix">
            <div class="f_l left pad10">
                <div class="udlinebox strong"><span class="f_l strong">名称：</span><p>${policy.title}</p></div>
                <div class="udlinebox mgb10"><span class="f_l strong">简介：</span><p>${policy.content}</p></div>
                <div class="udlinebox"><span class="f_l strong">发布单位：</span><p>${policy.unit}</p></div>
                <div class="udlinebox mgb10"><span class="f_l strong">面向对象：</span><p>${policy.handleCond}</p></div>
                <div class="udlinebox"><span class="f_l strong">受理单位：</span><p>${policy.accept}</p></div>
                <div class="udlinebox bordernone">
	                <span class="f_l strong">附件：</span><p>
	                #foreach ($att in $atts)
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
                        <tr #if(!$cat.status)style="background-color:#fff"#end>
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
</body>
</html>