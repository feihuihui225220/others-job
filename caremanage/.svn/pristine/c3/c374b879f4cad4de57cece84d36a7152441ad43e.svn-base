<!DOCTYPE html>
  <head>
  	<title>相册</title>
     <title></title>
     <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="$request.contextPath/assets/plugins/css/animate.css">
	<link rel="stylesheet" href="$request.contextPath/assets/plugins/css/bootstrap.min.css">
	<link rel="stylesheet" href="$request.contextPath/assets/plugins/css/font-awesome.min.css">
	<link rel="stylesheet" href="$request.contextPath/assets/plugins/css/templatemo_misc.css">
	<link rel="stylesheet" href="$request.contextPath/assets/plugins/css/templatemo_style.css">
  	<link rel="stylesheet" href="$request.contextPath/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="$request.contextPath/assets/css/common.css"/>
	<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
	<script src="$request.contextPath/assets/plugins/js/jquery-1.10.2.min.js"></script>
	<script src="$request.contextPath/assets/plugins/js/jquery.singlePageNav.js"></script>
	<script src="$request.contextPath/assets/plugins/js/jquery.flexslider.js"></script>
	<script src="$request.contextPath/assets/plugins/js/jquery.lightbox.js"></script>
	<script src="$request.contextPath/assets/plugins/js/templatemo_custom.js"></script>
    <script src="$request.contextPath/assets/plugins/js/jquery-git2.js"></script><!-- previous next script -->
 	<script language="javascript" type="text/javascript">
	if(top.location!=self.location)top.location=self.location;
	</script>
  </head>
  <body>
 <div class="wrapper">
			 #parse("/common/head.tpl")
	<br/><br/>
	 <dl style="margin-left: 5%;text-algin:center; ">
      	#foreach($a in $listPhoto)
       		<dd class="dd" style="float:left; margin-left:1%; Height:180px;">
         		<div class="gallery-item" style="width:180px;height:138px;">
					<img alt="$!a.photoName" id="$!a.id" name="$!a.photoName" src="/$a.photoUrl">
					<div class="overlay" style="width:100% height:100% position: relative; top:-5px;">
						<a href="/$a.photoUrl" data-rel="lightbox" class="fa fa-arrows-alt">展示</a>
					</div>
				</div>
				<input name="photoName" class="photoName_zhan" style='border:0px;' readonly="readonly" value="$!a.photoName"/><br/>
				<input name="photoDesc" class="photoDesc_zhan" style='border:0px;' readonly="readonly" value="$!a.photoDesc"/><br/>
 	   		</dd>
    	 #end
     </dl>
		
</div>	 
		<script src="$request.contextPath/assets/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="$request.contextPath/assets/js/bootstrap.min.js"></script>
		<script>
			$(function(){
			$(".photoDesc_zhan").hide();
			$(".delete").hide();
			$(".update").hide();
			$('dd').mouseout(function(){
				$(this).find(".photoDesc_zhan").hide();
				$(this).find(".delete").hide();
				$(this).find(".update").hide();
			}).mouseover(function(){
				$(this).find(".photoDesc_zhan").show();
				$(this).find(".delete").show();
				$(this).find(".update").show();
			});
	});
	
		</script>
  </body>
</html>