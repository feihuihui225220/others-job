/*
 * 分页跳转js
 */
function pageNavigator(page){
	var action;//form action value.
	var form =  $("[name='searchForm']");
	action = $(form).attr("action");
	$(form).append("<input type='hidden' name='page' value='"+page+"'/>");
	$("#in_mask").show();
	$(form).attr("action", action).submit();
}

function orderBy(column){
	var action;//form action value.
	var form =  $("[name='searchForm']");// 需要排序的form名
	action = $(form).attr("action");
	var orderBy = $("#orderBy").val();// 隐藏域的本次排序
	var sort = $("#sort").val();// 隐藏域的本次排序
	if(sort.indexOf(-1) != -1){
		$("[name='searchForm.orderBy']").attr("value", column);
		$("[name='searchForm.sort']").attr("value", 1);
	}else{
		$("[name='searchForm.orderBy']").attr("value", column);
		$("[name='searchForm.sort']").attr("value", -1);
	}
	$("#in_mask").show();
	$(form).attr("action", action).submit();
}
