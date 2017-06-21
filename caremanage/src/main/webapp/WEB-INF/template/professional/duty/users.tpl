<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>责任管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script type="text/javascript" src="/assets/js/top.js"></script>

</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
			<table class="table100 usertable cen">
                <tr><th>姓名</th><th>联系电话</th><th>当前服务人数</th></tr>
				#if ($page)
	                #foreach ($u in $page.result)
                		<tr class="limitid_$!u.id">
							<td>$!u.name</td>
							<td>$!u.contactPhone</td>
							#set($count=$sevCount.get($u.id))
							<td>#if(!$count)0#else$!count#end</td>
							#set($count=0)
						</tr>
					#end
				#end
            </table>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>