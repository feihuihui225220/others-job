<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>组合型试题</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <form method="post" action="/professional/assess/qa/commit" class="reg_area fix_pop" style="width:800px">
        <h2>添加评估量表</h2>   
        <input type="hidden" name="page" value="${page.page}" />
		<input type="hidden" name="num" value="${page.num}" />
		<input type="hidden" name="assessId" value="$!{assessId}" />
		<input type="hidden" name="type" value="${type}" />
		<input type="hidden" name="id" value="#if($assessQa.id) $assessQa.id #else 0 #end" />
        <div class="limitbox pad10">
            <table class="tb table_col2">
                <col class="col1"/><col class="col2"/>
                <tr>
                    <th></th>
                    <th>评估量表名称</th>
                </tr>
                #if(${assesses})
			    	#foreach ($assess in $assesses)
				    	<tr>
				    		<td><input type="checkbox" name="assessIds" value="${assess.id}" /></td>
				    		<td>${assess.name}</td>
				    	</tr>
			    	#end
			   #end	
            </table>
        </div>
        <p class="opt">
           <input type="button" class="btn button_delete" onClick="javascripts:history.go(-1)" value="取 消" />
           <button type="submit" class="btn  button_gm">添 加</button>
        </p>
    </form>
    <div class="footer">
        
    </div>
</div>

</body>
</html>