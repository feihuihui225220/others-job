<html>
<head>
<meta charset="utf-8" />
<title>用户信息</title>
<script type="text/javascript" src="/assets/js/top.js"></script>
<link href="/assets/director/styles/common.css" rel="stylesheet" type="text/css">
<link href="/assets/director/styles/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/assets/director/styles/table.css" type="text/css">
</head>
<style>
button.pad5 {
	line-height: 16px\0;
}
</style>
<body>
#parse("/common/dtop.tpl")
#parse("/common/dleft.tpl")
	<div class="wrapper">
		<div class="body bodyline pad10">
			 个人信息
				 
				#set($user=$session.getAttribute("sessionUser"))
				 
		</div>
	</div>
	<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
	    $(".deluser").click(function(){
	        var userid = $(this).attr("userid");
	        layer.confirm('是否确定删除该员工?', function(index){
	            $.get("/director/removeUser/"+userid,function(result){
	    			if(result=='success'){
		    			// 移除记录
	            		$('.userid_'+userid).remove();
	    			}
	  			});
	            layer.close(index);
	        }, function(index){
	            //console.log(index);
	        });
	    });// 
	    
	    $(".delsite").click(function(){
	        var mid = $(this).attr("mid");
	        layer.confirm('是否确定删除站点信息?', function(index){
	            $.get("/professional/vender/site/delete?id="+mid,function(result){
	    			if(result=='success'){
		    			// 移除记录
	            		$('.mid_'+mid).remove();
	    			}
	  			});
	            layer.close(index);
	        }, function(index){
	            //console.log(index);
	        });
	    });
	});
</script>
</body>
</html>
