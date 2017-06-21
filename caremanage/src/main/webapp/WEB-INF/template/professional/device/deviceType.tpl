<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>设备类型列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
	#parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
                <button class="btn button_add" onclick="javascripts:location.href='/professional/device/type/add?page=${page.pageNo}&num=${page.pageSize}'">添 加</button>
            </div>
            <form action="/professional/device/type" method="post" name="searchForm">
            </form>
        	#if ($page)
			<table class="tb table_col4 tab_115 fix_machine mgb10">
				<tr>
					<th>名称</th>
					<th>描述</th>
					<th>设备类型资质</th>
					<th>操作</th>
				</tr>
				#foreach ($deviceType in $page.result)
				<tr>
					<td>${deviceType.name}</td>
					<td>${deviceType.descr}</td>
					<td>${deviceType.qualification}</td>
					<td>
						<button class="tb_edit button_add" onclick="javascripts:location.href='/professional/device/type/modify?page=${page.pageNo}&num=${page.pageSize}&id=${deviceType.id}'">编辑</button>
						<button class="tb_remove button_delete" td_url="/professional/device/type/delete?page=${page.pageNo}&num=${page.pageSize}&id=${deviceType.id}">删除</button>
					</td>
				</tr>	
				#end
			</table>
			#parse("/common/page.tpl")	
		  #end
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>