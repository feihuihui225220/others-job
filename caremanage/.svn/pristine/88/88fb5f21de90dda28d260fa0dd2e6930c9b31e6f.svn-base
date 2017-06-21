<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>志愿者签到情况</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/pageNavigator.js"></script>
    <link rel="stylesheet" href="/assets/newCss/index.css" />

</head>
<style>
	
</style>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
	<div id="right">
		<div style="margin-top: 10px;margin-left: 10px ;margin-right: 10px">
	    <table class="table _tale1" style="margin-top: 10px">
	        <tr class="_active">
	            <th>姓名</th>
	            <th>性别</th>
	            <th>年龄</th>
	            <th>电话</th>
	            <th>退签</th>
	        </tr>
	        #foreach($e in $nVolunteer)
	         #set($i = $velocityCount + 1)
	        <tr class=" #if($i%2!=0 ) tr_two #else tr_first #end  data-id="$!e.id">
	            <td>$!e.name</td>
	            <td>$!e.sex</td>
	            <td>$!e.age</td>
	            <td>$!e.contact</td>
	            <td data-list="$!e.id">
	                <a href="#" class="tb_removeq ">删 除</a>
	            </td>
	        </tr>
	        #end
	    </table>
	</div>
    </div> 
</div>
</div>
</body>
<script>
	$(function(){
		 $(".tb_removeq").on("click", function () {
        	var gnl=confirm("你真的打算删除吗?");
				if (gnl==true){
					var table_id = $(this).parent().attr("data-list");
					var trainId=$trainId;
					location.href="/professional/volunteer/delete_nVolunteer_train?volunteerId="+table_id+"&trainId="+trainId;
				}else{
					return  false;
				}
           
        });
	});
</script>
</html>