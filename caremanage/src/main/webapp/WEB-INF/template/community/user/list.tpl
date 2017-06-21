<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>用户列表</title>
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
        <div class="usertitle strong">基础条件</div>
        <form action="/community/user/list" method="post" name="searchForm">
	        <ul class="inpubox clearfix">
	            <li><label>姓名：</label><input name="name" value="$!user.name" class="text150" type="text" /></li>
	            <li><label>身份证号：</label><input name="idCardNo" value="$!user.idCardNo" class="text150" type="text" /></li>
	            <li>
	            	<label>年龄：</label><input name="ageStart" value="$!{user.ageStart}" class="text50" type="text" /> 至 <input name="ageEnd" value="$!{user.ageEnd}" class="text50" type="text" /> 岁
	            </li>
	            <li>
	            	<label>户口类型：</label>#set($items=$!categorys.get(101))<select class="select160" name="hrType" id="">
	            		<option value="-1" #if($!{user.hrType}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.hrType}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li>
	            	<label>居住情况：</label>#set($items=$!categorys.get(105))<select class="select160" name="lifeCond" id="">
	            		<option value="-1" #if($!{user.lifeCond}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.lifeCond}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li>
	            	<label>激活状态：</label><select class="select160" name="active" id="">
	            		<option value="-1" #if($!{user.active}==-1)selected=true#end>全部</option>
	            		<option value="0" #if($!{user.active}==0)selected=true#end>未激活</option>
	            		<option value="1" #if($!{user.active}==1)selected=true#end>已激活</option>
	            		<option value="2" #if($!{user.active}==2)selected=true#end>已冻结</option>
	            		<option value="3" #if($!{user.active}==3)selected=true#end>待核对</option>
	            	</select>
	            </li>
	            #if($communitys)
	            <li>
	            	<label>所属社区：</label><select class="select160" name="communityId" id="">
	            		<option value="">全部社区</option>
	            		#foreach($item in $communitys)
	            		<option value="$!item.id" #if($!{user.communityId}==$!item.id)selected=true#end>$!item.name</option>
	            		#end
	            	</select>
	            </li>
	            #end
	        </ul>
	        <div class="user.title usertitletz strong">特征条件<span>更多<i>↓</i></span></div>
	        <ul class="inpubox bdline clearfix moreinput" style="display:none;">
	            <li>
	            	<label>三无：</label>
	            	#set($items=$!categorys.get(111))
	            	<select class="select160" name="three" id="">
	            		<option value="-1" #if($!{user.three}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.three}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li>
	            	<label>无保障：</label>
		            #set($items=$!categorys.get(113))
		            <select class="select160" name="noSecurity" id="">
		            	<option value="-1" #if($!{user.noSecurity}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.noSecurity}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
		            </select>
	            </li>
	            <li>
	            	<label>失独：</label>
	            	#set($items=$!categorys.get(117))
		            <select class="select160" name="lostOnly" id="">
		            	<option value="-1" #if($!{user.lostOnly}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.lostOnly}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
		            </select>
	            </li>
	            <li>
	            	<label>优抚：</label>
	            	#set($items=$!categorys.get(118))
		            <select class="select160" name="specialCare" id="">
		            	<option value="-1" #if($!{user.specialCare}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.specialCare}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
		            </select>
	            </li>
	            <li>
	            	<label>失能：</label>
	            	#set($items=$!categorys.get(112))
		            <select class="select160" name="disable" id="">
		            	<option value="-1" #if($!{user.disable}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.disable}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
		            </select>
	            </li>
	            <li>
	            	<label>孤寡：</label>
	            	#set($items=$!categorys.get(114))
		            <select class="select160" name="lonely" id="">
		            	<option value="-1" #if($!{user.lonely}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.lonely}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
		            </select>
	            </li>
	            <li>
	            	<label>低保：</label>
	            	#set($items=$!categorys.get(115))
		            <select class="select160" name="lessIncome" id="">
		            	<option value="-1" #if($!{user.lessIncome}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.lessIncome}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
		            </select>
	            </li>
	            <li>
	            	<label>空巢：</label>
	            	#set($items=$!categorys.get(116))
		            <select class="select160" name="emptyNest" id="">
		            	<option value="-1" #if($!{user.emptyNest}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.emptyNest}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
		            </select>
	            </li>
	            <li>
	            	<label>独居：</label>
	            	#set($items=$!categorys.get(119))
		            <select class="select160" name="lifeLonely" id="">
		            	<option value="-1" #if($!{user.lifeLonely}==-1)selected=true#end>全部</option>
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.lifeLonely}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
		            </select>
	            </li>
	        </ul>
	        <div class="rightbtn pad10">
	        	<button class="button_btn" type="submit">查询</button>
	        	<input class="ibtn button_btn importdata" type="button" value="导出">
	        	#if($!{sessionUser.getCateEnum()}!="STREET")
	    			<button class="button_btn" style="font-size:12px;" type="button" onclick='window.location.href="/community/user/add" '>添加人员</button>
	        	#end
	        </div>
        </form>
        #if($!{sessionUser.getCateEnum()}!="STREET")
        <div class="rightbtn pad10">
        	<form action="import" method="post" enctype="multipart/form-data">
        		<input type="file" name="file">
        		<button class="button_btn" type="submit">导入</button>
        	</form>
        </div>
        #end
        <div class="tablebox">
            <table class="table100 usertable trclick">
                <tr><th>姓名</th><th>身份证号</th><th>出生日期</th><th>联系电话</th><th>家庭住址</th><th>操作</th></tr>
                #if ($page)
	                #foreach ($u in $page.result)
		        		<tr>
		        			<td>$!{u.name}</td>
		        			<td>$!{u.idCardNo}</td>
		        			<td>$!date.format('yyyy-MM-dd',$!u.birthday)</td>
		        			<td>$!{u.contactPhone}</td>
		        			<td>$!{u.addr}</td>
		        			<td class="operate">
		        				<input onclick="window.location.href='/community/user/modify/$!{u.id}'" class="mgl5 button_btn" type="button" value="编辑"/>
		        				<input td_url="/community/user/remove/$!{u.id}" class="mgl5 button_btn tb_remove" type="button" value="删除"/>
		        				<input type="hidden" value="/community/user/detail/$!{u.id}"/>
		        			</td>
		        		</tr>
	        		#end
        		#end
            </table>
           #parse("/common/page.tpl")
        </div>
    </div>
    <div class="footer"></div>
    <script type="text/javascript">
    $(function(){
    	$('.usertitletz span').toggle(function(){
    		$(".moreinput").slideDown('fast',function(){$('.usertitletz span').html('收起<i>↑</i>');});    		
    	},function(){
    		$(".moreinput").slideUp('fast',function(){$('.usertitletz span').html('更多<i>↓</i>');});    		
    	});
    });
    </script>
</div>


<div class="importbox pad10 hide">
    <div class="selectbox clearfix">
        <div class="left f_l">
            <select class="selectmultiple" id="select_left" multiple="multiple" size="1">
                <option name="exp_name">姓名</option>
                <option name="exp_idCardNo">身份证号</option>
                <option name="exp_gender">性别</option>
                <option name="exp_birthday">出生日期</option>
                <option name="exp_mobilePhone">手机</option>
                <option name="exp_contactPhone">联系电话</option>
                <option name="exp_religion">宗教信仰</option>
                <option name="exp_hrType">户口类型</option>
                <option name="exp_hrAddr">户籍地址</option>
                <option name="exp_marry">婚姻情况</option>
                <option name="exp_political">政治面貌</option>
                <option name="exp_education">文化程度</option>
                <option name="exp_nation">民族</option>
                <option name="exp_addr">居住地址</option>
                <option name="exp_lifeCond">居住情况</option>
                <option name="exp_jobCond">从业情况</option>
                <option name="exp_income">经济来源</option>
                <option name="exp_medical">医疗保障</option>
            </select>
        </div>
        <div class="mid f_l">
        	<button class="addOption">添加</button>
        	<button class="delOption">删除</button>
        </div>
        <div class="right f_l">
        	<form action="export" id="exportForm" method="get">
	        	<input type="hidden" name="name" value="$!user.name" />
	        	<input type="hidden" name="idCardNo" value="$!user.idCardNo" />
	        	<input type="hidden" name="ageStart" value="$!{user.ageStart}" />
	        	<input type="hidden" name="ageEnd" value="$!{user.ageEnd}" />
	        	<input type="hidden" name="hrType" value="$!{user.hrType}" />
	        	<input type="hidden" name="lifeCond" value="$!{user.lifeCond}" />
	        	<input type="hidden" name="active" value="$!{user.active}" />
	        	<input type="hidden" name="three" value="$!{user.three}" />
	        	<input type="hidden" name="noSecurity" value="$!{user.noSecurity}" />
	        	<input type="hidden" name="lostOnly" value="$!{user.lostOnly}" />
	        	<input type="hidden" name="specialCare" value="$!{user.specialCare}" />
	        	<input type="hidden" name="disable" value="$!{user.disable}" />
	        	<input type="hidden" name="lonely" value="$!{user.lonely}" />
	        	<input type="hidden" name="lessIncome" value="$!{user.lessIncome}" />
	        	<input type="hidden" name="emptyNest" value="$!{user.emptyNest}" />
	        	<input type="hidden" name="lifeLonely" value="$!{user.lifeLonely}" />
	        	
            	<select class="selectmultiple" name="columns" id="select_right" multiple="multiple" size="1"></select>
            </form>
        </div>
    </div>
</div>
</body>
</html>