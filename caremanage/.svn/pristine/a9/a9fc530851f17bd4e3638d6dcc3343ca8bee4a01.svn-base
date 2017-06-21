<!DOCTYPE html>
<html>
  <head>
    <title>相册管理</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
   
	
	<link href="$request.contextPath/assets/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
	<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
 	<script src="$request.contextPath/assets/js/jquery-2.1.4.min.js"></script>
    <script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
    <script src="$request.contextPath/assets/js/calendar.js"></script>
    <script src="$request.contextPath/assets/js/highcharts.js"></script>
 	<script type="text/javascript" src="$request.contextPath/assets/js/bootstrap.min.js"></script>
<style>
.btn{display:inline-block;}
 body{background:#D9EBEB}
</style>
  </head>
  
  <body>
<div class="wrapper">
<br/>
	 <button data-toggle="modal" data-target="#addalbum" class="btn button_add" id="addchbutton" >创建相册</button>  
	 <dl style="margin-left: 5%;text-algin:center; ">
      	#foreach($a in $listAlbum)
       		<dd class="dd" style="float:left; margin-left:5%; ">
     	 		<img alt="$!a.albumName" id="$!a.id" style="width:180px;height:138px;" src="/file/pictures/$a.albumUrl"/>
 	   			<br/><input style='border:0px;' class="albumName_up" readonly="readonly" value="$!a.albumName"/>
 	   			<br/><input style='border:0px;' class="albumDesc_up" readonly="readonly" value="$!a.albumDesc"/><br/>
         		<button style=" position: relative; top:-65px;" class="ibtn button_delete">删除</button>
         		<button style=" position: relative; top:-65px;" data-toggle="modal" data-target="#updatephoto" class="update button_add"  >修改</button>  
 	   		</dd>
 	   		
    	 #end
     </dl>
	<div id="updatephoto" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
				    <div class="modal-dialog" style="width:300px;">
				      <div class="modal-content">
					        <div class="modal-body">
					  			 <form  id="updateAlbumform"  method="post"  action="$request.contextPath/professional/album/editAlbum" enctype="multipart/form-data">
										<input name="id" id="album_id" type="hidden">
									    <label>照片名称</label>
									    <input type="text" id="albumname" style="width:80%" class="albumname form-control" name="albumName">
									    <label>照片描述</label>
									   <input type="text" id="albumdesc" style="width:80%" class="albumdesc form-control" name="albumDesc" >
								  		<div class="form-group">
									    <label>相册封面</label>
									   <input type="file" style="width:80%" class="form-control"  name="pic" />
									  </div> 
								  </form> 
								  <div class="modal-footer">
									  <button type="button" class="btn btn-default" style="float:right;margin-left:20px" data-dismiss="modal" onclick="flush()">取消</button>
						          	  <button type="button" class="btn btn-primary" style="float:right" id="yes" onclick="updateAlbumform()">确认</button>
					        	  </div>
					        </div>
				      </div>
				    </div>
				</div>
 <!-- 添加相册 -->
</div>
<div id="addalbum" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">添加相册</h4>
        </div>
        <div class="modal-body">
				  <form role="form" id="addAlbumform" method="post" enctype="multipart/form-data" action="$request.contextPath/professional/album/add">
					<input type="hidden" name="activityId" value="$!activityId"/>		   
					<div class="form-group">
					      <label>相册名称(必选项)</label>
					    <input type="text" id="albumName" style="width:80%" class="form-control" name="albumName">
					</div>
					<div class="form-group">
					    <label>相册描述</label>
					   <input type="text" style="width:80%" class="form-control" name="albumDesc" >
					  </div>
					<div class="form-group">
					    <label>相册封面</label>
					   <input type="file" style="width:80%" class="form-control" multiple name="pic" >
					  </div> 
					</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="yes" onclick="addAlbum()">确认</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        </div>
      </div>
    </div>


<script>
	$("#program").click(function(){
		var start=$('#start').val();
		var end=$("#jieshu").val();
		$.ajax({  
                url:"seeprogram?start="+start+"&end="+end,  
                type:"post",          
                success:function(list){
                	  var list = eval("(" + list + ")");
                	  for(var i=0;i<list.nActivityPlan.length;i++){
                	  	//alert(list.nActivityPlan[i].planName);
                	  	var option=$("<option value='"+list.nActivityPlan[i].id+"'>"+list.nActivityPlan[i].planName+"</option>")
                	  	$('#activityId').append(option);
                	  }
                    
                 }
        });
	});
	function addAlbum(){
		if($('#albumName').val()!=null&&$('#albumName').val()!=""){
			$("#addAlbumform").submit();
		}else{
			alert("请填写相册名称！");
			return false;
		}
		
	}
	function updateAlbumform(){
		$("#updateAlbumform").submit();
	}
	$(function(){
		$(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '65px', height: '25px'});
		$(".ibtn").hide();
		$(".update").hide();
		$(".albumDesc_up").hide();
		$('dd').mouseout(function(){
				$(this).find(".ibtn").hide();
				$(this).find(".update").hide();
				$(this).find(".albumDesc_up").hide();
			}).mouseover(function(){
				$(this).find(".ibtn").show();
				$(this).find(".update").show();
				$(this).find(".albumDesc_up").show();
			});
		$('.ibtn').click(function(){
			$(this).parent().unbind("click");
			var gnl=confirm("你真的打算删除吗?");
			if (gnl==true){
				var id=$(this).siblings("img").attr("id");
				location.href="$request.contextPath/professional/album/delete?id="+id;
			}else{
				top.location.reload();
			}
		});
		$('.update').click(function(){
			//仅用父类单击事件
			$(this).parent().unbind("click");
			$('#album_id').val($(this).siblings("img").attr("id"));
			$('#albumname').val($(this).siblings(".albumName_up").val());
			$('#albumdesc').val($(this).siblings(".albumDesc_up").val());
		});
		$(".dd").click(function(){
			var id=$(this).find('img').attr("id");
			location.href="$request.contextPath/professional/album/findOneAlbum?id="+id;
		});
	});
	function flush(){
		top.location.reload();
	}
	
</script>
  </body>
</html>
