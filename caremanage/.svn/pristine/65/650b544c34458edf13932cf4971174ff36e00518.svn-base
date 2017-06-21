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
#parse("/common/masklayer.tpl")
<div class="wrapper">
    <div class=" bodyline pad10 ">
    	<ul class="ul_css nav nav-tabs " role="tablist" id="myTab">
	      <li class=" "><a href="#data" role="tab" data-toggle="tab">历史数据</a></li>
	      <li><a href="#lineChart" role="tab" data-toggle="tab">图表</a></li>
	    </ul>
	    
	<!-- Tab panes -->
			<div class="tab-content">
				<div class="tab-pane fade in active  div_css " id="data">
					<div class="searchli" >
						<ul class="inpubox clearfix">
							<Form method="get" action="/professional/service/show">
								<input type="hidden" name="deviceBindId"
									value="$device.deviceBindId" /> <input type="hidden"
									name="metaServiceId" value="$device.metaServiceId" />
								<li><input class="text150 timedate" type="text"
									name="start"
									value="$!date.format('yyyy-MM-dd',$!dateCond.start)" /> 至 <input
									class="text150 timedate" type="text" name="end"
									value="$!date.format('yyyy-MM-dd',$!dateCond.end)" />
								</li>
								<li>每页<input class="text150" type="text" name="num"
									value="${data.pageSize}" style="width:40px" />条</li>
								<li><input class="button_add" type="submit" value="查询">
								</li>
							</Form>
						</ul>
						<Form name="searchForm" method="get"
							action="/professional/service/show">
							<input type="hidden" name="deviceBindId"
								value="$device.deviceBindId" /> <input type="hidden"
								name="metaServiceId" value="$device.metaServiceId" /> <input
								type="hidden" name="start"
								value="$!date.format('yyyy-MM-dd',$!dateCond.start)" /> <input
								type="hidden" name="end"
								value="$!date.format('yyyy-MM-dd',$!dateCond.end)" /> <input
								type="hidden" name="num" value="${data.pageSize}" />
						</Form>
					</div>
					<div class="tablebox">
						<table class="table100 usertable cen">
							<tr>
								#foreach ($title in $data.titles)
								<th>${title}</th> #end
							</tr>
							#foreach ($da in $data.values)
							<tr>
								#foreach($d in $da) #if($foreach.index==0)
								<td>$!date.format('yyyy-MM-dd HH:mm',$!d)</td> #else
								<td>$!d</td> #end #end
							</tr>
							#end
						</table>
						#set($page = $data) #parse("/common/page.tpl")
					</div>
				</div>

				<div class="tab- fade  " id="lineChart">
				</div>
			</div>

		</div>
</div>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/highcharts.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script>
	$(function () {
	    $('#lineChart').highcharts({
	        chart: {
	            type: 'spline'
	        },
	        title: {
	            text: '$!data.name'
	        },
	        xAxis: {
	            categories: [
	            	#foreach($da in $data.values)
	            		#if($foreach.index!=0)
	            		,
	            		#end
	            		'$!date.format('yyyy-MM-dd HH:mm',$!da.get(0))'
	            	#end
	            ]
	        },
	        yAxis: {
	            title: {
	               text: '测量值'
	            },
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
	        	#foreach($title in $data.titles)
	        	#set($index = $foreach.index)
	        	#if($foreach.index!=0)
	        	#if($foreach.index!=1)
	        	,
	        	#end
	        	{
	            name: '$title',
	            data: [
	            				#foreach($da in $data.values)
	            					#if($foreach.index!=0)
	            					,
	            					#end
	            					$da.get($index)
	            				#end
	            			]
	        	}
	        	#end
	        	#end
	        ]
	    });
	    $(".timedate").calendar({ format:'yyyy-MM-dd' });
	});				
</script>
</body>
</html>