<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>编辑客户信息</title>
#parse("/common/top.tpl")
 <script type="text/javascript" src="../../assets/director/js/jquery-1.12.4.min.js"></script>
 <script type="text/javascript" src="/assets/js/country_1.js"></script>
 <script type="text/javascript" src="/assets/js/calendar.js"></script>
 <script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
 <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICleft.tpl")
<div  style="margin: 0 auto;width: 800px;">
    <div>
           	<br/><br/><a href="/customer/modifyHtml?id=${user.id}">编辑</a>
            <div class="actboxlist">
                <label>个人信息</label>
                	<!-- #set($us=$session.getAttribute("sessionUser"))
                	#if($us.getName()==$!{user.createdBy}) -->
                		<!-- <button  id="compile">编辑</button> -->
                	<!-- #end -->
                <hr/>
                <div class="actbox8 ">
                    <table class="table100 usertable">
                        <tr>
                        	<td>姓名：$!{user.name}</td>
                        	<td>婚姻状况：$!{categoryItems.get($!user.marry).itemName}</td>
                        	<td>街道名称：
                        	#if(${ocountry.fullNames.size()}>=4)
                        	$!{ocountry.fullNames[4]}
                        	#end
                        	</td>
                        </tr>
                        <tr>
                        	<td>身份证号：$!{user.idCardNo}</td>
                        	<td>手机：$!{user.mobilePhone}</td>
                        	<td>社区名称：
                        	#if(${ocountry.fullNames.size()}>=6)
                        	$!{ocountry.fullNames[5]}
                        	#end
                        	</td>
                        </tr>
                        <tr>
                        	<td>性别：#if($!{user.gender}==0)女#else男#end</td>
                        	<td>联系电话：$!{user.contactPhone}</td>
                        	<td>居住地址：$!{user.addr}</td>
                        </tr>
                        <tr>
                        	<td>出生日期：$!date.format('yyyy-MM-dd',$!user.birthday)</td>
                        	<td>政治面貌：$!{categoryItems.get($!user.political).itemName}</td>
                        	<td>居住情况：$!{categoryItems.get($!user.lifeCond).itemName}</td>
                        </tr>
                        <tr>
                        	<td>年龄：$!{user.age}</td>
                        	<td>文化程度：$!{categoryItems.get($!user.education).itemName}</td>
                        	<td>从业状况：$!{categoryItems.get($!user.jobCond).itemName}</td>
                       	</tr>
                        <tr>
                        	<td>宗教信仰：$!{categoryItems.get($!user.religion).itemName}</td>
                        	<td>民族：$!{categoryItems.get($!user.nation).itemName}</td>
                        	<td>经济来源：$!{categoryItems.get($!user.income).itemName}</td>
                        </tr>
                        <tr>
                        	<td>户口类型：$!{categoryItems.get($!user.hrType).itemName}</td>
                        	<td>省市名称：#if(${ocountry.fullNames.size()}>=2)$!{ocountry.fullNames[1]}#end</td>
                        	<td>医疗保障：$!{categoryItems.get($!user.medical).itemName}</td>
                        </tr>
                        <tr>
                        	<td>区县名称：
                        	#if(${ocountry.fullNames.size()}>=4)
                        	$!{ocountry.fullNames[3]}</td>
                    		#end
                        	#foreach($rc in $user.rContact)
                        	<td>紧急联系人：$!{rc.name}</td>
                        	<td>紧急联系电话：$!{rc.mobilePhone}</td>
                        	 #end  
                       	</tr>
                       	 #if($categoryItems)
                        <tr>
                        	<td>三无：$!{categoryItems.get($!user.specia.three).itemName}</td>
                        	<td>失能：$!{categoryItems.get($!user.specia.disable).itemName}</td>
                        	<td>无保障：$!{categoryItems.get($!user.specia.noSecurity).itemName}</td>
                        </tr>
                        <tr>
                        	<td>孤寡：$!{categoryItems.get($!user.specia.lonely).itemName}</td>
                        	<td>低保：$!{categoryItems.get($!user.specia.lessIncome).itemName}</td>
                        	<td>空巢：$!{categoryItems.get($!user.specia.emptyNest).itemName}</td>
                        </tr>
                        <tr>
                        	<td>失独：$!{categoryItems.get($!user.specia.lostOnly).itemName}</td>
                        	<td>优抚：$!{categoryItems.get($!user.specia.specialCare).itemName}</td>
                        	<td>独居：$!{categoryItems.get($!user.specia.lifeLonely).itemName}</td>
                        </tr>
                        <tr>
                        	<td>户籍地址：$!{user.hrAddr}</td><td></td><td></td>
                        </tr>
                    #end
                    </table>
                </div>
                <br/><br/><br/>
               
            </div>
        </div>
        
    </div>
</body>
</html>