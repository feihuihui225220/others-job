<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>服务推荐</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="searchli">
			<ul class="inpubox clearfix">
				<form action="/professional/recommand/query" method="post" name="searchForm">
				<li><label>姓名：    </label><input type="text" name="name" value="$!{condVo.name}" /> </li>
				<li><label>身份证：</label><input type="text" name="idCard" value="$!{condVo.idCard}" /> </li>
				<li>
					<label>服务类型：</label>
					<select name="catId">
                            <option value="-1" #if($item.id == $condVo.catId) selected #end>全部</option>
						#foreach($item in $catItems)
							<option value="${item.id}" #if($item.id == $condVo.catId) selected #end>${item.itemName}</option>
						#end
					</select>
				</li>
				<li><input class="ibtn button_btn" type="submit" value="搜索"></li>
				</form>
			</ul>
		</div>
        <div class="tablebox">
            <table class="table100 policy usertable cen">
                <tr>
					<th>姓名</th>
					<th>身份证号</th>
					<th>联系电话</th>
					<th>推荐数量</th>
				</tr>
				#foreach($recommand in $page.result)
                <tr class="hasnext">
					<td>${recommand.name}</td>
					<td>${recommand.idCard}</td>
					<td>${recommand.concatPhone}</td>
					<td>${recommand.services.size()}</td>
				</tr>
                <tr class="trhide hide">
					<td colspan="4">
						#foreach($service in $recommand.services)
                    	<p>${service.name}</p>
						#end
                	</td>
				</tr>
				#end
            </table>
            #parse("/common/page.tpl")
        </div>
    </div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
$(".policy tr.hasnext").toggle(function(){
        $(this).next('.trhide').show();
    },function(){
        $(this).next('.trhide').hide();
    });
});
</script>
</body>
</html>