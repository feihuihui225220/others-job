<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>人口统计</title>
#parse("/common/top.tpl")
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
	#parse("/common/head.tpl")
    <div class="body bodyline pad10">
    		#parse("/community/user/tab.tpl")
        <div class="usertitle strong">统计项</div>
        <form action="/community/user/count" method="post" name="searchForm">
	        <ul class="inpubox clearfix">
	            <li>
	            	&nbsp;&nbsp;&nbsp;&nbsp;<label>所属社区：</label><select class="select160" name="communityId">
	            		<option value="">全部社区</option>
	            		#foreach($item in $communitys)
	            		<option value="$!item.id" #if($!{param.communityId}==$!item.id)selected=true#end>$!item.name</option>
	            		#end
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[0].isCount" #if($param.items[0].isCount) checked#end><input type="hidden" name="items[0].title" value="户口类型">
	            	<label>户口类型：</label>#set($items=$!categorys.get(101))<select class="select160" name="items[0].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[0].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select></li>
	            <li><input type="checkbox" name="items[1].isCount" #if($param.items[1].isCount) checked#end><input type="hidden" name="items[1].title" value="年龄">
	            	<label>年龄：</label><input name="items[1].value" value="$!{param.items[1].value}" class="text50" type="text" /> 至 <input name="items[1].value2" value="$!{param.items[0].value2}" class="text50" type="text" /> 岁
	            </li>
	            <li><input type="checkbox" name="items[2].isCount" #if($param.items[2].isCount) checked#end><input type="hidden" name="items[2].title" value="居住情况">
	            	<label>居住情况：</label>#set($items=$!categorys.get(105))<select class="select160" name="items[2].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[2].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[3].isCount" #if($param.items[3].isCount) checked#end><input type="hidden" name="items[3].title" value="从业情况">
	            	<label>从业情况：</label>#set($items=$!categorys.get(106))<select class="select160" name="items[3].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[3].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[4].isCount" #if($param.items[4].isCount) checked#end><input type="hidden" name="items[4].title" value="经济来源">
	            	<label>经济来源：</label>#set($items=$!categorys.get(110))<select class="select160" name="items[4].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[4].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[5].isCount" #if($param.items[5].isCount) checked#end><input type="hidden" name="items[5].title" value="性别">
	            	<label>性别：</label><select class="select160" name="items[5].value" id="">
	            			<option value="1" #if($!{param.items[5].value}=="1")selected=true#end>男</option>
	            			<option value="0" #if($!{param.items[5].value}=="0")selected=true#end>女</option>
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[6].isCount" #if($param.items[6].isCount) checked#end><input type="hidden" name="items[6].title" value="政治面貌">
	            	<label>政治面貌：</label>#set($items=$!categorys.get(103))<select class="select160" name="items[6].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[6].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[7].isCount" #if($param.items[7].isCount) checked#end><input type="hidden" name="items[7].title" value="文化程度">
	            	<label>文化程度：</label>#set($items=$!categorys.get(104))<select class="select160" name="items[7].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[7].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[8].isCount" #if($param.items[8].isCount) checked#end><input type="hidden" name="items[8].title" value="民族">
	            	<label>民族：</label>#set($items=$!categorys.get(109))<select class="select160" name="items[8].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[8].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[9].isCount" #if($param.items[9].isCount) checked#end><input type="hidden" name="items[9].title" value="医疗保障">
	            	<label>医疗保障：</label>#set($items=$!categorys.get(107))<select class="select160" name="items[9].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[9].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li><input type="checkbox" name="items[10].isCount" #if($param.items[10].isCount) checked#end><input type="hidden" name="items[10].title" value="婚姻状况">
	            	<label>婚姻状况：</label>#set($items=$!categorys.get(102))<select class="select160" name="items[10].value" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{param.items[10].value}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            
	            
	        </ul>
	        
	        <ul class="inpubox bdline clearfix">
	            <li><input type="checkbox" name="items[11].isCount" #if($param.items[11].isCount) checked#end><input type="hidden" name="items[11].title" value="三无"><input type="hidden" name="items[11].isSpec" value="true">
	            	<label>三无</label>
	            </li>
	            <li><input type="checkbox" name="items[12].isCount" #if($param.items[12].isCount) checked#end><input type="hidden" name="items[12].title" value="无保障"><input type="hidden" name="items[12].isSpec" value="true">
	            	<label>无保障</label>
	            </li>
	            <li><input type="checkbox" name="items[13].isCount" #if($param.items[13].isCount) checked#end><input type="hidden" name="items[13].title" value="失独"><input type="hidden" name="items[13].isSpec" value="true">
	            	<label>失独</label>
	            </li>
	            <li><input type="checkbox" name="items[14].isCount" #if($param.items[14].isCount) checked#end><input type="hidden" name="items[14].title" value="优抚"><input type="hidden" name="items[14].isSpec" value="true">
	            	<label>优抚</label>
	            </li>
	            <li><input type="checkbox" name="items[15].isCount" #if($param.items[15].isCount) checked#end><input type="hidden" name="items[15].title" value="失能"><input type="hidden" name="items[15].isSpec" value="true">
	            	<label>失能</label>
	            </li>
	            <li><input type="checkbox" name="items[16].isCount" #if($param.items[16].isCount) checked#end><input type="hidden" name="items[16].title" value="孤寡"><input type="hidden" name="items[16].isSpec" value="true">
	            	<label>孤寡</label>
	            </li>
	            <li><input type="checkbox" name="items[17].isCount" #if($param.items[17].isCount) checked#end><input type="hidden" name="items[17].title" value="低保"><input type="hidden" name="items[17].isSpec" value="true">
	            	<label>低保</label>
	            </li>
	            <li><input type="checkbox" name="items[18].isCount" #if($param.items[18].isCount) checked#end><input type="hidden" name="items[18].title" value="空巢"><input type="hidden" name="items[18].isSpec" value="true">
	            	<label>空巢</label>
	            </li>
	            <li><input type="checkbox" name="items[19].isCount" #if($param.items[19].isCount) checked#end><input type="hidden" name="items[19].title" value="独居"><input type="hidden" name="items[19].isSpec" value="true">
	            	<label>独居</label>
	            </li>
	        </ul>
	        <div class="rightbtn pad10">
	        	<input class="button_btn search_btn" type="button" value="查询">
	        	<input class="button_btn export_btn" type="button" value="导出">
	        </div>
        </form>
        
        <div class="tablebox">
        #if($result)
            <table class="table100 usertable trclick">
                <tr>
                	<th>社区</th>
                	#foreach($item in $result)
                	<th>$!item.title</th>
                	#end
                </tr>
                #foreach($item in $result[0].itemList)
                #set($currentIndex = $foreach.index)
		        		<tr>
		        			<td>$!item.communityName</td>
		        			#foreach($i in $result)
		        			<td>$!i.itemList[$currentIndex].count</td>
		        			#end
		        		</tr>
		        		#end
            </table>
        #end
        </div>
    </div>
    <div class="footer"></div>
</div>
<script type="text/javascript">
$(function(){
	$('.export_btn').click(function(){
		$('form[name="searchForm"]').attr('action','/community/user/count/export');
		$('form[name="searchForm"]').submit();
	});
	$('.search_btn').click(function(){
		$('form[name="searchForm"]').attr('action','/community/user/count');
		$('form[name="searchForm"]').submit();
	});
});
</script>


</body>
</html>