<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Care Manager_服务商管理_详情页面</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
#if($!{sessionUser.getCateEnum()}!="STREET")
<script>
	function toModifyPage(venderId) {
		window.open('/professional/vender/tab/modify?venderId=' + venderId, '_self');
	}
</script>
#end
</head>
<body>
<div class="wrapper">
    <div class="body">
        <div class="useractbox bodyline pad10">
            <div class="actboxlist">
				    <div class="actbox1">
					  <div class=" mgb10 strong clearfix">
					  #if($!{sessionUser.getCateEnum()}!="STREET")
						<div class="frusertitle_itbn">
							<button class="addulimit button_gm" onclick="toModifyPage(${venderVO.id})">编辑</button>
						</div>
						#end
					</div>
                    <div class="umleft f_l clearfix adddiv">
						<ul class="usermes1 f_l addul1">
							<li><label class="addul1_label">服务商名称：</label><span class="strong">${venderVO.name}</span></li>
							<li><label class="addul1_label">服务商类别：</label><span class="strong">专业服务</span></li>
							<li><label class="addul1_label">办公地址：</label><span class="strong">${venderVO.contactAddr}</span></li>
						</ul>
						<ul class="usermes1 meswidth f_l addul1">
							<li><label class="addul1_label">联系电话：</label><span class="strong">${venderVO.contactPhone}</span></li>
						</ul>
						<ul class="usermes1 meswidth f_l addul1">
							<li><label class="addul1_label">管理员：</label><span class="strong">${venderVO.contact}</span></li>
							<li>
								<label class="addul1_label">评级：</label>
								<span class="strong">
									#if($venderVO.star > 0)
			                    		#foreach($i in [1..6])
			                    		★
				                    		#if($i == $venderVO.star)
				                    			#break;
				                    		#end
			                    		#end
		                    		#end
								</span>
							</li>
						</ul>
					</div>
					<div class="umleft f_l clearfix adddiv">
						<div class="umleft_l">
							<p>简介：</p>
						</div>
						<div class="umleft_r">
							<p>${venderVO.introduction}</p>
						</div>
					</div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>