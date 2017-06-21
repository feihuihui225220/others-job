<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>专业服务-客户管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css">
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script>

</script>
<style>
	.th_wid{width:80px;}
	.tablebox{width:97%}
	.mux_a{ background:#4AC6CE;}
	.margin_top{margin-top:20px;}
	#select{width:120px;}
	#conclusion{width:120px;}
	#if($sessionUser.cateEnum.type==3)
		#left{background-color: #16A5AD;}
		.nav1{background-color: #16A5AD;}
		.a_Special_4{position: relative;top: -45px;color: #F7FCFC;}
	#end
	
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
       <div id="left">
	        #parse("/common/providers.tpl")
       </div>
   <div class="main">
    <div >
    <div id="right">  
        <div class="searchli margin_top">
        	<form action="/professional/scaleScreen/demand" method="post" name="searchForm">
	            <ul class="inpubox clearfix margin_top left_ul">
	                <li>
	                	<label>量表：</label>
	                	<select id="select" name="scaleId" class="select160">
	                		<option value="0">------请选择------</option>
	                		#if($listAssessVO)
	                			#foreach($a in $listAssessVO)
	                				<option date-value="$a.name" #if($vo.scaleId==$a.id) selected #end value="$a.id">$a.name</option>
	                			#end
	                		#end
	                	</select>
                	</li>
	                <li>
	                	<label>量表结论：</label><input id="conclusion_input" type="hidden" value="$vo.conclusion"/>
	                	<select id="conclusion" name="conclusion" class="select160">
	                		<option value="0">------请选择------</option>
	                	</select> 
                	</li>
					<li><label>社区：</label>
					<select id="communityName" name="community" class="select160">
						<option value="0">------请选择------</option>
						#foreach($c in $oCountry)
						<option value="$c.id"  #if($vo.community==$!c.id) selected #end >$!c.name  </option>
						#end
					</select>  
					 #if($sessionUser.cateEnum.type==4)
					<li><label>站点：</label>
					<select id="siteId" name="siteId" class="select160">
						<option value="0">---请选择---</option>
						#foreach($m in $mVenderSite)
						<option value="$m.id" #if($m.id==$vo.siteId) selected="selected" #end>$!m.siteName</option>
						#end
					</select>  
					#end
					</li>
					<li><label>时间:</label>
					<input id="stat" class="text150 timedate" type="text" name="start"
                                                             value="$!date.format('yyyy-MM-dd',$!dateCond.start)">
       				<label>- </label><input id="ed" class="text150 timedate" type="text" name="end"
                                value="$!date.format('yyyy-MM-dd',$!dateCond.end)">
					</li>
	                <li><input class="ibtn button_gm" type="submit" value="搜索"></li>
	                 <li><input class="ibtn button_gm export" type="button" value="导出"></li>
	            </ul>
            </form>
        </div>
        <div class="tablebox">
            <table class="table100 usertable cen trclick">
                <th>姓名</th><th class="">性别</th><th>年龄</th><th>社区</th><th>站点</th><th>详情</th>
		        		#if($page)
		        			#foreach($n in $page.result)
							<tr>
								<td>$!{n.name}</td>
								<td>#if($!{n.gender}==0)女#else男#end</td>
								<td>$!{n.age}</td>
								<td>${n.communityName}</td>
								<td>$!{n.siteName}</td>
								<td><a href="/professional/vender/user/detail/$n.id">详情>></a></td>
							</tr>
		        			#end
		        		#end
            </table>
            #parse("/common/page.tpl")
        </div>    
    </div>
    
    </div>
    <div class="footer">
    </div>
   </div> 
</div>
<script>
	$(function(){
	 $(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '65px', height: '15px'});
	});
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
			var scaleId=$('#select').val();
			var start=$('#stat').val();
			var end=$('#ed').val();
			var assessName=$('#select').find('option[selected]').attr("date-value");
			var assessConclusion=$('#conclusion').find('option[selected]').attr("date-value");
			var conclusion=$('#conclusion').val();
			var community=$('#communityName').val();
			var siteId=$('#siteId').val();
			if(siteId="undefined"){
				siteId=0;
			}
			location.href="/professional/scaleScreen/export?scaleId="+scaleId+"&conclusion="+conclusion+"&community="+community+"&siteId="+siteId+"&assessConclusion="+assessConclusion+"&assessName="+assessName+"&start="+start+"&end="+end;
			//alert("/professional/scaleScreen/export?scaleId="+scaleId+"&conclusion="+conclusion+"&community="+community+"&siteId="+siteId+"&assessConclusion="+assessConclusion+"&assessName="+assessName+"&start="+start+"&end="+end);
		});
	})
</script>
</body>
</html>