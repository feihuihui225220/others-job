<!DOCTYPE html>
<html>
  <head>
    <title>巡诊计划</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script src="/assets/js/jquery-2.1.4.min.js"></script>
	<link href="/assets/director/styles/style.css" rel="stylesheet" type="text/css">
	<link rel='stylesheet' href='/assets/css/jquery-ui.min.css' />
	<link href='/assets/css/fullcalendar.print.css' rel='stylesheet' media='print' />
	<link href='/assets/css/fullcalendar.css' rel='stylesheet' />
	<style type="text/css">
		.wrapper{width:58%;}
		.pad10{margin-left: 70px;}
		#calendar{min-height:600px;margin-left:15px;margin-top:25px;width:85%;}
		#plan {
		position:absolute;
		width:600px;
		height:315px;
		z-index:100;
		left: 30%;
		top:40%;
		background-color: #fff;
		display: none;
		}
		/* .main1{
		filter: alpha(opacity=60); background-color: #eee;opacity:0.5; -moz-opacity:0.5;     
		} */
	</style>
  </head>
  <body>
  #parse("/common/dtop.tpl")
  #parse("/common/duser.tpl")
   <div class="main1">
	#parse("/common/dleft.tpl")
	 
	 <div class="personInfo_right rightnone fl">
      <a href="#" class="btnBg t">添加巡诊计划</a>
      <div class="main_right"> 
        <div id="calendar" class="clearfix"></div>
        
      </div>
    </div>
    </div>
    <div id="plan">12121</div>
  </body>
<script src='/assets/js/moment.min.js'></script>
<script src='/assets/js/fullcalendar.min.js'></script>
<script src='/assets/js/zh-cn.js'></script>
<script>

	$(document).ready(function() {
	$(".personInfo .personInfo_left .sidebar li a").eq(4).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
		$(".t").click(function(){
			location.href="/visit/plan/add?userId=$userId";
		});
		$('#calendar').fullCalendar({
			theme: true,
			
			editable: false,
			eventLimit: true, // allow "more" link when too many events
			events: [
		 
				#foreach($p in $plan)
				{
					start: '$p.visitTime',
					url:"/visit/getuserPlan?id="+$p.id
				},
				
				 #end
			],
			 eventClick: function(calEvent, jsEvent, view){
			  $.ajax({ 
                url:'/visit/getuserPlan?id='+calEvent.id,
                success:function(data){
                	 var json = eval('(' + data + ')');
                	 var h="";
					  $.each(json, function (n, value) {
					         h +="<tr>";
					         h += "<td>"+value.name+"</td>";
							 h += "<td>"+value.age+"</td>";
							 h += "<td>"+new Date(parseInt(value.visitTime) ).toLocaleString()+"</td>";
							 h +="</tr>";
					  
					    });
                	 $("#plan").empty();
                	 $("#plan").html(h);
                }
                
            });
			location.href="/visit/getuserPlan?id="+date.start+"&userId="+$userId;
			} 
			 
			/* eventClick: function(date,calEvent, jsEvent, view){
			$("#plan").css("display","block");
            $.ajax({ 
                url:'/visit/planlistDay?date='+date.start,
                success:function(data){
                	 var json = eval('(' + data + ')');
                	 var h="";
					  $.each(json, function (n, value) {
					         h +="<tr>";
					         h += "<td>"+value.name+"</td>";
					     	if(value.gender=="0"){
					     		h += "<td>女</td>";
					     	}else{
					     		h += "<td>男</td>";
					     	}
							 h += "<td>"+value.age+"</td>";
							 h += "<td>"+new Date(parseInt(value.visitTime) ).toLocaleString()+"</td>";
							 h +="</tr>";
					  
					    });
                	 $("#plan").empty();
                	 $("#plan").html(h);
                }
                
            });
            } */
		});
		
	});

</script>
</html>
