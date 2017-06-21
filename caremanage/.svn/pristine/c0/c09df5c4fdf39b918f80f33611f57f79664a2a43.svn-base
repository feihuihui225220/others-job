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

<div class="wrapper">
    #parse("/common/head.tpl")
       <div id="left">
	        #parse("/common/providers.tpl")
       </div>
	   <div class="main">
	    <div >
		    <div id="right">  
		       <div>
		       <div id="container" style="width: 410px; height: 260px; margin-left:30px;margin-top:10px;float:left; "></div>
		       <div id="container_1" style="width: 410px; height: 260px; margin-left:30px;margin-top:10px;float:left;"></div>
		       </div>
		       <div>
		       <div id="container1" style="width: 410px; height: 260px; margin-left:30px;margin-top:10px;float:left;"></div>
		       <div id="container_2" style="width: 410px; height: 260px;  margin-left:30px;margin-top:10px;float:left; "></div>
		       </div>
		       <div>
		       <div id="container2" style="width: 410px; height: 260px;  margin-left:30px;margin-top:10px;float:left;"></div>
		       <div id="container_3" style="width: 410px; height: 260px; margin-left:30px;margin-top:10px;float:left; "></div>
		       </div>
		    </div>
	    </div>
	   </div> 
</div>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/highcharts.js"></script>
<script>
$(function () {
  #foreach($m1 in $mv1)
    #if($m1.verifyMode==0)
    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'T值比较'
        },
        
        xAxis: {
            categories: [
                '单总体T检验','独立样本T检验'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0
           
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '检查值',
            data: [#if($m1.testValue1<0)0 #else $m1.testValue1 #end,#if($m1.testValue2<0)0 #else $m1.testValue2 #end]
        }, {
            name: '临界值',
            data: [$m1.criticalValue1,$m1.criticalValue1]
        }]
    });
   #elseif($m1.verifyMode==1)
   $('#container1').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'KF独立性检验'
        },
        
        xAxis: {
            categories: [
                '独立性检验'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0
           
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '检查值',
            data: [#if($m1.testValue1<0)0 #else $m1.testValue1 #end]
        }, {
            name: '临界值',
            data: [$m1.criticalValue1]
        }]
    });
   #elseif($m1.verifyMode==2)
    $('#container2').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'F单因素方差分析'
        },
        
        xAxis: {
            categories: [
                '单因素方差分析'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0
           
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '检查值',
            data: [#if($m1.testValue1<0)0 #else $m1.testValue1 #end]
        }, {
            name: '临界值',
            data: [$m1.criticalValue1]
        }]
    });
   #end
   #end
  <!----------------------------双因素------------------------------------>
  #foreach($m1 in $mv2)
    #if($m1.verifyMode==0)
    $('#container_1').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '不同特征的群体独立样本t检验'
        },
        
        xAxis: {
            categories: [
                '群体独立样本t检验'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0
           
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '检查值',
            data: [#if($m1.testValue1<0)0 #else $m1.testValue1 #end]
        }, {
            name: '临界值',
            data: [$m1.criticalValue1]
        }]
    });
   #elseif($m1.verifyMode==1)
   $('#container_2').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'KF统一性检验'
        },
        
        xAxis: {
            categories: [
                '独立性检验'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0
           
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '检查值',
            data: [#if($m1.testValue1<0)0 #else $m1.testValue1 #end]
        }, {
            name: '临界值',
            data: [$m1.criticalValue1]
        }]
    });
   #elseif($m1.verifyMode==2)
    $('#container_3').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'F单因素方差分析'
        },
        
        xAxis: {
            categories: [
                '单因素方差分析'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0
           
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f} </b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '检查值',
            data: [#if($m1.testValue1<0)0 #else $m1.testValue1 #end,#if($m1.testValue2<0)0 #else $m1.testValue2 #end,#if($m1.testValue3<0)0 #else $m1.testValue3 #end]
        }, {
            name: '临界值',
            data: [$m1.criticalValue1,$m1.criticalValue2,$m1.criticalValue1]
        }]
    });
   #end
   #end
   
});


</script>
</body>
</html>