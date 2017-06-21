<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="refresh" content="5;url=permission/toLogin">
<script type="text/javascript">
	function countDown(secs, surl) {
		var jumpTo = document.getElementById('jumpTo');
		jumpTo.innerHTML = secs;
		if (--secs > 0) {
			setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
		} else {
			window.parent.location = surl;
			-ma;
		}
	}
</script>
</head>
<body>
	<h2>登录超时</h2>
	<p>当前登录状态已失效。</p>
	<a href="permission/toLogin"><span id="jumpTo">5</span>秒后系统会自动跳转，也可点击本处直接跳</a>
	<script type="text/javascript">
		countDown(3, 'permission/toLogin');
	</script>
</body>
</html>
