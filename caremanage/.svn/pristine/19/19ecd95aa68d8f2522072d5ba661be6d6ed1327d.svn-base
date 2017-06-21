<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title>评估结果表</title>
        <link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
        <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
       	<script src="$request.contextPath/assets/js/jquery.jqprint-0.3.js"></script>
       	
	</head>
	<body>
		<div class="wrapper" >
			<div class="body" id="myPrintArea" style="font-family:楷体;">
				<div class="useractbox pad10 " >		
					<div style="padding-top:20px;padding-bottom:20px;">
					<h2 style="padding-left:40%;">体适能评估报告</h2><br>
					<h3>
					<label  style="padding-right:80px;" class="lable_1">姓名：$name </label>
					<label  style="padding-right:80px;" class="lable_1">性别：#if(${sex}==0)女 #else 男 #end  </label> 
					<label  style="padding-right:80px;" class="lable_1">	年龄：$age  </label> 
					<label  style="padding-right:80px;" class="lable_1">测试日期：$createTime   </label>
					<label  style="padding-right:80px;" class="lable_1">编号：$id   </label>
					</h3>
					</div>
					<table class="usertable " border=1 cellspacing=0 cellpadding=0>
					    <tr>
							<th  style="width:20%"  rowspan="2">评估类型</th>
							<th  style="width:42%"  colspan="3">评估质量</th>
							<th   rowspan="2">运动建议</th>
						</tr>
						<tr>
							<th >名称</th>
							<th >结果</th>
							<th >等级</th>
						</tr>
						<tr>
							<td  rowspan="2">一、肌力与肌耐力</td>
							<td>30秒坐站(次)</td>							
							<td>$!result1</td>
							<td>$grade1</td>
							<td tyle="300px;">$advice1</td>
						</tr>
						<tr>
							<td>握力(kg)</td>
							<td>$!result5</td>
							<td>$grade5</td>
							<td>$advice5</td>
						</tr>
						<tr>
							<td>二、心肺耐力</td>
							<td>两分钟抬腿(次)</td>
							<td>$!result2</td>
							<td>$grade2</td>
							<td>$advice2</td>
						</tr>
						<tr>
							<td rowspan="2">三、柔软度</td>
							<td>座椅体前屈(cm)</td>
							<td>$!result8</td>
							<td>$grade8</td>
							<td>$advice8</td>
						</tr>
						<tr>
							<td>双手背后相扣(cm)</td>
							<td>$!result3</td>
							<td>$grade3</td>
							<td>$advice3</td>
						</tr>
						<tr>
							<td>四、敏捷与动态平衡</td>
							<td>2.44米折返走(秒)</td>
							<td>$!result4</td>
							<td>$grade4</td>
							<td>$advice4</td>
						</tr>
						<tr>
							<td rowspan="2">五、身体成分</td>
							<td>身体质量指数</td>
							<td> 
							#if($!result6)
							#set($str=$!result6+"")	
								#if($str.length()>5)
								    #set($str=$str.substring(0,5))
								    $str
								#end
							#end
							</td>
							<td>$grade6</td>
							<td>$advice6</td>
						</tr>
						<tr>
							<td>腰臀比</td>
							<td>
							#if($!result7)
							#set($str=$!result7+"")	
								#if($str.length()>5)
								    #set($str=$str.substring(0,5))
								    $str
								#end
							#end
							</td>
							<td>$grade7</td>
							<td>$advice7</td>
						</tr>
						<tr>
							<td>肌力</td>
							<td>30秒手臂卷起</td>
							<td>$!result9</td>
							<td>$grade9</td>
							<td>$advice9</td>
						</tr>
						<tr>
							<td>四、敏捷与动态平衡</td>
							<td>2.44米折返走(秒)</td>
							<td>$!result10</td>
							<td>$grade10</td>
							<td>$advice10</td>
						</tr>
						<tr>
							<td>四、敏捷与动态平衡</td>
							<td>2.44米折返走(秒)</td>
							<td>$!result11</td>
							<td>$grade11</td>
							<td>$advice11</td>
						</tr>
						<tr>
							<td>四、敏捷与动态平衡</td>
							<td>2.44米折返走(秒)</td>
							<td>$!result12</td>
							<td>$grade12</td>
							<td>$advice12</td>
						</tr>
						<tr>
							<td>四、敏捷与动态平衡</td>
							<td>2.44米折返走(秒)</td>
							<td>$!result13</td>
							<td>$grade13</td>
							<td>$advice13</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
		<input id="printResult" type="button" value="打印" style="width:75px;height:50px; float:right;"/>
		<script type="text/javascript">
		$(document).ready(function () { 
          $("input#printResult").click(function(){
            $("#myPrintArea").jqprint(); 
          });
        });
        </script>
	</body>
</html>
