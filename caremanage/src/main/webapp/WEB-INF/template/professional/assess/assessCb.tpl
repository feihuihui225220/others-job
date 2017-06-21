<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>综合型试题列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
                <input type="button" class="btn button_add" onClick="javascripts:window.parent.location='/professional/assess'" value="返 回" />
                <button class="btn button_add" onclick="javascripts:location.href='/professional/assess/qa/add?page=${page.pageNo}&num=${page.pageSize}&type=${type}&assessId=${assessId}'">增加量表</button>
            </div>

            #if ($page)
            <table class="tb table_col4 fix_score mgb10 tab_115">
                <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/>
                <tr>
                    <th>序号</th>
                    <th>名称</th>
                    <th>简介</th>
                    <th>操作</th>
                </tr>
                #set($i=1)
					#foreach ($assess in $page.result)
					<tr>
						<td>${i}</td>
						<td>${assess.name}</td>
						<td>${assess.descr}</td>
						<td>
							<button class="tb_remove button_delete" td_url="/professional/assess/qa/delete?page=${page.pageNo}&num=${page.pageSize}&assessId=${assessId}&assessQaId=${assess.id}&type=${type}">删除</button>
						</td>
					</tr>
					#set($i=$i+1)	
					#end
				</table>	
			#end
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>