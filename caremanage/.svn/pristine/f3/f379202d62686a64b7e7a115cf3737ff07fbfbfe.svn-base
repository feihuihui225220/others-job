<!DOCTYPE html>
<html>
  <head>
    <title>相册管理</title>
	<link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="/assets/js/top.js"></script>
	
	<link href="$request.contextPath/assets/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
	<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
 	<script src="$request.contextPath/assets/js/jquery-2.1.4.min.js"></script>
    <script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
    <script src="$request.contextPath/assets/js/calendar.js"></script>
    <script src="$request.contextPath/assets/js/highcharts.js"></script>
 	<script type="text/javascript" src="$request.contextPath/assets/js/bootstrap.min.js"></script>
	<script language="javascript" type="text/javascript">
	if(top.location!=self.location)top.location=self.location;
</script>
<style>
.btn{display:inline-block;}
</style>
  </head>
  
  <body>
<div class="wrapper">
	 #parse("/common/head.tpl")
	 <br/><br/>
	 <dl style="margin-left: 5%;text-algin:center; ">
      	#foreach($a in $listAlbum)
       		<dd class="dd" style="float:left; margin-left:5%; ">
     	 		<img alt="$!a.albumName" id="$!a.id" style="width:180px;height:138px;" src="/file/pictures/$a.albumUrl"/>
 	   			<br/><input style='border:0px;' class="albumName_up" readonly="readonly" value="$!a.albumName"/>
 	   			<br/><input style='border:0px;' class="albumDesc_up" readonly="readonly" value="$!a.albumDesc"/><br/>
 	   		</dd>
 	   		
    	 #end
     </dl>
</div>
<script>
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
		$(".dd").click(function(){
			var id=$(this).find('img').attr("id");
			location.href="$request.contextPath/professional/album/myOneAlbum?id="+id;
		});
	});
	
	
</script>
  </body>
</html>
