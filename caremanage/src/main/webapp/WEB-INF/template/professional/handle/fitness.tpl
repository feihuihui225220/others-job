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
<script src="$request.contextPath/assets/js/My97DatePicker/WdatePicker.js"></script> 
<script src="$request.contextPath/assets/js/jquery.validate.js"></script>
</head>

<body>
<form action="$request.contextPath/fitness/added" id="form"  method="post"  name="myForm" onsubmit="return validateForm()">
<div id="myTabContent" class="tab-content" style="background-color: #fff;">
<table id="information" width="100%" border="1" align="center" cellpadding="0" cellspacing="0" 
 class="table  table-hover table-striped tab-pane fade in active">
  <tr>
    <td  colspan="2" valign="top">
      <strong> A</strong><strong>体适能评估 </strong></td>
  </tr>

  <tr>
     <td valign="top">1、年龄：
     <input name="age" type="text"  id="age" size="6" value="$user.age" />周岁
     </td>
  </tr>
  <tr>
    <td valign="top">2、30秒坐站: 
      <input name="result1" type="text" id="result1" size="6" />
次</td>
  </tr>
 <tr>
    <td valign="top">3、两分钟抬腿: 
      <input name="result2" type="text" id="result2" size="6" />
次</td>
  </tr>
  <tr>
    <td valign="top">4、双手背后相扣: 
      <input name="result3" type="text" id="result3" size="6" />
cm</td>
  </tr>
  <tr>
    <td valign="top">5、2.44米折返跑坐: 
      <input name="result4" type="text" id="result4" size="6" />
秒</td>
   </tr>
   <tr>
    <td valign="top">6、握力: 
      <input name="result5" type="text" id="result5" size="6" />
kg</td>
   </tr>
   <tr>
    <td valign="top">7、体脂百分数: 
      <input name="result61" type="text" id="result61" size="20" placeholder="这里输入体重（kg）" />
      <input name="result62" type="text" id="result62" size="20"  placeholder="这里输入身高（m）"/>
    </td>
   </tr>
   <tr>
    <td valign="top">8、腰臀比:
      <input name="result71" type="text" id="result71" size="20"  placeholder="这里输入腰围（cm）" />
      <input name="result72" type="text" id="result72" size="20"  placeholder="这里输入臀围（cm）"  />
    </td>
   </tr>
   <tr>
    <td valign="top">9、座椅体前屈: 
      <input name="result8" type="text" id="result8" size="6" />cm
     </td>
   
  </tr>
   <tr> 
    <td valign="top">10、30秒手臂卷起: 
      <input name="result9" type="text" id="result9" size="6" />cm
     </td>
     <tr/>
      <tr> 
    <td valign="top">11、闭眼硬表面: 
      <input name="result10" type="text" id="result10" size="6" />cm
     </td>
     <tr/>
      <tr> 
    <td valign="top">12、闭眼软表面: 
      <input name="result11" type="text" id="result11" size="6" />cm
     </td>
     <tr/>
      <tr> 
    <td valign="top">13、睁眼软表面: 
      <input name="result12" type="text" id="result12" size="6" />cm
     </td>
     <tr/>
     <tr> 
    <td valign="top">14、睁眼硬表面: 
      <input name="result13" type="text" id="result13" size="6" />cm
     </td>
     <tr/>
  <tr><td>15、测试时间：
     <input name="create_time" type=text onClick="WdatePicker()">
  </td></tr>
   <tr>
    <td> 
    <input type="submit" value="提交" style="width:70px;height:45px;">
    <input type="submit" value="返回" style="width:70px;height:45px;" onclick="javascript:history.go(-1)">
    </td>

  </tr>
  </table>
  <input type="hidden" value="${user.id}" name="userId"/>
  </div>
 </form> 
<script>
function validateForm()
{
var age = document.forms["myForm"]["age"].value;
if (age ==null || age=="")
  {
  alert("年龄必须填写");
  return false;
  } 
  if( age < 45 )
  {
  alert("年龄不能小于45");
  return false;
  }
}
</script>
   </body>
</html>