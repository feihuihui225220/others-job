<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title>评估结果表</title>
        <link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
        <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
        <script src="$request.contextPath/assets/js/jquery.PrintArea.js"></script>
	</head>
	
	<body>
		<div class="wrapper" >
			<div class="body" id="printArea">
				<div class="useractbox bodyline pad10 vv">			
					<table class="table100 usertable cen">
					<tr>
					姓名：$name   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					性别：#if(${sex}==0)女  #else 男 #end
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					年龄：$age  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					测试日期：$createTime   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					编号：$id   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					</tr>
						<tr>
							<th rowspan="2" >序号</th>
							<th rowspan="2">评估类型</th>
							<th colspan="3">评估质量</th>
							<th rowspan="2">运动建议</th>
							
						</tr>
						<tr>
							<th>名称</th>
							<th>结果</th>
							<th>等级</th>
							
						</tr>
						<tr>
							<td>1</td>
							<td rowspan="2">肌力</td>
							<td>30秒坐站（次）</td>							
							<td>$!result1</td>
							<td>$grade1</td>
							<td>$advice1</td>
							
						</tr>
						<tr>
							<td>2</td>
							<td>握力（kg）</td>
							<td>$!result5</td>
							<td>$grade5</td>
							<td>$advice5</td>
							
						</tr>
						<tr>
							<td>3</td>
							<td>心肺耐力</td>
							<td>两分钟抬腿（次）</td>
							<td>$!result2</td>
							<td>$grade2</td>
							<td>$advice2</td>
							
						</tr>
						<tr>
							<td>4</td>
							<td rowspan="2">柔软度</td>
							<td>座椅体前屈（cm）</td>
							<td>$!result8</td>
							<td>$grade8</td>
							<td>$advice8</td>
							
						</tr>
						<tr>
							<td>5</td>
							<td>双手背后相扣（cm）</td>
							<td>$!result3</td>
							<td>$grade3</td>
							<td>$advice3</td>
							
						</tr>
						<tr>
							<td>6</td>
							<td>敏捷与动态平衡</td>
							<td>2.44米折返跑坐（秒）</td>
							<td>$!result4</td>
							<td>$grade4</td>
							<td>$advice4</td>
							
						</tr>
						
						<tr>
							<td>7</td>
							<td rowspan="2">身体质量指数</td>
							<td>体脂百分数</td>
							<td>$!result6</td>
							<td>$grade6</td>
							<td>$advice6</td>
							
						</tr>
						<tr>
							<td>8</td>
							<td>腰臀比</td>
							<td>$!result7</td>
							<td>$grade7</td>
							<td>$advice7</td>
							
						</tr>
						
					</table>
				</div>
			</div>
		</div>
		
		<input id="printResult" type="button" value="打印" style="width:75px;height:50px; float:right;"></input>
		<script type="text/javascript">
		$(document).ready(function () { 
          $("input#printResult").click(function(){
            $("div#printArea").printArea();
          });
        });
        </script>
	</body>
</html>
