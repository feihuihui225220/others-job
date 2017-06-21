<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="/assets/css/reg.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>

<style>
.limitbox .inpubox li label {width:100px; height: 100%;}
</style>
</head>
<body>
<div class="wrapper">
    <form method="post" action="/professional/addPlan" class="reg_area fix_pop" style="width:600px">
    <input type="hidden" name="userId" value="$!{userId}" >
    <input type="hidden" name="mVenderId" value="$!{serviceId}" >
    <input type="hidden" name="ordreId" value="$!{orderId}" >
    <input type="hidden" name="serviceTime" id="selectDate" value="" >
        <h2>添加计划</h2>   
            <div class="limitbox pad10">
                <ul class="inpubox clearfix">
                    <li><label>时间：</label><input type="text" name="serviceTime1" class="timedate" value="$!{result.serviceTime}"  onclick="_SetTime(this)" readOnly=true ></li>
                    <li><label>计划分类：</label>
                    <select name="parentCategoryId" id="parentCategoryId">
                         #foreach ($mPlanCategory in $mPlanCategory)
                            <option value="${mPlanCategory.id}">
                                ${mPlanCategory.name}  
                            </option>
                         #end
                        </select>
                    </li>
                    <li><label>计划内容：</label>
                    <select name="categoryId" id="categoryId">
                         #foreach ($sub in $sub)
                            <option value="${sub.id}">
                                ${sub.name}  
                            </option>
                         #end
                        </select>
                    </li>
                    <li><label>备注：</label><textarea cols="58" rows="5" name="remark" >$!{result.remark}</textarea></li>
                </ul>
            </div>
        <p class="opt">
	        <button  class="btn button_gm" onclick="javascript:history.back();return false;">取 消</button>
	        <button type="submit" class="btn  button_gm">添 加</button>
        </p>
    </form>
    <div class="footer">
        
    </div>
</div>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>

<script>
/*$(".timedate").calendar({ format:'HH:mm:ss' ,minDate:'2014-11-18',maxDate:'2014-11-18',onSetDate:function(){
        setTimeout(function(){
            var time = $(".timedate").val();
            $("#selectDate").val(time);
        },200)
    }
}
);*/

var str = "";
document.writeln("<div id=\"_contents\" style=\"padding:6px; background-color:#E3E3E3; font-size: 12px; border: 1px solid #777777; position:absolute; left:?px; top:?px; width:?px; height:?px; z-index:1; visibility:hidden\">");
str += "\u65f6<select id=\"_hour\">";
for (h = 0; h <= 9; h++) {
    str += "<option value=\"0" + h + "\">0" + h + "</option>";
}

for (h = 10; h <= 23; h++) {
    str += "<option value=\"" + h + "\">" + h + "</option>";
}

str += "</select> \u5206<select id=\"_minute\">";

for (m = 0; m <= 9; m++) {
    str += "<option value=\"0" + m + "\">0" + m + "</option>";
}

for (m = 10; m <= 59; m++) {
    str += "<option value=\"" + m + "\">" + m + "</option>";
}

str += "</select> \u79d2<select id=\"_second\">";
for (s = 0; s <= 9; s++) {
    str += "<option value=\"0" + s + "\">0" + s + "</option>";
}

for (s = 10; s <= 59; s++) {
    str += "<option value=\"" + s + "\">" + s + "</option>";
}

str += "</select> <input name=\"queding\" type=\"button\" onclick=\"_select()\" value=\"\u786e\u5b9a\" style=\"font-size:12px\" /></div>";

document.writeln(str);

var _fieldname;

function _SetTime(tt) {

    _fieldname = tt;

    var ttop = tt.offsetTop;    //TT控件的定位点高

    var thei = tt.clientHeight;    //TT控件本身的高

    var tleft = tt.offsetLeft;    //TT控件的定位点宽

    while (tt = tt.offsetParent) {

        ttop += tt.offsetTop;

        tleft += tt.offsetLeft;

    }

    document.getElementById("_contents").style.top = ttop + thei + 4 + 'px';

    document.getElementById("_contents").style.left = tleft + 'px';

    document.getElementById("_contents").style.visibility = "visible";

}

function _select() {

    _fieldname.value = document.getElementById("_hour").value + ":" + document.getElementById("_minute").value + ":" + document.getElementById("_second").value;

    var time = '${date} '+_fieldname.value;
            $("#selectDate").val(time);
    document.getElementById("_contents").style.visibility = "hidden";

}
$(".timedate").click();
$(function(){
    $("#parentCategoryId").on('change',function(){
        console.log($(this).find("option:checked").val());
        $.ajax({
            url:'/professional/getAPlanContent/'+$(this).find("option:checked").val(),
            type:'post',
            success:function(json){
            		var plan=eval("("+json+")");
                    var dj = json.data,str='';
                    for(var i=0;i<plan.mPlanVOList.length;i++){
                        str +='<option value="'+plan.mPlanVOList[i].id+'">'+plan.mPlanVOList[i].name+'</option>';
                    }
                    $("#categoryId").html(str);
            }
        })
    });
});
</script>
</body>
</html>