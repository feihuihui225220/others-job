<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>专业服务-客户管理</title>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/assets/css/bootstrap-select.css"/>
<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
	.th_wid{width:80px;}
	.tablebox{width:97%}
	#right{width:78%;float:right;padding: 0 ;margin:0; }
	.searchli{margin-left:-8%;padding-bottom:20px;}
	.tablebox{margin-left:-8%;}
	.tablebox span{float: right;}
	.add_first{height:25px;}
	.sousuo{width:50px;}
	.topselect{width:110px;height:35px;}
	.bootstrap-select{width:150px;height:30px;}
	input{border-radius:3px;}
	select{border-radius:3px;}
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
       <div class="main">
       #parse("/common/providers.tpl")
    <div id="right">  
        <div class="searchli">
        <br/>
        	<form action="/professional/vender/sevUsers" method="post" name="searchForm">
	               <label>姓名：</label><input name="userName" value="$!{MUserVender.userName}" class="topselect" type="text" />
	                <label>身份证号：</label><input name="userIdCard" value="$!{MUserVender.userIdCard}" class="topselect" type="text" />
					<label>社区：</label>
					<select id="communityName" name="communityName" class="selectpicker topselect tocom" multiple data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
						#foreach($c in $oCountry)
						<option #if($communityName==$c.name) selected="selected" #end value="$c.name">$!c.name</option>
						#end
					</select>
					<label>站点：</label>
					<select id="siteId" class="selectpicker topselect topsite" name="siteIds" multiple data-live-search="true" data-live-search-placeholder="Search" data-actions-box="true">
						#foreach($m in $mVenderSite)
						<option value="$m.id" #if($m.id==$siteId) selected="selected" #end>$!m.siteName</option>
						#end
					</select>
					
					#if($sessionUser.super_)
					
						<label>分配状态：</label>
						<select id="allocation" name="allocation" class="topselect">
							<option value="-1" #if($allocation==-1)  selected="selected" #end>全部</option>
							<option #if($allocation==0) selected="selected"  #end value="0"  >新用户</option>
							<option #if($allocation==1)  selected="selected"  #end value="1"  >已分配</option>
						</select>
					
					#end
	                <input class="button_gm btn-default add_first sousuo  " type="submit" value="搜索">
                    #if($!{sessionUser.isSuper_()}==true)
                		<input class="button_gm btn-default add_first adduser " type="button" value="添加客户"/>
	            	#end
            </form>
        </div>
        <div class="tablebox">
            <table class=" _tale1" style="width:100%">
                <tr class="_active"><th class="th_wid">姓名</th><th>身份证号</th><th class="th_wid">性别</th><th>所属社区</th><th>所属站点</th><th class="th_wid">签到次数</th><th  class="th_wid">分配状态</th><th class="th_wid">详情</th><th class="th_wid">删除</th></tr>
               	#if ($page)
		                #foreach ($u in $page.result)
		                 #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
	        			<tr class=" #if($i%2!=0 ) tr_two #else tr_first #end ibtn addadver"data-id="$!e.id">
		        			<td>$!{u.userName}</td>
		        			<td>$!{u.idCard}</td>
		        			<td>#if($!{u.gender}==0)女#else男#end</td>
			                <td>$!{u.communityName}</td>
			                <td>$!{u.siteName}</td>
			                <td>$!{u.SignInCase}</td>
			                <td>#if($u.status==1)已分配#else新用户#end</td>
			                <td><a href="/professional/vender/user/detail/$u.userId">详情>></a></td>
			                <td><a  class="deletedd" date-value="$u.Id" href="#" ">删除>></a></td>
		        		</tr>
		        		#end
        		#end
            </table>
            #parse("/common/page.tpl")
        </div>    
    </div>
    
    <div class="footer">
    	<input type="hidden"  id="com" value="$!communityName"/>
    	<input type="hidden"  id="all" value="$!allocation"/>
    	<input type="hidden"  id="sites" value="$!siteId"/>
    </div>
   </div> 
</div>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/bootstrap-select.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script>
$(window).on('load', function() {
	var str = $('#com').val();
	var arr = str.split(',');
	$('.tocom').selectpicker('val', arr);
	var str1 = $('#sites').val();
	var arr1 = str1.split(',');
	$('.topsite').selectpicker('val', arr1);
});
$(function(){

		
		$('.adduser').click(function(){
			location.href="/professional/vender/addUser";
		});
	
		$('.deletedd').click(function(){
			var id=$(this).attr("date-value");
			var gnl=confirm("你真的打算删除吗?");
				if (gnl==true){
					location.href="/professional/vender/delete?id="+id;
				}else{
					return false;
				}
		});
		
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
</body>
</html>