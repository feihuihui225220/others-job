<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>老年人前端_公告政策_公告详情</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
</head>
<body>

<div class="wrapper">
   #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usertitle strong clearfix"><div class="f_r fr_itbn"><button class="addContact button_btn" onclick="location.href='noticelist'">返回</button>
        </div>公告详情</div>
        <div class="rightbtn pad10"></div>
        <div class="usedetail clearfix">
      
			<div class="ggtext">
				<p>$!{notice.title}</p></br>
				
				<p>$!{notice.content}</p></br>
				<p>$!{notice.publisher}</p></br> 
				<p>$!date.format('yyyy-MM-dd: HH:mm:ss',$!{notice.createdAt})</p></br>
			</div>
			<div class="ggtext_dl">
		#if($notice.directory)
                #foreach($dire in $notice.directory.split(","))
                #if(!($dire==""))
                #set($count = $velocityCount+1)
                <div><a href="${dire}" >附件${count} </a></div>
                #end
                #end
                #end
			</div>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>