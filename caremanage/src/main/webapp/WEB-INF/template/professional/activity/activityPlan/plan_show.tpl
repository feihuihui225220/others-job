<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>节目11</title>
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/jquery.PrintArea.js"></script>
</head>
<style>
	 body{background:#D9EBEB}
	  table{border-collapse:collapse;width:100%}  
      td{border:1px black solid;}  
      .tr1{width:70px;}
      
</style>
<body>
<button class="ibtn button_gm"  id="dayin">打印</button>
	<div id="myPrintArea" >
	
		<br/>
			<table class="" style="border-collapse:collapse;width:100%">
				<tr>
					
					<td colspan="6" style="border:1px black solid; text-align: center;line-height:1 "><h3>社区活动方案</h3></td>
				</tr>
				<tr>
					<td class="tr1" style="border:1px black solid;">计划名称</td>
					<td colspan="5" style="border:1px black solid;">$!activity.planName</td>
				</tr>
				<tr>
					<td style="border:1px black solid;">计划详情 </td>
					<td colspan="5" style="border:1px black solid;" >$!activity.planDesc</td>
				</tr>
				<tr>
					<td style="border:1px black solid;">计划时间 </td>
					<td colspan="5" style="border:1px black solid;">$!activity.createdAt</td>
				</tr>
				<tr>
					<td style="border:1px black solid;">志 愿 者 </td>
					<td colspan="5" style="border:1px black solid;">
						#foreach ($nVolunteer in $nVolunteer)
							$nVolunteer.name
						#end
					</td>
				</tr>
				<tr>
					<td style="border:1px black solid;">员&nbsp;&nbsp;工 </td>
					<td colspan="5" style="border:1px black solid;">
						#foreach ($employees in $employees)
							$employees.name
						#end 
					</td>
				</tr>
				<tr>
					<td style="border:1px black solid;">服务对象</td>
					<td colspan="5" style="border:1px black solid;"></td>
					
				</tr>
				#if($NactivityProgramOfEvents)
				<tr>
					<td style="border:1px black solid;">活动时间</td><td style="border:1px black solid;">时长</td><td style="border:1px black solid;">活动主题</td><td style="border:1px black solid;">活动内容</td><td style="border:1px black solid;">活动用品及音乐</td><td style="border:1px black solid;">活动分工</td>
				</tr>
				#foreach($n in $NactivityProgramOfEvents)
				<tr>
					<td style="border:1px black solid;">$!n.activeTime</td>
					<td style="border:1px black solid;">$!n.duration</td>
					<td style="border:1px black solid;">$!n.activityTheme</td>
					<td style="border:1px black solid;">$!n.activeContent</td>
					<td style="border:1px black solid;">$!n.activitySuppliesMusic</td>
					<td style="border:1px black solid;">$!n.activitiesDivision</td>
				</tr>
				#end
				#end
			</table>
		
	</div>
			    
</body>
  <script src="$request.contextPath/assets/js/jquery.jqprint-0.3.js"></script>
<script defer="defer" type="text/javascript">
	 	$(document).ready(function(){
    		$("#dayin").click(function(){
   	 			$("#myPrintArea").jqprint();
    		});
		});
	</script>
</body>
</html>