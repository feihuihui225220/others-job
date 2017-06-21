<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="author" content="angtian">
 	<title>站点具体内容</title>
 	#parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/newCss/plan.css"/>
    <link rel="stylesheet" href="/assets/newCss/index.css" />
</head>
<style>
	#right{margin-top:20px;}
	.labe_{position:relative;top:-52px;}
	.add_first{width:90px;margin:0 0 20px 20px; }
	.quxiao{width:90px; }
	.r-top{padding-left:70%;}
	.yuangong{ width:85%;height:auto;margin-left:6%;}
	#suspension_add{position:absolute;margin-left:60px;margin-top:6%;}
	.yuangong{padding-top:5px;}
</style>
<body>
	<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="main">
	        #parse("/common/providers.tpl")
		<div id="right" > 
			<form  action="/professional/activity/updateNActivityPlanVO" method="post" id="searchForm">
			<div class="r-top">
				<input type="button" class="btn-default add_first btn addup" value="保存">
				<input type="button" class="btn-default add_first btn " value="预览">
			</div>
			<div>
			<input  type="hidden" name="id" value="$!nActivityPlan.id" >
			<input id="volunteerId" type="hidden" name="volunteerId" value="$!nActivityPlan.volunteerId" >
			<input id="_employeeId"  type="hidden"  name="employeeId" value="$!nActivityPlan.employeeId" >
			<label class="lable">活动主题：</label><input name="planName" value="$!nActivityPlan.planName"><br><br>
			<label class="lable">活动地点：</label><input name="planPlace" value="$!nActivityPlan.planPlace"><br><br>
			<label class="lable labe_">活动目的：</label><textarea name="planDesc" rows="3" cols="40">$!nActivityPlan.planDesc</textarea><br><br>
			<label class="lable">工作人员：</label><input id="employeeId"  value="" autocomplete="off"><input type="button" class="btn-default  btn  quxiao "  value="取消">
			<ul id="suspension_add" class="suspension" style="">
			</ul>
			<div class="yuangong">
				#foreach($u in $user)
					<input class="btn-default add_first btn daa-y" date-id='$u[0]' value='$u[1]'>
				#end
			</div>
			&nbsp;<label class="lable">志 愿 者：</label>
			<select class="ocountrys">
			<option value="-1">请选择</option>
			#foreach($oc in $ocountrys)
			     <option  value="$oc.id">
			         $oc.name
			     </option>
			#end	
			</select>
			<div class="nVolunteer_div"> 
			#foreach($n in $nVolunteer)
			     #if($!{velocityCount}%10==0)<br>#end
				<label style="width:100px;"><input class="_nVolunteer" type="checkbox" value="$n.id">$n.name &nbsp;&nbsp;&nbsp; </label> 
			#end	
			</div>
			</form> 
			<br/><br/>
			<table class="table _tale1">
				<tr  class="_active">
					<th>活动时间</th>
					<th>活动时长</th>
					<th>活动主题</th>
					<th>活动音乐</th>
					<th>活动内容</th>
					<th>人员安排</th>
					<th>操作</th>
				</tr>
				#foreach($npr in $nActivityPlan.programOfVO)
					<tr class="userid_$!npr.id">
						<td>$!npr.activeTime</td>
						<td>$!npr.duration</td>
						<td>$!npr.progranName</td>
						<td>$!npr.activitySuppliesMusic</th>
						<td>暂无</th>
						<td>$!npr.teacher</th>
						<td><a class="delete delplan" style="cursor:pointer;" date-id="$!npr.id">删除</a></th>
					</tr>
				#end
			</table>
			</div>
		</div>	
        </div> 
	</div>	
</body>
<script>
    $(function(){
         $('.ocountrys').change(function(){
           var communityId=$(this).val();
            $.ajax({  
                    url:"/professional/activity/VolunteerVO?communityId="+communityId,  
                    type:"get",          
                    success:function(data){
                        $(".nVolunteer_div").empty();
                           var dataRole = eval(data);  
                         for(var i=0;i<dataRole.length;i++){
                            var html=$('<label style="width:100px;"><input class="_nVolunteer" type="checkbox" value='+dataRole[i].id+'>'+dataRole[i].name+' &nbsp;&nbsp;&nbsp; </label> ');
				            $(".nVolunteer_div").append(html);
				             if(i%9==0&&i!=0){
				                $(".nVolunteer_div").append("<br>");
				             }
                         }
                    }
                 });
        });
    
    
        var volunteerId=$('#volunteerId').val();
        var arr=[];
        arr=volunteerId.split(",");
        $('._nVolunteer').each(function(){
            var vaule=$(this).val();
            for(var i=0;i<arr.length;i++){
                if(vaule==arr[i]){
                    $(this).prop('checked',true);
                }
            }
        
        });
    });
   
    
</script>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/newJs/plan.js"></script>
  
  
</html>
