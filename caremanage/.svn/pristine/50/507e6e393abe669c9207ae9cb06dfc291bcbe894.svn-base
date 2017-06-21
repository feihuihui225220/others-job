<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>空间图片</title>
<link rel="stylesheet" href="/assets/newCss/wucha.css"/>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css"/>
	<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
	<link rel="stylesheet" href="$request.contextPath/assets/css/zyUpload.css" />
	<script type="text/javascript" src="$request.contextPath/assets/js/jquery-1.7.2.js"></script>
 	<script type="text/javascript">
	        var $172 = $;
 	</script>
	<script src="/layer/jquery.js?v=1.83.min"></script>
 	<script type="text/javascript">
	        var $183 = $;
 	</script>
 	<link rel="stylesheet" href="$request.contextPath/assets/plugins/css/bootstrap.min.css">
 	<script src="$request.contextPath/assets/js/jquery-2.1.4.min.js"></script>
 	<script type="text/javascript" src="$request.contextPath/assets/js/bootstrap.min.js"></script>
  	<script type="text/javascript">
	        var $214 = $;
 	</script>
	<script type="text/javascript" src="$request.contextPath/assets/js/zyupload-1.0.0.js"></script>
  	<script type="text/javascript">
        console.log($172.fn.jquery);
        console.log($183.fn.jquery);
        console.log($214.fn.jquery);
    </script>
<script src="/layer/layer.min.js"></script>
<style>
html{background-color:#E3E3E3; font-size:14px;  font-family:'微软雅黑'}
a,a:hover{ text-decoration:none;}
pre{font-family:'微软雅黑'}
.box{padding:20px;  margin:20px 100px; border-radius:5px;}
.box a{padding-right:15px;}
#about_hide{display:none}
.layer_text{background-color:#fff; padding:20px;}
.layer_text p{margin-bottom: 10px; text-indent: 2em; line-height: 23px;}
.button{display:inline-block; *display:inline; *zoom:1; line-height:30px; padding:0 20px; background-color:#56B4DC; color:#fff; font-size:14px; border-radius:3px; cursor:pointer; font-weight:normal;}
.img{width:180px;height:200px;padding:0 20px 20px;}
#addchbutton{margin-left:1.8%;position:relative;top:-25px;}
.album{position:relative;top:-40px;left:28px; width:60px;}
.album1{position:relative;top:-55px;left:28px; width:60px;}
.album2{position:relative;top:-50px;left:28px; width:60px;}
.upload_preview{ width:830px;}
</style>
<script language="javascript" type="text/javascript">
	if(top.location!=self.location)top.location=self.location;
	//$(function(){
		//$('#addchbutton').click(function(){
			//var id=$!photoId;
			//location.href="/professional/album/findOneAlbum/toAdd?id="+id;
		//});
	//})
	$(function(){
			//删除单张图片
			$('.delete').click(function(){
				$(this).parent().unbind("click");
				var gnl=confirm("你真的打算删除吗?");
				if (gnl==true){
					var id=$(this).attr("data-id");
					//var src=$(this).siblings("div").find("img").attr("src");
					var al=$!photoId;
					location.href="$request.contextPath/professional/photo/delete?id=" + id +"&albumId=" +al;
				}else{
					top.location.reload();
				}
			});
			});
</script>
<script>
;!function(){
layer.use('/extend/layer.ext.js', function(){
    //初始加载即调用，所以需放在ext回调里
    layer.ext = function(){
        layer.photosPage({
            html:'<div style="padding:20px;"></div>',
            title: '快捷模式-获取页面元素包含的所有图片',
            id: 100, //相册id，可选
            parent:'#imgs'
        });
    };
});

}();
</script>
</head>
<body class="body1">
 #parse("/common/head.tpl")
<div class="box wrapper">
			 <br/>
			<button data-toggle="modal" data-target="#addphoto" class="btn button_add" id="addchbutton" >添加照片</button>  
		    <div id="imgs"  >
		       	#foreach($a in $listPhoto)
				       	<div class="imgs" style="float:left;height:220px;">
				       		<img class="img" id="$a.id" name="$!a.photoName" layer-pname="$!a.photoDesc"   data-value="$!a.photoDesc" src="/$a.photoUrl"><br/>
							<button data-toggle="modal" data-target="#updatephoto" class="album2 button_add update">修改</button>			       
							<button   data-id="$a.id" class="album2 button_delete delete">删除</button>	<br/>
							<p class="album">$a.photoName</p>	       
				       	</div>
		       	#end
		    </div>
			   <div id="updatephoto" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
			    <div class="modal-dialog" style="width:300px;">
			      <div class="modal-content">
			        <div class="modal-body">
			  			 <form  id="updatePhotoform"  method="post"  action="$request.contextPath/professional/photo/editPhoto">
								<input name="id" id="photo_Id" type="hidden">
							    <label>照片名称</label>
							    <input type="text" id="photoname" class="photoname form-control" name="photoName">
							    <label>照片描述</label>
							   <input type="text" id="photodesc" class="photodesc form-control" name="photoDesc" >
						  </form> 
						  <div class="modal-footer">
							  <button type="button" class="btn btn-default" style="float:right;margin-left:20px" data-dismiss="modal">取消</button>
				          	  <button type="button" class="btn btn-primary" style="float:right" id="yes" onclick="updatePhotoform()">确认</button>
		        	  	  </div>
			        </div>
			       </div>
			    </div>
			</div>
			<!-- ***********************************添加照片************************************* -->
			<div id="addphoto" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" ">
		      	 <div class="modal-dialog" id="addphoto_too" style="width:852px;" >
		      	  <div class="modal-content">
			        <div class="modal-body">
		      	 		<label>添加照片</label>
			        </div>
			        <div id="zyupload" class="zyupload"></div>  
					<input type="hidden" id="album" name="albumId" value="$photoId"/>
			        </div>
		  			
		    	</div>
		 	</div>   
</div>
<script>
$(function(){
	$(".delete").hide();
	$(".update").hide();
	$('.imgs').mouseout(function(){
				//$(this).find(".photoDesc_zhan").hide();
				$(this).find(".delete").hide();
				$(this).find(".update").hide();
			}).mouseover(function(){
				//$(this).find(".photoDesc_zhan").show();
				$(this).find(".delete").show();
				$(this).find(".update").show();
			});
	
});
$(function(){
		$('.update').click(function(){
			$('#photo_Id').val($(this).siblings("img").attr("id"));
			$('#photoname').val($(this).siblings("img").attr("name"));
			$('#photodesc').val($(this).siblings("img").attr("data-value"));
		});
	});

</script>
<script >
	$(function(){
	var albumId=$('#album').val();
		// 初始化插件
		$("#zyupload").zyUpload({
			width            :   "850px",                 // 宽度
			height           :   "400px",                 // 宽度
			itemWidth        :   "140px",                 // 文件项的宽度
			itemHeight       :   "115px",                 // 文件项的高度
			url              :   "/professional/photo/add?albumId="+albumId,  // 上传文件的路径
			fileType         :   ["jpg","png","js","exe"],// 上传文件的类型
			fileSize         :   51200000,                // 上传文件的大小
			multiple         :   true,                    // 是否可以多个文件上传
			dragDrop         :   true,                    // 是否可以拖动上传文件
			tailor           :   true,                    // 是否可以裁剪图片
			del              :   true,                    // 是否可以删除文件
			finishDel        :   false,  				  // 是否在上传文件完成后删除预览
			/* 外部获得的回调接口 */
			onSelect: function(selectFiles, allFiles){    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
				console.info("当前选择了以下文件：");
				console.info(selectFiles);
			},
			onDelete: function(file, files){              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
				console.info("当前删除了此文件：");
				console.info(file.name);
			},
			onSuccess: function(file, response){          // 文件上传成功的回调方法
				console.info("此文件上传成功：");
				console.info(file.name);
				console.info("此文件上传到服务器地址：");
				console.info(response);
				
				//$("#uploadInf").append("<p>上传成功，文件地址是：" + response + "</p>");
			},
			onFailure: function(file, response){          // 文件上传失败的回调方法
				console.info("此文件上传失败：");
				console.info(file.name);
			},
			onComplete: function(response){           	  // 上传完成的回调方法
				console.info("文件上传完成");
				console.info(response);
			}
			
		});
		
	});
	
</script> 

</body>
</html>