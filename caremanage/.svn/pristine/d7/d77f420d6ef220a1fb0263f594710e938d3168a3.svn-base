<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/reg.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
</head>
<body>

<div class="wrapper">
	#parse("/common/head.tpl")
    <form method="post" action="/community/user/saveContact" class="reg_area fix_pop" style="width:640px">
    <style>
    .mask_contact .inpubox li {width:280px;}
    .mask_contact .inpubox li.w520 {width:570px;}
    .mask_contact .inpubox li.w520 input{width:440px;}
    .mask_contact .inpubox .select160 {height:auto;line-height:auto;}
    </style>
        <h2>添加联系人</h2> 
        <div class="mask_contact pad10">
        	<input type="hidden" name="id" value="$!id">
            <ul class="inpubox clearfix">
                <li><label>姓名：</label><input class="text150" name="name" type="text" /></li>
                <li><label>身份证号：</label><input class="text150" name="idCardNo" type="text" /></li>
                <li>
                	<label>性别：</label><select name="gender" id="">
                		<option value="0">女</option>
            			<option value="1">男</option>
                	</select>
                </li>
                <li><label>出生日期：</label><input class="text150 timedate" readonly="true" maxlength="10" name="birthday" type="text" /></li>
                <li>
                	<label>与用户关系：</label><select name="relation" id="">
	            		#foreach($!k in $!categorys.keySet())
	            			<option value="$!categorys.get($k).id">$!categorys.get($k).itemName</option>
	            		#end
            		</select>
                </li>
                <li><label>手机：</label><input class="text150" type="text" name="mobilePhone" /></li>
                <li class="w520"><label>居住地址：</label><input class="text150" type="text" name="addr" /></li>
            </ul>
            <!--div class="centerbtn pad10"><button class="button_btn" type="submit">保存</button><button class="pad5 contact_closed">取消</button></div-->
        </div>
        <p class="opt">
			<button class="btn button_btn" type="button" onclick='window.location.href="/community/user/detail/$!id" '>取 消</button>
        	<button type="submit" class="btn  button_btn">添 加</button>
        </p>
    </form>
    <div class="footer"/>
</div>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".timedate").calendar({ format:'yyyy-MM-dd' });
});
</script>
</body>
</html>