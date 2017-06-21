<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="/assets/js/pageNavigator.js"></script>
<style>
.col7 {width:220px;}
.col3 {width:90px;}
.col4 {width:90px;}
</style>

</head>
<body>
 #parse("/common/masklayer.tpl")
<div class="wrapper">
   
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
                <button class="btn button_add"  >添 加</button>
            </div>
            <form action="/admin/knowledgelist" method="post" name="searchForm"></form>
			#if($page)
            <table class="tb table_col7 tab_115 mgb10"  style="table-layout:fixed;">
                <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/><col class="col5"/><col class="col6"/><col class="col7"/>
                
                <tr>
                    <th>标题</th>
                    <th>内容</th>
                    <th>发布人</th>
                    <th>发布时间</th>
                    <th>关键字</th>
                    <th>知识库类型</th>
                    <th>操作</th>
                </tr>
                #foreach ($listkw in $page.result)
                <tr>
                    <td style="overflow:hidden;" nowrap title="$!{listkw.title}">$!{listkw.title}</td>
                    <td style="overflow:hidden;" nowrap title="$!{listkw.content}" class="hiddentext">$!{listkw.content}</td>
                    <td>$!{listkw.publisher}</td>
                    <td>$!date.format('yyyy-MM-dd',$!{listkw.createdAt})</td>
                    <td style="overflow:hidden;" nowrap>$!{listkw.keyword}</td>
              		<td style="overflow:hidden;" nowrap>$!{listkw.categoryItem.itemName}</td>
                    <td>					
						<span class="tb_edit button_add" onclick='location.href="edit?id=${listkw.id}"'>编 辑</span>
						<span class="tb_remove button_delete" td_url='delKnowledgeById?id=${listkw.id}'>删 除</span>
					</td>
              </tr>
              	#end
			
            </table>
            #end
            
            #parse("/common/page.tpl")
        </div>
    </div>
    <div class="footer"></div>
</div>
<script type="text/javascript">
	$(".btn").click(function(){
		var url ="addpage";
		location.href=url;
		});
</script>
</body>
</html>