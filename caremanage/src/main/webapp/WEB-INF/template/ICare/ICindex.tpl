<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户首页-公用</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
</head>
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
<body>
#parse("/common/head.tpl")
  #parse("/ICare/ICmain.tpl")
</body>

</html>
 