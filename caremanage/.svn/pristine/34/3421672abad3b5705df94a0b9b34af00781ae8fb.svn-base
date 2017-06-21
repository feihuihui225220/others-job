<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>专业服务-客户管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css">
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script>
$(function(){
 $(".timedate").calendar({ format:'yyyy-MM-dd' });
})
</script>
<style>
	.th_wid{width:80px;}
	.tablebox{width:97%}
	.mux_a{ background:#4AC6CE;}
	.margin_top{margin-top:20px;}
	#select{width:120px;}
	select{height:25px;}
	#conclusion{width:120px;}
	#if($sessionUser.cateEnum.type==3)
		#left{background-color: #16A5AD;}
		.nav1{background-color: #16A5AD;}
		.a_Special_4{position: relative;top: -45px;color: #F7FCFC;}
	#end
	#left{height:115%;}
	.table100{margin-left:30px;}
	.click_td{cursor:pointer;}
	tr .click_td:hover{background-color: #16A5AD;}
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
       <div id="left">
	        #parse("/common/providers.tpl")
       </div>
   <div class="main">
    <div >
    <div id="right">  
        <div class="searchli margin_top">
        	<form action="/assess/finance" method="post" name="searchForm">
	            <ul class="inpubox clearfix margin_top left_ul">
					<li><label>检验方式:</label>
					<select name="ModelingCategory" class="text150 ModelingCategory">
						<option value="-1">请选择</option>
						<option value="0">t检验单项服务检验</option>
						<option value="1">不同特征的群体独立样本t检验</option>
						<option value="2">卡方独立性检验</option>
						<option value="3">卡方统一性检验</option>
						<option value="4">单因素方差分析</option>
						<option value="5">双因素方差分析</option>
					</select>
					</li>
					<li><label>影响因素:</label>
					<select name="choice" class="text150 choice">
						<option value="-1">请选择</option>
						<option value="1">日常生活自理能力</option>
						<option value="2">工具性活动能力</option>
						<option value="3">身体成分</option>
						<option value="4">肌力得分</option>
						<option value="5">心肺耐力</option>
						<option value="6">柔软素质</option>
						<option value="7">神经反应能力</option>
						<option value="8">血压</option>
						<option value="9">定向力</option>
						<option value="10">注意力与集中力</option>
						<option value="11">记忆力</option>
						<option value="12">回忆力</option>
						<option value="13">抽象思维</option>
						<option value="14">视结构</option>
						<option value="15">执行能力</option>
						<option value="16">计算力</option>
						<option value="17">心理素质</option>
						<option value="18">语言能力</option>
					</select>
					<select name="TimeFactor" class="text150 TimeFactor">
						<option value="-1">请选择</option>
						<option value="0">性别</option>
						<option value="1">婚姻状况</option>
						<option value="2">文化程度</option>
						<option value="3">从业状况</option>
						<option value="4">宗教</option>
						<option value="5">失能与否</option>
						<option value="6">经济来源</option>
						<option value="7">过去职业</option>
						<option value="8">年龄</option>
						<option value="9">神经反应能力</option>
					</select>
					<select name="ageds" class="text150  ageds" style="display:none;">
						<option value="-1">请选择</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
					</select>
					</li>
					<li><label>显著水平:</label>
					<select name="a" class="text150 a_lin">
						<option value="-1">请选择</option>
						<option value="0.01">0.01</option>
						<option value="0.05">0.05</option>
						<option value="0.10">0.10</option>
					</select>
					</li><br><br>
					<li class="li_hise1"><label>人员分组:</label>
					<select name="group1" class="text150 group1">
						<option value="-1">请选择</option>
						<option value="1">头脑体操干预组</option>
						<option value="2">体适能训练干预组</option>
						<option value="3">混合组</option>
						<option value="4">对照组</option>
						
					</select>
					<select name="group2" class="text150 group2">
						<option value="-1">请选择</option>
						<option value="1">头脑体操干预组</option>
						<option value="2">体适能训练干预组</option>
						<option value="3">混合组</option>
						<option value="4">对照组</option>
					</select>
					</li>
					<li><label>时间:</label>
					<input id="stat" class="text150 timedate" type="text" name="start"
                                                             value="$!date.format('yyyy-MM-dd',$!dateCond.start)">
       				<label>- </label><input id="ed" class="text150 timedate" type="text" name="end"
                                value="$!date.format('yyyy-MM-dd',$!dateCond.end)">
					</li><br><br>
	                <li><input class="ibtn button_gm" type="submit" value="分析"></li>
	                 <li><input class="ibtn button_gm export" type="button" value="导出"></li>
	            </ul>
            </form>
        </div>
        <div class="actboxlist">
            <table class="table100 usertable  trclick ">
            	<tr>
            		<th rowspan="2">一级指标</th>
            		<th rowspan="2">二级指标</th>
            		<th rowspan="2">均值提高</th>
            		<th colspan="3" >检验方式</th>
            	</tr>
            	<tr>
            		<th>t检验</th>
            		<th>卡方检验</th>
            		<th>方差分析</th>
            	</tr>
            	<!--  体适能  -->
            	#if($assess1||$assess2||$assess3||$assess4||$assess5||$assess6||$assess7||$assess8)
            	 <tr >
                	<td rowspan="8">体适能</td>
                	#if($assess1)
                	<td class="click_td" date-itemizeId ="$assess1.itemizeId">日常生活自理能力</td>
                	<td class="click_td" date-itemizeId ="$assess1.itemizeId"> $number.format("#0.00",$assess1.average)</td>
                	<td class="click_td" date-itemizeId ="$assess1.itemizeId">#if($assess1.testValue1&&$assess1.testValue1>$assess1.AValue)  + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess1.itemizeId">#if($assess1.kf&&$assess1.kf>$assess1.AValue) + #elseif($assess1.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess1.itemizeId">#if($assess1.f&&$assess1.f>$assess1.AValue) + #elseif($assess1.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess2)
                	<td class="click_td" date-itemizeId ="$assess2.itemizeId">工具性活动能力</td>
                	<td class="click_td" date-itemizeId ="$assess2.itemizeId"> $number.format("#0.00", $assess2.average)</td>
                	<td class="click_td" date-itemizeId ="$assess2.itemizeId">#if($assess2.testValue1&&$assess2.testValue1>$assess2.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess2.itemizeId">#if($assess2.kf&&$assess1.kf>$assess2.AValue) + #elseif($assess2.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess2.itemizeId">#if($assess2.f&&$assess1.f>$assess2.AValue) + #elseif($assess2.f) - #end</td>
                	#end
                </tr>
                 <tr>
                 	#if($assess3)
                	<td class="click_td" date-itemizeId ="$assess3.itemizeId">身体成分</td>
                	<td class="click_td" date-itemizeId ="$assess3.itemizeId">    $number.format("#0.00", $assess3.average)  </td>
                	<td class="click_td" date-itemizeId ="$assess3.itemizeId">#if($assess3.testValue1&&$assess3.testValue1>$assess3.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess3.itemizeId">#if($assess3.kf&&$assess3.kf>$assess3.AValue) + #elseif($assess3.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess3.itemizeId">#if($assess3.f&&$assess3.f>$assess3.AValue) + #elseif($assess3.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	
                	#if($assess4)
                	<td class="click_td" date-itemizeId ="$assess4.itemizeId">肌力及肌耐力</td>
                	<td class="click_td" date-itemizeId ="$assess4.itemizeId">  $number.format("#0.00", $assess4.average)</td>
                	<td class="click_td" date-itemizeId ="$assess4.itemizeId">#if($assess4.testValue1&&$assess4.testValue1>$assess4.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess4.itemizeId">#if($assess4.kf&&$assess4.kf>$assess4.AValue) + #elseif($assess4.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess4.itemizeId">#if($assess4.f&&$assess4.f>$assess4.AValue) + #elseif($assess4.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess5)
                	<td class="click_td" date-itemizeId ="$assess5.itemizeId">心肺耐力</td>
                	<td class="click_td" date-itemizeId ="$assess5.itemizeId">$number.format("#0.00", $assess5.average)</td>
                	<td class="click_td" date-itemizeId ="$assess5.itemizeId">#if($assess5.testValue1&&$assess5.testValue1>$assess5.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess5.itemizeId">#if($assess5.kf&&$assess5.kf>$assess5.AValue) + #elseif($assess5.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess5.itemizeId">#if($assess5.f&&$assess5.f>$assess5.AValue) + #elseif($assess5.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess6)
                	<td class="click_td" date-itemizeId ="$assess6.itemizeId">柔软素质</td>
                	<td class="click_td" date-itemizeId ="$assess6.itemizeId"> $number.format("#0.00",$assess6.average) </td>
                	<td class="click_td" date-itemizeId ="$assess6.itemizeId">#if($assess6.testValue1&&$assess6.testValue1>$assess6.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess6.itemizeId">#if($assess6.kf&&$assess6.kf>$assess6.AValue) + #elseif($assess6.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess6.itemizeId">#if($assess6.f&&$assess6.f>$assess6.AValue) + #elseif($assess6.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess7)
                	<td class="click_td" date-itemizeId ="$assess7.itemizeId">神经反应</td>
                	<td class="click_td" date-itemizeId ="$assess7.itemizeId">  $number.format("#0.00",$assess7.average)</td>
                	<td class="click_td" date-itemizeId ="$assess7.itemizeId">#if($assess7.testValue1&&$assess7.testValue1>$assess7.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess7.itemizeId">#if($assess7.kf&&$assess7.kf>$assess7.AValue) + #elseif($assess7.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess7.itemizeId">#if($assess7.f&&$assess7.f>$assess7.AValue) + #elseif($assess7.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess8)
                	<td class="click_td" date-itemizeId ="$assess8.itemizeId">血压</td>
                	<td class="click_td" date-itemizeId ="$assess8.itemizeId"> $number.format("#0.00",$assess8.itemizeId)</td>
                	<td class="click_td" date-itemizeId ="$assess8.itemizeId">#if($assess8.testValue1&&$assess8.testValue1>$assess8.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess8.itemizeId">#if($assess8.kf&&$assess8.kf>$assess8.AValue) + #elseif($assess8.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess8.itemizeId">#if($assess8.f&&$assess8.f>$assess8.AValue) + #elseif($assess8.f) - #end</td>
                	#end
                </tr>	
				#end
                <!-  认知功能  ->
            	#if($assess9||$assess10||$assess11||$assess12||$assess13||$assess14||$assess15||$assess16||$assess17||$assess18)
                 <tr>
                	<td rowspan="10">认知功能</td>
                	#if($assess9)
                	<td class="click_td" date-itemizeId ="$assess9.itemizeId">定向力（时间、地点）</td>
                	<td class="click_td" date-itemizeId ="$assess9.itemizeId"> $number.format("#0.00",$assess9.itemizeId)</td>
                	<td class="click_td" date-itemizeId ="$assess9.itemizeId">#if($assess9.testValue1&&$assess9.testValue1>$assess9.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess9.itemizeId">#if($assess9.kf&&$assess9.kf>$assess9.AValue) + #elseif($assess9.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess9.itemizeId">#if($assess9.f&&$assess9.f>$assess9.AValue) + #elseif($assess9.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess10)
                	<td class="click_td" date-itemizeId ="$assess10.itemizeId">注意力和集中力</td>
                	<td class="click_td" date-itemizeId ="$assess10.itemizeId"> $number.format("#0.00",$assess10.itemizeId)</td>
                	<td class="click_td" date-itemizeId ="$assess10.itemizeId">#if($assess10.testValue1&&$assess10.testValue1>$assess10.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess10.itemizeId">#if($assess10.kf&&$assess10.kf>$assess10.AValue) + #elseif($assess10.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess10.itemizeId">#if($assess10.f&&$assess10.f>$assess10.AValue) + #elseif($assess10.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess11)
                	<td class="click_td" date-itemizeId ="$assess11.itemizeId">记忆力</td>
                	<td class="click_td" date-itemizeId ="$assess11.itemizeId"> $number.format("#0.00",$assess11.itemizeId)</td>
                	<td class="click_td" date-itemizeId ="$assess11.itemizeId">#if($assess11.testValue1&&$assess11.testValue1>$assess11.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess11.itemizeId">#if($assess11.kf&&$assess11.kf>$assess11.AValue) + #elseif($assess11.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess11.itemizeId">#if($assess11.f&&$assess11.f>$assess11.AValue) + #elseif($assess11.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess12)
                	<td class="click_td" date-itemizeId ="$assess12.itemizeId">回忆力</td>
                	<td class="click_td" date-itemizeId ="$assess12.itemizeId">$number.format("#0.00",$assess12.itemizeId )</td>
                	<td class="click_td" date-itemizeId ="$assess12.itemizeId">#if($assess12.testValue1&&$assess12.testValue1>$assess12.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess12.itemizeId">#if($assess12.kf&&$assess12.kf>$assess12.AValue) + #elseif($assess12.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess12.itemizeId">#if($assess12.f&&$assess12.f>$assess12.AValue) + #elseif($assess12.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess13)
                	<td class="click_td" date-itemizeId ="$assess13.itemizeId">抽象思维</td>
                	<td class="click_td" date-itemizeId ="$assess13.itemizeId"> $number.format("#0.00",$assess13.itemizeId )</td>
                	<td class="click_td" date-itemizeId ="$assess13.itemizeId">#if($assess13.testValue1&&$assess13.testValue1>$assess13.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess13.itemizeId">#if($assess13.kf&&$assess13.kf>$assess13.AValue) + #elseif($assess13.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess13.itemizeId">#if($assess13.f&&$assess13.f>$assess13.AValue) + #elseif($assess13.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess14)
                	<td class="click_td" date-itemizeId ="$assess14.itemizeId">视结构技能</td>
                	<td class="click_td" date-itemizeId ="$assess14.itemizeId"> $number.format("#0.00",$assess14.itemizeId )</td>
                	<td class="click_td" date-itemizeId ="$assess14.itemizeId">#if($assess14.testValue1&&$assess14.testValue1>$assess14.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess14.itemizeId">#if($assess14.kf&&$assess14.kf>$assess14.AValue) + #elseif($assess14.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess14.itemizeId">#if($assess14.f&&$assess14.f>$assess14.AValue) + #elseif($assess14.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess15)
                	<td class="click_td" date-itemizeId ="$assess15.itemizeId">执行能力</td>
                	<td class="click_td" date-itemizeId ="$assess15.itemizeId"> $number.format("#0.00",$assess15.itemizeId )</td>
                	<td class="click_td" date-itemizeId ="$assess15.itemizeId">#if($assess15.testValue1&&$assess15.testValue1>$assess15.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess15.itemizeId">#if($assess15.kf&&$assess15.kf>$assess15.AValue) + #elseif($assess15.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess15.itemizeId">#if($assess15.f&&$assess15.f>$assess15.AValue) + #elseif($assess15.f) - #end</td>
                	#end
                </tr>
                 <tr>
                	#if($assess16)
                	<td class="click_td" date-itemizeId ="$assess16.itemizeId">计算力</td>
                	<td class="click_td" date-itemizeId ="$assess16.itemizeId" >$number.format("#0.00",$assess16.itemizeId )</td>
                	<td class="click_td" date-itemizeId ="$assess16.itemizeId">#if($assess16.testValue1&&$assess16.testValue1>$assess16.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess16.itemizeId">#if($assess16.kf&&$assess16.kf>$assess16.AValue) + #elseif($assess16.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess16.itemizeId">#if($assess16.f&&$assess16.f>$assess16.AValue) + #elseif($assess16.f) - #end</td>
                	#end
                </tr>
                <tr>
                	#if($assess17)
                	<td class="click_td" date-itemizeId ="$assess17.itemizeId">心理素质</td>
                	<td class="click_td" date-itemizeId ="$assess17.itemizeId"> $number.format("#0.00",$assess17.itemizeId )</td>
                	<td class="click_td" date-itemizeId ="$assess17.itemizeId">#if($assess17.testValue1&&$assess17.testValue1>$assess17.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess17.itemizeId">#if($assess17.kf&&$assess17.kf>$assess17.AValue) + #elseif($assess17.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess17.itemizeId">#if($assess17.f&&$assess17.f>$assess17.AValue) + #elseif($assess17.f) - #end</td>
                	#end
                </tr>
                <tr>
                	#if($assess18)
                	<td class="click_td" date-itemizeId ="$assess18.itemizeId">语言能力</td>
                	<td class="click_td" date-itemizeId ="$assess18.itemizeId"> $number.format("#0.00",$assess18.itemizeId )</td>
                	<td class="click_td" date-itemizeId ="$assess18.itemizeId">#if($assess18.testValue1&&$assess18.testValue1>$assess18.AValue) + #else - #end</td>
                	<td class="click_td" date-itemizeId ="$assess18.itemizeId">#if($assess18.kf&&$assess18.kf>$assess18.AValue) + #elseif($assess18.kf) - #end</td>
                	<td class="click_td" date-itemizeId ="$assess18.itemizeId">#if($assess18.f&&$assess18.f>$assess18.AValue) + #elseif($assess18.f) - #end</td>
                	#end
                </tr>
            <!--     <tr>
                	<td>信息记忆</td>
                	<td></td>
                	<td></td>
                	<td></td>
                	<td></td>
                </tr>
             -->    
				#end
                <!-  （抑郁程度）  ->
              
            <table>
               
                
                
                
                 
        </div>
    </div>
    
    </div>
    <div class="footer">
    </div>
   </div> 
</div>
<script>
$(function(){
	$('.ModelingCategory').change(function(){
			var value=$(this).val();
			if(value==0|value==2){
				$('.group1').show();
				$('.group2').hide();
			}else if(value==1|value==3){
				$('.group1').show();
				$('.group2').show();
			}else if(value==4|value==5){
				$('.group1').hide();
				$('.group2').hide();
				$('.li_hise1').hide();
			}
			if(value==0|value==3|value==4){
				$('.TimeFactor').hide();
				$('.ageds').hide();
				$('.ageds').val(0);
			}else{
				$('.TimeFactor').show();
			}
	});
	$('.TimeFactor').change(function(){
		if($(this).val()==8){
			$('.ageds').show();
		}else{
			$('.ageds').hide();
			$('.ageds').val(0);
		}
	});
	
	$('.click_td').click(function(){
		var itemizeId=$(this).attr("date-itemizeId");
		location.href="/assess/lookAssess?itemizeId="+itemizeId;
	});
})
</script>
</body>
</html>