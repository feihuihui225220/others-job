<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>我的服务</title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<style>
.box{margin-top:20px;margin-left:6%;}
</style>

</head>
<body>
	<div class="wrapper">
		<div class="box">
			<div class="searchli" >
				<ul class="inpubox clearfix">
					<li><input class="text150 timedate"  id="start"/> 至 <input class="text150 timedate" id="endd"/>
					</li>
					<li><input class="button_add" type="button" value="查询">
					</li>
				</ul> 
			</div>
			<div class="imgs">
				<table class="tabImg">
					<tr>
						<th>序号</th>
						<th>图片一</th>
						<th>图片二</th>
						<th>图片三</th>
						<th>图片四</th>
						<th>图片五</th>
						<th>图片六</th>
					</tr>
					
				</table>
			<div>
			
			
		</div>
		<input type="hidden" id="naodian" value="$IdCardNo"/>
		<input type="hidden" id="_start" value="$date.format('yyyy-MM-dd',$start)"/>
		<input type="hidden" id="_end" value="$date.format('yyyy-MM-dd',$end)"/>
	<div>
<script>
	$(function(){
    		var IdCardNo=$("#naodian").val();
    		 $.ajax({
    	         url :"http://114.251.187.74:8115/stration/eeg/userList?IdCodNo="+$IdCardNo,
    	         dataType : "jsonp",
 				 jsonp: "jsonpCallback",
 				 success:function(json){
    	            for(var i=0;i<json.datatable.length;i++){
    	            var n=i+1;
    	            	//var tab=$('<tr class="imgTr" date-url1='+json.datatable[i].pic1Url+' date-url2='+json.datatable[i].pic2Url+' date-url3='+json.datatable[i].pic3Url+' date-url4='+json.datatable[i].pic4Url+' date-url5='+json.datatable[i].pic5Url+' date-url6='+json.datatable[i].pic6Url+'><td>'+n+'</td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td></tr>');
    	            	var tab=$('<tr class="imgTr" date-url1='+json.datatable[i].pic1Url+' date-url2='+json.datatable[i].pic2Url+' date-url3='+json.datatable[i].pic3Url+' date-url4='+json.datatable[i].pic4Url+' date-url5='+json.datatable[i].pic5Url+' date-url6='+json.datatable[i].pic6Url+'><td>'+n+'</td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic1Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic2Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic3Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic4Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic5Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic6Url+'"/></td></tr>');
    	            	$('.tabImg').append(tab);
    	            	
    	            }
    	         } 
    	     });
    	     $('.imgTr').live('click',function(){
    	   
    	     	var url1=$(this).attr('date-url1');
    	     	var url2=$(this).attr('date-url2');
    	     	var url3=$(this).attr('date-url3');
    	     	var url4=$(this).attr('date-url4');
    	     	var url5=$(this).attr('date-url5');
    	     	var url6=$(this).attr('date-url6');
    	     	location.href="/professional/service/eeg?pic1Url="+url1+"&pic2Url="+url2+"&pic3Url="+url3+"&pic4Url="+url4+"&pic5Url="+url5+"&pic6Url="+url6;
    	     });
    	      
    	});
	$(function(){  
	$('.timedate').calendar({ format:'yyyy-MM-dd', zIndex:222222222});
	 
	})  
 	$(function(){
 		var IdCardNo=$("#naodian").val();
 		$('.button_add').click(function(){
 			$('.imgTr').html("");
 			var start=$('#start').val();
 			var endd=$('#endd').val();
 			$.ajax({
    	         url :"http://114.251.187.74:8115/stration/eeg/userList?IdCodNo="+IdCardNo+"&start="+start+"&end="+endd,
    	         dataType : "jsonp",
 				 jsonp: "jsonpCallback",
 				 success:function(json){
    	            
    	            for(var i=0;i<json.datatable.length;i++){
    	            var n=i+1;
    	            	var tab=$('<tr class="imgTr" date-url1='+json.datatable[i].pic1Url+' date-url2='+json.datatable[i].pic2Url+' date-url3='+json.datatable[i].pic3Url+' date-url4='+json.datatable[i].pic4Url+' date-url5='+json.datatable[i].pic5Url+' date-url6='+json.datatable[i].pic6Url+'><td>'+n+'</td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic1Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic2Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic3Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic4Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic5Url+'"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[i].pic6Url+'"/></td></tr>');
    	            	$('.tabImg').append(tab);
    	            	
    	            }
    	         } 
    	     });
    	     $('.imgTr').live('click',function(){
    	     	var url1=$(this).attr('date-url1');
    	     	var url2=$(this).attr('date-url2');
    	     	var url3=$(this).attr('date-url3');
    	     	var url4=$(this).attr('date-url4');
    	     	var url5=$(this).attr('date-url5');
    	     	var url6=$(this).attr('date-url6');
    	     	location.href="/professional/service/eeg?pic1Url="+url1+"&pic2Url="+url2+"&pic3Url="+url3+"&pic4Url="+url4+"&pic5Url="+url5+"&pic6Url="+url6;
    	     });
    	      
 		})
	})

</script>
</body>
</html>