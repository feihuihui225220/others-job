<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script>
	function serviceSet(userId, serviceId, status, start, end, orderId,stype){
	    if(status == 1){
		   var x = parent.document.getElementById('userFrame');
		   x.src = "/professional/service/user/set?userId=" + userId + "&serviceId=" + serviceId + "&start=" + start + "&end="+ end + "&orderId="+ orderId+"&stype="+stype;
	    }
	}
</script>
<style>
.distributionList{padding-left:80px;margin-top:20px;height:200px;overflow:auto;width:100%;}
.uradio{margin:0 10px;}
.distributionList{text-align: center;}
.usertableborder{border:1px solid #f00;}
.usertableborder td,.usertableborder th{border:1px solid #555;padding:5px 10px;}
</style>
</head>
<body>
<input type="hidden" id="adId">
<div class="wrapper">
	<br/><br/>
	<div class="distributionList1"></div>
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript">
$(function(){
   		var fush=0;
    	var userid = ${userId};
    	//alert(userid);
    	//var that = this;
    	$.ajax({
    		url:'/professional/vender/distr/users?userId='+userid,
    		type:'post',
    		success:function(data){
    			var json=eval("("+data+")");
    			var vender=json.venderDistrVOs;
    				var str = '';
    				str +='<table class="table100 usertable cen trclick tab_115">';
    				str +='<tr><th>序号</th><th>姓名</th><th>已分配人员数量</th><th>操作</th></tr>';
    				for(var i=0;i<vender.length;i++){
    					str +='<tr><td>'+(i+1)+'</td><td style="display:none;">'+vender[i].adminId+'</td><td>'+vender[i].adminName+'</td><td>'+vender[i].count+'</td><td><a href="/professional/vender/distr/user/commit?userId='+userid+'&adminId='+vender[i].adminId+'">分配 >></a></td></tr>';
    				}
    				str +='</table>';
    				$('.distributionList1').html(str);
    				 $("table tr td").each(function(){
						var id=$(this).text();
							if(id==json.adminIds){
								$(this).next().css("color","red");
								$(this).next().next().next().text("已分配>>");
								$(this).next().next().next().css("color","red");
							}
						//$(this).css("background-color","red");
					});
    		}
    	});
    	/*  $("table tr td").each(function(){
    		alert(0);
			var a=$(this).text();
			alert(a);
			//$(this).css("background-color","red");
		}); */
  //  });
 
});
</script>
</body>
</html>