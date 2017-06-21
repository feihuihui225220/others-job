<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>志愿者培训记录表</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/pageNavigator.js"></script>

</head>
<style>
    .table-hover > tbody > tr >td:hover {
        background-color: skyblue;
    }
    .input-width{
        width: 50px;
    }
    td{
        vertical-align:middle !important;
    }
</style>
<body>
<div style="margin-top: 10px;margin-left: 10px ;margin-right: 10px">
    <div>
        <span>时间：</span>
        <input id="year" class="input-width" type="number">
        <span>年</span>
        <input id="month" class="input-width" type="number">
        <span>月</span>
        <button class="btn_lookOver btn button_add">确定</button>
    </div>
       <div>
       	<h3></h3>
       </div> 
    <table class="table table-hover table-bordered" style="margin-top: 10px">
        <tr class="" style="text-align:center">
            <td colspan="4">志愿者培训记录表</td>
            <td>培训累计次数</td>
            #foreach($date1 in $dates)
            <td>$!date.format('yyyy-MM-dd',$!date1)</td>
            #end
        </tr>
        <tr class=""  style="text-align:center">
            <td colspan="4">基本信息</td>
            <td>$num</td>
             #foreach($date in $dates)
            <td>1</td>
            #end
        </tr>
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>所在社区</td>
            <td>参加培训次数</td>
             #foreach($date in $dates)
            	<td>签到情况</td>
            #end
        </tr>
        #set($i=1)
        #foreach($n in $volunteerTrainingRecordVo)
        <tr>
        	<td>$i</td>
        	<td>$n.volunteerName</td>
        	<td>$n.sex</td>
        	<td>$n.community</td>
        	<td>$n.countRecord</td>
			#foreach($date in $dates)
				#foreach($param in $n.signIn.keySet()) 
            			#if($date==$param)
            			<td>$n.signIn.get($param)</td>
            			#end
            	#end
			#end
        </tr>
        #set($i=$i+1)
        #end
    </table>
</div>
</body>
<script>
    $(document).ready(function () {
        var date = new Date();
        var month = date.getMonth()+1;
        var year = date.getFullYear();
        $("#year").attr("value",year);
        $("#month").attr("value",month);
    });
    $('.btn_lookOver').click(function(){
    	var year=$('#year').val();
    	var month=$('#month').val();
    	var date=year+"-"+month;
    	location.href="/professional/volunteer/record_train?date="+date;
    });
</script>
</html>