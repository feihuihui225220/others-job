<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>投诉管理</title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
	 #set ($sessionUser=$!{session.getAttribute("sessionUser")})
   #parse("/common/head.tpl")
    <div class="body bodyline pad10">
       
            <div class="usedetail clearfix fix_complain">
                <div class="usertitle mgb10 strong clearfix">新增投诉<div class="f_r fr_itbn">
                 #if($resultComplaint.status!=2)
                 #if($!{sessionUser.getCateEnum()}!="STREET")
                <button class="addulimit button_gm" onClick="submit()">保 存</button>
                 #end
                 #end
                <button class="addulimit button_delete" onclick="javascript:history.back();return false;">返 回</button></div></div>
                <table class="tb">
                    <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/><col class="col5"/><col class="col6"/>
                  
                    #if(!${result.rUser.id})
                    <tr>
                       <form method="post" action="/care/order/userOrderListByIdcard"  >
                        <td class="t_r">身份证号：</td>
                        <td colspan="5" class="t_l">
                        <input type="input" name="idcard"  value="$!{idcard}" /> <button class="button_gm" type="submit">查询</button></td>
                        </form>
                     
                    </tr>
                    #end
                     <form method="get" action="/care/complaint/addOrUpdate" id="form">
                      #set($user=$session.getAttribute("sessionUser"))
                      <input type="hidden" name="userId" value="$!{result.rUser.id}"/>
                      <input type="hidden" name="orderId" value="$!{result.id}"  />
                      <!--<input type="hidden" name="communityId" value="1"  />-->
                      #if(${resultComplaint.status})
                        <input type="hidden" name="id" value="$!{resultComplaint.id}"  />
                      #end
                      <input type="hidden" name="status" value="$!{resultComplaint.status}"  />
                    <tr>
                        <td class="t_r">姓名：</td>
                        <td>#if($result.rUser.name)${result.rUser.name}#end</td>
                        <td class="t_r">订单号：</td>
                        <td>#if($result.id)${result.id}#end</td>
                        <td class="t_r">订单时间：</td>
                        <td>$!date.format('yyyy-MM-dd HH:mm',$!{result.createdAt})</td>
                    </tr>
                    <tr>
                        <td class="t_r">服务类型：</td>
                        <td>关爱服务</td>
                        <td class="t_r">服务分类：</td>
                        <td>$!{result.cServiceManager.name}</td>
                        <td class="t_r">服务商：</td>
                        <td>$!{result.cVendor.name}</td>
                    </tr>
                    <tr>
                        <td class="t_r">投诉内容：</td>
                        <td><textarea class="w98" cols="44" rows="4" name="content"   #if($resultComplaint.status)readonly="readonly" disabled="disabled"#end>$!{resultComplaint.content}</textarea></td>
                        <td class="t_r">处理建议：</td>
                        <td><textarea class="w98" cols="44" rows="4" name="conclusion" #if($resultComplaint.status!=0 || $user.cateEnum.type!=3)readonly="readonly" disabled="disabled"#end>$!{resultComplaint.conclusion}</textarea></td>
                        <td class="t_r">回访记录：</td>
                        <td><textarea class="w98" cols="44" rows="4" name="callback"   #if($!{sessionUser.getCateEnum()}=="STREET")readonly="readonly" disabled="disabled"#elseif($resultComplaint.status!=1 || $user.cateEnum.type==3)readonly="readonly" disabled="disabled"#end>$!{resultComplaint.callback}</textarea></td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
    <div class="footer"></div>
</p>

</div>

</body>
<script >
 function submit(){
 document.getElementById('form').submit();
} 
</script >
</html>
