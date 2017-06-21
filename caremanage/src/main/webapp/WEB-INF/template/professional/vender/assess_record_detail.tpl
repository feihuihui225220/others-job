<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>评估量表-评估记录详情</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="$request.contextPath/assets/css/common.css"/>
    <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css"/>
    <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
</head>

<body onload="">
<div class="wrapper">
    #if($!{sessionUser.getCateEnum()}=="USER")
			 #parse("/common/head.tpl")
	#end
	 #if($!{sessionUser.getCateEnum()}=="USER")
		 	<iframe id="userFrame"  width="20%" style="height:800px; margin-left:1%"src="/user/detail" frameborder="0" scrolling="no"></iframe>
		    <div  style="width:77%;float:right;" height=800px;>
	 #else
		    <div   height=800px;>
	 #end
        <script>
            function a(a) {
                alert(a);
            }
        </script>
        <div class="useractbox bodyline pad10 vv">
            #foreach($detail in $list)
            <table class="table table-bordered table-hover tablewidth">
                <tr class="success">
                    <th>序号</th>
                    <th>问题</th>
                    <th>选项</th>
                    <th>内容</th>
                    <th>建议</th>
                    <th>得分</th>
                </tr>
                #set($result=$detail.result)
                #foreach ($answer in $result)
                 #set($i = $velocityCount + 1)
                #set($questionName=$answer.questionName)
                	#if($!{answer.questionName}!="PA"&&$!{answer.questionName}!="NA"&&$!{answer.questionName}!="PE"&&$!{answer.questionName}!="NE")
                	<tr>
                    	<td>$i</td>
                    	<td>$!{answer.questionName}</td>
                    	<td>$!{answer.code}</td>
                    	<td>$!{answer.answerName}</td>
                    	<td id=$!{answer.answerId}></td>
                    	<td>$!{answer.score}</td>
                	</tr>
                	#end
               
               
                #end
            </table>
            <h3>评估结论：$detail.conclusion</h3>
            #end
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $.ajax({
            url: "/professional/vender/assess/conclusion",
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                json.conclusions.forEach(function (e) {//遍历数组
                	if(e.conclusion!=null){
                    $("#" + e.answerId).text(e.conclusion);
                	}else{
                    $("#" + e.answerId).text("暂无");
                	}
                });
            },
            error: function () {
            }
        });
    });
</script>
</body>
</html>