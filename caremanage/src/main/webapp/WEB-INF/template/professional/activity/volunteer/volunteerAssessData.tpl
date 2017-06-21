<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="/assets/newCss/clndr.css">
    <link rel="stylesheet" type="text/css" href="/assets/newCss/zy_index.css">
    <script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
  
</head>
<body>
<div class="container">
    <div class="cal1"></div>
</div>
<button class="button_gm">下一页</button>
          
<script>
var duixiang={
		volunteerId:$!volunteerId,
		arr:[]
	}
$(window).on('load', function() {
    

    var arr= new Array();
		duixiang.arr=new Array();
			$('td').each(function(){
			var td=$(this);
			td.removeClass("event");
			$(this).find("div").attr("display","none");
			var date=$(this).find("div").html();
			#foreach($param in ${plans.keySet()})  
				 var d1=parseInt("$param");
				 if(d1==date){
					duixiang.arr.push(d1);
					td.attr("data-id",${plans.get($param)});
				   td.addClass("event");
				 } 
			#end    
			});
			$('.last-month').removeClass("event");
			$('.next-month').removeClass("event");
    
    $('.button_gm').click(function(){
       var xuanzhong= $('#xuanzhong').find("div").html();
       var planId= $('#xuanzhong').attr("data-id");
       if($('#xuanzhong').attr('data-id')!=undefined&&$('#xuanzhong').attr('data-id')>=0){
         $.ajax({ 
            url: "/nVolunteerAssess/toChecksum_?planId="+planId,
            type: "get",
            success: function (json) {
                if(json==-1){
                    alert("当前活动已经填写量表！");
                    return false;
                }else if(json==0){
                    alert("当天此站点没有活动！");
                    return false;
                }else{
                    location.href="/professional/volunteer/tonVolunteerAssess?palnId="+planId+"&volunteerId=$!volunteerId";     
                }
            }    
        });    
      
       }else{
         alert("您选择的日期没有活动！");
       }
    });
});
  
   
</script>
<script type="text/javascript" src="/assets/newJs/underscore.js"></script>
<script type="text/javascript" src="/assets/newJs/moment.min.js"></script>
<script type="text/javascript" src="/assets/newJs/zy_index.js"></script>
<script type="text/javascript" src="/assets/newJs/zhiyuanzhedata.js"></script>
<script type="text/javascript" src="/assets/newJs/clndr.min.js"></script>
<script type="text/javascript" src="/assets/newJs/underscore.js"></script>
<script type="text/javascript" src="/assets/js/zh-cn.js"></script>
</body>
</html>