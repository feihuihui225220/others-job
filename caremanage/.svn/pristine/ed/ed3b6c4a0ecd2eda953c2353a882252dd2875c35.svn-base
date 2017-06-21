<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>实时消息设置</title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
</head>
<body>

<div class="wrapper">
    <div class="body">
        <div class="usermessbox bodyline pad10 mgb10 clearfix">
            #if($sessionUser.cateEnum.type==1)
            <div class="searchli">
				<ul class="inpubox clearfix">
					<li><label>选择日期：</label><input class="text150 timedate" type="text"> 至 <input class="text150 timedate" type="text"></li>
					<li><input class="ibtn button_btn" type="button" value="搜索"></li>
				</ul>
			</div>
            #end
			#foreach($message in $messages.result)
			    <div class="jianyi">
				    <p class="jianyi_p">${message.message}</p>
				    <span class="jianyi_span">$!date.format('yyyy-MM-dd HH:mm',$!message.createdAt)</span>
			    </div>
			#end
            #if($sessionUser.cateEnum.type==4)
				<form action="/professional/msg/commit" method="post">
			         <input type="hidden" name="userId" value="${userId}" />
			         <input type="hidden" name="serviceId" value="${serviceId}" />
		             <textarea name="message" style="width: 99%; height: 100px; margin: 0 auto; display: block; margin-bottom: 10px;"></textarea>
		             <input class="ibtn button_btn" type="submit" value="添加信息" style=" margin: 0 auto; display: block;"/>
		        </form>
            #end
        </div>
    </div>
    <div class="footer"></div>
</div>

<script type="text/javascript">
$(function(){
    $(".timedate").calendar({ format:'yyyy-MM-dd' });
});
</script>
</body>
</html>