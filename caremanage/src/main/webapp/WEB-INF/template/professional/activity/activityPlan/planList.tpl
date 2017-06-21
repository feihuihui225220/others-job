<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>培训记录添加</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap-select.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
  	<script src="/assets/js/pageNavigator.js"></script>
    <link rel="stylesheet" href="/assets/newCss/plan.css"/>
  	<link rel="stylesheet" href="/assets/newCss/index.css" />
</head>
<style>
	#right{
    		padding-top:20px;
			height: 87%;
			position: absolute;
			right:-25px;
			OVERFLOW-Y: auto; OVERFLOW-X:hidden;
			}
	.right{float:right;margin-left:20px;}
	.buton_{height:100px;}
	.nei{position: relative;top:-25px;}
	.tab1{margin-top:25px;}
	#main{margin-left:10%;width:80%;}
	div#right::-webkit-scrollbar {
        width:0px;
        height:0px;
    }
    div#right::-webkit-scrollbar-button    {
        background-color:#FF7677;
    }
    div#right::-webkit-scrollbar-track     {
        background:#FF66D5;
    }
    div#right::-webkit-scrollbar-track-piece {
       
    }
    div#right::-webkit-scrollbar-thumb{
        background:#FFA711;
        border-radius:0px;
    }
    div#right::-webkit-scrollbar-corner {
        background:#82AFFF;
    }
    div#right::-webkit-scrollbar-resizer  {
        background:#FF0BEE;
    }	
	
</style>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
		#parse("/common/head.tpl")
		#if($!{sessionUser.isSuper_()}==true)
		<div class="main">
	        #parse("/common/providers.tpl")
		<div id="right" > 
		#else
		<div id=main>
		#end
			
		<button class="btn-default add_first btn add_plan">添加活动</button>
		<div class="main_"><input type="hidden" id="sit" value="$siteIds">
		<form  action="/professional/activity/list" id="activity"  method="post" name="searchForm">
			<label>站点筛选：</label>  
			<select class="selectpicker " name="siteIds" multiple data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
              #foreach($s in $site)
              <option value="$s.id">$s.siteName</option>
              #end
            </select>
			<label class="lable_1">日期选择：</label>
			<input name="start" class=" timedate start" type="text" value="$!date.format('yyyy-MM-dd',$!dateCond.start)"/>-<input class=" timedate end" name="end"  type="text" value="$!date.format('yyyy-MM-dd',$!dateCond.end)"/>　　 
			<button class="btn-default add_first btn ">确定</button>
		</form>
		<br>
		<table class="table _tale1">
			<tr class="_active">
				<th class="first_"><input id="cjeck" class="first_ cjeck"  type="checkbox">时间</th>			
				<th>活动主题</th>			
				<th>活动站点</th>			
				<th>活动时间</th>			
				<th>活动地点</th>			
				<th>站点负责人</th>			
				<th>备注</th>			
				<th>方案性质</th>			
			</tr>
			#foreach($result in $page.result)
			 #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
			<tr class=" #if($i%2!=0 ) tr_two #else tr_first #end ibtn addadver userid_$!result.id" data-id="$!e.id">
				<td><input class="cjeck" type="checkbox">$!date.format('yyyy-MM-dd',$result.pubdate)</td>	
				<td>$!result.planName</td>	
				<td>$!result.siteIdName</td>		
				<td>$!result.planTime</td>		
				<td>活动站点</td>	
				<td>站点负责人</td>	
				<td>$!result.remark</td>	
				<td>活动方案<input type="button" class="div_cs  btn-default  btn" value="▲" ></td>					
			</tr>
			<tr class="table_diaplay userid_$!result.id">
				<td  colspan="8">
					<table class="tab1">
						<tr>
							<td>课程类别</td>
							<td>专业老师</td>
							<td>印象标签</td>
							<td>活动时长</td>
						</tr>
						#foreach($npr in $result.programOfVO)
						<tr>
							<td>$!npr.progranName</td>
							<td>$!npr.teacher</td>
							<td>$!npr.keyword</td>
							<td>$!npr.duration</th>
						</tr>
						#end
						
					</table>
					<div class="nei">
						<input class="btn-default add_first btn right update_plan" type="button" date-id=$!result.id  value="点击编辑">
						<input class="btn-default add_first btn right deluser" type="button" date-id=$!result.id value="删除">
					</div>
				</td>
			</tr>
			#end
		</table>
			#parse("/common/page.tpl")
		<div class="buton_"></div>
		</div>
        </div> 
	</div>	
</div>	
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/bootstrap-select.js"></script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/newJs/plan.js"></script>
<script>
$(function(){
    $(".timedate").calendar({
        format : 'yyyy-MM-dd'
    }).css({
        width : '90px',
        height : '28px'
    });
    
    var str = $('#sit').val();
    if (str != undefined) {
        var arr = str.split(',');
        $('.selectpicker').selectpicker('val', arr);
    }
    
});
    
</script>
</html>