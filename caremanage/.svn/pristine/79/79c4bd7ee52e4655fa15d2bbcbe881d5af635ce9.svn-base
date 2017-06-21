<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="../assets/director/style/userFiling.css">
</head>

<body>

  #parse("/common/dtop.tpl")
    #parse("/common/duser.tpl")
<div class="main1">
  <div>
	<div class="contentPer">#parse("/common/dleft.tpl")</div>
    <div class="personInfo_right fl" style="float: left;">
      <div class="personInfo_righttop">
        <label>建档医生:</label>
        <label class="marginleft15">$!user.rUserDefault.doctor</label>
        <label class="marginleft75">建档护士:</label>
        <label class="marginleft15">$!user.rUserDefault.nurse</label>
        <label class="marginleft75">建档日期:</label>
        <label class="marginleft15">$!date.format('yyyy-MM-dd',$!user.createdAt)</label>
        <a href="/director/getRUserById?userId=$!user.id" class="fr save"></a>
      </div>
      <div class="personInfo_rightbottom">
        <ul class="detail">
          <li class="clearfix">
            <p class="p1 fl"><label>姓名:</label><label>$!user.name</label></p>
            <p class="p2 fl"><label>体重:</label><label>$!user.rUserDefault.weight kg</label></p>
           <!--  <p class="p3 fl"><label>工作单位:</label><label></label></p> -->
            <p class="p4 fl"><label>身份证号:</label><label>$!user.idCardNo</label></p>
          </li>
          <li class="clearfix">
            <p class="p1 fl"><label>性别:</label><label>#if($!user.gender==0)女#else男#end</label></p>
            <p class="p2 fl"><label>身高:</label><label>$!user.rUserDefault.height cm</label></p>
            <p class="p3 fl"><label>家庭电话:</label><label>$!user.mobilePhone</label></p>
            <p class="p4 fl"><label>社区(居委会):</label><label>$!fullName</label></p>
          </li>
          <li class="clearfix">
            <p class="p1 fl"><label>年龄:</label><label>$!user.age</label></p>
            <p class="p2 fl"><label>民族:</label><label> #foreach($!member in $!category)
	         	$!member.itemName
	         #end</label></p>
            <p class="p3 fl"><label>家庭住址:</label><label>$!user.addr</label></p>
          </li>
        </ul>
        <div class="emergency clearfix">
          <label class="contact fl">紧急联系人:</label>
          <div class="fl">
            <p><label>姓名:</label><label>$!user.rContact.name</label><label class="tele">电话:</label><label>$!user.rContact.mobilePhone</label></p>
          </div>
        </div>
        <div class="medical clearfix">
          <div class="clearfix">
            <p class="fl pLeft"><label >医疗费用类型:</label><label>$!user.rUserDefault.costType</label></p>
            <p class="fl pRight"><label >定点医疗单位:</label><label>$!user.rUserDefault.positionHospital</label></p>
          </div>
          <div class="clearfix">
          #if($!user.rUserDefault.family!='')
	       #set ($columnName = $!user.rUserDefault.family)
	                 #set ($columnArray = $columnName.split(","))
	                 #set ($columnArray = $columnName.indexOf(","))
	                 #set ($column=$columnName.substring(0,$columnArray))  
	                 
	                 #set ($columnq=$columnName.substring($columnArray))                 
	                 #set($columnws=$columnq.indexOf(",",1))
	                 #set ($columnw=$columnq.substring(1,$columnws))
	                 
	                 #set($columnqs=$columnq.substring($columnws))
	                 #set($columnes=$columnqs.indexOf(",") + 1)
	                 #set($columne=$columnqs.substring($columnes,$columnqs.length()))
	             #end
            <p class="fl pLeft"><label >家族情况:</label><label>父母:</label><label>$!column</label><label>子:</label><label>$!columnw</label><label>女:</label><label>$!columne</label></p>
            <p class="fl pRight"><label >文化程度:</label><label>
            		#if($!$!user.education=='201')文盲
                #elseif($!$!user.education=='200')小学 
                #elseif($!$!user.education=='198')初中
                #elseif($!$!user.education=='199')高中
                #elseif($!$!user.education=='202')大学专科和专科学校
                #elseif($!$!user.education=='203')中等专业学校
                #elseif($!$!user.education=='204')中等专业学校
                #elseif($!$!user.education=='260')研究生 
                #elseif($!$!user.education=='261')不详 
                #elseif($!$!user.education=='223')其他 
                #end
            	</label></p>
          </div>
          <div class="clearfix">
            <p class="fl pLeft"><label >职业:</label><label>
            	#if($!user.jobCond=='0')工人
	                #elseif($!user.jobCond=='1')干部
	                #elseif($!user.jobCond=='2')教师
	                #elseif($!user.jobCond=='3')医务
	                #elseif($!user.jobCond=='4')家务
	                #elseif($!user.jobCond=='5')军人
	                #elseif($!user.jobCond=='6')个体
	                #elseif($!user.jobCond=='205')退（离）休
	                #elseif($!user.jobCond=='206')无业
               	 	#elseif($!user.jobCond=='207')其他
                #end
            </label></p>
            <p class="fl pRight"><label >婚姻状况:</label><label>
            	#if($!user.marry=='193')已婚
	                #elseif($!user.marry=='222')未婚
	                #elseif($!user.marry=='192')丧偶
	                #elseif($!user.marry=='250')离婚
	                #elseif($!user.marry=='252')再婚
	                #elseif($!user.marry=='254')不详
	                #elseif($!user.marry=='253')其他
                #end
            </label></p>
          </div>
          <div class="clearfix">
          	#if($user.rUserDefault.smoking!='')
       			#set($smoking=$user.rUserDefault.smoking)
                #set($yys=$!smoking.indexOf(","))
                #set($yy=$smoking.substring(0,$yys))
                  
                #set($smokings=$smoking.substring($!yys))
               	#set($dds=$smokings.indexOf(",",1))
               	#set($dd=$smokings.substring(1,$dds))
                
                #set($smokingse=$smokings.substring($dds))
                #set($jies=$smokingse.indexOf(",") + 1)
                #set($jie=$smokingse.substring($jies,$smokingse.length()))
                #end
            <p class="fl pLeft"><label >吸烟史:</label><label>$!yy年</label></p>
            <p class="fl pRight"><label >吸烟量:</label><label>$!dd支/天</label><label >已戒烟:</label><label>$!jie年</label></p>
          </div>
          <div class="clearfix">
          	#if($user.rUserDefault.drinking!='')
        		#set($drinking=$user.rUserDefault.drinking)
                #set($dyys=$drinking.indexOf(","))
                #set($dyy=$drinking.substring(0,$dyys))
                #set($drinkings=$drinking.substring($dyys))
               	#set($ddds=$drinkings.indexOf(",",1))
               	#set($ddd=$drinkings.substring(1,$ddds))
                #set($drinkingse=$drinkings.substring($ddds))
                #set($djies=$drinkingse.indexOf(",") + 1)
                #set($djie=$drinkingse.substring($djies,$drinkingse.length()))
                #end
            <p class="fl pLeft"><label >饮酒史:</label><label>$!dyy年</label></p>
            <p class="fl pRight"><label >饮酒量:</label><label>$!ddd两/天</label><label >已戒酒:</label><label>$!djie年</label></p>
          </div>
          <div class="clearfix">
            <p class="fl pLeft"><label >饮食习惯:</label><label>$!user.rUserDefault.eating</label></p>
            <p class="fl pRight"><label >当前特殊困难:</label><label>$!user.rUserDefault.trouble</label></p>
          </div>
          <div class="clearfix div35"><label>药物过敏:</label><label>$!user.rUserDefault.allergy</label></div> 
          <div class="clearfix">
            <p class="fl pLeft1">病史及服药状况:</p>
            <p class="fl pRight1 colorRed">$!user.rUserDefault.medicalHistory</p>
          </div>   
        </div>
      </div>
    </div>
  </div>
   </div>
</body>
<script type="text/javascript" src="../assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
    	$(function(){
    		$(".personInfo .personInfo_left .sidebar li a").eq(0).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
    	});
    </script>
</html>
