<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/reg.css" />
<script src="js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
    #parse("/common/top.tpl")
    <div class="body">
        <div class="reg_area fix_error">
            <h2>页面提示</h2>
            <div>
                <h1>提示信息</h1>
                <p>$!{ex.message}</p>
                <button type="button" class="button_btn" onclick="javascript:history.go(-1)">返 回</button>
            </div>
        </div>
    </div>
    <div class="footer">
        
    </div>
</div>

</body>
</html>