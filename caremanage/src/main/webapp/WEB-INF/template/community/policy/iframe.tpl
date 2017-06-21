<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
</head>
<body>
	    <table class="table100 usertable cen trclick">
	        <tr><th>序号</th><th>服务名称</th><th>政策编号</th><th>办理状态</th></tr>
    		#if($upolicy.result)
			    #foreach($up in $upolicy.result)
			        #set($count = $velocityCount+1)
			        <tr>
			        	<td>
			        		${count}
			        		#if($up.id&&$up.pstate>=1&&$up.pstate<=3)
			        			<input type="hidden" value="/community/userpolicy/toHandleIframe?id=${up.id}" />
			        		#end
			        	</td>
			        	<td>${up.ptitle}</td>
			        	<td>$!{up.pnumber}</td>
			        	<td>
			        		#if($up.pstate)
			        			$statearr.get(${up.pstate})
			        		#else
			        			未确认
			        		#end
			        	</td>
			        </tr>
			    #end
	        #end
	    </table>
</body>
</html>