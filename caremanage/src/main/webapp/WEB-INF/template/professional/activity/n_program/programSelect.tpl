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
	<script src="/assets/js/pageNavigator.js"></script>
	<link rel="stylesheet" href="/assets/newCss/index.css" />
    <style>
    
    	.course{width:60%;margin-top:10px;}
    	.add_first{margin-right:20px;}
    	.guanjianci{height:27px;}
    	
		.course{margin-left:10%;margin-top:20px;}	
		.void_click{cursor: pointer;}
		.deluser{cursor: pointer;}
	</style>
</head>
<body>
	<div class="wrapper">
			#parse("/common/head.tpl")
		<div class="location"><span class="currentlocation">当前位置：</span><span>首页</span><span>&gt;课程管理</span>
			#if($!{sessionUser.isSuper_()}==true)
		<div class="main">
		        #parse("/common/providers.tpl")
		<div id="right">
		#else
		  <div class="courseMain">
	        <div class="course">
		#end
				
		<form action="/professional/fete/programSelect" method="post" name="searchForm">
				<input type="button" class="btn-default add_first add_class btn" value="添加课件"/>
				<input  class="guanjianci" placeholder="按关键词搜索" name="keyword" value="$!keyword"/><input type="submit" class="btn-default add_first  btn" value="搜索"/>
				#if($!{sessionUser.isSuper_()}==true)
				<input type="button" class="btn-default  add_first btn fanhui"  value="返回上一页"/>
        		#end
				<input id="id_" type="hidden" name="id" value="$nProgram.id"/>
				<input type="button" class="btn-default  add_first btn "  onclick="location.href='/professional/fete/tovoid?parentId=$nProgram.id'" value="添加视频">
				<div class="table" >
					<table class="table _tale1" style="width:60%">
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
							<td  class="void_click" data-url="$n.aviUrl">点击查看</td>
							<td><a href="/professional/fete/gpupdate?id=$n.id">修改</a></td>
							<td userid=$n.id class="deluser">删除</td>
						</tr>
						
						#end
					</table>
					</form>
					 #parse("/common/page.tpl")
				</div>
				<div class="div_void" style="float:right;position: absolute;top:158px;right:120px;  display:none" >
				<video id="videoid" width="320" height="240" controls>
				  <source  src="movie.mp4" type="video/mp4">
				  <source src="movie.ogg" type="video/ogg">
				  <source src="movie.webm" type="video/webm">
				  <object data="movie.mp4" width="320" height="240">
				    <embed src="movie.swf" width="320" height="240">
			  	</object> 
				</div>
                </video>		
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
    $('.void_click').click(function(){
    	var url=$(this).attr('data-url');
    	  document.getElementById("videoid").src=url;
    	$('.div_void').show();
    });
    
    $('.fanhui').click(function(){
    	location.href="/professional/fete";
    });
  </script>
</body>
</html>