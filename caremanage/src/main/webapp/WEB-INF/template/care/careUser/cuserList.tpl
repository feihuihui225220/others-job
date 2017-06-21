<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/common.js"></script>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<style>
.table_col5 .col6 {width:210px;}
.table_col5 .col4 {width:30%;}
.table_col5 .col5 {width:15%;}
</style>
</head>
<body>
 #parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
                <button class="btn button_gm" onclick="javascripts:location.href='/care/user/goToAdd'">添 加</button>
            </div>
            <form name="searchForm" method="post" action="/care/user/careUserList" >
            </form>
            <table class="tb table_col5 mgb10">
                <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/>
                <tr>
                    <th>名称</th>
                    <th>管理员姓名</th>
                    
                    <th>服务对象</th>
                    <th>操作</th>
                </tr>
                #foreach ($result in $page.result)
                <tr>
                    <td>$!{result.nickname}</td>
                    <td>${result.name}</td>
                    <td> #foreach ($country in $result.oCountry) ${country.name} #end</td>
                    <td>
                    <button class="tb_edit button_gm" onclick="javascripts:location.href='/care/user/details?id=${result.id}'">编辑</button>
                   <!-- <button class="tb_edit"   onclick="javascripts:location.href='/care/user/delete?uid=${result.id}'">删 除</button> -->
                    </td>
                </tr>
                #end
            </table>
            #parse("/common/page.tpl")
        </div>
    </div>
    
</div>
</body>
</html>