<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>课程内容</title>
   	#parse("/common/top.tpl")
   	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
	<script src="/assets/newJs/nProgram.js"></script>
	<link rel="stylesheet" href="/assets/newCss/index.css" />
    <style>
    
    	.course{width:60%;margin-top:10px;}
    	.add_first{margin-right:20px;}
    	.guanjianci{height:27px;}
    	
	</style>
</head>
<body>
	<div class="wrapper">
			#parse("/common/head.tpl")
			<div class="main">
		        #parse("/common/providers.tpl")
		<div id="right">
				<form action="/professional/fete/programSelect" method="post" name="programSelect">
				<input type="button" class="btn-default add_first add_class btn" value="添加课件"/>
				<input  class="guanjianci" placeholder="按关键词搜索" name="keyword" value="$!keyword"/><input type="submit" class="btn-default add_first  btn" value="搜索"/>
				<input type="button" class="btn-default  add_first btn fanhui"  value="返回上一页"/>
				<input id="id_" type="hidden" name="id" value="$nProgram.id"/>
				<div class="course">
					<table class="table _tale1">
						<tr  class="_active">
							<th>序号</th>
							<th>课件名称</th>
							<th>特征标签</th>
							<th>课件视频</th>
							<th>编辑详情</th>
							<th>操作</th>
						</tr>
						#foreach($n in $page.result)
						 #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
        				<tr id="$n.id" class=" #if($i%2!=0 ) tr_two #else tr_first #end"data-id="$!e.id">
							<td>$i</td>
							<td>$n.programName</td>
							<td>$n.programTime</td>
							<td>点击查看</td>
							<td><a href="/professional/fete/gpupdate?id=$n.id">修改</a></td>
							<td userid=$n.id class="deluser">删除</td>
						</tr>
						
						#end
					</table>
					</form>
					 #parse("/common/page.tpl")
				</div>		
	        </div> 
		</div>
	</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript">
   $(".deluser").click(function(){
       
        // 阻止事件向上冒泡
        //event.stopPropagation();
         var mid = $(this).attr("userid");
        layer.confirm('是否确定删除该课程?', function(index){
        	$.get("/professional/fete/delete/"+mid,function(result){
    			if(result=='success'){
	    			// 移除记录
		          $('#'+mid).remove();
    			}
    			layer.close(index);
  			});
        }, function(index){
            //console.log(index);
        });
        
        
    });
    $('.fanhui').click(function(){
    	location.href="/professional/fete";
    });
  </script>
</body>
</html>