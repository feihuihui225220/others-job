<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>消息管理</title>   
    #parse("/common/top.tpl")
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
  </head>
  
  <body>
  
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;"> 
$detail.content
<div>
<form action="/icare/notice/add" method="post" name="searchForm">
<input type="hidden" class="input2" name="userContact" value="$!detail.userContact"/>
<textarea  name="content" style="width: 400px;height: 300px;margin-top:30px;"></textarea>
<input type="submit" value="回复"  class="btnBg" style="width: 100px;"/>
</form>
</div>
</body>
#parse("/common/masklayer.tpl")
  <script type="text/javascript" src="../../assets/director/js/jquery-1.12.4.min.js"></script>
 <script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
  <script type="text/javascript" src="/assets/js/calendar.js"></script>
 
 <script type="text/javascript">
 $(function(){
 	$(".timedate").calendar({ format:'yyyy-MM-dd hh:mm:ss' });
 	$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
 });
 </script>
</html>
