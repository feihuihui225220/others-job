<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>专业服务-客户管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
.searchli{padding-left:10%;}
</style>
<script>
	$(function(){
		$('.adduser').click(function(){
			location.href="/professional/vender/addUser";
		});
	});
</script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="">
        <div class="searchli">
        	<form action="/professional/vender/sevUsers" method="post" name="searchForm">
	            <ul class="inpubox clearfix">
	                <li><label>姓名：</label><input name="userName" value="$!{MUserVender.userName}" class="text150" type="text" /></li>
	                <li><label>身份证号：</label><input name="userIdCard" value="$!{MUserVender.userIdCard}" class="text150" type="text" /></li>
					<li><label>社区：</label>
					<select id="communityName" name="communityName" class="select160">
						<option value="">--------请选择--------</option>
						#foreach($c in $oCountry)
						<option value="$c.name">$!c.name</option>
						#end
					</select>
					</li>
	           		 <li><label>站点：</label>
					<select id="siteId" name="siteId" class="select160">
						<option value="0">--------请选择--------</option>
						#foreach($m in $mVenderSite)
						<option value="$m.id">$!m.siteName</option>
						#end
					</li>
					</select>
	                <li><input class="ibtn button_gm" type="submit" value="搜索"></li>
	           
	            </ul>
	           
            </form>
        </div>
       
        <div class="tablebox">
            <table  class="table _tale1" style="width:80%;margin-left:10%">
                <tr><th>姓名</th><th>身份证号</th><th>性别</th><th>所属社区</th><th>详情</th>
                #if($!{sessionUser.isSuper_()}==true)
                <th>分配状态</th>
                <th>删除</th>
                #end
                </tr>
               	#if ($page)
		                #foreach ($u in $page.result)
		               
			        		<tr class="ibtn addadver">
		        			<td>$!{u.rUser.name}</td>
		        			<td>$!{u.rUser.idCardNo}</td>
		        			<td>#if($!{u.rUser.gender}==0)女#else男#end</td>
			                 <td>
				       			$oCountry1.get($u.rUser.communityId)
				            </td>
			                <td><a href="/professional/vender/user/detail/$!{u.rUser.id}">详情>></a></td>
		                    #if($!{sessionUser.isSuper_()}==true)
		                    <td> #if($u.ruser.allocation==1)已分配#else新用户#end</td>
							<td><a href="/professional/vender/delete?id=$!{u.rUser.id}">删除>></a></td>
		        			#end
		        		</tr>
		        		#end
        		#end
            </table>
            #parse("/common/page.tpl")
        </div>
    </div>
    <div class="footer">
    	<input type="hidden"  id="com" value="$!communityName"/>
    </div>
</div>
<script>
	$(function(){
		var m=$('#com').val();
		$('#communityName option').each(function () {
		    var $option = $(this);
		    var html = $option.html();
		    var value = $option.val();
		    if(value==m){
		    	$(this).attr('selected','selected');
		    }
		});
	});

</script>
</body>
</html>