<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>转诊记录</title>
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
<div class="main1" >
<input type="hidden" class="userId" value="$dirUser.id">
  <div>
    <div class="personInfo_right fl" style="float: left;">
	      <div><a href="#" onClick="javascript :history.back(-1);" class="btnBg">返回</a></div>
	  <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="dayin">
	     <tr>
	    <th>日期</th>
		<th>PH</th>
		<th>氧分压（PO2）</th>
		<th>二氧化碳分压（PCO2）</th>
		<th>标准碳酸氢根</th>
		<th>缓冲碱</th>
		<th>剩余碱 </th>
		<th>总血红蛋白  </th>
		<th>氧饱和度</th>
		
	 </tr>
	 #foreach($li in $list)
		<tr class="userid_2020">
		<input type="hidden" class="id" value="$li.id">
		<td>$li.changeTime</td>
		<td name="ph">$li.ph</td>
		<td name="po2">$li.po2</td>
		<td name="pco2">$li.pco2  </td>
		<td name="standardBicarbonate">$li.standardBicarbonate</td>
		<td name="bufferBase">$li.bufferBase</td>
		<td name="residualAlkali">$li.residualAlkali</td>
		<td name="oxygenSaturation">$li.oxygenSaturation</td>
		<td name="hydrogenIonConcentration">$li.hydrogenIonConcentration</td>
		
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
                url: "/director/editBlood?userId="+userId+"&id="+id+'&'+param,   
                
                });  
              
        });      
      
        
    });    
});    

</script>
</html>
