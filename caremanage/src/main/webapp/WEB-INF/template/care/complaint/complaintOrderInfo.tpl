<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>CallCenter事务办理_公共服务</title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/common.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
     #parse("/common/head.tpl")
    <div class="body bodyline pad10 trclick">
                                                                                                  
        <form method="post" #if($type==3) action="/care/order/userOrderListByIdcard"#else action="/care/complaint/listByCommunityId "#end name="searchForm">
        <input type="hidden" name="idcard" value="$!{idcard}"/>
            <table class="table100 usertable cen trclick pointer">
                <tr>
                    <th>订单编号</th>
                    <th>服务类型</th>
                    <th>服务分类</th>
                    <th>订单时间</th>
                    <th>服务商</th>
                </tr>
                #foreach ($result in $page.result)  
                <tr>
                    <td>${result.id}</td>
                    <td>关爱服务</td>
                    <td>${result.cServiceManager.name}</td>
                    <td>${result.createdAt}</td>
                    <td>${result.cVendor.name}</td>
                     <input type="hidden"  value="/care/complaint/goBackToAdd?orderId=${result.id}"/>
                </tr>
               #end
            </table>
            #parse("/common/page.tpl")
        </form>
        
    </div>
    <div class="footer"></div>
</p>

</div>
<div class="limitbox pad10 hide limitboxcomplain">
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
</body>
</html>