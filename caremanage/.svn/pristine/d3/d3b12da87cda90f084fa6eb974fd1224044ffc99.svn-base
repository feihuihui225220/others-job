<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>专业服务-客户管理</title>
<link rel="stylesheet" type="text/css" href="/assets/newJs/jquery-easyui-1.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/assets/newJs/jquery-easyui-1.5/themes/icon.css">
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/assets/css/bootstrap-select.css"/>
<link rel="stylesheet" type="text/css" href="/assets/newJs/jquery-easyui-1.5/demo/demo.css">
<link href="/assets/newCss/filter.css" rel="stylesheet" type="text/css">
<link href="/assets/newCss/filter.css" rel="stylesheet" type="text/css">
<link href="/assets/newCss/common.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
	#select{width:120px;}
	#conclusion{width:120px;}
	label{width:120px;}
	.bootstrap-select{width:120px !important;}
	.pagespan{float:right !important;}
</style>

</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
	  <div class="main">
        #parse("/common/providers.tpl")
        <div class="content fl" style="width:auto;">
        	<div class="wrap" >
				  			<form action="/professional/scaleScreen/demand" method="post" class="demand" name="searchForm">
        			<div class="time">
			  			<span class="ft">选择时间:</span>
			  			<input class="timedate" style="line-height:31px;border-radius: 4px;" id="start" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)">
			  			<span>—</span>
		  				<input class="timedate" style="line-height:31px;border-radius: 4px;" id="ed" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)">
			  		</div>
				  	<div class="basicFilter">
				  			<input class="array" name="array" type="hidden" value="$!array">
				  			<input class="array1" name="array1" type="hidden" value="$!array1">
				  			<span class="ft">基本筛选:</span>
				  			<select id="communityName" name="community"  class="selectpicker " multiple data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
								#foreach($c in $oCountry)
								<option value="$c.id">$!c.name  </option>
								#end
							</select>  
				  			<input class="select_com" type="hidden" value="$!vo.community">
				  			<!--<select>
				  				<option>报告筛选</option>
				  				<option>量表</option>
				  			</select>-->
				  			<input class="input_" name="userName" placeholder="按姓名搜索" class="searchName" style="height: 32px;line-height: 32px;border-radius: 4px;margin-left: 20px;" value="$!UserName">
				  			
				  	</div>
				  	<div class="scaleFilter">
				 			<span class="ft">量表筛选:</span>
				 			<select id="select" name="scaleId" style="height:31px;line-height:31px;border-radius:4px;" class="select160">
		                		<option value="0">---请选择---</option>
		                		#if($listAssessVO)
		                			#foreach($a in $listAssessVO)
		                				<option date-value="$a.name" #if($vo.scaleId==$a.id) selected #end value="$a.id">$a.name</option>
		                			#end
		                		#end
		                	</select>
				 			<input id="conclusion_input" type="hidden" value="$vo.conclusion"/>
		                	<select id="conclusion"  style="height:31px;line-height:31px;border-radius:4px;" name="conclusion" class="select160">
		                		<option value="0">---请选择---</option>
		                	</select> 
				 			
				  		<input type="button" class="btn-default  btn confimSearch" value="确认搜索"/>
				  	</div>
					  <!--	<div class="reportFilter">
					  		<span class="ft">报告筛选:</span>
					  		<select>
					  			<option>心脑血管慢病管理报告</option>
					  		</select>
					  	</div>-->
  				</form>
  					<hr>
  	
			  	<div>
			  		
				  		<input type="button" class="btn-default  btn  currentList export" value="导出当前列表内容"/>(未选择用户，导出所有)
				  		<input type="button" class="btn-default  btn  customBtn" style="margin-left:auto;float:right;" value="自定义显示列"/>
			  		
			  		<table id="filterTable" border="0">
			  			<tr class="th_">
			  				<th>序号</th>
			  				<th>姓名</th>
			  				<th>身份证号</th>
			  				<th>性别</th>
			  				<th>年龄</th>
			  				<th>所在站点</th>
			  				<th>所在社区</th>
			  			</tr>
			  		</table>
			  		 #parse("/common/page.tpl")
			  	</div>
	 </div> 
 <div class="black_overlay" style="position: fixed;"></div>
  <div class="custom_Show"  style="position: fixed;top:5%;">
  	<div class="title">
  		<span class="custom_cols">自定义显示列</span>
  		<span class="right_close fr" style="cursor:pointer">X</span>
  	</div>
  	<hr>
  	<h3>拖动区块调整显示顺序:</h3>
  	
  	<div style="margin:20px 0;"></div>
	  	  <ul style="margin:0;padding:0;margin-left:10px;" class="dragShow">
					<li class="drag-item" data-id="0">姓名</li>
					<li class="drag-item" data-id="1">身份证号</li>
					<li class="drag-item" data-id="2">性别</li>
					<li class="drag-item" data-id="3">年龄</li>
					<li class="drag-item" data-id="4">所在站点</li>
					<li class="drag-item" data-id="5">所在社区</li>
			</ul>
  	
  	<h3 class="clear">选择显示列:</h3>
  	<div class="showContent">
  		<input type="checkbox" name="content" id="name" data-id="0" checked="checked" disabled="disabled" style="display:none;"><label for="name" style="display:none;">姓名</label>
  		<input type="checkbox" name="content" id="userID" data-id="1" checked="checked"><label for="userID">身份证号</label>
  		<input type="checkbox" name="content" id="sex" data-id="2" checked="checked" disabled="disabled" style="display:none;"><label for="sex" style="display:none;">性别</label>
  		<input type="checkbox" name="content" id="age" data-id="3" checked="checked" disabled="disabled" style="display:none;"><label for="age" style="display:none;">年龄</label>
  		<input type="checkbox" name="content" id="station" data-id="4" checked="checked"><label for="station">所在站点</label>
  		<input type="checkbox" name="content" id="community" data-id="5" checked="checked" disabled="disabled" style="display:none;"><label for="community" style="display:none;">所在社区</label>
      <input type="checkbox" name="scale" id="s_name" data-id="6"><label for="s_name">量表名称</label>
      <input type="checkbox" name="scale" id="s_date" data-id="7"><label for="s_date">评估日期</label>
	
  		<h3>量表显示系列(导出展示)</h3>
  		
      	<input type="checkbox" class="checkbox1" name="checkbox1"  data-id="8"><label for="conclusion">主要结论</label>
  		<input type="checkbox" class="checkbox1" name="checkbox1"  data-id="9"><label for="detail">评估详情</label>
  		<input type="checkbox" class="checkbox1" name="checkbox1"  data-id="10"><label for="score">得分</label>

  	</div>
  	<div class="bottom_btn">
  		<input  type="button" class="btn-default  btn  confirm input_button" value="确认">
  		<input  type="button" class="btn-default  btn cancel input_button" value="取消">
  		<input  type="button" class="btn-default  btn reset input_button" value="重置">
  	</div>

  	</div>
        </div>
    </div>

</div>	  
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/assets/newJs/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="/assets/newJs/filter.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script>
	$(window).on('load', function() {
		var str = $('.select_com').val();
		var arr = str.split(',');
		if(str==""){
			arr=[0];
		}
		$('.selectpicker').selectpicker('val', arr);
	})
	$(function(){
	 	$(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '120px', height: '31px'});
	})
	$(document).keyup(function(e){
        var key =  e.which;
        if(key == 27){
			$('.custom_Show').hide();
			$('.black_overlay').hide();
        }
    });
								
	$(function(){
	
	 	var arr=$('.array').val();
	 	var arr1=$('.array1').val();
	 	if(arr==""){arr="0,1,2,3,4,5";}
	 	if(arr1==""){arr1="0,1,2,3,4,5";$('.array1').val(arr1); }
	 	var array=arr.split(',');
	 	var array1=arr1.split(',');
	 	see(array);
		$('.bottom_btn .confirm').click(function() {
        $('#filterTable tr:eq(1) td:eq(0)').empty();
        $('.custom_Show').hide();
        $('.black_overlay').hide();
        var tableLength = $('#filterTable tr th').length;
        var liLength = $('.dragShow li').length;
        $('#filterTable tr th:not(:first)').empty();

        if (tableLength > liLength) {
            for (var i = 0; i < tableLength - liLength - 1; i++) {
                $("#filterTable tr :last-child").remove();
            }
        } else {
            for (var i = 0; i < liLength - tableLength + 1; i++) {
                var th1 = $("<th></th>");
                $("#filterTable tr").append(th1);
            }

        }
        $('<input type="checkbox" name="num"/><label>1</label>').appendTo($("#filterTable tr td:eq(0)"));
        array.splice(0,array.length);
        array1.splice(0,array1.length);
        $('.dragShow li').each(function() {
            var index = $(this).index();
            $('#filterTable tr').eq(0).find('th').eq(index + 1).text($(this).text()).attr('data-id', $(this).attr('data-id'));
			var dateId=$(this).attr('data-id');
			array.push(dateId); 
			array1.push(dateId); 
        })
   		$(".checkbox1").each(function(){
			if($(this).prop('checked')){
				array1.push($(this).attr('data-id')); 
			}
		}) 
		$('.array1').val(array1);
			see(array);
    })
	 
	
	});
	
	function see(array){
		$('.th_').remove();
		$('.see_').remove();
		var m=1;
		var stite = array;
		$('.array').val(stite);
		var _th=$('<tr class="see_"><th></label></th></tr>');
		for(var x=0;x<stite.length;x++){
			var i=stite[x];
			if(i==0){
				var _th1=$('<th>姓名</th>');
				_th.append(_th1);
				}else if(i==1){
				var _th1=$('<th>身份证号</th>');
				_th.append(_th1);
				}else if(i==2){
				var _th1=$('<th>性别</th>');
				_th.append(_th1);
				}else if(i==3){
				var _th1=$('<th>年龄</th>');
				_th.append(_th1);
				}else if(i==4){
				var _th1=$('<th>站点名称</th>');
				_th.append(_th1);
				}else if(i==5){
				var _th1=$('<th>社区名称</th>');
				_th.append(_th1);
				}else if(i==6){
				var _th1=$('<th>量表明称</th>');
				_th.append(_th1);
				}else if(i==7){
				var _th1=$('<th>添加日期</th>');
				_th.append(_th1);
				}else{
				var _th1=$('<th> </th>');
				_th.append(_th1);
				}
			}
			$('#filterTable').append(_th);
			
		
		
		#foreach($n in $page.result)
			 
		 	#set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
			var tr=$('<tr class="see_"><td><label>$i<input type="checkbox" class="userId" date-recordId="$n.recordId" date-id="$n.id"></label></td></tr>');
			m++;
			for(var x=0;x<stite.length;x++){
			//"$!n"
				var i=stite[x];
				if(i==0){
				var td=$('<td >$n.name</td>');
				tr.append(td);
				}else if(i==1){
				var td=$('<td>$n.idCardNo</td>');
				tr.append(td);
				}else if(i==2){
				var td=$('<td> #if($n.gender==0)女#else男#end </td>');
				tr.append(td);
				}else if(i==3){
				var td=$('<td>$!n.age</td>');
				tr.append(td);
				}else if(i==4){
				var td=$('<td>$!n.siteName</td>');
				tr.append(td);
				}else if(i==5){
				var td=$('<td>$!n.communityName</td>');
				tr.append(td);
				}else if(i==6){
				var td=$('<td>$!n.assessName</td>');
				tr.append(td);
				}else if(i==7){
				var td=$('<td>$!n.creatAt</td>');
				tr.append(td);
				}else if(i==8){
				var td=$('<td>$!n.assessConclusion</td>');
				tr.append(td);
				}else{
				var td=$('<td>暂无参数</td>');
				tr.append(td);
				}
			}
			
			$('#filterTable').append(tr);
		#end
	
	
	
	
	}
	
	$('#select').change(function(){
		var scale = $(this).val();
		add(scale);
		
	});
	
	function  add(scale){
		$('.option2').remove();
		$.ajax({
			type:'post',
            url:"/professional/scaleScreen/scaleVerdict?scale="+scale,
            dataType:'json',
            success:function(json){
            	for(var i=0;i<json.conclusion.length;i++){
            		var option=$('<option class="option2" value="'+json.conclusion[i].id+'">'+json.conclusion[i].content+'</option>');
            		$('#conclusion').append(option);
            	}
            }
		});
	}
	$(function(){
		if($('#conclusion_input').val()!=null&&$('#conclusion_input').val()!=""){
			var scale =$('#select').val();
			$.ajax({
			type:'post',
            url:"/professional/scaleScreen/scaleVerdict?scale="+scale,
            dataType:'json',
            success:function(json){
            	for(var i=0;i<json.conclusion.length;i++){
            		var option=$('<option class="option2" date-value="'+json.conclusion[i].content+'" value="'+json.conclusion[i].id+'">'+json.conclusion[i].content+'</option>');
            		$('#conclusion').append(option);
            	}
            	$('.option2').each(function(){
					if($(this).val()==$('#conclusion_input').val()){
						$(this).attr('selected',true);
					}
				})
            }
		});
		
		}
	
	});
	$(function(){
		$('.export').click(function(){
			if($(".see_").length==1){
				alert("当前列表无导出内容");
				return false;
			}
			var scaleId=$('#select').val();
			var start=$('#start').val();
			var end=$('#ed').val();
			var assessName=$('#select').find('option[selected]').attr("date-value");
			var assessConclusion=$('#conclusion').find('option[selected]').attr("date-value");
			var conclusion=$('#conclusion').val();
			var community=$('#communityName').val();
			
			var array1=$('.array1').val();
			var siteId=$('#siteId').val();
			var userIds=[];
			var recordIds="";
			$('.userId').each(function(){
				if($(this).prop('checked')){
				    userIds.push($(this).attr('date-id')); 
				    recordIds+=$(this).attr('date-recordId'); 
				    recordIds+=","; 
				}
			})
			if(siteId="undefined"){
				siteId=0;
			}
			recordIds=recordIds.substring(0, recordIds.lastIndexOf(','));
			location.href="/professional/scaleScreen/export?scaleId="+scaleId+"&conclusion="+conclusion+"&community="+community+"&siteId="+siteId+"&assessConclusion="+assessConclusion+"&assessName="+assessName+"&start="+start+"&end="+end+"&array1="+array1+"&userIds="+userIds+"&recordIdsUser="+recordIds;
			//alert("/professional/scaleScreen/export?scaleId="+scaleId+"&conclusion="+conclusion+"&community="+community+"&siteId="+siteId+"&assessConclusion="+assessConclusion+"&assessName="+assessName+"&start="+start+"&end="+end);
		});
		
		$('.confimSearch').click(function(){
			$('.demand').submit();
		});
	})
</script>
</body>
</html>