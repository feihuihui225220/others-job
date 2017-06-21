<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>专业服务-客户管理</title>
<link rel="stylesheet" type="text/css" href="/assets/director/style/userManager.css">
     <script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/assets/director/js/userManager.js"></script>
</head>
<body>
#parse("/common/dtop.tpl")
<div class="main" style="margin-left:15px;">
	#parse("/common/dirleft.tpl")
	#set ($sessionUser=$!{session.getAttribute("sessionUser")})
  <div class="main_right">
  	<div class="wrapLeft fl">
      <div class="rightTitle">
      <form method="post" id="SelectUser" action="/director/dirAssociate/plan"  >
        <select name="status" class="selectSize">
	   		<option #if($status==99) selected = "selected" #end value="">请选择</option>
	   		<option #if($status==0) selected = "selected" #end value="0">待建档</option>
	   		<option  #if($status==1) selected = "selected" #end  value="1">正常巡诊</option>
	   		<option  #if($status==2) selected = "selected" #end  value="2">转诊</option>
	   		<option  #if($status==3) selected = "selected" #end  value="3">停诊</option>
	   		<option  #if($status==4) selected = "selected" #end  value="4">会诊</option>
   		</select>
        <input type="submit"   class="btnBg" value="查询" />
   		<input type="button" id="dayin"   class="btnBg" value="打印今日用户列表">
       </form>
      </div>
      <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="commonTable">
      <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>住址</th>
        <th>联系方式</th>
        <th>时间</th>
        <th>用户状态</th>
      </tr>
     #foreach($u in $page.result)
   			  #set($i = $velocityCount + 1)
   			 #if($!{u.user.state}==0)
   			 <tr class="pointer1" date-href="/director/user?userId=$!{u.user.id}">
   			 #elseif($!{u.user.state}==1)
   			 <tr class="pointer1" date-href="/visit/planByUserId?userId=$!{u.user.id}">
   			 #elseif($!{u.user.state}==2)
   			 <tr class="pointer1" date-href="/director/HTransfer?userId=$!{u.user.id}">
   			 #elseif($!{u.user.state}==3)
   			 <tr class="pointer1" date-href="/visit/planByUserId?userId=$!{u.user.id}">
   			 #elseif($!{u.user.state}==4)
   			 <tr class="pointer1" date-href="/consu/pageResult?userId=$!{u.user.id}">
   			 #end
   			 
			<td>$i</td>   			
   			<td>$!{u.user.name}</td>
			<td> #if($!{u.user.gender}==0)女#else男#end</td>
            <td> $!{u.user.addr} </td>
            <td> $!{u.user.mobilePhone} </td>
            <td> $date.format("yyyy-MM-dd hh:mm",$!{u.visitTime}) </td>
            <td>#if($!{u.user.state}==0)待建档 #elseif($!{u.user.state}==1)正常巡诊 
            #elseif($!{u.user.state}==2)转诊 #elseif($!{u.user.state}==3)停诊
             #elseif($!{u.user.state}==4)会诊#end </td>			
   			<tr>
   			#end
    </table> 
    <div class="page fr">
       	 #parse("/common/page.tpl")
      </div>  
    </div>  
    <div class="wrapRight fr">
     <a href="#" class="newUser">新用户登记</a>
     <div class="info">
	#foreach($u in $hConsultations)
				 #set($i = $velocityCount + 1)
      <p><i class="dot"></i>您好，你所在巡诊组于$!date.format('yyyy-MM-dd',$!u.applyTime)对$!u.user.name提出的会诊需求已获批，会诊时间定于$!date.format('yyyy-MM-dd',$!u.applyTime) $!date.format('HH:mm',$!u.applyTime)地址：$!u.address</p>
     #end
     </div>
    </div> 
  </div>
   	
   	
</div>

<div class="addUser">
<form role="form" id="addUserFrom" method="post" action="/director/addRUser">
  <div class="title">
    <span class="fl span_add">添加用户</span>
    <span class="fr close"></span>
  </div>
  <div class="userInfo">
  
    <div><label class="addUser_span">姓名:</label><input type="text" id="name" name="name" placeholder="只能输入中文或字母" class="addUser_input_2 addUser_input_ addUser_input" /></div>
    <div><label class="addUser_span">性别:</label><select class="addUser_select_ addUser_select_2 addUser_select" id="gender" name="gender"><option value="0">女</option><option value="1">男</option></select></div>
 
    <div><label class="addUser_span">年龄:</label><input type="text" id="age" name="age" placeholder="只能输入数字" onkeyup="value=value.replace(/[^\d]/g,'') " class="addUser_input_2 addUser_input_ addUser_input" /></div>
    <div><label class="addUser_span">身份证号:</label><input type="text" id="idCardNo" name="idCardNo" class="addUser_input_2 addUser_input_ addUser_input" /></div>
    <div><label class="addUser_span">家庭住址:</label><input type="text" name="addr" id="addr" class="addUser_input_2 addUser_input_ addUser_input" /></div>
    <div><label class="addUser_span">联系电话:</label><input type="text" name="mobilePhone" id="mobilePhone" class="addUser_input_2 addUser_input_ addUser_input" /></div>
    <div><label class="addUser_span">社区:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select class='addUser_select1' id="province" next="city">
		                	<option value="0">请选择</option>
		                </select>
		                <select class='addUser_select1' id="city" next="region">
		                    <option value="-1">请选择</option>
		                </select>
		                <select class='addUser_select1' id="region" next="street">
		                    <option value="-1">请选择</option>
		                </select>
		                <select class='addUser_select1' id="street" next="community">
		                    <option value="-1">请选择</option>
		                </select>
		                <select class='addUser_select1' id="community" name="communityId">
		                    <option value="-1">请选择</option>
		                </select><br/>
    </div>

    <div><label class="addUser_span">用户状态:</label>&nbsp;&nbsp;&nbsp;<select name="state"  class="addUser_select"><option value="0">待建档</option><option value="1">正常巡诊</option><option value="2">转诊</option><option value="3">停诊</option><option value="4">会诊</option></select></div>
    <div><label class="addUser_span">登记人:</label><label class="registerPerson">$sessionUser.name</label></div>
  </div>
  <button type="button" class="aUser btnBg btnlg">确认</button>
  <button type="button" class="btnBg btnBg1 cancel_all" data-dismiss="modal">取消</button>
  </form>
</div>
<div class="mask"></div>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/country_1.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/jquery.jqprint-0.3.js"></script>
<script>
var ok3=false;
var ok1=false;
var ok2=false;
var ok5=false;
var ok4=false;
var ok6=false;
$("#idCardNo").blur(function(){

 		var idCardNo = $("#idCardNo").val();
		var verify = isCardNo(idCardNo);
		if(verify){
			$.get("/community/user/verifyIdCard/"+idCardNo, function(data) {
				if(data.code==0){
					ok3=true;
				}else{
					alert(data.data[0]);
					return false;
				}
			},"json");
		}
		return false;
		
});
function isCardNo(card){  
		   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
		   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
		   if(reg.test(card) === false){  
		       alert("身份证输入不合法");  
		       $("#idCardNo").val("");
		       return  false;  
		   }
	   return true;
}
$("#mobilePhone").blur(function(){
		var mobile=0;
		var mobilePhone = $("#mobilePhone").val();
		var pattern = /^1[34578]\d{9}$/;
		if(!pattern.test(mobilePhone)){
			alert("手机号码格式不对！");
			  ok5=false;
		}else{
			$.get("/community/user/verifymobilePhone/"+mobilePhone, function(data) {
				if(data.code==0){
					mobile=1;
					 ok5=true;
				}else{
					$("#mobilePhone").val("");
					alert(data.data[0]);
					 ok5=false;
				}
			},"json");
		};

});

$(document).ready(function(){
	$(".main .main_left .sidebar li a").eq(0).addClass("active");
	$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
	$("#dayin").click(function(){
		$("#commonTable").jqprint(); 
	});
		$(".aUser").click(function(){
		var  name=$('#name').val();
		var re = /^[\u4e00-\u9fa5a-z]+$/gi;//只能输入汉字和英文字母
		if (!re.test(name)) {
			alert("姓名中不能包含特殊字符，只能输入汉字或者英文字母");
			ok1=false;
	    }else{
	    	ok1=true;
	    };
	    if(name.length>20){
	    	alert("姓名的长度过长!");
	    	 ok1=false;
	    }else{
	    	ok1=true;
	    };
	    var  age=$('#age').val();
	     if(age>=120||age<18){
	    	alert("请输入合法的年龄");
		  	 ok2=false;
		 }else{
		 	ok2=true;
		 };
	   
		var  addr=$('#addr').val();
			if(addr==""){
				alert("请输入家庭住址!");
				ok4=false;
			}else{
				ok4=true;
			};
			if(addr.length>30){
				alert("输入家庭住址过长!");
				 ok4=false;
			}else{
				ok4=true;
			};
		
		var community=$('#community').val();
		if(community==-1){
			alert("请选择社区!");
			  ok6=false;
		}else{
			 ok6=true;
		};
		if(ok1 && ok2 && ok3 && ok4 && ok5 && ok6){
			$('#addUserFrom').submit();
		}
	});
});


</script>
</body>
</html>