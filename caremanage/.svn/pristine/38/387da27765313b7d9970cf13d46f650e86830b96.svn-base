#set ($sessionUser=$!{session.getAttribute("sessionUser")})
 #if($!{sessionUser.getCateEnum()}=="PRO")
<link rel="stylesheet" href="/assets/newCss/common.css" />
<style>
	#U_name{
		cursor: text;
	}
	#U_name:hover{
		text-decoration:none;
	}
</style>
<!--[if IE 6]>
<script type="text/javascript" src="/assets/js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<script>
DD_belatedPNG.fix('.ie6png','background');
</script>

<script language="javascript" type="text/javascript">
$(document).ready(function (){
         #if($!{sessionUser.getCateEnum()}=="PRO")
        
        #else
         $(".header ul li").each(function(index){
                $(this).click(function(){        
                $(".header ul li").removeClass("first");
                $(".header ul li").eq(index).addClass("first");
                });
                });
        });
        #end
        //16A4AD
</script>
<![endif]-->
<!-- <script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?04ca4be2584991d69bda41436ea1bcf2";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script> -->
<div class="wrapper">	
     <div id="top">
        <div class="logo fl" ><img src="/assets/newImg/logo.png"></div>
        <div class="topmid fl">
            <div class="nav" style="">
                #if ($!{sessionUser.getResources()})
                <ul>
	           		#foreach ($res in ${sessionUser.getResources()})
	           			#if($!{res.getUserCategory()}!=-1)
                	<li><a href="$!{res.getUrl()}">$!{res.getName()}</a></li>
	           			#end
	        		#end
                </ul>
           		#end
            </div>
        </div>
        <div class="topright fr">
            <a href="#" class="userlogin" id="U_name">欢迎您，<span>$!{sessionUser.getName()}</span></a>
            <a href="/permission/toReset" class="userset">修改密码</a>
            <a href="/permission/logout" class="loginout">注销</a>
        </div>
    </div>				
	
 </div>
#else
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
#if($sessionUser)
<!--[if IE 6]>
<script type="text/javascript" src="/assets/js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<script>
DD_belatedPNG.fix('.ie6png','background');
</script>

<script language="javascript" type="text/javascript">
$(document).ready(function (){
         #if($!{sessionUser.getCateEnum()}=="PRO")
        
        #else
         $(".header ul li").each(function(index){
                $(this).click(function(){        
                $(".header ul li").removeClass("first");
                $(".header ul li").eq(index).addClass("first");
                });
                });
        });
        #end
        //16A4AD
</script>
<![endif]-->
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?04ca4be2584991d69bda41436ea1bcf2";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<div class="wrapper">

	#if($!{sessionUser.getCateEnum()}=="USER")
	<div class="header">

		#else
		<div class="header" style="#if($!{sessionUser.getCateEnum()}==" PRO") height: 100px;   #else  background: #16A5AD; height: 80px;padding-left:20px;#end ">

			#end
			<ul class="nav0 #if($!{sessionUser.getCateEnum()}==" PRO") nav2 #else nav1_1  #end"#if($!{sessionUser.getCateEnum()}!=" PRO") style="position: relative; top:25px;"#end >
				<!-- 最后一个li 有class=act -->
				<!--<li class="act"><a href="">用户管理</a></li>-->
				#if ($!{sessionUser.getResources()})
				#if($!{sessionUser.getCateEnum()}=="USER") #foreach ($res in
				${sessionUser.getResources()}) #if($!sessionUser.idCardNo &&
				${res.getName()}!="完善资料")
				<li class="first"><a href="$!{res.getUrl()}">$!{res.getName()}</a></li>
				#elseif(!$sessionUser.idCardNo)
				<li class="first"><a
					href="javascript:location.href='/user/professional/datum'">完善资料</a></li>
				#break #end #end #elseif($!{sessionUser.getCateEnum()}=="PRO")
				<img
					style="width: 246px; height: 70px; float: left; margin-top: 15px;"
					src="/assets/newImg/lehuotang.png" /> #foreach ($res in
				${sessionUser.getResources()}) #if($!{res.getUserCategory()}!=-1)
				<li class="first" style="height: 100px;"><img class="topImg"
					src="$!res.imgUrl" /> &nbsp;<a class="headera impa"
					href="$!{res.getUrl()}">$!{res.getName()}</a></li> #end #end #else
				#foreach ($res in ${sessionUser.getResources()})
				<li class="first"><a href="$!{res.getUrl()}">
						$!{res.getName()}</a></li> #end #end
				#if($!{sessionUser.getCateEnum()}=="USER")
				<li class="position" style="float: right"><p class="width">
						欢迎您，$!{sessionUser.getName()}<a href="/permission/toReset">修改密码</a><a
							href="/permission/logout">注销</a>
					</p>
				<li>
				#else
				<li class="user_no"style="float: right; position: relative; top: -15px;left:-5px;color:white;"><p>
						欢迎您，$!{sessionUser.getName()}<a href="/permission/toReset">修改密码</a><a
							href="/permission/logout">注销</a>
					</p>
				<li>#end #end
			</ul>
		</div>
	</div>
	#if($!{sessionUser.getCateEnum()}=="CC") #set($searchUserVo=$!{session.getAttribute("searchUserVo")})
	<style>
.label {
	display: inline-block;
	width: 60px;
	text-align: right;
}

#searchInfo {
	width: 100%;
	height: 80px;
}

.infoblock {
	width: 25%;
	float: left;
}

.infoblock p {
	margin: 10px 0 0 20px;
}
</style>
	<script src="$request.contextPath/assets/js/common.js"></script>
	<script src="$request.contextPath/assets/js/jquery.validate.js"></script>

	url:"/callCenter/searchUser"

	<div id="CallInfo"
		style="width: 400px; margin: auto; border: #69C solid 3px; position: absolute; top: 200px; left: 50%; margin-left: -200px; background-color: #FFF; display: none;">
		<h3>来电信息</h3>
		<p>
			<span>身份证：</span><span id="cardNo"></span>
		</p>
		<p>
			<span>电话：</span><span id="phone"></span>
		</p>
		<p>
			<span>姓名：</span><span id="name"></span>
		</p>
		<p>
			<span>性别：</span><span id="gender"></span>
		</p>
		<p>
			<span>年龄：</span><span id="age"></span>
		</p>
		<p>
			<span>住址：</span><span id="addr"></span>
		</p>
		<center>
			<button class="ibtn button_btn" id="check">查看</button>
			<!--<button class="ibtn button_btn" id="hid">隐藏</button>-->
		</center>
	</div>
	<script type="text/javascript">
		function callMsg(){
			$.ajax({
				url:"http://114.251.187.74:8080/monitor/call/status.json?account=$!{sessionUser.getName()}",
				dataType : "jsonp",
				jsonp: "callback",
				jsonpCallback:"jsonpCallback",
				success:function(data){
						if(data.code=="1"){
							search(data.tel);
						}
						callMsg();
				},
				error:function(){
					callMsg();
				}
			});
		}
		
		$(document).ready(function(){
			callMsg();
			
			$("#check").click(function(){
				location.href="/callCenter/searchUserById?idcard="+$("#cardNo").text();
			});
					
			
		});
		
		// 校验身份证号
$("#addCardNo").blur(function(){
	var idCard = $("#addCardNo").val();
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

	</script>
	#end #end



#end