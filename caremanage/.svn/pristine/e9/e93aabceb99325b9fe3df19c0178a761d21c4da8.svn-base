<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>培训记录添加</title>
    #parse("/common/top.tpl")
    <script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <script src="/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/pageNavigator.js"></script>
  	<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
  	<link rel="stylesheet" href="/assets/newCss/index.css" />
  	<style>
  		a{color:black;}
  		._div{margin-left:30px;}   
  	</style>
</head>
<style>
</style>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
	<div id="right" > 
	<label class="title_2 title_main">
			<a class="a_first" href="/professional/volunteer/see_train" >培训记录列表</a>
			</label><label class="title_2">|</label>
			<label class="title_2">
			<a class="a_first" href="/professional/volunteer/index">志愿者服务列表</a>
			</label>
			<label class="title_2">|</label>
            <label class="title_2">
            <a class="a_first" href="/nVolunteerAssess/palvelutietue">服务记录</a></label>
			<br><br><br><br>
			<button class="btn-default add_first btn  ">添加培训</button>
				<div  class=" div_from1 panel-primary plan_ product-container" >
				 		<form  method="post" action="/professional/volunteer/add_train_one"  id="" ><br><br>
						<input type="hidden" id="siteIds"  name="siteIds"/>
						<input type="hidden" id="commityIds" name="communityIds"/>
						<label>&nbsp;&nbsp;&nbsp;&nbsp;培训时间：
						<input id="start" name="start" class="timedate"   onclick="_SetTime(this)" >-<input id="end" name="end" class="timedate"   onclick="_SetTime(this)" ></label><br><br>
						<label>&nbsp;&nbsp;&nbsp;&nbsp;培训主题： <input id="theme" name="theme" /></label><br><br>
						<label>&nbsp;&nbsp;&nbsp;&nbsp;培训地址： <input id="trainplace"  name="trainPlace" /></label><br><br>
						<label>&nbsp;&nbsp;&nbsp;&nbsp;培训站点：	<select id="site">
									<option>-----请选择-----</option>
									#foreach ($s in $mVenderSite)
										<option  class="oCountry_communityIds"  value=$!s.id>$!s.siteName</option>
									#end
								</select><br>
							</label>
						<div class="add_traindiv1">
								
						</div>
							<label>&nbsp;&nbsp;&nbsp;&nbsp;培训社区： <select id="community" >
									<option value="0">-----请选择-----</option>
									#foreach ($o in $oCountry)
										<option  class="oCountry_communityIds"  value=$!o.id>$!o.name</option>
									#end
								</select>
							</label>
						<div class="add_traindiv2">
							
						</div>
						<div class="_div">
							<input type="submit"class="btn btn-primary button_float" id="vo_submit" value="确认 "/><input type="button" class="btn btn-default button_float _quxiao" value="取消"/>
						</div>
						</form>
				</div>
				
				
				<div id="addtrain" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
					    <div class="modal-dialog">
					      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							          <h4 class="modal-title" id="myModalLabel">修改信息</h4>
							        </div>
							        <form  method="post" action="/professional/volunteer/update_train"  id="formUpdate" ><br><br>
										<input id="_id_update" type="hidden"   name="id"/>
										<input type="hidden"  id="siteIds_update"  name="siteIds"/>
										<input type="hidden" id="commityIds_update" name="communityIds"/>
										<label>&nbsp;&nbsp;&nbsp;&nbsp;培训时间：
										<input id="_start_update"  name="start" class="timedate"   onclick="_SetTime(this)" >-<input  id="_end_update" name="end" class="timedate"   onclick="_SetTime(this)" ></label><br><br>
										<label>&nbsp;&nbsp;&nbsp;&nbsp;培训主题： <input id="_theme_update" name="theme" /></label><br><br>
										<label>&nbsp;&nbsp;&nbsp;&nbsp;培训地址： <input id="_trainPlace_update"   name="trainPlace" /></label><br><br>
										<label>&nbsp;&nbsp;&nbsp;&nbsp;培训站点：	<select id="site_update">
													<option>-----请选择-----</option>
													#foreach ($s in $mVenderSite)
														<option  class="oCountry_communityIds"  value=$!s.id>$!s.siteName</option>
													#end
												</select><br>
											</label>
											<div class="add_traindiv1_update _add_traindiv1_update">
													
											</div>
											<label>&nbsp;&nbsp;&nbsp;&nbsp;培训社区： <select id="community_update" >
													<option>-----请选择-----</option>
													#foreach ($o in $oCountry)
														<option  class="oCountry_communityIds"  value=$!o.id>$!o.name</option>
													#end
												</select>
											</label>
										<div class="add_traindiv2_update _add_traindiv2_update">
											
										</div> 
										
								        <div class="modal-footer"> <br>
											<input type="button" class="btn btn-primary button_float" id="_vo_submit" value="确认 "/>
											<input type="button" class="btn btn-default button_float _quxiao"  data-dismiss="modal" value="取消"/>
								        </div>
								        </form>
					      </div>
					    </div>
				
				</div>



	<form  method="post" action="/professional/volunteer/see_train"  name="searchForm" >
	    <ul class="inpubox clearfix inpubox_">
			<li><label>按站点查看：</label>
				<select id="inceonttwo"  name="inceonttwo"  class="select1"  style="height:25px;">
					<option   value=0>-----请选择-----</option>
					#foreach ($s in $mVenderSite)
						<option  class="oCountry_communityIds" #if($site==$!s.id) selected="selected" #end  value=$!s.id>$!s.siteName</option>
					#end
				</select>
			</li>
			<li><label>按社区查看：</label>
				<select id="inceont" name="inceont"  class="select1"  style="height:25px;">
					<option   value=0>-----请选择-----</option>
				</select>
			</li>
			
			<li><input class="sousuo button_gm" type="submit" value="搜索"></li>
	    </ul>
	 </form>	
	
	<table  class="table _tale1" style="margin-top: 10px" >
		<tr class="_active">
			<td>序号</td>
			<td>培训主题</td>
			<td>培训时间</td>
			<td>培训时长</td>
			<td>培训地点</td>
			<td>培训详情</td>
			<td>人员签到</td>
			<td>操作</td>
		</tr>
		
	 	#foreach($vc in $page.result)
	 	 #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
	        <tr class=" #if($i%2!=0 ) tr_two #else tr_first #end"id=$vc.id>
	 		<td>$i</td>
	 		<td>$vc.theme</td>
	 		<td>$!date.format('yyyy-MM-dd HH:mm',$vc.traindate)-$!date.format('yyyy-MM-dd HH:mm',$vc.endTime)</td>
	 		<td> $!vc.trainTimes </td>
	 		<td> $!vc.trainPlace</td>
	 		<td><a class="details">查看</a></td>
	 		<td style="cursor:pointer;" class="Sign_in">签到记录</td>
	 		<td>
	 		<a date-id="$!vc.id" date-start="$!date.format('yyyy-MM-dd HH:mm',$vc.endTime)" date-end="$!date.format('yyyy-MM-dd HH:mm',$vc.traindate)"  date-contact="$vc.theme"  date-del="$vc.trainPlace"  data-toggle="modal" data-target="#addtrain"   href="#"  class="_button_add redact _see">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="delete ">删除</a></td>
	 	</tr>
	 	#set($i=$i+1)	
	 	#end
	</table>
	#parse("/common/page.tpl")
	</div>	
</div>	
</div> 
</body>
<script>
	$(document).ready(function(){
	  
	  $(".add_traindiv1").on("click",".div_module",function(){
	    var date_value=$(this).attr('date-value');
			$('#site option').each(function(){
				if($(this).val()==date_value){
					$(this).show();				
				}
			});
			var str=","+date_value;
			var siteVlues=$('#siteIds').val();
			siteVlues=siteVlues.replace(str, '');
			$('#siteIds').val(siteVlues);
			$(this).remove();
	  });
	  
	  $(".add_traindiv2_update").on("click",".div_module1_update",function(){
			var date_value=$(this).attr('date-value');
			$('#community_update option').each(function(){
				if($(this).val()==date_value){
					$(this).show();				
				}
			});
			var str=","+date_value;
			var siteVlues=$('#commityIds_update').val();
			siteVlues=siteVlues.replace(str, '');
			$('#commityIds_update').val(siteVlues);
			$(this).remove();
			
		});
	  $(".add_traindiv1_update").on("click",".div_module_update",function(){
	    var date_value=$(this).attr('date-value');
			$('#site_update option').each(function(){
				if($(this).val()==date_value){
					$(this).show();				
				}
			});
			var str=","+date_value;
			var siteVlues=$('#siteIds_update').val();
			siteVlues=siteVlues.replace(str, '');
			$('#siteIds_update').val(siteVlues);
			$(this).remove();
	  });
	  
	  $(".add_traindiv2").on("click",".div_module1",function(){
			var date_value=$(this).attr('date-value');
			$('#community option').each(function(){
				if($(this).val()==date_value){
					$(this).show();				
				}
			});
			var str=","+date_value;
			var siteVlues=$('#commityIds').val();
			siteVlues=siteVlues.replace(str, '');
			$('#commityIds').val(siteVlues);
			$(this).remove();
			
		});
	});
	$(function(){
			$(".timedate").calendar({ format:'yyyy-MM-dd HH:mm' ,minDate:'2014-11-18 00:00:00',maxDate:'2099-11-18 11:59:59'
	     }
	     );
	});
	$(function(){
		$("#select_all").click(function(){ 
				if(this.checked){ 
					$(".pitch_up").each(function(){this.checked=true;}); 
				}else{ 
					$(".pitch_up").each(function(){this.checked=false;}); 
				} 
	   });
	   $('.details').click(function(){
	   		var id=$(this).parent().parent().attr("id");
	   		location.href="/professional/volunteer/details?id="+id;
		});
		
		$('.delete').click(function(){
			var id=$(this).parent().parent().attr("id");
			
		layer.confirm('是否确定删除该条培训信息?', function(index){
            location.href="/professional/volunteer/delete_train?id="+id;
        }, function(index){
            //console.log(index);
        });
			
			
			
		});
	});
	
	$('.Sign_in').click(function(){
		var id=$(this).parent().attr("id");
		location.href="/professional/volunteer/train_add_volunteer?id="+id;
	}); 
	 $(".add_first").click(function(){
    	$(".plan_").toggle();
    });
    $(function(){
    	$(".plan_").hide();
    });
    //添加培训记录时社区和站点处理
    $(function(){
    	//添加
    	$('#site').change(function(){
			var value=$(this).children('option:selected').val();
			var siteVlues=$('#siteIds').val();
			siteVlues+=",";siteVlues+=value;
			$('#siteIds').val(siteVlues)
			var name=$(this).children('option:selected').text();
			$(this).children('option:selected').hide();
			if("-----请选择-----"!=name){
				$('.add_traindiv1').append('<div class="div_module" date-value='+value+'>'+name+'</div>');
			}
		});
    	$('#community').change(function(){
			var value=$(this).children('option:selected').val();
			var siteVlues=$('#commityIds').val();
			siteVlues+=",";siteVlues+=value;
			$('#commityIds').val(siteVlues)
			var name=$(this).children('option:selected').text();
			$(this).children('option:selected').hide();
			if("-----请选择-----"!=name){
				$('.add_traindiv2').append('<div cursor="hand " class="div_module1" date-value='+value+'>'+name+'</div>');
			}
		});
		
		//修改
    	$('#site_update').change(function(){
			
			var value=$(this).children('option:selected').val();
			var siteVlues=$('#siteIds_update').val();
			siteVlues+=",";siteVlues+=value;
			$('#siteIds_update').val(siteVlues)
			var name=$(this).children('option:selected').text();
			$(this).children('option:selected').hide();
			if("-----请选择-----"!=name){
				$('.add_traindiv1_update').append('<div class="div_module_update _updateMVenderSite" date-value='+value+'>'+name+'</div>');
			}
			
		});
    	$('#community_update').change(function(){
			var value=$(this).children('option:selected').val();
			var siteVlues=$('#commityIds_update').val();
			siteVlues+=",";siteVlues+=value;
			$('#commityIds_update').val(siteVlues)
			var name=$(this).children('option:selected').text();
			$(this).children('option:selected').hide();
			if("-----请选择-----"!=name){
				$('.add_traindiv2_update').append('<div cursor="hand " class="div_module1_update _updateOCountry" date-value='+value+'>'+name+'</div>');
			}
		});
	
		
		$('._quxiao').click(function(){
		  location.href="/professional/volunteer/see_train";
		});
    
    	  $('#site').change(function(){
	    	 var id=$(this).children('option:selected').val();
	    	 $('#community').html("<option id='_moren'  value=0>-----请选择-----</option>");
	    	 if(id!=0){
		    	  $.ajax({
		                url: "/professional/site/communtiy?id="+id,
		                type: "get",
		                success: function (json) {
		                  	var mjson = eval("(" + json + ")");
		                  	var length=mjson.oCountry.length;
		                  	for(var i=0;i<length;i++){
		                  		
		                  		var option=$("<option  class='oCountry_communityIds'  value="+mjson.oCountry[i].id+">"+mjson.oCountry[i].name+"</option>");
		                  		$('#community').append(option);
		                  	}
		                }
		         });
	    	 }
    
    	})
    	  $('#site_update').change(function(){
	    	 var id=$(this).children('option:selected').val();
	    	 $('#community_update').html("<option id='_moren'  value=0>-----请选择-----</option>");
	    	 if(id!=0){
		    	  $.ajax({
		                url: "/professional/site/communtiy?id="+id,
		                type: "get",
		                success: function (json) {
		                  	var mjson = eval("(" + json + ")");
		                  	var length=mjson.oCountry.length;
		                  	for(var i=0;i<length;i++){
		                  		var option=$("<option  class='oCountry_communityIds'  value="+mjson.oCountry[i].id+">"+mjson.oCountry[i].name+"</option>");
		                  		$('#community_update').append(option);
		                  	}
		                }
		         });
	    	 }
    
    	})
    
    });
     $('#inceonttwo').change(function(){
    	 var id=$(this).children('option:selected').val();
    	 $('#inceont').html("<option id='_moren'  value=0>-----请选择-----</option>");
    	 if(id!=0){
	    	  $.ajax({
	                url: "/professional/site/communtiy?id="+id,
	                type: "get",
	                success: function (json) {
	                  	var mjson = eval("(" + json + ")");
	                  	var length=mjson.oCountry.length;
	                  	for(var i=0;i<length;i++){
	                  		var option=$("<option  class='oCountry_communityIds'   value="+mjson.oCountry[i].id+">"+mjson.oCountry[i].name+"</option>");
	                  		$('#inceont').append(option);
	                  	}
	                }
	         });
    	 }
    
    })
  $(function(){
  		var id=$("#inceonttwo").children('option:selected').val();
  		if(id!=0){
	    	  $.ajax({
	                url: "/professional/site/communtiy?id="+id,
	                type: "get",
	                success: function (json) {
	                  	var mjson = eval("(" + json + ")");
	                  	var length=mjson.oCountry.length;
	                  	var communityId=$communityId;
	                  	for(var i=0;i<length;i++){
	                  		if(communityId==mjson.oCountry[i].id){
	                  			var option=$("<option  class='oCountry_communityIds'  selected='selected' value="+mjson.oCountry[i].id+">"+mjson.oCountry[i].name+"</option>");
	                  		}else{
	                  			var option=$("<option  class='oCountry_communityIds' value="+mjson.oCountry[i].id+">"+mjson.oCountry[i].name+"</option>");
	                  		}
	                  		$('#inceont').append(option);
	                  	}
	                }
	         });
    	 }
  	
  	
  	})
	$('.redact').click(function(){
		$('._add_traindiv2_update').html("");
		$('._add_traindiv1_update').html("");
		var name=$(this).attr("date-contact");
		var del=$(this).attr("date-del");
		var id=$(this).attr("date-id");
		var start=$(this).attr("date-start");
		var end=$(this).attr("date-end");
		$("#_theme_update").val(name);
		$("#_start_update").val(start);
		$("#_end_update").val(end);
		$("#_id_update").val(id);
		$("#_trainPlace_update").val(del);
		$.ajax({
			url: "/professional/volunteer/volunteerTraining_update?id="+id,
	                type: "get",
	                success: function (json) {
                  	var mjson = eval("(" + json + ")");
                  	var length=mjson.oCountry.length;
                  	var sitelength=mjson.mVenderSite.length;
                  	for(var i=0;i<length;i++){
                  		var div=$("<div  class='div_module1_update _updateOCountry'  date-value="+mjson.oCountry[i].id+">"+mjson.oCountry[i].name+"</div>");
                  		$('._add_traindiv2_update').append(div);
                  	}
                  	for(var i=0;i<sitelength;i++){
                  		var div=$("<div  class='div_module_update _updateMVenderSite'  date-value="+mjson.mVenderSite[i].id+">"+mjson.mVenderSite[i].siteName+"</div>");
                  		$('._add_traindiv1_update').append(div);
                  	}
                }
		});
		
	});
	
	$('#_vo_submit').click(function(){
		var commountyIds=",";
		var sites=",";
		$('._updateOCountry').each(function(){
			var value=$(this).attr("date-value");
			commountyIds+=value;
			commountyIds+=",";
		});
		$('._updateMVenderSite').each(function(){
			var value=$(this).attr("date-value");
			sites+=value;
			sites+=",";
		});
		sites=sites.substring(0,sites.length-1) ;
		commountyIds=commountyIds.substring(0,commountyIds.length-1) ;
		$('#commityIds_update').val(commountyIds);
		$('#siteIds_update').val(sites);
	 	$('#formUpdate').submit();
	});
	$('#vo_submit').on("click",function(){
		var start=$('#start').val();
		var theme=$('#theme').val();
		var trainplace=$('#trainplace').val();
		var site=$('#site').val();
		var community=$('#community').val();
		console.log(community);
		if(start==""|| end==""){
			alert("请填写培训时间段");
			return false;
		}else if(theme==""|| trainplace==""){
			alert("请填写培训主题及地址");
			return false;
		}else{
			if(community==0){
			alert("社区错误");
			return false;
			}
		}
	});
</script>
</html>