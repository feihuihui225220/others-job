<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>服务商详情</title>
#parse("/common/top.tpl")
 <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/common.css"/>
    <link rel="stylesheet" href="/assets/css/reg.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
     <style>
         .bodyposition{ margin-right:5%;}
         .tablediv{width: 70%;float:left;}
         .searchli{float:left;margin-left:5%;}
         .nav-pills>li.active>a, 
         .nav-pills>li.active>a:hover, 
         .nav-pills>li.active>a:focus{background-color:#4CEDF7 !important;}
         #rightIframe{border:0px;width:85%;height:1200px;float:right;}
         .divcss5{padding:20px; width:180px;height:240px;border:1px solid #C5C5C5} 
         .divcss5{border:1px solid #C5C5C5} 
         
        .top{ margin:0; height:1300px; background-color:#12D4E0; width:10%; float:left}
	</style>
</head>
<body>
    #parse("/common/head.tpl")
<div class="wrapper">
    	<div class="top" >
    		<ul id="nav" class=" nav nav-pills nav-stacked clourstitle1" style="float:left;width:100% ">
		        <li index="1" class="rel on"><a>服务商信息</a></li>
                <li index="2" class="rel"><a>服务商评价</a></li>
				<li index="3" class="rel"><a>服务对象</a></li>
              <!--  <li index="4" class="rel"><a>服务项目</a></li>  -->
		    </ul>
   		</div>
	   <div class="body" style="width:70%;float:right; margin-right:10%">
        <div class="usermessbox bodyline pad10 mgb10 clearfix" style="fliat:right">
            <div class="umleft f_l clearfix adddiv">
                <ul class="usermes1 f_l addul">
                    <li><label class="addul1_label">服务商名称：</label><span class="strong">${venderVO.name}</span></li>
                    <li><label class="addul1_label">联系人：</label><span class="strong">${venderVO.contact}</span></li>
                    <li><label class="addul1_label">服务商类别：</label><span class="strong">专业服务</span></li>
                    <li>
                    	<label class="addul1_label">评级：</label>
                    	<span class="strong">
                    		#if($venderVO.star > 0)
	                    		#foreach($i in [1..6])
	                    		★
		                    		#if($i == $venderVO.star)
		                    			#break;
		                    		#end
	                    		#end
                    		#end
                    	</span>
                    </li>
                </ul>
                <ul class="usermes1 meswidth f_l addul1">
                    <li><label class="addul1_label">联系电话：</label><span class="strong">${venderVO.contactPhone}</span></li>
                    <li><label class="addul1_label">办公地址：</label><span class="strong">${venderVO.contactAddr}</span></li>
                    <li><label class="addul1_label">服务分类：</label><span class="strong">${venderVO.categoryName}</span></li>
                    #if(${venderVO.longitude} && ${venderVO.latitude})
                    <li>
                   		<div style="width:200px;height:200px;" id="position">
                   		
                   		</div>
                   	</li>
                   	#end
                </ul>
            </div>
        </div>
        
        
        <div class="" >
            <ul class=" strong mgb10">
            </ul>
            <div class="actboxlist">
				<iframe src="/professional/vender/tab/detail?venderId=${venderVO.id}" scrolling="no" onload="Javascript:iframeAutoSet(this)" width="100%" height="250" frameborder="0"></iframe>
            </div>
        </div>
        
    </div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
<script type="text/javascript">
$(function(){
	#if(${venderVO.longitude} && ${venderVO.latitude})
	//百度地图api
	var map = new BMap.Map("position",{enableMapClick:false}); 
	map.disableDragging(); 
	//map.enableScrollWheelZoom(true);
	var point = new BMap.Point($!{venderVO.longitude},$!{venderVO.latitude});
	map.centerAndZoom(point, 15);
	var marker = new BMap.Marker(new BMap.Point($!{venderVO.longitude},$!{venderVO.latitude}));
	map.addOverlay(marker);
	#end
    $(".clourstitle1 li").click(function(){
        var index = $(this).attr('index');
        $(this).addClass('on').siblings().removeClass('on');
        $(".actboxlist .actbox"+index).show().siblings().hide();
        if(index == 1) {
			$(".actboxlist iframe").attr("src", "/professional/vender/tab/detail?venderId=${venderVO.id}");
		}else if(index == 2) {
			$(".actboxlist iframe").attr("src", "/professional/vender/tab/eva?venderId=${venderVO.id}");
		}else if(index == 3) {
			$(".actboxlist iframe").attr("src", "/professional/vender/tab/users?venderId=${venderVO.id}");
		}else if(index == 4) {
			$(".actboxlist iframe").attr("src", "/professional/vender/tab/service?venderId=${venderVO.id}");
		}
    });
});
</script>
</body>
</html>