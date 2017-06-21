<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>报告添加 </title>
    <link rel="stylesheet" href="$request.contextPath/assets/css/common.css"/>
    <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/jquery-1.8.0.min.js"></script>
    <script src="/assets/js/calendar.js"></script>
    <script src="/assets/js/lhgcalendar.min.js"></script>
    <script src="/assets/js/highcharts.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <style>
    	#service_report{width:800px;height:200px;}
    </style>
</head>
<body>
<form id="from" method="post" action="$request.contextPath/UpReport/service/upReport">
    <input id="hidden" type="hidden" name="hidden"/>
    <input id="reportName" name="reportName" type="hidden"/>
    <input id="rUserId" name="rUserId" type="hidden"/>
    <input id="reportType" name="reportType" type="hidden"/>
    <input id="principal" name="principal" type="hidden"/>
    <input name="scale" id="scale" type="hidden"/>
     <input name="chief" id="chief" type="hidden"/>
</form>
<div class="wrapper">
    <div id="gds" style="display: none">
    	<div class='PagerPrint'></div>
    	$!gds
    </div>
  
   <br/>
	<img class="basic " src="$request.contextPath/assets/css/img/bao_gao/jiben.jpg">
    <div class="basic_">
        <table id="tab_basic">
            <tr>
                <td><label><input type="checkbox" class="acquiesce" id="rUserId" name="姓  名" value="${rUser.name}"/> 姓 名></label></td>
                <td><label><input type="checkbox" class="acquiesce" name="性  别" value="${rUser.gender}"/> 性 别</label></td>
                <td><label><input type="checkbox" class="acquiesce" name="头  像" value="$!rUser.head"/> 头 像</label></td>
                <td><label><input type="checkbox" class="acquiesce" name="生  日" value="${rUser.birthday}"/> 生 日</label></td>
                <td><label><input type="checkbox" class="acquiesce" name="手  机" value="${rUser.mobilePhone}"/> 手 机</label></td>
                <td><label><input type="checkbox" class="acquiesce" name="年  龄" value="${rUser.age}"/> 年 龄</label></td>
                <td><label><input type="checkbox" name="学  历" value="${education}"/> 学 历</label></td>
            </tr>
            <tr>
                <td><label><input type="checkbox" name="社区名称" value="${oCountry.name}"/> 社区名称</label></td>
                <td><label><input type="checkbox" name="居住情况" value="${lifeCond}"/> 居住情况</label></td>
                <td><label><input type="checkbox" name="联系电话" value="${rUser.contactPhone}"/> 联系电话</label></td>
                <td><label><input type="checkbox" name="身份证号" value="${rUser.idCardNo}"/> 身份证号</label></td>
                <td><label><input type="checkbox" name="宗教信仰" value="${religion}"/> 宗教信仰</label></td>
                <td><label><input type="checkbox" name="民  族" value="${nation}"/> 民 族</label></td>
                <td><label><input type="checkbox" name="经济来源" value="${income}"/> 经济来源</label></td>
            </tr>
            <tr>
                <td><label><input type="checkbox" name="户口类型" value="${hrtype}"/> 户口类型</label></td>
                <td><label><input type="checkbox" name="户籍地址" value="${rUser.hrAddr}"/> 户籍地址</label></td>
                <td><label><input type="checkbox" name="婚姻状况" value="${marry}"/> 婚姻状况</label></td>
                <td><label><input type="checkbox" name="政治面貌" value="${political}"/> 政治面貌</label></td>
                <td><label><input type="checkbox" name="现地址详细" value="${rUser.addr}"/> 现地址详细</label></td>
                <td><label><input type="checkbox" name="从业情况" value="${jobCond}"/> 从业情况</label></td>
                <td><label><input type="checkbox" name="医  保" value="${medical}"/> 医 保</label></td>
            </tr>
        </table>
        <div align="right">
            <input type="button" class="ibtn button_add" id="add_basic" value="确定"/>
            <input type="button" class="ibtn button_add" id="delete_basic" value="取消"/>
        </div>
    </div>
    <img class="plan" src="$request.contextPath/assets/css/img/bao_gao/jihua.jpg">

    <div id="div_plan" class="plan_">
        <input name="when" type="radio" value="1"/>日期 <input id="stat" class="text150 timedate" type="text" name="start"
                                                             value="$!date.format('yyyy-MM-dd',$!dateCond.start)">
        <label>-</label> <input id="ed" class="text150 timedate" type="text" name="end"
                                value="$!date.format('yyyy-MM-dd',$!dateCond.end)"> <br/><input name="when" value="0"
                                                                                                type="radio"/>今日
        <br/><input name="when" value="3" type="radio"/>未来三天
        <br/><input name="when" value="7" type="radio"/>未来一周
        <div align="right">
            <input type="button" class="ibtn button_add" id="plan_button" value="确定"/>
            <input type="button" class="ibtn button_add" id="plan_delete" value="取消"/>
        </div>
    </div>
    <img class="service" src="$request.contextPath/assets/css/img/bao_gao/fuwu.jpg">
    <div id="div_service" class="service_">
        <dl style="margin-left:0px;">
            <dd style="float:left">
                <table>
                    <tr>
                        <td>专业服务：</td>
                        <td>
                            <select id="major" name="major">
                                <option>--------------请选择-------------</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>日&nbsp;&nbsp;&nbsp;&nbsp;期：</td>
                        <td>
                            <input class="text150 timedate" id="unit_start" type="text"
                                   value="$!date.format('yyyy-MM-dd',$!dateCond.start)"> <label>-</label> <input
                                class="text150 timedate" id="unit_end" type="text"
                                value="$!date.format('yyyy-MM-dd',$!dateCond.end)">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input id="unit_button" class="ibtn button_add" type="button" value="添加"/>
                        </td>
                    </tr>
                </table>
            </dd>
            <dd style="float:left">
                <table id="unit_table" class="table table-bordered usertable trclick">
                    <tr>
                        <td>专业服务</td>
                        <td>启示日期</td>
                        <td>结束日期</td>
                        <td>操作</td>
                    </tr>
                </table>
            </dd>
            <input id="spreadsheet" type="checkbox"/> 数据表</br>
            <input id="graph" type="checkbox"/> 图
        </dl>
        </br></br>
        <div align="right">
            <input type="button" class="ibtn button_add" id="button_add" value="确定"/>
            <input type="button" class="ibtn button_add" id="service_delete" value="取消"/>
        </div>
        </br>
    </div>
    <img class="assess" src="$request.contextPath/assets/css/img/bao_gao/pinggu.jpg">
    <div class="assess_">

		日期： <input id="startt" class="text150 timedate" type="text" name="start"
         value="$!date.format('yyyy-MM-dd',$!dateCond.start)"> 
           <label>-</label> <input id="endd"
                                 class="text150 timedate"
                                         type="text" name="end"
                                                 value="$!date.format('yyyy-MM-dd',$!dateCond.end)">
			<button id="assess_ibtn" class="ibtn button_add" >搜索</button>
        <table id="tab" class="table table-bordered usertable trclick">
            <tr>
                <th><input id="assessfirst" type="checkbox">全选</th>
                <th>量表名称</th>
                <th>评估日期</th>
                <th>主要结论</th>
                <th>评估详情</th>
                <th>选项</th>
                <th>得分</th>
            </tr>
        </table>
        <div align="right">
            <input id="assess_button" class="ibtn button_add" type="button" value="确定"/>
            <input id="delete_assess" class="ibtn button_add" type="button" value="取消"/>
        </div>
        <div id="synthesize" class='synthesize_div'>
			<text class="font_text">评估摘要</text>
			<div style="border-left:#000 solid 0px;border-right:#000 solid 0px;border-top:#000 solid 2px;border-bottom:#000 solid 2px; ">
				<text>&nbsp;&nbsp;量表得分</text>
				<text style="position:relative; left:40%; ">结&nbsp;&nbsp;论&nbsp;&nbsp;&nbsp;&nbsp;</text>
			</div>
			
			<div style="border-left:#000 solid 0px;border-right:#000 solid 0px;border-top:#000 solid 0px;border-bottom:#000 solid 2px; ">
				<table id="synthesize_tab" style="width:100%">
				</table>
			</div>
			
        </div>
        <div id="synthesize_brief" class='synthesize_div' style="display: none">
       	 #if($brief)
	    	 <div id="brenk" >
		    		<text class="font_text">慢病评估摘要</text>
					<div style="border-left:#000 solid 0px;border-right:#000 solid 0px;border-top:#000 solid 2px;border-bottom:#000 solid 2px; ">
						<font style="line-height:1.5;">
						&nbsp;&nbsp;&nbsp;&nbsp;$brief
						</font>
					</div>
		    </div>
		    #end
        </div>
    </div>
	<img class="servicereport" src="$request.contextPath/assets/css/img/bao_gao/fuwubaogao.jpg">
    <div class="servicereport_" >
    	<textarea id="service_report" style="margin-left:10%"></textarea>
    	<div align="right">
    		<button class="servicereport_save ibtn button_add">确定</button>
    		<button class="servicereport_delete ibtn button_add">取消</button>
    	</div>
    </div>
    <div id="biaoti">
    	<img  src="$request.contextPath/assets/css/img/bao_gao/biaoti.jpg">
    	<input type="text" class="form-control" id="control" style=" width: 300px; position:relative; top:-33px; left:100px;"  placeholder="报告名称    必填项" maxlength="15"></text>
	</div>
    <div class = "PagerPrint"></div>
    <div class="envelope">
    <!-- 尾部 -->
		<div style="text-align:center;" class="stern">
			<div class = "PagerPrint"></div>
			<div style="height:40%;"></div>
			<img style="height:391px;width:393px"   src="$request.contextPath/assets/css/img/bao_gao/beike.png">
		</div>    
    </div>
    <div  style="width:80%;margin-left:20%">
        <pro>
            <div class="footer" style="width:80%; ">
            	<div  class="cover">
					<img style="width:30%"  src="$request.contextPath/assets/css/img/bao_gao/yemei.png">
					<img style="width:100%"  src="$request.contextPath/assets/css/img/bao_gao/fengpi.jpg">
					<br/><br/><br/><br/><br/><br/>
					<table style="font-size:20px;" class="underline"  cellpadding="0" cellspacing="0" border="0" >
						<tr >
							<td style="border-bottom:1px solid black;height:35px;">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</td>
							<td style="border-bottom:1px solid black;">&nbsp;:&nbsp;</td>
							<td style="border-bottom:1px solid black;">$!{rUser.name}</td>
						</tr>
						<tr>
							<td style="border-bottom:1px solid black; height:35px;">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</td>
							<td style="border-bottom:1px solid black;">&nbsp;:&nbsp;</td>
							<td style="border-bottom:1px solid black;">$!{rUser.age}岁</td>
						</tr>
						<tr>
							<td style="border-bottom:1px solid black;height:35px;">所在社区</td>
							<td style="border-bottom:1px solid black;">&nbsp;:&nbsp;</td>
							<td style="border-bottom:1px solid black;">$!{oCountry.name}</td>
						</tr>
					</table>
					<div id="number" style="border-bottom:1px solid black;float:right; margin-right:12%;margin-bottom:40px;">
						<br/><br/>
						编码：
					</div>
					
				</div>
				<br/><br/>
				<br/><br/>
				<div class = "PagerPrint"></div>
            			<div style="height:10%"></div>
		            	<div id="add_mainly">
							<text class="font_text">基本信息</text>
		            	</div>
		            	<div id="add_service_report">
							<text class="font_text">服务报告</text>
            			</div>
            			
    					<br/><br/>
						<br/><br/>
						<div class="jielun_"></div>
						<div class="jielun_gds"><br><br><br></div>
    					<div class="disable_div disable_logisticsDementia">
    						<text class="font_text">数据模型分析结果</text>
		    				<h3>（一）、失能的概率和得分预测情况（模型有关结果的可视化）</h3>	
							<table class="tab_table">
								<tr>
									<td></td><td>失能概率</td><td>不失能概率</td><td></td><td>失能得分</td><td>不失能得分</td>							</tr>
								<tr>
									<td>基于二元逻辑回归的失能模型</td><td><text class="disable"></text></td><td><text class="noDisability"></text></td><td>基于Fisher判别分析的失能模型</td><td><text class="disYes"></text></td><td><text class="disNo"></text></td>
								</tr>
								<tr>
									<td>总体结论：</td><td colspan="5"><text>
										模型预测老人的失能概率<text style="color:red" class="logshineng"> </text >不失能概率，预测老人的失能得分<text style="color:red" class="fisshineng">  </text>不失能得分。综合评价，老人失能的可能性<text class="lastResultDisable" style="color:red">  </text>
									</text></td>
								</tr>
							</table>
							<h3>（二）、失智的概率和得分预测情况</h3>	
							<table class="tab_table">
								<tr>
									<td></td><td>失智概率</td><td>不失智概率</td><td></td><td>失智得分</td><td>不失智得分</td>							</tr>
								<tr>
									<td>基于二元逻辑回归的失能模型</td><td><text class="logisticsDementia"></text></td><td><text class="noLogisticDementia"></text></td><td>基于Fisher判别分析的失能模型</td><td><text class="deYes"></text></td><td><text class="deNo"></text></td>
								</tr>
								<tr>
									<td>总体结论：</td><td colspan="5"><text >
										模型预测老人的失能概率<text style="color:red" class="logshizhi">  </text>不失能概率，预测老人的失能得分<text style="color:red" class="fisshizhi"></text> 不失能得分。综合评价，老人失能的可能性<text class="lastResultDementia" style="color:red">  </text>
									</text></td>
								</tr>
							</table>
							
					</div>
					
   			<div id="container" rutun="server"></div>
            </div>
        </pro>
    </div>
    <div style="margin-left:40%;style="margin-top:20px;">
    	<br/>
    	<br/>
    	<br/>
	    <button class="ibtn button_add" id="pvw">预览</button>
	    <button id="tijiao" class="ibtn button_add">提交</button>
	    <button class="ibtn button_add" onclick="javascripts:location.href='/professional/bao_gao_add?userId=${rUser.id}'">清空</button>
    </div>
    <script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
    <script>
    	$(function(){
    	 var id = ${rUser.id};
       	 $.ajax({
                    url: "/handle/sesses?userId="+id,
                    type: "post",
                    success: function (mjson) {
                    	var json = eval("(" + mjson + ")");
                    	if(json.boolean==true){
                    	$('.logisticsDementia').text(json.logisticsDementia);
                    	$('.noDisability').text(json.noDisability);
                    	$('.deNo').text(json.deNo);
                    	$('.disNo').text(json.disNo);
                    	$('.deYes').text(json.deYes);
                    	$('.disYes').text(json.disYes);
                    	$('.disable').text(json.disable);
                    	$('.noLogisticDementia').text(json.noLogisticDementia);
                    	$('.lastResultDisable').text(json.lastResultDisable);
                    	$('.lastResultDementia').text(json.lastResultDementia);
                    	$('.logshineng').text(json.logshineng);
                    	$('.logshizhi').text(json.logshizhi);
                    	$('.fisshineng').text(json.fisshineng);
                    	$('.fisshizhi').text(json.fisshizhi);
                    	}else{
                    		$('.disable_logisticsDementia').remove();
                    	}
                    }
                });
        
        });
        $(document).ready(function () {
        	//--------------------------------------------------------------------------------
            $(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '65px', height: '10px'});
            $(".basic_").hide();
           	$("#synthesize").hide();
            $(".plan_").hide();
            $(".service_").hide();
            $(".assess_").hide();
            $(".envelope").hide();
            $(".servicereport_").hide();
           
            $(".indent_").hide();
            $('.footer').hide();
            $(".basic").click(function () {
                $(".basic_").toggle();
            });
            $(".plan").click(function () {
                $(".plan_").toggle();
            });
            $(".service").click(function () {
                $(".service_").toggle();
            });
            $(".assess").click(function () {
                $(".assess_").toggle();
            });
            $(".indent").click(function () {
                $(".indent_").toggle();
            });
            $(".servicereport").click(function () {
                $(".servicereport_").toggle();
            });
           $('.servicereport_save').click(function(){
           		var report=$('#service_report').val();
           		if(report==null||report==""){
           		}else{
           		 	$(".servicereport_").hide();
           			$('#add_service_report').append("<p calss=''>"+report+"</p>");
           		}
           });
            //默认加载老年人基本信息
            var basic_t = $("<p calss='basic_t'></p>");
          	$(".acquiesce").attr("checked", true);
            var essage="";
            var b = 0;
            $('.acquiesce').each(function () {
            	if ($(this).attr('name') == "生  日") {
                        essage += $(this).attr('name');
                        essage += ":";
                        var str1 = $(this).val() + "";
                        str = str1.substring(0, 10);
                        essage += str;
                        essage += " | ";
                    } else if ($(this).attr('name') == "头  像") {
                        if ($(this).val() != "") {
                            var src = $(this).val();
                            var img = ("<img class='img_1' style='width:120px;height:138px;   float: right; margin-right:10%;' src='" + src + "'/>");
                           $('#add_mainly').append(img);
                        }
                    } else if ($(this).attr('name') == "性  别") {
                        essage += $(this).attr('name');
                        essage += ":";
                        if ($(this).val() == 1) {
                            var sex = " 男   ";
                        } else {
                            var sex = " 女 ";
                        }
                        essage += sex;
                        essage += " | ";
                    }else {
                        essage += $(this).attr('name');
                        essage += ":";
                        essage += $(this).val();
                        if (b % 5 == 0) {
                            essage += "<br/>";
                        } else {
                            essage += " | ";
                        }
                    } 
                    b++;
            });
            var basic_essage = essage.substring(0, essage.length - 2);
            var basic_first = $("<div id='div1_1'><text class='text1' style='font-size:18.7px;'>" + basic_essage + "</text></div>");
            $('#add_mainly').append(basic_first);
           
            //点击添加时加载老年人基本信息
            $('#add_basic').click(function () {
           		 $('#div1_1').empty();
           		 $('.img_1').remove();
                var basic_str = "";
                var i = $('#tab_basic tr td input:checked').length;
                var a = 0;
                $('#tab_basic tr td input:checked').each(function () {
                    if ($(this).attr('name') == "生  日") {
                        basic_str += $(this).attr('name');
                        basic_str += ":";
                        var str1 = $(this).val() + "";
                        str = str1.substring(0, 10);
                        basic_str += str;
                        basic_str += " | ";
                    } else if ($(this).attr('name') == "头  像") {
                        if ($(this).val() != "") {
                            var src = $(this).val();
                            var img = ("<img style='width:120px;height:138px;   float: right; margin-right:10%;' src='" + src + "'/>");
                           $('#add_mainly').append(img);
                        }
                    } else if ($(this).attr('name') == "性  别") {
                        basic_str += $(this).attr('name');
                        basic_str += ":";
                        if ($(this).val() == 1) {
                            var sex = " 男   ";
                        } else {
                            var sex = " 女 ";
                        }
                        basic_str += sex;
                        basic_str += " | ";
                    } else {
                        basic_str += $(this).attr('name');
                        basic_str += ":";
                        basic_str += $(this).val();
                        if (a % 5 == 0) {
                            basic_str += "<br/>";
                        } else {
                            basic_str += " | ";
                        }
                    }
                    a++;
                });
                var basic_str1 = basic_str.substring(0, basic_str.length - 2);
                var basic_p = $("<p style='font-size:18.7px;'>" + basic_str1 + "</p>");
                basic_t.append(basic_p);
                $('#add_mainly').append(basic_p);
                $("#add_basic").attr("disabled", true).css("color", "#999");
                $('#assess_button').attr("disabled", false).css('color', '#ffffff');
                $('#plan_button').attr("disabled", false).css('color', '#ffffff');
                $('#button_add').attr("disabled", false).css('color', '#ffffff');
                $(".basic_").hide();
            });
            
            $('#delete_basic').click(function () {
                basic_t.remove();
                $('#add_basic').attr("disabled", false).css('color', '#ffffff');
                $("#tab_basic").find('input').attr("checked", false);
            });
        });
        $(function () {
            $('#plan_button').click(function () {
                $('.report').remove();
                var id = ${rUser.id};
                var end = null;
                var tDate;
                var oDate = new Date();
                var month = oDate.getMonth() + 1;
                var time = $("input[name='when']:checked").val();
                if (time == 1) {
                    start = $('#stat').val();
                    end = $('#ed').val();
                } else if (time == 0) {
                    start = oDate.getFullYear() + "-" + month + "-" + oDate.getDate();
                    var n = new Date(oDate.getTime() + 86400000);
                    end = n.getFullYear() + "-" + (n.getMonth() + 1) + "-" + n.getDate();
                } else if (time == 3) {
                    var start = oDate.getFullYear() + "-" + month + "-" + oDate.getDate();
                    var n = new Date(oDate.getTime() + 86400000 * 3);
                    end = n.getFullYear() + "-" + (n.getMonth() + 1) + "-" + n.getDate();
                } else {
                    var start = oDate.getFullYear() + "-" + month + "-" + oDate.getDate();
                    var n = new Date(oDate.getTime() + 86400000 * 7);
                    end = n.getFullYear() + "-" + (n.getMonth() + 1) + "-" + n.getDate();
                }
                $.ajax({
                    url: "/professional/report?id=" + id + "&start=" + start + "&end=" + end,
                    type: "post",
                    success: function (mjson) {
                        var json = eval("(" + mjson + ")");
                        var majson = json.report;
                        if (majson.length != 0) {
                            var table2 = $("<table id='table2'></table>");
                            table2.addClass('table table-bordered usertable trclick');
                            var tr1 = $("<tr >" + "<td >" + "时间" + "</td>" + "<td>" + "计划分类" + "</td>" + "<td>" + "计划内容" + "</td>" + "<td>" + "备注" + "</td>" + "</tr>");
                            table2.append(tr1);
                            $('.footer').append(table2);
                            for (var i = 0; i < majson.length; i++) {
                                var time = new Date(majson[i].serviceTime);
                                var moth = time.getMonth() + 1;
                                var tr2 = $("<tr class='report'>" + "<td >" + time.getFullYear() + "-" + moth + "-" + time.getDate() + "</td>" + "<td>" + majson[i].name + "</td>" + "<td>" + majson[i].content + "</td>" + "<td>" + majson[i].remark + "</td>" + "</tr>");
                                table2.append(tr2);
                            }
                        } else {
                            alert("计划为空");
                        }
                    }
                });
                $("#plan_button").attr("disabled", true).css("color", "#999");
                $(".plan_").hide();
            });
            $('#plan_delete').click(function () {
                $("#plan_button").attr("disabled", false).css("color", "#ffffff");
                $("#div_plan").find('input').attr("checked", false);
            });

        });
        //获取服务信息------------------------------------------------------------------------
        $(function () {
            //进入此页面就加载出全部专业服务
            var major_tr = "";
            var id = ${rUser.id};
            var major = $('#major');
            $.ajax({
                url: "/professional/service/report?userId=" + id,
                type: "post",
                success: function (mjson) {
                  	  var mjon = eval("(" + mjson + ")");
                    for (var i = 0; i < mjon.serviceBrief.length; i++) {
                        major_tr = ("<option id='" + mjon.serviceBrief[i].deviceBindId + "' class='mjson_class' value='" + mjon.serviceBrief[i].serviceId + "' name='" + mjon.serviceBrief[i].serviceName + "'  >" + mjon.serviceBrief[i].serviceName + "</option>")
                        major.append(major_tr);
                    }
                }
            });
            var unit_tr = "";
            
            var str = "";
            $('#unit_button').click(function () {
                //获取元服务名；获取当前老年人名；获取时间判断订单
                var servicename = $('#major').children('option:selected').attr("name");
                var metaServiceId = $('#major').children('option:selected').val();
                var deviceBindId = $('#major').children('option:selected').attr("id");
                var starts = $('#unit_start').val();
                var ends = $('#unit_end').val();
                if (servicename != null && metaServiceId != null && starts != null && ends != null) {
                    var strr = metaServiceId + "," + deviceBindId + "," + starts + "," + ends;
                    var unit_button_tr = ("<tr class='unit_button_tr'>" + "<td>" + "<input type='hidden' value='" + strr + "'/>" + servicename + "</td>" +  "<td>" + starts + "</td>" + "<td>" + ends + "</td>" + "<td>" + "<button style='border: 0px;' class='deleted'>" + "删除" + "</button>" + "</td>" + "</tr>");
                    $('#unit_table').append(unit_button_tr);
                    $("#unit_button").attr("disabled", true);
                    $("#unit_button").css("color", "#999");
                    var strr = metaServiceId + "," + deviceBindId + "," + starts + "," + ends;
                    str += strr;
                    str += ";";
                } else {
                    alert("请选择");
                }

            });
            $(".deleted").live('click', function () {
                var strr = $(this).parent().parent().find("input").val() + ";";
                str = str.replace(strr, "");
                $(this).parent().parent().remove();
            });
            var tab_ser = $("<table style='width:80%;text-align:center;'></table>");
            $('#button_add').click(function () {
                $.ajax({
                    url: "/professional/service/showservice?str="+str,
                    type: "post",
                    success: function (object) {
                        var mmjon = eval("(" + object + ")");
                        if ($('#spreadsheet').attr('checked') != "checked" && $('#graph').attr('checked') != "checked") {
                            alert("请选择数据表/图");
                        } else {
                            if ($('#spreadsheet').attr('checked') == "checked") {
                                for (var i = 0; i < mmjon.servicesSet.length; i++) {
                                    if (mmjon.servicesSet[i].module == "床垫动作") {
                                    } else {
                                        var servicesSet = mmjon.servicesSet[i];
                                        if (servicesSet.arry.length == 0) {
                                        } else {
                                            tab_ser.addClass('table table-bordered usertable trclick');
                                            var tr1 = $("<tr style='width:100%'></tr>");
                                            var tr0 = $("<tr>" + "<td style='text-align: center;' colspan='" + servicesSet.titles_obj.titles_cn.length + "'>" + mmjon.servicesSet[i].module + "</td>" + "</tr>");
                                            tab_ser.append(tr0);
                                            for (var a = 0; a < servicesSet.titles_obj.titles_cn.length; a++) {
                                                var td = $("<td>" + servicesSet.titles_obj.titles_cn[a] + "</td>");
                                                tr1.append(td);
                                            }
                                            tab_ser.append(tr1);
                                            for (var j = 0; j < servicesSet.arry.length; j++) {
                                                var tr2 = $("<tr></tr>");
                                                for (var k = 0; k < servicesSet.arry[j].num.length; k++) {
                                                    if (k == 0) {
                                                        var createdAt1 = new Date(servicesSet.arry[j].num[k]);
                                                        var moth = createdAt1.getMonth() + 1
                                                        createdData = createdAt1.getFullYear() + "-" + moth + "-" + createdAt1.getDate();
                                                        var td1 = $("<td>" + createdData + "</td>");
                                                    } else {
                                                        var td1 = $("<td>" + servicesSet.arry[j].num[k] + "</td>");
                                                    }
                                                    tr2.append(td1);
                                                }
                                                tab_ser.append(tr2);
                                            }
                                            $('.footer').append(tab_ser);
                                        }
                                    }
                                }
                                var str = "";
                            }
                            if ($('#graph').attr('checked') == "checked") {
                                for (var s = 0; s < mmjon.servicesSet.length; s++) {
                                    var subber = [];
                                    if (mmjon.servicesSet[s].arry.length == 1 || mmjon.servicesSet[s].arry.length > 100) {
                                    } else {
                                        for (var j = 0; j < mmjon.servicesSet[s].arry.length; j++) {
                                            //去除报错的
                                            var serviceTime = new Date(mmjon.servicesSet[s].arry[j].num[0]);
                                            var moth = serviceTime.getMonth() + 1
                                            serviceData = serviceTime.getFullYear() + "-" + moth + "-" + serviceTime.getDate();
                                            subber.push("'" + serviceData + "'");
                                            if (j != (mmjon.servicesSet[s].arry.length - 1)) {
                                            }
                                        }
                                        var domo = "[";
                                        for (var a = 0; a < mmjon.servicesSet[s].titles_obj.titles_cn.length; a++) {
                                            if (a != 0) {
                                                domo += "{ name:";
                                                domo += "'";
                                                domo += mmjon.servicesSet[s].titles_obj.titles_cn[a];
                                                domo += "'";
                                                domo += ",data: [";
                                                for (var k = 0; k < mmjon.servicesSet[s].arry.length; k++) {
                                                    var str = mmjon.servicesSet[s].arry[k].num[a];
                                                    domo += str;
                                                    if (k != (mmjon.servicesSet[s].arry.length - 1)) {
                                                        domo += ",";
                                                    }
                                                }
                                                domo += "]";
                                                if (a != (mmjon.servicesSet[s].titles_obj.titles_cn.length - 1)) {
                                                    domo += "},";
                                                } else {
                                                    domo += "}";
                                                }
                                            }
                                        }
                                        domo += "]";
                                        testJson = eval("(" + domo + ")");
                                        var lineChart = $("<div class='lineChart'></div>");
                                        lineChart.highcharts({
                                            chart: {
                                                type: 'spline'
                                            },
                                            title: {
                                                text: mmjon.servicesSet[s].module
                                            },
                                            xAxis: {
                                                categories: subber
                                            },
                                            yAxis: {
                                                title: {
                                                    text: '测量值'
                                                },
                                                min: 0
                                            },
                                            plotOptions: {
                                                line: {
                                                    dataLabels: {
                                                        enabled: true
                                                    },
                                                    enableMouseTracking: true
                                                }
                                            },
                                            series: testJson
                                        });
                                        $('.footer').append(lineChart);
                                    }
                                }
                            }
                            $(".service_").hide();
                            $("#button_add").attr("disabled", true);
                            $("#button_add").css("color", "#999");
                        }
                    }
                });
            });

            $('#service_delete').click(function () {
                $("#button_add").attr("disabled", false).css("color", "#ffffff");
                $("#unit_button").attr("disabled", false).css("color", "#ffffff");
                tab_ser.remove();
                $('.lineChart').remove();
                $('.unit_button_tr').remove();
                str = "";
            })
        });
        //-----------------------------------------添加评估量表-----------------------------------------------------
        $(function () {
            $('#assess_ibtn').click(function () {
                var start = $('#startt').val();
                var end = $('#endd').val();
                var id = ${rUser.id};
                $('.domo').remove();
                $.ajax({
                    url: "/professional/vender/assesses?id=" + id + "&start=" + start + "&end=" + end,
                    type: "post",
                    success: function (data) {
                        var json = eval("(" + data + ")");
                        var majson = json.mAssessRecord;
                        for (var i = 0; i < majson.length; i++) {
                            var time = new Date(majson[i].createdAt); 
                            var moth = time.getMonth() + 1;
                            $('#tab').append("<tr class='domo'>" + "<td>" + "<input class='assessput' name='" + majson[i].id + "' value='" + majson[i].assessName + "' type='checkbox'/>" + "</td>" + "<td>" + majson[i].assessName + "</td>" + "<td>" + time.getFullYear() + "-" + moth + "-" + time.getDate() + "</td>" + "<td>" + "<input class='chief' value='" + i + "' type='checkbox'/>" + "</td>" + "<td>" + "<input class='details'  type='checkbox'/>" + "</td>"+ "<td>"+ "<input class='choice'  type='checkbox'/>"+ "</td>" + "<td>" + "<input class='score'  type='checkbox'/>" + "</td>"+ "</tr>");
                        }
                    }
                });
            });
            //====================点击报告tr中第一个input this 下input全选===========================
           $(".assessput").live('click', function () {
                if (this.checked) {
                    $(this).parent().parent().find('input').attr("checked", true);
                } else {
                    $(this).parent().parent().find('input').attr("checked", false);
                }
            });
            //--------点击tr中主要结论和评估详情tr下第一个input选中---------------
           
            $(".chief").live('click', function () {
                if (this.checked) {
                    $($(this).parent().parent().children().get(0)).find('input').attr("checked", true);
                } else {
                    if ($(this).parent().parent().find('.details').attr('checked') == 'checked') {
                    } else {
                        $($(this).parent().parent().children().get(0)).find('input').attr("checked", false);
                    }
                }
            });
            //--------全选-------------
            $("#assessfirst").click(function () {
                if (this.checked) {
                    $(".assessput,.details,.chief:checkbox").attr("checked", true);
                } else {
                    $(".assessput,.details,.chief:checkbox").attr("checked", false);
                }
            });
        });
        //添加评估详情
        $('#assess_button').click(function () {
			if($('#tab input:checked').length>0){
				$("#mask_zhezhao", parent.document).show();
			}
		
            var id = ${rUser.id};
            var a = new Array();
            var brstr = "";
            var Ids = "";
            $('.assessput:checked').each(function () {
                var b = "";
                brstr = $(this).attr("name");
                b += brstr;
                b += ",";
                a.push(b);
            });
            Ids = a.join("");
           
            //获取评估报告详情
            $.ajax({
                url: "/professional/vender/assesses/detail?Ids=" + Ids,
                type: "post",
                success: function (sjson) {
                	
                	$('.jielun_').append($('.synthesize_div'));
                	$('.synthesize_div').show();
                	var div_z = $("<div></div>");
                    var textarea_z = $("<br><br><br><textarea id='chiefs' class='textarea' style=' width:700px;height:200px;'></textarea>");
                    var textpro_z = $("<p class='textpro'><p>");
                    var button_xiugai_z = $("<button class='xiugai'>修改</button><button class='baocui'>保存</button>");
                    var synthesize_z = "综合建议：";
                    var assess1_1=false;
                    var sjsons = eval("(" + sjson + ")");
                   // for(var p=0;p<sjsons.length;p++){
                    //	if(sjsons[p].list.length>1) {
                    	//	assess1_1=true;
                    	//	break;
                    	//} 
                   // }
                 //	if(assess1_1==true){
                 	//	synthesize_z+="建议到医院就诊，经确诊后给予针对性治疗，可根据情况进行辅疗干预、加强家人照护并掌握相关护理知识，预防坠床，噎食，褥疮等发生。";
                 //	}
                    textarea_z.append(synthesize_z);
                    div_z.append(textarea_z);
                    div_z.append(textpro_z);
                    div_z.append(button_xiugai_z);
                    $('.textarea').attr("disabled",true);
                    $('.footer').append(div_z);
                   
                    //获取所有选取的量表名和主要结论
                    var scale="";
                    for (var i = 0; i < sjsons.length; i++) {
                    	
                       	 var sjs = sjsons[i].list[0].result;
                       	 var recordId = sjsons[i].list[0].recordId;
                       	 $(".assessput").each(function (a, b) {
                            var value = $(b).attr("name");
                           
                            if (value == sjsons[i].list[0].recordId&&sjsons[i].list.length==1) {
	                        		var div2=$("<div class='PagerPrint'></div>");
	                        		$('.footer').append(div2);
	                        		var resultName= $(this).val();
	                            	var conclusion = sjsons[i].list[0].conclusion;
	                            	var synthesize_tr=$("<tr>"+"<td style='width:47%;height:30px;'>"+resultName+"</td>"+"<td>"+conclusion+"</td>"+"</tr>")
	                                $('#synthesize_tab').append(synthesize_tr);
                            		scale+=resultName;
                            		scale+=":";
                            		scale+=conclusion;
                            		scale+=";";
	                                var $td = $(this).parents('td').parents('tr').children('td');
	                                var input1 = $td.eq(3).find('input').prop("checked");
	                                var input2 = $td.eq(4).find('input').prop("checked");
	                                var input3 = $td.eq(5).find('input').prop("checked");
	                                var input4 = $td.eq(6).find('input').prop("checked");
                                //======================开始======================
                                //添加建议
	                                var div = $("<div><br><br><br></div>");
	                                var clusion1 = $('<div><text style="folat:left;font-size:20px; font-family:KaiTi_GB2312,楷体_GB2312,SimHei,黑体">'+"个人建议:"+'</text></div>');
	                                var textarea = $("<textarea class='textarea' style=' width:700px;height:200px;'></textarea>");
	                                var textpro = $("<p class='textpro'><p>");
	                                var button_xiugai = $("<button class='xiugai'>修改</button><button class='baocui'>保存</button>");
	                                var core = 1;
	                                var clusion="";
                               
	                                if (sjs.length != 0 && sjs.length != null) {
	                                    textarea.append(clusion + "\n");
	                                }
	                                for (var j = 0; j < sjs.length; j++) {
		                                    if (sjs[j].aConclusion != null && sjs[j].aConclusion != "") {
		                                        var aConclusion = sjs[j].aConclusion;
		                                        textarea.append(aConclusion  + "\n");
		                                        core++;
		                                    }
	                                }
	                                textarea.attr("disabled", "disabled");
	                                div.append(clusion1);
	                                div.append(textarea);
	                                div.append(textpro);
	                                div.append(button_xiugai);
                              
	                                var textadl="该量表主要反应人们在家庭和社区中最基本的日常生活能力 ， 包括照料自己的衣食住行， 保持个人卫生整洁和进行独立的社区活动等方面的评估。";
								    var textiadls="该量表主要反应人们在社区中的日常生活活动能力。";													
								    var textmmse="该量表是对时间定向力，地点定向力，即刻记忆，注意力及计算力 ，延迟记忆，语言，视空间共 7 个方面的评估。";													
									var tr_remarks = $("<tr class='tab_table' style='width:100%'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(三)该量表补充说明"+"</td>"+"</tr>");
				                                    														
        //====================此处加判断量表类型（题目所占空间大还是选项内容所占空间大）=========================================                        
                                	if(resultName=="日常生活活动评估表(ADL)"|resultName=="工具日常生活量表（IADLs）"|resultName=="基本生活活动能力量表（ADL）"){
	                                	if (input2 == true) {
		                                   			var n = 1;
		                                    		var tables = $("<table calss='tab_table' style='width:100%'></table>");
				                                    if(input3 == true&&input4 == true){
				                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='5' style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;' >"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
				                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
				                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
			                                    	
				                                    	tables.append(tr_headline);
				                                    	tables.append(tr_mainresults);
				                                    	tables.append(tr_scaledetails);
				                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td' style='border:1px solid #999 ;'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>" + "<td  class='tab_td' >" + "选项" + "</td>" + "<td>" + "内容" + "</td>" + "<td   class='tab_td' >" + "得分" + "</td>" + "</tr>");
				                                    	tables.append(tr1);
					                                   
					                                    for (var j = 0; j < sjs.length; j++) {
															if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
					                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
					                                            var tr3 = $("<tr class='tab_table' >" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
					                                            tables.append(tr3);
					                                        } else {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td' style='border:1px solid #999 ;'>" + n + "</td>" + "<td  class='tab_td1'>" + sjs[j].questionName + "</td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td  class='tab_td2'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
					                                            n++;
					                                            tables.append(tr3);
					                                        }
				                                    	}
					                                    	if(resultName=="日常生活活动评估表(ADL)"|resultName=="基本生活活动能力量表（ADL）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='5'>"+textadl+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}else if(resultName=="工具日常生活量表（IADLs）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='5'>"+textiadls+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}
				                                    	 	$('.footer').append(tables);
				                                    }else if(input3 != true&&input4 == true){
				                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='4'    style='font-size:20px; border-left:1px solid #999 ;border-top:1px solid #999 ;' >"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
				                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
				                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
				                                    	tables.append(tr_headline);
				                                    	tables.append(tr_mainresults);
				                                    	tables.append(tr_scaledetails);
				                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>"  + "<td class='tab_td2'>" + "内容" + "</td>" + "<td class='tab_td'>" + "得分" + "</td>" + "</tr>");
				                                    	tables.append(tr1);
					                                   
					                                    for (var j = 0; j < sjs.length; j++) {
															if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
					                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' ></td>" + "<td></td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
					                                            tables.append(tr3);
					                                        } else {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td1'>" + sjs[j].questionName + "</td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
					                                            n++;
					                                            tables.append(tr3);
					                                        }
					                                    }
					                                    if(resultName=="日常生活活动评估表(ADL)"|resultName=="基本生活活动能力量表（ADL）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textadl+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}else if(resultName=="工具日常生活量表（IADLs）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textiadls+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}
					                                    	$('.footer').append(tables);
				                                    	
				                                    }else if(input4 != true&&input3 == true){
				                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='4'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;' >"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
				                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
				                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
				                                    	tables.append(tr_headline);
				                                    	tables.append(tr_mainresults);
				                                    	tables.append(tr_scaledetails);
				                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>" + "<td class='tab_td'>" + "选项" + "</td>" + "<td class='tab_td2'>" + "内容" + "</td>"  + "</tr>");
				                                    	tables.append(tr1);
					                                   
					                                    for (var j = 0; j < sjs.length; j++) {
															if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
					                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td  style='border-left:1px solid #999 ;' ></td>" + "<td></td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>"  + "</tr>");
					                                            tables.append(tr3);
					                                        } else {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td1'>" + sjs[j].questionName + "</td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>"  + "</tr>");
					                                            n++;
					                                            tables.append(tr3);
					                                        }
				                                    	}
				                                    		if(resultName=="日常生活活动评估表(ADL)"|resultName=="基本生活活动能力量表（ADL）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textadl+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}else if(resultName=="工具日常生活量表（IADLs）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textiadls+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}
					                                     $('.footer').append(tables);
				                                    }else{
				                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='3'    style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;'>"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
				                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='3' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
				                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='3' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
				                                    	tables.append(tr_headline);
				                                    	tables.append(tr_mainresults);
				                                    	tables.append(tr_scaledetails);
				                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>"  + "<td class='tab_td2'>" + "内容" + "</td>"  + "</tr>");
				                                    	tables.append(tr1);
						                                    for (var j = 0; j < sjs.length; j++) {
							                                        if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																		continue;
																	}
							                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
							                                            var tr3 = $("<tr class='tab_table'>" + "<td  style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "</tr>");
							                                            tables.append(tr3);
							                                        } else {
							                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td1'>" + sjs[j].questionName + "</td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "</tr>");
							                                            n++;
							                                            tables.append(tr3);
							                                        }
				                                          	}
				                                         	if(resultName=="日常生活活动评估表(ADL)"|resultName=="基本生活活动能力量表（ADL）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textadl+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}else if(resultName=="工具日常生活量表（IADLs）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textiadls+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}
				                                    		$('.footer').append(tables);
						                                  
				                                    }
				                                    
				                                }
		                                
		                                }else{
		                                	if (input2 == true) {
		                                    var n = 1; 
		                                    var tables = $("<table calss='tab_table' style='width:100%'></table>");
		                                    if(input3 == true&&input4 == true){
		                                    	var tr_headline = $("<tr class='tab_table' >"+"<td colspan='5'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;' >"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
		                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
		                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
		                                    	tables.append(tr_headline);
		                                    	tables.append(tr_mainresults);
		                                    	tables.append(tr_scaledetails);
		                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td' >" + "序号" + "</td>" + "<td>" + "问题" + "</td>" + "<td  class='tab_td' >" + "选项" + "</td>" + "<td >" + "内容" + "</td>" + "<td   class='tab_td' >" + "得分" + "</td>" + "</tr>");
		                                    	tables.append(tr1);
			                                    
			                                    for (var j = 0; j < sjs.length; j++) {
			                                        if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
			                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
			                                            tables.append(tr3);
			                                        } else {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_left'>" + sjs[j].questionName + "</td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
			                                            n++;
			                                            tables.append(tr3);
			                                        }
		                                    	}
		                                    	if(resultName=="简易智能精神状态检查量表(MMSE)"){
		                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='5'>"+textmmse+"</td>"+"</tr>");
		                                    		tables.append(tr_remarks);
		                                    		tables.append(tr_detailremarks);
		                                    	}
		                                    	$('.footer').append(tables);
		                                    }else if(input3 != true&&input4 == true){
		                                    	var tr_headline = $("<tr class='tab_table' >"+"<td colspan='4'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;'>"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
		                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
		                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
		                                    	tables.append(tr_headline);
		                                    	tables.append(tr_mainresults);
		                                    	tables.append(tr_scaledetails);
		                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>"  + "<td >" + "内容" + "</td>" + "<td class='tab_td'>" + "得分" + "</td>" + "</tr>");
		                                    	tables.append(tr1);
			                                    
			                                    for (var j = 0; j < sjs.length; j++) {
													if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
			                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "<td >" + sjs[j].score + "</td>" + "</tr>");
			                                            tables.append(tr3);
			                                        } else {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td2'>" + sjs[j].questionName + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
			                                            n++;
			                                            tables.append(tr3);
			                                        }
			                                    }
		                                    	if(resultName=="简易智能精神状态检查量表(MMSE)"){
		                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textmmse+"</td>"+"</tr>");
		                                    		tables.append(tr_remarks);
		                                    		tables.append(tr_detailremarks);
		                                    	}
		                                    	$('.footer').append(tables);
		                                    }else if(input4 != true&&input3 == true){
		                                    	var tr_headline = $("<tr class='tab_table'   >"+"<td colspan='4'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;'>"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
		                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
		                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
		                                    	tables.append(tr_headline);
		                                    	tables.append(tr_mainresults);
		                                    	tables.append(tr_scaledetails);
		                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>" + "<td class='tab_td'>" + "选项" + "</td>" + "<td >" + "内容" + "</td>"  + "</tr>");
		                                    	tables.append(tr1);
			                                   
			                                    for (var j = 0; j < sjs.length; j++) {
													if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
			                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>"  + "</tr>");
			                                            tables.append(tr3);
			                                        } else {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td2'>" + sjs[j].questionName + "</td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>"  + "</tr>");
			                                            n++;
			                                            tables.append(tr3);
			                                        }
		                                    	}
		                                    	if(resultName=="简易智能精神状态检查量表(MMSE)"){
		                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textmmse+"</td>"+"</tr>");
		                                    		tables.append(tr_remarks);
		                                    		tables.append(tr_detailremarks);
		                                    	}
		                                    	$('.footer').append(tables);
		                                    }else{
		                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='3'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;'>"+"<text>"+resultName+"</text  >"+"</td>"+"</tr>");
		                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='3'  style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
		                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='3' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
		                                    	tables.append(tr_headline);
		                                    	tables.append(tr_mainresults);
		                                    	tables.append(tr_scaledetails);
		                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>"  + "<td>" + "内容" + "</td>"  + "</tr>");
		                                    	tables.append(tr1);
			                                   
				                                    for (var j = 0; j < sjs.length; j++) {
															if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
					                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "</tr>");
					                                            tables.append(tr3);
					                                        } else {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td2'>" + sjs[j].questionName + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "</tr>");
					                                            n++;
					                                            tables.append(tr3);
					                                        }
				                                    }
				                                if(resultName=="简易智能精神状态检查量表(MMSE)"){
		                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textmmse+"</td>"+"</tr>");
		                                    		tables.append(tr_remarks);
		                                    		tables.append(tr_detailremarks);
		                                    	}
		                                    	$('.footer').append(tables);    
		                                    }
		                                }
		                                
                            	}
                            	//=============for外=============
                            	$('#scale').val(scale);
                                $('.footer').append(div);
                                $('#assess_button').attr("disabled", true);
                                $("#assess_button").css("color", "#999");
                            }else  if (value == sjsons[i].list[0].recordId&&sjsons[i].list.length>1) {
                            	for(var kl=0;kl<sjsons[i].list.length;kl++){
                            		 var div2=$("<div class='PagerPrint'></div>");
                            		$('.footer').append(div2);
                            		sjs = sjsons[i].list[kl].result;
                            		var resultName= $(this).val();
                            		resultName=sjsons[i].list[kl].assessName;
	                            	var conclusion = sjsons[i].list[kl].conclusion;
	                            	var synthesize_tr=$("<tr>"+"<td style='width:47%;height:30px;'>"+resultName+"</td>"+"<td>"+conclusion+"</td>"+"</tr>")
	                                $('#synthesize_tab').append(synthesize_tr);
                            		scale+=resultName;
                            		scale+=":";
                            		scale+=conclusion;
                            		scale+=";";
	                                var $td = $(this).parents('td').parents('tr').children('td');
	                                var input1 = $td.eq(3).find('input').prop("checked");
	                                var input2 = $td.eq(4).find('input').prop("checked");
	                                var input3 = $td.eq(5).find('input').prop("checked");
	                                var input4 = $td.eq(6).find('input').prop("checked");
                                //======================开始======================
                                //添加建议
	                                var div = $("<div><br><br><br></div>");
	                                var clusion1 = $('<div><text style="folat:left;font-size:20px; font-family:KaiTi_GB2312,楷体_GB2312,SimHei,黑体">'+"个人建议:"+'</text></div>');
	                                var textarea = $("<textarea class='textarea' style=' width:700px;height:200px;'></textarea>");
	                                var textpro = $("<p class='textpro'><p>");
	                                var button_xiugai = $("<button class='xiugai'>修改</button><button class='baocui'>保存</button>");
	                                var core = 1;
	                                var clusion="";
                               
	                                if (sjs.length != 0 && sjs.length != null) {
	                                    textarea.append(clusion + "\n");
	                                }
	                                for (var j = 0; j < sjs.length; j++) {
		                                 //   alert(sjs[j].aConclusion);
		                                    if (sjs[j].aConclusion != null && sjs[j].aConclusion != "") {
		                                        var aConclusion = sjs[j].aConclusion;
		                                        textarea.append(aConclusion  + "\n");
		                                        core++;
		                                   }
	                               }
	                                textarea.attr("disabled", "disabled");
	                                div.append(clusion1);
	                                div.append(textarea);
	                                div.append(textpro);
	                                div.append(button_xiugai);
                              
	                                var textadl="该量表主要反应人们在家庭和社区中最基本的日常生活能力 ， 包括照料自己的衣食住行， 保持个人卫生整洁和进行独立的社区活动等方面的评估。";
								    var textiadls="该量表主要反应人们在社区中的日常生活活动能力。";													
								    var textmmse="该量表是对时间定向力，地点定向力，即刻记忆，注意力及计算力 ，延迟记忆，语言，视空间共 7 个方面的评估。";													
									var tr_remarks = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(三)该量表补充说明"+"</td>"+"</tr>");
                            	  if(resultName=="日常生活活动评估表(ADL)"|resultName=="工具日常生活量表（IADLs）"|resultName=="基本生活活动能力量表（ADL）"){
	                                	if (input2 == true) {
		                                   			var n = 1;
		                                    		var tables = $("<table calss='tab_table' style='width:100%'></table>");
				                                    if(input3 == true&&input4 == true){
				                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='5' style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;' >"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
				                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
				                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
			                                    	
				                                    	tables.append(tr_headline);
				                                    	tables.append(tr_mainresults);
				                                    	tables.append(tr_scaledetails);
				                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td' >" + "序号" + "</td>" + "<td>" + "问题" + "</td>" + "<td  class='tab_td' >" + "选项" + "</td>" + "<td>" + "内容" + "</td>" + "<td   class='tab_td' >" + "得分" + "</td>" + "</tr>");
				                                    	tables.append(tr1);
					                                   
					                                    for (var j = 0; j < sjs.length; j++) {
															if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
					                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
					                                            tables.append(tr3);
					                                        } else {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td  class='tab_td1'>" + sjs[j].questionName + "</td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td  class='tab_td2'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
					                                            n++;
					                                            tables.append(tr3);
					                                        }
				                                    	}
					                                    	if(resultName=="日常生活活动评估表(ADL)"|resultName=="基本生活活动能力量表（ADL）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='5'>"+textadl+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}else if(resultName=="工具日常生活量表（IADLs）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='5'>"+textiadls+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}
					                                    	
				                                    	 	$('.footer').append(tables);
				                                    }else if(input3 != true&&input4 == true){
				                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='4'    style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;' >"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
				                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
				                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
				                                    	tables.append(tr_headline);
				                                    	tables.append(tr_mainresults);
				                                    	tables.append(tr_scaledetails);
				                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>"  + "<td class='tab_td2'>" + "内容" + "</td>" + "<td class='tab_td'>" + "得分" + "</td>" + "</tr>");
				                                    	tables.append(tr1);
					                                   
					                                    for (var j = 0; j < sjs.length; j++) {
															if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
					                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' ></td>" + "<td></td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
					                                            tables.append(tr3);
					                                        } else {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td1'>" + sjs[j].questionName + "</td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
					                                            n++;
					                                            tables.append(tr3);
					                                        }
					                                    }
					                                    if(resultName=="日常生活活动评估表(ADL)"|resultName=="基本生活活动能力量表（ADL）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textadl+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}else if(resultName=="工具日常生活量表（IADLs）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textiadls+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}
					                                    	
					                                    	$('.footer').append(tables);
				                                    	
				                                    }else if(input4 != true&&input3 == true){
				                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='4'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;' >"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
				                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
				                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
				                                    	tables.append(tr_headline);
				                                    	tables.append(tr_mainresults);
				                                    	tables.append(tr_scaledetails);
				                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>" + "<td class='tab_td'>" + "选项" + "</td>" + "<td class='tab_td2'>" + "内容" + "</td>"  + "</tr>");
				                                    	tables.append(tr1);
					                                   
					                                    for (var j = 0; j < sjs.length; j++) {
															if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
					                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>"  + "</tr>");
					                                            tables.append(tr3);
					                                        } else {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td1'>" + sjs[j].questionName + "</td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>"  + "</tr>");
					                                            n++;
					                                            tables.append(tr3);
					                                        }
				                                    	}
				                                    		if(resultName=="日常生活活动评估表(ADL)"|resultName=="基本生活活动能力量表（ADL）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textadl+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}else if(resultName=="工具日常生活量表（IADLs）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textiadls+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}
					                                     $('.footer').append(tables);
				                                    }else{
				                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='3'    style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;'>"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
				                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='3' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
				                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='3' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
				                                    	tables.append(tr_headline);
				                                    	tables.append(tr_mainresults);
				                                    	tables.append(tr_scaledetails);
				                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>"  + "<td class='tab_td2'>" + "内容" + "</td>"  + "</tr>");
				                                    	tables.append(tr1);
						                                    for (var j = 0; j < sjs.length; j++) {
							                                        if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																		continue;
																	}
							                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
							                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "</tr>");
							                                            tables.append(tr3);
							                                        } else {
							                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td1'>" + sjs[j].questionName + "</td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "</tr>");
							                                            n++;
							                                            tables.append(tr3);
							                                        }
				                                          	}
				                                         	if(resultName=="日常生活活动评估表(ADL)"|resultName=="基本生活活动能力量表（ADL）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textadl+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}else if(resultName=="工具日常生活量表（IADLs）"){
					                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textiadls+"</td>"+"</tr>");
					                                    		tables.append(tr_remarks);
					                                    		tables.append(tr_detailremarks);
					                                    	}
				                                    		$('.footer').append(tables);
						                                  
				                                    }
				                                    
				                                }
		                                
		                                }else{
		                                	if (input2 == true) {
		                                    var n = 1;
		                                    var tables = $("<table calss='tab_table' style='width:100%'></table>");
		                                    if(input3 == true&&input4 == true){
		                                    	var tr_headline = $("<tr class='tab_table' >"+"<td colspan='5'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;' >"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
		                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
		                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='5' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
		                                    	tables.append(tr_headline);
		                                    	tables.append(tr_mainresults);
		                                    	tables.append(tr_scaledetails);
		                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td' >" + "序号" + "</td>" + "<td>" + "问题" + "</td>" + "<td  class='tab_td' >" + "选项" + "</td>" + "<td >" + "内容" + "</td>" + "<td   class='tab_td' >" + "得分" + "</td>" + "</tr>");
		                                    	tables.append(tr1);
			                                    
			                                    for (var j = 0; j < sjs.length; j++) {
			                                        
			                                        if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
			                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
			                                            tables.append(tr3);
			                                        } else {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_left'>" + sjs[j].questionName + "</td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
			                                            n++;
			                                            tables.append(tr3);
			                                        }
		                                    	}
		                                    	if(resultName=="简易智能精神状态检查量表(MMSE)"){
		                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='5'>"+textmmse+"</td>"+"</tr>");
		                                    		tables.append(tr_remarks);
		                                    		tables.append(tr_detailremarks);
		                                    	}
		                                    	
		                                    	$('.footer').append(tables);
		                                    }else if(input3 != true&&input4 == true){
		                                    	var tr_headline = $("<tr class='tab_table' >"+"<td colspan='4'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;'>"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
		                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
		                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
		                                    	tables.append(tr_headline);
		                                    	tables.append(tr_mainresults);
		                                    	tables.append(tr_scaledetails);
		                                    	var tr1 = $("<tr class='tab_table'>" + "<td  style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>"  + "<td >" + "内容" + "</td>" + "<td class='tab_td'>" + "得分" + "</td>" + "</tr>");
		                                    	tables.append(tr1);
			                                    
			                                    for (var j = 0; j < sjs.length; j++) {
													if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
			                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' ></td>" + "<td></td>" + "<td class='tab_td2'>" + sjs[j].answerName + "</td>" + "<td >" + sjs[j].score + "</td>" + "</tr>");
			                                            tables.append(tr3);
			                                        } else {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td2'>" + sjs[j].questionName + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "<td class='tab_td'>" + sjs[j].score + "</td>" + "</tr>");
			                                            n++;
			                                            tables.append(tr3);
			                                        }
			                                    }
		                                    	if(resultName=="简易智能精神状态检查量表(MMSE)"){
		                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textmmse+"</td>"+"</tr>");
		                                    		tables.append(tr_remarks);
		                                    		tables.append(tr_detailremarks);
		                                    	}
		                                     
		                                    	$('.footer').append(tables);
		                                    }else if(input4 != true&&input3 == true){
		                                    	var tr_headline = $("<tr class='tab_table'   >"+"<td colspan='4'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;'>"+"<text>"+resultName+"</text>"+"</td>"+"</tr>");
		                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
		                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='4' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
		                                    	tables.append(tr_headline);
		                                    	tables.append(tr_mainresults);
		                                    	tables.append(tr_scaledetails);
		                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>" + "<td class='tab_td'>" + "选项" + "</td>" + "<td >" + "内容" + "</td>"  + "</tr>");
		                                    	tables.append(tr1);
			                                   
			                                    for (var j = 0; j < sjs.length; j++) {
													if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
			                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>"  + "</tr>");
			                                            tables.append(tr3);
			                                        } else {
			                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td2'>" + sjs[j].questionName + "</td>" + "<td class='tab_td'>" + sjs[j].code + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>"  + "</tr>");
			                                            n++;
			                                            tables.append(tr3);
			                                        }
		                                    	}
		                                    	if(resultName=="简易智能精神状态检查量表(MMSE)"){
		                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textmmse+"</td>"+"</tr>");
		                                    		tables.append(tr_remarks);
		                                    		tables.append(tr_detailremarks);
		                                    	}
		                                    	 
		                                    	$('.footer').append(tables);
		                                    }else{
		                                    	var tr_headline = $("<tr class='tab_table'>"+"<td colspan='3'  style='font-size:20px;border-top:1px solid #999 ;border-left:1px solid #999 ;'>"+"<text>"+resultName+"</text  >"+"</td>"+"</tr>");
		                                    	var tr_mainresults = $("<tr class='tab_table'>"+"<td colspan='3' style='border-left:1px solid #999 ;'>"+"(一)主要结论："+conclusion+"</td>"+"</tr>");
		                                    	var tr_scaledetails = $("<tr class='tab_table'>"+"<td colspan='3' style='border-left:1px solid #999 ;'>"+"(二)量表详情"+"</td>"+"</tr>");
		                                    	tables.append(tr_headline);
		                                    	tables.append(tr_mainresults);
		                                    	tables.append(tr_scaledetails);
		                                    	var tr1 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + "序号" + "</td>" + "<td>" + "问题" + "</td>"  + "<td>" + "内容" + "</td>"  + "</tr>");
		                                    	tables.append(tr1);
			                                   
				                                    for (var j = 0; j < sjs.length; j++) {
															if(sjs[j].questionName=="PA"||sjs[j].questionName=="NA"||sjs[j].questionName=="PE"||sjs[j].questionName=="NE"){
																continue;
															}
					                                        if (sjs[j].questionName == null|| sjs[j].questionName =="") {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;'></td>" + "<td></td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "</tr>");
					                                            tables.append(tr3);
					                                        } else {
					                                            var tr3 = $("<tr class='tab_table'>" + "<td style='border-left:1px solid #999 ;' class='tab_td'>" + n + "</td>" + "<td class='tab_td2'>" + sjs[j].questionName + "</td>" + "<td class='tab_left'>" + sjs[j].answerName + "</td>" + "</tr>");
					                                            n++;
					                                            tables.append(tr3);
					                                        }
				                                    }
				                                if(resultName=="简易智能精神状态检查量表(MMSE)"){
		                                    		var tr_detailremarks = $("<tr class='tab_table'>"+"<td colspan='4'>"+textmmse+"</td>"+"</tr>");
		                                    		tables.append(tr_remarks);
		                                    		tables.append(tr_detailremarks);
		                                    	}
		                                    	 
		                                    	$('.footer').append(tables);  
		                                    	
		                                    }
		                                }
		                                
                            	}
                            	//=============for外=============
                            	$('#scale').val(scale);
                                $('.footer').append(div);
                                $('#assess_button').attr("disabled", true);
                                $("#assess_button").css("color", "#999");
                            	}
                            }
							$("#mask_zhezhao",parent.document).hide();
                            $(".assess_").hide();
                        });
                    }
                   
                }
            });
			
            $('#delete_assess').click(function () {
                $('#assess_button').attr("disabled", false).css("color", "#ffffff");
                $("#div_service").find('input').attr("checked", false);
                //$(".assessput,.details,.chief:checkbox").attr("checked",false);
                $("#assessfirst").attr("checked", false);
                $('.domo').remove();
                $('.tab_table').remove();
                $('.zonghe').remove();
                $('textarea').remove();
                $('.xiugai').remove();
                $('.baocui').remove();
            });

        });
        $(".xiugai").live('click', function () {
            $(this).parent().parent().find("textarea").removeAttr("disabled");
        });
        $(".baocui").live('click', function () {
            $(this).parent().parent().find("textarea").attr("disabled", "disabled");

        });
        //获取订单表单
        $(function () {
            $("#checked_indent").click(function () {
                if (this.checked) {
                    $(".itemput").attr("checked", true);
                } else {
                    $(".itemput").attr("checked", false);
                }

            });


        });

        $("#pvw").click(function () {
        	if($('.clone_tab_tr').length==0){
        		 $('.tas_tr').remove();
        	}
        	
          if ($('#control').val() != null && $('#control').val() != "") {
          		
          		$('#biaoti').hide();
                $(".footer").toggle();
                $(".basic").hide();
                $(".plan").hide();
                $(".service").hide();
                $(".assess").hide();
                $(".indent").hide();
                $(".basic_").hide();
                $(".plan_").hide();
                $(".service_").hide();
                $(".assess_").hide();
                $(".indent_").hide();
                $(".servicereport").hide();
            } else {
                alert("请填写报告名称！");
            }
             if($('#service_report').val()==null||$('#service_report').val()==""){
            	$('#add_service_report').remove();
            }
        });
        $('#tijiao').click(function () {
			if($("#control").val()==""){
				alert("请填写报告名称！");
				return false;
			}
            var chiefs=$('#chiefs').val();
            $("#chief").val(chiefs);
            $(".textarea").each(function (element) {
                var text = this.value ;
              	var arry = text.split("\n");
              	var div=$('<div></div>');
              	for(var i=0;i<arry.length;i++){
					var p=$('<p></p>');
					p.append(arry[i]);
					div.append(p);             			
              	}
          		 $(this).parent().find(".textpro").append(div);
               	
                $(this).parent().find("button").remove();
                $(this).remove();

            });
            if($('#service_report').val()==null||$('#service_report').val()==""){
            	$('#add_service_report').remove();
            }
            $(".tab_td1").css('text-align','left')
            $(".tab_td2").css('text-align','left')
            $(".tab_left").css('text-align','left')
            var control = $('#control').val();
            var rUserId =${rUser.id};
            var reportType = '$!sessionUser.cateEnum.name';
            var principal = '$!sessionUser.name';
            $('#reportName').val(control);
            $('#rUserId').val(rUserId);
            $('#reportType').val(reportType);
            $('#principal').val(principal);
            $('.footer').append($('#gds').html());
            $('.footer').append($('.stern'));
            $('.jielun_gds').append($('#brenk'));
            var html = $('.footer').html();
            $("#hidden").val(html);
           
            $('#from').submit();
        });
    </script>
</div>
</body>
</html>