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
	        <tr><th>序号</th><th>服务名称</th><th>政策编号</th></tr>
    		#if($recomendlist)
			    #foreach($up in $recomendlist)
			        #set($count = $velocityCount+1)
			        <tr>
			        	<td>
			        		${count}
			        		<input type="hidden" value="/community/policyRecommend/toaddiframe?id=${up.id}"/>
			        	</td>
			        	<td>${up.policy.title}</td>
			        	<td>$!{up.policy.number}</td>
			        </tr>
			    #end
	        #end
	    </table>
</body>
</html>