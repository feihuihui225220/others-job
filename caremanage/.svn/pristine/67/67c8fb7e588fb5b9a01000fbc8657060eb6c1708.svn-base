<!DOCTYPE html>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>问卷</title>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">

<style>
*{margin:0;padding:0;}
body{ font-family:"微软雅黑"; font-size:14px;overflow-x:hidden;}
table{ border:1px #eee solid;  box-shadow:#CCC 0px 5px 15px;}
label{font-weight:100 !important;}
#information label{text-align:left;  padding-right:10px;}
#information1 label{width:100px; text-align:left;}
#information2 label{padding-left:10px; text-align:left;}
#information3 label{text-align:left; padding-right:10px;}
#information4 label{text-align:left; padding-right:10px;}
#information5 label{text-align:left; padding-right:10px;}
#information6 label{text-align:left; padding-right:60px;}
#myTab{position:fixed; background-color:#FFF; width:100%}
#myTabContent{position:absolute; z-index:-1; margin-top:45px;}

input[type=number] {-moz-appearance:textfield;width:60px;}
/**input[type=number]::-webkit-inner-spin-button,
input[type=number]::-webkit-outer-spin-button {
-webkit-appearance: none;}*/
button{ padding:10px 20px;}
</style>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</head>

<body>
<ul id="myTab" class="nav nav-tabs">
   <li class="active"><a href="#information" data-toggle="tab"> 基本状况 </a></li>
   <li><a href="#information1" data-toggle="tab">性格分析</a></li>
   <li><a href="#information2" data-toggle="tab">现状的评价</a></li>
   <li><a href="#information3" data-toggle="tab">生活方式</a></li>
   <li><a href="#information4" data-toggle="tab">日常活动能力</a></li>
   <li><a href="#information5" data-toggle="tab">活动与参与</a></li>
   <li><a href="#information6" data-toggle="tab">身体状况</a></li>
 
</ul>
<form action="/professional/vender/user/detail/${userId}" id="form"  method="post">
<div id="myTabContent" class="tab-content" style="background-color: #fff;">
<table id="information" width="100%" border="1" align="center" cellpadding="0" cellspacing="0" 
 class="table  table-hover table-striped tab-pane fade in active">
  <tr>
    <td  colspan="2" valign="top">
      <strong> A</strong><strong>基本状况 </strong></td>
  </tr>
  <tr>
    <td width="50%"  valign="top">1性别： 
     <label> <input type="radio" name="sex" id="radio73" value="1" />男  </label>
     <label> <input type="radio" name="sex" id="radio74" value="2" />女</label>  </td>
    <td width="50%"  valign="top">2民族： 
     <label> <input type="radio" name="nation" id="radio77" value="1" />汉族 </label>
     <label> <input type="radio" name="nation" id="radio78" value="2" />其他</label>  </td>
  </tr>
  <tr>
    <td  valign="top">3请问您现在多大年龄了？（如果老人回答虚岁，则追问其周岁年龄） 
      <input name="age" type="number" width="10px" id="textfield2" />周岁 </td>
    <td  valign="top">4、您出生在哪个省/市？ 
    <select name="sheng">
        #foreach($c in $country)
    		<option value="$c.id">$c.name</option>
    	#end
    </select>
    省/市 </td>
  </tr>
  <tr>
    <td valign="top">5、当时您的出生地是城镇还是农村？ 
      
     <label> <input type="radio" name="residenc" id="radio79" value="1" />城镇  </label>
	 <label> <input type="radio" name="residenc" id="radio80" value="2" />农村  </label>  </td>
    <td valign="top">6、您现在与谁住在一起？ 
     <label><input type="radio" name="livewith" id="radio83" value="1" />家人</label>
     <label><input type="radio" name="livewith" id="radio84" value="2" />独居 </label>
	 <label><input type="radio" name="livewith" id="radio85" value="3" />养老院 </label> </td>
  </tr>
  <tr>
    <td valign="top">7、您一共上过几年学？ 
      <input name="education" type="number" id="textfield3" size="5" />
年（未念过书：00）</td>
    <td  valign="top">8、您60岁以前主要从事什么工作（职业）:
      
   <label> <input type="radio" name="job" id="radio86" value="1" />专业技术/医生/教师</label>
   <label> <input type="radio" name="job" id="radio87" value="2" />行政管理</label>
   <label> <input type="radio" name="job" id="radio88" value="3" />一般职员/服务人员/工人</label> 
   <label> <input type="radio" name="job" id="radio89" value="4" />农民 </label>
   <label> <input type="radio" name="job" id="radio90" value="5" />家务劳动 </label>
   <label> <input type="radio" name="job" id="radio91" value="6" />军人 </label>
   <label> <input type="radio" name="job" id="radio92" value="7" />无业人员 </label>
   <label> <input type="radio" name="job" id="radio93" value="8" />其他 </label></td>
  </tr>
  <tr>
    <td colspan="2" valign="top">9、您现在主要的生活来源是什么？    （单选）
    <label>  <input type="radio" name="sourceincome" id="radio94" value="1" />退休金</label>
    <label>  <input type="radio" name="sourceincome" id="radio95" value="2" />配偶</label>
    <label>  <input type="radio" name="sourceincome" id="radio96" value="3" />子女</label>
    <label>  <input type="radio" name="sourceincome" id="radio97" value="4" />孙子女</label>
    <label>  <input type="radio" name="sourceincome" id="radio98" value="5" />其他亲属</label>
    <label>  <input type="radio" name="sourceincome" id="radio99" value="6" />当地政府或社团M</label>
    <label>  <input type="radio" name="sourceincome" id="radio100" value="7" />自己劳动或工作</label>
    <label>  <input type="radio" name="sourceincome" id="radio101" value="8" />其他 </label></td>
  </tr>
  <tr>
    <td  valign="top">10、您所有的生活来源是否够用？ 
      
     <label> <input type="radio" name="booleanIncome" id="radio81" value="1" />够用</label>  
	 <label> <input type="radio" name="booleanIncome" id="radio82" value="2" />不够用 </label>    </td>
    <td  valign="top">11、请您评价自己的经济情况
        
        <label><input type="radio" name="economic" id="radio102" value="1" />很富裕</label>
        <label><input type="radio" name="economic" id="radio103" value="2" />比较富裕</label>
        <label><input type="radio" name="economic" id="radio104" value="3" />一般</label>
        <label><input type="radio" name="economic" id="radio105" value="4" />比较困难</label>
        <label><input type="radio" name="economic" id="radio106" value="5" />很困难</label>
    </td>
  </tr>
  <tr>
    <td colspan="2" valign="top"> 12、您现在的婚姻状况是： 
        <label><input type="radio" name="marriage" id="radio114" value="1" />已婚,并与老伴住在一起</label>
        <label><input type="radio" name="marriage" id="radio115" value="2" />已婚,但不与老伴住在一起</label>
        <label><input type="radio" name="marriage" id="radio116" value="3" />离婚</label>
        <label><input type="radio" name="marriage" id="radio117" value="4" />丧偶</label>
        <label><input type="radio" name="marriage" id="radio118" value="5" />从未结过婚</label>
    </td>
  </tr>
</table>
<table width="100%" border="1" cellpadding="0" cellspacing="0" id="information1" 
 class="table  table-hover table-striped tab-pane fade">
  <tr>
    <td  colspan="2" valign="top">* <strong>B </strong><strong>对现状的评价及性格特征</strong> <br />
      <strong><em>（此部分问题在提示选项后必须由老人亲自回答） </em></strong></td>
  </tr>
  <tr>
    <td width="30%"  valign="top">B1-1 您觉得您现在的生活怎么样？ </td>
    <td width="70%"  valign="top">
      <label><input type="radio" name="b11" id="checkbox1" value="1" />很好</label>
      <label><input type="radio" name="b11" id="checkbox2" value="2"  />好</label>
      <label><input type="radio" name="b11" id="checkbox3" value="3"  />一般</label>
      <label><input type="radio" name="b11" id="checkbox4" value="4"  />不好</label>
      <label><input type="radio" name="b11" id="checkbox5" value="5"  />很不好</label>
      <label><input type="radio" name="b11" id="checkbox6" value="6" />无法回答</label> </td>
  </tr>
  <tr>
    <td  valign="top">B1-2 您觉得现在您自己的健康状况怎么样？ </td>
    <td  valign="top">
      <label><input type="radio" name="b12" id="checkbox1" value="1" />很好</label>
      <label><input type="radio" name="b12" id="checkbox2" value="2"  />好</label>
      <label><input type="radio" name="b12" id="checkbox3" value="3"  />一般</label>
      <label><input type="radio" name="b12" id="checkbox4" value="4"  />不好</label>
      <label><input type="radio" name="b12" id="checkbox5" value="5"  />很不好</label>
      <label><input type="radio" name="b12" id="checkbox6" value="6" />无法回答</label> </td>
  </tr>
  <tr>
    <td  valign="top">B1-3    过去一年来您觉得您的健康状况有没有改变？ </td>
    <td  valign="top">
      <label><input type="radio" name="b13" id="checkbox13" value="1"/>好多了</label>
      <label><input type="radio" name="b13" id="checkbox14" value="2"/>好一些</label>
      <label><input type="radio" name="b13" id="checkbox15" value="3"/>没变</label>
      <label><input type="radio" name="b13" id="checkbox16" value="4"/>差一些</label>
      <label><input type="radio" name="b13" id="checkbox17" value="5"/>差多了</label>
      <label><input type="radio" name="b13" id="checkbox18" value="6"/>无法回答</label> </td>
  </tr>
  <tr>
    <td  valign="top">B2-1    不论遇到什么事您是不是都能想得开？ </td>
    <td  valign="top">
      <label><input type="radio" name="b21" id="checkbox19" value="1"/>很想得开</label>
	  <label><input type="radio" name="b21" id="checkbox20" value="2"/>想得开</label>
	  <label><input type="radio" name="b21" id="checkbox21" value="3"/>一般</label>
	  <label><input type="radio" name="b21" id="checkbox22" value="4"/>想不开</label>
	  <label><input type="radio" name="b21" id="checkbox23" value="5"/>很想不开</label>
	  <label><input type="radio" name="b21" id="checkbox24" value="6"/>无法回答</label></td>
  </tr>
  <tr>
    <td  valign="top">B2-2    您是不是喜欢把东西弄得干净、整洁？ </td>
    <td  valign="top">
    <label><input type="radio" name="b22" id="checkbox25"  value="1"/>很喜欢</label>
    <label><input type="radio" name="b22" id="checkbox26"  value="2" />喜欢</label>
    <label><input type="radio" name="b22" id="checkbox27"  value="3"/>一般</label>
    <label><input type="radio" name="b22" id="checkbox28"  value="4"/>不喜欢</label>
    <label><input type="radio" name="b22" id="checkbox29"  value="5"/>很不喜欢</label>
	<label><input type="radio" name="b22" id="checkbox30"  value="6"/>无法回答</label></td>
  </tr>
  <tr>
    <td  valign="top">B2-3 您是不是经常感到紧张、害怕？ </td>
    <td  valign="top">
    <label><input type="radio" name="b23" id="checkbox7"  value="1" />总是</label>
    <label><input type="radio" name="b23" id="checkbox8"  value="2" />经常</label>
    <label><input type="radio" name="b23" id="checkbox9"  value="3" />有时</label>
    <label><input type="radio" name="b23" id="checkbox10" value="4" />很少</label>
    <label><input type="radio" name="b23" id="checkbox11" value="5" />从不</label>
    <label><input type="radio" name="b23" id="checkbox12" value="6" />无法回答</label> </td>
  </tr>
  <tr>
    <td  valign="top">B2-4 您是不是经常觉得孤独？ <br />
    </td>
    <td  valign="top">
    <label><input type="radio" name="b24" id="checkbox7"  value="1" />总是</label>
    <label><input type="radio" name="b24" id="checkbox8"  value="2" />经常</label>
    <label><input type="radio" name="b24" id="checkbox9"  value="3" />有时</label>
    <label><input type="radio" name="b24" id="checkbox10" value="4" />很少</label>
    <label><input type="radio" name="b24" id="checkbox11" value="5" />从不</label>
    <label><input type="radio" name="b24" id="checkbox12" value="6" />无法回答</label>  </td>
  </tr>
  <tr>
    <td  valign="top">B2-5    您自己的事情是不是自己说了算？ </td>
    <td  valign="top">
    <label><input type="radio" name="b25" id="checkbox7"  value="1" />总是</label>
    <label><input type="radio" name="b25" id="checkbox8"  value="2" />经常</label>
    <label><input type="radio" name="b25" id="checkbox9"  value="3" />有时</label>
    <label><input type="radio" name="b25" id="checkbox10" value="4" />很少</label>
    <label><input type="radio" name="b25" id="checkbox11" value="5" />从不</label>
    <label><input type="radio" name="b25" id="checkbox12" value="6" />无法回答</label>  </td>
  </tr>
  <tr>
    <td  valign="top">B2-6 您是不是觉得越老越不中用？ </td>
    <td  valign="top">
    <label><input type="radio" name="b26" id="checkbox7"  value="1" />总是</label>
    <label><input type="radio" name="b26" id="checkbox8"  value="2" />经常</label>
    <label><input type="radio" name="b26" id="checkbox9"  value="3" />有时</label>
    <label><input type="radio" name="b26" id="checkbox10" value="4" />很少</label>
    <label><input type="radio" name="b26" id="checkbox11" value="5" />从不</label>
    <label><input type="radio" name="b26" id="checkbox12" value="6" />无法回答</label> </td>
  </tr>
  <tr>
    <td  valign="top">B2-7    您是不是觉得与年轻时一样快活？ </td>
    <td  valign="top">
     <label><input type="radio" name="b27" id="checkbox54" value="1" />快活很多</label>
     <label><input type="radio" name="b27" id="checkbox53" value="2"  />快活一些</label>
     <label><input type="radio" name="b27" id="checkbox52" value="3"  />一样</label>
     <label><input type="radio" name="b27" id="checkbox51" value="4" />差一些</label>
     <label><input type="radio" name="b27" id="checkbox49" value="5" />差很多</label>
     <label><input type="radio" name="b27" id="checkbox50" value="6" />无法回答</label> </td>
  </tr>
</table>
<table width="100%" border="1" align="center" cellpadding="0" id="information2" cellspacing="0" class="table  table-hover table-striped tab-pane fade">
  <tr>
    <td colspan="2" valign="top"><strong>C 对现状的评价及性格特征</strong> <br />
      <strong><em>（此部分问题在提示选项后必须由老人亲自回答）</em></strong></td>
  </tr>
  <tr>
    <td  width="50%" valign="top">C1-1 现在是什么时候，上午，中午，下午，还是晚上？ 
      <label><input type="radio" name="c11" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c11" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c11" id="radio121" value="8" />无法回答</label> </td>
    <td  width="50%" valign="top">
    C1-2 现在是几月份（阴历、阳历均可）？ 
      <label><input type="radio" name="c12" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c12" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c12" id="radio121" value="8" />无法回答</label> </td>
  </tr>
 
  <tr>
    <td  valign="top">C1-3中秋节是阴历几月几日？ 
      <label><input type="radio" name="c13" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c13" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c13" id="radio121" value="8" />无法回答</label></td>
    <td  valign="top">
      C1-4现在是什么季节，是春天、夏天、秋天、还是冬天? 
      <label><input type="radio" name="c14" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c14" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c14" id="radio121" value="8" />无法回答</label></td>
  </tr>
  <tr>
    <td  valign="top">C1-5这个区或乡的名字是什么？ <br />
      （对不是常住此地的被访老人，可让被访老人回答他原居住地的乡或区的名称。） </td>
    <td  valign="top">
      <label><input type="radio" name="c15" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c15" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c15" id="radio121" value="8" />无法回答</label> </td>
  </tr>
  <tr>
    <td  valign="top">C1-6请您尽量多的告诉我一些蔬菜、水果的名称（用一分钟时间） </td>
    <td  valign="top"><input name="c16" type="number" id="textfield4" size="5" />
    个（超过10种记录10种） </td>
  </tr>
  <tr>
    <td colspan="2" valign="top">* C2     <strong>反应能力</strong>（此部分问题必须由老人亲自回答） </td>
  </tr>
  <tr>
    <td valign="top">C2-1 我现在说三样东西的名字： <br />
      桌子，苹果，衣服 <br />
      请您按顺序重复这些东西的名字： <br />
      桌子 苹果 衣服 <br />
      注：若老人的第一次回答有错，需再次向老人说上述三样东西的名称再请老人重复，直到完全正确为止。(最多可重复6次，若重复6次仍不正确填7)。 <br />
      C2-2    重复次数。(第一次完全正确填0) </td>
    <td  valign="top">第一次回答正确的有 <br />
      （对每一样东西的回答单选）： 
      1.对   0.错   8.无法回答 <br />
      <label><input type="radio" name="c211" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c211" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c211" id="radio121" value="8" />无法回答</label> <br />
	  <label><input type="radio" name="c212" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c212" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c212" id="radio121" value="8" />无法回答</label> <br />
      <label><input type="radio" name="c213" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c213" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c213" id="radio121" value="8" />无法回答</label> <br />
       
      <input name="c22" type="number" id="textfield5" size="5" />
      次 </td>
  </tr>
  <tr>
    <td colspan="2" valign="top">* C3  <strong>注意力及计算能力</strong>（此部分问题必须由老人亲自回答） </td>
  </tr>
  <tr>
    <td  valign="top">C3-1    如果有20元钱， 花了3元，请您说出还剩多少元?<br />
      再花3元，    还剩多少元? <br />
      再花3元，    还剩多少元? <br />
      再花3元，    还剩多少元? <br />
      再花3元， 还剩多少元?<br />
      注：如果老人忘了上一个数，可以告诉他（她）上一个数是什么以便继续进行。但这次即使答对了，也算错，再后面答对了则算对。如果老人上一个数答错了，但下一个数在错数的基础上减3的得数是对的，则算对。 </td>
    <td  valign="top">（每项单选） <br />
      <label><input type="radio" name="c311" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c311" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c311" id="radio121" value="8" />无法回答</label> <br />
	  <label><input type="radio" name="c312" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c312" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c312" id="radio121" value="8" />无法回答</label><br />
	  <label><input type="radio" name="c313" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c313" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c313" id="radio121" value="8" />无法回答</label> <br />
	  <label><input type="radio" name="c314" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c314" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c314" id="radio121" value="8" />无法回答</label> <br />
	  <label><input type="radio" name="c315" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c315" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c315" id="radio121" value="8" />无法回答</label></td>
  </tr>
  <tr>
    <td  valign="top">C3-2请老人画出B卡上的图形。 <br />
      注：若所有的边角都正确，并且中间部分是个四边形算对。 </td>
    <td valign="top">
    <label><input type="radio" name="c32" id="radio119" value="1" />对</label>  
    <label><input type="radio" name="c32" id="radio120" value="0" />错</label> 
    <label><input type="radio" name="c32" id="radio109" value="8" />不会用笔/从未画图</label> 
    <label><input type="radio" name="c32" id="radio110" value="9" />无法做（功能障碍）</label> </td>
  </tr>
  <tr>
    <td colspan="2" valign="top">* <strong>C4 回忆</strong>（此部分问题必须由老人亲自回答） </td>
  </tr>
  <tr>
    <td valign="top">C4-1 请您说出我刚才要您重复的三样东西是什么？<br />
      （桌子） （苹果） （衣服） <br />
      注：不管顺序，只要说对名称即可。 </td>
    <td  valign="top">（对每一样东西单选） <br />
      <label><input type="radio" name="c411" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c411" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c411" id="radio121" value="8" />无法回答</label> <br />
	  <label><input type="radio" name="c412" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c412" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c412" id="radio121" value="8" />无法回答</label><br />
	  <label><input type="radio" name="c413" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c413" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c413" id="radio121" value="8" />无法回答</label></td>
  </tr>
  <tr>
    <td  valign="top">C5-1(用手指向笔，然后再指手表，分别问被访老人: &ldquo;这是什么？&rdquo;)<br />
      笔 手表 </td>
    <td  valign="top">（对每一种单选） <br />
      <label><input type="radio" name="C511" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="C511" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="C511" id="radio121" value="8" />无法回答</label> <br />
      <label><input type="radio" name="C512" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="C512" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="C512" id="radio121" value="8" />无法回答</label>  </tr>
  <tr>
    <td  valign="top">C5-2 请您重复我下边说的这句话： &ldquo;种瓜得瓜，种豆得豆 。&rdquo;</td>
    <td  valign="top">
      <label><input type="radio" name="c52" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c52" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c52" id="radio121" value="8" />无法回答</label></td>
  </tr>
  <tr>
    <td valign="top">C5-2-1请您念一念下面的一句话，并且按照这句话的意思去做。 
      <p align="center"><strong>&ldquo;</strong><strong><u>闭上您的双眼</u></strong><strong>&rdquo;</strong></td>
    <td valign="top">
      <label><input type="radio" name="c521" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c521" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c521" id="radio121" value="8" />无法回答</label></td>
  </tr>
  <tr>
    <td  valign="top"><u>&nbsp;</u>C5-2-2请您写一个完整的句子，要有主语，有动词，有意义。 </td>
    <td  valign="top">
      <label><input type="radio" name="c522" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c522" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c522" id="radio121" value="8" />无法回答</label></td>
  </tr>
  <tr>
    <td  valign="top">C5-3 (访问员递给老人一张纸，同时说：) 请您用右手拿这张纸，用您的双手将纸对折，放在地上。 （不要重复要求，不要提供任何帮助。注意动作是否正确<em>。</em>） <br />
      右手拿 对折 放在地上 </td>
    <td  valign="top"><br />
      <label><input type="radio" name="c531" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c531" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c531" id="radio121" value="8" />无法回答</label><br />
      <label><input type="radio" name="c532" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c532" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c532" id="radio121" value="8" />无法回答</label><br />
      <label><input type="radio" name="c533" id="radio119" value="1" />对</label>  
      <label><input type="radio" name="c533" id="radio120" value="0" />错</label> 
      <label><input type="radio" name="c533" id="radio121" value="8" />无法回答</label> </td>
  </tr>
  <tr>
    <td  valign="top">C5-4 被访老人能否回答以上 B 和C 两大类所有的问题? </td>
    <td  valign="top">
      <label><input type="radio" name="c54" id="radio119" value="1" />能</label>  
      <label><input type="radio" name="c54" id="radio120" value="2" />不能</label> 
      <label><input type="radio" name="c54" id="radio121" value="3" />部分能</label> </td>
  </tr>
</table>
<table width="100%" border="1" align="center" cellpadding="0"  id="information3" cellspacing="0" 
class="table  table-hover table-striped tab-pane fade">
  <tr>
    <td colspan="4" valign="top"><strong>D生活方式</strong></td>
  </tr>
  <tr>
    <td colspan="2" valign="top">D1-1 您是否经常吃新鲜水果? </td>
    <td colspan="2" valign="top">
    <label><input type="radio" name="d11" id="radio127" value="1" />每天/几乎每天吃</label>       
    <label><input type="radio" name="d11" id="radio128" value="2" />经常吃</label>
    <label><input type="radio" name="d11" id="radio129" value="3" />有时吃  </label>
    <label><input type="radio" name="d11" id="radio130" value="4" />很少或从不吃</label></td>
  </tr>
  <tr>
    <td colspan="2" valign="top">D1-2 您是否经常吃新鲜蔬菜?</td>
    <td colspan="2" valign="top">
    <label><input type="radio" name="d12" id="radio127" value="1" />每天/几乎每天吃</label>       
    <label><input type="radio" name="d12" id="radio128" value="2" />经常吃</label>
    <label><input type="radio" name="d12" id="radio129" value="3" />有时吃  </label>
    <label><input type="radio" name="d12" id="radio130" value="4" />很少或从不吃</label> </td>
  </tr>
  <tr>
    <td colspan="2" valign="top">D2 您是否经常食用： </td>
    <td width="395" valign="top"><p align="center">现在 </td>
    <td width="422" valign="top"><p align="center">60岁左右 </td>
  </tr>
  <tr>
    <td width="114" rowspan="3" valign="top">
      <p>（注：询问&ldquo;60岁左右&rdquo;时，要提示老人相应年代的情况，下同。） </p></td>
    <td width="157" valign="top">肉类 </td>
    <td width="395" valign="top">
    <label><input type="radio" name="d221" id="radio131" value="1" />几乎每天吃;</label>
    <label><input type="radio" name="d221" id="radio132" value="2" />不是每天，但每周至少吃一次;</label>
    <label><input type="radio" name="d221" id="radio133" value="3" />不是每周，但每月至少吃一次;</label>
    <label><input type="radio" name="d221" id="radio134" value="4" />不是每月，但有时吃;</label>
    <label><input type="radio" name="d221" id="radio135" value="5" />很少吃或从不吃 </label></td>
    <td width="422" valign="top">
    <label><input type="radio" name="d2211" id="radio136" value="1" />几乎每天吃;</label>
    <label><input type="radio" name="d2211" id="radio137" value="2" />不是每天，但每周至少吃一次;</label>
    <label><input type="radio" name="d2211" id="radio138" value="3" />不是每周，但每月至少吃一次;</label>
    <label><input type="radio" name="d2211" id="radio139" value="4" />不是每月，但有时吃;</label>
    <label><input type="radio" name="d2211" id="radio140" value="5" />很少吃或从不吃 </label></td>
  </tr>
  <tr>
    <td width="157" valign="top">鱼等水产品 </td>
    <td width="395" valign="top">
    <label><input type="radio" name="d222" id="radio136" value="1" />几乎每天吃;</label>
    <label><input type="radio" name="d222" id="radio137" value="2" />不是每天，但每周至少吃一次;</label>
    <label><input type="radio" name="d222" id="radio138" value="3" />不是每周，但每月至少吃一次;</label>
    <label><input type="radio" name="d222" id="radio139" value="4" />不是每月，但有时吃;</label>
    <label><input type="radio" name="d222" id="radio140" value="5" />很少吃或从不吃 </label></td>
    <td width="422" valign="top">
    <label><input type="radio" name="d2221" id="radio136" value="1" />几乎每天吃;</label>
    <label><input type="radio" name="d2221" id="radio137" value="2" />不是每天，但每周至少吃一次;</label>
    <label><input type="radio" name="d2221" id="radio138" value="3" />不是每周，但每月至少吃一次;</label>
    <label><input type="radio" name="d2221" id="radio139" value="4" />不是每月，但有时吃;</label>
    <label><input type="radio" name="d2221" id="radio140" value="5" />很少吃或从不吃 </label></td>
  </tr>
  <tr>
    <td width="157" valign="top">蛋类 </td>
    <td width="395" valign="top">
    <label><input type="radio" name="d223" id="radio136" value="1" />几乎每天吃;</label>
    <label><input type="radio" name="d223" id="radio137" value="2" />不是每天，但每周至少吃一次;</label>
    <label><input type="radio" name="d223" id="radio138" value="3" />不是每周，但每月至少吃一次;</label>
    <label><input type="radio" name="d223" id="radio139" value="4" />不是每月，但有时吃;</label>
    <label><input type="radio" name="d223" id="radio140" value="5" />很少吃或从不吃 </label></td>
    <td width="422" valign="top">
    <label><input type="radio" name="d2231" id="radio136" value="1" />几乎每天吃;</label>
    <label><input type="radio" name="d2231" id="radio137" value="2" />不是每天，但每周至少吃一次;</label>
    <label><input type="radio" name="d2231" id="radio138" value="3" />不是每周，但每月至少吃一次;</label>
    <label><input type="radio" name="d2231" id="radio139" value="4" />不是每月，但有时吃;</label>
    <label><input type="radio" name="d2231" id="radio140" value="5" />很少吃或从不吃 </label></td>
  </tr>
  <tr>
    <td colspan="2" valign="top">D3-1 您现在吸烟吗？ 
    <label><input type="radio" name="d31" id="radio75" value="1" />是</label>  
    <label><input type="radio" name="d31" id="radio76" value="2" />否</label> </td>
    <td colspan="2" valign="top">D3-2 您过去吸烟吗？
    <label><input type="radio" name="d32" id="radio75" value="1" />是</label>  
    <label><input type="radio" name="d32" id="radio76" value="2" />否</label> </td>
  </tr>
  <tr>
    <td colspan="2" valign="top">D4-1 您现在常喝酒吗？ 
     <label><input type="radio" name="d41" id="radio75" value="1" />是</label>  
     <label><input type="radio" name="d41" id="radio76" value="2" />否</label> </td>
    <td colspan="2" valign="top">D4-2 您过去常喝酒吗？
    <label><input type="radio" name="d42" id="radio75" value="1" />是</label>  
    <label><input type="radio" name="d42" id="radio76" value="2" />否</label></td>
  </tr>
</table>
<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" id="information4" 
class="table  table-hover table-striped tab-pane fade">
  <tr>
    <td colspan="2" valign="top"><strong>E 日常活动能力 </strong></td>
  </tr>
  <tr>
    <td width="40%"  valign="top">E1 您洗澡时是否需要他人帮助（包括擦洗上身或下身）？ </td>
    <td width="60%" valign="top">
      <label><input type="radio" name="e1" id="radio164" value="1" />不需要任何帮助</label> 
      <label><input type="radio" name="e1" id="radio165" value="2" />某一部位需要帮助 </label>
      <label><input type="radio" name="e1" id="radio166" value="3" />两个部位以上需要帮助 </label></td>
  </tr>
  <tr>
    <td  valign="top">E2    您穿衣时是否需要他人帮助（包括找衣和穿衣）？ </td>
    <td valign="top">
    <label><input type="radio" name="e2" id="radio167" value="1" />自己能找到并穿上衣服，无需任何帮助</label> 
    <label><input type="radio" name="e2" id="radio168" value="2" />能找到并穿上衣服，但自己不能穿鞋 </label>
    <label><input type="radio" name="e2" id="radio169" value="3" />需要他人帮助找衣或穿衣</label> </td>
  </tr>
  <tr>
    <td  valign="top">E3 您上厕所大小便时是否需要他人帮助（包括便后洗手、解衣穿衣，包括在房间中用马桶大小便。）？ </td>
    <td  valign="top">
      <label><input type="radio" name="e3" id="radio170" value="1" /> 完全能独立，无需帮助 </label>
      <label><input type="radio" name="e3" id="radio171" value="2" />能自己料理，但需要他人帮助 </label>
      <label><input type="radio" name="e3" id="radio172" value="3" />卧床不起，只能在床上由他人帮助使用便盆等</label> </td>
  </tr>
  <tr>
    <td  valign="top">E4在室内活动时您是否需要他人帮助（室内活动指上下床、坐在椅子或凳子上或从椅子或凳子上站起来）？ </td>
    <td  valign="top">
      <label><input type="radio" name="e4" id="radio173" value="1" />无需帮助，可用辅助设施</label> 
      <label><input type="radio" name="e4" id="radio174" value="2" />需要帮助  </label>
      <label><input type="radio" name="e4" id="radio175" value="3" />卧床不起 </label></td>
  </tr>
  <tr>
    <td  valign="top">E5 您是否能控制大小便？ </td>
    <td  valign="top">
      <label><input type="radio" name="e5" id="radio176" value="1" />能控制大小便 </label>
      <label><input type="radio" name="e5" id="radio177" value="2" />偶尔/有时失禁 </label>
      <label><input type="radio" name="e5" id="radio178" value="3" />使用导管等协助控制或不能控制</label> </td>
  </tr>
   <tr>
    <td  valign="top">E6    您吃饭时是否需要他人帮助？（吃饭无需帮助是指吃饭时不需他人帮助，自己能独立进餐。） </td>
    <td  valign="top">
      <label><input type="radio" name="e6" id="radio161" value="1" /> 吃饭无需帮助 </label>
      <label><input type="radio" name="e6" id="radio162" value="2" />能自己吃饭，但需要一些帮助</label> 
      <label><input type="radio" name="e6" id="radio163" value="3" />完全由他人喂食</label> </td>
  </tr>
</table>
<table width="100%" border="1" align="center" cellpadding="0" id="information5" cellspacing="0" 
class="table  table-hover table-striped tab-pane fade">
  <tr>
    <td colspan="2" valign="top"><strong>F</strong><strong>活动与参与 </strong></td>
  </tr>
  <tr>
    <td width="32%"  valign="top">F1-1 您现在是否经常锻炼身体？（指有目的的健身活动，如散步，打球，跑步，气功等。） </td>
    <td width="68%"  valign="top">
    <label><input type="radio" name="f11" id="radio75" value="1" />是</label>  
    <label><input type="radio" name="f11" id="radio76" value="2" />否</label></td>
  </tr>
  <tr>
    <td  valign="top">F1-2 您过去是否经常锻炼身体？ </td>
    <td  valign="top">
    <label><input type="radio" name="f12" id="radio75" value="1" />是</label>  
    <label><input type="radio" name="f12" id="radio76" value="2" />否</label></td>
  </tr>
  <tr>
    <td  valign="top">F2-1 您过去是否经常从事体力劳动？ </td>
    <td  valign="top">
    <label><input type="radio" name="f21" id="radio75" value="1" />是</label>  
    <label><input type="radio" name="f21" id="radio76" value="2" />否</label></td>
  </tr>
  <tr>
    <td  valign="top" colspan="2">F3您现在从事/参加以下活动吗？ </td>
   
  </tr>
  <tr>
    <td >F3-1家务（做饭，带小孩） </td>
    <td >
      <label><input type="radio" name="f31" id="radio185" value="1" />几乎每天;</label> 
      <label><input type="radio" name="f31" id="radio186" value="2" />不是每天，但每周至少一次;</label>
      <label><input type="radio" name="f31" id="radio187" value="3" />不是每周，但每月至少一次; </label>
      <label><input type="radio" name="f31" id="radio188" value="4" />不是每月;但有时;</label>
      <label><input type="radio" name="f31" id="radio189" value="5" />不参加 </label></td>
  </tr>
  <tr>
    <td >F3-2种菜 </td>
    <td > 
      <label><input type="radio" name="f32" id="radio185" value="1" />几乎每天;</label> 
      <label><input type="radio" name="f32" id="radio186" value="2" />不是每天，但每周至少一次;</label>
      <label><input type="radio" name="f32" id="radio187" value="3" />不是每周，但每月至少一次; </label>
      <label><input type="radio" name="f32" id="radio188" value="4" />不是每月;但有时;</label>
      <label><input type="radio" name="f32" id="radio189" value="5" />不参加 </label></td>
  </tr>
  <tr>
    <td >F3-3园艺 </td>
    <td >
      <label><input type="radio" name="f33" id="radio185" value="1" />几乎每天;</label> 
      <label><input type="radio" name="f33" id="radio186" value="2" />不是每天，但每周至少一次;</label>
      <label><input type="radio" name="f33" id="radio187" value="3" />不是每周，但每月至少一次; </label>
      <label><input type="radio" name="f33" id="radio188" value="4" />不是每月;但有时;</label>
      <label><input type="radio" name="f33" id="radio189" value="5" />不参加 </label></td>
  </tr>
  <tr>
    <td >F3-5读书看报/上网 </td>
    <td >
      <label><input type="radio" name="f34" id="radio185" value="1" />几乎每天;</label> 
      <label><input type="radio" name="f34" id="radio186" value="2" />不是每天，但每周至少一次;</label>
      <label><input type="radio" name="f34" id="radio187" value="3" />不是每周，但每月至少一次; </label>
      <label><input type="radio" name="f34" id="radio188" value="4" />不是每月;但有时;</label>
      <label><input type="radio" name="f34" id="radio189" value="5" />不参加 </label></td>
  </tr>
  <tr>
    <td >F3-5饲养家禽、家畜 </td>
    <td >
      <label><input type="radio" name="f35" id="radio185" value="1" />几乎每天;</label> 
      <label><input type="radio" name="f35" id="radio186" value="2" />不是每天，但每周至少一次;</label>
      <label><input type="radio" name="f35" id="radio187" value="3" />不是每周，但每月至少一次; </label>
      <label><input type="radio" name="f35" id="radio188" value="4" />不是每月;但有时;</label>
      <label><input type="radio" name="f35" id="radio189" value="5" />不参加 </label></td>
  </tr>
  <tr>
    <td >F3-6打牌或打麻将等 </td>
    <td >
      <label><input type="radio" name="f36" id="radio185" value="1" />几乎每天;</label> 
      <label><input type="radio" name="f36" id="radio186" value="2" />不是每天，但每周至少一次;</label>
      <label><input type="radio" name="f36" id="radio187" value="3" />不是每周，但每月至少一次; </label>
      <label><input type="radio" name="f36" id="radio188" value="4" />不是每月;但有时;</label>
      <label><input type="radio" name="f36" id="radio189" value="5" />不参加 </label></td>
  </tr>
  <tr>
    <td >F3-7看电视听广播 </td>
    <td >
      <label><input type="radio" name="f37" id="radio185" value="1" />几乎每天;</label> 
      <label><input type="radio" name="f37" id="radio186" value="2" />不是每天，但每周至少一次;</label>
      <label><input type="radio" name="f37" id="radio187" value="3" />不是每周，但每月至少一次; </label>
      <label><input type="radio" name="f37" id="radio188" value="4" />不是每月;但有时;</label>
      <label><input type="radio" name="f37" id="radio189" value="5" />不参加 </label></td>
  </tr>
  <tr>
    <td >F3-8参加社会活动 <br />
      （有组织的活动） </td>
    <td >
      <label><input type="radio" name="f38" id="radio185" value="1" />几乎每天;</label> 
      <label><input type="radio" name="f38" id="radio186" value="2" />不是每天，但每周至少一次;</label>
      <label><input type="radio" name="f38" id="radio187" value="3" />不是每周，但每月至少一次; </label>
      <label><input type="radio" name="f38" id="radio188" value="4" />不是每月;但有时;</label>
      <label><input type="radio" name="f38" id="radio189" value="5" />不参加 </label></td>
  </tr>
  <tr>
    <td  valign="top">F4近两年里您外出旅游过多少次？ </td>
    <td  valign="top">
      <input name="f4" type="number" id="textfield6" size="5" />次（未外出旅游的填00） </td>
  </tr>
</table>
<table width="100%" border="1" cellpadding="0" cellspacing="0" id="information6"
 class="table  table-hover table-striped tab-pane fade">
  <tr>
    <td colspan="2" >
      <strong>G身体状况</strong>（<strong>医生检查后由访问员填写</strong>） </td>
  </tr>
  <tr>
    <td >G1 不戴眼镜, 您看这个圆圈有没有开口? 如有，开口在什么地方（上，下，左，右）？（用手电筒照访问员手册上视力表上的圆圈。）</td>
    <td>
    <label><input type="radio" name="g1" id="radio230" value="1" />能, 且能分清缺口方向</label>.  
    <label><input type="radio" name="g1" id="radio231" value="2" />能, 但不能分清缺口方向 </label>
    <label><input type="radio" name="g1" id="radio232" value="3" /> 看不清 </label>
    <label><input type="radio" name="g1" id="radio233" value="4" />失明</label></td>
  </tr>
  <tr>
    <td>G2    您现在是否患有下列疾病？</td>
    <td width="617"  >是否有病？(自报) 1. 有 2. 没有 3. 不知道</td>
  </tr>
  <tr>
    <td>01．高血压</td>
    <td>
    <label><input type="radio" name="g01" id="radio" value="1" />有</label>
    <label><input type="radio" name="g01" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g01" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>02．糖尿病</td>
    <td>
    <label><input type="radio" name="g02" id="radio" value="1" />有</label>
    <label><input type="radio" name="g02" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g02" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>03．心脏病</td>
    <td>
    <label><input type="radio" name="g03" id="radio" value="1" />有</label>
    <label><input type="radio" name="g03" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g03" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>04．中风及脑血管疾病</td>
    <td>
    <label><input type="radio" name="g04" id="radio" value="1" />有</label>
    <label><input type="radio" name="g04" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g04" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>05．支气管炎，肺气肿，哮喘病或肺炎</td>
    <td>
    <label><input type="radio" name="g05" id="radio" value="1" />有</label>
    <label><input type="radio" name="g05" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g05" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>06．肺结核</td>
    <td>
    <label><input type="radio" name="g06" id="radio" value="1" />有</label>
    <label><input type="radio" name="g06" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g06" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>07．白内障</td>
    <td>
    <label><input type="radio" name="g07" id="radio" value="1" />有</label>
    <label><input type="radio" name="g07" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g07" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>08．青光眼</td>
    <td>
    <label><input type="radio" name="g08" id="radio" value="1" />有</label>
    <label><input type="radio" name="g08" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g08" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>09．癌症</td>
    <td>
    <label><input type="radio" name="g09" id="radio" value="1" />有</label>
    <label><input type="radio" name="g09" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g09" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>10．前列腺疾病</td>
    <td>
    <label><input type="radio" name="g10" id="radio" value="1" />有</label>
    <label><input type="radio" name="g10" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g10" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>11．胃肠溃疡</td>
    <td>
    <label><input type="radio" name="g11" id="radio" value="1" />有</label>
    <label><input type="radio" name="g11" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g11" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>12．帕金森氏病</td>
    <td>
    <label><input type="radio" name="g12" id="radio" value="1" />有</label>
    <label><input type="radio" name="g12" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g12" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>13．褥疮</td>
    <td>
    <label><input type="radio" name="g13" id="radio" value="1" />有</label>
    <label><input type="radio" name="g13" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g13" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>14．关节炎</td>
    <td>
    <label><input type="radio" name="g14" id="radio" value="1" />有</label>
    <label><input type="radio" name="g14" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g14" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
    <td>15．痴呆</td>
    <td>
    <label><input type="radio" name="g15" id="radio" value="1" />有</label>
    <label><input type="radio" name="g15" id="radio2" value="2" />没有</label>
    <label><input type="radio" name="g15" id="radio3" value="3" />不知道</label></td>
  </tr>
  <tr>
  <td colspan="2" align="right"><button onClick="myCheck()">提交</button></td>
  </tr>
</table>
<input type="hidden" value="${userId}" name="userId"/>
</div>
</form>

<script type="text/javascript">  

	//绑定beforeunload事件 
		$(window).bind('beforeunload',function(){ 
		return '您输入的内容尚未保存，确定离开此页面吗？'; 
		}); 
		//解绑
		//$(window).unbind('beforeunload'); 
          function myCheck() {  
           
            var radioname;
   			//var arrRadio = new Array();
			var arrRadio = [];
			var inputs=document.getElementsByTagName("input");
			for(var i=0;i<inputs.length;i++) {
				if(inputs[i].type=="radio" || inputs[i].type=="checkbox"){
					if (radioname !=inputs[i].name){
	                arrRadio.push(inputs[i].name);
	                radioname =inputs[i].name
	                }
				}
				
				//&& (inputs[i].value!=null||inputs[i].value!=undefined)
				if(inputs[i].type=="number" &&inputs[i].value==""){
					alert(inputs[i].value+"本问卷所有输入框不能为空！");
					inputs[i].focus();
					return false;
				}
			}
			for (var i=0;i<arrRadio.length;i++) {
      		var bRadio=false;
      			for (var j=0;j<document.getElementsByName(arrRadio[i]).length;j++) {
         			if (document.getElementsByName(arrRadio[i]).item(j).checked==true){
              		bRadio=true;
              		continue;
          			}
      			}
      			if (!bRadio){
            		alert("当前页面单选框和复选框不能有空项！");
            		return false;
      			}
   			}
			$('#form').attr('action','$request.contextPath/handle');
			$(window).unbind('beforeunload'); 
   			$("#form").submit();
         }  
</script>  
</body>
</html>
