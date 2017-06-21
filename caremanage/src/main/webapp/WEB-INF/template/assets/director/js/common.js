$(document).ready(function(){
	 
	$('.personTitle_right .huizhen').click(function(){
		$('.mask').show();
		$('.huizhenReason').show();
	});
	$('.personTitle_right .zhuanzhen').click(function(){
		$('.mask').show();
		$('.zhuanzhenReason').show();
	});
	$('.personTitle_right .zhiliao').click(function(){
		$('.mask').show();
		$('.zhiliaoReason').show();
	});
	$('.personTitle_right .shouye').click(function(){
		window.location.href='index.html';
	});

	$('.huizhenReason .close,.huizhenReason .cancel').click(function(){
		$('.mask').hide();
		$('.huizhenReason').hide();
	});
	$('.zhuanzhenReason .close,.zhuanzhenReason .cancel').click(function(){
		$('.mask').hide();
		$('.zhuanzhenReason').hide();
	});
	$('.zhiliaoReason .close,.zhiliaoReason .cancel').click(function(){
		$('.mask').hide();
		$('.zhiliaoReason').hide();
	});
// 用户信息页面 加号 事件——添加姓名、电话
	$('.emergency .increase').click(function(){
		$('.emergency').append("<p class='fl'><label>姓名:</label><input type='text' class='input1'/><label>电话:</label><input type='text' class='input2'/></p>  ");
	});

});