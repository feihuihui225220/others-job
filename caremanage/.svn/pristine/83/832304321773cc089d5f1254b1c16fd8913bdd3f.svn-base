<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>分数型试题列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
                <input type="button" class="btn button_delete" onClick="javascripts:window.parent.location='/professional/assess'" value="返 回" />
                <button class="btn button_add" onclick="javascripts:location.href='/professional/assess/qa/add?page=${page.pageNo}&num=${page.pageSize}&assessId=${assessId}&type=${type}'">增加试题</button>
            </div>
            <form action="/professional/assess/qa?assessId=$!assessId&type=$!type" method="post" name="searchForm">
            </form>
            #if ($page)
            <table class="tb table_col3 mgb10 tab_115">
                <col class="col1"/><col class="col2"/><col class="col3"/>
                <tr>
                    <th>序号</th>
                    <th>试题内容</th>
                    <th>操作</th>
                </tr>
                #set($i = 1)
					#foreach ($assessQa in $page.result)
					<tr>
						<td>$i</td>
						<td>${assessQa.content}</td>
						<td>
							<button class="btn_edit button_gm" onclick="javascripts:location.href='/professional/assess/qa/modify?assessId=${assessQa.assessId}&assessQaId=${assessQa.id}&page=${page.pageNo}&num=${page.pageSize}&type=${type}'">编辑</button>
							<button class="tb_remove button_delete" td_url="/professional/assess/qa/delete?assessId=${assessQa.assessId}&assessQaId=${assessQa.id}&page=${page.pageNo}&num=${page.pageSize}&type=${type}">删除</button>
						</td>
					</tr>
					#set($i=$i+1)	
					#end
				</table>	
				#parse("/common/page.tpl")
			#end
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
<script src="/assets/js/pageNavigator.js"></script>
</html>