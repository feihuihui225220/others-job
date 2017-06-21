<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>评估量表</title> #parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<style>
.input165 {
    width: 165px;
    height: 30px;
}

#jindu {
    width: 80%;
    position: relative;
    top: -18px;
    left: 62px;
}

.black_overlay {
    display: none;
    position: absolute;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: black;
    z-index: 1001;
    -moz-opacity: 0.8;
    opacity: .80;
    filter: alpha(opacity = 80);
}

.white_content {
    display: none;
    position: absolute;
    top: 25%;
    left: 32%;
    width: 30%;
    height: 10%;
    padding: 16px;
    background-color: white;
    z-index: 1002;
    overflow: auto;
}
.btn{float: left;margin-right: 20px;}
</style>
</head>
<body>
    <div class="wrapper">
        #parse("/common/head.tpl")
        <div class="body bodyline">
            <form id="formzf" action="/ICareFitness/Conclusion/update"   method="post">
                <input type="hidden" name="id" value="$zfit.id">
                <input type="hidden" name="fitnessId" value="$zfit.fitnessId">
                 <select name="comboId">
                #foreach($n in $combo)
                        <option #if($zfit.comboId==$n.comboId)  selected="selected" #end value="$n.comboId">$n.comboName</option>
                #end
                </select><br><br><br>
                <input id="add" class="btn button_gm" type="submit" value="编辑">
                <input id="delete" class="btn button_delete" type="button" value="取消">
            </form>
        </div>
        <div id="fade" class="black_overlay">
            <div class="footer"></div>
        </div>
</body>
</html>