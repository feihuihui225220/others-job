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
                url: "/director/hrtEdit?userId="+userId+"&id="+id+'&'+param,   
                  
                });  
              
        });      
      
        
    });    
});    
  