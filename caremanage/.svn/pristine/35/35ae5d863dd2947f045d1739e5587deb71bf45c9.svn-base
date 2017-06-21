<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>添志愿者培训签到</title>
    #parse("/common/top.tpl")
     <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/pageNavigator.js"></script>
  	<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
  	<link rel="stylesheet" href="/assets/newCss/index.css" />
</head>
<style>
	
</style>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
	<div id="right" > 
	<div >
		<br>
		<button class="btn-default add_first btn see_nVolunteer">查看签到人员列表</button> <input class="btn  button_color" type=button value=返回 onclick="location.href='/professional/volunteer/see_train'"><br><br>
		
		<div  class=" div_from2 panel-primary plan_" >
	 	<table class="table _tale1" padding:0px;">
	        <tr class="_active">
	            <th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>所在社区</th>
				<th>联系电话</th>
				<th>操作</th>
	        </tr>
	        #foreach($e in $nVolunteer)
	         #set($i = $velocityCount + 1)
	        <tr class=" #if($i%2!=0 ) tr_two #else tr_first #end  data-id="$!e.id">
	            <td>$!e.name</td>
	            <td>$!e.sex</td>
	            <td>$!e.age</td>
	            <td>$!e.communityNmae</td>
	            <td>$!e.contact</td>
	            <td data-list="$!e.id">
	                <a href="#" class="tb_removeq ">退 签</a>
	            </td>
	        </tr>
	        #end
	    </table> 		
		</div>
		
		<form id="add_nvolunteer" action="/professional/volunteer/train_add_volunteer" method="post">
			<input type="hidden" name="id"  value="$trainId"/>
			<input type="hidden" name="trainId"  value="$trainId"/>
			<label class="lable_11">	按站点查看：
				<select id="site" name="siteIds">
					<option value="">---请选择---</option>
					#foreach ($s in $mVenderSite)
						<option  class="oCountry_communityIds"  value=$!s.id>$!s.siteName</option>
					#end
				</select>
			</label>	
			<label class="lable_11">	按社区查看：
				<select id="community" name="communityIds">
					<option value="">---请选择---</option>
					#foreach ($s in $oCountry)
						<option  class='oCountry_communityIds'  value=$!s.id>$!s.name</option>
					#end
				</select>
			</label>
			
			<input class="btn-default button_color  btn " type="submit" value=" &nbsp;搜  索&nbsp; "/>	
			<input class="btn-default button_color btn add_nVolunteer" type="button" value="点击签到"/>	 &nbsp; &nbsp;
			<label><input id="select_all" value=$trainId  type="checkbox"/>全部选择</label>
			<table class="table _tale1"  style="margin-top: 10px" >
				<tr class="_active">
					<th><input  type="hidden">序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>所在社区</th>
					<th>联系电话</th>
					<th>操作</th>
				</tr>
				#if ($list_vo)
				
		        #foreach($e in $list_vo)
		       #set($i = $velocityCount + 1)
	        <tr class=" #if($i%2!=0 ) tr_two #else tr_first #end"id=$e.id>
		        	<td style="width:10%">$i</td>
		            <td>$!e.name</td>
		            <td>$!e.sex</td>
		            <td>$!e.age</td>
		            <td>$!e.communityNmae</td>
		            <td>$!e.contact</td>
		            <td><input name="nid" class="pitch_up" type="checkbox" value=$e.id  />选择</td>
		        </tr>
		         #set($i=$i+1)
		        #end
		        #end
			</table>
		</form>
	</div> 
	<div>
<div>
<div>
	
</body>
<script>
	$(function(){
		 var mydate = new Date();
	  	 var str =mydate.getFullYear()+ "-";
		 str += (mydate.getMonth()+1) + "-";
		 str += mydate.getDate();
		 $(".timedate").val(str);
		 $(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '87px', height: '27px'});
	});
	$(function(){
		$("#select_all").click(function(){ 
				if(this.checked){ 
					$(".pitch_up").each(function(){this.checked=true;}); 
				}else{ 
					$(".pitch_up").each(function(){this.checked=false;}); 
					} 
			   });
	});
	$('.add_nVolunteer').click(function(){
		if($(".pitch_up[type='checkbox']:checked").length==0){
			alert("没有选择签到人员！");
		}else{
			$('#add_nvolunteer').attr("action","/professional/volunteer/add_nVolunteer");
			$('#add_nvolunteer').submit();
		}
		
	});
	
	 $(".add_first").click(function(){
    	$(".plan_").toggle();
    });
    $(function(){
    	$(".plan_").hide();
    });
    
    $(function(){
		 $(".tb_removeq").on("click", function () {
        	var gnl=confirm("你真的打算删除吗?");
				if (gnl==true){
					var table_id = $(this).parent().attr("data-list");
					var trainId=$trainId;
					location.href="/professional/volunteer/delete_nVolunteer_train?volunteerId="+table_id+"&trainId="+trainId;
				}else{
					return  false;
				}
           
        });
        
       
        
	});
</script>
</html>