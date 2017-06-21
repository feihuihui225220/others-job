<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/reg.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
</head>
<body>

<div class="wrapper">
	#parse("/common/head.tpl")
    <form method="post" action="/community/user/uploadCert/$!{id}" id="certForm" enctype="multipart/form-data" class="reg_area fix_pop" style="width:590px">
        <input type="hidden" name="id" value="$!id">
		<h2>添加证据信息</h2>
        <div class="mask_evidence pad10">
            <style>
            .mask_evidence li {width:auto;}
            #addfile, .iptdiv {margin-left:10px;padding-left:0;}
            .iptdiv {margin-bottom:5px;}
            #addfile {height:30px;line-height:30px;padding:0 6px;margin-bottom:10px;}
            .iptdiv input{cursor: pointer;}
            .iptdiv a{text-decoration:none;}
            </style>
            <ul class="inpubox clearfix" style="margin-bottom:4px;">
                <li>
                	<label>材料类型：</label>
                	<select class="select160" name="categoryId" id="">
						#foreach($!k in $!categorys.keySet())
	            			<option value="$!categorys.get($k).id">$!categorys.get($k).itemName</option>
	            		#end
                	</select>
                </li>
                <li style="padding:8px 2px;"><label for="">材料编号：</label><input id="num" name="number"/></li>
                
                
            </ul>
            <div class="inpubox_div">
            <div class="iptdiv"><input class="filechange" type="file" name="files" class="ipt" /><a class="filedel" href="#" name="rmlink"> </a></div>
            </div>
            <div><button id="addfile" type="button">增加附件</button></div>
            <!--div class="centerbtn pad10"><button class="button_btn" type="submit">保存</button><button class="pad5 contact_closed">取消</button></div-->
        </div>
        <p class="opt">
			<button class="btn button_btn" type="button" onclick='window.location.href="/community/user/detail/$!id" '>取 消</button>
			<button type="button" disabled="true" class="btn addfilebtn button_btn">添 加</button>
		</p>
    </form>
    <div class="footer">
        
    </div>
</div>
<script>
$(function(){
	$(".addfilebtn").click(function(){
		if($("#num").val()==""){
			alert("请填写材料编号！");		
		}else{
			$("#certForm").submit();
		}
	});
    $("#addfile").click(function(){
        $(".mask_evidence .inpubox_div").append('<div class="iptdiv"><input class="filechange" type="file" name="files" class="ipt" /><a href="#" class="filedel" name="rmlink"> <img src="/assets/css/img/uploadify-cancel.png" alt=""> </a></div>');
        
    });
    $("body").delegate('.filedel','click',function(){
        $(this).parent('.iptdiv').remove();
        var box = $(".inpubox .filechange"),flag = true;

        for(var i=0;i<box.length;i++){
            if(box[i].value!=''){
                flag = false;
            }
        }
        if(flag){
            $(".addfilebtn").attr('disabled',true);
        }
    });
    $("body").delegate('.filechange','change',function(){
        if(this.value!=''){
            $(".addfilebtn").removeAttr('disabled');
        }else{
            $(".addfilebtn").attr('disabled',true);
        }
    });
});


</script>
</body>
</html>