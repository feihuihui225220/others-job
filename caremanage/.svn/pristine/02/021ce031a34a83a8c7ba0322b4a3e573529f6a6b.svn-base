<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>编辑巡诊组</title>
<link rel="stylesheet" href="../assets/plugins/css/bootstrap.min.css">
<link rel="stylesheet" href="/assets/director/styles/table.css" type="text/css">
</head>
<style>
</style>
<body>
#parse("/common/dtop.tpl")
#parse("/common/dmain.tpl")
<div class="">
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
					<div class="new_user_dj" style="float:left;margin:20px;">
						<form action="/group/edit" method="post" name="form" id="form">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tbody>
									<tr><input type="hidden" name="id" value="$group.id">
										<td align="right"><strong>巡诊组名称：</strong></td>
										<td align="left"><input type="text" name="userName"  value="$!group.userName" readonly="readonly"  class="txt_input" placeholder="请填写巡诊组名称"></td>
									</tr>
									<tr>
										<td align="right"><strong>医生：</strong></td>
										<td align="left">
											<input type="text" name="doctor" class="input1" value="$!group.doctor" placeholder="请填写医生名称"></td>
										</td>
									</tr>
									<tr>
										<td align="right"><strong>护士：</strong></td>
										<td align="left">
											<input type="text" name="nurse" class="input1" value="$!group.nurse" placeholder="请填写护士名称"></td>
										</td>
									</tr>
									<tr><input type="hidden"   name="community" class="community_">
										<td><input  type="hidden" class="txt_input text_com" value="$!group.community">
										</td>
										<td><input  type="button" class="btn_cancle btn_cancle_sub btnBg" value="确定">
											<input type="button"  class="btnBg btnBg1 cancel_all" onclick="history.back();" value="取消"></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
					<h4 style="color:red;">提示：双击添加社区/双击取消社区</h4>
		<div style="float:left;border: 1px solid black;margin:20px;">
				<select class="select1" multiple="multiple" style="width:200px;height:265px;margin-right:30px;">
					#foreach($o in $oCountry)
						<option class="option1">$!o.name</option>
					#end
				</select>
				
				<select class="select2" multiple="multiple" style="width:200px;height:265px;">
				</select>
		</div>
		 <div style="float:left; position: relative;left: -254px;top:110px">
				 添加<br>
				 ----><br>
				 取消<br>
				 <----
		 </div>
</div>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="../../assets/js/bootstrap.min.js"></script>
<script src="/assets/js/country_1.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script>
$(function(){
	$(".main .main_left .sidebar li a").eq(3).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
	$(".select1").dblclick(function(){
   	   $(".select2").append( $(".select1 option:selected"));
    });
    $(".select2").dblclick(function(){
   	   $(".select1").append( $(".select2 option:selected"));
    });
    
	var array=$('.text_com').val();
	var arr=array.split(",");
	for(var i=0;i<arr.length;i++){
		var option=$('<option >'+arr[i]+'</option>');
		 $(".select2").append(option);
	}
	
	$('.btn_cancle_sub').click(function(){
		var com="";
		$('.select2 option').each(function(){
			com+=$(this).val();
			com+=",";
		});
		if(com!=""){
			com=com.substring(0,com.length-1);
		}
		$('.community_').val(com);
		$('#form').submit();
	});
});


</script>
</body>
</html>