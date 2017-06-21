<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>申请</title>
#parse("/common/top.tpl")
 <link rel="stylesheet" href="$request.contextPath/assets/css/common.css"/>
    <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css"/>
    <script src="$request.contextPath/assets/js/calendar.js"></script>
    <script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
    <script src="$request.contextPath/assets/js/highcharts.js"></script>
    <link rel="stylesheet" href="/assets/css/reg.css" />
	<script src="/assets/js/jquery-1.8.0.min.js"></script>
	<script src="/assets/js/country_1.js"></script>
    <style>
    	.bodyline{width:70%; margin-left:10%}
    	a{color:red}
    </style>
</head>
<body>

<div class="wrapper">
   	 #parse("/common/head.tpl")
    <br/>
    <div class="bodyline ">
   <br/>
        <div class="usertitle strong">基础信息(<a>*为必填项</a>)</div>
        <form action="/community/user/save" id="saveUser" method="post" enctype="multipart/form-data">
	        <ul class="inpubox clearfix">
	        	<input type="hidden" name="id" value="$!user.id"/>
	            <li><label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
	            <input class="text150" type="text" name="name" value="$!user.name"  maxlength="8" /><a class="required"> *</a></li>
	            <li><label>身份证号：</label>
	            <input class="text150" type="text"  name="idCardNo" maxlength="18" id="idCard" #if($!user.idCardNo) value="$!user.idCardNo" #else  value="" #end/><a class="required"> *</a></li>
	            <li>
	            	<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
	            	<select class="select160" name="gender" id="">
	            		<option value="0" #if($!{user.gender}==0)selected=true#end>女</option>
	            		<option value="1" #if($!{user.gender}==1)selected=true#end>男</option>
	            	</select><a class="required"> *</a></li>
	            <li><label>出生日期：</label>
	            <input class="text150 timedate" id="birthday" type="text" value="$!date.format('yyyy-MM-dd',$!user.birthday)"  name="birthday"/><a class="required"> *</a></li>
	            <li>
	            	<label>手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：</label>
	            	<input class="text150" type="text" maxlength="11" name="mobilePhone" id="mobilePhone"  value="$!user.mobilePhone" #if($user.mobilePhone) readOnly="true"  #end/><a class="required"> *</a>
	        	</li>
	           
	           #set($us=$session.getAttribute("sessionUser"))
   				#if($us.getCateEnum()=="PRO")
	            <li>
	            	<label>站&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：</label>
	    				<select name="siteId" class='select160 site' id="site" >
		                	<option  value="0">=请选择=</option>
		                	#foreach($m in $mVenderSiteList)
		                	<option #if($mUserVender.siteId==$m.id) selected=true #end value="$m.id">$m.siteName </option>
		                	#end
		                </select><a class="required"> *</a>
				  </li>
    			
   				#end
	            <li class="w520"><label>户籍地址：</label>
	            	<input class="text150" type="text" name="hrAddr" value="$!user.hrAddr" maxlength="255" />
	            </li>
	            
	            
	            
	            <li>
	            	<label>居住情况：</label>
	            	#set($items=$!categorys.get(105))
	            	<select class="select160" name="lifeCond" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.lifeCond}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
            </ul>
            #if(!${user.name})			       
	  		<div class="usertitle strong">添加社区(<a>*为必填项</a>)</div>
		  	<ul class="inpubox clearfix">
	            <li id="li">
	            	<label>社区选择：</label>
	    				<select class='ocountry select260 input' id="province" next="city">
		                	<option value="0">=请选择=</option>
		                </select>
		                <select class='ocountry select260 input' id="city" next="region">
		                    <option value="-1">=请选择=</option>
		                </select>
		                <select class='ocountry select260 input' id="region" next="street">
		                    <option value="-1">=请选择=</option>
		                </select>
		                <select class='ocountry select260 input' id="street" next="community">
		                    <option value="-1">=请选择=</option>
		                </select>
		                <select class='ocountry select260 input' id="community" name="communityId">
		                    <option value="-1">=请选择=</option>
		                </select><a class="required"> *</a><br/>
		               
				  </li>
    		</ul>
    		#else
    			<input type="hidden" id="community" name="communityId" value="$user.communityId"/>
    		#end
    		 #if(!${user.name})		
    		<div class="usertitle strong">照护人员信息</div>
	        <ul class="inpubox clearfix">
            <li>
            	<label>姓名：</label>
            	<input  class="text150 " name="nName" value="" maxlength="5" >
            </li>
            <li> <label>年龄：</label>
	            <input  class="text150 " name="nAge" value="" maxlength="3" >
            </li>
            <li>
	            <label>老人关系：</label>
	            <select class="select160" name="nRelation" id="">
            			<option >配偶</option>
            			<option >子女</option>
            			<option >孙辈子女</option>
            			<option >亲属</option>
            			<option >监护人</option>
	            </select>
            </li>
            <li>
	            <label>居住地址：</label>
	           <input class="text150" type="text" name="nAddr"  maxlength="255" />
            </li>
           
            <li>
	            <label>住宅电话：</label>
	            <input class="text150" type="text" name="nPhone"  maxlength="8" maxlength="12" />
            </li>
            <li>
	            <label>移动电话：</label>
	            <input class="text150" type="text" name="nMobilePhone" value="$!user.addr" maxlength="11" />
            </li>
            <li>
	            <label>照护内容：</label>
	            <select class="select160" name="nContent" id="">
            			<option >顾问或情感支持</option>
            			<option >个人生活照护</option>
            			<option >居家生活支持</option>
	            </select>
            </li>
            <li>
	            <label>照护时长：</label>
	           <input class="text150" type="text" name="nTimedate"  maxlength="8" />
            </li>
           
             
             <li>
	            <label>照护状态：</label>
	           <select class="select160" name="nState" id="">
            			<option >因健康原因无法对老人继续提供照护</option>
            			<option >家庭照护者得不到来自家庭成员或朋友的充分支援</option>
            			<option >家庭照护者表达其感到疲惫、情绪不稳定</option>
            			<option >无</option>
	            </select></li>
	               <li class="pianyi3">
            	<label >性别：</label>
            	<select  class="select160" name="nSex" id="">
            		<option >女</option>
            		<option >男</option>
            	</select></li>
            	<li >
            	<label>与老人住：</label>
            	<input type="radio" name="nliveTogether" value="是"> 是
            	<input type="radio" name="nliveTogether" value="否"> 否
            </li>
            </li>
        </ul>
	        #end
    		
        	<div class="usertitle strong">详细信息</div>
	        <ul class="inpubox clearfix">    
	            <li>
	            	<label>婚姻情况：</label>
	            	#set($items=$!categorys.get(102))
	            	<select class="select160" name="marry" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.marry}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            
	             <li>
	            	<label>宗教信仰：</label>
	            	#set($items=$!categorys.get(108))
	            	<select class="select160" name="religion" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.religion}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            
	            
	            <li>
	            	<label>联系电话：</label>
	            	<input class="text150" type="text" maxlength="11" name="contactPhone" value="$!user.contactPhone" maxlength="11" />
	        	</li>
	           	<li class="w520">
	            	<label>居住地址：</label>
	            	<input class="text150" type="text" name="addr" value="$!user.addr" maxlength="255" />
	            </li>
	            
	            <li>
	            	<label>从业情况：</label>
	            	#set($items=$!categorys.get(106))
	            	<select class="select160" name="jobCond" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.jobCond}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li>
	            	<label>经济来源：</label>
	            	#set($items=$!categorys.get(110))
	            	<select class="select160" name="income" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.income}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	             <li>
	            	<label>民&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;族：</label>
	            	#set($items=$!categorys.get(109))
	            	<select class="select160" name="nation" id="">
		            	#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.nation}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li>
	            	<label>医疗保障：</label>
	            	#set($items=$!categorys.get(107))
	            	<select class="select160" name="medical" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.medical}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	             <li>
	            	<label>政治面貌：</label>
	            	#set($items=$!categorys.get(103))
	            	<select class="select160" name="political" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.political}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li>
	            	<label>文化程度：</label>
	            	#set($items=$!categorys.get(104))
	            	<select class="select160" name="education" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.education}==$k)selected=true#end>$!items.get($k).itemName <!-- $!items.get($k).id --></option>
	            		#end
	            	</select>
	            </li>
	             <li>
	            	<label>户口类型：</label>
	            	#set($items=$!categorys.get(101))
	            	<select class="select160" name="hrType" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.hrType}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	           #if($user.mobilePhone)
	           			#if($user.rContact!='[]')
	                 		#foreach($rc in $user.rContact)
		                         <li><label>紧急联系人:</label> <input class="text150"
		                                    type="text" name="rContactName" value="$!rc.name" />
		                         </li>
		                         <li><label>紧急联系手机:</label> <input class="text150"
		                                    type="text" maxlength="11" name="rContactMobilePhone" value="$!rc.mobilePhone" /></li>
					               <input type="hidden"  name="rCName" id="rCName" />
				                   <input type="hidden"  name="rCPhone" id="rCPhone" />
	              			#end
	              		#else
	              			<li><label>紧急联系人:</label>
              			 		<input type="text" class="text150" name="rCName" /></li>
                 		<li><label>紧急联系手机:</label>
                 				<input type="text"  class="text150" name="rCPhone" /></li>
              			#end
              	#else
              		  <li><label>紧急联系人:</label>
              			 <input type="text" class="text150" name="rCName" /></li>
                 	<li><label>紧急联系手机:</label>
                 		<input type="text"  class="text150" name="rCPhone" /></li>
                 		  
	             #end
	        <!--	 <li>
	            	<label>紧急联系人:</label>
	            	<input class="text150" type="text"  name="rContact.name"   value="$!user.rContact.name" />
	        	</li>
	        	 <li>
	            	<label>紧急联系手机:</label>
	            	<input class="text150" type="text" maxlength="11" name="rContact.mobilePhone" id="mobilePhone_1"  value="$!user.rContact.mobilePhone"  />
	        	</li> -->
	        	<li  class="pianyi">
	            	<label >照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片：</label>
	            	<input class="text150" name="headFile" type="file">
	            	<input type="hidden" name="active" value="1">
	            	<input type="hidden" name="status" value="2">
	        	</li>
	        </ul>
	        
 	<div class="usertitle strong">特征信息</div>
        <ul class="inpubox clearfix">
            <li>
            	<label>三&nbsp;&nbsp;&nbsp;&nbsp;无：</label>
            	#set($items=$!categorys.get(111))
            	<select class="select160" name="specia.three" id="">
            		<option value="-1" #if($!{user.specia.three}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.three}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
            	</select>
            </li>
            
            <li>
            	<label>无保障：</label>
	            #set($items=$!categorys.get(113))
	            <select class="select160" name="specia.noSecurity" id="">
	            	<option value="-1" #if($!{user.specia.noSecurity}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.noSecurity}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
            	<label>失&nbsp;&nbsp;&nbsp;&nbsp;独：</label>
            	#set($items=$!categorys.get(117))
	            <select class="select160" name="specia.lostOnly" id="">
	            	<option value="-1" #if($!{user.specia.lostOnly}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.lostOnly}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
            	<label>优&nbsp;&nbsp;&nbsp;&nbsp;抚：</label>
            	#set($items=$!categorys.get(118))
	            <select class="select160" name="specia.specialCare" id="">
	            	<option value="-1" #if($!{user.specia.specialCare}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.specialCare}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
            	<label>失&nbsp;&nbsp;&nbsp;&nbsp;能：</label>
            	#set($items=$!categorys.get(112))
	            <select class="select160" name="specia.disable" id="">
	            	<option value="-1" #if($!{user.specia.disable}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.disable}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
            	<label>孤&nbsp;&nbsp;&nbsp;&nbsp;寡：</label>
            	#set($items=$!categorys.get(114))
	            <select class="select160" name="specia.lonely" id="">
	            	<option value="-1" #if($!{user.specia.lonely}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.lonely}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
            	<label>低&nbsp;&nbsp;&nbsp;&nbsp;保：</label>
            	#set($items=$!categorys.get(115))
	            <select class="select160" name="specia.lessIncome" id="">
	            	<option value="-1" #if($!{user.specia.lessIncome}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.lessIncome}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
            	<label>空&nbsp;&nbsp;&nbsp;&nbsp;巢：</label>
            	#set($items=$!categorys.get(116))
	            <select class="select160" name="specia.emptyNest" id="">
	            	<option value="-1" #if($!{user.specia.emptyNest}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.emptyNest}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
            	<label>独&nbsp;&nbsp;&nbsp;&nbsp;居：</label>
            	#set($items=$!categorys.get(119))
	            <select class="select160" name="specia.lifeLonely" id="">
	            	<option value="-1" #if($!{user.specia.lifeLonely}==-1)selected=true#end>全部</option>
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.lifeLonely}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
         </ul>   
					         
		
        <div  class="addbtn centerbtn">
        	<input class="button_gm" id="save" type="button" value="添加"/>
        	<button class="button_delete" type="button" onclick="javascript:window.history.go(-1)">取消</button>
        </div>
        </form>
    </div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".timedate").calendar({ format:'yyyy-MM-dd' });
});
// 校验身份证号
/* $("#idCard").blur(function(){
	var idCard = $("#idCard").val();
	var verify = isCardNo(idCard);
	if(verify){
		$.get("/community/user/verifyIdCard/"+idCard, function(data) {
			if(data.code==0){
				//alert("证件号可用");
			}else{
				alert(data.data[0]);
			}
		},"json");
	}
}); */
var mobile=0;
$("#mobilePhone").blur(function(){
	var mobilePhone = $("#mobilePhone").val();
	$.get("/community/user/verifymobilePhone/"+mobilePhone, function(data) {
		if(data.code==0){
			mobile=1;
			//alert("证件号可用");
		}else{
			alert(data.data[0]);
		}
	},"json");
	
});

	$("#save").click(function(){
		//--------------------新增----------------------
		var arr = new Array();
			var size = $("input[name='rContactName']").length;
			for(var i =0;i<size;i++){
				var urgentName = $("input[name='rContactName']").get(i).value;
				arr.push(urgentName);
			}
			var arrphone = new Array();
			var sizes = $("input[name='rContactMobilePhone']").length;
			for(var k =0;k<sizes;k++){
				var rContactMobilePhone = $("input[name='rContactMobilePhone']").get(k).value;
				arrphone.push(rContactMobilePhone);
			}
			$("#rCName").val(arr);
			$("#rCPhone").val(arrphone);
		//----------------------------------------------	
	
	
		var idCard = $("#idCard").val().length;
		var birthday =$('#birthday').val().length;
		var mobilePhone = $("#mobilePhone").val().trim();
	 	var reg = mobilePhone.length;  
			if(idCard!=18){
					alert("身份证不合法");
			}else{
				if(reg!=11){
					alert("请输入11位手机号");
				}else{
					if(($('#community').val())!=-1&&mobilePhone.length==11){
						if($('select[name=siteId]').val()!=0&&birthday==10){
							$('#saveUser').submit();
						}else{
							alert("请查看生日，站点是否已选！");
						}
					}else{
						alert("请查看手机号码是否正确或社区是否选择！");
					}
					
				}
			}
	});

	
</script>
</body>
</html>