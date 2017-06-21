<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>结论</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script>
			function commitAssessClu() {
				
				var type = document.getElementById("type").value;
				if(type == 0 || type == 2) {
					var lowerLimit = document.getElementById("lowerLimit").value;
					var upperLimit = document.getElementById("upperLimit").value;
					var standard = lowerLimit + '-' + upperLimit;
					if(!/^\d*-\d*$/.test(standard) || parseInt(lowerLimit) > parseInt(upperLimit)){
						alert("分级标准录入不正确!");
						return false;
					}
					document.getElementById("standard").value = standard;
				}
				document.getElementById("cluForm").submit();
			}
		</script>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <form method="post" id="cluForm" action="/professional/assess/clu/commit" class="reg_area fix_pop" style="width:580px">
        <h2>添加结论</h2>   
        <input type="hidden" name="page" value="${page.page}" />
		<input type="hidden" name="num" value="${page.num}" />
		<input type="hidden" name="assessId" value="${assessId}" />
		<input type="hidden" id="type" name="type" value="${type}" />
		<input type="hidden" name="id" value="$!{id}" />
        <div class="limitbox pad10">
            <ul class="inpubox clearfix">
                #if($type == 0 || $type == 2)
                   <li><label>分级标准：</label><input type="text" style="margin-right:0" id="lowerLimit" name="lowerLimit" value="$!{assessClu.lowerLimit}"/> —— <input type="text" style="margin-right:0" id="upperLimit" name="upperLimit" value="$!{assessClu.upperLimit}" /></li>
                   <input type="hidden" id="standard" name="standard" value="$!{assessClu.standard}" />
                #else 
                   <li><label style="position: relative;top:-60px;">分级标准：</label>&nbsp;<textarea cols="50" rows="5" id="standard" name="standard" >$!{assessClu.standard}</textarea></li>
                #end
                <li><label style="position: relative; #if($type == 0 || $type == 2) top:-103px; #else top:-60px; #end">分级名称：</label><textarea cols="50" rows="5" id="standard" name="content" >$!{assessClu.content}</textarea></li><br>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<lable>选择套餐：</lable><select name="comboId">
                        #foreach($n in $zCombo)
                        <option #if(${assessClu.comboId}==$n.comboId) selected=selected #end value=$n.comboId>$n.comboName</option>
                        #end
                    </select>   
                </li>
            </ul>
        </div>
        <p class="opt">
           <input type="button" class="btn button_delete" onClick="javascripts:history.go(-1)" value="取 消" />
           <button type="button" onClick="commitAssessClu()" class="btn button_add">添 加</button>
        </p>
    </form>
    <div class="footer">
        
    </div>
</div>

</body>
</html>