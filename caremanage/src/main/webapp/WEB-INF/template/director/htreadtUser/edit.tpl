<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>治疗申请</title>
<link href="/assets/director/styles/style.css" rel="stylesheet" type="text/css">
<link href="/assets/director/styles/dirAssociate.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/assets/director/styles/table.css" type="text/css">
</head>
<style>
</style>
<body>
#parse("/common/dtop.tpl")
#parse("/common/duser.tpl")
<div class="main1">
#parse("/common/dleft.tpl")
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
<div id="table_w" >
					<div class="personInfo_right fl" style="float: left;">
						<form action="/director/htreatuser/save" method="post" name="form" id="form">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tbody>
								    <input type="hidden" name="userId" value="$!userId">
									<!--<tr>
										<td align="right"><strong>治疗类型：</strong></td>
										<td align="left"><input type="text" name="state" class="txt_input" style="height:30px;" placeholder="治疗类型"></td>
									</tr>-->
									<tr>
										<td align="right"><strong>治疗需求：</strong></td>
										<td align="left">
											<textarea  rows="3" cols="30" id="des"  placeholder="请填写治疗需求"></textarea>
										</td>
								        <input type="hidden" name="desired" id="desired" />
									</tr>
									<tr>
										<td>
										</td>
										<td><input  type="button" class="btnBg btn_cancle_sub" value="确定">
											<input type="reset" onclick="history.go(-1)" class="btnBg btn_cancle" value="取消"></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
</div>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/country_1.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script>
$(function(){
	$('.btn_cancle_sub').click(function(){
		var $des=$("#des").val();
		$("#desired").val($des);
		$('#form').submit();
	});
	
});


</script>
</body>
</html>