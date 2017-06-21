<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>添加课件</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/assets/newCss/wucha.css"/>
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<link rel="stylesheet" href="/assets/newCss/program.css"/>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
	
	.add_first{margin-right:20px;}
	.table{width:60%; margin-left:70px;}
	.num{width:30px;}
	.a_color{margin-right:30px;}
	.span{color:#33CCFF}
	.uploadImg{display:none;}
	input[type='radio']{cursor: pointer;}
	.a_color:hover{color:red !important;}
	.delete_n{cursor: pointer;}
</style>
</head>
<body>
	<div class="wrapper">
			#parse("/common/head.tpl")
			<div class="main">
		        #parse("/common/providers.tpl")
			<div id="right"  >  
				<form   method="post"  action="/professional/fete/addNProgram" enctype="multipart/form-data" id="addNProgram">
					<input name="id" type="hidden" id="_nProgramId"  value="$!nProgram.id"/>
					<input name="parentId" type="hidden" value="$programId"/>
					<input type="button" class="btn-default add_x add_first btn success_1" value="保存"/><input type="button" class="btn-default add_x add_first btn" onclick="javascript:history.go(-1)" value="取消"/>
					<div  class="addClass">
					<label class="">课程名称：</label><input name="programName" value="$!nProgram.programName"/><a class="a_color"> * 必填项</a><br><br>
					<label class="">课程类型：</label>VIP <input type="radio" #if($!nProgram.type==true) checked="checked" #end name="type" value="1"/>     非VIP <input type="radio"  #if(!$!nProgram.type==false) checked="checked" #end  name="type" value="0"/><a class="a_color"> * VIP必填项</a><br><br>
					<label class="">课程售价：</label><input name="price" value="$!nProgram.price"/>元<a class="a_color"> * VIP必填项</a><br><br>
			        <br> 
					<label class="">特征标签：</label><input  id="u31_input"/> <input type="button" class="btn-default add_first btn addClass_input" value="确定"/><a class="a_color"> * 必填项(点击特征标签删除)</a>
					<input id="keyword" value="$!nProgram.keyword" type="hidden" name="keyword"/>
					<div class="addClass_main">
						
					</div>	
					<label class="">课程时长：</label>
					<input name="programTime" class="radio_" #if( $nProgram.programTime=="5 分钟") checked="checked" #end type="radio" value="5 分钟"/>5 分钟&nbsp;&nbsp;&nbsp;
					<input name="programTime" class="radio_" #if( $nProgram.programTime=="10分钟") checked="checked" #end type="radio" value="10分钟"/>10分钟&nbsp;&nbsp;&nbsp; 
					<input name="programTime" class="radio_" #if( $nProgram.programTime=="15分钟") checked="checked" #end type="radio" value="15分钟"/>15分钟&nbsp;&nbsp;&nbsp;
					<input name="programTime" class="radio_" #if( $nProgram.programTime=="20分钟") checked="checked" #end type="radio" value="20分钟"/>20分钟&nbsp;&nbsp;&nbsp; 
					<input name="programTime" class="radio_" #if( $nProgram.programTime=="25分钟") checked="checked" #end type="radio" value="25分钟"/>25分钟&nbsp;&nbsp;&nbsp; 
					<input name="programTime" class="radio_" #if( $nProgram.programTime=="30分钟") checked="checked" #end type="radio" value="30分钟"/>30分钟&nbsp;&nbsp;&nbsp;<a class="a_color"> * 必填项</a><br><br>     
					<label class="div_la">功能简介：</label>
					<textarea name="programDesc" rows="4" cols="70">$!nProgram.programDesc</textarea> <br><br>
					<label class="div_la">活动内容：</label>
					<textarea name="programContent" rows="4" cols="70">$!nProgram.programContent</textarea><br><br>
					<label class="div_la">实战经验：</label>
					<textarea name="programExperience" rows="4" cols="70">$!nProgram.programExperience</textarea><br><br>
					<label class="">物料详情：</label><input class="materials_name"/> <input class="_materias btn-default  add_first btn" type="button" value="确定"/>
					<table class="table _tale1 ta_11">
						<tr class="_active">
							<th>序号</th>
							<th>物料名称</th>
							<th>物料数量</th>
							<th>规格</th>
							<th>操作</th>
						</tr>
						#set($i=1)
						#foreach($n in $nProgram.nVenderMaterial )
						<tr class='clik_' date-id=$n.materialId>
							<td class='td_1'>$i</td>
							<td>$n.materialName</td>
							<td><a class='jian font_a' >-&nbsp; </a><input name='materialAmount' class='num' value='$n.materialAmount'/><a class='jia font_a'  > + </a></td>
							<th>$n.materialStandard</td>
							<td><a class="delete_n">删除</a><input type="hidden" value="$n.materialId" name='materialId' /></th>
						</tr>
						#set($i=$i+1)
						#end
					</table>
				</form>		
				</div>
			</div>
			</div>
	</div>
	<script>
		$(function(){
		 
			$('.uploadImg').show();
			$('#file').hide();
			if($('#keyword').val()!=""){
				var arr =$('#keyword').val().split(',');
				for(var i=0;i<arr.length;i++){
					var div1=$('<div  onclick="menuSH(this)" class="btn-default see_ add_first btn">'+arr[i]+'</div>');							 
					$('.addClass_main').append(div1);
				}
				
			}
			
			$('.addClass_input').click(function(){
			 	var val=$('#u31_input').val().replace(/\s+/g,"");
			 	if(val!=""){
					var div1=$('<div  onclick="menuSH(this)" class="btn-default see_ add_first btn">'+val+'</div>');							 
					$('.addClass_main').append(div1);
				}else{
					return false;
				}	
			});
			var mycars=new Array();
			$('._materias').click(function(){
				var name=$('.materials_name').val();
				$.ajax({
					url : "/professional/material/List?name="+name,
					success : function(json) {
						$('.materials_name').val("");
						var mjson = eval("(" + json + ")");
						var length = mjson.length;
						for (var i = 0; i < length; i++) {
							if($.inArray(mjson[i].id, mycars) ==-1){ 
								var tr = $("<tr class='clik_' date-id="+ mjson[i].id + "><td class='td_1'></td><td>"+mjson[i].materialName+"</td><td><a class='jian font_a' >-&nbsp; </a><input name='materialAmount' class='num' value='1'/><a class='jia font_a'  > + </a></td><td>"+mjson[i].materialStandard+"</td><td><a class=delete_n>删除</a><input type='hidden' value="+mjson[i].id+" name='materialId' /></td></tr>");
								$('.table').append(tr);
							}
						}
						var m=1;
						mycars.length=0;
						$('.clik_').each(function(){
							var n=m-1;
							mycars[n]=Number($(this).attr("date-id"));
							$(this).children('.td_1').html(m);
							m++;
						});
					}
				});
			});
			
			$(document).on('click','.jia',function(){
				var num1=Number($(this).prev('.num').val());
				num1+=1;
				$(this).prev('.num').val(num1);
			});
			$(document).on('click','.delete_n',function(){
				$(this).parent().parent().remove();
			});
			$(document).on('click','.jian',function(){
				var num1=Number($(this).next('.num').val());
				if(num1>1){
					num1=num1-1;
				}else{
					num1=1;
				}
				$(this).next('.num').val(num1);
			});
			$('.success_1').click(function(){
				var guan="";
				$('.see_').each(function(){
					guan+=$(this).html();
					guan+=","
				});
				guan=guan.substr(0,guan.length-1);
				$('#keyword').val(guan);
				if($('#_nProgramId').val()!=""){
					$('#addNProgram').attr("action","/professional/fete/updateNProgram");
				}
				
				if($("input[name='type']:checked").val()==undefined){
				    alert("请选择课程类型！");
				    return false;
				}else{
				    if($("input[name='type']:checked").val()==1){
				       var str=$("input[name='price']").val();
				       if(!(/^[+-]?\d*\.?\d*$/.test(str))){
				            alert("售价必须是数字！");
				            $("input[name='price']").val("");
				            return false;
				       }
				    }
				}
				if($('.ta_11 tr').length==1){
					alert("物料不能为空！");
					return false;
				}
				$('#addNProgram').submit();
			});
			
		});
		function menuSH(obj){
				if($('.addClass_main').children().length>1){
					obj.remove();
				}else{
					alert("特征标签数量必须大于一！");
				}
		}
		
	</script>
</body>
</html>