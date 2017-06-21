<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style>
	b{color:red;}
	</style> 
	<link rel="stylesheet" href="/assets/css/common.css" />
	
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
	    
	 <title>结果</title>
</head>

<body>
<div class="wrapper">
<!--<ol>
  <li><strong>日常活动能力和认知功能现状 </strong></li>
</ol>

<table width="90%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td  valign="top"><p align="center">量表名称 </p></td>
    <td  valign="top"><p align="center">状况 </p></td>
    <td  valign="top"><p align="center">评价 </p></td>
  </tr>
  <tr>
    <td  valign="top"><p align="center">ADL</p></td>
    <td  valign="top"><p>洗澡、穿衣、上厕所、室内移动、控制大小便、吃饭六项活动中， <br>
      能够独立完成的是：<br>
      需要部分帮助的是：<br>
      完全需要帮助的是：</p></td>
    <td  valign="top"><p>根据ADL量表，老年人处于<u>失能/不失能</u>状态，日常活动能力<u>完好/受损</u>，<u>需要/不需要</u>照顾。（标准） </p></td>
  </tr>
  <tr>
    <td  valign="top"><p align="center">MMSE</p></td>
    <td  valign="top"><p>MMSE得分为：分，其中： <br>
      时间和地点定向力得分：分 <br>
      反应能力得分：分 <br>
      注意力及计算力得分：分 <br>
      回忆力得分：分 </p></td>
    <td  valign="top"><p>根据MMSE得分，老年人处于<u>失智/不失智</u>状态，认知功能<u>未受损/受损</u>，<u>需要/不需要</u>照顾。 </p></td>
  </tr>
</table>
-->
<ol>
  <li><strong>失能、失智的概率/得分预测 </strong></li>
</ol>
<h3>（一）、失能的概率和得分预测情况（模型有关结果的可视化） </h3>
<table width="90%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><p>&nbsp;</p></td>
    <td valign="top"><p>失能概率 </p></td>
    <td valign="top"><p>不失能概率 </p></td>
    <td valign="top"><p>&nbsp;</p></td>
    <td valign="top"><p>失能得分 </p></td>
    <td valign="top"><p>不失能得分 </p></td>
  </tr>
  <tr>
    <td valign="top"><p>基于二元逻辑回归的失能模型 </p></td>
    <td valign="top"><p>$disable </p></td>
    <td valign="top"><p>$noDisability </p></td>
    <td valign="top"><p>基于Fisher判别分析的失能模型 </p></td>
    <td valign="top"><p>$disYes</p></td>
    <td valign="top"><p>$disNo</p></td>
  </tr>
  <tr>
    <td valign="top"><p>总体结论： </p></td>
    <td  colspan="5" valign="top"><p>模型预测老人的失能概率<b>
     $!logshineng
</b>不失能概率，预测老人的失能得分<b>
$!fisshineng
</b>不失能得分。综合评价，老人失能的可能性<b>
$lastResultDisable
</b></p></td>
  </tr>
</table>
<h3>（二）、失智的概率和得分预测情况 </h3>
<table width="90%" border="1" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><p>&nbsp;</p></td>
    <td valign="top"><p>失智概率 </p></td>
    <td valign="top"><p>不失智概率 </p></td>
    <td valign="top"><p>&nbsp;</p></td>
    <td valign="top"><p>失智得分 </p></td>
    <td valign="top"><p>不失智得分 </p></td>
  </tr>
  <tr>
    <td valign="top"><p>基于二元逻辑回归的失智模型 </p></td>
    <td valign="top"><p>$logisticsDementia</p></td>
    <td valign="top"><p>$noLogisticDementia</p></td>
    <td valign="top"><p>基于Fisher判别分析的失智模型 </p></td>
    <td valign="top"><p>$deYes</p></td>
    <td valign="top"><p>$deNo</p></td>
  </tr>
  <tr>
    <td valign="top"><p>总体结论： </p></td>
    <td  colspan="5" valign="top"><p>模型预测老人的失智概率 <b>
    $!logshizhi
    </b>
    不失智概率，预测老人的失智得分<b>
$!fisshizhi
</b>不失智得分。
    综合评价，老人失智的可能性<b>
    $!lastResultDementia</b>
    </p></td>
  </tr>
</table>
<!--<div><button onclick="location.href='$request.contextPath/handle/$!userId'">查看其它信息</button></div>-->
<div><button onclick="history.go(-2)">查看其它信息</button></div>
</div>
</body>
</html>
