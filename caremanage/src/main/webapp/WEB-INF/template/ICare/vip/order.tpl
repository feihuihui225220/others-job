<!DOCTYPE html>
<html>
  <head>
    <title>订单列表</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  </head>
  
  <body>
#parse("/common/dtop.tpl")
#parse("/ICare/ICleft.tpl")

<div>
    <table class="commonTable" style="width: 1000px;">
		<tr>
			<th>序号</th>
			<th>下单人</th>
			<th>联系方式</th>
			<th>开通周期</th>
			<th>开通日期</th>
			<th>剩余时间</th>
			<th>操作</th>
		</tr>
                #foreach ($order in $page.result)
                
                #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
                <tr>
                    <td>$i</td>
                    <td style="overflow:hidden;" nowrap title="$!{order.name}">$!{order.name}</td>
                    <td style="overflow:hidden;" nowrap title="$!{order.mobilePhone}"  >$!{order.mobilePhone}</td>
                    <td>$!{order.monthNum}个月</td>
                    <td>$!date.format('yyyy-MM-dd',$!order.openingDate)</td>
                    <td>$!{order.days}天</td>
                    <td>					
						<a href="get/$order.id">详 情</a>
						<a href="toAdd/$order.id">开通会员</a>
						<a href="remove/$order.id">删 除</a>
					</td>
              </tr>
              	#end
              	
            </table>
            #parse("/common/page.tpl")
            </div>
            <form action="/vipOrder/getList" name="searchForm"></form>
            <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
  </body>
</html>
