<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>警报管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="$request.contextPath/assets/js/pageNavigator.js"></script>
</head>
<style>
	.input_width{
		width:48px;
	}
</style>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    <!-- cm、user、pro顶部菜单附带头信息 -->
    #if($sessionUser.cateEnum.type == 1 || ($sessionUser.cateEnum.type == 3 && !$userId)|| ($sessionUser.cateEnum.type == 4 && !$userId))
       #parse("/common/head.tpl")
    #end
     #if($!{sessionUser.getCateEnum()}=="USER")
		 	<iframe id="userFrame"  width="20%" style="height:800px; margin-left:1%"src="/user/detail" frameborder="0" scrolling="no"></iframe>
    		<div class=" useractbox bodyline pad10" style="width:75%;float:right;" height=800px;>
	 #else
		<div class=" useractbox bodyline pad10" >
	 #end
		<div class="searchli">
			<ul class="inpubox ">
			    <form action="/professional/alarm/query" method="post" name="searchForm">
		    	#if(($sessionUser.cateEnum.type == 4||$sessionUser.cateEnum.type == 3) && $userId)
		    	   <input type="hidden" id="userId" name="userId" value="$userId"/>
		    	#end
			    <!--cm、pro（顶部） 增加姓名过滤-->
			    #if(($sessionUser.cateEnum.type == 4 && !$userId) || ($sessionUser.cateEnum.type == 3 && !$userId))
			    <li><label>姓名：</label><input class="select160" id="userName" name="userName" type="text" value="$!{userName}"></li>
			    #end
			    
			    <!--cm 增加身份证过滤-->
			    <!--
			    #if($sessionUser.cateEnum.type == 3 && !$userId)
			    <li><label>身份证号：</label><input class="select160" name="userCardId" type="text"></li>
			    #end
			    -->
			    
				<li ><label>警报日期：</label><input class="text150 timedate" type="text" id="startT" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)"/> 至 <input class="text150 timedate" type="text" id="endT" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)" /></li>
				
				
				#if($sessionUser.cateEnum.type!=4 ||$sessionUser.cateEnum.type==4)
					<li>
							<label>所属服务：</label>
							<select class="select160" name="serviceId" id="serviceId">
									<option value="-1"#if($serviceId == -1) selected #end>全部</option>
									#foreach($service in $services)
										<option value="${service.id}" #if($serviceId == $service.id) selected #end>${service.name}</option>
									#end
							</select>
					</li>
				
					<li>
							<label>状态：</label>
							<select class="select160" name="status" id="status">
								<option value="-1" #if($status == -1) selected #end>全部</option>
								<option value="1" #if($status == 1) selected #end>已处理</option>
								<option value="0" #if($status == 0) selected #end>未处理</option>
							</select>
					</li>
				#end			
				<li><input class="button_add" type="submit" value="搜索"></li>
				<!--#if($sessionUser.cateEnum.type == 4 && $userId)
				<li><input id="add_button" type="button" class="button_gm" value="警报阀值"/></li>
				#end-->
				</form>
			</ul>
		</div>
		<table class="table100 usertable cen">
            <tr>
            #if($sessionUser.cateEnum.type == 1)
            	<!--
            	<th>序号</th>
            	-->
        	#end
        		<th>姓名</th>
        		<!--<th>联系方式</th>-->
				<th>警报内容</th>
				<th>警报类别</th>
				<th>所属服务</th>
				<th>警报时间</th>
				<!--<th>响应时间</th>-->
			#if($sessionUser.cateEnum.type == 3)
				<th>服务商</th>
			#end
			#if($sessionUser.cateEnum.type != 1)
				<th>处理人员</th>
			#end
				<th>处理状态</th>
			</tr>
			#set($i=1)
			#foreach($alarm in $page.result)
            	<tr>
            		#if($sessionUser.cateEnum.type == 1)
            		<!--
            		<td>$i<td/>
            		-->
        			#end
    				<td>$!{alarm.userName}</td>
    				<!--<td>$!{alarm.contect}</td>-->
					<td>${alarm.content}</td>
					<td>${alarm.dateItemDesc}</td>
					<td>${alarm.serviceName}</td>
					<td>$!date.format('yyyy-MM-dd HH:mm:ss',${alarm.alarmTime})</td>
					<!--<td>$!date.format('yyyy-MM-dd HH:mm:ss',${alarm.responseTime})</td>-->
					#if($sessionUser.cateEnum.type == 3)
					<td>$!{alarm.venderName}</td>
					#end
					#if($sessionUser.cateEnum.type != 1)
					<td>$!{alarm.createdBy}</td>
					#end
					<td>
						#if(${alarm.status}==0) 
							#if($sessionUser.cateEnum.type == 4 && !$userId)
								<input class="button_add input_width"  name="deal_btn" value="    处理" alarmId="${alarm.id}" /> 
							#else
								未处理
							#end  
						#else 
							已处理 
						#end
					</td>
				</tr>
            #end
            
            
        </table>
        #parse("/common/page.tpl")
    </div>
    <div class="footer"></div>
</div>
<form action="/professional/alarm/deal" method="post" name="dealForm" id="dealForm">
	<div class="limitbox pad10 hide">
	    <ul class="inpubox clearfix">
	        <li>
	            <label></label>
	        	<textarea cols="40" rows="10" name="suggestion" id="deal"></textarea>
	        	<input type="hidden" id="hAlarmId" name="id" value="" />
	        	<input type="hidden" id="hUserId" name="userId" value="" />
	        	<input type="hidden" id="hUserName" name="userName" value="" />
	        	<input type="hidden" id="hServiceId" name="serviceId" value="" />
	        	<input type="hidden" id="hStatus" name="status" value="" />
	        	<input type="hidden" id="hStart" name="start" value="" />
	        	<input type="hidden" id="hEnd" name="end" value="" />
	        	<input type="hidden" id="hPage" name="page" value="${page.getPageNo()}" />
	        	<input type="hidden" id="hNum" name="num" value="${page.getPageSize()}" />
	        </li>
	    </ul>
	</div>
</form>
</body>
<script src="$request.contextPath/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
   	$('#add_button').click(function(){
   		location.href="/professional/alarm/setup?userId=${userId}&venderId=${venderId}"	
   	});
   
    $(".timedate").calendar({ format:'yyyy-MM-dd' });

    $("input[name='deal_btn']").click(function() {
        $('#hAlarmId').val($(this).attr("alarmId"));
        $('#hUserId').val($('#userId').val());
        $('#hUserName').val($('#userName').val());
        $('#hServiceId').val($('#serviceId').val());
        $('#hStatus').val($('#status').val());
        $('#hStart').val($('#startT').val());
        $('#hEnd').val($('#endT').val());
        $.layer({
            type : 1,
            title : '警报处理意见',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
				var suggestion = $('#deal').val(); 
				if(suggestion == "" || suggestion == null){
					alert("请录入处理意见！");
						return false;
				}else{
					$("#dealForm").submit();
	                layer.close(index);
                }
            },
            area : ['450px','270px'],
            page : {dom : '.limitbox'}
        });
    });
});
</script>
</html>