<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="author" content="angtian">
<title>站点具体内容</title> #parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/rili/clndr.css" />
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/newCss/plan.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/yui-min.js"></script>
<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
#right {
	background-color: #D9EBEB;
	margin-top: 3%;
}

.r_left {
	width: 31.8%;
	float: left;
	height: 515px;
}

.r_right {
	width: 67.9%;
	float: left;
	height: 515px;
}

.r-top {
	height: 145px;
}

.add_first {
	width: 90px;
}

.r_right div {
	padding-left: 65%;
}

.r_right div button {
	float: left;
	margin-left: 10px;
}

h1 {
	padding-left: 30px;
}

h4 {
	padding-left: 30px;
	margin-top: 30px;
}

.mytable tr td {
	border-left: 1px solid #DDDDDD;
	border-right: 1px solid #DDDDDD
}

.r_right{
			width:55%;
    		padding-top:20px;
			height: 87%;
			position: absolute;
			right:20px;
			OVERFLOW-Y: auto; OVERFLOW-X:hidden;
			zoom:0.9;
			}
</style>
</head>
<body>
	<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">#parse("/common/providers.tpl")

		<div id="right">
			<div class="r_left">
				<div class="r-top"></div>
				<div class="container1">
					<div class="cal1"></div>
				</div>
			</div>
			<div class="r_right">
				<div>
					<button class="btn-default add_first btn " id="dayin">打印</button>
					<button class="btn-default add_first btn " id="fanhui">返回</button>
				</div>
				<br />
				<table class="table _tale1  select_1">
					<tr class="_active">
						<th><label >全选<input type="checkbox" class="quanxuan">社区名称</label></th>
						<th>活动内容</th>
						<th>老人签到表</th>
						<th>志愿者签到表</th>
						<th>服务记录表</th>
						<th>活动物料汇总表</th>
					#foreach($nActivityPlan in $NActivityPlan)
					</tr>
						<td ><label >$nActivityPlan.siteIdName<input  class="xheck inputcj" type="checkbox"/></label></td>
						<td><a
							href="/professional/activity/tiaozhuan?id=$nActivityPlan.id"
							id=$nActivityPlan.id>编辑</a><input date-id="$nActivityPlan.id" class="print1" type="checkbox">打印</td>
						<td><a
							href="/professional/activity/activity_aged?id=$nActivityPlan.id&siteId=$nActivityPlan.siteIds&communityId=0&pubdate= $!date.format('yyyy-MM-dd',$nActivityPlan.pubdate)">签到</a><input date-id="$nActivityPlan.id" class="print2" type="checkbox">打印</td></td>
						<td><a
							href="/professional/activity/activity_voluntary?id=$nActivityPlan.id&&pubdate=$!date.format('yyyy-MM-dd',$nActivityPlan.pubdate)">签到</a><input date-id="$nActivityPlan.id" class="print3" type="checkbox">打印</td></td>
						<td><a>查看</a></td>
						<td><a>查看</a></td>
					</tr>
					#end
				</table>
			</div>
			<div id="myPrintArea" style="font-size:20px;font-family:楷体; " class="_tabPlan1">
				#foreach($nActivityPlan in $NActivityPlan)
					<table class="table _tale1 zhu_$nActivityPlan.id">
						<tr class="_active">
							<th style=" text-align: center;" class="active-th" colspan="6">$nActivityPlan.planName</th>
						<tr>
						<tr>
							<td>活动时间</td>
							<td colspan="5">$!date.format('yyyy-MM-dd',$nActivityPlan.pubdate)
								$nActivityPlan.planTime</td>
						<tr>
							<td>活动地点</td>
							<td colspan="5">$!nActivityPlan.planPlace</td>
						</tr>
						<tr>
							<td>活动目的</td>
							<td colspan="5">$!nActivityPlan.planDesc</td>
						</tr>
						<tr>
							<td>工作人员</td>
							<td colspan="5">#foreach($e in $nActivityPlan.employee)
								$e&nbsp; #end</td>
						</tr>
						<tr>
							<td>志愿者</td>
							<td colspan="5">#foreach($e in $VolunteerTrainingRecordVo)
								$e.volunteerName #end</td>
						</tr>
						<!--<tr>  暂无
							<td>服务对象</td>
							<td colspan="5">
								$!nActivityPlan.planAge
							</td>
						</tr>-->
						<tr>
							<td>活动时间</td>
							<td>时长</td>
							<td>活动主题</td>
							<td>活动内容</td>
							<td>活动音乐</td>
							<td>人员安排</td>
						</tr>
						
						#foreach($n in $nActivityPlan.programOfVO)
							<tr>
							<td>$!n.activeTime 暂无</td>
							<td>$n.duration</td>
							<td>$n.progranName</td>
							<td>暂无</td>
							<td>
								<!--$n.activitySuppliesMusic--> 暂无
							</td>
							<td>$n.teacher</td> 
						</tr>
						#end
					</table>
					
					<table class="table _tale1 ren_$nActivityPlan.id">
						<tr class="_active">
							<th colspan="5" style=" text-align: center;">用户签到记录表</th>
						</tr>
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>社区</th>
						</tr>
						
						#foreach($user in $nActivityPlan.ruser) 
						#set($x = $velocityCount+1)
						<tr class="#if($x%2!=0 ) tr_first  #else tr_two #end">
							<td>$x
							</th>
							<td>$user.name</td>
							<td>#if($user.gender==0)女 #else 男 #end</td>
							<td>$user.age</td>
							<td>$user.comminityName</td>
						</tr>
						#end
					</table>
					
					<table class="table _tale1 zhi_$nActivityPlan.id">
						<tr class="_active">
							<th colspan="5" style=" text-align: center;">志愿者签到记录表</th>
						</tr>
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>社区</th>
						</tr>
						#foreach($n in $nActivityPlan.volunteerVO)
						#set($x = $velocityCount+1)
						<tr>
							<td>$x</td>
							<td>$n.name</td>
							<td>$n.sex</td>
							<td>$n.age</td>
							<td>$n.communityNmae</td>
						</tr>
						#end
					</table>
					<div class="PagerPrint"></div>
				#end
			</div>
		</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="$request.contextPath/assets/js/jQuery.print.js"></script>
<script>
	$(function() {
		$('.xheck').click(function(){
			if($(this).prop('checked')==true){
				$(this).parent().parent().parent().find('input').prop('checked',true);
			}else{
				$(this).parent().parent().parent().find('input').prop('checked',false);
			}		
		});
		$('.quanxuan').click(function(){
			if($(this).prop('checked')==true){
				$("input:checkbox").prop('checked',true);
			}else{
				$("input:checkbox").prop('checked',false);
			}	
		});
		var myDate = new Date();
		var h1 = $('<h1>' + myDate.getDate() + '</h1>');
		$(".r-top").append(h1);

		var date = getCurrentDateTime();
		var calendar = showCal();
		var h4 = $('<h4>' + date + '</h4>');
		var h41 = $('<h4>农历：' + calendar + '</h4>');
		$(".r-top").append(h4);
		$(".r-top").append(h41);
		$('.today').hide();
		$('#dayin').click(function() {
			if($('.print1').prop('checked')==true){
				$(".print_1").show();
				$(".print_1").addClass("myPrintArea");
			}
			$('.print3').each(function(){
				if($(this).prop('checked')==true){
					var id=$(this).attr('date-id');
					$('.zhi_'+id).show();
					$('.zhi_'+id).addClass("myPrintArea");
				}
			
			});
			$('.print2').each(function(){
				if($(this).prop('checked')==true){
					var id=$(this).attr('date-id');
					$('.ren_'+id).show();
					$('.ren_'+id).addClass("myPrintArea");
				}
			
			});
			$('.print1').each(function(){
				if($(this).prop('checked')==true){
					var id=$(this).attr('date-id');
					$('.zhu_'+id).show();
					$('.zhu_'+id).addClass("myPrintArea");
				}
			
			});
			if($('.myPrintArea').length!=0){
			 $.print(".myPrintArea");
			}
			$('#myPrintArea').hide();
			
		});
		
	});
	
	function getDateStr(str){
	 var strDate = new Date(str);
	 var sDate = strDate.toLocaleString().split(' ')[0];
	 return sDate.replace(/年|月/g, '--').replace(/日/g, '');
	} 
</script>
<script>
	YUI({
		modules : {
			'trip-calendar' : {
				fullpath : '/assets/js/trip-calendar.js',
				type : 'js',
				requires : [ 'trip-calendar-css' ]
			},
			'trip-calendar-css' : {
				fullpath : '/assets/css/trip-calendar.css',
				type : 'css'
			}
		}
	}).use(
			'trip-calendar',
			function(Y) {

				/**
				 * 非弹出式日历实例
				 * 直接将日历插入到页面指定容器内
				 */
				var oCal = new Y.TripCalendar({
					container : '#J_Calendar', //非弹出式日历时指定的容器（必选）
					selectedDate : new Date
				//指定日历选择的日期
				});
				//日期点击事件
				oCal.on('dateclick', function() {
					var selectedDate = this.get('selectedDate');
					location.href="/professional/activity/DateList?pubdate="+ selectedDate;

				});
				Y.one('#J_Example').delegate('click', function(e) {
					var oTarget = e.currentTarget;
				}, 'button', oCal);
			});
</script>
<script type="text/javascript">
	$(document).ready(function(){
	  $("#fanhui").click(function(){
		location.href="/professional/activity/list";
	  })
	});
</script>
<script type="text/javascript" src="/assets/js/rili/underscore.js"></script>
<script type="text/javascript" src="/assets/js/rili/moment.min.js"></script>
<script type="text/javascript" src="/assets/js/rili/demo.js"></script>
<script type="text/javascript" src="/assets/js/rili/clndr.min.js"></script>
<script src="/assets/js/date.js"></script>
<script type="text/javascript" src="/assets/newJs/plan.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>

</html>
