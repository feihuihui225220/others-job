<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/assets/newCss/zy_end.css">
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
</head>
<body>
    <div class="gou"></div>
    <div class="t_font">提交成功，非常感谢！</div>
    <div class="t_font">倒计时<span style="color:red;">3</span>秒后跳转首页</div>
</body>
<script language="javaScript">
    var time=parseInt($(".t_font>span").html());
    function daoji(){
    	$(".t_font>span").html(time)
    	time--;
    	if(time==0){
    		location.href="/professional/volunteer/nVolunteerAssess?volunteerId="+$!volunteer;
    	}
    }
    setInterval("daoji();",1000)
</script>
</html>