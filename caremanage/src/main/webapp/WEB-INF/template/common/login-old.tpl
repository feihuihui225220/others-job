<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>登 录</title>
<link rel="stylesheet" href="/assets/css/login.css" />
<!--[if IE 6]>
<script type="text/javascript" src="/assets/js/DD_belatedPNG_0.0.8a-min.js"></script>
<script>
DD_belatedPNG.fix('.ie6png','background-image');
</script>
<![endif]-->
</head>
<body>
<s class="ie6png"></s>

<form method="post" action="/permission/login">
<div class=" login_area">
<div class="login_area2 ie6png"></div>
    <input name="name" class="user_name" />
    <input name="password" class="user_pass" type="password" />
    <select name="userCategory">
    	#foreach ($category in $userCategorys)
	        <option value="${category}">${category.name}</option>
        #end
    </select>
    <button type="submit">登 录</button>
    <a href="/permission/toReg">激 活</a>
</div>
</form>

</body>
</html>