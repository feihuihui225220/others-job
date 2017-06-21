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
<div class="main1" >
<input type="hidden" class="userId" value="$dirUser.id">
  <div>
    <div class="personInfo_right fl" style="float: left;">
	      <div><a href="#" onClick="javascript :history.back(-1);" class="btnBg">返回</a></div>
	  <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="dayin">
	    <tr>
	    <th>日期</th>
		<th>活化部分凝血酶原时间（APTT）</th>
		<th>凝血酶原时间（PT）</th>
		<th>凝血酶时间（TT） </th>
		<th>纤维蛋白原（Fg）</th>
		<th>纤维蛋白原降解产物（FDPs）</th>
		<th>D二聚体</th>
		
	 </tr>
	 #foreach($li in $list)
		<tr class="userid_2020">
		<input type="hidden" class="id" value="$li.id">
		<td>$li.changeTime</td>
		<td name="aptt">$li.aptt</td>
		<td name="pt">$li.pt</td>
		<td name="tt">$li.tt  </td>
		<td name="fg">$li.fg</td>
		<td name="fdps">$li.fdps</td>
		<td name="dimer">$li.dimer</td>
	
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
                url: "/director/editDic?userId="+userId+"&id="+id+'&'+param,   
                
                });  
              
        });      
      
        
    });    
});    

</script>
</html>
