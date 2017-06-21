<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>实时消息</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
</head>
<style>
</style>
<body>
#parse("/common/masklayer.tpl")
 <!-- 老年人消息页面带头信息 -->
    #if($sessionUser.cateEnum.type == 1)
    #parse("/common/head.tpl")
    #end
<div class="wrapper" >
   
     #if($!{sessionUser.getCateEnum()}=="USER")
		 	<iframe id="userFrame"  width="20%" style="height:800px; margin-left:1%"src="/user/detail" frameborder="0" scrolling="no"></iframe>
	 #end
    <div style="width:77%;float:right;" height=800px;>
        <div class="usermessbox bodyline pad10 mgb10 clearfix">
            <!-- 老年人消息页面带查询 -->
           
            <div class="searchli">
				<ul class="inpubox clearfix">
				    <form action="/professional/msg/query" method="post" name="searchForm">
				     #if($sessionUser.cateEnum.type==1)
						<li><label>选择日期：</label><input class="text150 timedate" type="text" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)"> <label>至</label> <input class="text150 timedate" type="text" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)"></li>
						<li><input class=" button_add" type="submit" value="搜索"></li>
					 #end
					</form>
				</ul>
			</div>
           
			#foreach($message in $page.result)
			    <div class="jianyi">
				    <p>${message.serviceName}    $!date.format('yyyy-MM-dd HH:mm',$!message.createdAt)</p>
				    <span style="word-wrap:break-word;" >${message.message}</span>
			    </div>
			    <hr/>
			#end
			#if($page.result.size()>0)
				#parse("/common/page.tpl")
			#end
			<!-- 专业服务区商可以添加消息 -->
            #if($sessionUser.cateEnum.type == 4)
				<form action="/professional/msg/commit" method="post">
			         <input type="hidden" name="userId" value="${userId}" />
			         <input type="hidden" name="serviceId" value="${serviceId}" />
			         
		             <textarea name="message" maxlength="200" style="width: 99%; height: 100px; margin: 0 auto; display: block; margin-bottom: 10px;"></textarea>
		             <label>注意：最多输入200字。</label>
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