<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>CallCenter事务办理_公共服务</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usedetail clearfix">
			<div class="usertitle mgb10 strong clearfix"><div class="f_r fr_itbn"><button class="addulimit button_btn" onclick="window.location='/callCenter/index'">返回</button></div></div>
			<iframe src="/community/policyRecommend/iframe/?userId=$!{id}" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>