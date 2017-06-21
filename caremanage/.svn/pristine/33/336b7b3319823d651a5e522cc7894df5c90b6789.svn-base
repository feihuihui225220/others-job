<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>管理系统首页</title>
    <link href="/assets/newCss/common.css" rel="stylesheet" type="text/css">
    <link href="/assets/newCss/statistics.css" rel="stylesheet" type="text/css">
</head>
<style>
	#todaytask2{background-color:#35b5f1;color:#fff;}
</style>
<body>
    #parse("/common/head.tpl")
    <div class="location"><span class="currentlocation">当前位置：</span><span>首页</span>&gt;<span>排课统计</span></div>
    <div class="main">
        #parse("/common/lhtTeacher.tpl")
        <div class="content fl">
        	<div class="wrap">
        			<div class="date">
						<form action="/professional/activity/statistics" id="statistics" method="post" name="searchForm">               
                        <span>从</span>
                        <input name="start" class="timedate" type="text" value="$!date.format('yyyy-MM-dd',$!dateCond.start)">
                        <span>到</span>
                        <input class="timedate"   name="end" type="text" value="$!date.format('yyyy-MM-dd',$!dateCond.end)">
                        <a class="select" href="#">确定</a>
                    </form>
                    </div>
                    <div class="sta_pic">
                        <div class="stationCounts"><p>$!sumz</p></div>
                        <div class="courseCounts"><p>$!plansumz</p></div>
                        <div class="time"><p>$!planTime min</p></div>
                        <div class="finishCounts"><p>$!classsumw</p></div>
                        <div class="undone"><p>$!plansumw</p></div><br><br><br><br><br><br>
                        <label>服务站点总量</label><label>&nbsp;&nbsp;活动总次数</label><label>&nbsp;&nbsp;&nbsp;&nbsp;活动总时长</label><label>&nbsp;&nbsp;已完成排课量</label><label>未完成排课次数</label>
                    </div>
                    <div class="chart">
                         <div id="lineChart" style="min-width:700px;height:400px"></div>
                    </div>
                    <br><br><br><br><br>
        			<div class="currentName" style="cursor:pointer;">导出当前名单</div>
                    #if($StatisticsVO)
                    <div id="myPrintArea" style="font-family:楷体;">

                    <table class="prent" cellpadding="8">
                        <tr>
                            <th>序号</th>
                            <th>站点名称</th>
                            <th>活动总量</th>
                            <th>活动时长</th>
                            <th>实际排课数量</th>
                            <th>未排课数量</th>
                           
                        </tr>
                       #foreach($s in $StatisticsVO)
                        #set($i =$velocityCount + 1)
                        <tr>
                            <td>$i</td>
                            <td>$s.SiteName</td>
                            <td>$s.Sumz</td>
                            <td>$s.STime min</td>
                            <td>$s.WPlan</td>
                            <td>$s.Sumw</td>
                        </tr>
                        #end
                    </table>
                    #end
                    </div>
        	</div>
        </div>
    </div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/highcharts.js"></script>
<script src="$request.contextPath/assets/js/jQuery.print.js"></script>
<script>
	$(function(){
	 	$(".timedate").calendar({ format:'yyyy-MM-dd' });
		$('.currentName').click(function(){
			$.print("#myPrintArea");
		});
		$('.select').click(function(){
			$('#statistics').submit();
		});
	
	    $('#lineChart').highcharts({
	        title: {
	        	text: '月份排课统计图表',
	        	x: -20 //center
	    	},
	    	colors: ["#DDDF0D", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
	   	 	chart: { backgroundColor: '#16A8FD' },
	    	xAxis: {
	    		gridLineWidth: 1, labels: { style: { fontSize: '12px' } },
	 	       categories: [
					#foreach($da in $date)
	   		     		#if($foreach.index!=0)
	    	    		,
	        			#end
	        			'$da'
	 	       	#end
				]
			
	    	},
	    	yAxis: {
	        title: {
	               		text: '课程数量'
	            	},
	            min:0
	    	},
	    	tooltip: {
	       	 valueSuffix: '次'
		    },
		    legend: {
				layout: 'vertical',
				align: 'right',
	        	verticalAlign: 'middle',
	        	borderWidth: 0
	    	},
	    	series: [
	    	  #foreach($siteName in $map.keySet())
	    		#if($foreach.index!=0)
	    		,
	    		#end
	    		{
	    			name:'$siteName',
	    			data:[
	    				#foreach($sitenum in $map.get($siteName))
	    					#if($foreach.index!=0)
			        		,
			        		#end
			        		$sitenum
	    				#end
	    			]
	    		}
	    	#end
	   		]
		});
	});				
</script>
</html>