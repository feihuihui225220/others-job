<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>节目修改</title>
#parse("/common/top.tpl")
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
 	<link rel="stylesheet" href="/assets/newCss/index.css" />
  	<style>
    
    	.course{width:60%;margin-top:10px;}
    	.add_first{margin-right:20px;}
    	.guanjianci{height:27px;}
    	#jindu{width:900px;border:1px solid black;height:20px;position: relative;left: 285px;}
    	.percentage{position: relative;left: 65%;top:18px}
    	.div_con{position: relative;left: 83px;cursor: pointer;}
		.div_con>option{cursor: pointer;}
		.course{margin-left:10%;margin-top:20px;}	
	</style>
</head>
<body>
	<div class="wrapper">
			#parse("/common/head.tpl")
		<div class="location"><span class="currentlocation">当前位置：</span><span>首页</span><span>&gt;视频上传</span>
		#if($!{sessionUser.isSuper_()}==true)
		<div class="main">
		        #parse("/common/providers.tpl")
			<div id="right">
		#else
		<div class="courseMain">
	        <div class="course">
		#end
				<input id="parentId" type="hidden" value="$parentId">
				<form id='fForm' class="form-actions form-horizontal" action="/professional/fete/savevoid"   
		              encType="multipart/form-data" target="uploadf" method="post">  
		                 <div class="control-group">  
		                    <label class="control-label">选择课件:</label>  
		                    <div class="controls">  
		                     	<select class="div_con" name="nprpgramId">
		                     	#foreach($n in $nProgram)
		                     		<option value="$n.id">$n.programName</option>
		                     	#end
		                     	</select>
		                    </div>  
		                    <label class="control-label">上传文件:</label>  
		                    <div class="controls">  
		                     	<input class="div_con" type="file"  name="file" style="width:550">  
		                    </div>  
		                    <label class="control-label">上传进度:</label>  <a class="percentage" href="#">0%</a>
		                   <div id="jindu" style="border-radius: 20px;">
		                    	<div id="proBar" style="width:0%;background-color: #68EE68;height:18px;border-radius: 20px;">
		                    	
		                    	</div>
		                    </div>
		                </div>  
	                 	<div class="control-group">  
		                    <div class="controls">  
		                    <button type="button" id="subbut" class="btn">submit</button>  
		                    </div>  
		                </div>  
		        </form>  
		        <iframe name="uploadf" style="display:none"></iframe>  	
			</div>		
		</div>
		</div> 
</div>


	
<script type="text/javascript">
$(document).ready(function(){  
    $(document).on('click',  '#subbut',function(){  
           var filepath = $("input[name='file']").val();
            var extStart = filepath.lastIndexOf(".");
              var ext = filepath.substring(extStart, filepath.length).toUpperCase();
              if(ext!=".MP4"){
              	alert("上传视频格式不正确，请选择MP4格式！");
              	return false;
              } 
	       	   $('#fForm').submit();  
	            var eventFun = function(){  
	                $.ajax({  
	                    type: 'GET',  
	                    url: '/professional/fete/process',  
	                    data: {},  
	                    dataType: 'json',  
	                    success : function(data){  
	                            $('#proBar').css('width',data.rate+''+'%');  
	                            $('.percentage').empty();  
	                            $('.percentage').append(data.rate+''+'%');   
	                            	if(data.rate == 100){  
	                                	window.clearInterval(intId); 
	                                	location.href="/professional/fete/programSelect?id="+$('#parentId').val(); 
	                            	}     
	            				}
	            });
	            };  
	            var intId = window.setInterval(eventFun,500);  
               
    });  
});  
	</script>
</body>
</html>