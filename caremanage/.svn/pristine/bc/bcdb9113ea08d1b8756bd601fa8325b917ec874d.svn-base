<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>物料管理</title>
   	#parse("/common/top.tpl")
 	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/newCss/wuliao.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="/assets/newCss/index.css" />
    <style>
    	._lable1{text-align: center;
    	 display:inline-block;width:90px;    	}
    	
    </style>
</head>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
		<div id="right">  
			<div class="searchbox">
				<form   method="post"  action="/professional/material/select" enctype="multipart/form-data" style="height:30px">
				<label>名称:<input placeholder="按名称搜索" name="materialName" value="$!mMaterial.materialName"/></label>
				<label>类型:
					<select name="materialNature">
						<option  >请选择</option>
						<option #if($mMaterial.materialNature=="基础物料") selected="true" #end>基础物料</option>
						<option #if($mMaterial.materialNature=="课程物料") selected="true" #end>课程物料</option>
					</select>
				</label>
				<label><button class="btn-default add_first  btn">搜索</button></label>
				<label><input type="button" class="btn-default add_first add_first_1 btn" value="添加"/></label>	
				</form>
			</div>
			<!--  添加div版面  -->
			<div  class="div_from3 add_div product-container" >
			<form   method="post"  action="/professional/material/add" enctype="multipart/form-data">
				<label class="_lable1">物 料 名 称 ：</label><input id="materialName" name="materialName"/><br><br>
				<label class="_lable1">数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 量  ：</label><input id="materialAmount" name="materialAmount"/><br><br>
				<label class="_lable1">物 料 属 性 ：</label>
					<select name="materialNature">
						<option>基础物料</option>
						<option>课程物料</option>
					</select><br><br>
				<label class="_lable1">物 料 规 格 ：</label><input name="materialStandard" type="radio" value="小"/>小  <input name="materialStandard" type="radio" value="中"/>中  <input name="materialStandard" type="radio" value="大"/>大  <input name="materialStandard" type="radio" value="无规格"/>无规格<br><br>
				<label class="_lable1">重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量 ：</label><input id="materialWight" name="materialWight" /><br><br>
				<label class="_lable1">高&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度 ：</label><input id="materialHeight" name="materialHeight" /><br><br>
				<label class="_lable1">长&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度 ：</label><input id="materialLength" name="materialLength" /><br><br>
				<label class="_lable1">颜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色 ：</label><input id="materialColor" name="materialColor" /><br><br>
				<label class="_lable1">其 他 描 述 ：</label><input name="materialFeature" /><br><br>
				<label class="_lable1">添 加 图 片 ：</label> <input id="pic" name="pic" class="_img" type="file"/ ><br><br>
				<div>
					<input type="submit"class="btn btn-primary button_float" id="vo_submit" value="确认 "/><input type="button"  class="btn btn-default button_float _quxiao" value="取消"/>
				</div>
			</form>	
			</div>
			<!--  展示table  -->
			<div>
			 <table class="table _tale1" style="margin-top: 10px">
		        <tr class="_active">
		            <th>序号</th>
		            <th>物料名称</th>
		            <th>数量</th>
		            <th>规格</th>
		            <th>物料属性</th>
		            <th>图片</th>
		            <th>操作</th>
		        </tr>
		         #foreach($e in $page.result)
			        #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
			        <tr class="mid_$!e.id #if($i%2!=0 ) tr_two #else tr_first #end"data-id="$!e.id">
		            <td>$i</td>
		            <td>$!e.materialName</td>
		            <td>$!e.materialAmount</td>
		            <td>$!e.materialStandard</td>
		            <td>$!e.materialNature</td>
		            <td><a class="_select">查看图片</a><div class="img_hiden"><img class="materials_img" src="/file/mMaterial/$e.imgUrl"/></div></td>
		            <td>
						 <a class="_pdayeMate" date-id="$e.id" date-materialName="$e.materialName" date-materialAmount="$e.materialAmount" 
						 date-materialStandard="$e.materialStandard" date-materialNature="$e.materialNature" date-materialHeight="$e.materialHeight" 
						 date-materialWight="$e.materialWight" date-materialLength="$e.materialLength"   date-materialColor="$e.materialColor"  date-materialFeature="$e.materialFeature"  data-toggle="modal"  data-target="#addmaterials" >编辑</a>
						 <a class="deluser" userid="$!e.id">删除</a>
					</td>
		        </tr>
		        #end
	         </table>
	          #parse("/common/page.tpl")
          	</div>
		</div>
		
		
		<div id="addmaterials" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
					    <div class="modal-dialog">
					      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							          <br>
							          <h4 class="modal-title" id="myModalLabel">修改信息</h4>
							          <br>
							        </div>
						         	 <div class="modal-body">
							         	<form   method="post"  action="/professional/material/update" enctype="multipart/form-data">
											<input name="id" type="hidden" class="_id"/>
											<label class="_lable1">物料名称：</label><input class="_materialName" name="materialName"/><br><br>
											<label class="_lable1">数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：<!-- <select><br><br>
												<option>支</option>
												<option>条</option>
												<option>张</option>
												<option>个</option>
											</select> --></label><input class="_materialAmount" name="materialAmount"/><br><br>
											<label class="_lable1">物料属性：</label><select class="_materialNature" name="materialNature">
												<option >基础物料</option>
												<option>课程物料</option>
											</select><br><br>
											<label class="_lable1">物料规格： </label><input class="_materialStandard" name="materialStandard" type="radio" value="小"/>小  <input class="_materialStandard" name="materialStandard" type="radio" value="中"/>中  <input  class="_materialStandard" name="materialStandard" type="radio" value="大"/>大  <input  class="_materialStandard" name="materialStandard" type="radio" value="无规格"/>无规格<br><br>
											<label class="_lable1">重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量： </label><input cla class="_materialWight" name="materialWight" /><br><br>
											<label class="_lable1">高&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度： </label><input class="_materialHeight" name="materialHeight" /><br><br>
											<label class="_lable1">长&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度： </label><input class="_materialLength" name="materialLength" /><br><br>
											<label class="_lable1">颜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色： </label><input class="_materialColor" name="materialColor" /><br><br>
											<label class="_lable1">其他描述： </label><input class="_materialFeature" name="materialFeature" /><br><br>
											<label class="_lable1">添加图片： </label><input id="_pic" name="pic" class="_img" type="file" ><br><br>
											<div class="modal-footer">
												<input type="submit"class="btn btn-primary button_float" id="_vo_submit" value="确认 "/><input type="button" class="btn btn-default button_float _quxiao" value="取消"/>
											</div>
										</form>	
					      			</div>
					    	</div>
					    </div>
				
				</div>
        </div> 
</div>
<script src="/assets/js/bootstrap.min.js"></script>
<script>
	$(function(){
		$('.add_div').hide();
		$('.add_first_1').click(function(){
			$(".add_div").toggle();
		})
		
		$('._quxiao').click(function(){
			location.href='/professional/material/select';
		
		});
	});
	
	$(function(){
		$('.img_hiden').hide();
		
		$('._select').click(function(){
		if($(this).next("div").css("display")=="block"){
			$('.img_hiden').hide();
			$(this).next("div").hide();
		}
		else{
			$('.img_hiden').hide();
			$(this).next("div").toggle();
		}
		
			
			
			
		
		});
		$('._pdayeMate').click(function(){
			var id=$(this).attr("date-id");
			var materialName=$(this).attr("date-materialName");
			var materialAmount=$(this).attr("date-materialAmount");
			var materialStandard=$(this).attr("date-materialStandard");
			var materialNature=$(this).attr("date-materialNature");
			var materialHeight=$(this).attr("date-materialHeight");
			var materialWight=$(this).attr("date-materialWight");
			var materialLength=$(this).attr("date-materialLength");
			var materialColor=$(this).attr("date-materialColor");
			var materialFeature=$(this).attr("date-materialFeature");
			$('._id').val(id);
			$('._materialName').val(materialName);
			$('._materialAmount').val(materialAmount);
			$('._materialNature').val(materialNature);
			$('._materialNature').val(materialNature);
			$('._materialHeight').val(materialHeight);
			$('._materialWight').val(materialWight);
			$('._materialLength').val(materialLength);
			$('._materialFeature').val(materialFeature);
			$('._materialColor').val(materialColor);
			$('._materialNature').each(function(){
				if($(this).val()==materialNature){
					$(this).attr('select',true);				
				}
			});
			$('._materialStandard').each(function(){
				
				if($(this).val()==materialStandard){
					
					$(this).attr("checked",'checked');			
				}
			});
		});
	});
	
	$("#vo_submit").click(function(){
		var radio=$('input:radio[name="materialStandard"]:checked').val();
		var materialName=$('#materialName').val();
		var materialAmount=$('#materialAmount').val();
		var materialWight=$('#materialWight').val();
		var materialHeight=$('#materialHeight').val();
		var materialColor=$('#materialColor').val();
		var materialLength=$('#materialLength').val();
		var pic=$('#pic').val();
		if(materialName==""|| materialAmount==""){
			alert("请填写物料名称及数量");
			return false;
		}else if(materialWight==""|| materialHeight=="" ||
				materialColor=="" || materialLength==""){
			alert("请填写全物料的基本信息");
			return false;
		}else if(radio==null){
			alert("请选择物料规格");
			return false;
		}else{
			if(pic==""){
				alert("请上传物料照片");
				return false;
			}
		}
	});
	
	$("#_vo_submit").click(function(){
		var _radio=$('input:radio[name="materialStandard"]:checked').val();
		var _materialName=$('._materialName').val();
		var _materialAmount=$('._materialAmount').val();
		var _materialWight=$('._materialWight').val();
		var _materialHeight=$('._materialHeight').val();
		var _materialColor=$('._materialColor').val();
		var _materialLength=$('._materialLength').val();
		var _pic=$('#_pic').val();
		console.log(_pic);
		if(_materialName==""|| _materialAmount==""){
			alert("请补全物料名称及数量");
			return false;
		}else if(_materialWight==""|| _materialHeight=="" ||
				_materialColor=="" || _materialLength==""){
			alert("请填补全物料的基本信息");
			return false;
		}else if(_radio==null){
			alert("请选择物料规格");
			return false;
		}else{
			if(_pic==""){
				alert("请上传物料照片");
				return false;
			}
		}
	});
	
</script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript">
   $(".deluser").click(function(){
        var mid = $(this).attr("userid");
        layer.confirm('是否确定删除物料信息?', function(index){
            $.get("/professional/material/remove?id="+mid,function(result){
    			if(result=='success'){
	    			// 移除记录
            		$('.mid_'+mid).remove();
    			}
  			});
            layer.close(index);
        }, function(index){
            //console.log(index);
        });
    });
  </script>
</body>
</html>