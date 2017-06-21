<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>用户主页</title>
    <link rel="stylesheet" href="/assets/css/common.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
	<script src="/assets/js/highcharts.js"></script>
	<script src="/assets/js/highcharts-more.src.js"></script>
     <script language="javascript"> 
	if(top.location!==self.location){ 
	top.location.href=self.location.href; 
	} 
	</script>  
     <style>
         .bodyposition{ margin-right:5%;margin-left:5%;}
         #rightIframe{border:0px;width:82%;height:14200px;float:right;}
         .divcss5{padding:20px; width:189px;height:360px;border:1px solid #C5C5C5;padding:0px;} 
         .divcss5{border:1px solid #C5C5C5} 
         .divcss6{margin-left:33px;}
         #nav{float:left;width:14.9%;background:#12D4E0}
         #nav li{ font-size:16px;}
        .nav>li> a:hover,
        .nav-pills>li a:focus{background-color:#4CEDF7 !important;}
         .nav>li>a {position: relative;display: block;padding: 10px 45px;}
         .rolord{background-color:#CCFFFF;}
	</style>
</head>
<body>
<div id="mask_zhezhao" style="width:100%;height:100%;background: rgba(0, 0, 0, 0.2);display:none;position:fixed;z-index:9999;text-align:center;padding-top:20%;font-size:40px;">
	加载中...
</div>
<div class="">
    #parse("/common/head.tpl")
	   
	    <input  type="hidden"  id="voluntary" value="$!voluntarycount">
	    <input type="hidden"  id="default" value="$!count">
	    <input type="hidden"  id="pubdate" name="pubdate" value="$!date.format('yyyy-MM-dd',$!activity.pubdate)"/>
    <div class="bodyposition">
    	<div id="mainDiv">
		    <br/>
		    <iframe id="rightIframe" src="/professional/vender/user/detail_from/$!{user.id}"  class="rightIframe" style="height:4200px;"></iframe><br/>
	    </div>
	   
    	<div >
    		<div class="divcss5">
    			 <div class=" divcss6 "><img src="/$!{user.head}" onerror="this.src='/assets/css/img/people.png'" alt="头像"  style="width:118px;height:148px;"/></div>
    			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$!{user.name}&nbsp;&nbsp; &nbsp; #if($!{user.gender}==0)女#else男#end&nbsp;&nbsp;&nbsp;  $!{user.age}岁<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$!{user.addr}
    			<div id="container" class="" style=" height:150px;width:189px; margin:0px; ">
		   </div>   
    		</div>
    		
    		<br/>
		    <ul id="nav" class="nav" >
		        <li id="activity_plan" ><a>报告</a></li>
		        <li id="activity_aged"><a>计划</a></li>
		        <li id="activity_voluntary"><a>健康档案</a></li>
		        <li id="activity_serve"><a>警报</a></li>
		        <li id="assess"><a>评估</a></li>
		        <li id="condition"><a>状态</a></li>
		     	<!-- <li id="brainwave"><a>脑电波</a></li> -->
		       	#if ($sessionUser.cateEnum.type==3)
		        <li id="facilitator"><a>添加服务商</a></li>
		        #elseif($sessionUser.cateEnum.type==4)
		        #if($!{sessionUser.isSuper_()}==true)
			        <li id="setup"><a>员工分配</a></li>
			        <li id="checkin"><a>签到统计</a></li>
		        #end
		        #end
		    </ul>
	    </div>
     </div>
     </div>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>

<script type="text/javascript">
    $(function(){
			var id=$('#activityId').val();
			var pubdate=$('#pubdate').val();
    		var myDate = new Date();
			var year=myDate.getFullYear();
    		$('#activity_plan').click(function(){
				$(this).attr("style","backgroud-color:red");
				$('#rightIframe').attr("src","/professional/vender/baogao?userId=$!{user.id}");
    		
    		});
    		//判断
    		$('#assess').click(function(){
    			$('#rightIframe').attr("src","/professional/vender/assess?userId=$!{user.id}");
    		});
			$('#activity_aged').click(function(){
					$('#rightIframe').attr("src","/professional/plan?userId=$!{user.id}");
			});
    		
    		$('#activity_voluntary').click(function(){
    				$('#rightIframe').attr("src","/professional/service/list?userId=$!{user.id}");
    		});
    		$('#activity_serve').click(function(){
				$('#rightIframe').attr("src","/professional/alarm?userId=$!{user.id}");
    		});
    		$('#condition').click(function(){
				$('#rightIframe').attr("src","/professional/state?userId=$!{user.id}");
    		});
    		$('#facilitator').click(function(){
				$('#rightIframe').attr("src","/professional/facilitator?userId=$!{user.id}");
    		});
    		$('#setup').click(function(){
				$('#rightIframe').attr("src","/professional/setup?userId=$!{user.id}");
    		});
    		$('#checkin').click(function(){
				$('#rightIframe').attr("src","/professional/checkin?userId=$!{user.id}&year="+year);
    		});
    		$('#brainwave').click(function(){
				$('#rightIframe').attr("src","/professional/user/brainwave?userId=$!{user.id}");
    		});
            $("#nav").children().click(function(){
                $(this).parent().children().attr("class","");
                $(this).attr("class","active");
            })
            
           $("#checkall").click(function(){ 
				if(this.checked){ 
					$("input[name='code']").each(function(){this.checked=true;}); 
				}else{ 
					$("input[name='code']").each(function(){this.checked=false;}); 
					} 
			   });
    });
    
    $(function(){
    	$('#nav li').each(function(){
    		$(this).click(function(){
    			$(this).addClass('rolord');
    		});
    	});
    });

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
				textTransform: 'uppercase'
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
		if($stauts_m==null||$stauts_m==""){
			$('#container').hide();
		}
		
	});
</script>
</body>
</html>