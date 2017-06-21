<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>编辑客户信息</title>
#parse("/common/top.tpl")
<script type="text/javascript" src="../../assets/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/assets/js/country_1.js"></script>
<style>
	li{list-style: none;}
</style>
<style>
.bodyline {width:1000px;margin-left: 20%;border: 1px solid #ddd;padding-bottom: 20px;}
.usertitle {color: #333;line-height: 30px;border-bottom: 1px solid #ddd;font-size: 16px;}
.strong {padding-left:8px;font-weight: 900;}
a:hover { text-decoration: none;}
a { color: red;}
a { color: black;}
a { text-decoration: none;color: #333;}
a { text-decoration: none;color: #333;}
.clearfix {display: block;}
.inpubox {padding: 5px;}
ol, ul {list-style: none;}
ul, menu, dir { display: block;  list-style-type: disc;    -webkit-margin-before: 1em;    -webkit-margin-after: 1em;
    -webkit-margin-start: 0px;    -webkit-margin-end: 0px;    -webkit-padding-start: 40px;}
input {-webkit-appearance: textfield;    background-color: white;    -webkit-rtl-ordering: logical;
    user-select: text;    cursor: auto;    padding: 1px;    border-width: 2px;
    border-style: inset;    border-color: initial;    border-image: initial;}
.inpubox li label {white-space:nowrap;display: inline-block;width:85px;text-align:right;}
.inpubox li {float:left;padding: 5px;    line-height: 14px; overflow: hidden;}
ul.inpubox.clearfix1{height:100px;display:block;}
ul.inpubox.clearfix2 {height:170px;display:block;}
.text150 { width: 150px;  padding: 3px;}
.w520 .text150 {width:420px;}
.clearfix2 li{width:260px;}
.clearfix li{width:260px;}
.select160{height:25px;width:160px;}
.clearfix:after {
    content: "";
    display: block;
    height: 0;
    visibility: hidden;
   
}
.centerbtn {
    text-align: center;
}
.button_gm {
    font-size: 12px;
    background-image: url(/assets/newImg/btn.png);
    width: 75px;
    height: 25px;
    border: 0px;
    color: #EBF8FB;
}
.rightbtn button, .centerbtn button {
    /* width: 100px; */
    margin-left: 10px;
    cursor: pointer;
}
.button_delete {
    font-size: 12px;
    background: #7A9292;
    width: 75px;
    height: 25px;
    border: 0px;
    color: #EBF8FB;
}
</style>
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div style="margin: 0 auto;margin-left:180px;" class="bodyline">
 <div class="usertitle strong ">基础信息(<a>*为必填项</a>)</div>
        <form action="/customer/save" id="saveUser" method="post" enctype="multipart/form-data">
	        <ul class="inpubox clearfix1">
	        	<input type="hidden" name="id" value="$!user.id"/>
	            <li><label>姓&nbsp;&nbsp;名：</label>
	            <input class="text150" type="text" name="name" value="$!user.name"/><a class="required"> *</a></li>
	            <li><label>身份证号：</label>
	            <input class="text150" type="text"  name="idCardNo" maxlength="18" id="idCard" value="$!user.idCardNo" #if($!user.idCardNo)readOnly="true"  #end/><a class="required"> *</a></li>
	            <li>
	            	<label>性&nbsp;&nbsp;别：</label>
	            	<select class="select160" name="gender" id="">
	            		<option value="0" #if($!{user.gender}==0)selected=true#end>女</option>
	            		<option value="1" #if($!{user.gender}==1)selected=true#end>男</option>
	            	</select><a class="required"> *</a></li>
	            <li><label>出生日期：</label>
	            <input class="text150 timedate" id="birthday" type="text" value="$!date.format('yyyy-MM-dd',$!user.birthday)"  name="birthday"/><a class="required"> *</a></li>
	            <li>
	            	<label>手&nbsp;&nbsp;机：</label>
	            	<input class="text150" type="text" maxlength="11" name="mobilePhone" id="mobilePhone"  value="$!user.mobilePhone" #if($user.mobilePhone) readOnly="true"  #end/><a class="required"> *</a>
	        	</li>
	           
	          <!--  #set($us=$session.getAttribute("sessionUser")) -->
   				<!-- #if($us.getCateEnum()=="PRO") -->
	            <li>
	            	<label>站&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：</label>
	    				<select name="siteId" class='select160 site' id="site" >
		                	<option  value="0">=请选择=</option>
		                	#foreach($m in $mVenderSiteList)
		                	<option #if($mUserVender.siteId==$m.id) selected=true #end value="$m.id">$m.siteName </option>
		                	#end
		                </select><a class="required"> *</a>
				  </li>
    			
   			<!-- 	#end -->
   			 <li>
	            	<label>居住情况：</label>
	            	#set($items=$!categorys.get(105))
	            	<select class="select160" name="lifeCond" id="">
	            		#foreach($!k in $!items.keySet())
	            			<option value="$!items.get($k).id" #if($!{user.lifeCond}==$k)selected=true#end>$!items.get($k).itemName</option>
	            		#end
	            	</select>
	            </li>
	            <li class="w520"><label>户籍地址：</label>
	            	<input class="text150" type="text" name="hrAddr" value="$!user.hrAddr"/>
	            </li>
	            
	            
	            
	           
            </ul>
            #if(!${user.name})       
	  		<div class="usertitle strong">添加社区(<a>*为必填项</a>)</div>
		  	<ul class="inpubox">
	           
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
				 
    		</ul>
    		#else
    			<input type="hidden" id="community" name="communityId" value="$user.communityId"/>
    		#end
    		 #if(!${user.name})		
    		<div class="usertitle strong">照护人员信息</div>
	        <ul class="inpubox" style="height:130px;">
            <li>
            	<label>姓名：</label>
            	<input  class="text150 " name="nName" value="">
            </li>
            <li> <label>年龄：</label>
	            <input  class="text150 " name="nAge" value="">
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
	           <input class="text150 dizhi" type="text" name="nAddr" />
            </li>
           
            <li>
	            <label>住宅电话：</label>
	            <input class="text150" type="text" name="nPhone" />
            </li>
            <li>
	            <label>移动电话：</label>
	            <input class="text150" type="text" name="nMobilePhone" value="$!user.addr"/>
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
	           <input class="text150" type="text" name="nTimedate" />
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
	        <ul class="inpubox clearfix2">    
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
	            	<input class="text150" type="text" maxlength="11" name="contactPhone" value="$!user.contactPhone"/>
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
	            	<label>民&nbsp;&nbsp;族：</label>
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
	        	<!-- <li>
	            	<label>紧急联系人:</label>
	            	<input class="text150" type="text"  name="rContact.name"   value="$!user.rContact.name" />
	        	</li>
	        	 <li>
	            	<label>紧急联系手机:</label>
	            	<input class="text150" type="text" maxlength="11" name="rContact.mobilePhone" id="mobilePhone_1"  value="$!user.rContact.mobilePhone"  />
	        	</li>-->
	        	<input type="hidden" value="$!user.rContact" id="rcUser" />
	        	#if($user.rContact=='[]')
	        		<li><label>紧急联系人:</label> <input class="text150" type="text"
	        			 name="rCName" value="$!rc.name" />  </li>
                                <li><label>紧急联系手机:</label> <input class="text150"
                                    type="text" maxlength="11" name="rCPhone"
                                    value="$!rc.mobilePhone" /></li>
	        	#else
	        	  #foreach($rc in $user.rContact)
                                <li><label>紧急联系人:</label> <input class="text150"
                                    type="text" name="rContactName" value="$!rc.name" />
                                </li>
                                <li><label>紧急联系手机:</label> <input class="text150"
                                    type="text" maxlength="11" name="rContactMobilePhone"
                                    value="$!rc.mobilePhone" /></li>
                   #end  
                                  <input type="hidden" name="rCName" id="rCName" />
                                  <input type="hidden" name="rCPhone" id="rCPhone" />
	        	#end
	        	<li  class="pianyi">
	            	<label >照&nbsp;&nbsp;片：</label>
	            	<input class="text150" name="headFile" type="file">
	            	<input type="hidden" name="active" value="1">
	            	<input type="hidden" name="status" value="2">
	        	</li>
	        	 <li class="w520 dizhi" style="width:525px;">
	            	<label>居住地址：</label>
	            	<input class="text150" type="text" name="addr" value="$!user.addr"/>
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
        	<input class="button_gm" id="save" type="submit" value="添加"/>
        	<button class="button_delete" type="button" onclick="javascript:window.history.go(-1)">取消</button>
        </div>
        </form>
    </div> 
</body>
<script>
	$(function(){
		$(".inpubox:eq(0) input").attr("required", "required");
		$(".sidebar li a").eq(2).css("background-color","#16A5AD").css("color","#fff");
		$("#save").click(function(){
			var rcUser = $("#rcUser").val();
			if(rcUser!="[]"||rcUser!=""){
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
			}
		})
	});
</script>
</html>