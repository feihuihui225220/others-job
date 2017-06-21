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
    <script src="/assets/js/country.js"></script>
</head>
<body>

<div class="wrapper">
	<br/>
	#set($us=$session.getAttribute("sessionUser"))
	#if($us.getName()==$!{user.name})
   	 #parse("/common/head.tpl")
	#end
    
    <div class="bodyline ">
   
        <div class="usertitle strong">基础信息</div>
        <form action="/user/update/too" id="saveUser" method="post" enctype="multipart/form-data">
						        <ul class="inpubox clearfix">
						        	<input type="hidden" name="id" value="$!user.id"/>
						            <li><label>姓名：</label>
						            <input class="text150" type="text" name="name" value="$!user.name" /></li>
						            <li><label>身份证号：</label>
						            <input class="text150" type="text" #if($user.idCardNo) disabled #end name="idCardNo" maxlength="18" id="idCard" value="$!user.idCardNo" /></li>
						            <li>
						            	<label>性别：</label>
						            	<select style="width:120px;" class="select160" name="gender" id="">
						            		<option value="0" #if($!{user.gender}==0)selected=true#end>女</option>
						            		<option value="1" #if($!{user.gender}==1)selected=true#end>男</option>
						            	</select></li>
						            <li><label>出生日期：</label>
						            <input class="text150 timedate" id="birthday" type="text" value="$!date.format('yyyy-MM-dd',$!user.birthday)"  name="birthday"/></li>
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
						            	<label>户口类型：</label>
						            	#set($items=$!categorys.get(101))
						            	<select class="select160" name="hrType" id="">
						            		#foreach($!k in $!items.keySet())
						            			<option value="$!items.get($k).id" #if($!{user.hrType}==$k)selected=true#end>$!items.get($k).itemName</option>
						            		#end
						            	</select>
						            </li>
						            <li class="w520"><label>户籍地址：</label>
						            	<input class="text150" type="text" name="hrAddr" value="$!user.hrAddr"/>
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
						            	<label>手机：</label>
						            	<input class="text150" type="text" id="mobilePhone" name="mobilePhone"  value="$!user.mobilePhone" disabled/>
						        	</li>
						            <li>
						            	<label>联系电话：</label>
						            	<input class="text150" type="text" name="contactPhone" value="$!user.contactPhone"/>
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
						            			<option value="$!items.get($k).id" #if($!{user.education}==$k)selected=true#end>$!items.get($k).itemName</option>
						            		#end
						            	</select>
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
						            	<label>民族：</label>
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
						          	<li class="w520">
						            	<label>居住地址：</label>
						            	<input class="text150" type="text" name="addr" value="$!user.addr"/>
						            </li>
						        	<li>
						            	<label>照片：</label>
						            	<input class="text150" name="headFile" type="file">
						            	<input type="hidden" name="active" value="1">
						            	<input type="hidden" name="status" value="2">
						        	</li>
						        	 <li>
						            	<label>紧急联系人:</label>
						            	<input class="text150" type="text"  name="rContact.name"   value="$!user.rContact.name" />
						        	</li>
						        	 <li>
						            	<label>紧急联系手机:</label>
						            	<input class="text150" type="text" maxlength="11" name="rContact.mobilePhone" id="mobilePhone_1"  value="$!user.rContact.mobilePhone"  />
						        	</li>
						        </ul>
					 <div class="usertitle strong">特征信息</div>
					        <ul class="inpubox clearfix">
					            <li>
					            	<label>三无：</label>
					            	#set($items=$!categorys.get(111))
					            	<select class="select160" name="three" id="">
					            		<option value="-1" #if($!{user.specia.three}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.three}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
					            	</select>
					            </li>
					            
					            <li>
					            	<label>无保障：</label>
						            #set($items=$!categorys.get(113))
						            <select class="select160" name="noSecurity" id="">
						            	<option value="-1" #if($!{user.specia.noSecurity}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.noSecurity}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
						            </select>
					            </li>
					            <li>
					            	<label>失独：</label>
					            	#set($items=$!categorys.get(117))
						            <select class="select160" name="lostOnly" id="">
						            	<option value="-1" #if($!{user.specia.lostOnly}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.lostOnly}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
						            </select>
					            </li>
					            <li>
					            	<label>优抚：</label>
					            	#set($items=$!categorys.get(118))
						            <select class="select160" name="specialCare" id="">
						            	<option value="-1" #if($!{user.specia.specialCare}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.specialCare}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
						            </select>
					            </li>
					            <li>
					            	<label>失能：</label>
					            	#set($items=$!categorys.get(112))
						            <select class="select160" name="disable" id="">
						            	<option value="-1" #if($!{user.specia.disable}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.disable}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
						            </select>
					            </li>
					            <li>
					            	<label>孤寡：</label>
					            	#set($items=$!categorys.get(114))
						            <select class="select160" name="lonely" id="">
						            	<option value="-1" #if($!{user.specia.lonely}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.lonely}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
						            </select>
					            </li>
					            <li>
					            	<label>低保：</label>
					            	#set($items=$!categorys.get(115))
						            <select class="select160" name="lessIncome" id="">
						            	<option value="-1" #if($!{user.specia.lessIncome}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.lessIncome}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
						            </select>
					            </li>
					            <li>
					            	<label>空巢：</label>
					            	#set($items=$!categorys.get(116))
						            <select class="select160" name="emptyNest" id="">
						            	<option value="-1" #if($!{user.specia.emptyNest}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.emptyNest}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
						            </select>
					            </li>
					            <li>
					            	<label>独居：</label>
					            	#set($items=$!categorys.get(119))
						            <select class="select160" name="lifeLonely" id="">
						            	<option value="-1" #if($!{user.specia.lifeLonely}==-1)selected=true#end>全部</option>
					            		#foreach($!k in $!items.keySet())
					            			<option value="$!items.get($k).id" #if($!{user.specia.lifeLonely}==$k)selected=true#end>$!items.get($k).itemName</option>
					            		#end
						            </select>
					            </li>
					        </ul>
	  	<div class="usertitle strong">添加社区</div>
		  <ul class="inpubox clearfix">
	            <li id="li">
	            	<label>请选择：</label>
	    				<select class='ocountry' id="province" next="city">
		                	<option value="0">=请选择=</option>
		                </select>
		                <select class='ocountry' id="city" next="region">
		                    <option value="-1">=请选择=</option>
		                </select>
		                <select class='ocountry' id="region" next="street">
		                    <option value="-1">=请选择=</option>
		                </select>
		                <select class='ocountry' id="street" next="community">
		                    <option value="-1">=请选择=</option>
		                </select>
		                <select class='ocountry' id="community" name="communityId">
		                    <option value="-1">=请选择=</option>
		                </select>
				  </li>
    		</ul>
    		#set($user=$session.getAttribute("sessionUser"))
   			#if($user.getCateEnum()=="PRO")
				<div class="usertitle strong">添加站点</div>
				   	 <ul class="inpubox clearfix">
	            <li id="li">
	            	<label>请选择：</label>
	    				<select name="siteId" class='site' id="site" >
		                	<option  value="0">=请选择=</option>
		                	#foreach($m in $mVenderSiteList)
		                	<option value="$m.id">$m.siteName </option>
		                	#end
		                </select>
				  </li>
    		</ul>		
   			#end
       
       
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
$("#idCard").blur(function(){
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
});

	$("#save").click(function(){
		var idCard = $("#idCard").val().length;
		var mobilePhone = $("#mobilePhone").val().trim();
	 	var reg = mobilePhone.length;  
		if(idCard!=18){
				alert("身份证不合法");
			}else{
				if(reg!=11){
					alert("请输入11位手机号");
				}else{
					alert("ok");
					//$('#saveUser').submit();
				}
		}
	});

	
</script>
</body>
</html>