<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>生化指标</title>
    <link rel="stylesheet" type="text/css" href="/assets/director/style/xunzhenrecord.css">
	<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
	<style type="text/css">
		.personInfo_right{width: 100% !important; margin: 0px !important;}
		.main1{ margin: 0 !important;}
	</style>
</head>

<body>

#parse("/common/dtop.tpl")
<div class="main1">
<input type="hidden" class="userId" value="$dirUser.id">
  <div>
    <div class="personInfo_right fl" style="float: left;">
	      <div><a href="#" onClick="javascript :history.back(-1);" class="btnBg">返回</a></div>
	  <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="dayin">
	    <tr>
	    <th>日期</th>
		<th>前白蛋白</th>
		<th>总蛋白</th>
		<th>白蛋白</th>
		<th>白蛋白/球蛋白比值（A/G）</th>
		<th>丙氨酸氨基转移酶或谷丙转氨酶（ALT或GPT）</th>
		<th>天冬氨酶氨基转移酶或谷草转氨酶(AST或GOT) </th>
		<th>碱性磷酸酶（AKP）</th>
		<th>γ谷氨酰转肽酶（γ-GT）</th>
		<th>血淀粉酶</th>
		<th>总胆红素</th>
		<th>直接胆红素</th>
	 </tr>
	 #foreach($li in $list)
		<tr class="userid_2020">
		<input type="hidden" class="id" value="$li.id">
		<td>$li.changeTime</td>
		<td name="preAlbumin">$li.preAlbumin</td>
		<td name="totalProtein">$li.totalProtein</td>
		<td name="albumin">$li.albumin  </td>
		<td name="albuminRatio">$li.albuminRatio</td>
		<td name="atl">$li.atl</td>
		<td name="ast">$li.ast</td>
		<td name="akp">$li.akp</td>
		<td name="gt">$li.gt</td>
		<td name="serumAmylase">$li.serumAmylase</td>
		<td name="totalBilirubin">$li.totalBilirubin</td>
		<td name="directBilirubin">$li.directBilirubin</td>
		</tr>
		#end
	 </table>
	      
		      <div class="page fr">
		       	#parse("/common/page.tpl")
		      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script>
$(function(){       
    var tds=$("td");     
    tds.click(function(){  
        var td=$(this),tr=td.parents('tr');     
        var oldText=td.text();      
        var input=$("<input type='text' value='"+oldText+"'/>");  
        var olText=td.text();
        td.html(input);    
        input.click(function(){    
            return false;    
        });    
                     
        input.trigger("focus").trigger("select");       
        input.blur(function(){  
        	td.text($(this).val());
        	var userId=$('.userId').val();
        	var id=tr.find('.id').val();
        	console.log(id);
        	var param=[].join.call(tr.find('td[name]').map(function(){
            	return $(this).attr('name')+'='+$.trim($(this).text());
        	}),'&');
            $.ajax({   
                type:"post",  
                url: "/director/editHliver?userId="+userId+"&id="+id+'&'+param,   
                
                });  
              
        });      
      
        
    });    
});    

</script>
</html>
