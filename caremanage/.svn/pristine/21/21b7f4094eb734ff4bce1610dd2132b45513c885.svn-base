<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>用户管理</title>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
<link href="/assets/director/styles/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/assets/director/styles/table.css" type="text/css">
<style type="text/css">
.title1{padding-left: 245px;}
</style>
</head>
<body>
#parse("/common/dtop.tpl")
#parse("/common/duser.tpl")
<div class="main1">
	#parse("/common/dleft.tpl")
	 <input type="hidden" class="userId" value="$dirUser.id">
	 <div style="padding-left:180px;" >
	 <select name="sel" id="sel" onchange="sel_div(this)" style="margin-top:10px;width: 200px;height: 30px;position: relative;top:38px;">
    <option value="d_1"> 血常规</option>
    <option value="d_2"> 尿常规</option>
    <option value="d_3"> DIC相关检查</option>
    <option value="d_4"> 肝功能</option>
    <option value="d_5"> 肾功能</option>
    <option value="d_6">电解质</option>
    <option value="d_7"> 血气分析</option>
    <option value="d_8">激素</option>
    <option value="d_9"> 血脂</option>
    <option value="d_10">体液免疫</option>
    <option value="d_11"> 细胞免疫</option>
    <option value="d_12">肝炎病毒</option>
    </select>	 
	 </div>	 
	 	 
	 <div style="padding-left:180px;" id="d_1">
	 <label class="title1">血常规</label>
	 <input type="button"  value="添加" date-id="$!hrt.id" class="btnBg " onclick="add1()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/hrtList?userId=${dirUser.id}'"><br> 
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	 <label class="lab_1 ">白细胞（WBC）</label><label class="lab_2 ">(3.97~9.15)X10<sup>9</sup>/L</label><label class="lab_3 "><input readonly="readonly" class="input_compile1 input_compile whiteBloodCell"  value="$hrt.whiteBloodCell"></label>
	 <label class="lab_1 ">中性粒细胞</label><label class="lab_2 ">50%~70%(2.00~7.00)X10<sup>9</sup>/L</label><label class="lab_3 "><input readonly="readonly" class="input_compile neutrophilicGranulocyte"  value="$hrt.neutrophilicGranulocyte"></label>
	 <label class="lab_1 ">嗜酸性粒细胞</label><label class="lab_2 ">0.5%~5.0%(0.02~0.50)X10<sup>9</sup>/L<br></label><label  class="lab_3 "><input readonly="readonly" class="input_compile eosinophileGranulocyte" value="$hrt.eosinophileGranulocyte"></label>
	 <label class="lab_1 ">嗜碱性粒细胞<br><br></label><label class="lab_2 "><1.0%<br><p>>1.0%X10<sup>9</sup>/L</p></label><label class="lab_3 "><input readonly="readonly" class="input_compile basophileGranulocyte"   value="$hrt.basophileGranulocyte"><br><br></label>
	 <label class="lab_1 ">单核细胞<br><br></label><label class="lab_2 ">3%~10%<br><p>(0.12%~1.0%)X10<sup>9</sup></p></label><label class="lab_3 "><input readonly="readonly" class="input_compile monocyte"  value="$hrt.monocyte"><br><br></label>
	 <label class="lab_1 ">淋巴细胞<br><br></label><label class="lab_2 ">20%~40%<br><p>(0.80%~4.00%)X10<sup>9</sup>/L</p></label><label class="lab_3 "><input readonly="readonly" class="input_compile lymphocyte"   value="$hrt.lymphocyte"><br><br></label>
	 <label class="lab_1 ">红细胞（RBC）</label><label class="lab_2 ">(4.09%~5.7)X10<sup>12</sup>/L</label><label class="lab_3 "><input readonly="readonly" class="input_compile redBloodCell"   value="$hrt.redBloodCell"></label>
	 <label class="lab_1 ">血红蛋白（HB）</label><label class="lab_2 ">(131~172)g/L</label><label class="lab_3 "><input readonly="readonly" class="input_compile hemoglobin"   value="$hrt.hemoglobin"></label>
	 <label class="lab_1 ">血小板（PLT）</label><label class="lab_2 ">(85~303)X10<sup>9</sup>/L</label><label class="lab_3 "><input readonly="readonly" class="input_compile platelet"   value="$hrt.platelet"></label>
	 <label class="lab_1 ">红细胞沉降率（ESR）<br><br></label><label class="lab_2 ">男(0~15)mm/h<br><p>女(0~15)mm/h</p></label><label class="lab_3 "><input readonly="readonly" class="input_compile esr"  value="$hrt.esr"><br><br></label>
	 </div>
	 	  
<form action="$request.contextPath/director/hBloodRoutine" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light1" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">白细胞（WBC）:</div> <div class="bioch3"><input type="text" name="whiteBloodCell"/></div></div>
       <div class="bioch1"><div class="bioch2">中性粒细胞:</div> <div class="bioch3"><input type="text" name="neutrophilicGranulocyte" /></div></div>
       <div class="bioch1"><div class="bioch2">嗜酸性粒细胞:</div> <div class="bioch3"><input type="text" name="eosinophileGranulocyte"/></div></div>
       <div class="bioch1"><div class="bioch2">嗜碱性粒细胞:</div> <div class="bioch3"><input type="text" name="basophileGranulocyte"/></div></div>
       <div class="bioch1"><div class="bioch2">单核细胞:</div> <div class="bioch3"><input type="text" name="monocyte"/></div></div>
       <div class="bioch1"><div class="bioch2">淋巴细胞:</div> <div class="bioch3"><input type="text" name="lymphocyte"/></div></div>
       <div class="bioch1"><div class="bioch2">红细胞（RBC）:</div> <div class="bioch3"><input type="text" name="redBloodCell"/></div></div>
       <div class="bioch1"><div class="bioch2">血红蛋白（HB）:</div> <div class="bioch3"><input type="text" name="hemoglobin"/></div></div>
       <div class="bioch1"><div class="bioch2">血小板（PLT）:</div> <div class="bioch3"><input type="text" name="platelet"/></div></div>
       <div class="bioch1"><div class="bioch2">红细胞沉降率（ESR）:</div> <div class="bioch3"><input type="text" name="esr"/></div></div>      
       <input class="bio1 btnBg sub_" style="margin-left: 230px;"   type="submit"  value="提交">
       
       <input class="bio2 btnBg" type="button" value="取消" onclick="move1()">
      </div>     
</form>
	 
	 	 
	 <div style="padding-left:180px;display:none;" id="d_2">
	 <label class="title1" >尿常规</label>
	 <input type="button"  value="添加" date-id="$!uri.id" class="btnBg" onclick="add2()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/uriList?userId=${dirUser.id}'"><br> 
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	 <label class="lab_1 ">尿比重</label><label class="lab_2 ">1.005~1.030</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile urineSpecificGravity" value="$uri.urineSpecificGravity"></label>
	 <label class="lab_1 ">酸碱度（PH）</label><label class="lab_2 ">5.0~9.0</label><label class="lab_3 "><input readonly="readonly"   class="input_compile ph" value="$uri.ph"></label>
	 <label class="lab_1 ">白细胞（WBC）</label><label class="lab_2 ">(0~5)/HP</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile whiteBloodCell" value="$uri.whiteBloodCell"></label>
	 <label class="lab_1 ">红细胞（RBC）</label><label class="lab_2 ">（0~3）/Hp</label><label class="lab_3 "><input readonly="readonly"   class="input_compile redBloodCell" value="$uri.redBloodCell"></label>
	 <label class="lab_1 ">亚硝酸盐</label><label class="lab_2 ">定性：阴性</label><label class="lab_3 "><input readonly="readonly"   class="input_compile nitrite" value="$uri.nitrite"></label>
	 <label class="lab_1 ">蛋白质<br><br></label><label class="lab_2 ">定性：阴性   <br> <p>定量：（24~150）mg/24h</p></label><label class="lab_3 "><input readonly="readonly"   class="input_compile protein" value="$uri.protein"><br><br></label>
	 <label class="lab_1 ">葡萄糖（RBC）</label><label class="lab_2 ">定性：阴性</label><label class="lab_3 "><input readonly="readonly"   class="input_compile glucose" value="$uri.glucose"></label>
	  <label class="lab_1 ">酮体 </label><label class="lab_2 ">定性： 阴性 </label><label class="lab_3 "><input readonly="readonly"   class="input_compile ketone" value="$uri.ketone"></label>
	 <label class="lab_1 ">尿胆原 </label><label class="lab_2 ">定性：弱阳性  </label><label class="lab_3 "><input readonly="readonly"   class="input_compile urinaryBladder" value="$uri.urinaryBladder"></label>
	 <label class="lab_1 ">尿胆红素 </label><label class="lab_2 ">定性：阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile urineBilirubin" value="$uri.urineBilirubin"></label>
	 </div>
	 
<form action="$request.contextPath/director/hUrineRoutine" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light2" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">尿比重:</div> <div class="bioch3"><input type="text" name="urineSpecificGravity"/></div></div>
       <div class="bioch1"><div class="bioch2">酸碱度（PH）:</div> <div class="bioch3"><input type="text" name="ph" /></div></div>
       <div class="bioch1"><div class="bioch2">白细胞（WBC）:</div> <div class="bioch3"><input type="text" name="whiteBloodCell"/></div></div>
       <div class="bioch1"><div class="bioch2">红细胞（RBC）:</div> <div class="bioch3"><input type="text" name="redBloodCell"/></div></div>
       <div class="bioch1"><div class="bioch2">亚硝酸盐:</div> <div class="bioch3"><input type="text" name="nitrite"/></div></div>
       <div class="bioch1"><div class="bioch2">蛋白质:</div> <div class="bioch3"><input type="text" name="protein"/></div></div>
       <div class="bioch1"><div class="bioch2">葡萄糖（RBC）:</div> <div class="bioch3"><input type="text" name="glucose"/></div></div>
       <div class="bioch1"><div class="bioch2">酮体:</div> <div class="bioch3"><input type="text" name="ketone"/></div></div>
       <div class="bioch1"><div class="bioch2">尿胆原:</div> <div class="bioch3"><input type="text" name="urinaryBladder"/></div></div>
       <div class="bioch1"><div class="bioch2">尿胆红素:</div> <div class="bioch3"><input type="text" name="urineBilirubin"/></div></div>      
       <input class="bio1 btnBg sub_"  style="margin-left: 230px;"  type="submit"  value="提交">
       <input class="bio2 btnBg"  value="取消" onclick="move2()">
      </div>     
</form>

	 <div style="padding-left:180px;display:none;" id="d_3">
	 <label class="title1">DIC相关检查</label>
	 <input type="button"  value="添加" date-id="$!dic.id" class="btnBg" onclick="add3()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/dicList?userId=${dirUser.id}'"><br> 
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	  <label class="lab_1 ">活化部分凝血酶原时间（APTT）</label><label class="lab_2 ">（27.3~41.0）s</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile aptt" value="$dic.aptt"></label>
	 <label class="lab_1 ">凝血酶原时间（PT）</label><label class="lab_2 ">（10.0~16.0）s</label><label class="lab_3 "><input readonly="readonly"   class="input_compile pt" value="$dic.pt"></label>
	 <label class="lab_1 ">凝血酶时间（TT）</label><label class="lab_2 ">(14.00~21.00)s</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile tt" value="$dic.tt"></label>
	 <label class="lab_1 ">纤维蛋白原（Fg）</label><label class="lab_2 ">(1.8~4.0)g/L </label><label class="lab_3 "><input readonly="readonly"   class="input_compile fg" value="$dic.fg"></label>
	 <label class="lab_1 ">纤维蛋白原降解产物（FDPs）</label><label class="lab_2 ">＜5μg/ml </label><label class="lab_3 "><input readonly="readonly"   class="input_compile fdps" value="$dic.fdps"></label>
	 <label class="lab_1 ">D二聚体 </label><label class="lab_2 ">＜0.25μg/ml</label><label class="lab_3 "><input readonly="readonly"   class="input_compile dimer" value="$dic.dimer"></label>
	  </div>
	 
<form action="$request.contextPath/director/hDicCheck" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light3" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">活化部分凝血酶原时间（APTT）:</div> <div class="bioch3"><input type="text" name="aptt"/></div></div>
       <div class="bioch1"><div class="bioch2">凝血酶原时间（PT）:</div> <div class="bioch3"><input type="text" name="pt" /></div></div>
       <div class="bioch1"><div class="bioch2">凝血酶时间（TT）:</div> <div class="bioch3"><input type="text" name="tt"/></div></div>
       <div class="bioch1"><div class="bioch2">纤维蛋白原（Fg）:</div> <div class="bioch3"><input type="text" name="fg"/></div></div>
       <div class="bioch1"><div class="bioch2">纤维蛋白原降解产物（FDPs）:</div> <div class="bioch3"><input type="text" name="fdps"/></div></div>
       <div class="bioch1"><div class="bioch2">D二聚体:</div> <div class="bioch3"><input type="text" name="dimer"/></div></div>      
       <input class="bio1 btnBg sub_" style="margin-left: 230px;"  type="submit"  value="提交">
       <input class="bio2 btnBg"  value="取消" onclick="move3()">
      </div>     
</form>	 


	  <div style="padding-left:180px;display:none;" id="d_4">
	 <label class="title1">肝功能检查</label>
	 <input type="button"  value="添加" date-id="$!hli.id" class="btnBg" onclick="add4()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/hliList?userId=${dirUser.id}'"><br> 
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	   <label class="lab_1 ">前白蛋白</label><label class="lab_2 ">(180~380)mg/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile preAlbumin" value="$hli.preAlbumin"></label>
	 <label class="lab_1 ">总蛋白</label><label class="lab_2 ">(60~83)g/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile totalProtein" value="$hli.totalProtein"></label>
	 <label class="lab_1 ">白蛋白 <br><br></label><label class="lab_2 ">(35~55)g/L</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile albumin" value="$hli.albumin"></label>
	 <label class="lab_1 ">白蛋白/球蛋白比值（A/G） </label><label class="lab_2 ">1.25~2.5</label><label class="lab_3 "><input readonly="readonly"   class="input_compile albuminRatio" value="$hli.albuminRatio"></label>
	 <label class="lab_1 ">丙氨酸氨基转移酶或谷丙转氨酶（ALT或GPT）</label><label class="lab_2 ">(10~64)U/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile atl" value="$hli.atl"></label>
	 <label class="lab_1 ">天冬氨酶氨基转移酶或谷草转氨酶(AST或GOT)</label><label class="lab_2 ">(8~40) U/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile ast" value="$hli.ast"></label>
	 <label class="lab_1 ">碱性磷酸酶（AKP）</label><label class="lab_2 ">（38~126）U/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile akp" value="$hli.akp"></label>
	 <label class="lab_1 ">γ谷氨酰转肽酶（γ-GT</label><label class="lab_2 ">（7~64）U/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile gt" value="$hli.gt"></label>
	 <label class="lab_1 ">血淀粉酶  </label><label class="lab_2 ">（36~128）U/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile serumAmylase" value="$hli.serumAmylase"></label>
	 <label class="lab_1 ">总胆红素</label><label class="lab_2 ">（5.1~20.5）μmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile totalBilirubin" value="$hli.totalBilirubin"></label>
	 <label class="lab_1 ">直接胆红素</label><label class="lab_2 "> (0~6.8) μmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile directBilirubin" value="$hli.directBilirubin"></label>
	  </div>
	 
<form action="$request.contextPath/director/hLiverFunction" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light4" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">前白蛋白:</div> <div class="bioch3"><input type="text" name="preAlbumin"/></div></div>
       <div class="bioch1"><div class="bioch2">总蛋白:</div> <div class="bioch3"><input type="text" name="totalProtein" /></div></div>
       <div class="bioch1"><div class="bioch2">白蛋白 :</div> <div class="bioch3"><input type="text" name="albumin"/></div></div>
       <div class="bioch1"><div class="bioch2">白蛋白/球蛋白比值（A/G）:</div> <div class="bioch3"><input type="text" name="albuminRatio"/></div></div>
       <div class="bioch1"><div class="bioch2">丙氨酸氨基转移酶或谷丙转氨酶（ALT或GPT）:</div> <div class="bioch3"><input type="text" name="atl"/></div></div>
       <div class="bioch1"><div class="bioch2">天冬氨酶氨基转移酶或谷草转氨酶(AST或GOT):</div> <div class="bioch3"><input type="text" name="ast"/></div></div>
        <div class="bioch1"><div class="bioch2">碱性磷酸酶（AKP）:</div> <div class="bioch3"><input type="text" name="akp"/></div></div>
       <div class="bioch1"><div class="bioch2">γ谷氨酰转肽酶（γ-GT）:</div> <div class="bioch3"><input type="text" name="gt" /></div></div>
       <div class="bioch1"><div class="bioch2">血淀粉酶:</div> <div class="bioch3"><input type="text" name="serumAmylase"/></div></div>
       <div class="bioch1"><div class="bioch2">总胆红素:</div> <div class="bioch3"><input type="text" name="totalBilirubin"/></div></div>
       <div class="bioch1"><div class="bioch2">直接胆红素:</div> <div class="bioch3"><input type="text" name="directBilirubin"/></div></div>            
       <input class="bio1 btnBg sub_" style="margin-left: 230px;" type="submit"  value="提交">
       <input class="bio2 btnBg"  value="取消" onclick="move4()">
      </div>     
</form>	 

	 <div style="padding-left:180px;display:none;" id="d_5">
	 <label class="title1">肾功能检查</label>
	 <input type="button"  value="添加" date-id="$!hre.id" class="btnBg" onclick="add5()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/hreList?userId=${dirUser.id}'"><br> 
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	  <label class="lab_1 ">尿素氮（BUN）</label><label class="lab_2 "> (2.50~7.10) mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile bun" value="$hre.bun"></label>
	 <label class="lab_1 ">肌酐（Cr）</label><label class="lab_2 ">（53~97）μmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile cr" value="$hre.cr"></label>
	 <label class="lab_1 ">尿酸  <br><br></label><label class="lab_2 ">（16~430）μmol/L</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile uricAcid" value="$hre.uricAcid"></label>
	 <label class="lab_1 ">血糖   </label><label class="lab_2 ">（3.90~6.10）mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile bloodSugar" value="$hre.bloodSugar"></label>
	 </div>
	 
<form action="$request.contextPath/director/hRenalFunction" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light5" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">尿素氮（BUN）:</div> <div class="bioch3"><input type="text" name="bun"/></div></div>
       <div class="bioch1"><div class="bioch2">肌酐（Cr）:</div> <div class="bioch3"><input type="text" name="cr" /></div></div>
       <div class="bioch1"><div class="bioch2">尿酸:</div> <div class="bioch3"><input type="text" name="uricAcid"/></div></div>
       <div class="bioch1"><div class="bioch2">血糖:</div> <div class="bioch3"><input type="text" name="bloodSugar"/></div></div>
       <input class="bio1 btnBg sub_" style="margin-left: 230px;"  type="submit"  value="提交">
       <input class="bio2 btnBg" value="取消" onclick="move5()">
      </div>     
</form>	 
	 
	 
	 <div style="padding-left:180px;display:none;" id="d_6">
	 <label class="title1">电解质</label>
	 <input type="button"  value="添加" date-id="$!elect.id" class="btnBg" onclick="add6()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/electList?userId=${dirUser.id}'"><br> 
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	 <label class="lab_1 ">钾  </label><label class="lab_2 ">(3.5~5.1) mmol/</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile potassium" value="$elect.potassium"></label>
	 <label class="lab_1 ">钠   </label> <label class="lab_2 ">(13~147) mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile sodium" value="$elect.sodium"></label>
	 <label class="lab_1 ">氯 </label><label class="lab_2 ">(96~108) mmol/L</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile chlorine" value="$elect.chlorine"></label>
	 <label class="lab_1 ">钙   </label><label class="lab_2 "> (2.00~2.75) mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile calcium" value="$elect.calcium"></label>
	 <label class="lab_1 ">磷  </label><label class="lab_2 "> (0.8~1.6) mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile phosphorus" value="$elect.phosphorus"></label>
	  </div>

<form action="$request.contextPath/director/hElectrolyte" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light6" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">钾:</div> <div class="bioch3"><input type="text" name="potassium"/></div></div>
       <div class="bioch1"><div class="bioch2">钠:</div> <div class="bioch3"><input type="text" name="sodium" /></div></div>
       <div class="bioch1"><div class="bioch2">氯:</div> <div class="bioch3"><input type="text" name="chlorine"/></div></div>
       <div class="bioch1"><div class="bioch2">钙:</div> <div class="bioch3"><input type="text" name="calcium"/></div></div>
       <div class="bioch1"><div class="bioch2">磷:</div> <div class="bioch3"><input type="text" name="phosphorus"/></div></div>
       <input class="bio1 btnBg sub_" style="margin-left: 230px;" type="submit"  value="提交">
       <input class="bio2 btnBg"  value="取消" onclick="move6()">
      </div>     
</form>	 
	 
	  <div style="padding-left:180px;display:none;" id="d_7">
	 <label class="title1">血气分析</label>
	 <input type="button"  value="添加" date-id="$!blood.id" class="btnBg" onclick="add7()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/bloodList?userId=${dirUser.id}'"><br>
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	   <label class="lab_1 ">PH </label><label class="lab_2 ">7.35~7.45</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile ph" value="$blood.ph"></label>
	 <label class="lab_1 ">氧分压（PO2） </label><label class="lab_2 ">（80~100）mmHg</label><label class="lab_3 "><input readonly="readonly"   class="input_compile po2" value="$blood.po2"></label>
	 <label class="lab_1 ">二氧化碳分压（PCO2）</label><label class="lab_2 ">（35~45）mmHg</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile pco2" value="$blood.pco2"></label>
	 <label class="lab_1 ">标准碳酸氢根   </label><label class="lab_2 ">(22.0~27.0) mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile standardBicarbonate" value="$blood.standardBicarbonate"></label>
	 <label class="lab_1 ">缓冲碱    </label><label class="lab_2 ">(45.0~55.0) mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile bufferBase" value="$blood.bufferBase"></label>
	 <label class="lab_1 ">剩余碱   </label><label class="lab_2 "> ±3 mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile residualAlkali" value="$blood.residualAlkali"></label>
	 <label class="lab_1 ">总血红蛋白  </label><label class="lab_2 "> (115~174) g/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile oxygenSaturation" value="$blood.oxygenSaturation"></label>
	 <label class="lab_1 ">氧饱和度    </label><label class="lab_2 ">（91.9~99）%</label><label class="lab_3 "><input readonly="readonly"   class="input_compile hydrogenIonConcentration" value="$blood.hydrogenIonConcentration"></label>
	  </div>
	 
<form action="$request.contextPath/director/hBloodGasAnalysis" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light7" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">PH:</div> <div class="bioch3"><input type="text" name="ph"/></div></div>
       <div class="bioch1"><div class="bioch2">氧分压（PO2）:</div> <div class="bioch3"><input type="text" name="po2" /></div></div>
       <div class="bioch1"><div class="bioch2">二氧化碳分压（PCO2）:</div> <div class="bioch3"><input type="text" name="pco2"/></div></div>
       <div class="bioch1"><div class="bioch2">标准碳酸氢根:</div> <div class="bioch3"><input type="text" name="standardBicarbonate"/></div></div>
       <div class="bioch1"><div class="bioch2">缓冲碱 :</div> <div class="bioch3"><input type="text" name="bufferBase"/></div></div>
       <div class="bioch1"><div class="bioch2">剩余碱:</div> <div class="bioch3"><input type="text" name="residualAlkali"/></div></div>
       <div class="bioch1"><div class="bioch2">总血红蛋白 :</div> <div class="bioch3"><input type="text" name="oxygenSaturation"/></div></div>
       <div class="bioch1"><div class="bioch2">氧饱和度:</div> <div class="bioch3"><input type="text" name="hydrogenIonConcentration"/></div></div>      
       <input class="bio1 btnBg sub_" style="margin-left: 230px;"  type="submit"  value="提交">
       <input class="bio2 btnBg"  value="取消" onclick="move7()">
      </div>     
</form>		 
	 
	 <div style="padding-left:180px;display:none;" id="d_8">
	 <label class="title1">激素</label>
	 <input type="button"  value="添加" date-id="$!hor.id" class="btnBg" onclick="add8()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/horList?userId=${dirUser.id}'"><br>
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	   <label class="lab_1 ">三碘甲状腺原氨酸（T3）</label><label class="lab_2 ">(0.89~2.44) nmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile t3" value="$hor.t3"></label>
	 <label class="lab_1 ">甲状腺素（T4） </label><label class="lab_2 ">(62.67~150.84) nmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile t4" value="$hor.t4"></label>
	 <label class="lab_1 ">游离三碘甲状腺原氨酸（FT3） </label><label class="lab_2 ">(2.62~6.49) pmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile ft3" value="$hor.ft3"></label>
	 <label class="lab_1 ">游离甲状腺（FT4）</label><label class="lab_2 ">(9.01~19.04) pmol/L</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile ft4" value="$hor.ft4"></label>
	 <label class="lab_1 ">促甲状腺素(TSH)</label><label class="lab_2 ">(0.35~4.94) μU/ml</label><label class="lab_3 "><input readonly="readonly"   class="input_compile tsh" value="$hor.tsh"></label>
	 <label class="lab_1 ">抗甲状腺球蛋白抗体（TGAb）</label><label class="lab_2 ">＜4.11U/ml</label><label class="lab_3 "><input readonly="readonly"   class="input_compile tgab" value="$hor.tgab"></label>
	 <label class="lab_1 ">抗甲状腺过氧化物酶抗体（TPOAb） </label><label class="lab_2 ">  ＜5.61 U/ml</label><label class="lab_3 "><input readonly="readonly"   class="input_compile tpoab" value="$hor.tpoab"></label>
	 <label class="lab_1 ">甲状旁腺激素（PTH）</label><label class="lab_2 ">  (15.0~68.3)pg/ml</label><label class="lab_3 "><input readonly="readonly"   class="input_compile pth" value="$hor.pth"></label>
	 <label class="lab_1 ">血清胰岛素 </label><label class="lab_2 ">(2.6~24.9) μU/ml </label><label class="lab_3 "><input readonly="readonly"   class="input_compile serumInsulin" value="$hor.serumInsulin"></label>
	 <label class="lab_1 ">降钙素  </label><label class="lab_2 ">（0.1~10）pg/ml</label><label class="lab_3 "><input readonly="readonly"   class="input_compile calciumReducingHormone" value="$hor.calciumReducingHormone"></label>
	  </div>
	
<form action="$request.contextPath/director/hHormone" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light8" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">三碘甲状腺原氨酸（T3）:</div> <div class="bioch3"><input type="text" name="t3"/></div></div>
       <div class="bioch1"><div class="bioch2">甲状腺素（T4）:</div> <div class="bioch3"><input type="text" name="t4" /></div></div>
       <div class="bioch1"><div class="bioch2">游离三碘甲状腺原氨酸（FT3）:</div> <div class="bioch3"><input type="text" name="ft3"/></div></div>
       <div class="bioch1"><div class="bioch2">游离甲状腺（FT4）:</div> <div class="bioch3"><input type="text" name="ft4"/></div></div>
       <div class="bioch1"><div class="bioch2">促甲状腺素(TSH) :</div> <div class="bioch3"><input type="text" name="tsh"/></div></div>
       <div class="bioch1"><div class="bioch2">抗甲状腺球蛋白抗体（TGAb）:</div> <div class="bioch3"><input type="text" name="tgab"/></div></div>
       <div class="bioch1"><div class="bioch2">抗甲状腺过氧化物酶抗体（TPOAb） :</div> <div class="bioch3"><input type="text" name="tpoab"/></div></div>
       <div class="bioch1"><div class="bioch2">甲状旁腺激素（PTH）:</div> <div class="bioch3"><input type="text" name="pth"/></div></div>
       <div class="bioch1"><div class="bioch2">血清胰岛素:</div> <div class="bioch3"><input type="text" name="serumInsulin"/></div></div>
       <div class="bioch1"><div class="bioch2">降钙素 :</div> <div class="bioch3"><input type="text" name="calciumReducingHormone"/></div></div>      
       <input class="bio1 btnBg sub_"  style="margin-left: 230px;" type="button" value="提交">
       <input class="bio2 btnBg"  value="取消" onclick="move8()">
      </div>     
</form>	
 
	 <div style="padding-left:180px;display:none;" id="d_9">
	 <label class="title1">血脂</label>
	 <input type="button"  value="添加" date-id="$!fat.id" class="btnBg" onclick="add9()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/fatList?userId=${dirUser.id}'"><br>
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	   <label class="lab_1 ">三酰甘油（甘油三酯）  </label><label class="lab_2 ">（0.56~1.70） mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile triglyceride" value="$fat.triglyceride"></label>
	 <label class="lab_1 ">游离脂肪酸  </label><label class="lab_2 ">（0.10~0.45）mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile cholesterol" value="$fat.cholesterol"></label>
	 <label class="lab_1 ">胆汁酸  </label><label class="lab_2 ">（1.0~10.0）μmol/L</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile freeFattyAcids" value="$fat.freeFattyAcids"></label>
	 <label class="lab_1 ">高密度脂蛋白（HDL）</label><label class="lab_2 ">（0.80~1.80）mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile bileAcid" value="$fat.bileAcid"></label>
	 <label class="lab_1 ">低密度脂蛋白（LDL）</label><label class="lab_2 ">（1.3~4.30） mmol/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile hdl" value="$fat.hdl"></label>
	 <label class="lab_1 ">酮体  </label><label class="lab_2 "> ＜294μmol/L（＜3mg/L）</label><label class="lab_3 "><input readonly="readonly"   class="input_compile ldl" value="$fat.ldl"></label>
	 <label class="lab_1 ">磷脂   </label><label class="lab_2 "> (1.68~3.23) mmol/L （130~250mg/dl）</label><label class="lab_3 "><input readonly="readonly"   class="input_compile ketone" value="$fat.ketone"></label>
	 <label class="lab_1 ">胆固醇   </label><label class="lab_2 ">（2.33~5.7） mmol/L  </label><label class="lab_3 "><input readonly="readonly"   class="input_compile phospholipid" value="$fat.phospholipid"></label> 
	  </div>
	  
<form action="$request.contextPath/director/hBloodFat" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light9" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">三酰甘油（甘油三酯）:</div> <div class="bioch3"><input type="text" name="triglyceride"/></div></div>
       <div class="bioch1"><div class="bioch2">游离脂肪酸:</div> <div class="bioch3"><input type="text" name="cholesterol" /></div></div>
       <div class="bioch1"><div class="bioch2">胆汁酸:</div> <div class="bioch3"><input type="text" name="freeFattyAcids"/></div></div>
       <div class="bioch1"><div class="bioch2">高密度脂蛋白（HDL）:</div> <div class="bioch3"><input type="text" name="bileAcid"/></div></div>
       <div class="bioch1"><div class="bioch2">低密度脂蛋白（LDL） :</div> <div class="bioch3"><input type="text" name="hdl"/></div></div>
       <div class="bioch1"><div class="bioch2">酮体:</div> <div class="bioch3"><input type="text" name="ldl"/></div></div>
       <div class="bioch1"><div class="bioch2">磷脂 :</div> <div class="bioch3"><input type="text" name="ketone"/></div></div>
       <div class="bioch1"><div class="bioch2">胆固醇:</div> <div class="bioch3"><input type="text" name="phospholipid"/></div></div>
       <input class="bio1 btnBg sub_"  style="margin-left: 230px;" type="button" value="提交">
       <input class="bio2 btnBg" value="取消" onclick="move9()">
      </div>     
</form>	
	  
	  <div style="padding-left:180px;display:none;" id="d_10">
	 <label class="title1">体液免疫</label>
	 <input type="button"  value="添加" date-id="$!hum.id" class="btnBg" onclick="add10()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/humList?userId=${dirUser.id}'"><br>
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	 <label class="lab_1 ">免疫球蛋白G（IgG）  </label><label class="lab_2 ">（751~1560）mg/dl</label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile g" value="$hum.g"></label>
	 <label class="lab_1 ">免疫球蛋白A（IgA） </label><label class="lab_2 ">（82~453）mg/dl</label><label class="lab_3 "><input readonly="readonly"   class="input_compile a" value="$hum.a"></label>
	 <label class="lab_1 ">免疫球蛋白M（IgM）</label><label class="lab_2 ">（46~304）mg/dl</label><label  class="lab_3 "><input readonly="readonly"   class="input_compile m" value="$hum.m"></label>
	 <label class="lab_1 ">免疫球蛋白D（IgD）  </label><label class="lab_2 "> (1~40)mg/L</label><label class="lab_3 "><input readonly="readonly"   class="input_compile d" value="$hum.d"></label>
	 <label class="lab_1 ">免疫球蛋白E（IgE） </label><label class="lab_2 ">  (0~100)U/ml </label><label class="lab_3 "><input readonly="readonly"   class="input_compile e" value="$hum.e"></label>
	  </div>
	  
<form action="$request.contextPath/director/hHumoralImmunity" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light10" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">免疫球蛋白G（IgG）:</div> <div class="bioch3"><input type="text" name="g"/></div></div>
       <div class="bioch1"><div class="bioch2">免疫球蛋白A（IgA）:</div> <div class="bioch3"><input type="text" name="a" /></div></div>
       <div class="bioch1"><div class="bioch2">免疫球蛋白M（IgM）:</div> <div class="bioch3"><input type="text" name="m"/></div></div>
       <div class="bioch1"><div class="bioch2">免疫球蛋白D（IgD）:</div> <div class="bioch3"><input type="text" name="d"/></div></div>
       <div class="bioch1"><div class="bioch2">免疫球蛋白E（IgE） :</div> <div class="bioch3"><input type="text" name="e"/></div></div>
       <input class="bio1 btnBg sub_"  style="margin-left: 230px;"   type="submit"  value="提交">
       <input class="bio2 btnBg"  value="取消" onclick="move10()">
      </div>     
</form>	
	  
	  <div style="padding-left:180px;display:none;" id="d_11">
	 <label class="title1">细胞免疫</label>
	 <input type="button"  value="添加" date-id="$!cell.id" class="btnBg" onclick="add11()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/cellList?userId=${dirUser.id}'"><br>
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	 <label class="lab_1 ">自然杀伤细胞（NK）<br><br>  </label><label class="lab_2 "> 数量：（17.5±2.34）% <br><p> 活性：实验cpm-自发cpm</p> </label><label class="lab_3 "><input readonly="readonly"   class="input_compile1 input_compile nk" value="$cell.nk"><br><br></label>
	 <label class="lab_1 ">淋巴激活素激活杀伤细胞（LAK）<br><br> </label><label class="lab_2 "> 最大cpm-自发cpm <br><p>   活性：实验cpm-自发cpm </p></label><label class="lab_3 "><input readonly="readonly"   class="input_compile lak" value="$cell.lak"><br><br></label>
	 <div><p style="margin-bottom: 300px;">T细胞亚群 </p><br></div>
	 <div>
	 <p style="float: left;margin-left: 336px;margin-top: -340px;">靶细胞参入cpm×100%</p>
	 <p style="float: left;margin-left: 336px;margin-top: -300px;"> CD3:60%～90%</p>
	 <p style="float: left;margin-left: 336px;margin-top: -260px;">CD4:32%～65%</p>
	 <p style="float: left;margin-left: 336px;margin-top: -220px;">CD8:16%～39%</p>
	 <p style="float: left;margin-left: 336px;margin-top: -180px;"> CD4/ CD8:（2～3）：1</p> 
	 </div>
	 <div style="float: left;margin-left: 672px;margin-top: -340px;"><input readonly="readonly"   class="input_compile TCellSubsets" value="$cell.TCellSubsets"></div>
	  </div>
	  
<form action="$request.contextPath/director/hCellularImmunity" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light11" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">自然杀伤细胞（NK）:</div> <div class="bioch3"><input type="text" name="nk"/></div></div>
       <div class="bioch1"><div class="bioch2">淋巴激活素激活杀伤细胞（LAK）:</div> <div class="bioch3"><input type="text" name="lak" /></div></div>
       <div class="bioch1"><div class="bioch2">T细胞亚群:</div> <div class="bioch3"><input type="text" name="TCellSubsets"/></div></div>
       <input class="bio1 btnBg sub_" style="margin-left: 230px;"   type="submit"  value="提交">
       <input class="bio2 btnBg"  value="取消" onclick="move11()">
      </div>     
</form>
	  
	 <div style="padding-left:180px;display:none;" id="d_12">
	 <label class="title1">肝炎病毒</label>
	 <input type="button"  value="添加" date-id="$!virus.id" class="btnBg" onclick="add12()"> 
	 <input type="button" value="测量记录" class="btnBg" onclick="javascripts:location.href='/director/virusList?userId=${dirUser.id}'"><br>
	 
	 <label class="lab_1 lab_" style="background: #f1f1f1;font-size: 18px;">生化指标</label><label class="lab_2 lab_"style="background: #f1f1f1;font-size: 18px;">正常范围</label><label class="lab_3 lab_" style="background: #f1f1f1;font-size: 18px;">实际指标</label>
	 <label class="lab_1 ">甲型肝炎</label><label class="lab_2 "></label><label class="lab_3 "></label>
	 <label class="lab_1 ">甲型肝炎病毒免疫球蛋白M抗体（抗HAV- IgM） </label><label class="lab_2 "> 阴性</label><label class="lab_3 "><input readonly="readonly"   class="input_compile havIgm" value="$virus.havIgm"></label>
	 
	 <label class="lab_1 ">乙型肝炎<br><br></label><label class="lab_2 "></label><label  class="lab_3 "></label>
	 <label class="lab_1 ">乙型肝炎病毒表面抗原（HBsAg） </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hbsag" value="$virus.hbsag"></label>
	 <label class="lab_1 ">乙型肝炎病毒表面抗体（HBsAb）</label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hbsab" value="$virus.hbsab"></label>
	 <label class="lab_1 ">乙型肝炎病毒核心抗体（HBcAb） </label><label class="lab_2 ">    阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hbcab" value="$virus.hbcab"></label>
	 <label class="lab_1 ">乙型肝炎病毒e抗原（HBeAg）</label><label class="lab_2 ">   阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hbeag" value="$virus.hbeag"></label>
	 <label class="lab_1 ">乙型肝炎病毒e抗体（HBeAb）   </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hbeab" value="$virus.hbeab"></label>
	 <label class="lab_1 ">乙型肝炎病毒脱氧核糖核酸定量（HBV-DNA） </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hbv" value="$virus.hbv"></label>
	 <label class="lab_1 ">乙型肝炎病毒脱氧核糖核酸聚合酶链反应（HBV-DNA聚合酶） </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hbvDna" value="$virus.hbvDna"></label>
	 
	 <label class="lab_1 ">丙型肝炎 </label><label class="lab_2 "></label><label class="lab_3 "></label>
	 <label class="lab_1 ">丙型肝炎病毒脱氧核糖核酸（HCV-RNA） </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hcvRna" value="$virus.hcvRna"></label>
	 <label class="lab_1 ">丙型肝炎病毒抗体（抗HCV）</label><label class="lab_2 ">   阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hcv" value="$virus.hcv"></label>
	 
	 <label class="lab_1 ">丁型肝炎</label><label class="lab_2 "></label><label class="lab_3 "></label>
	 <label class="lab_1 ">丁型肝炎病毒抗体（抗HDV）    </label><label class="lab_2 ">  阴性      </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hdv" value="$virus.hdv"></label>
	 <label class="lab_1 ">丁型肝炎病毒抗原（HDVAg）   </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hdvag" value="$virus.hdvag"></label>
	  <label class="lab_1 ">丁型肝炎病毒脱氧核糖核酸（HDV-RNA）    </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hdvRna" value="$virus.hdvRna"></label>
	
	
	 <label class="lab_1 ">戊型肝炎病毒抗体（抗HEV）  </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hev" value="$virus.hev"></label>
	 <label class="lab_1 ">戊型肝炎病毒脱氧核糖核(HEV-RNA)  </label><label class="lab_2 ">   阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile hevRna" value="$virus.hevRna"></label>
	 <label class="lab_1 ">梅毒血清学试验(RPR)</label><label class="lab_2 ">    阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile rpr" value="$virus.rpr"></label>
	 <label class="lab_1 ">梅毒螺旋体抗体明胶颗粒凝集试验(TPPA)     </label><label class="lab_2 ">  阴性     </label><label class="lab_3 "><input readonly="readonly"   class="input_compile tppa" value="$virus.tppa"></label>
	</div>
	
<form action="$request.contextPath/director/hHepatitisVirus" method="post"  name="myForm" onsubmit="return validateForm()">
	  <div id="light12" class="white_content">
	   <input type="hidden" name="userId" value="$dirUser.id" >
       <div class="bioch1"><div class="bioch2">甲型肝炎病毒免疫球蛋白M抗体（抗HAV- IgM）:</div> <div class="bioch3"><input type="text" name="havIgm" /></div></div>
       
       <div class="bioch1"><div class="bioch2">乙型肝炎病毒表面抗原（HBsAg）:</div> <div class="bioch3"><input type="text" name="hbsag"/></div></div>
       <div class="bioch1"><div class="bioch2">乙型肝炎病毒表面抗体（HBsAb）:</div> <div class="bioch3"><input type="text" name="hbsab"/></div></div>
       <div class="bioch1"><div class="bioch2">乙型肝炎病毒核心抗体（HBcAb）:</div> <div class="bioch3"><input type="text" name="hbcab"/></div></div>
       <div class="bioch1"><div class="bioch2">乙型肝炎病毒e抗原（HBeAg）:</div> <div class="bioch3"><input type="text" name="hbeag"/></div></div>
       <div class="bioch1"><div class="bioch2">乙型肝炎病毒e抗体（HBeAb）:</div> <div class="bioch3"><input type="text" name="hbeab"/></div></div>
       <div class="bioch1"><div class="bioch2">乙型肝炎病毒脱氧核糖核酸定量（HBV-DNA）:</div> <div class="bioch3"><input type="text" name="hbv"/></div></div>
       <div class="bioch1"><div class="bioch2">乙型肝炎病毒脱氧核糖核酸聚合酶链反应（HBV-DNA聚合酶）:</div> <div class="bioch3"><input type="text" name="hbvDna"/></div></div>
       
       <div class="bioch1"><div class="bioch2">丙型肝炎病毒脱氧核糖核酸（HCV-RNA）:</div> <div class="bioch3"><input type="text" name="hcvRna" /></div></div>
       <div class="bioch1"><div class="bioch2">丙型肝炎病毒抗体（抗HCV）:</div> <div class="bioch3"><input type="text" name="hcv"/></div></div>
       
       <div class="bioch1"><div class="bioch2">丁型肝炎病毒抗体（抗HDV）:</div> <div class="bioch3"><input type="text" name="hdv"/></div></div>
       <div class="bioch1"><div class="bioch2">丁型肝炎病毒抗原（HDVAg）:</div> <div class="bioch3"><input type="text" name="hdvag"/></div></div>
       <div class="bioch1"><div class="bioch2">丁型肝炎病毒脱氧核糖核酸（HDV-RNA） :</div> <div class="bioch3"><input type="text" name="hdvRna"/></div></div>
             
       <div class="bioch1">
	       <div class="bioch2">戊型肝炎病毒抗体（抗HEV）:</div> 
	       <div class="bioch3"><input type="text" name="hev"/></div>
       </div>
       <div class="bioch1"><div class="bioch2">戊型肝炎病毒脱氧核糖核(HEV-RNA):</div> <div class="bioch3"><input type="text" name="hevRna"/></div></div> 
       <div class="bioch1"><div class="bioch2">梅毒血清学试验(RPR):</div> <div class="bioch3"><input type="text" name="rpr"/></div></div>
       <div class="bioch1">
	       <div class="bioch2">梅毒螺旋体抗体明胶颗粒凝集试验(TPPA):</div> 
	       <div class="bioch3"><input type="text" name="tppa"/></div>
       </div>     
       <input class="bio1 btnBg sub_" style="margin-left: 230px;"  type="submit"  value="提交"> <input class="bio2 btnBg" value="取消" onclick="move12()">
			</div>     
</form>  
	  
	  
   	</div>
</div>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/biochemistry-edit.js"></script>
<script src="/assets/js/biochemistry-add.js"></script>
<script>

 $(document).ready(function(){
    var temp = "";

    $(".btnBg").click(function(){
      
      $(this).siblings("label").find("input[readonly='readonly']").each(function(i){
        temp = $(this).attr("value");
        $($(".white_content:visible input[type='text']").get(i)).attr("value", temp);
      })
    })
    
  })
$(function(){
    		$(".personInfo .personInfo_left .sidebar li a").eq(2).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
 	});
function sel_div(t){
 for(var i=0;i<t.length;i++){
  document.getElementById(t.options[i].value).style.display="none";
 }
 if(t.value!="请选择"){
  document.getElementById(t.value).style.display="block";
 }
}
$(function(){
	$(".sub_").click(function(){
		$(this).siblings(".bioch1").find("input").each(function(){
			if($(this).val()==""){
				$(this).val("0");
			}
		});
		
		 
	});
	 

});
	
</script>
</body>
</html>