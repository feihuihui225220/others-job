<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>志愿者,列表</title>
<link href="/assets/newCss/index.css" rel="stylesheet" type="text/css">
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/country_1.js"></script>
<style>
.table{width:86%;}
.img_{width:200px;height:150px;}
</style>
</head>
<body>
	<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
			#parse("/common/providers.tpl")
				<div class="content fl">
						<div class="r_top">
							<a class="select a_right select_add" style="cursor:pointer" >保存</a> <a class="select a_right" style="cursor:pointer" onclick="javascript:history.back();">返回</a><br><br><br>
                            <label>基础信息</label><a class="a_left"> * 为必填项</a><br>
						</div>
					<form method="post" action="/professional/site/update" enctype="multipart/form-data" id="update">
						<div class="r_middle search">
									<br>
									 <label class="lable_1">站点名称：<input
										placeholder="站点名称" id="siteName" name="siteName" value="$mVenderSite.siteName"><a
										class="a_color"> * </a> <text id="_texth">
										<text></label><br>
									<br>
									<input type="hidden"  name="id" value="$!{mVenderSite.id}">
									<input type="hidden" name="longitude" value="$!{mVenderSite.longitude}">
									<input type="hidden" name="latitude" value="$!{mVenderSite.latitude}">
									<label class="lable_1">所在区域： <select
										style="width: 140px; margin-left: -5px;" class="stationSearch" id="province" next="city">
											<option value="0">请选择</option>
									</select> <select class="stationSearch" style="width: 140px;" id="city" next="region">
											<option value="-1">请选择</option>
									</select> <select style="width: 140px;" class="stationSearch" id="region" next="street">
											<option value="-1">请选择</option>
									</select> <select style="width: 140px;" class="stationSearch" id="street" name="countryId">
											<option value="-1">请选择</option>
									</select> <a class="a_color"> * </a>
									<text id="_text">
										<text></label><br>
									<br>
									 <label class="lable_1">活动地点：<input
										placeholder="请输入活动地点" id="sAddress" name="sAddress" value=$!{mVenderSite.sAddress}><a
										class="a_color"> * </a> <text id="_texth">
										<text></label><br>
									<br>
									<br>
									<!--<label  class="lable_1">封&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;面：<input placeholder="封面"  type="file" style="width:40%" class="img_site"  multiple name="pic" ></label>-->
									<label class="lable_1">位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置：</label>
									<div style="width:730px;height:260px;margin-left:105px;" id="position">
           							</div>
									<br>	
								
						</div>
						<label class="title_">服务信息</label><a class="a_left title_a"> * 为必填项</a>
						<div class="r_middle_1 search">
							<label class="lab_1">服务社区: </label> <select
										style="width: 140px; margin-left: -5px;" class="stationSearch" id="province_1" >
											<option value="0">请选择</option>
									</select> <select class="stationSearch" style="width: 140px;" id="city_1" >
											<option value="-1">请选择</option>
									</select> <select style="width: 140px;" class="stationSearch" id="region_1">
											<option value="-1">请选择</option>
									</select> <select style="width: 140px;" class="stationSearch" id="street_1">
											<option value="-1">请选择</option>
									</select> <select style="width: 140px;" class="stationSearch" id="community_1">
											<option value="-1">请选择</option>
									</select> <a class="a_color"> * </a>
									<text id="_text">
										<text></label><br>
									<br>
									<input  type="hidden" id="communityIds" name="communityIds" value="${mVenderSite.communityIds}"  >
									<input id="street_2" type="hidden" value="$!{mVenderSite.countryId}"  >
									<input id="imgs" type="hidden"  value="$!{mVenderSite.imgUrl}"  >
									<table class="table" type="hidden"  id="community_as">
										<tr>
											<th>社区名称</th>										
											<th>社区联系人</th>										
											<th>职称</th>										
											<th>联系方式</th>										
											<th>备注</th>										
										</tr>
									</table>
						</div>
						<label class="title_">环境信息</label><a class="a_left title_a"> * 为必填项</a>
						<div class="r_middle_1 search">
							<label class="lab_1">场地面积: </label><input id="siteArea" name="siteArea" value="$!{mVenderSite.siteArea}">平方米 <a class="a_left "> * </a><br><br>
							<label class="lab_1">场地环境: </label><a class="span_img" >添加图片<input name="pic" id="file" type="file"></a><br><br><br>
							<div class="ming_div">
							</div>
							
							<label class="lab_2">固定设施: </label><textarea name="sFixture" rows="5" cols="80">$!{mVenderSite.sFixture}</textarea>
						</div>
						<div class="buttom"></div>
					</form>
						<div id="map" style="width: 600px; height: 459px;"></div>
						</div>
			</div>
			
	</div>
</div>
	<script src="/assets/js/jquery-1.8.0.min.js"></script>
	<script type="text/javascript" src="/assets/js/layer.min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
	<script type="text/javascript">
		$(function(){
			var value=$('#communityIds').val();
			
			if(value!=null&&value!=""){
				value=value.substring(1,value.length);
				$.ajax({
					type:'post',
	                url:"/community/getCountryList?ids="+value,
	                dataType:'json',
	                success:function(data){
	                	for(var i=0;i<data.countrys.length;i++){
	                		var tr=$('<tr><td>'+data.countrys[i].name+'</td><td>暂无</td><td>暂无</td><td>暂无</td><td>暂无</td></tr>');
							$('#community_as').append(tr);
	                	}
	                }
				});	
		        
			}
    			 
    			$.ajax({
    					type:'post',
    	                url:"/community/oCountry?id="+$('#street_2').val(),
    	                dataType:'json',
    	                success:function(data){
    	                		option=$('<option selected="selected" class="option5" value='+data.countrys.id+'>'+data.countrys.name+'</option>')
    	                		$('#street').append(option);
    	                }
    			});	
			
			$('#community_1').change(function(){
				var value=$('#communityIds').val();
				var id=$(this).val();
				var name=$(this).find("option:selected").text();
				var tr=$('<tr><td>'+name+'</td><td>暂无</td><td>暂无</td><td>暂无</td><td>暂无</td></tr>');
				$('#community_as').append(tr);
				value+=",";value+=id;
				$('#communityIds').val(value);
				if(value!=null&&value!=""){
						value=value.substring(1,value.length);
						var arr = value.split(',');
			        	$('#community_1 option').each(function(){
							if($(this).val()==arr[arr.length-1]){
								$(this).hide();	
							}
						});
				        
					}
			});
			var imgs=$('#imgs').val();
			if(imgs!=null&&imgs!=""){
					var arrImg = imgs.split(',');
					for(var m=0;m<arrImg.length;m++){
						var img=$('<img class="img_"src="/'+arrImg[m]+'">');
						$('.ming_div').append(img);
					}
			}
		});
		$(function(){
			#if(${mVenderSite.longitude} && ${mVenderSite.latitude})
			//百度地图api
			var map = new BMap.Map("position",{enableMapClick:false}); 
			map.disableDragging(); 
			//map.enableScrollWheelZoom(true);
			var point = new BMap.Point($!{mVenderSite.longitude},$!{mVenderSite.latitude});
			map.centerAndZoom(point, 15);
			var marker = new BMap.Marker(new BMap.Point($!{mVenderSite.longitude},$!{mVenderSite.latitude}));
			map.addOverlay(marker);
			#end
		});
		
		$('.select_add').click(function() {
		var name = $('#siteName').val();
		name = name.replace(/\s+/g, "");
		var siteArea = $('#siteArea').val();
		siteArea = siteArea.replace(/\s+/g, "");
		var sAddress = $('#sAddress').val();
		sAddress = sAddress.replace(/\s+/g, "");
		if (name.length == 0) {
			alert("请填写站点名称");
			return false;
		}
		var city = $('#street').val();
		if (city == -1) {
			alert("请选择所在区域");
			return false;
		}
		
		if (sAddress.length == 0) {
			alert("请填写活动地点");
			return false;
		}
		
		var length=$('#community_as').find('tr').length;
		if(length<2){
			alert("请选择社区");
			return false;
		}
		
		if (siteArea.length == 0) {
			alert("请填写场地面积");
			return false;
		}
		$('#update').submit();
	});
	</script>
</body>
</html>