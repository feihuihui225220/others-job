<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>课程说明</title>
   	#parse("/common/top.tpl")
   	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/newCss/program.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
	<script src="/assets/newJs/nProgram.js"></script>
    <link href="/ueditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" charset="utf-8" src="/ueditor/umeditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="/ueditor/umeditor.min.js"></script>
    <link rel="stylesheet" href="/assets/newCss/index.css" />
    <style>
    	
    	.see_{margin-right:30px;margin-top:20px;}
    	.r_teacher{padding-right:60px;}
    	
	</style>
</head>
<body>
	<div class="wrapper">
			#parse("/common/head.tpl")
			<div class="main">
		        #parse("/common/providers.tpl")
		<div id="right">
				<input type="button" class="btn-default add_first add_x btn" value="编辑"/><input type="button" class="btn-default add_x add_first btn success_1" value="保存"/><input type="button" class="btn-default add_x add_first btn" onclick="javascript:history.go(-1)" value="返回上一页"/>
				<input id="id_" type="hidden" value="$nProgram.id"/>
				<script type="text/plain" id="myEditor" style="width:60%;height:60%; ">
				$!nProgram.programDesc
				</script>
				<script type="text/javascript">
				    //实例化编辑器
				    var um = UM.getEditor('myEditor');
				    function getContent() {
				        var arr = [];
				        arr.push(UM.getEditor('myEditor').getContent());
				        return arr.join("\n");
				    }
				</script>
				<div class="r_teacher">
					<h5>专业老师</h5>
					<input placeholder="输入姓名搜索" id="parentId" /><br>
					<ul class="n_tea n_t1">
					</ul>
					#foreach($n in $subjectTeacher)
					<div class="btn-default see_ add_first btn" date-id=$n.id>$!n.name</div>
					#end
				</div>		
		</div>
        </div> 
	</div>
</body>
</html>