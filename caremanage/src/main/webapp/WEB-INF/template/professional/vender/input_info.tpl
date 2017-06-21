<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title>报警阀值</title>
		<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
		<style>
	.text50 {position:relative;z-index:555;width:100px;}
	.inpubox2{clear: none;width: 45%;}
	</style>
	</head>
	
	<body onload="successTips($!{success})">
	
		<div class="wrapper" align="center">
			<div class="body" align="center">
				
					    <form id="from" action="/professional/input/submit" method="post">
						    <div class="useractbox bodyline pad10 vv">
							    <div class="oooo6" align="center">
						             <input type="hidden" name="userId" value="${userId}" /> 
						             <input type="hidden" name="serviceId" value="${serviceId}" /> 
						             
						             
						          #foreach($dataModule in $dataModules)
						          #set($i = $foreach.index)
									    #if($dataModule.name!="脑电波"&&$dataModule.name!="能床垫（二）"&&$dataModule.name!="床垫动作")
									    <ul class="inpubox2 clearfix">
									    	<li><label><strong>$dataModule.name</strong></label>
									    	<input type="hidden" name="dataModules[$i].tableName" value="${dataModule.tableName}" />
									    	<input type="hidden" name="dataModules[$i].metaServiceId" value="${dataModule.metaServiceId}" />
								        #set($j = 0)
								        #foreach($item in $dataModule.items)
								        #if(${dataModule.items[$foreach.index].name}!="deviceId") 
									      <li><label>${item.desc}：</label>
									      	<input type="hidden" name="dataModules[$i].items[$j].name" value="${dataModule.items[$foreach.index].name}" />
									      	<input type="hidden" name="dataModules[$i].items[$j].itemType" value="$!{dataModule.items[$foreach.index].itemType}" />
									      	<input class="text50 #if(${dataModule.items[$foreach.index].name}=="uploadTime")timedate#end" #if(${dataModule.items[$foreach.index].name}=="uploadTime")value="$!date.format('yyyy-MM-dd HH:mm:ss',$currentDate)"#end type="text" name="dataModules[$i].items[$j].inputParam" size="3"/>
									      </li>
									      #set($j = $j + 1)
									      #end
										   	#end
									    </ul>
										  #end
										#end
									
								    <p style="clear:both;overflow:hidden;"><input class="button_gm additem" type="button" value="提交" ></p>
								</div>
				            </div>
						</form>
					
			</div>
		</div>
	</body>
	<script src="/assets/js/jquery-1.8.0.min.js"></script>
	<script src="/assets/js/lhgcalendar.min.js"></script>
	<script type="text/javascript">
	$(function(){
		#if($success)
			alert("录入成功");
		#end
		$(".timedate").calendar({ format:'yyyy-MM-dd HH:mm:ss' });
		
		$('.additem').click(function(){
			$('.text50').each(function(){
				if($(this).val()==""){
					$(this).val("0");
				}
			});
			
			$('#from').submit();
		});
	});
	</script>
</html>