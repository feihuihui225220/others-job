<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>结论列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
                <input type="button" class="btn button_delete" onClick="javascripts:window.parent.location='/professional/assess'" value="返 回" />
                <button class="btn button_add" onclick="javascripts:location.href='/professional/assess/clu/add?page=${page.pageNo}&num=${page.pageSize}&assessId=${assessId}&type=${type}'">增加结论</button>
            </div>
            #if ($page)
               <table class="tb table_col4 fix_score mgb10">
                   <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/>
                    <tr>
                       <th>序号</th>
                       <th>分级标准</th>
                       <th>分级名称</th>
                       <th>操作</th>
                   </tr>
                   #set($i=1)
				   #foreach ($assessClu in $page.result)
				   <tr>
					 <td>${i}</td>
					 <td>${assessClu.standard}</td>
					 <td>${assessClu.content}</td>
					 <td>
						<button class="tb_edit button_add" onclick="javascript:location.href='/professional/assess/clu/modify?page=${page.pageNo}&num=${page.pageSize}&assessId=${assessId}&assessCluId=${assessClu.id}&type=${type}'">编辑</button>
						<button class="tb_remove button_delete" td_url="javascript:location.href='/professional/assess/clu/delete?page=${page.pageNo}&num=${page.pageSize}&assessId=${assessId}&assessCluId=${assessClu.id}&type=${type}'">删除</button>
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