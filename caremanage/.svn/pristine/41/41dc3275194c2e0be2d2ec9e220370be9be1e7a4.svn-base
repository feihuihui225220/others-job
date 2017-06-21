<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>评估量表</title> #parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<style>
.input165 {
	width: 165px;
	height: 30px;
}

#jindu {
	width: 80%;
	position: relative;
	top: -18px;
	left: 62px;
}

.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80);
}

.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 32%;
	width: 30%;
	height: 10%;
	padding: 16px;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}
.btn{float: left;margin-right: 20px;}
</style>
</head>
<body>
	<div class="wrapper">
		#parse("/common/head.tpl")
		<div class="body bodyline">
			<form id="formzf" action="/ICareFitness/zfitness/insert"   method="post">
			     #if($!fid)
				    <input  type="hidden" class="FId" name="FId" value="$!fid"> 
			    #end
			    <input type="hidden" class="parentId" name="parentId" value="$parentId">
				    <label>体适能类型:</label><input class="fName" name="FName" value="$!zfit.FName"> 
				    <input class="fileNames" name="videoUrl" type="hidden"> 
			</form>
			#if($parentId==0)
			<form id='fForm' class="form-actions form-horizontal"
				action="/ICareFitness/zfitness/operation" encType="multipart/form-data"
				target="uploadf" method="post">
				<div class="control-group">
					<label class="control-label">上传文件:</label> 
					<label><input class="fileNames" name="fileNames" type="hidden"></label>
					<div class="controls">
						<input class="div_con" type="file" id="video" name="file" style="width:550">
					</div>
				</div>
			</form>
			<iframe name="uploadf" style="display:none"></iframe>
			#end
		</div>
		<div id="light" class="white_content">
			<br> <label class="control-label">上传进度:</label> <a
				class="percentage" href="#" style=" position: relative;z-index:10">0%</a>
			<div id="jindu" style="border-radius: 20px;">
				<div id="proBar"
					style="width:0%;background-color: #68EE68;height:18px;border-radius: 20px;">
				</div>
			</div>
		</div>
		<input id="add" class="btn button_gm" type="button" value="编辑">
		<input id="delete" class="btn button_delete" type="button" value="取消">
		<div id="fade" class="black_overlay">
			<div class="footer"></div>
		</div>
		<script>
			$(document).ready(function() {
								$("#video").on('change',function() {
													document
															.getElementById('light').style.display = 'block';
													document
															.getElementById('fade').style.display = 'block';
													var date = new Date()
															.getTime()+".mp4";
													$('.fileNames').val(date);
													var filepath = $(
															"input[name='file']")
															.val();
													var extStart = filepath
															.lastIndexOf(".");
													var ext = filepath
															.substring(
																	extStart,
																	filepath.length)
															.toUpperCase();
													if (ext != ".MP4") {
														alert("上传视频格式不正确，请选择MP4格式！");
														return false;
													}
													$('#fForm').submit();
													var eventFun = function() {
														$
																.ajax({
																	url : '/ICareFitness/zfitness/process',
																	success : function(
																			json) {
																		var data = eval("("
																				+ json
																				+ ")");
																		$(
																				'#proBar')
																				.css(
																						'width',
																						data.rate
																								+ ''
																								+ '%');
																		$(
																				'.percentage')
																				.empty();
																		$(
																				'.percentage')
																				.append(
																						data.rate
																								+ ''
																								+ '%');
																		if (data.rate == 100) {
																			window
																					.clearInterval(intId);
																			alert("视频上传成功！")
																			document
																					.getElementById('light').style.display = 'none';
																			document
																					.getElementById('fade').style.display = 'none';

																		}
																	}
																});
													};
													var intId = window
															.setInterval(
																	eventFun,
																	500);

												});
							});
							
		$('#add').click(function(){
		 
		  var result=$('.fName').val().replace(/\s+/g,"");
		  if(result==""){
		      alert("名称不能为空！");
              return false;
   		  }
   		  if($('.FId').val()!=""&&$('.FId').val()!=undefined&&$('.parentId').val()==0){
   		   $('#formzf').attr("action","/ICareFitness/zfitness/update")
   		  }
		  $('#formzf').submit();
		});
		</script>
</body>
</html>