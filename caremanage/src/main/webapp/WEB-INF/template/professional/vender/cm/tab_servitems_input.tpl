<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
    <form method="post" action="/professional/vender/tab/service/commit" class="reg_area fix_pop" style="width:800px">
    	<input type="hidden" name="venderId" value="${venderId}" />
        <h2>添加服务项目</h2>   
        <div class="limitbox pad10">
            <table class="tb table_col2">
                <col class="col1"/><col class="col2"/>
                <tr>
                    <th>序号</th>
                    <th>专业服务名称</th>
                </tr>
                #foreach($service in $services)
                	<tr>
                		<td><input type="checkbox" name="serviceId" value="${service.id}" /></td>
                		<td>${service.name}</td>
                	</tr>
                #end
            </table>
        </div>
        <p class="opt">
        	<button type="button" class="btn button_btn" onclick="javascript:history.go(-1)">取 消</button>
        	<button type="submit" class="btn  button_btn">添 加</button>
        </p>
    </form>
    <div class="footer">
        
    </div>
</div>

</body>
</html>