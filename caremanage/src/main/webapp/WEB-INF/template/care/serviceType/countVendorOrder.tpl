<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>用户列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
	#parse("/common/head.tpl")
    <div class="body bodyline pad10">
    #parse("/community/user/tab.tpl")
       <form action="" method="get" name="searchForm">
        <ul class="inpubox clearfix">
            <li style="width: auto;"><label>时间：</label><input name="start" value="$!date.format('yyyy-MM-dd',$!datevo.start)" class="text150 timedate" type="text" /> ~ <input name="end" value="$!date.format('yyyy-MM-dd',$!datevo.end)" class="text150 timedate" type="text" /></li>
            <li><label>统计项：</label><input type="radio" name="type" value="1" #if($type==1)checked="checked"#end>订单  &nbsp;<input type="radio" name="type" value="2" #if($type==2)checked="checked"#end>投诉</li>
            <li><input type="submit" class="ibtn button_btn" value="统计"></li>
            #if($serviceType)
            <input type="hidden" name="serviceTypeId" value="$serviceType">
            #end
        </ul>
       </form>
        <div class="tablebox">
            <table class="table100 usertable trclick">
                <tr><th>服务商</th><th>#if($type==1)订单量#else投诉量#end</th></tr>
               
	              #foreach ($item in $counts)
		        		<tr>
		        			<td>$!{item.name}</td>
		        			<td>#if($type==1)$!{item.orderCount}#else$!{item.comCount}#end</td>
		        		</tr>
	        			#end
            </table>
        </div>
    </div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".timedate").calendar({ format:'yyyy-MM-dd' });
});
</script>
</body>
</html>