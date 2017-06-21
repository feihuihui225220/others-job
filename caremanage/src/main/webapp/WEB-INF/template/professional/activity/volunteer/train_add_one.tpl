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
<!-- action="/professional/volunteer/add_train_one" -->
	<button id="domo" class="ibtn button_add">添加</button>
	<form class="form" method="post" action="/professional/volunteer/add_train_one"   id="add_train" name="add_train">
		<br/>
		
		<label>培训时间:</label>
		<input  class="text150 timedate" name="traindate"  type="text"/><br/>  
		<label>培训时长:</label>
		<input id="trainTimes" name="trainTimes" type="text"/>  <br/> 
		<label>培训地点:</label>
		<input id="trainPlace" name="trainPlace" type="text"/> <br/>  
		<label>培训主题:</label>
		<input id="theme" name="theme" type="text"/> <br/>  
		<label style="float:left">培训内容:&nbsp;</label>
		<textarea id="trainContent" name="trainContent"  style=" width:800px;height:120px;" ></textarea>
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