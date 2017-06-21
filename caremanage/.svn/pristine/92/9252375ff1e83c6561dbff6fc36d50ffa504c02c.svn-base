<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>志愿者,列表</title>
   	#parse("/common/top.tpl")
 	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/common.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="/assets/newCss/index.css" />

</head>
<style>
   .bodyposition{ margin-right:5%;margin-left:5%;}
         .tablediv{width: 70%;float:left;margin-left:5%;}
         .searchli{float:left;margin-left:5%;}
         .nav-pills>li.active>a, 
         .nav-pills>li.active>a:hover, 
         .nav-pills>li.active>a:focus{background-color:#4CEDF7 !important;}
         a:hover{text-decoration:none;}
    .lable_1{margin-left:30px;} 
    .plan_{padding-top:20px;}
    ._div{margin-left:30px;}   
		.course{margin-left:10%;margin-top:20px;width:80%}	
	</style>
<body>
#parse("/common/masklayer.tpl")
	<div class="wrapper">
			#parse("/common/masklayer.tpl")
			#parse("/common/head.tpl")
			#if($!{sessionUser.isSuper_()}==true)
			<div class="main">
		        #parse("/common/providers.tpl")
		<div id="right">
		#else
		  <div class="courseMain">
	        <div class="course">
		#end
			<label class="title_2 title_main">
			<a class="a_first" href="/professional/volunteer/index">志愿者服务列表</a>
			</label><label class="title_2">|</label>
			<label class="title_2">
			<a class="a_first" href="/professional/volunteer/see_train">培训记录列表</a></label>
			<label class="title_2">|</label>
            <label class="title_2">
            <a class="a_first" href="/nVolunteerAssess/palvelutietue">服务记录</a></label>
			<br><br><br><br>
			<button class="btn-default add_first btn ">添加志愿者</button>
				<div  class=" div_from panel-primary plan_  product-container" style="display:none;">
				 		<form  method="post" action="/professional/volunteer/add"  id="" >
						<br>
						<label 	class="lable_1">姓名：<input placeholder="姓名" id="volunteerName" name="name"/></label><label  class="lable_1">性别：男 <input name="sex"  checked="checked" value="男" type="radio">&nbsp;&nbsp;&nbsp;女 <input name="sex" value="女" type="radio"></label><br><br>
						<label  class="lable_1">年龄：<input placeholder="年龄" id="age" name="age"/></label><label  class="lable_1">电话：<input id="contact" placeholder="座机加区号，例：010-0000000" name="contact"/></label><br><br>
						
						<label  class="lable_1">站点：</label>
						<select id="site_id" name="siteId"   style="height:25px;">
								<option id="_moren1"  value=0>-----请选择-----</option>
								#foreach ($s in $mVenderSite)
									<option  class="oCountry_communityIds"  value=$!s.id>$!s.siteName</option>
								#end
						</select>&nbsp;&nbsp;&nbsp;&nbsp;
						<label  class="lable_1">社区：</label>
						<select id="community" name="community"   class="select1"  style="height:25px;">
								<option id="_moren"  value=0>-----请选择-----</option>
						</select><br><br>
						<div class="_div">
							<input type="submit"class="btn btn-primary button_float" id="vo_submit" value="确认 "/><input type="button" class="btn btn-default button_float _quxiao" value="取消"/>
						</div>
					</form>
				</div>
				<div id="addVolunteer" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
					    <div class="modal-dialog">
					      <div class="modal-content">
							        <div class="modal-header">
							          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							          <br>
							          <h4 class="modal-title" id="myModalLabel">修改信息</h4>
							          <br>
							        </div>
						         <form action="/professional/volunteer/update" method="post" >
							        <div class="modal-body">
							         <br><input name="ids" type="hidden" id="_ids"/>
									 <label class="lable_1">姓名：<input placeholder="姓名" id="_volunteerName" name="namess"/></label><label  class="lable_1">性别： 男 <input name="sexs"  checked="checked" value="男" type="radio">&nbsp;&nbsp;&nbsp;女 <input name="sexs" value="女" type="radio"></label><br><br>
									 <br>
									 <label  class="lable_1">年龄：<input placeholder="年龄" id="_age" name="ages"/></label><label  class="lable_1">电话：  <input id="_contact" placeholder="座机加区号，例：010-0000000" name="contacts"/></label><br><br>
									 <br>
									
									 <label  class="lable_1">站点：</label>
									 <select id="_site_id" name="siteids"   style="height:25px;">
											<option  value=0>-----请选择-----</option>
											#foreach ($s in $mVenderSite)
												<option  class="_site_communityIds"  value=$!s.id>$!s.siteName</option>
											#end
									 </select>&nbsp;&nbsp;&nbsp;&nbsp;
									  <label  class="lable_1">社区：</label>
									 <select id="_community" name="communityids"   class="select1"  style="height:25px;">
										<option   value=0>-----请选择-----</option>
									 </select>
							        </div>
						        <div class="modal-footer"> <br>
									<input type="submit"class="btn btn-primary button_float" id="_vo_submit" value="确认 "/>
									<input type="button" class="btn btn-default button_float _quxiao"  data-dismiss="modal" value="取消"/>
						         	<br><br><br>
						        </div>
						        </form>
					      </div>
					    </div>
				
				</div>
	
		
	<div style="margin-top: 10px;margin-right: 10px">
		 <form action="/professional/volunteer/index" method="post" name="searchForm">
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
	    <table class="table _tale1" style="margin-top: 10px">
	        <tr class="_active">
	            <th>序号</th>
	            <th>姓名</th>
	            <th>性别</th>
	            <th>年龄</th>
	            <th>所在社区</th>
	            <th>服务站点</th>
	            <th>联系电话</th>
	            <th>服务记录</th>
	            <th>操作</th>
	        </tr>
	       #foreach($e in $page.result)
	        #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
	        <tr class=" #if($i%2!=0 ) tr_two #else tr_first #end"data-id="$!e.id">
	            <td>$i</td>
	            <td>$!e.name</td>
	            <td>$!e.sex</td>
	            <td>$!e.age</td>
	            <td>$!e.communityNmae</td>
	            <td>$!e.siteNmae</td>
	            <td>$!e.contact</td>
	            <td><a href="/professional/volunteer/service?volunteerId=$e.id">查看</a></td>
	            <td data-list="$!e.id">
	                <a data-toggle="modal" date-contact="$!e.contact" date-id="$!e.id" date-name="$!e.name" date-sex="$!e.sex" date-age="$!e.age" date-communty="$!e.community" date-site="$!e.site" data-target="#addVolunteer" class=" _button_add"  href="#" class="_see">编辑</a>
	                <a href="#" class="_delete ">删 除</a>
	            </td>
	        </tr>
	        #end
	    </table>
	    #parse("/common/page.tpl")
	</div>
	</div> 

</div>
</div>
</body>
<script src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script>
	$("._delete").on("click", function () {
        	var gnl=confirm("你真的打算删除吗?");
				if (gnl==true){
					var table_id = $(this).parent().attr("data-list");
					$(this).attr("href", "toDelete?volunteerId=" + table_id);
				}else{
					return  false;
				}
      });     
    $(".nav").children().click(function () {
        $(this).parent().children().attr("class", "");
        $(this).attr("class", "active");
    });

    $("#add_volunteer").on("click", function () {
        $("#iframe").attr("src","/professional/volunteer/gotoAdd");
    });

    $("#train").click(function(){
        $("#iframe").attr("src","/professional/volunteer/record_train");
    });
    $(".add_first").click(function(){
    	$(".plan_").toggle();
    });
    $(function(){
    	$(".plan_").hide();
    });
    $('._quxiao').click(function(){
    	$('#contact').val("");
    	$('#age').val("");
    	$('#volunteerName').val("");
    	
    	$(".plan_").hide();
    });
    
</script>
<script>
	$('._button_add').click(function(){
	
		var contact=$(this).attr('date-contact');
		var id=$(this).attr('date-id');
		var name=$(this).attr('date-name');
		var sex=$(this).attr('date-sex');
		var age=$(this).attr('date-age');
		var communty=$(this).attr('date-communty');
		var site=$(this).attr('date-site');
		$('#_ids').val(id);
		$('#_volunteerName').val(name);
		$('#_contact').val(contact);
		$('#_age').val(age);
		$('._oCountry_communityIds').each(function(){
		if($(this).val()==communty){
			$(this).attr('selected',true);
		}
		})
		$('._site_communityIds').each(function(){
		if($(this).val()==site){
			$(this).attr('selected',true);
		}
		})
		
	});

    $("#vo_submit").on("click", function () {
    	var contact=$('#contact').val();
    	var age=$('#age').val();
    	var volunteerName=$('#volunteerName').val();
    	var community=$('#community').val();
     	if((/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/.test(contact))){ 
			if (age < 18 || age > 120){ 
				alert("年龄不合法！")
				return false; 
			}else{
				if(community==0||volunteerName==null){
		    		alert("姓名或社区出错！");
		    		return false;
		    	}	
			} 
    	}else{
	    	alert("不是完整的11位手机号或者正确的手机号前七位"); 
	        return false; 
    	}
     
    })
    $("#_vo_submit").on("click", function () {
    	var contact=$('#_contact').val();
    	var age=$('#_age').val();
    	var volunteerName=$('#_volunteerName').val();
    	var community=$('#_community').val();
     	if((/^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/.test(contact))){ 
			if (age < 18 || age > 120){ 
				alert("年龄不合法！")
				return false; 
			}else{
				if(community==0||volunteerName==null){
		    		alert("姓名或社区出错！");
		    		return false;
		    	}	
			} 
    	}else{
	    	alert("不是完整的11位手机号或者正确的手机号前七位"); 
	        return false; 
    	}
     
    })									
    
    $('#site_id').change(function(){
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
    
    $('#_site_id').change(function(){
    	 var id=$(this).children('option:selected').val();
    	 $('#_community').html("<option id='_moren'  value=0>-----请选择-----</option>");
    	 if(id!=0){
	    	  $.ajax({
	                url: "/professional/site/communtiy?id="+id,
	                type: "get",
	                success: function (json) {
	                  	var mjson = eval("(" + json + ")");
	                  	var length=mjson.oCountry.length;
	                  	for(var i=0;i<length;i++){
	                  		var option=$("<option  class='_oCountry_communityIds'  value="+mjson.oCountry[i].id+">"+mjson.oCountry[i].name+"</option>");
	                  		$('#_community').append(option);
	                  	}
	                }
	         });
    	 }
    
    })
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
</script>
</html>