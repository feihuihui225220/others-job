<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>评估量表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<style>
.input165{width: 165px; height: 30px;}
</style>
<script>
	function publish(assessId, pageNo, pageSize, status) {
		if(status){
			window.open("/professional/assess/abolish?page=" + pageNo + "&num=" + pageSize + "&assessId=" + assessId, "_self");
		}else{
			window.open("/professional/assess/publish?page=" + pageNo + "&num=" + pageSize + "&assessId=" + assessId, "_self");
		}
	}
	function srecommend(assessId, pageNo, pageSize, status) {
			window.open("/professional/assess/srecommend?page=" + pageNo + "&num=" + pageSize + "&assessId=" + assessId+"&recommend="+status, "_self");
	}
	
</script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
            <form action="/professional/assess" method="post" name="searchForm">
            	<select class="input165 tiaozhuan"> 
            		<option  value="1">评估量表管理</option>
            		<option  value="2">套餐管理</option>
            		<option  value="3">体适能管理</option>
            	</select>
            	<label>量表名称:</label><input class="input165" name="name" value="$!name">
            	<label>量表类型:</label>
            	<select class="input165 " name="itemId">
            		<option value="-1">--请选择--</option>
            		#foreach($n in $cit)
            			<option value="$n.id" #if($itemId==$n.id) selected=selected #end>$n.itemName</option>
            		#end
            	<select>
            	<label>添加时间:</label><input class="timedate" name="start" value=$!date.format('yyyy-MM-dd',$daVo.start)>-<input class="timedate" name="end" value=$!date.format('yyyy-MM-dd',$daVo.end)>
            	<label><button class="btn button_gm"> 查询</button></label>
            	
                <input class="btn button_gm" onclick="javascripts:location.href='/professional/assess/add?page=${page.pageNo}&num=${page.pageSize}'" value="添 加" type="button">
            </form>
             </div>
            #if ($page)
               <table class="tb table_col1 tab_115">
                  <col class="col1"/><col class="col1"/><col class="col3"/><col class="col4"/>
                  <tr>
                      <th>名称</th>
                      <th>简介</th>
                      <th>类型</th>
                      <th style="width:10%">分类</th>
                      <th>操作</th>
                  </tr>
                  #foreach ($assess in $page.result)
                  <tr>
                    <td>${assess.name}</td>
                    <td class="hiddentext">${assess.descr}</td>
                    <td>$!{assess.ItemName}</td>
                    <td style="width:10%">#if($assess.type == 0) 分数题  #elseif($assess.type == 1) 组合题 #else 开站评估 #end</td>
                    <td>
                      <button class="tb_edit button_gm" onclick="javascripts:location.href='/professional/assess/modify?page=${page.pageNo}&num=${page.pageSize}&assessId=${assess.id}'">编 辑</button>
                      <button class="tb_btn button_gm" onclick="javascripts:location.href='/professional/assess/qa?assessId=${assess.id}&type=${assess.type}'">试 题</button>
                      <button class="tb_btn button_gm" onclick="javascripts:location.href='/professional/assess/clu?assessId=${assess.id}&type=${assess.type}'">结 论</button>
                      <button class="tb_remove button_delete" td_url="/professional/assess/delete?page=${page.pageNo}&num=${page.pageSize}&assessId=${assess.id}">删 除</button>
                      #if($assess.publishStatus)	
                      <button class="tb_btn button_fb"  onclick="publish(${assess.id}, ${page.pageNo}, ${page.pageSize}, ${assess.publishStatus})">取 消</button>
                      #else
                      <button class="tb_btn button_gm"  onclick="publish(${assess.id}, ${page.pageNo}, ${page.pageSize}, ${assess.publishStatus})">发 布</button>
                      #end
                      <button class="tb_btn button_gm"  onclick="srecommend(${assess.id}, ${page.pageNo}, ${page.pageSize},#if($!{assess.recommend})1 #else 0 #end)"> #if($!{assess.recommend})已推荐#else未推荐#end</button>
                    </td>
                  </tr>
                  #end
              </table>
              #parse("/common/page.tpl")
           #end
        </div>
    </div>
    <div class="footer"></div>
</div>
<script>
$(function(){
	$(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '165px', height: '30px'});
	$('.tiaozhuan').change(function(){
		if($(this).attr('value')==1){
			location.href="/professional/assess";
		}else if($(this).attr('value')==2){
			location.href="/ICareCombo/combo/list";		
		}else{
			location.href="/ICareFitness/zfitness/insert";		
		}
	});
	
});
</script>
</body>
</html>