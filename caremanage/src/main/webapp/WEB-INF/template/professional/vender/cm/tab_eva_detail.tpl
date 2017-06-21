<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<style>
.inpubox li {width:290px;}
.mask_contact {padding-top:20px;}
.mask_contact table {width:72%;margin-left:112px;}
.mask_contact table a {color:#333;}
.mask_contact .inpubox li.w520 {width:640px;}
.mask_contact h4 {margin-bottom:15px;}
.col2 {width:6em;}
.fix_car {padding-left:112px;margin-bottom:15px;}
.fix_car span {display:block;margin-bottom:15px;}
.fix_car b {color:#678678;font-weight:normal;}
.fix_car textarea {padding:5px;}
.fix_car select {margin-bottom:20px;}
.mask_contact p {border:0 none;padding:0;}
</style>
</head>
<body>
<div class="wrapper">
        <h2>${venderName}服务商评价报告</h2>
        <div class="mask_contact pad10">
            <h4>时间段：</h4>
            <ul class="inpubox clearfix">
                <li>$!date.format('yyyy-MM-dd',$!venderEvaluation.startTime) —— $!date.format('yyyy-MM-dd',$!venderEvaluation.endTime)</li>
            </ul>
        </div>
        <div class="mask_contact pad10">
            <h4>一、基本统计数据</h4>
            <div class="fix_car">
                <span>当前服务人数：${venderEvaluation.serverCount}人</span>
                <span>当前新增人数：${venderEvaluation.incCount}人</span>
                <span>当前减少人数：${venderEvaluation.dincCount}人</span>
            </div>
        </div>
        <div class="mask_contact pad10">
            <h4>二、问题及建议</h4>
            <div class="fix_car">
                <p>${venderEvaluation.question}</p>
            </div>
        </div>
        <div class="mask_contact pad10">
            <h4>三、评价结论</h4>
            <div class="fix_car">
                        星级：
	        #if($star > 0)
        		#foreach($i in [1..6])
        		★
	        		#if($i == $star)
	        			#break;
	        		#end
        		#end
    		#end
            <br /><br />
            <p>${venderEvaluation.evaluation}</p>
            </div>
        </div>
        <p class="opt"><button type="button" class="btn button_btn" onclick="javascript:history.go(-1)">返 回</button></p>
    <div class="footer">
    </div>
</div>
<script type="text/javascript" src="js/lhgcalendar.min.js"></script>
<script>
$('.timedate').calendar({ format:'yyyy-MM-dd', zIndex:222222222});
</script>
</body>
</html>