<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>志愿者,列表</title>
   	#parse("/common/top.tpl")
 	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/common.css"/>
    <link rel="stylesheet" href="/assets/newCss/index.css" />
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/assets/js/top.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <script src="/assets/js/pageNavigator.js"></script>
	<script src="/assets/js/country_1.js"></script>
</head>
<style>
   .bodyposition{ margin-right:5%;margin-left:5%;}
         .tablediv{width: 70%;float:left;margin-left:5%;}
         .searchli{float:left;margin-left:5%;}
         .nav-pills>li.active>a, 
         .nav-pills>li.active>a:hover, 
         .nav-pills>li.active>a:focus{background-color:#4CEDF7 !important;}
         a:hover{text-decoration:none;}
    .lable_1{margin-left:30px;} 
    .plan_{padding-top:20px;} 
    .a_color{color；red;}  
    .text{color；red;} 
    .a_left{margin-left:28px;}
    
    
</style>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
	<div id="right">  
			<br>
			<button class="btn-default add_first add_first_1 btn ">新增站点</button>
				<div  class=" div_from_site panel-primary plan_ product-container">
				 		<a class="a_left"> * 为必填项</a>
				 		<form  method="post" action="/professional/site/save" enctype="multipart/form-data"  id="save" >
						<br><input type="hidden" name="longitude" value="$!{vender.longitude}">
            			<input type="hidden"   name="latitude" value="$!{vender.latitude}">
						<label 	class="lable_1">所在区域：
							<select style="width:70px;margin-left:-5px;"   id="province" next="city">
		                		<option value="0">请选择</option>
			                </select>
			                <select style="width:70px;"  id="city" next="region">
			                    <option value="-1">请选择</option>
			                </select>
			                <select style="width:70px;" id="region" next="street">
			                    <option value="-1">请选择</option>
			                </select>
			                <select style="width:70px;"  id="street" name="countryId" >
			                    <option value="-1">请选择</option>
			                </select>
			                <a class="a_color"> * </a><text id="_text"><text>
						</label><br><br>
						<label 	class="lable_1">站点名称：<input placeholder="站点名称" id="siteName" name="siteName"/><a class="a_color"> * </a> <text id="_texth"><text></label><br><br>
						<!--<label  class="lable_1">封&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;面：<input placeholder="封面"  type="file" style="width:40%" class="img_site"  multiple name="pic" ></label>-->
						<label class="lable_1">位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置：</label><input type="button" value="添加地理位置" class="btn-default add_first  btn" style="margin-left:70px;margin-top:-22px;" id="pos_btn"/>
						
						<div>
							<br>
							<input type="button"class="btn btn-primary button_float" id="vo_submit" value="确认 "/><input type="button" class="btn btn-default button_float _quxiao" value="取消"/>
						</div>
					</form>
				</div>
		<div style="margin-top: 10px;margin-right: 10px">
		   <form  method="post" action="/professional/site/sitemanage"  name="searchForm">
		   </form>
		    <table class="table _tale1" style="margin-top: 10px">
		        <tr class="_active">
		            <th>序号</th>
		            <th>站点名称</th>
		            <th>添加时间</th>
		            <th>开站评估</th>
		            <th>评估完成时间</th>
		            <th>评估结果</th>
		            <th>是否添加新站点</th>
		            <th>编辑</th>
		            <th>删除</th>
		        </tr>
		       #foreach($e in $page.result)
		        #set($i = $velocityCount + 1)
		        <tr class=" #if($i%2!=0 ) tr_two #else tr_first #end"data-id="$!e.id">
		            <td>$i</td>
		            <td>$!e.siteName</td>
		            <td>$!date.format('yyyy-MM-dd',$!e.createdAt)</td>
		            <!-- 需要站点Id -->
		            <td><a href="/professional/vender/service/assess?userId=$!e.id&type=2">评估记录</a></td>
		            <td>$!date.format('yyyy-MM-dd',$!e.endTime)</td>
		            <td>$!e.assessResult</td>
		            <td><a href="#" class=" _button_add _see _available" id="$!e.id" date-value="$!e.id">#if($!e.available==true) 已添加 #else 未添加 #end</a></td>
		            <td data-list="$!e.id">
		                <a class=" _button_add _see"   #if($!e.available==false) href="" style="color:red;" #else href="/professional/site/toupdate?id=$!e.id"   #end  >编辑</a>
		            </td>
		            <td data-list="$!e.id">
		                <a href="#" class="_delete ">删 除</a>
		            </td>
		        </tr>
		        #end
		    </table>
		    #parse("/common/page.tpl")
		</div>
		<div id="map" style="width:600px;height:459px;">
		</div>
  		<script src="/assets/js/layer.min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
		<script type="text/javascript">
		    $(function(){
		    	$('#map').hide();
		    	//百度地图api
		    	var map = new BMap.Map("map",{enableMapClick:false});   
		    	//单击获取点击的经纬度
		    	map.addEventListener("click",function(e){
		    		console.debug(e.point.lng+","+e.point.lat)
		    		//删除原有点
		    		var allOverlay = map.getOverlays();
		    		for (var i = 0; i < allOverlay.length; i++){
		    			map.removeOverlay(allOverlay[i]);
		    		}
		    		//设置input值
		    		$("input[name='longitude']").val(e.point.lng);
		    		$("input[name='latitude']").val(e.point.lat);
		    		//画点
		    		var clickpoint = new BMap.Point(e.point.lng, e.point.lat);
		    		var marker = new BMap.Marker(clickpoint);
		    		map.addOverlay(marker);
		    		//改变按钮颜色
		    		$('#pos_btn').css({background:'#3385ff',width:'auto'});
		    		$('#pos_btn').val(e.point.lng+","+e.point.lat);
		    	});
		    	
		    	var point = new BMap.Point(116.404081,39.924226);
		    	map.centerAndZoom(point, 15);
		    	map.enableScrollWheelZoom(true);
		    	map.setDefaultCursor("crosshair");
		    	//地图
		      $('#pos_btn').click(function(){
		      	$.layer({
		              type : 1,
		              title : '选择位置',
		              offset:['100px' , ''],
		              border : false,
		              shadeClose:true,
		              fadeIn: 300,
		              area : ['600px','460'],
		              page : {dom : '#map'}
		          });
		
		      });
		      $(".autocomplete").click(function(){
		          $(this).hide().next('input').show().focus();
		      });
		    });
	    </script>
        </div> 
</div>
</div>
</body>
<script>
	$("._delete").on("click", function () {
        	var gnl=confirm("你真的打算删除吗?");
				if (gnl==true){
					var table_id = $(this).parent().attr("data-list");
					$(this).attr("href", "/professional/site/delete?id=" + table_id);
				}else{
					return  false;
				}
      });     
    $(".add_first_1").click(function(){
    	//$(".plan_").toggle();
    	location.href="/professional/site/toSave";
    });
    $(function(){
    	$(".plan_").hide();
    });
    $('._quxiao').click(function(){
    	$('#contact').val("");
    	$('#age').val("");
    	$('#volunteerName').val("");
    	$(".plan_").hide();
    });
    
    $('._available').click(function(){
    	var id=$(this).attr("date-value");
    	 $.ajax({
                url: "/professional/site/available?id="+id,
                type: "post",
                success: function (mjson) {
               		 location.reload();
                }
        
        });
    
    });
    
    $('#vo_submit').click(function(){
    	var name=$('#siteName').val();
   		name=name.replace(/\s+/g, "");
   		if(name.length==0){
   			$('#_texth').html("请填写站点名称");
   			return false;
   		}
   		var city=$('#street').val();
   		if(city==-1){
   			$('#_text').html("此项必选项");
   			return false;
   		}
   		$('#save').submit();
    });
    
</script>
</html>