$(document).ready(function() {
		
		// li 单击左右添加事件
		$('.xzul1').on("click","li",function(){
			var text=$(this).text();
			$(this).remove();
			$(".xzul2").append(" <li >"+text+"</li>");
		});

		$(".xzul2").on("click","li", function() {
     	var text1=$(this).text();
			$(this).remove();
			$(".xzul1").append(" <li >"+text1+"</li>");
		 });
    $('.commonTable .delete').click(function(){
    	if(confirm("确认删除吗？")){
    		$(this).parent().parent().remove();
    	}
    	else{
    		return;
    	}
    });
    // 新建巡诊弹框
    $('.newXunzhen').click(function(){
    	$('.mask').show();
    	$('.Detail').show();
    });
    $('.Detail .close').click(function(){
    	$('.mask').hide();
    	$('.Detail').hide();
    });

	});