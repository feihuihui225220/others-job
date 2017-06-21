<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Care Manager_服务商管理_详情页面</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
#if($!{sessionUser.getCateEnum()}!="STREET")
<script>
	function toAddPage(venderId) {
		window.open('/professional/vender/tab/service/add?venderId=' + venderId, '_self');
	}
	
	function delService(venderId, serviceId) {
		window.open('/professional/vender/tab/service/remove?venderId=' + venderId + "&serviceId=" + serviceId, '_self');
	}
</script>
#end
</head>
<body>
<div class="wrapper">
    <div class="body">
        <div class="useractbox bodyline pad10">
            <div class="actboxlist">
				<div class="actbox4">
					<div class="usertitle mgb10 strong clearfix">
					#if($!{sessionUser.getCateEnum()}!="STREET")
						<div class="fr_itbn">
							<button type="button" style="float:right;" class="addulimit button_btn" onclick="toAddPage(${venderId})">添加</button>
						</div>
					#end
					</div>
					<table class="table100 usertable cen">
                        <tr>
                        	<th>序号</th>
                        	<th>服务名称</th>
                        	<th>操作</th>
                        </tr>
                        #set($i=1)
                        #foreach($service in $services)
                        <tr>
                        	<td>$i</td>
                        	<td>${service.serviceName}</td>
                        	<td class="operate">
                        		<input limitid='1' class="delulimit mgl5 button_btn" type="button" value="删除" onclick="delService(${venderId}, ${service.serviceId})"/>
                        	</td>
                        </tr>
                        #set($i=$i+1)
                        #end
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>