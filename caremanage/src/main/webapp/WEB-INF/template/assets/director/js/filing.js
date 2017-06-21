$(document).ready(function(){
	$('input').attr("disabled",true);
	$('.personInfo_righttop .save').click(function(){
		$('input').attr("disabled",false);
		$(this).css('background-image','url(./image/save.png)');
	});
});