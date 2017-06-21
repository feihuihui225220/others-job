<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>老年人前端_知识库详细</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
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
        <button class="addContact button_btn" onclick="history.back(-1)">返回</button>
        </div>知识库</div>
        <div class="rightbtn pad10"></div>
        <div class="usedetail clearfix">
				<div class="ggtext c_fix_txt">
				<h1> ${know.title}</h1>
              	  <span class="meta">$!date.format('yyyy-MM-dd: HH:mm:ss',$!{know.createdAt})</span>
                <div class="con">
                    <p>${know.content}</p>
                   
                </div>
			</div>
			<div class="ggtext">
			</div>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>