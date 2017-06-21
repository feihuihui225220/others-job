<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/reg.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>

</head>
<style type="text/css">
.reg_area{width:auto;margin:0;}
.mask_contact .inpubox li label{width:50px;}
</style>
<body>
<div class="wrapper">
   
        <h2>服务商评价报告</h2>
        <div class="mask_contact pad10">
            <h4>选择时间段：</h4>
            <ul class="inpubox clearfix">
            <form method="post" action="/care/evaluation/addOrUpdate" class="reg_area fix_pop" name="total_form">
                 <input type="hidden" name="vendorId" value="$!{vendorId}" >
                 <input type="hidden" name="serviceCount" value="$!{finishCount}" >
                 <input type="hidden" name="complaintCount" value="$!{commplaintCount}" >
                <li><label>开始：</label> <input class="text150 timedate" type="text" name="starDate" value="$!{star}"/></li>
                <li><label>结束：</label> <input class="text150 timedate" type="text" name="endDate" value="$!{end}"/></li>
                <li><button type="submit" class="btn button_btn mgt8" id="sbtn">查询</button></li>
            </ul>
        </div>
        <div class="mask_contact pad10">
            <h4>一、基本统计数据</h4>
            <div class="fix_car">
                <span>当前服务人数：$!{finishCount}人</span>
                <span>当前投诉次数：$!{commplaintCount}人</span>
                <b>注：当前服务人次表示该服务提供商所完成的订单量</b>
            </div>
        </div>
        <div class="mask_contact pad10">
            <h4>二、问题及建议</h4>
            <div class="fix_car">
                <textarea cols="72" rows="8" name="problem">#if($result.problem) $result.problem #end</textarea>
            </div>
        </div>
        <div class="mask_contact pad10">
            <h4>三、评价结论</h4>
            <div class="fix_car">
                星级：<select name="stars">
                <option value="5"  #if($details.stars==5) selected = "selected" #end>★★★★★</option>
                <option value="4"  #if($details.stars==4) selected = "selected" #end>★★★★</option>
                <option value="3"  #if($details.stars==3) selected = "selected" #end>★★★</option>
                <option value="2"  #if($details.stars==2) selected = "selected" #end>★★</option>
                <option value="1"  #if($details.stars==1) selected = "selected" #end>★</option>
               </select><br />
                <textarea cols="72" rows="8" placeholder="评论内容" name="conclusion">#if($result.conclusion) $result.conclusion #end</textarea>
            </div>
        </div>
        <p class="opt">
			<button type="button" class="btn button_btn" onclick="javascript:history.go(-1)">取 消</button>
			<button type="submit" class="btn  button_btn">添 加</button>
		</p>
    </form>
    <div class="footer">
        
    </div>
</div>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script>
$('.timedate').calendar({ format:'yyyy-MM-dd', zIndex:222222222});
$("#sbtn").click(function(){
                var b = $("input[name='starDate']").attr("value");
                var e = $("input[name='endDate']").attr("value");
                if(b == '' || e == ''){
                    alert("请选择时间范围!");
                    return false;
                }else if(b > e) {
                    alert("开始时间不能大于结束结束时间!");
                    return false;
                }
                $("form[name='total_form']").submit();
            });
</script>
</body>
</html>