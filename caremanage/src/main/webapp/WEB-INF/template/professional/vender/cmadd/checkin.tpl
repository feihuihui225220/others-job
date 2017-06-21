<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>历史数据</title>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
	<br/><br/><br/><br/><br/>
	<div  id="lineChart">
	</div>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/highcharts.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script>
	$(function () {
	    $('#lineChart').highcharts({
	        chart: {
	        	backgroundColor: '#D9EBEB',
	            type: 'spline'
	        },
	        title: {
	            text: '$year年度签到情况'
	        },
	        xAxis: {
	            categories: [
	            	'一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'
	            ]
	        },
	        yAxis: {
	            title: {
	               text: '签到次数'
	            },
	           gridLineWidth: 1,
	            min:0
	        },
	        plotOptions: {
	            line: {
	                dataLabels: {
	                    enabled: true
	                },
	                enableMouseTracking: true
	            }
	        },
	        series: [
	        	
	        	{
	            name: '活动签到',
	            data: [
						#set($i=1)
					#foreach($n in$checkIn)
						#if($i<12)
						$n,
						#else
						$n
						#end
					#end
						]
	        	},
	        	{
	            name: '评估次数',
	            data: [
						#set($i=1)
					#foreach($s in$checkInassess)
						#if($i<12)
						$s,
						#else
						$s
						#end
					#end
						]
	        	}
	        	
	        ]
	    });
	    $(".timedate").calendar({ format:'yyyy-MM-dd' });
	});				
</script>
</body>
</html>