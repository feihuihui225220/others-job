<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script>
	function doSubmit(type) {
		//before commit must do calc  提交请求需判断是否已经统计
		
		if(type == 1) {
			if(document.getElementById("type").value != '3') {
				alert("提交前需要进行数据统计！");
				return false;
			}		
		} 
		
		
		//check form
		var start = document.getElementById("start").value;
		var end = document.getElementById("end").value;
		if(start == '' || end == ''){
			alert("请选择时间范围！");
			return false;
		}else if(start > end){
			alert("开始时间不能大于结束时间！");
			return false;
		}
		
		if(type == 1) {
			var question = document.getElementById("question").value;
			var evaluation = document.getElementById("evaluation").value;
			if(question == '' || evaluation == ''){
				alert("信息不完整!");
				return false;
			}
		}
		//change type value
		document.getElementById("type").value = type;
		//commit
		document.getElementById("evaForm").submit();
	}
</script>
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
.input_empty {border:0 none;background:#FFF;width:1em}
.input_empty:focus{outline:0 none;}
.reg_area{margin:10px auto;width:auto;}
body{background:#D9EBEB;}
</style>
</head>
<body >
<div class="  ">
    <form id="evaForm" method="post" action="/professional/vender/tab/eva/commit" AutoScroll=false style="height:900px;">
    	<input type="hidden" id="type" name="type" value="$!{type}" />
    	<input type="hidden" name="venderId" value="${venderId}" />
        <h2>服务商评价报告</h2>
        <div class="mask_contact pad10">
            <h4>选择时间段：</h4>
            <ul class="inpubox clearfix">
                <li><label>开始：</label> <input class="text150 timedate" type="text" id="start" name="startTime" value="$!date.format('yyyy-MM-dd',$!venderEvaVO.startTime)" /></li>
                <li><label>结束：</label> <input class="text150 timedate" type="text" id="end" name="endTime" value="$!date.format('yyyy-MM-dd',$!venderEvaVO.endTime)" /></li>
                <li><input class="button_gm" type="button" value="统计"  onclick="doSubmit(0)"/></li>
            </ul>
        </div>
        <div class="mask_contact pad10">
            <h4>一、基本统计数据</h4>
            <div class="fix_car">
                <span>当前服务人数：<input type="text" class="input_empty" name="serverCount" value="#if(!$venderEvaVO.serverCount) 0 #else $venderEvaVO.serverCount #end" />人</span>
                <span>当前新增人数：<input type="text" class="input_empty" name="incCount" value="#if(!$venderEvaVO.incCount) 0 #else $venderEvaVO.incCount #end" />人</span>
                <span>当前减少人数：<input type="text" class="input_empty" name="dincCount" value="#if(!$venderEvaVO.dincCount) 0 #else $venderEvaVO.dincCount #end" />人</span>
                <b>注：当前服务人数表示该服务提供商所管辖的老年人数量，该部分数据由选择时间段后计算得到</b>
            </div>
        </div>
        <div class="mask_contact pad10">
            <h4>二、问题及建议</h4>
            <div class="fix_car">
                <textarea id="question" name="question" cols="72" rows="8"></textarea>
            </div>
        </div>
        <div class="mask_contact pad10">
            <h4>三、评价结论</h4>
            <div class="fix_car">
                星级：<select name="star">
                    <option value="5">★★★★★</option>
                    <option value="4">★★★★</option>
                    <option value="3">★★★</option>
                    <option value="2">★★</option>
                    <option value="1">★</option>
                </select><br />
                <textarea id="evaluation" name="evaluation" cols="72" rows="8" placeholder="评论内容"></textarea>
            </div>
        </div>
        <p class="opt">
        	<button type="button" class="btn button_delete" onclick="javascript:history.go(-1)">取 消</button>
        	<button type="button" class="btn button_add" onclick="doSubmit(1)">添 加</button>
        </p>
    </form>
    <div class="footer">
        
    </div>
</div>
<script type="text/javascript" src="js/lhgcalendar.min.js"></script>
<script>
$('.timedate').calendar({ format:'yyyy-MM-dd', zIndex:222222222});


</script>
</body>
</html>