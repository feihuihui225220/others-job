<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>老年人前端_我的信息</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/highcharts.js"></script>
<script src="/assets/js/highcharts-more.src.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<style>
	 .divcss5{padding:40px; width:240px;height:480px;border:1px solid #C5C5C5;padding:8px;} 
	 .divcss5{border:1px solid #C5C5C5} 
	 .divcss6{margin-left:60px;margin-top:15px;padding:0px; }
	 .divcss7{margin-left:60px;padding:0px;position:relative;top:-12px; }
	 #container{height:250px;width:240px; margin:0px;}
</style>
</head>
<body>
<div class=" ">
	<div class="divcss5">
    			 <div class=" divcss6 "><img src="/$!{user.head}" onerror="this.src='/assets/css/img/people.png'" alt="头像"/></div><br/>
    			<div class=" divcss7 ">$!{user.name}&nbsp;&nbsp; &nbsp; #if($!{user.gender}==0)女#else男#end&nbsp;&nbsp;&nbsp;  $!{user.age}岁<br/> $!{user.addr}</div>
    			<div id="container" >
   </div>              		
</div>
<script type="text/javascript">
$(function () {
	
		$('#container').highcharts({
		    chart: {
		         backgroundColor: '#D9EBEB',
		         polar: true,
		         type: 'line'
		    },
		subtitle: {
			style: {
				color: '#E0E0E3',
				textTransform: 'uppercase'
			}
		},
		    title: {
		        text: null
		    },
		    pane: {
		    	size: '52%'
		    },
		    xAxis: {
		    	gridLineColor: '#707073',
		        categories: ['日常饮食', '运动状况', '精神状态', '医疗健康', 
		                '休闲爱好', '社会支持'],
		        tickmarkPlacement: 'on',
		        lineWidth: 1,
		        style: {
				color: '#E0E0E3',
				'fontSize' : '18px'
			}
		    },
		    legend: {
				enabled: false
			},
			yAxis: {
				lineWidth: 0,
				min: 0,
				labels:{
				enabled:false //Y轴刻度值不显示
				}
				},
		    series: [{
		        data: [
		        	#set($i=1)
					#foreach($n in$stauts_m)
						#if($i<6)
						$n,
						#else
						$n
						#end
					#end
				],
		    }]
		
		});
		if($stauts_m==null){
			$('#container').hide();
		};
		
	});
</script>
</body>
</html>