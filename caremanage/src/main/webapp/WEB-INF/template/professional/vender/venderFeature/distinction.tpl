<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>专业服务-客户管理</title>
#parse("/common/top.tpl")
 <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css">
<script type="text/javascript" src="/assets/js/top.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="/assets/newCss/index.css" />


<script>
	 $(function(){
	
		var exhibition=$feat.exhibition;
		var theme=$feat.theme;
		if(theme==1){$('.a_Special_1').addClass("here"); $('.shenghuo').show();}if(theme==2){$('.a_Special_2').addClass("here");$('.nengli').show();}if(theme==3){$('.a_Special_3').addClass("here");$('.xuanze').show();}
		$("."+exhibition+"").addClass("mux_a")
		//alert(theme);
	});
	
</script>
<style>
	
	.tablebox{width:97%}
	#right{width:85%;float:right; padding-right:5%}
	#left{background:#6AD6D8; width:10%;height:765px;position:absolute;left:0px;top:0px;Z-index:-20}
	.show:{text-decoration:underline;border:important;}  
	#container{height:300px;width:80%;margin-left:10%}
	.mux_a{ background:#4AC6CE;}
	.image{margin-top:20px;margin-bottom:20px;}
	a{color:black;}
	
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
       <div class="main">
       #parse("/common/providers.tpl")
    <div id="right">  
		    		<div class="image">
						<ul class="  nav nav-tabs shenghuo"  style=display:none role="tablist" id="myTab">
					 	<!-- 将特征信息传入 -->
					      <li  class="mux "><a href="/professional/feature?theme=1&classify=111&exhibition='three'" class="three">三无</a></li>
					      <li><a href="/professional/feature?theme=1&classify=115&exhibition='less_income'" class="less_income">低保</a></li>
					      <li><a href="/professional/feature?theme=1&classify=113&exhibition='no_security'" class="no_security">无保障</a></li>
					      <li class=""><a href="/professional/feature?theme=1&classify=118&exhibition='special_care'" class="special_care">优抚</a></li>
					    </ul>
						<ul class=" nav nav-tabs nengli" style=display:none role="tablist" id="myTab">
					      <li><a href="/professional/feature?theme=2&classify=114&exhibition='lonely'" class="lonely">孤寡</a></li>
					      <li><a href="/professional/feature?theme=2&classify=116&exhibition='empty_nest'" class="empty_nest">空巢</a></li>
					      <li><a href="/professional/feature?theme=2&classify=119&exhibition='life_lonely '" class="life_lonely " >独居</a></li>
					    </ul>
						<ul class=" nav nav-tabs xuanze"  style=display:none role="tablist" id="myTab">
					      <li class="mux "><a href="/professional/feature?theme=3&classify=112&exhibition='disable'" class="disable">失能</a></li>
					      <li><a href="/professional/feature?theme=3&classify=117&exhibition='lost_only'" class="lost_only">失独</a></li>
					      <li><a href="/professional/feature?theme=3&classify=001&exhibition='independent'" class="independent">自理</a></li>
					    </ul>
					 </div>   
		    		<div  id="container">
					</div>
        <div class="searchli">
        
        	<form id="from_action" action="$url" method="post" name="searchForm">
	            <ul class="inpubox clearfix">
	                <li><label>姓名：</label><input name="userName" value="$!{MUserVender.userName}" class="text150" type="text" /></li>
	                <li><label>身份证号：</label><input name="userIdCard" value="$!{MUserVender.userIdCard}" class="text150" type="text" /></li>
					<!--<li><label>社区：</label>
					<select id="communityName" name="communityName" class="select160">
						<option value="">--------请选择--------</option>
						#foreach($c in $oCountry)
						<option value="$c.name">$!c.name</option>
						#end
					</select> -->
					<li><label>站点：</label>
					<select id="siteId" name="siteId" class="select160">
						<option value="0">--------请选择--------</option>
						#foreach($m in $mVenderSite)
						<option value="$m.id" #if($siteId==$m.id) selected="selected" #end>$!m.siteName</option>
						#end
					</select>
					</li>
	                <li><input class="ibtn button_gm" type="submit" value="搜索"></li>
	               </form>
	                <li><input class="ibtn button_gm export" type="button" value="导出"></li>
                   
	            </ul>
            
        </div>
        <div class="tablebox">
            <table class="table100 usertable cen trclick">
                <tr><th class="th_wid">姓名</th><th>身份证号</th><th class="th_wid">性别</th><th>所属站点</th><th class="th_wid">详情</th></tr>
               	#if ($page)
		                #foreach ($u in $page.result)
			        		<tr class="ibtn addadver">
		        			<td>$!{u.userName}</td>
		        			<td>$!{u.userIdCard}</td>
		        			<td>#if($!{u.userSex}==0)女#else男#end</td>
			                <td>$!{u.siteName}</td>
			                <td><a href="/professional/vender/user/detail/$u.userId">详情>></a></td>
		        		</tr>
		        		#end
        		#end
            </table>
            #parse("/common/page.tpl")
    </div>
    
    </div>
    <div class="footer">
    	<input type="hidden" id="com" value="$!communityName"/>
    	<input type="hidden" id="all" value="$!allocation"/>
    </div>
   </div> 
</div>
<script>
	$(function(){
		var m=$('#com').val();
		var a=$('#all').val();
		$('#communityName option').each(function () {
		    var $option = $(this);
		    var html = $option.html();
		    var value = $option.val();
		    if(value==m){
		    	$(this).attr('selected','selected');
		    }
		});
		$('#allocation option').each(function () {
		    var $option = $(this);
		    var html = $option.html();
		    var value = $option.val();
		    if(value==a){
		    	$(this).attr('selected','selected');
		    }
		});
	});
	
</script>
<script src="/assets/js/highcharts.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script>
	$(function () {
    	$('#container').highcharts({
		        chart: {
		            type: 'column',
		             backgroundColor: 'rgba(0,0,0,0)'
		           
		        },
		        title: {
		            text: '老年人特征对比图'
		        },
		       
		        xAxis: {
		            categories: [
		            	#set($m=1)
		            	  #foreach($member in $hash.keySet())
	            	  		  '$member'
			            	  #if($m!=$hash.size())
			            	  	,
			            	  #end
		            	  #set($m=$m+1)	
		            	  #end
		                
		            ]
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: '人(位)'
		            }
		        },
		        plotOptions: {
		           series: {
		               pointWidth:25 //柱子之间的距离值
		           }
		       },
		        series: [{
		            name: '人数',
		            data: [
		            	  #set($a=1)
		            	  #foreach($member in $hash.entrySet())
	            	  		   $member.value
			            	  #if($a!=$hash.size())
			            	  	,
			            	  #end
		            	  #set($a=$a+1)	
		            	  #end
							
							]
		
		        }]
		    });
	});
	
	$(function(){
		$('.export').click(function(){
			var a=$('#from_action').attr("action");
			var array = a.split("?");
			var uri=array[1];
			location.href="/professional/feature/export?"+uri;
			alert("/professional/feature/export?"+uri);
		});
	});  				
</script>
</body>
</html>