<!DOCTYPE html>
<html>
#set ($dirUser=$!{session.getAttribute("dirUser")})
<head>
    <meta charset="utf-8">
    <title>用户首页-公用</title>
</head>

<body>
<div class="main">
  <div class="personTitle clearfix">
    <div class="personTitle_left fl">
      #if(!$dirUser.head)
      	<img src="/assets/director/image/head.png" width="101px" height="121px" class="fl">
      	#else
      	 <img src="/$!dirUser.head" width="101px" height="121px" class="fl">
      #end
      <ul class="fl">
        <li><label class="marginright10">姓名:</label><label>$!dirUser.name $!dirUser.super_</label><label class="marginleft50">性别:</label><label>#if($!dirUser.gender=='0')女  #else 男  #end</label><label class="marginleft50">年龄:</label><label class="">$!dirUser.age</label><label class="marginleft50">电话:</label><label>$!dirUser.mobilePhone</label></li>
        <li><label class="marginright10">住址:</label><label>$!dirUser.addr</label></li>
        <li><label class="marginright10">病史:</label><label>$!dirUser.medicalHistory</label></li>
        <li><label class="marginright10">过敏史:</label><label>$!dirUser.allergy</label></li>
      </ul>
    </div>
    <div class="personTitle_right fl">
      <ul class="clearfix fr">
      #if(!$sessionUser.super_)
        <li>
          <a href="#" class="huizhen">
            <img src="../../assets/director/image/huizhen.png">
            <span style="color:#fec07d;">申请会诊</span>
          </a>
        </li>
       
        <li class="zhuanzhen">
          <a href="#">
            <img src="../../assets/director/image/zhuanzhen.png">
            <span style="color:#ff5024;">申请转诊</span>
          </a>
        </li>
        
        <li>
          <a href="#" class="zhiliao">
            <img src="../../assets/director/image/zhiliao.png">
            <span style="color:#8fc374;">申请治疗</span>
          </a>
        </li>
        #end
        <li class="shouye">
          <a href="/director/userlist">
            <img src="../../assets/director/image/return.png">
            <span style="color:#f7c456;">返回首页</span>
          </a>
        </li>
      </ul>
    </div>
  </div>
</div>
<div class="mask"></div>
<!-- 会诊原因 -->
<div class="huizhenReason">
<form method="post" id="SelectUser" action="/consu/addhConsu">
	<input type="hidden" name="userId" value="$dirUser.id">
   <div class="title">
    <span class="fl span_add">会诊原因</span>
    <span class="fr close"></span>
  </div>
  <div class="reason_content">
    <textarea name="content" class="content"></textarea>
  </div>
  <div class="btn-fc">
  	<a href="#" id="huizhen" class="confirm btnBg">确认</a>
    <!--<input type="submit" class="confirm btnBg" value="确认" />-->
    <a href="#" class="cancel btnBg">取消</a>
  </div>
  </form>
</div>
<!-- 转诊原因 -->
<div class="zhuanzhenReason">
<input type="hidden" value="$!dirUser.id" name="uId" id="uId"/>
  <div class="title">
    <span class="fl span_add">转诊原因</span>
    <span class="fr close"></span>
  </div>
  <div class="reason_content">
    <textarea name="content" class="contentz"></textarea>
  </div>
  <div class="btn-fc">
    <a href="#" id="adds" class="confirm btnBg">确认</a>
    <a href="#" class="cancel btnBg">取消</a>
  </div>
</div>
<!-- 申请治疗原因 -->
<div class="zhiliaoReason">
<form action="/director/htreatuser/save" method="post"  id="form">
  <div class="title"><input type="hidden" name="userId" value="$!dirUser.id">
    <span class="fl span_add">治疗原因</span>
    <span class="fr close"></span>
  </div>
  <div class="reason_content">
    <textarea  name="desired" id="desired"></textarea>
  </div>
  <div class="btn-fc">
    <a href="#" class="confirm btnBg" id="zhiliao" >确认</a>
    <a href="#" class="cancel btnBg">取消</a>
  </div>
  </form>
</div>
</body>
<script>
$(function(){
	$("#huizhen").click(function(){
		var content=$('.content').val();
		if(content!=""){
			$('#SelectUser').submit();
		}else{
			alert("有文本框未填写!");
			return false;
		}
	});
	//转诊
	$("#adds").click(function(){
    var uId=$("#uId").val();
   	var content=$(".contentz").val();
   	if(content==""){
   		alert("转诊内容不能为空!");
   	}else{
	   	$.ajax({
	   		url:"/director/addHTransfer",
	   		type:"post",
	   		data:{"uId":uId,"content":content},
	   		success: function(result){
							var res = String($.trim(result)); 
							if(res=="OK"){ 
								alert("申请转诊成功");
								location.href ="/director/HTransfer?userId="+uId;
							}else{ 
								alert("网络不好，请稍等重试");
							} 
						} 
	   	});
	   }
  });
  //申请治疗
  $("#zhiliao").click(function(){
		var des=$("#desired").val();
		if(des==""){
			alert("申请治疗需求为空！");
			return false;
		}else{
			$("#form").submit();
		}
	});
});	
</script>
</html>
