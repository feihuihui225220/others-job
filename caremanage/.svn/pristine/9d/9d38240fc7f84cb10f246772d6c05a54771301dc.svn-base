<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script>
    function checkParm(){
          if(!document.getElementById("nameTxt").value){
              alert("请输入服务商名称！");
          }else if(!document.getElementById("phoneTxt").value){
              alert("请输入服务商电话！");
          }else if(!document.getElementById("adminTxt").value){
              alert("请输入服务商管理员用户名！");
          }else if(!document.getElementById("adrTxt").value){
              alert("请输入服务商地址！");
          }else if(!document.getElementById("pwdTxt").value){
              alert("请输入服务商管理员密码！");
          }else if(!document.getElementById("intrTxt").value){
              alert("请输入服务商简介！");
          }else{
              document.getElementById("commitForm").submit();
          }
          
    }
</script>
<style>
.fix_detail ul label {width:6em;}
.fix_detail .inpubox li {width:300px;float:left;}
.fix_detail .inpubox .w520 {clear:both;width:auto;}
/*.fix_detail .inpubox .w520 label {width:7em;}*/
.fix_detail .inpubox .w520 .tit {width:6em;}
.fix_detail .inpubox .w520 input {vertical-align:text-bottom;}
.fix_detail .inpubox .w520 div {margin-left:7em;margin-top:-39px;}
.fix_detail .inpubox .w520 .fix_len {width:auto;}
.fix_detail .inpubox .auto {width:auto;}
</style>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="reg_area fix_pop fix_detail" style="width:660px">
        <form id="commitForm" method="post" action="/professional/vender/commit" class="limitbox pad10">
            <input type="hidden" name="longitude" value="$!{vender.longitude}">
            <input type="hidden" name="latitude" value="$!{vender.latitude}">
            <ul class="inpubox clearfix ">
                <li><label>服务商名称：</label><input id="nameTxt" type="text" name="name" value="$!{vender.name}" /></li>
                <li><label>联系电话：</label><input id="phoneTxt" type="text" name="contactPhone" value="$!{vender.contactPhone}" /></li>
                <li><label>管理员：</label><input id="adminTxt" type="text" name="userName" value="$!{vender.userName}" /></li>
                <li><label>联系地址：</label><input  class="autocomplete" type="text" value=""><input id="adrTxt" type="text" autocomplete="off" name="contactAddr" value="$!{vender.contactAddr}" style="display:none;" /></li>
                <li><label>位置：</label><input type="button" value="点击选择" id="pos_btn"></li>
                <li><label>密码：</label><input class="autocomplete" type="text" value=""><input id="pwdTxt" type="password" autocomplete="off" name="password" value="$!{vender.password}" style="display:none;" /></li>
                <!--
                <li>
                	<label>服务分类：</label><select name="categoryId">
						#foreach($catItem in $catItems)
							<option value="${catItem.id}" #if($catItem.id == $vender.categoryId) selected #end>${catItem.itemName}</option>
						#end                		
                	</select>
                </li>
               
                <li class="w520">
                	<label class="tit">准入资质：</label>
                	#foreach($service in $services)
                		<label>${service.name} <input type="checkbox" name="" value="${service.id}" /></label>
                	#end
                </li>
                -->
                <li class="w520"><label>服务商简介：</label><textarea id="intrTxt" name="introduction" cols="72" rows="8"></textarea>
                </li>
            </ul>
        <p class="opt">
        	<button type="button" class="btn button_delete" onclick="javascript:history.go(-1)">取消</button>
        	<button type="button" class="btn  button_gm" onClick="checkParm()">添 加</button>
        </p>
        </form>
    </div>
    <div class="footer">
    </div>
    <div id="map" class="hide" style="width:600px;height:459px;">
		</div>
		<script type="text/javascript" src="/assets/js/layer.min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.4"></script>
    <script type="text/javascript">
    $(function(){
    	
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
</body>
</html>