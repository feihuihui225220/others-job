<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>评估量表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
     #parse("/common/head.tpl")
    <div class=" ">
        <form method="post" action="/professional/assess/commit" class="reg_area fix_pop" style="width:400px">
            <h2>添加评估量表</h2>
            <input type="hidden" name="page" value="${page.page}" />
		    <input type="hidden" name="num" value="${page.num}" />
		    <input type="hidden" name="id" value="$!{assess.id}" />
            <dl>
                <dt>名    称：</dt>
                <dd><input type="text" name="name" value="$!{assess.name}" /></dd>
                <dt>量表类型：</dt>
                <dd>
                    <select name="type">
                        <option value="0" #if($assess.type == 0) selected #end>分数题</option>
		    		    <option value="1" #if($assess.type == 1) selected #end>组合题</option>
		    		    <option value="2" #if($assess.type == 2) selected #end>社区评估</option>
                    </select>
                </dd>
                <dt>种类类型：</dt>
                <dd>
                    <select name="itemId">
                            <option value=-1>===请选择===</option>
                        #foreach($n in $cit)
                            <option value=$n.id>$n.itemName</option>
                        #end
                    </select>
                </dd>
                <dt>简    介：</dt>
                <dd style="height:auto;"><textarea name="descr" style="width:240px;height:80px;resize:none;margin-bottom:20px;">$!{assess.descr}</textarea></dd>
            </dl>
            <p class="opt">
                <input type="button" class="btn button_delete" onClick="javascripts:history.go(-1)" value="取 消" />
                <button type="submit" class="btn button_add">添 加</button>
            </p>
        </form>
    </div>
    <div class="footer">
        
    </div>
</div>
</body>
</html>