<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>修改密码</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/reg.css" />
	<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
</head>
<body>
<div class="wrapper">
	#parse("/common/head.tpl")
    <div class="body">
        <form method="post" action="/permission/resetPass" class="reg_area fix_reg">
            <h2>修改密码</h2>
            <dl>
			<input type="password" name="password1"  style="display:none"/>
                <dt>原密码：</dt>
                <dd><input type="password" name="oldPass" autocomplete="off"/></dd>
                <dt>新密码：</dt>
                <dd><input type="password" name="newPass" autocomplete="off"/></dd>
                <dt>确认密码：</dt>
                <dd><input type="password" name="newPass2" autocomplete="off"/></dd>
            </dl>
            <span style="font-size:12px;color:red">$!{msg}</span>
            <p><button type="submit" class="btn  button_gm">修 改</button></p>
        </form>
    </div>
    <div class="footer">
    </div>
</div>

<script>
	$("[name='oldPass']").val('');
	$("[name='newPass']").val('');
	$("[name='newPass2']").val('');
    $('button').click(function () {
        if ($('input:eq(1)').val() != $('input:eq(2)').val()) {
            alert('两次输入的密码不一致');
            return false;
        }
    });

</script>
</body>
</html>