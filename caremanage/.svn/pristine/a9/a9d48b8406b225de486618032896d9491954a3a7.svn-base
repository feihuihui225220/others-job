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

</head>
<body>
<div class="wrapper">
<div class="actboxlist">
            <table class="table100 usertable  trclick ">
            	<tr>
            		<th>一级指标</th>
            		<th>二级指标</th>
            		<th>干预前</th>
            		<th>干预后</th>
            		<th>干预效果</th>
            	</tr>
            	<!--  体适能  -->
            	 #if($assess1||$assess2||$assess3||$assess4||$assess5||$assess6||$assess7||$assess8)
            	 <tr >
                	<td rowspan="8">体适能</td>
                	#if($assess1)
                	<td class="click_td" >日常生活自理能力</td>
                	<td class="click_td" >$!assess1.interveneGo</td>
                	<td class="click_td" >$!assess1.interveneLa</td>
                	<td class="click_td" >#if($!assess1.interveneLa>$!assess1.interveneGo) 能力有所提升 #elseif($!assess1.interveneLa==$!assess1.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess2)
                	<td class="click_td" >工具性活动能力</td>
                	<td class="click_td" >$!assess2.interveneGo</td>
                	<td class="click_td" >$!assess2.interveneLa</td>
                	<td class="click_td" >#if($!assess2.interveneLa<$!assess2.interveneGo) 能力有所提升 #elseif($!assess2.interveneLa==$!assess2.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess3)
                	<td class="click_td" >身体成分</td>
                	<td class="click_td" >$!assess3.interveneGo</td>
                	<td class="click_td" >$!assess3.interveneLa</td>
                	<td class="click_td" >#if($!assess3.interveneLa<$!assess3.interveneGo) 能力有所提升 #elseif($!assess3.interveneLa==$!assess3.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	
	              	#end
                </tr>
                 <tr>
                	#if($assess4)
                	<td class="click_td" >肌力及肌耐力</td>
	              	<td class="click_td" >$!assess4.interveneGo</td>
                	<td class="click_td" >$!assess4.interveneLa</td>
                	<td class="click_td" >#if($!assess4.interveneLa>$!assess4.interveneGo) 能力有所提升 #elseif($!assess4.interveneLa==$!assess4.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess5)
                	<td class="click_td" >心肺耐力</td>
	              	<td class="click_td" >$!assess5.interveneGo</td>
                	<td class="click_td" >$!assess5.interveneLa</td>
                	<td class="click_td" >#if($!assess5.interveneLa>$!assess5.interveneGo) 能力有所提升 #elseif($!assess5.interveneLa==$!assess5.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess6)
                	<td class="click_td" >柔软素质</td>
	              	<td class="click_td" >$!assess6.interveneGo</td>
                	<td class="click_td" >$!assess6.interveneLa</td>
                	<td class="click_td" >#if($!assess6.interveneLa>$!assess6.interveneGo) 能力有所提升 #elseif($!assess6.interveneLa==$!assess6.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>  
                 <tr>
                	#if($assess7)
                	<td class="click_td" >神经反应</td>
	              	<td class="click_td" >$!assess7.interveneGo</td>
                	<td class="click_td" >$!assess7.interveneLa</td>
                	<td class="click_td" >#if($!assess7.interveneLa>$!assess7.interveneGo) 能力有所提升 #elseif($!assess7.interveneLa==$!assess7.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess8)
                	<td class="click_td" >血压</td>
	              	<td class="click_td" >$!assess8.interveneGo</td>
                	<td class="click_td" >$!assess8.interveneLa</td>
                	<td class="click_td" >#if($!assess8.interveneLa>$!assess8.interveneGo) 能力有所提升 #elseif($!assess8.interveneLa==$!assess8.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
 				#end
                <!-  认知功能  ->
                #if($assess9||$assess10||$assess11||$assess12||$assess13||$assess14||$assess15||$assess16||$assess17||$assess18)
                
                 <tr>
                	#if($assess9)
                	<td rowspan="10">认知功能</td>
                	<td class="click_td" >定向力（时间、地点）</td>
	              	<td class="click_td" >$!assess9.interveneGo</td>
                	<td class="click_td" >$!assess9.interveneLa</td>
                	<td class="click_td" >#if($!assess9.interveneLa>$!assess9.interveneGo) 能力有所提升 #elseif($!assess9.interveneLa==$!assess9.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess10)
                	<td class="click_td" >注意力和集中力</td>
	              	<td class="click_td" >$!assess10.interveneGo</td>
                	<td class="click_td" >$!assess10.interveneLa</td>
                	<td class="click_td" >#if($!assess10.interveneLa>$!assess10.interveneGo) 能力有所提升 #elseif($!assess10.interveneLa==$!assess10.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess11)
                	<td class="click_td" >记忆力</td>
	              	<td class="click_td" >$!assess11.interveneGo</td>
                	<td class="click_td" >$!assess11.interveneLa</td>
                	<td class="click_td" >#if($!assess11.interveneLa>$!assess11.interveneGo) 能力有所提升 #elseif($!assess11.interveneLa==$!assess11.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess12)
                	<td class="click_td" >回忆力</td>
	              	<td class="click_td" >$!assess12.interveneGo</td>
                	<td class="click_td" >$!assess12.interveneLa</td>
                	<td class="click_td" >#if($!assess12.interveneLa>$!assess12.interveneGo) 能力有所提升 #elseif($!assess12.interveneLa==$!assess12.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess13)
                	<td class="click_td" >抽象思维</td>
	              	<td class="click_td" >$!assess13.interveneGo</td>
                	<td class="click_td" >$!assess13.interveneLa</td>
                	<td class="click_td" >#if($!assess13.interveneLa>$!assess13.interveneGo) 能力有所提升 #elseif($!assess13.interveneLa==$!assess13.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess14)
                	<td class="click_td" >视结构技能</td>
	              	<td class="click_td" >$!assess14.interveneGo</td>
                	<td class="click_td" >$!assess14.interveneLa</td>
                	<td class="click_td" >#if($!assess14.interveneLa>$!assess14.interveneGo) 能力有所提升 #elseif($!assess14.interveneLa==$!assess14.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess15)
                	<td class="click_td" >执行能力</td>
	              	<td class="click_td" >$!assess15.interveneGo</td>
                	<td class="click_td" >$!assess15.interveneLa</td>
                	<td class="click_td" >#if($!assess15.interveneLa>$!assess15.interveneGo) 能力有所提升 #elseif($!assess15.interveneLa==$!assess15.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                 <tr>
                	#if($assess16)
                	<td class="click_td" >计算力</td>
	              	<td class="click_td" >$!assess16.interveneGo</td>
                	<td class="click_td" >$!assess16.interveneLa</td>
                	<td class="click_td" >#if($!assess16.interveneLa>$!assess16.interveneGo) 能力有所提升 #elseif($!assess16.interveneLa==$!assess16.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                <tr>
                	#if($assess17)
                	<td class="click_td" >心理素质</td>
                	<td class="click_td" >$!assess17.interveneGo</td>
                	<td class="click_td" >$!assess17.interveneLa</td>
                	<td class="click_td" >#if($!assess17.interveneLa<$!assess17.interveneGo) 能力有所提升 #elseif($!assess17.interveneLa==$!assess17.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
                <tr>
                	#if($assess18)
                	<td class="click_td" >语言能力</td>
	              	<td class="click_td" >$!assess18.interveneGo</td>
                	<td class="click_td" >$!assess18.interveneLa</td>
                	<td class="click_td" >#if($!assess18.interveneLa>$!assess18.interveneGo) 能力有所提升 #elseif($!assess18.interveneLa==$!assess18.interveneGo) 能力不变 #else 能力减弱 #end</td>
	              	#end
                </tr>
              	#end
            <table>
        </div>
        <div id="container" style="min-width:400px;height:400px"></div>
        <div id="container1" style="min-width:400px;height:400px"></div>
        <div id="container3" style="min-width:400px;height:400px"></div>
        <div id="container2" style="min-width:400px;height:400px"></div>
</div>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/highcharts.js"></script>
<script src="/assets/js/highcharts-more.src.js"></script>
<script>
$(function () {
    var categories = [
	  #if($assess1)   '日常生活自理能力', #end
	  #if($assess2)   '工具性活动能力',   #end
	  #if($assess4)   '肌耐力',           #end
	  #if($assess5)   '心肺耐力',         #end
	  #if($assess6)   '柔软素质',         #end
	  #if($assess7)   '神经反应能力',     #end
	  #if($assess9)   '定向力',           #end
	  #if($assess10)  '注意力和集中力',   #end  
	  #if($assess11)  '记忆力',           #end
	  #if($assess12)  '回忆力',           #end
	  #if($assess13)  '抽象思维',         #end
	  #if($assess14)  '视结构技能',       #end
	  #if($assess15)  '执行能力',         #end
	  #if($assess16)  '计算力',           #end
	  #if($assess17)  '心理素质',         #end
	  #if($assess18)  '语言能力',         #end
    ];
    
    categories: ['柔软素质','肌力', '神经反应能力', '心肺耐力','BMI' ],
    $(document).ready(function () {   
        $('#container').highcharts({
            chart: {
                type: 'bar'
            },
            title: {
                text: '干预前后指标得分双向条形图'
            },
           
            xAxis: [{
                categories: categories,
                reversed: false,
                labels: {
                    step: 1
                }
            }],
            yAxis: {
                title: {
                    text: null
                },
                labels: {
                    formatter: function () {
                        return (Math.abs(this.value));
                    }
                },
               
            },
            plotOptions: {
                series: {
                    stacking: 'normal'
                }
            },
            tooltip: {
                formatter: function () {
                    return '<b>' + this.series.name + ', age ' + this.point.category + '</b><br/>' +
                        'Population: ' + Highcharts.numberFormat(Math.abs(this.point.y), 0);
                }
            },
            series: [{
                name: '干预前',
                data: [
				#if($assess1)  -$assess1.interveneGo , #end
				#if($assess2)  -$assess2.interveneGo , #end
				#if($assess4)  -$assess4.interveneGo , #end
				#if($assess5)  -$assess5.interveneGo , #end
				#if($assess6)  -$assess6.interveneGo , #end
				#if($assess7)  -$assess7.interveneGo , #end
				#if($assess9)  -$assess9.interveneGo , #end
				#if($assess10) -$assess10.interveneGo , #end
				#if($assess11) -$assess11.interveneGo , #end
				#if($assess12) -$assess12.interveneGo , #end
				#if($assess13) -$assess13.interveneGo , #end
				#if($assess14) -$assess14.interveneGo , #end
				#if($assess15) -$assess15.interveneGo , #end
				#if($assess16) -$assess16.interveneGo , #end
				#if($assess17) -$assess17.interveneGo , #end
				#if($assess18) -$assess18.interveneGo , #end
				]
            }, {
                name: '干预后',
                data: [
				#if($assess1)  $assess1.interveneLa , #end
				#if($assess2)  $assess2.interveneLa , #end
				#if($assess4)  $assess4.interveneLa , #end
				#if($assess5)  $assess5.interveneLa , #end
				#if($assess6)  $assess6.interveneLa , #end
				#if($assess7)  $assess7.interveneLa , #end
				#if($assess9)  $assess9.interveneLa , #end
				#if($assess10) $assess10.interveneLa , #end
				#if($assess11) $assess11.interveneLa , #end
				#if($assess12) $assess12.interveneLa , #end
				#if($assess13) $assess13.interveneLa , #end
				#if($assess14) $assess14.interveneLa , #end
				#if($assess15) $assess15.interveneLa , #end
				#if($assess16) $assess16.interveneLa , #end
				#if($assess17) $assess17.interveneLa , #end
				#if($assess18) $assess18.interveneLa , #end
				]
            }]
        });
    });
    
});

$(function(){
$('#container1').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '自理能力干预前后柱状图'
        },
        
        xAxis: {
            categories: [
                '日常生活自理能力','工具性活动能力'
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
            name: '干预前',
            data: [ '$assess1.interveneGo',' $assess2.interveneGo']
        }, {
            name: '干预后',
            data: [' $assess1.interveneLa',' $assess2.interveneLa']
        }]
    });
});

$(function(){
$('#container3').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '血压干预前后柱状图'
        },
        
        xAxis: {
            categories: [
                '干预前','干预后'
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
            name: '干预前',
            data: [ '$assess8.interveneGo',' $assess8.interveneGo']
        }, {
            name: '干预后',
            data: [' $assess8.interveneLa',' $assess8.interveneLa']
        }]
    });
});
</script>
<script>
$(function () {
	
		$('#container2').highcharts({
		    chart: {
		        polar: true,
		        type: 'line'
		    },
		    title: {
		        text: '综合体适能'
		    },
		    
		    xAxis: {
		    	gridLineColor: '#707073',
		        categories: [ #if($assess6)   '柔软素质',         #end
      #if($assess4)   '肌耐力',           #end
       #if($assess7)   '神经反应能力',     #end
       #if($assess5)   '心肺耐力',         #end
       #if($assess3)   '身体成分',         #end ],
		        tickmarkPlacement: 'on',
		        lineWidth: 1,
		    },
		    
			yAxis: {
				lineWidth: 0,
				min: 0,
				labels:{
				}
				},
		    series: [{
		    	name:'干预前',
		        data: [
		       		#if($assess6)  $assess6.interveneGo , #end
					#if($assess4)  $assess4.interveneGo , #end
					#if($assess7)  $assess7.interveneGo , #end
					#if($assess5)  $assess5.interveneGo , #end
					#if($assess3)  $assess3.interveneGo , #end
				]
		    },
		    {
		    	name:'干预后',
		        data: [
		    		#if($assess6) $assess6.interveneLa , #end
				#if($assess4) $assess4.interveneLa , #end
				#if($assess7) $assess7.interveneLa , #end
				#if($assess5) $assess5.interveneLa , #end
				#if($assess3) $assess3.interveneLa , #end
				]
		    }
		    ]
		
		});
		
		
	});

</script>
</body>
</html>