<!DOCTYPE html>
<html>
  <head>
    <title>巡诊计划</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script src="/assets/js/jquery-2.1.4.min.js"></script>
	<link href="/assets/director/styles/table.css" rel="stylesheet" type="text/css">
	<link rel='stylesheet' href='/assets/css/jquery-ui.min.css' />
	<link href='/assets/css/fullcalendar.print.css' rel='stylesheet' media='print' />
	<link href='/assets/css/fullcalendar.css' rel='stylesheet' />
	<style type="text/css">
		 #calendar{min-height:420px;margin:10px 10px 0px -10px;width:63%;float:left;}
	</style>
	
  </head>
  
  <body>
    #parse("/common/dtop.tpl")
	#parse("/common/dmain.tpl")
  <div class="main1">
	<div class="personInfo_right rightnone fl">
	        <div id="calendar" class="clearfix"></div>
 
	  <div class="table fl">
	       <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable">
	       	<tr>
	       		<th>姓名</th>
	       		<th>性别</th>
				<th>年龄</th>
				<th>寻访时间</th>
	       	</tr>
	       	<tbody  id="user">
	       	</tbody>
	       </table>
		</div>
	</div>
	</div>

  </body>
<script src='/assets/js/moment.min.js'></script>
<script src='/assets/js/fullcalendar.min.js'></script>
<script src='/assets/js/zh-cn.js'></script>
<script>

	$(document).ready(function() {
		$(".main .main_left .sidebar li a").eq(1).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
		$(".button_gm").click(function(){
			location.href="/visit/plan/add";
		});
		$('#calendar').fullCalendar({
			theme: true,
			
			editable: false,
			eventLimit: true, // allow "more" link when too many events
			events: [
		  #foreach($p in $plan.keySet())
				{
					title:'$plan.get($p)人',
					start: '$date.format("yyyy-MM-dd",$p)',
				},
				 #end
			],
			 
			eventClick: function(date,calEvent, jsEvent, view){
			console.info(date);
            $.ajax({ 
                url:'/visit/planlistDay?date='+date.start,
                success:function(data){
                	 var json = eval('(' + data + ')');
                	 var h="";
					  $.each(json, function (n, value) {
					         h +="<tr onclick=javascripts:location.href='/director/user?userId="+value.id+"'>";
					         h += "<td>"+value.name+"</td>";
					     	if(value.gender=="0"){
					     		h += "<td>女</td>";
					     	}else{
					     		h += "<td>男</td>";
					     	}
							 h += "<td>"+value.age+"</td>";
							 h += "<td>"+new Date(parseInt(value.visitTime) ).toLocaleString().substring(0,20)+"</td>";
							 h +="</tr>";
					  
					    });
                	 $("#user").empty();
                	 $("#user").html(h);
                }
                
            });
        }
		});
		
	});

</script>
</html>
