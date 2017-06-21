<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/assets/css/login.css" rel="stylesheet" type="text/css">
<title>出错了！</title>
</head>

<body style="background:#fffee0;">
<div id="error">
      <div class=""><img src="/assets/css/img/error_01.png">Error </br>出现问题，请联系开发人员
        邮箱:baihsuangdong@le-ho.cn
      </div>
      <hr />
      <div class="error_text"><span>提示信息：</span><label>$!{exception}</label></div>
      <input type="button" class="button" onclick="javascript:window.history.go(-1)"/>
</div>
</body>

<script src="$request.contextPath/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(function(){
		 $.ajax({
             url: "https://le-ho.cn/official/exception?e=caremamager$!{exception}",
             success: function (msg) {
				alert("您的错误消息已经反馈给管理人员，给您带来不便深感抱歉！");               
             }
         });
})
</html>
