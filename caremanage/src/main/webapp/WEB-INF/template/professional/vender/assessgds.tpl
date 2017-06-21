<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>condition</title>
 	<link rel="stylesheet" href="/assets/css/common.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <style type="text/css">
    *{padding:0; margin:0;}
    .condition{padding:20px;}
    .condition .condition-right{margin-left:20px;}
    .condition .pheight35{height:35px;line-height:35px;margin:0px auto 0 20px;}
    .condition .pheight100{margin:5px auto 0 20px;}
    .condition-left{width:310px;}
    .marginright10{margin-right:10px;}
    .marginbottom15{margin-bottom:15px;}
    .labelwidth106{display:inline-block;width:106px;}
    .labelwidth88{display:inline-block;width:88px;}
    .in_left{margin-left:58px;}
    .condition h3 {
        color: #43bef8;
    }
    
    .fl {
        float: left;
    }
    
    .fr {
        float: right;
    }
    .clearfix:after{
        content:"";
        display:block;
        height:0;
        visibility:hidden;
        clear:both;
    }
		.clearfix{zoom:1;}
		.inputwidth80{width: 180px;height: 30px;border: 1px solid #b7b7b7;border-radius: 5px;}
        .other{margin-top:10px;}
    </style>
</head>

<body>
    <div class="condition clearfix">
        <div class="condition-left fl">
            <form id="submit" action="/professional/assessgds/gds" method="post" >
	            <input type="hidden" name="userId" value="$userId">
	            <div class="family">
	                <h3>家族史</h3>
	                <p class="pheight100">
	                    <label class="marginbottom15">高血压
	                        <input type="checkbox" name="hbp" class="marginright10 marginbottom15">
	                    </label>
	                    <label class="marginbottom15">糖尿病
	                        <input type="checkbox" name="dm" class="marginright10 marginbottom15">
	                    </label>
	                    <label class="marginbottom15">高血脂
	                        <input type="checkbox" name="dsLip" class="marginright10 marginbottom15">
	                    </label><br>
	                    <label>&lt;55/65岁心梗
	                        <input type="checkbox" name="qmi" class="marginright10">
	                    </label>
	                    <label>&lt;55/65岁脑卒中
	                        <input type="checkbox" name="stroke" class="marginright10">
	                    </label>
	                </p>
	            </div>
	            <div class="other">
	                <h3>相关情况</h3>
	                <p class="pheight35">
	                    <label>吸烟
	                        <input type="checkbox" name="smoke" >
	                    </label>
	                <p class="pheight35">
	                		<label class="labelwidth88">饮酒杯数/日</label>
	                    <input type="text" maxlength="4" data-value="饮酒杯数/日" name="drink" class="inputwidth80" >
	                </p>
	                </p>
	            </div>
	            <div class="healthexam">
	                <h3>体检</h3>
	                <p class="pheight35">
	                    <label class="labelwidth88">身高(cm)</label>
	                    <input type="text" placeholder="60-260"   min=60 max=260 name="height" class="inputwidth80">
	                </p>
	                <p class="pheight35">
	                    <label class="labelwidth88">体重(Kg)</label>
	                    <input type="text" placeholder="20-250"  min=20 max=250 name="weight" class="inputwidth80">
	                </p>
	                <p class="pheight35">
	                    <label class="labelwidth88">脉搏(次)</label>
	                    <input type="text"  placeholder="25-250" min=25 max=250 name="pulse" class="inputwidth80">
	                </p>
	            </div>
	        </div>
	        <div class="condition-right fl">
	            <div class="bloodpressure">
	                <h3>血压</h3>
	                <p class="pheight35">
	                    <label class="labelwidth106">收缩压(高压)</label>
	                    <input type="text" placeholder="70-256"  min=70 max=256 name="sbp" class="inputwidth80">
	                </p>
	                <p class="pheight35">
	                    <label class="labelwidth106">舒张压(低压)</label>
	                    <input type=text placeholder="30-160" name="dbp" min=30 max=160 class="inputwidth80">
	                </p>
	            </div>
	            <div class="bloodsugar">
	                <h3>血糖</h3>
	                <p class="pheight35">
	                	<label class="labelwidth106">空腹血糖(FPG)</label>
	                	<input type=text placeholder="2-30 或 40-3000"  min=30 max=160 name="fpg" class="inputwidth80 ">
	                </p>
	            </div>
	            <div class="bloodfat">
	                <h3>血脂</h3>
	                <p class="pheight35">
	                    <label class="labelwidth106">TC(总胆固醇)</label>
	                    <input type="text" placeholder="0.5-30 或 40-3000" min=0 name="tc" class="inputwidth80">
	                </p>
	                <p class="pheight35">
	                    <label class="labelwidth106">LDLC(低密度)</label>
	                    <input type="text" placeholder="0.3-30 或 40-3000" min=0 name="ldlc" class="inputwidth80">
	                </p>
	                <p class="pheight35">
	                    <label class="labelwidth106">HDLC(高密度)</label>
	                    <input type="text" placeholder="0.3-10 或 20-300" min=0 name="hdlc" class="inputwidth80">
	                </p>
	                <p class="pheight35">
	                    <label class="labelwidth106">TG(甘油三脂)</label>
	                    <input type="text" placeholder="0.3-30 或 40-3000" min=0 name="tg" class="inputwidth80">
	                </p>
	            </div><br><br>
	            <input type="button" value="提交" class="ibtn button_add submit_">
	            <input type="button" value="取消" class="ibtn button_add in_left"  onclick="javascript:history.go(-1);">
             </form>
        </div>
    </div>
</body>
<script>
$(function(){
	$('.submit_').click(function(){
		var bool=false;
		$("input[type='text']").each(function(){
			if($(this).val()!=""&&$(this).attr("data-value")!="饮酒杯数/日"){
				bool=true;
			}
		});
		if(bool==true){
			$('#submit').submit();
			return false;
		}
		alert("体检、血压、血糖、血脂中至少填写一条实测数据！");
	});
	$("input[type='text']").bind("change",function(){
		if(!/^\d+(\.\d+)?$/.test($(this).val())){
        	alert("请输入数字!");
        	$(this).val("");
        }
	});
	
});
</script>
</html>
