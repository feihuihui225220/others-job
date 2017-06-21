<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>添志愿者培训签到</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/pageNavigator.js"></script>
  	<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
</head>
<style>
</style>
<body>
<div >
	<form class="form" method="post" action="/professional/volunteer/update_train"   id="add_train" name="update_train">
		<input name="id" type="hidden" value="$nVolunteerTrain.id"/>
		<label>培训时间:</label>
		<input  class="text150 timedate" name="traindate" value="$nVolunteerTrain.traindate"  type="text"/><br/>  
		<label>培训时长:</label>
		<input id="trainTimes"  name="trainTimes" value="$nVolunteerTrain.trainTimes" type="text"/>  <br/> 
		<label>培训地点:</label>
		<input id="trainPlace"  name="trainPlace" value="$nVolunteerTrain.trainPlace" type="text"/> <br/>  
		<label>培训主题:</label>
		<input id="theme"  name="theme" value="$nVolunteerTrain.theme" type="text"/> <br/>  
		<label style="float:left">培训内容:&nbsp;</label>
		<textarea id="trainContent"  style=" width:800px;height:120px;" name="trainContent" >$nVolunteerTrain.trainContent</textarea>
		<br/>
		<input type="submit" class="btn button_add" value="保存"/>
		<input type="button" class="btn button_delete" value="取消"/>
	</from>
<div>
</body>
<script>
	$(function(){
		 var mydate = new Date();
	  	 var str =mydate.getFullYear()+ "-";
		 str += (mydate.getMonth()+1) + "-";
		 str += mydate.getDate();
		 $(".timedate").val(str);
		 $(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '87px', height: '27px'});
	});
	$(function(){
		$("#select_all").click(function(){ 
				if(this.checked){ 
					$(".pitch_up").each(function(){this.checked=true;}); 
				}else{ 
					$(".pitch_up").each(function(){this.checked=false;}); 
					} 
			   });
	});
	$('#domo').click(function(){
   		var trainTimes =$('#trainTimes').val()
   		var trainPlace =$('#trainPlace').val()
   		var theme =$('#theme').val()
   		var trainContent =$('#trainContent').val()
   		if(trainTimes==""||trainPlace==""||theme==""||trainContent==""){
			alert("请将选项填写完成");
			return false;
		}else{
			$('#add_train').submit();
		}
			
	});
</script>
</html>