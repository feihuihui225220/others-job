<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title>报警阀值</title>
		<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
		<link rel="stylesheet" href="/assets/css/home.css" />
<link rel="stylesheet" href="/assets/css/reg.css" />
		<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
		<script>
			function successTips(success) {
				if(success == true) {
					alert("设置成功！");
				}
			}
		</script>
		<style>
	.text50 {position:relative;z-index:555;}
	</style>
	</head>
	<div class="">
        #parse("/common/head.tpl")
        <div class="bodyposition">
            <div id="mainDiv">
                <div id="rightIframe" class="rightIframe">
	<body onload="successTips($!{success})">
	
		<div class="wrapper" align="center">
			<div class="body" align="center">
				
					    <form action="/professional/alarm/setup/commit" method="post">
						    <div class="useractbox bodyline pad10 vv">
							    <div class="oooo6" align="center">
						             <input type="hidden" name="userId" value="${userId}" /> 
						             <input type="hidden" name="serviceId" value="61" /> 
						             
						             #set($i = 0)
						             #set($j = 0)
						           	 #foreach($dataModule in $dataModules)
									    <ul class="inpubox2 clearfix">
									       #foreach($item in $dataModule.items)
									          <input type="hidden" name="items[$i].metaServiceId" value="${dataModule.metaServiceId}" />
										      <input type="hidden" name="items[$i].id" value="${item.id}" />
										      <input type="hidden" name="items[$i].name" value="${item.name}" />
										      <li><label>${item.desc}：</label>
										      	
										      	<input class="text50" type="text" name="items[$i].alarmLower" size="3" value="#if($item.alarmLower == -1)#else$item.alarmLower#end" />至 
										      	<input class="text50" type="text" name="items[$i].alarmUpper" size="3" value="#if($item.alarmUpper == -1)#else$item.alarmUpper#end" />
										      </li>
											  #set($i = $i + 1)
										   #end
									    </ul>
									  
										<ul class="inpubox4 clearfix">
											#foreach($item in $dataModule.items)
												<li> <label>是否报警：</label><select class="select160" name="items[$j].isAlarm"><option value="1" #if($item.isAlarm == true) selected #end>是</option><option value="0" #if($item.isAlarm == false) selected #end>否</option></select> </li>
											    #set($j = $j + 1)								
											#end	
										</ul>
									#end
									
									
								    <p style="clear:both;overflow:hidden;"><input class="button_gm" type="submit" value="提交" style="float:right;clear:both"></p>
								</div>
				            </div>
						</form>
					
			</div>
		</div>
		 </div>
            </div>
            #parse ("/common/userHome.tpl")
        </div>
    </div>
		
	</body>
</html>