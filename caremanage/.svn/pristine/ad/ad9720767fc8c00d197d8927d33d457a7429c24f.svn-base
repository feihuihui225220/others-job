<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息</title>   
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="../../assets/js/common.js"></script>
<script src="../../assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
<style>
.list_my li {float:left;width:320px;margin-right:30px;border:1px solid #ddd;padding:10px 0 0 10px;margin-bottom:20px;}
.list_my li h4 {background:#f2f2f2;border-bottom:1px solid #ddd;font-size:14px;height:26px;line-height:26px;margin-bottom:10px;padding-left:6px;width:304px;color:#299DCA;}
.list_my li a {color:#333;display:block;}
.list_my li a:hover {text-decoration:none;}
.list_my li div {float:left;width:90px;margin-right:5px;margin-bottom:10px;text-align:center;background:#f2f2f2;padding:5px;}
.list_my li div h5 {border-bottom:1px solid #ddd;text-align:left;margin:0;padding-bottom:3px;color:green;margin-bottom:3px;padding-left:5px;} */
.inpubox{padding:0;}
.searchli {border-bottom:1px solid #000;margin:0 0 20px 0;}
.rightbtn button{line-height:16px\0;}
.popover{color:#000000;}
.nopadding{padding: 0}
.progress-bar-default{background-color: #f5f5f5;height: 21px;}
.progress-bar{overflow: visible;}
</style>
</head>

<body>

<div class="main1">
  #parse("/common/dtop.tpl")
    #parse("/common/duser.tpl")
  <div>
	<div class="contentPer">#parse("/common/dleft.tpl")</div>
    	<div class="personInfo_right fl" style="float: left;">
     		#if($!{sessionUser.getCateEnum()}=="USER")
					 #end
				      时间:$newDate
				    <div id="container"></div>
				 	<div id="container1" style="min-width:700px;height:400px"></div>
				          	<div class="row">
				          		<div class="col-sm-3 col-sm-offset-2">
				         				<ol class="breadcrumb" style="background-color: transparent;margin-top: 20px;">
						                  <li><a>$!date.format('yyyy-MM-dd',$!datecond.start)</a></li>
						                  <li><a>$!date.format('yyyy-MM-dd',$!datecond.end)</a></li>
						                </ol>
				     			</div>	
				          		<div class="col-sm-6">	
				          			<ul class="pager pull-right">
						           		<li><a href="/director/service/history?userId=$!userId&serviceId=$!serviceId&type=$!type&start=$!date.format('yyyy-MM-dd',$!qianqi)&end=$!date.format('yyyy-MM-dd',$!qianmo)">&larr;上一天</a></li>
						              <li><a href="/director/service/history?userId=$!userId&serviceId=$!serviceId&type=$!type&start=$!date.format('yyyy-MM-dd',$!houqi)&end=$!date.format('yyyy-MM-dd',$!houmo)">下一天&rarr;</a></li>
						            </ul>
				          		</div>
				          	</div>
    	</div>
  	</div>
   </div>
</body>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/highcharts.js"></script>
<script src="$request.contextPath/assets/js/bootstrap.min.js"></script>
<script>
var tasks = [{
    name: '在床',
    intervals: [ 
     #set($m="")
     #foreach($datas in $beds)
		#if($datas[2]=="on")
		$m
		{
        from: Date.UTC(0, 0, 0, $!date.format('HH',$datas[0]),$!date.format('mm',$datas[0]),$!date.format('ss',$datas[0])),
        to: Date.UTC(0, 0, 0, $!date.format('HH',$datas[1]),$!date.format('mm',$datas[1]),$!date.format('ss',$datas[1]))
    	} #set($m=",")
    	#end
   	 #end
   	  ]
}, {
    name: '离床',
    intervals: [
     #set($a="")
      #foreach($datas in $beds)
		#if($datas[2]=="off")
		$a
		{
        from: Date.UTC(0, 0, 0, $!date.format('HH',$datas[0]),$!date.format('mm',$datas[0]),$!date.format('ss',$datas[0])),
        to: Date.UTC(0, 0, 0, $!date.format('HH',$datas[1]),$!date.format('mm',$datas[1]),$!date.format('ss',$datas[1]))
    	}#set($a=",") 
    	#end
   	 #end
    ]
}, {
    name: '体动',
    intervals: [
     #set($i="")
     #foreach($datas in $beds)
		
		#if($datas[2]=="mov")
		$i
		{
        from: Date.UTC(0, 0, 0, $!date.format('HH',$datas[0]),$!date.format('mm',$datas[0]),$!date.format('ss',$datas[0])),
        to: Date.UTC(0, 0, 0, $!date.format('HH',$datas[1]),$!date.format('mm',$datas[1]),$!date.format('ss',$datas[1]))
    	} #set($i=",")
    	#end
   	 #end
   ]
}];

var series = [];
$.each(tasks.reverse(), function(i, task) {
    var item = {
        name: task.name,
        data: []
    };
    $.each(task.intervals, function(j, interval) {
        item.data.push({
            x: interval.from,
            y: i,
            label: interval.label,
            from: interval.from,
            to: interval.to
        }, {
            x: interval.to,
            y: i,
            from: interval.from,
            to: interval.to
        });
        
        if (task.intervals[j + 1]) {
            item.data.push(
                [(interval.to + task.intervals[j + 1].from) / 2, null]
            );
        }

    });
	
    series.push(item);
});

var chart = new Highcharts.Chart({

    chart: {
        renderTo: 'container'
    },
    
    title: {
        text: '智能床垫'
    },

    xAxis: {
        type: 'datetime'
    },

    yAxis: {
        tickInterval: 1,
        labels: {
            formatter: function() {
                if (tasks[this.value]) {
                    return tasks[this.value].name;
                }
            }
        },
        startOnTick: false,
        endOnTick: false,
        title: {
            text: 'Activity'
        },
            minPadding: 0.2,
                maxPadding: 0.2
    },

    legend: {
        enabled: true
    },

    tooltip: {
        formatter: function() {
            return '<b>'+ tasks[this.y].name + '</b><br/>' +
                Highcharts.dateFormat('%H:%M:%S', this.point.options.from)  +
                ' - ' + Highcharts.dateFormat('%H:%M:%S', this.point.options.to); 
        }
    },
	
    plotOptions: {
        line: {
            lineWidth: 9,
            marker: {
                enabled: true
            },
            dataLabels: {
                enabled: true,
                align: 'left',
                formatter: function() {
                    return this.point.options && this.point.options.label;
                }
            }
        }
    },

    series: series
	
});

$(function () {
$(".personInfo .personInfo_left .sidebar li a").eq(3).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
  $('#container1').highcharts({
       chart: {
            type: 'spline'
        },
        title: {
            text: '心跳频率'
        },
       
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: { // don't display the dummy year
                month: '%e. %b',
                year: '%b'
            }
        },
        yAxis: {
            title: {
                text: '次数(min/次)'
            },
            min: 0
        },
        plotOptions: {
          spline: {
              lineWidth: 4,
             
              marker: {
                  enabled: false
              }
             
          }
      },
        series: [{
            name: '心跳次数',
            data: [
            	#foreach($da in $pant)
					#if($foreach.index!=0)
					,
					#end
					 [Date.UTC(0, 0, 0,$!date.format('HH',$da[0]),$!date.format('mm',$da[0]),$!date.format('ss',$da[0])), $da[1]   ] 
				#end
              
            ]
        }]
    });
});	

</script>
</html>
