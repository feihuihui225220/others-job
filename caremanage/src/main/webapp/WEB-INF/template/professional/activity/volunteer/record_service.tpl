<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>志愿者,列表</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/pageNavigator.js"></script>
    <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
    <script src="$request.contextPath/assets/js/jquery.jqprint-0.3.js"></script>
    <link rel="stylesheet" href="/assets/newCss/index.css" />

</head>
<style>
    .table-hover > tbody > tr >td:hover {
        background-color: skyblue;
    }
    .input-width{
        width: 50px;
    }
    td{
    	 text-align: center;
        vertical-align:middle !important;
    }
    .content{
    	width:100%;
    	height:80%;
    }
</style>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
	<div id="right">  
		<div style="margin-top: 10px;margin-left: 10px ;margin-right: 10px">
		    <div>
		        <span>时间：</span>
		        <input id="year" class="input-width" type="number">
		        <span>年</span>
		        <input id="month" class="input-width month"  value="$!month" type="number" >
		        <span>月</span>
		        <button id="see_btn" class="btn button_add">确定</button>
		        <input id="printResult" type="button" value="打印" class="btn button_add"/>
		    	<input class="btn button_gm" type=button value=返回 onclick="location.href='/professional/volunteer/index';   //window.history.back()">
		    </div>
		    <div class="body" id="myPrintArea" style="font-family:楷体;">
		    <table class="_tale1 table table-hover table-bordered" style="margin-top: 10px">
		        <tr class="_active"><td colspan="6"><h4>志愿者服务记录详情表</h4></td></tr>
		        #if ($list_vo)
		        #foreach($e in $list_vo)
		    	<input id="volunteerId" type="hidden" value='$e.id'/>
		        <tr class="tr_first">
		            <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</td>
		            <td id="name">$!e.name</td>
		            <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</td>
		            <td id="sex">$!e.sex</td>
		            <td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</td>
		            <td id="age">$!e.age</td>
		        </tr>
		        <tr class="tr_two">
		            <td>联系方式</td>
		            <td>$!e.contact</td>
		            <td>居住社区</td>
		            <td>$!volunteerTrainingRecordVo.community</td>
		            <td>服务站点</td>
		            <td>$!siteName</td>
		        </tr>
		        <tr class="tr_first">
		            <td>活动累计次数</td>
		            <td id="">$num</td>
		             <td>服务累计次数</td>
		            #set($n = $volunteerTrainingRecordVo.countRecord)
		            <td id="">$n</td>
		            <td></td>
		            <td></td>
		        </tr>
		        <tr class="tr_first">
		            <td>服务时数统计</td>
		            <td id=""> $!activeTime  </td>
		             <td>培训时数统计</td>
		            #set($n = $volunteerTrainingRecordVo.countRecord)
		            <td id=""> $!trainTimes  </td>
		            <td>共计时数</td>
		            <td>   $!sumTime   </td>
		        </tr>
		        <tr class="tr_two">
		           <td colspan="6" >服务记录详情</td>
		        </tr>
		        <tr class="tr_first">
		         	<td >服务时间</td>
		         	<td colspan="1">服务名称</td>
		         	<td colspan="3">服务内容</td>
		         	<td colspan="1">服务记录</td>
	         	 </tr>
		        
		         #foreach($date1 in $volunteerTrainingRecordVo.serviceItem.keySet())
	         	  #set($i = ($velocityCount + 1))
	         	 <tr class=" #if($i%2!=0 ) tr_two #else tr_first #end">
		         	<td >$!date.format('yyyy-MM-dd',$!date1)</td>
		         	<td colspan="1">
					 #if($!volunteerTrainingRecordVo.serviceItem.get($date1)==1)
		            		$!volunteerTrainingRecordVo.title.get($date1)
		           	 #else	
		           	 		未签到
	           	 	 #end
					</td>
		         	<td colspan="3">
						#if($!volunteerTrainingRecordVo.serviceItem.get($date1)==1)
		            			$!volunteerTrainingRecordVo.content.get($date1)
			           	#else	
			           	 		未签到
		           	 	#end
					</td>
		         	<td colspan="1">
						#if($!volunteerTrainingRecordVo.volunteerAssessIds.get($date1)!=0)
		            			<a href="/nVolunteerAssess/selectById?id=$!volunteerTrainingRecordVo.volunteerAssessIds.get($date1)" color="red">查看记录</a>
			           	#else	
			           	 		未签到
		           	 	#end
					</td>
	         	 </tr>
		         #end
		        #end
		        #end
		    </table>
		</div>
		</div>
    </div> 
	</div>
</div>
	
</body>
<script>
    $(document).ready(function () {
        var date = new Date();
      
        var year = date.getFullYear();
        $("#year").attr("value",year);
    });
    $(function(){
    	$('.content').attr("disabled","disabled");
    	$('.preserve').attr("disabled","disabled");
    	$('.alter').click(function(){
    		$(this).prev().attr("disabled",false);
    		$(this).next().attr("disabled",false);
    	});
    	
    	$('.preserve').click(function(){
    		var volunteerId=$('#volunteerId').val();
    		var addTime=$(this).siblings(".add_time").val();
    		var content=$(this).siblings(".content").val();
    		$.ajax({
                    url: "/professional/volunteer/add_content?volunteerId="+volunteerId+"&addTime="+addTime+"&content="+content,
                    type: "post",
                    success: function (mjson) {
                        alert(mjson);
                    }
                });
                $(this).attr("disabled","disabled");
                $(this).prev().prev().attr("disabled","disabled");
    	});
    });
    $('#see_btn').click(function(){
    		var volunteerId=$('#volunteerId').val();
    		var year = $("#year").val();
       		var month = $("#month").val();
       		var date=year+"-"+month;
       		location.href="/professional/volunteer/service?volunteerId=" + volunteerId+"&date="+date;
    		
    	});
	$("#printResult").click(function(){
            $("#myPrintArea").jqprint(); 
    });
    
     $('.month').change(function(){
        if($(this).val()<=0){
            $(this).val(1);
        }else if($(this).val()>=13){
            $(this).val(12);
        }
        
    });
</script>
</html>