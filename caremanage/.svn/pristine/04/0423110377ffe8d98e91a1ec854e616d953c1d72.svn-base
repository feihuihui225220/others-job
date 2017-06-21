<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息-编辑</title>
    <link rel="stylesheet" type="text/css" href="../assets/director/style/filing.css">
    <style type="text/css">
    	.ocountry{width:100px;
				    height: 30px;
				    border: 1px solid #b7b7b7;
				    border-radius: 5px;
				    margin:15px 0px 5px 2px;}
    </style>
</head>

<body>
  #parse("/common/dtop.tpl")
    #parse("/common/duser.tpl")
<div class="main">

  <div>
	<div class="contentPer">#parse("/common/dleft.tpl")</div>
    <div class="personInfo_right fl" style="float: left;">
    <form action="/director/modifyRUser" method = "post" id="tijiao" enctype="multipart/form-data">
      <div class="personInfo_righttop">
        <label>建档医生:</label>
        <label class="marginleft15">$!user.rUserDefault.doctor</label>
        <label class="marginleft75">建档护士:</label>
        <label class="marginleft15">$!user.rUserDefault.nurse</label>
        <label class="marginleft75">建档日期:</label>
        <label class="marginleft15">$!date.format('yyyy-MM-dd',$!user.createdAt)</label>
        <div style=position:relative;left:690px;top:-30px;">
        <a  class="btnBg addSave" date-value="1" style="margin-left:150px;width: 80px;">保存</a>

       	<a href="javascript:history.go(-1)" class="btnBg" style="width: 60px;">返回</a>
        </div>
      </div>
      <input value="${array}" id="allergy" type="hidden"/>
	 	 <input type="hidden" name="id" value="$!user.id">
	 	 <input type="hidden" name="family" id="family" />
	 	 <input type="hidden" name="smoking" id="smoking" />
	 	 <input type="hidden" name="drinking" id="drinking" value="$!dyy,$!ddd,$!jie" />
      <div class="personInfo_rightbottom">
        <ul class="detail">
          <li>
            <label>姓名:</label><input type="text"  name="name" value="$!user.name"  class="input1" />
            <label>体重:</label><input type="text" name="weight" value="$!user.rUserDefault.weight" class="input1">
            <!-- <label>工作单位:</label><input type="text" name="unit" value="" class="input2"> -->
            <label>身份证号:</label><input type="text" name="idCardNo" value="$!user.idCardNo" class="input2">
            <label>头像:</label><input type="file" id="file" name="pic" />
          </li>
          <li>
            <label>性别:</label><input type="radio" name="gender" #if($!user.gender==0) checked=checked #end  value="0" >女
          	<input type="radio" name="gender" #if($!user.gender==1) checked=checked #end value="1" >男
            <label>身高:</label><input type="text" name="height" value="$!user.rUserDefault.height" class="input1">
            <label>家庭电话:</label><input type="text" name="mobilePhone" value="$!user.mobilePhone" class="input2">
           <!--  <label>社区（居委会）:</label><input type="text" name="" class="input2"> -->
		            <input type="hidden" class="txt_input_edit" id="communityId" value="$!fullName"/>
		          	<select  id="com" style="width:100px; display:none;">
		          	#foreach($!c in $!country)
		          		<option value="$!c.id">$!c.name</option>
		          	#end
		          	</select><br>
		          	<label>社区（居委会）:</label>
            		    <select class='ocountry select260 ' id="province" next="city">
		                	<option value="0">=请选择=</option>
		                </select>
		                <select class='ocountry select260' id="city" next="region">
		                    <option value="-1">=请选择=</option>
		                </select>
		                <select class='ocountry select260' id="region" next="street">
		                    <option value="-1">=请选择=</option>
		                    #if($city)
		                   <option class="option3" value="$city.id" selected = selected >$city.name</option>  
		                   #end 
		                </select>
		                <select class='ocountry select260' id="street" next="community">
		                    <option value="-1">=请选择=</option>
		                    #foreach($str in $ocstreet)
		                    <option class="option4" value="$str.id" #if($str.id==$street.id) selected = "selected" #end>$str.name</option>
		                    #end
		                </select>
		                <select class='ocountry select260' id="community" name="communityId">
		                    <option value="-1">=请选择=</option>
		                    #foreach($str in $occom)
		                    <option class="option5" value="$str.id" #if($!user.communityId==$str.id) selected = selected #end>$str.name </option>
		                    #end
		                </select><a class="required"></a><br/>
          </li>
          <li>
            <label>年龄:</label><input type="text" name="age" value="$!user.age" class="input1">
            <label>民族:</label>
            	<select id="minzu" name="nation" class="input1">
			        <option value="">请选择</option>
			        #foreach($pse in $!categorys.keySet())
			        	<option #if($pse==$!user.nation) selected="selected" #end value="$pse">$!{categorys.get($pse)}</option>
			        	#end
			        </select>
            
            <label>家庭住址:</label><input type="text" name="addr" value="$!user.addr" class="input2" style="width:330px;">
          </li>
        </ul>
        <div class="emergency clearfix">
          <label class="contact fl">紧急联系人:</label>
           <p class="fl" style="width:450px;">
            <label>姓名:</label>
            <input type="text" class="input1" name="nameL" value="$!user.rContact.name" />
            <label>电话:</label>
            <input type="text" class="input2" name="mobilePhoneL" value="$!user.rContact.mobilePhone" />
           </p> 
        <!--   <a href="#" class="increase"></a> -->
        </div>
        <div class="medical">
          <label class="leftInfo">医疗费用类型:</label>
          <input type="checkbox" name="costType" id="baoxian" value="医保">
          <label for="baoxian" class="marginright50">医保</label>
          <input type="checkbox" name="costType" id="gongliao" value="公疗">
          <label for="gongliao" class="marginright50">公疗</label>
          <input type="checkbox" name="costType" id="laoxiao" value="一老一小">
          <label for="laoxiao" class="marginright50">一老一小</label>
          <input type="checkbox" name="costType" id="jiashu" value="家属<">
          <label for="jiashu" class="marginright50">家属</label>
          <input type="checkbox" name="costType" id="zifei" value="自费">
          <label for="zifei">自费</label>
        </div>
        <div class="fixedmed">
          <label class="leftInfo">定点医疗单位:</label>
          <input type="text" name="positionHospital" value="$!user.rUserDefault.positionHospital" class="input3">
        </div>
        <div class="marriage border-bottom">
          <label class="leftInfo fl">婚姻状况:</label>
            <input type="radio" name="marry"  value="193" id="yihun" #if($!user.marry=='193') checked=checked #end>
            <label for="yihun" class="marginright50">已婚</label>
            <input type="radio" name="marry"  value="222" id="weihun" #if($!user.marry=='222') checked=checked #end>
            <label for="weihun" class="marginright50">未婚</label>
            <input type="radio" name="marry" value="192" id="sangou" #if($!user.marry=='192') checked=checked #end>
            <label for="sangou" class="marginright50">丧偶</label>
            <input type="radio" name="marry"  value="250" id="lihun"  #if($!user.marry=='250') checked=checked #end>
            <label for="lihun" class="marginright50">离婚</label>
            <input type="radio" name="marry"  value="252" id="zaihun"  #if($!user.marry=='252') checked=checked #end>
            <label for="zaihun" class="marginright50">再婚</label>
            <input type="radio" name="marry"  value="254" id="buxiang" #if($!user.marry=='254') checked=checked #end>
            <label for="buxiang" class="marginright50">不详</label>
            <input type="radio" name="marry"  value="253" id="qita" #if($!user.marry=='253') checked=checked #end>
            <label for="qita">其他</label>
        </div>
        <div class="family border-bottom">
        		#if($user.rUserDefault.family!='')
      			 #set ($columnName = $user.rUserDefault.family)
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
          <label class="leftInfo">家族情况:</label>
          <label>父母:</label>
          <input type="text" name="" id="column" value="$!column" class="input4">
          <label>人</label>
          <label style="margin-left:58px;">子:</label>
          <input type="text" name="" id="columnw" value="$!columnw" class="input4">
          <label>人</label>
          <label style="margin-left:58px;">女:</label>
          <input type="text" name="" id="columne" value="$!columne" class="input4">
          <label>人</label>
        </div>
        <div class="degree border-bottom">
          <label class="leftInfo">文化程度:</label>
          <input type="radio" name="education"  value="201" id="illiteracy" #if($!$!user.education=='201') checked=checked  #end>
          <label for="illiteracy" class="marginright50">文盲或半文盲</label>
          <input type="radio" name="education"  value="200" id="primary" #if($!$!user.education=='200') checked=checked  #end>
          <label for="primary" class="marginright50">小学</label>
          <input type="radio" name="education"  value="198" id="chu" #if($!$!user.education=='198') checked=checked  #end>
          <label for="chu" class="marginright50">初中</label>
          <input type="radio" name="education"  value="199" id="gao" #if($!$!user.education=='199') checked=checked  #end>
          <label for="gao" class="marginright50">高中</label>
          <input type="radio" name="education"  value="202" id="zhuan" #if($!$!user.education=='202') checked=checked  #end>
          <label for="zhuan" class="marginright50">大学专科和专科学校</label>
          <input type="radio" name="education"  value="203" id="senior" #if($!$!user.education=='203') checked=checked  #end>
          <label for="senior" class="marginright50">中等专业学校</label>
          <input type="radio" name="education"  value="204" id="college" #if($!$!user.education=='204') checked=checked  #end>
          <label for="college" class="marginright50">大学</label>
           <input type="radio" name="education"  value="260" id="degree_other" #if($!$!user.education=='260') checked=checked  #end>
          <label for="degree_other">研究生</label><br/>
          <input type="radio" name="education" style="margin-left:150px;"  value="261" id="bux" #if($!$!user.education=='261') checked=checked  #end>
          <label for="bux">不详</label>
          <input type="radio" name="education"  value="223" id="qit" #if($!$!user.education=='223') checked=checked  #end>
          <label for="qit">其他</label>
        </div>
        <div class="profession border-bottom">
          <label class="job">职业:</label>
          <input type="radio" name="jobCond"  value="0" id="worker" #if($!user.jobCond=='0') checked=checked  #end>
          <label for="worker" class="marginright50">工人</label>
          <input type="radio" name="jobCond"  value="1" id="leader" #if($!user.jobCond=='1') checked=checked  #end>
          <label for="leader" class="marginright50">干部</label>
          <input type="radio" name="jobCond"  value="2" id="teacher" #if($!user.jobCond=='2') checked=checked  #end>
          <label for="teacher" class="marginright50">教师</label>
          <input type="radio" name="jobCond"   value="3" id="doctor" #if($!user.jobCond=='3') checked=checked  #end>
          <label for="doctor" class="marginright50">医务</label>
          <input type="radio" name="jobCond"  value="4" id="housework" #if($!user.jobCond=='4') checked=checked  #end>
          <label for="housework" class="marginright50">家务</label>
          <input type="radio" name="jobCond"  value="5" id="soldier" #if($!user.jobCond=='5') checked=checked  #end>
          <label for="soldier" class="marginright50">军人</label>
          <input type="radio" name="jobCond"  value="6" id="self" #if($!user.jobCond=='6') checked=checked  #end>
          <label for="self" class="marginright50">个体</label>
          <input type="radio" name="jobCond"  value="205" id="retire" #if($!user.jobCond=='205') checked=checked  #end>
          <label for="retire" class="marginright50">退(离)休</label>
          <input type="radio" name="jobCond"  value="206" id="unemployed" #if($!user.jobCond=='206') checked=checked  #end>
          <label for="unemployed" class="marginright50">无业</label>
          <input type="radio" name="jobCond"  value="207" id="other" #if($!user.jobCond=='207') checked=checked  #end>
          <label for="other">其他</label>
        </div>
        <div class="smoke border-bottom">
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
          <label class="leftInfo">吸烟史:</label>
          <input type="text" name="" id="yy" class="input4" value="$!yy" />
          <label>年</label>
          <label class="marginleft50">吸烟量:</label>
          <input type="text" name="" id="dd" class="input4" value="$!dd" />
          <label>支/天</label>
          <label class="marginleft50">已戒烟:</label>
          <input type="text" name="" id="jie" class="input4" value="$!jie" />
          <label>年</label>
        </div>
        <div class="drink border-bottom">
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
          <label class="leftInfo">饮酒史</label>
          <input type="text" name="" id="dyy" class="input4" value="$!dyy">
          <label>年</label>
          <label class="marginleft50">饮酒量:</label>
          <input type="text" name="" id="ddd" class="input4" value="$!ddd">
          <label>两/天</label>
          <label class="marginleft50">已戒酒:</label>
          <input type="text" name="" id="djie" class="input4"  value="$!djie">
          <label>年</label>
        </div>
        <div class="dietary border-bottom">
          <label class="habit">饮食习惯:</label>
          <input type="checkbox" name="eating" id="salty" value="咸">
          <label for="salty" class="marginright60">咸</label>
          <input type="checkbox" name="eating" id="sweet" value="甜">
          <label for="sweet" class="marginright60">甜</label>
          <input type="checkbox" name="eating" id="spicy" value="辣">
          <label for="spicy" class="marginright60">辣</label>
          <input type="checkbox" name="eating" id="sour" value="酸">
          <label for="sour" class="marginright60">酸</label>
          <input type="checkbox" name="eating" id="fried" value="油炸">
          <label for="fried" class="marginright60">油炸</label>
          <input type="checkbox" name="eating" id="hot" value="热食">
          <label for="hot" class="marginright60">热食</label>
          <input type="checkbox" name="eating" id="cold" value="冷食">
          <label for="cold" class="marginright60">冷食</label>
          <input type="checkbox" name="eating" id="vege" value="素食">
          <label for="vege" class="marginright60">素食</label>
          <input type="checkbox" name="eating" id="meat" value="荤食">
          <label for="meat" class="marginright60">荤食</label>
          <input type="checkbox" name="eating" id="qita1" value="其他">
          <label for="qita1" >其他</label>
        </div>
        <div class="irritability border-bottom">
          <label class="leftInfo" style="margin-left: -145px;">药物过敏:</label>
          <input type="checkbox" name="allergy" id="qinmeisu" value="青霉素">
          <label for="qinmeisu" class="marginright50">青霉素</label>
          <input type="checkbox" name="allergy" id="lianmeisu" value="链霉素">
          <label for="lianmeisu" class="marginright50">链霉素</label>
          <input type="checkbox" name="allergy" id="huangan" value="磺胺">
          <label for="huangan" class="marginright50">磺胺</label>
          <input type="checkbox" name="allergy" id="toubao" value="头孢">
          <label for="toubao" class="marginright50">头孢</label>
          <input type="checkbox" name="allergy" id="qita_med" value="其他">
          <label for="qita_med" class="marginright50">其他</label>
          <input type="checkbox" name="allergy" id="no" value="无">
          <label for="no">无</label>
        </div>
        <div class="hard border-bottom">
          <label class="leftInfo">当前特殊困难:</label>
          <input type="checkbox" name="trouble" id="bashi" value=">80">
          <label for="bashi" class="marginright50">&gt;80岁</label>
          <input type="checkbox" name="trouble" id="xingdong" value="行动不便">
          <label for="xingdong" class="marginright50">行动不便</label>
          <input type="checkbox" name="trouble" id="wochuang" value="卧床">
          <label for="wochuang" class="marginright50">卧床</label>
          <input type="checkbox" name="trouble" id="duju" value="独居">
          <label for="duju" class="marginright50">独居</label>
          <input type="checkbox" name="trouble" id="nochild" value="子女不在身边">
          <label for="nochild" class="marginright50">子女不在身边</label>
          <input type="checkbox" name="trouble" id="hardno" value="无">
          <label for="hardno">无</label>
        </div>
        <div class="medhisory">
          <label class="leftInfo fl">病史及服药状况:</label>
          <textarea class="medhis" name="medicalHistory">$!user.rUserDefault.medicalHistory</textarea>
        </div>
        <div><a  class="btnBg addSave" style="margin-left:150px;width: 120px;">保存并继续建档</a></div>
      </div>
    </div>
    </form>
  </div>
</div>
</body>
<script src="/assets/js/country_1.js"></script>
    <script type="text/javascript">  
    		 $(document).ready(function(){
    		 $(".personInfo .personInfo_left .sidebar li a").eq(0).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
		    	var allergy=$("#allergy").val().split(',');
				 var inputs=$("input[type='checkbox']");
				 	for(var i in inputs){
				 		for(var a in allergy){
				 			if(allergy[a]==inputs.eq(i).val()){
				 				inputs.eq(i).attr("checked",true);
				 			}
				 		}
			 		};
		 			 $('#region').click(function(){
		 			 	var id=$(this).val(); 
				       	$("#region option:not(:selected)").each(function(){
				       		if($(this).val()==id){
				       			$(this).remove();
				       		}
		 			 
				       	});
		 			 });
		 		$(".addSave").click(function(){
				          	var value=$(this).attr("date-value");
				          	if(value!=undefined){
				          		$('#tijiao').attr("action","/director/modifyRUser?type=1");
				          	}else{
				          		$('#tijiao').attr("action","/director/modifyRUser");
				          	}
				          	var col=$("#column").val();
				          	var colw=$("#columnw").val();
				          	var cloe=$("#columne").val();
				          	var arr = new Array();
				          	arr.push(col);
				          	arr.push(colw);
				          	arr.push(cloe);
				          	$("#family").val(arr);
				          	
				          	var yy=$("#yy").val();
				          	var dd=$("#dd").val();
				          	var jie=$("#jie").val();
				          	var arrs=new Array();
				          	arrs.push(yy);
				          	arrs.push(dd);
				          	arrs.push(jie);
				          	$("#smoking").val(arrs);
				          	
				          	var dyy=$("#dyy").val();
				          	var ddd=$("#ddd").val();
				          	var djie=$("#djie").val();
				          	var arrd=new Array();
				          	arrd.push(dyy);
				          	arrd.push(ddd);
				          	arrd.push(djie);
				          	$("#drinking").val(arrd);
				          	
					            var radioname;
					   			var arrRadio = new Array();
								var inputs=document.getElementsByTagName("input");
								for(var i=0;i<inputs.length;i++) {
									if(inputs[i].type=="radio" || inputs[i].type=="checkbox"){
										if (radioname !=inputs[i].name){
						                arrRadio.push(inputs[i].name);
						                radioname =inputs[i].name;
						                }
									} 
								}
								for (var i=0;i<arrRadio.length;i++) {
					      		var bRadio=false;
					      			for (var j=0;j<document.getElementsByName(arrRadio[i]).length;j++) {
					         			if (document.getElementsByName(arrRadio[i]).item(j).checked==true){
					              		bRadio=true;
					              		continue;
					          			}
					      			}
					      			/* if (!bRadio){
					            		alert("当前页面单选框和复选框不能有空项！");
					            		return false;
					      			} */
					   			}
				   			var f=document.getElementById("file").value;
					        if(f!=""){
					        	 if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(f)){
						          alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
          							return false;
        						};
					        }
					       $("#tijiao").submit();
					        return true; 
		 		})
		 			
	      }); 
	      function myCheck(){      		
				         };

		     
    </script>
</html>
