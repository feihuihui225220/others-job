<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>课程管理</title>
   	#parse("/common/top.tpl")
   	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/newCss/program.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/newJs/nProgram.js"></script>
    <link rel="stylesheet" href="/assets/newCss/index.css" />
    <style>
    	.n_add{padding:30px 0 0 10px;}
    	.n_lable{margin:0px;}
    	
#main{margin-left:10%;margin-top:20px;width:80%;}
</style>
<body>
<div class="wrapper">
		#parse("/common/head.tpl")
		#if($!{sessionUser.isSuper_()}==true)
		<div class="main">
	        #parse("/common/providers.tpl")
		<div id="right" > 
		#else
		<div id=main>
		#end
			<a class="add_">添加新课程类型</a>
			<div  class="div_from4 add_div product-container" >
				<form   method="post"  action="/professional/fete/parentAdd" enctype="multipart/form-data" id="parentAdd">
					<div class="n_add">
						<label class="n_lable">课程类别：<input name="programName"/><a class="a_color required"> * 必填项</a></label><br><br>
						<label class="n_lable">专业老师：<input  id="parentId" placeholder="输入姓名搜索" /><a class="a_color required"> * 必选项</a></label><br>
						<label class="n_t">
							<ul class="n_tea">
							</ul>
						</label>
						
						<input type="hidden" name="parentId" value="0"/>
						<input  type="hidden" name="subjectTeacher" >
					</div>
					<div class="n_teacher">
					</div>
					<div class="n_handle">
					<br>
						<input type="button"class="btn btn-primary button_float" id="vo_submit" value="确认 "/><input type="button"  class="btn btn-default button_float _quxiao" value="取消"/>
					</div>
				</form>	
			</div>
			<div style="">
				#foreach($n in $nProgram)
				<div class="discipline" date-id="$n.id">
					<a class="dis_a1" >$n.programName</a><br>
					<a class="dis_a2" date-id="$n.id" style="cursor:pointer;">课程说明</a>
					<p class="dis_lale">专业老师：$n.subjectTeacher</p>
				</div>				
				#end
			</div>
		</div>
        </div> 
	</div>
</body>
</html>