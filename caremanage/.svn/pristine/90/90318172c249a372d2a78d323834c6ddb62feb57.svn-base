<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>元服务列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="/assets/js/pageNavigator.js"></script>
<style>
.fix_yuan .col1, .fix_yuan .col2, .fix_yuan .col3, .fix_yuan .col4, .fix_yuan .col5 {width:20%;}
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
                <button class="btn button_gm" onclick="javascripts:location.href='/professional/meta/add?page=${page.pageNo}&num=${page.pageSize}'">添 加</button>
            </div>
            <form action="/professional/meta" method="post" name="searchForm">
            </form>
            #if ($page)
            <table class="tb  tab_115">
                <tr>
                    <th>名称</th>
                    <th>数据模块</th>
                    <th>设备类型</th>
                    <th></th>
                    <th></th>
                </tr>
                #foreach ($meta in $page.result)
                  <tr>
                      <td>${meta.name}</td>
					  <td>${meta.dataModule.name}</td>
                      <td>${meta.deviceType.name}</td>
                      <td>
                         <a href='/professional/meta/modify?page=${page.pageNo}&num=${page.pageSize}&id=${meta.id}'>编 辑>></a>
                      </td>
                      <td>
                        <img class="tb_remove" style="width:60px;height:20px;" td_url="/professional/meta/delete?page=${page.pageNo}&num=${page.pageSize}&id=${meta.id}" style="width:60px;height:20px; position:relative;top:20px;" src="/assets/css/img/delete.png"/>
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