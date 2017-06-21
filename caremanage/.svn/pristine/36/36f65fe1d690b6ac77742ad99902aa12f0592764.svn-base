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
		<th>甲型肝炎病毒免疫球蛋白M抗体（抗HAV- IgM）</th>
		
		<th>乙型肝炎病毒表面抗原（HBsAg）</th>
		<th>乙型肝炎病毒表面抗体（HBsAb） </th>
		<th>乙型肝炎病毒核心抗体（HBcAb）</th>
		<th>乙型肝炎病毒e抗原（HBeAg）</th>
		<th>乙型肝炎病毒e抗体（HBeAb）</th>
		
		<th>乙型肝炎病毒脱氧核糖核酸定量（HBV-DNA） </th>
		<th>乙型肝炎病毒脱氧核糖核酸聚合酶链反应（HBV-DNA聚合酶）</th>	
		
		<th>丙型肝炎病毒抗体（抗HCV）</th>
		<th>丙型肝炎病毒脱氧核糖核酸（抗HCV-Rna）</th>
		<th>丁型肝炎病毒抗体（抗HDV）</th>
		<th>丁型肝炎病毒抗原（HDVAg）</th>
		<th>丁型肝炎病毒脱氧核糖核酸（HDV-RNA）</th>
		
		<th>戊型肝炎病毒抗体（抗HEV）</th>
		<th>戊型肝炎病毒脱氧核糖核(HEV-RNA)</th>
		<th>梅毒血清学试验(RPR)</th>
		<th>梅毒螺旋体抗体明胶颗粒凝集试验(TPPA) </th>
		
	 </tr>
	 #foreach($li in $list)
		<tr class="userid_2020">
		<input type="hidden" class="id" value="$li.id">
		<td>$li.changeTime</td>		
		<td name="havIgm">$li.havIgm</td>
		
		<td name="hbsag">$li.hbsag  </td>
		<td name="hbsab">$li.hbsab</td>
		<td name="hbcab">$li.hbcab</td>
		<td name="hbeag">$li.hbeag</td>
		<td name="hbeab">$li.hbeab</td>		
		<td name="hbv">$li.hbv</td>
		<td name="hbvDna">$li.hbvDna</td>
		
		<td name="hcv">$li.hcv</td>
		<td name="hcvRna">$li.hcvRna</td>		
		<td name="hdv">$li.hdv</td>
		<td name="hdvag">$li.hdvag</td>
		<td name="hdvRna">$li.hdvRna</td>
		
		<td name="hev">$li.hev</td>
		<td name="hevRna">$li.hevRna</td>
		<td name="rpr">$li.rpr</td>
		<td name="tppa">$li.tppa</td>
		
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
                url: "/director/editVirus?userId="+userId+"&id="+id+'&'+param,   
               
                });  
              
        });      
      
        
    });    
});    

</script>
</html>
