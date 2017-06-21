<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>我的服务</title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<style>
.list_my {padding:20px 0 0 20px;/*width:1086px;*/overflow:hidden;margin:0 10px;}
.list_my li {float:left;width:320px;margin-right:30px;border:2px solid #ddd;padding:10px 0 0 10px;margin-bottom:20px;}
.list_my li h4 {background:#f2f2f2;border-bottom:1px solid #ddd;font-size:14px;height:26px;line-height:26px;margin-bottom:10px;padding-left:6px;width:304px;color:#299DCA;}
.list_my li a {color:#333;display:block;}
.list_my li a:hover {text-decoration:none;}
.list_my li div {float:left;width:90px;margin-right:5px;margin-bottom:10px;text-align:center;background:#f2f2f2;padding:5px;}
.list_my li div h5 {border-bottom:1px solid #ddd;text-align:left;margin:0;padding-bottom:3px;color:green;margin-bottom:3px;padding-left:5px;}
.inpubox{padding:0;}
.searchli {border-bottom:1px solid #000;margin:0 10px;}
.rightbtn button{line-height:16px\0;}
.height{ height:165px;}
</style>

</head>
<body>

<div class="wrapper">
#parse("/common/head.tpl");
 #if($!{sessionUser.getCateEnum()}=="USER")
 <iframe id="userFrame"  width="20%" height=800px; float:left; src="/user/detail" frameborder="0" scrolling="no"></iframe>
 #end
 
    <div class=" bodyline" style="width:77%;float:right;">
      <!-- <img src="$request.contextPath/permission/validatepng" id="img" height="200" width="150">  -->
        <div class="searchli">
            <ul class="inpubox clearfix">
                <li style="height:30px;line-height:50px">我的服务</li>
             <!--   <li class="rightbtn pad10" style="float:right;"><button class="button_btn addEvidence" onclick="javascripts:location.href='/professional/service/apply?idCard=${condVo.idCard}'">服务申请</button></li> -->
            </ul>
        </div>
         <ul class="list_my zhanshi">
        	#foreach($data in $datas)
            <li class="b">
              <h4><a href="/professional/service/diverseShow?userId=${userId}&serviceId=${data.serviceId}&stype=${data.type} ">${data.serviceName}</a></h4>
                #set($i = 0)
                #foreach($title in $data.data.titles)
	        		<div>
	            		<h5>${title}</h5>
	            		#if($title.equals("上传时间"))
	            			<b>$!date.format('yyyy-MM-dd',$!data.data.values[0][$i])</b>
	            		#else
	            			<b>$data.data.values[0][$i]</b>
	            		#end
	        		</div>
	        		#set($i = $i + 1)
				#end        	 	
            	</a>
             
           </li>
           #end
        </ul>
        <ul class="list_my">
        	#foreach($data in $datas)
        	
	            <li class="a_serviceId" date-value="${data.serviceId}" date-stype="$data.stype" date-serviceName="${data.serviceName}">
            		<h4><a href="/professional/service/diverseShow?userId=${userId}&serviceId=${data.serviceId}&stype=${data.type} ">${data.serviceName} ${data.type}</a></h4>
		              	#set($i = 0) 
		                #foreach($title in $data.data.titles)
			        		<div >
	            				<h5>xa${title}</h5>
			            		#if($title.equals("上传时间"))
			            			<b>$date.format('yyyy-MM-dd',$!data.data.values[0][$i])</b>
			            		#else
		            				<b >$data.data.values[0][$i]</b>
			            		#end
			        		</div>
			        		#set($i = $i + 1)
						#end  
	           	</li>
           #end
        </ul>
    </div>
    <div class="footer"></div>
</div>
<script>
	$(function(){
	
		//$('#img').html($img);
		$('.b').each(function(){
			if($(this).find('div').length==0){
				$(this).remove();
			}else{
				$(this).addClass("height");			
			}
			
		});
		$('.a_serviceId').each(function(){
			if($(this).find('div').length!=0){
				$(this).remove();
			}
			var serviceName=$(this).attr("date-serviceName");
			var IdCardNo=$IdCardNo;
			if($(this).attr("date-value")==30){
				 
				 $.ajax({
    	         url :"http://114.251.187.74:8115/stration/eeg/userList?IdCodNo="+IdCardNo,
    	         dataType : "jsonp",
 				 jsonp: "jsonpCallback",
 				 success:function(json){
    	            if(json.datatable.length!=0){
    	            	var stype=$(this).attr("date-stype");
    	            	
    	            	var userId=$userId;
    	            	 for(var i=0;i<json.datatable.length;i++){
		    	            	var n=i+1;
		    	            	//var tab=$('<tr class="imgTr" date-url1='+json.datatable[i].pic1Url+' date-url2='+json.datatable[i].pic2Url+' date-url3='+json.datatable[i].pic3Url+' date-url4='+json.datatable[i].pic4Url+' date-url5='+json.datatable[i].pic5Url+' date-url6='+json.datatable[i].pic6Url+'><td>'+n+'</td><td></td></tr>');
		    	            	var tab=$('<tr class="imgTr" date-url1='+json.datatable[i].pic1Url+' date-url2='+json.datatable[i].pic2Url+' date-url3='+json.datatable[i].pic3Url+' date-url4='+json.datatable[i].pic4Url+' date-url5='+json.datatable[i].pic5Url+' date-url6='+json.datatable[i].pic6Url+'><td>'+n+'</td><td></td></tr>');
		    	            	$('.tabImg').append(tab);
    	            			var div=$('<li class="b"><h4><a href="/professional/service/history?userId='+userId+'&serviceId=30" >'+serviceName+'</a></h4><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic1Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic2Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic3Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic4Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic5Url+'"/><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/'+json.datatable[0].pic6Url+'"/></li>');
    	            			//var div=$('<li class="b"><h4><a href="/professional/service/history?userId='+userId+'&serviceId=30" >'+serviceName+'</a></h4><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></td><td><img class="imgs_eeg" src="http://114.251.187.74:8115/static_img/333333444444111111111111111111201512231952_3.jpeg"/></li>');
    	            			$('.zhanshi').append(div);	
    	            			break;	
	            		}
    	            	remove();
    	            }
    	           
    	         } 
    	     });
			}
			
		});
	})
	function remove(){
		$('.a_serviceId').each(function(){
			if($(this).attr("date-value")==30){
				$(this).html("");
			}
		});
	}
</script>
</body>
</html>