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
		<th>三酰甘油（甘油三酯）</th>
		<th>游离脂肪酸</th>
		<th>胆汁酸 </th>
		<th>高密度脂蛋白（HDL）</th>
		<th>低密度脂蛋白（LDL）</th>
		<th>酮体 </th>
		<th>磷脂 </th>
		<th>胆固醇</th>
		
	 </tr>
	 #foreach($li in $list)
		<tr class="userid_2020">
		<input type="hidden" class="id" value="$li.id">
		<td>$li.changeTime</td>
		<td name="triglyceride">$li.triglyceride</td>
		<td name="cholesterol">$li.cholesterol</td>
		<td name="freeFattyAcids">$li.freeFattyAcids  </td>
		<td name="bileAcid">$li.bileAcid</td>
		<td name="hdl">$li.hdl</td>
		<td name="ldl">$li.ldl</td>
		<td name="ketone">$li.ketone</td>
		<td name="phospholipid">$li.phospholipid</td>
		
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
                url: "/director/editFat?userId="+userId+"&id="+id+'&'+param,   
                
                });  
              
        });      
      
        
    });    
});    

</script>
</html>




<!--<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>用户管理</title>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css" />
<link href="/assets/director/styles/common.css" rel="stylesheet" type="text/css">
<link href="/assets/director/styles/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/assets/director/styles/table.css" type="text/css">
<link rel="stylesheet" href="/assets/js/jquery-1.7.2.js" type="text/css">
</head>
<body>
<div class="wrapper">
<input type="hidden" class="userId" value="$dirUser.id">
	 <div class="table-wrapper div_m" >
		  
	  <div style="float:left;margin-top:50px;" class="tablebox">
	  	  
	  <table class="table100 policy usertable cen pointer">
	  <tbody>
	  <tr>
	    <th>日期</th>
		<th>三酰甘油（甘油三酯）</th>
		<th>游离脂肪酸</th>
		<th>胆汁酸 </th>
		<th>高密度脂蛋白（HDL）</th>
		<th>低密度脂蛋白（LDL）</th>
		<th>酮体 </th>
		<th>磷脂 </th>
		<th>胆固醇</th>
		
	 </tr>
	 #foreach($li in $list)
		<tr class="userid_2020">
		<input type="hidden" class="id" value="$li.id">
		<td>$li.changeTime</td>
		<td name="triglyceride">$li.triglyceride</td>
		<td name="cholesterol">$li.cholesterol</td>
		<td name="freeFattyAcids">$li.freeFattyAcids  </td>
		<td name="bileAcid">$li.bileAcid</td>
		<td name="hdl">$li.hdl</td>
		<td name="ldl">$li.ldl</td>
		<td name="ketone">$li.ketone</td>
		<td name="phospholipid">$li.phospholipid</td>
		
		</tr>
		#end
	 </tbody>
	 </table>
	  
	  </div>  
</div>

 
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
                url: "/director/editFat?userId="+userId+"&id="+id+'&'+param,   
                success:function(msg){   
                        if(msg=="ok"){  
                        	console.log('修改成功');
                            //alert(msg);  
                        }   
                        else
                        {     
                        	//请求失败，将修改的值改为原来的值；
                        	td.text(olText);
                             alert(msg);            
                           
                        }   
                    }   
                });  
              
        });      
      
        
    });    
});    

</script>
</body>
</html>-->