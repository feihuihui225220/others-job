<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>老年人_知识库</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
</head>
<body>
    #parse("/common/head.tpl")
<div class="wrapper">
     #if($!{sessionUser.getCateEnum()}=="USER")
		 	<iframe id="userFrame"  width="20%" style="height:800px; margin-left:1%"src="/user/detail" frameborder="0" scrolling="no"></iframe>
	 #end
    <div class=" bodyline pad10" style="width:75%;float:right;" height=800px;>
        <div class="usertitle strong">知识库</div>
        <div class="searchli">
        	<form action="knowledgelist" method="post" name="form">
	            <ul class="inpubox clearfix">  
	                <li><label>分类：</label>
                    <select class="select160" name="category" onChange="form.submit();">
	               	 <option value="0">全部</option>
	                #foreach ($map in $maplist.entrySet())
			        <option value="${map.value.id}" #if($!{map.value.id}==$!{category})selected=true#end>${map.value.itemName}</option>
			        #end
					</select></li>
	            </ul>
            </form>
        </div>
        <div class="tablebox">
        	#if($knowledgelist)
            <table class="table100  cen">   
                #foreach ($k in $knowledgelist.result)
                <tr class="newsid_1" style="text-align:left;"><td><a href="knowledgedetail?id=${k.id}" target="_self">${k.title}</a></td></tr>
             	#end
            </table>
            #end
        </div>
    </div>
    <div class="footer"></div>
</div>

<script type="text/javascript">

</script>
</body>
</html>