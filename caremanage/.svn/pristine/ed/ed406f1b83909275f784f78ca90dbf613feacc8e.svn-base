<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>添加人口信息</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usertitle strong">基础信息</div>
        <form action="/community/user/save" id="saveUser" method="post" enctype="multipart/form-data">
        <ul class="inpubox clearfix">
        	<input type="hidden" name="id" value="$!user.id"/>
            <li><label>姓名：</label>
            <input class="text150" type="text" name="name" value="$!user.name"/></li>
            <li><label>身份证号：</label>
            <input class="text150" type="text" #if($!user.id)disabled="true"#end name="idCardNo" maxlength="18" id="idCard" value="$!user.idCardNo"/></li>
            <li>
            	<label>性别：</label>
            	<select style="width:120px;" class="select160" name="gender" id="">
            		<option value="0" #if($!{user.gender}==0)selected=true#end>女</option>
            		<option value="1" #if($!{user.gender}==1)selected=true#end>男</option>
            	</select></li>
            <li><label>出生日期：</label>
            <input class="text150 timedate" type="text" readonly="true" maxlength="10" name="birthday" value="$!date.format('yyyy-MM-dd',$!user.birthday)"/></li>
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
            <input class="text150" type="text" name="hrAddr" value="$!user.hrAddr"/></li>
            <li>
            	<label>婚姻情况：</label>
            	#set($items=$!categorys.get(102))
            	<select class="select160" name="marry" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.marry}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
            	</select>
            </li>
            <li><label>手机：</label>
            <input class="text150" type="text" name="mobilePhone" value="$!user.mobilePhone"/></li>
            <li><label>联系电话：</label>
            <input class="text150" type="text" name="contactPhone" value="$!user.contactPhone"/></li>
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
            	<label>民族：</label>
            	#set($items=$!categorys.get(109))
            	<select class="select160" name="nation" id="">
	            	#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.nation}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
            	</select>
            </li>
            <li class="w520">
            	<label>居住地址：</label>
            	<input class="text150" type="text" name="addr" value="$!user.addr"/>
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
            	<label>医疗保障：</label>
            	#set($items=$!categorys.get(107))
            	<select class="select160" name="medical" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.medical}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
            	</select>
            </li>
            <li><label>照片：</label><input class="text150" name="headFile" type="file"></li>
            <li><label>楼宇：</label>
            	<select class="select160" name="buildingId" id="">
            		#foreach($item in $buildings)
            			<option value="$item.buildingId" #if($!{user.buildingId}==$item.buildingId)selected=true#end>$item.name</option>
            		#end
            	</select>
            </li>
            <li>
            	<label>状态：</label>
            	<select class="select160" name="active" id="">
            		<option value="0" #if($!{user.active}==0)selected=true#end>未激活</option>
            		<option value="1" #if($!{user.active}==1)selected=true#end>已激活</option>
            		<option value="2" #if($!{user.active}==2)selected=true#end>已冻结</option>
            		<option value="3" #if($!{user.active}==3)selected=true#end>待核对</option>
            	</select>
            </li>
        </ul>
        <div class="usertitle strong">特征信息</div>
        <ul class="inpubox bdline clearfix">
            <li>
            	<label>三无：</label>
            	#set($items=$!categorys.get(111))
            	<select class="select160" name="specia.three" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.three}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
            	</select>
            </li>
            <li>
	            <label>孤寡：</label>
	            #set($items=$!categorys.get(114))
	            <select class="select160" name="specia.lonely" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.lonely}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
	            <label>失独：</label>
	            #set($items=$!categorys.get(117))
	            <select class="select160" name="specia.lostOnly" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.lostOnly}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
	            <label>失能：</label>
	            #set($items=$!categorys.get(112))
	            <select class="select160" name="specia.disable" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.disable}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
	            <label>低保：</label>
	            #set($items=$!categorys.get(115))
	            <select class="select160" name="specia.lessIncome" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.lessIncome}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
            	<label>优抚：</label>
            	#set($items=$!categorys.get(118))
	            <select class="select160" name="specia.specialCare" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.specialCare}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
	            <label>无保障：</label>
	            #set($items=$!categorys.get(113))
	            <select class="select160" name="specia.noSecurity" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.noSecurity}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
	            <label>空巢：</label>
	            #set($items=$!categorys.get(116))
	            <select class="select160" name="specia.emptyNest" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.emptyNest}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
            <li>
	            <label>独居：</label>
	            #set($items=$!categorys.get(119))
	            <select class="select160" name="specia.lifeLonely" id="">
            		#foreach($!k in $!items.keySet())
            			<option value="$!items.get($k).id" #if($!{user.specia.lifeLonely}==$k)selected=true#end>$!items.get($k).itemName</option>
            		#end
	            </select>
            </li>
        </ul>
        <div class="centerbtn pad10">
        	<button class="button_btn" id="save" type="button">保存</button>
        	<button type="reset" onclick="window.location.href='/community/user/list'" class="button_btn">取消</button>
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
#if(!$user.id)
$("#save").click(function(){
	var idCard = $("#idCard").val();
	var verify = isCardNo(idCard);
	if(verify){
		$.get("/community/user/verifyIdCard/"+idCard, function(data) {
			if(data.code==0){
				$('#saveUser').submit();
			}else{
				alert(data.data[0]);
			}
		},"json");
	}
});
#else
	$("#save").click(function(){
		$('#saveUser').submit();
	});
#end

</script>
</body>
</html>